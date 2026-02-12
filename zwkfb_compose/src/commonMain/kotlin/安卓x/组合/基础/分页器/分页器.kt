package 安卓x.组合.基础.分页器

import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.snapFlingBehavior
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 水平滚动的分页器。页面会根据可视区域大小懒加载放置。默认所有页面尺寸相同，由 [页面大小] 指定；通过 [抛掷行为] 提供吸附动画，
 * 将页面滚动到特定位置。可用 [超出视图页面数] 在可视页面前后额外加载更多页面。
 *
 * 如需对不同尺寸的页面实现吸附效果，可使用带有适配 LazyList 的 [SnapLayoutInfoProvider] 的 [snapFlingBehavior]。
 *
 * @param 状态 控制此分页器的状态。
 * @param 修饰符 应用于该 Pager 外层布局的修饰符实例。
 * @param 内容内边距 整个内容四周的内边距。该参数会在内容被裁剪后添加内边距，这是通过 [修饰符] 参数无法实现的。你可以使用它
 * 在第一页之前或最后一页之后添加内边距。使用 [页面间距] 可在页面之间添加间距。
 * @param 页面大小 使用此参数可改变页面在分页器中的外观。
 * @param 超出视图页面数 在可视页面前后额外组合与布局的页面数量。注意：若 [超出视图页面数] 设置过大，会导致大量页面被组合、测量和放置，
 * 从而失去懒加载的意义。该值应作为优化手段，仅用于预加载可视区前后少数几页，不包括滚动事件期间预取器在滚动方向上自动组合与布局的页面。
 * @param 页面间距 此分页器中页面之间的间隔距离。
 * @param 垂直对齐 页面在此分页器中的垂直对齐方式。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用，仍可通过 [PagerState.scroll] 以编程方式滚动。
 * @param 反向布局 反转滚动和布局的方向。
 * @param 键 代表该项的稳定且唯一键值。指定键值后，滚动位置将基于该键保持：若在当前可见项前添加/删除项，拥有该键的项仍会被保留为首个可见项。
 * 若传入 null，则列表位置即为键值。
 * @param 页面嵌套滚动连接 一个 [NestedScrollConnection]，用于指定此 [Pager] 与嵌套列表的交互行为。默认行为为 [Pager] 消费所有嵌套滚动增量。
 * @param 捕捉位置 此分页器对页面执行吸附的计算方式。通过它可为布局中不同位置提供不同的停靠效果。[Pager] 用它来计算 [PagerState.currentPage]，
 * 即最接近吸附位置的页面（例如吸附位置在布局起始，则 currentPage 为最接近该位置的页面）。
 * @param 过度滚动效果 用于为此分页器渲染过度滚动效果的 [OverscrollEffect]。注意：[OverscrollEffect.node] 会在内部自动应用，
 * 无需额外使用 Modifier.overscroll。
 * @param 页面内容 此分页器的页面组合项。
 * @see androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider 用于实现基于
 * [androidx.compose.foundation.lazy.LazyListState] 的 [SnapLayoutInfoProvider]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 水平分页器(
    状态: PagerState,
    修饰符: Modifier = Modifier,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    页面大小: PageSize = PageSize.Fill,
    超出视图页面数: Int = PagerDefaults.BeyondViewportPageCount,
    页面间距: Dp = 0.dp,
    垂直对齐: Alignment.Vertical = Alignment.CenterVertically,
    抛掷行为: TargetedFlingBehavior = PagerDefaults.flingBehavior(state = 状态),
    用户滚动启用: Boolean = true,
    反向布局: Boolean = false,
    键: ((index: Int) -> Any)? = null,
    页面嵌套滚动连接: NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(状态, Orientation.Horizontal),
    捕捉位置: SnapPosition = SnapPosition.Start,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    页面内容: @Composable PagerScope.(page: Int) -> Unit,
) {
    HorizontalPager(
        state = 状态,
        modifier = 修饰符,
        contentPadding = 内容内边距,
        pageSize = 页面大小,
        beyondViewportPageCount = 超出视图页面数,
        pageSpacing = 页面间距,
        verticalAlignment = 垂直对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动启用,
        reverseLayout = 反向布局,
        key = 键,
        pageNestedScrollConnection = 页面嵌套滚动连接,
        snapPosition = 捕捉位置,
        overscrollEffect = 过度滚动效果,
        pageContent = 页面内容,
    )
}

/**
 * 垂直滚动的分页器。页面会根据可视区域大小懒加载放置。默认所有页面尺寸相同，由 [页面大小] 指定；通过 [抛掷行为]
 * 提供吸附动画，将页面滚动到特定位置。可用 [超出视图页面数] 在可视页面前后额外加载更多页面。
 *
 * 如需对不同尺寸的页面实现吸附效果，可使用带有适配 LazyList 的 [SnapLayoutInfoProvider] 的 [snapFlingBehavior]。
 *
 * @param 状态 控制此分页器的状态。
 * @param 修饰符 应用于该 Pager 外层布局的修饰符实例。
 * @param 内容内边距 整个内容四周的内边距。该参数会在内容被裁剪后添加内边距，这是通过 [修饰符] 参数无法实现的。你可以使用它
 * 在第一页之前或最后一页之后添加内边距。使用 [页面间距] 可在页面之间添加间距。
 * @param 页面大小 使用此参数可改变页面在分页器中的外观。
 * @param 超出视图页面数 在可视页面前后额外组合与布局的页面数量。注意：若 [超出视图页面数] 设置过大，会导致大量页面被组合、测量和放置，
 * 从而失去懒加载的意义。该值应作为优化手段，仅用于预加载可视区前后少数几页，不包括滚动事件期间预取器在滚动方向上自动组合与布局的页面。
 * @param 页面间距 此分页器中页面之间的间隔距离。
 * @param 水平对齐 页面在此分页器中的水平对齐方式。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用，仍可通过 [PagerState.scroll] 以编程方式滚动。
 * @param 反向布局 反转滚动和布局的方向。
 * @param 键 代表该项的稳定且唯一键值。指定键值后，滚动位置将基于该键保持：若在当前可见项前添加/删除项，拥有该键的项仍会被保留为首个可见项。若传入 null，则列表位置即为键值。
 * @param 页面嵌套滚动连接 一个 [NestedScrollConnection]，用于指定此 [Pager] 与嵌套列表的交互行为。默认行为为 [Pager] 消费所有嵌套滚动增量。
 * @param 捕捉位置 此分页器对页面执行吸附的计算方式。通过它可为布局中不同位置提供不同的停靠效果。[Pager] 用它来计算 [PagerState.currentPage]，
 * 即最接近吸附位置的页面（例如吸附位置在布局起始，则 currentPage 为最接近该位置的页面）。
 * @param 过度滚动效果 用于为此分页器渲染过度滚动效果的 [OverscrollEffect]。注意：[OverscrollEffect.node] 会在内部自动应用，
 * 无需额外使用 Modifier.overscroll。
 * @param 页面内容 此分页器的页面组合项。
 * @see androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider 用于实现基于
 * [androidx.compose.foundation.lazy.LazyListState] 的 [SnapLayoutInfoProvider]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 垂直分页器(
    状态: PagerState,
    修饰符: Modifier = Modifier,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    页面大小: PageSize = PageSize.Fill,
    超出视图页面数: Int = PagerDefaults.BeyondViewportPageCount,
    页面间距: Dp = 0.dp,
    水平对齐: Alignment.Horizontal = Alignment.CenterHorizontally,
    抛掷行为: TargetedFlingBehavior = PagerDefaults.flingBehavior(state = 状态),
    用户滚动启用: Boolean = true,
    反向布局: Boolean = false,
    键: ((index: Int) -> Any)? = null,
    页面嵌套滚动连接: NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(状态, Orientation.Vertical),
    捕捉位置: SnapPosition = SnapPosition.Start,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    页面内容: @Composable PagerScope.(page: Int) -> Unit,
) {
    VerticalPager(
        state = 状态,
        modifier = 修饰符,
        contentPadding = 内容内边距,
        pageSize = 页面大小,
        beyondViewportPageCount = 超出视图页面数,
        pageSpacing = 页面间距,
        horizontalAlignment = 水平对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动启用,
        reverseLayout = 反向布局,
        key = 键,
        pageNestedScrollConnection = 页面嵌套滚动连接,
        snapPosition = 捕捉位置,
        overscrollEffect = 过度滚动效果,
        pageContent = 页面内容,
    )
}



/** 包含 [Pager] 使用的默认值。 */
object 分页器默认值 { // PagerDefaults

    /**
     * 一个 [snapFlingBehavior]，可将页面吸附到布局起始位置。可通过给定参数控制吸附动画效果。
     *
     * @param 状态 控制应用此 FlingBehavior 的 [PagerState]。
     * @param 分页器抓取距离 控制此 [Pager] 吸附目标的方式。默认行为是：若滑动速度足够，则滑向滑动方向的下一页；否则回弹。
     * 使用 [PagerSnapDistance.atMost] 可限制滑动结束后最多继续滑动的页数。
     * @param 衰减动画规格 用于接近目标偏移量的动画规范。当滑动速度足够大（足以自然衰减）时生效。对于单页吸附，这种情况通常不会发生，
     * 因为没有足够空间运行衰减动画。
     * @param 捕捉动画规格 最终吸附到位置所用的动画规范。常用于两种情况：1) 有足够空间运行接近动画，分页器将在最后一步使用 [捕捉动画规格]
     * 将页面固定到位；2) 没有足够的空间运行接近动画。
     * @param 快照位置阈值 当滑动速度较低（如慢速滚动）时，此吸附阈值用于判断分页器应回弹还是前进。取值 0–1，表示需滚动页面尺寸的百分比；
     * 超过该值即跳至下一页，否则回弹。例如设为 0.35，则慢速滚动超过 35% 时翻页，否则回弹。注意：速度足够高的滑动将**始终**朝滑动方向翻页。
     * @return 默认将页面吸附到下一页的 [FlingBehavior] 实例。动画由滑动后速度决定：速度不足时，分页器使用 [捕捉动画规格] 到达吸附位置；
     * 速度足够高时，按 [衰减动画规格] 与 [捕捉动画规格] 的逻辑执行。
     * @see androidx.compose.foundation.gestures.snapping.snapFlingBehavior 了解更多关于各个参数如何控制整体吸附动画的信息。
     *
     * fling 行为使用的动画规范取决于两个因素：1) 手势速度；2) [分页器抓取距离] 提议的目标页。
     *
     * 若使用单页吸附（Pager 最常见场景），通常空间不足，无法运行衰减动画接近目标页，因此 Pager 始终使用 [捕捉动画规格] 的吸附动画。
     * 若使用多页吸附（即 abs(targetPage - currentPage) > 1），是否使用 [衰减动画规格] 或 [捕捉动画规格] 取决于触发手势的速度：
     * 速度足够高：先使用 [衰减动画规格] 接近目标页，再用 [捕捉动画规格] 完成最后一步；速度不足：类似地连续使用 [捕捉动画规格]。
     */
    @Composable
    fun 抛掷行为(
        状态: PagerState,
        分页器抓取距离: PagerSnapDistance = PagerSnapDistance.atMost(1),
        衰减动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        捕捉动画规格: AnimationSpec<Float> =
            spring(
                stiffness = Spring.StiffnessMediumLow,
                visibilityThreshold = Int.VisibilityThreshold.toFloat(),
            ),
        @FloatRange(from = 0.0, to = 1.0) 快照位置阈值: Float = 0.5f,
    ): TargetedFlingBehavior =
        PagerDefaults.flingBehavior(
            state = 状态,
            pagerSnapDistance = 分页器抓取距离,
            decayAnimationSpec = 衰减动画规格,
            snapAnimationSpec = 捕捉动画规格,
            snapPositionalThreshold = 快照位置阈值,
        )

    /**
     * Pager 默认的 页面嵌套滚动连接 实现。
     *
     * @param 状态 分页器的状态。
     * @param 方向 分页器的方向，用于确定嵌套滚动连接将操作和响应的方向。
     */
    @Composable
    fun 页面嵌套滚动连接(
        状态: PagerState,
        方向: Orientation,
    ): NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(
            state = 状态,
            orientation = 方向,
        )

    /**
     * beyondViewportPageCount 的默认值，用于指定在可视页面前后需要组合与布局的页面数量。该值不包括滚动事件期间预取器在滚动方向上自动组合与布局的页面。
     */
    const val 超出视图页面数 = PagerDefaults.BeyondViewportPageCount
}

//==================================================================

/**
 * 一个 [snapFlingBehavior]，可将页面吸附到布局起始位置。可通过给定参数控制吸附动画效果。
 *
 * @param 状态 控制应用此 FlingBehavior 的 [PagerState]。
 * @param 分页器抓取距离 控制此 [Pager] 吸附目标的方式。默认行为是：若滑动速度足够，则滑向滑动方向的下一页；否则回弹。
 * 使用 [PagerSnapDistance.atMost] 可限制滑动结束后最多继续滑动的页数。
 * @param 衰减动画规格 用于接近目标偏移量的动画规范。当滑动速度足够大（足以自然衰减）时生效。对于单页吸附，这种情况通常不会发生，
 * 因为没有足够空间运行衰减动画。
 * @param 捕捉动画规格 最终吸附到位置所用的动画规范。常用于两种情况：1) 有足够空间运行接近动画，分页器将在最后一步使用 [捕捉动画规格]
 * 将页面固定到位；2) 没有足够的空间运行接近动画。
 * @param 快照位置阈值 当滑动速度较低（如慢速滚动）时，此吸附阈值用于判断分页器应回弹还是前进。取值 0–1，表示需滚动页面尺寸的百分比；
 * 超过该值即跳至下一页，否则回弹。例如设为 0.35，则慢速滚动超过 35% 时翻页，否则回弹。注意：速度足够高的滑动将**始终**朝滑动方向翻页。
 * @return 默认将页面吸附到下一页的 [FlingBehavior] 实例。动画由滑动后速度决定：速度不足时，分页器使用 [捕捉动画规格] 到达吸附位置；
 * 速度足够高时，按 [衰减动画规格] 与 [捕捉动画规格] 的逻辑执行。
 * @see androidx.compose.foundation.gestures.snapping.snapFlingBehavior 了解更多关于各个参数如何控制整体吸附动画的信息。
 *
 * fling 行为使用的动画规范取决于两个因素：1) 手势速度；2) [分页器抓取距离] 提议的目标页。
 *
 * 若使用单页吸附（Pager 最常见场景），通常空间不足，无法运行衰减动画接近目标页，因此 Pager 始终使用 [捕捉动画规格] 的吸附动画。
 * 若使用多页吸附（即 abs(targetPage - currentPage) > 1），是否使用 [衰减动画规格] 或 [捕捉动画规格] 取决于触发手势的速度：
 * 速度足够高：先使用 [衰减动画规格] 接近目标页，再用 [捕捉动画规格] 完成最后一步；速度不足：类似地连续使用 [捕捉动画规格]。
 */
@Composable
fun PagerDefaults.抛掷行为(
    状态: PagerState,
    分页器抓取距离: PagerSnapDistance = PagerSnapDistance.atMost(1),
    衰减动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    捕捉动画规格: AnimationSpec<Float> =
        spring(
            stiffness = Spring.StiffnessMediumLow,
            visibilityThreshold = Int.VisibilityThreshold.toFloat(),
        ),
    @FloatRange(from = 0.0, to = 1.0) 快照位置阈值: Float = 0.5f,
): TargetedFlingBehavior =
    this.flingBehavior(
        state = 状态,
        pagerSnapDistance = 分页器抓取距离,
        decayAnimationSpec = 衰减动画规格,
        snapAnimationSpec = 捕捉动画规格,
        snapPositionalThreshold = 快照位置阈值,
    )

/**
 * Pager 默认的 页面嵌套滚动连接 实现。
 *
 * @param 状态 分页器的状态。
 * @param 方向 分页器的方向，用于确定嵌套滚动连接将操作和响应的方向。
 */
@Composable
fun PagerDefaults.页面嵌套滚动连接(
    状态: PagerState,
    方向: Orientation,
): NestedScrollConnection =
    this.pageNestedScrollConnection(
        state = 状态,
        orientation = 方向,
    )

/**
 * beyondViewportPageCount 的默认值，用于指定在可视页面前后需要组合与布局的页面数量。该值不包括滚动事件期间预取器在滚动方向上自动组合与布局的页面。
 */
val PagerDefaults.超出视图页面数
    get() = this.BeyondViewportPageCount


