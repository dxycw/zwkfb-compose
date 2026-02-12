package 安卓x.组合.材质3.下拉刷新

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

// TODO: 当可用的链接到 Material Design 规范时。
/**
 * 下拉刷新框 是一个容器，要求内部是可滚动的布局。当用户在内容顶部向下滑动时，它会添加手势支持以手动触发刷新。
 * 默认情况下，它使用 下拉刷新默认值.Indicator 作为刷新指示器，但你也可以自定义指示器，或使用 下拉刷新默认值.LoadingIndicator。
 *
 * @param 是否刷新中 是否正在刷新中
 * @param 刷新回调 当用户手势越过阈值，从而触发刷新请求时调用的回调。
 * @param 修饰符 应用于该容器的 Modifier。
 * @param 状态 用于跟踪下拉距离的状态。
 * @param 内容对齐 盒子 内部的默认对齐方式。
 * @param 指示器 当用户开始下拉或正在刷新时，将绘制在内容顶部的指示器。
 * @param 内容 下拉刷新容器的内容，通常是可滚动的布局，例如 LazyColumn 或使用 Modifier.verticalScroll 的布局。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 下拉刷新框(
    是否刷新中: Boolean,
    刷新回调: () -> Unit,
    修饰符: Modifier = Modifier,
    状态: PullToRefreshState = 记住下拉刷新状态(),
    内容对齐: Alignment = Alignment.TopStart,
    指示器: @Composable BoxScope.() -> Unit = {
        PullToRefreshDefaults.Indicator(
            modifier = Modifier.align(Alignment.TopCenter),
            isRefreshing = 是否刷新中,
            state = 状态,
        )
    },
    内容: @Composable BoxScope.() -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = 是否刷新中,
        onRefresh = 刷新回调,
        modifier = 修饰符,
        state = 状态,
        contentAlignment = 内容对齐,
        indicator = 指示器,
        content = 内容,
    )
}

/**
 * 为容器添加嵌套滚动支持的修饰符，用于实现下拉刷新手势。当用户下拉距离超过 [阈值] 并释放手势时，将调用 [刷新回调]。
 * 下拉刷新框 会自动应用此修饰符。
 *
 * @param 是否刷新中 表示是否正在刷新。如果没有正在进行的手势，当 是否刷新中 为 false 时，`state.distanceFraction` 将动画过渡到 0f；否则将动画过渡到 1f。
 * @param 状态 用于跟踪下拉距离的状态。
 * @param 已启用 嵌套滚动事件是否应由该修饰符消费。
 * @param 阈值 在触发 [刷新回调] 之前，最多可以向下滚动的距离。
 * @param 刷新回调 当下拉距离超过 [阈值] 时触发的回调。
 */
fun Modifier.下拉刷新(
    是否刷新中: Boolean,
    状态: PullToRefreshState,
    已启用: Boolean = true,
    阈值: Dp = PullToRefreshDefaults.PositionalThreshold,
    刷新回调: () -> Unit,
): Modifier =
    this.pullToRefresh(
        isRefreshing = 是否刷新中,
        state = 状态,
        enabled = 已启用,
        threshold = 阈值,
        onRefresh = 刷新回调,
    )



/** 包含 [下拉刷新框] 的默认值。 */
object 下拉刷新默认值 { // PullToRefreshDefaults
    /** [指示器]的默认形状 */
    @Deprecated("Use indicatorShape instead", ReplaceWith("indicatorShape"))
    @ExperimentalMaterial3Api
    val 形状: Shape = PullToRefreshDefaults.shape

    /** [指示器]的默认形状 */
    val 指示器形状: Shape = PullToRefreshDefaults.indicatorShape

    /** [指示器]的默认容器颜色 */
    @Deprecated("Use indicatorContainerColor instead", ReplaceWith("indicatorContainerColor"))
    @ExperimentalMaterial3Api
    val 容器颜色: Color
        @Composable get() = PullToRefreshDefaults.containerColor

    /** [指示器]的默认容器颜色 */
    val 指示器容器颜色: Color
        @Composable get() = PullToRefreshDefaults.indicatorContainerColor

    /**
     * 下拉刷新时出现的加载指示器的默认容器颜色。
     */
    @ExperimentalMaterial3ExpressiveApi
    val 加载指示器容器颜色: Color
        @Composable get() = PullToRefreshDefaults.loadingIndicatorContainerColor

    /** [指示器] 的默认指示器颜色 */
    val 指示器颜色: Color
        @Composable get() = PullToRefreshDefaults.indicatorColor

    /**
     * 下拉刷新时出现的加载指示器的默认活动指示器颜色。
     */
    @ExperimentalMaterial3ExpressiveApi
    val 加载指示器颜色: Color
        @Composable get() = PullToRefreshDefaults.loadingIndicatorColor

    /** [rememberPullToRefreshState]的默认刷新阈值 */
    val 位置阈值 = PullToRefreshDefaults.PositionalThreshold

    /**
     * 默认最大距离 [指示器]、[指示器框] 和 [加载指示器] 可以被拉动*在触发刷新之前。
     */
    val 指示器最大距离 = PullToRefreshDefaults.IndicatorMaxDistance

    /** 应用于[指示器]的[指示器框]的默认高度 */
    val 阴影 = PullToRefreshDefaults.Elevation

    /** 应用于[加载指示器]的[指示器框]的默认高度 */
    val 加载指示器阴影 = PullToRefreshDefaults.LoadingIndicatorElevation

    /**
     * 一个包装器，负责处理下拉刷新指示器的尺寸、偏移、裁剪、阴影和背景绘制，适用于实现自定义指示器。
     * PullToRefreshDefaults.Indicator 将其作为容器使用。
     *
     * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
     * @param 是否刷新中 是否正在刷新中
     * @param 修饰符 应用于此布局的修饰符。
     * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
     * @param 形状 该指示器的形状（[Shape]）。
     * @param 容器颜色 该指示器的容器颜色。
     * @param 阴影 指示器的阴影高度（elevation）。
     * @param 内容 此 [指示器框] 的内容。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 指示器框(
        状态: PullToRefreshState,
        是否刷新中: Boolean,
        修饰符: Modifier = Modifier,
        最大距离: Dp = 指示器最大距离,
        形状: Shape = 指示器形状,
        容器颜色: Color = Color.Unspecified,
        阴影: Dp = this.阴影,
        内容: @Composable BoxScope.() -> Unit,
    ) {
        PullToRefreshDefaults.IndicatorBox(
            state = 状态,
            isRefreshing = 是否刷新中,
            modifier = 修饰符,
            maxDistance = 最大距离,
            shape = 形状,
            containerColor = 容器颜色,
            elevation = 阴影,
            content = 内容,
        )
    }

    /**
     * [指示器框] 的默认指示器。
     *
     * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
     * @param 是否刷新中 是否正在刷新中
     * @param 修饰符 应用于此布局的修饰符。
     * @param 容器颜色 该指示器的容器颜色。
     * @param 颜色 该指示器的颜色。
     * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 指示器(
        状态: PullToRefreshState,
        是否刷新中: Boolean,
        修饰符: Modifier = Modifier,
        容器颜色: Color = this.指示器容器颜色,
        颜色: Color = this.指示器颜色,
        最大距离: Dp = 指示器最大距离,
    ) {
        PullToRefreshDefaults.Indicator(
            state = 状态,
            isRefreshing = 是否刷新中,
            modifier = 修饰符,
            containerColor = 容器颜色,
            color = 颜色,
            maxDistance = 最大距离,
        )
    }

    /**
     * 用于 [指示器框] 的 [加载指示器]。
     *
     * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
     * @param 是否刷新中 是否正在刷新中
     * @param 修饰符 应用于此布局的修饰符。
     * @param 容器颜色 该指示器的容器颜色。
     * @param 颜色 该指示器的颜色。
     * @param 阴影 该指示器的阴影高度（elevation）。
     * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 加载指示器(
        状态: PullToRefreshState,
        是否刷新中: Boolean,
        修饰符: Modifier = Modifier,
        容器颜色: Color = this.加载指示器容器颜色,
        颜色: Color = this.加载指示器颜色,
        阴影: Dp = 加载指示器阴影,
        最大距离: Dp = 指示器最大距离,
    ) {
        PullToRefreshDefaults.LoadingIndicator(
            state = 状态,
            isRefreshing = 是否刷新中,
            modifier = 修饰符,
            containerColor = 容器颜色,
            color = 颜色,
            elevation = 阴影,
            maxDistance = 最大距离,
        )
    }
}

/**
 * [下拉刷新框] 的状态，用于跟踪容器和指示器被下拉的距离。
 *
 * 每个 [下拉刷新框] 实例都应拥有自己独立的 [下拉刷新状态]。
 */
@Stable
interface 下拉刷新状态 { // PullToRefreshState

    /**
     * 距离刷新阈值的百分比。0.0 表示无距离，1.0 表示刚好达到阈值偏移量，大于 1.0 表示超过给定阈值的过拉距离。
     */
    @get:FloatRange(from = 0.0) val 距离分数: Float

    /**
     * 状态当前是否正在将指示器动画过渡到阈值偏移位置，或回到隐藏偏移位置。
     */
    val 是否动画中: Boolean

    /**
     * 将距离动画过渡到锚点或阈值位置，刷新时指示器将在该位置显示。
     */
    suspend fun 动画到阈值()

    /** 将距离动画过渡到指示器在空闲时隐藏的位置。 */
    suspend fun 动画至隐藏()

    /** 将指示器瞬间移动至指定的阈值比例位置。 */
    suspend fun 捕捉到(@FloatRange(from = 0.0) targetValue: Float)
}

/** 创建并记住默认的 [下拉刷新状态]。 */
@Composable
fun 记住下拉刷新状态(): PullToRefreshState = rememberPullToRefreshState()


/**
 * 创建一个 [下拉刷新状态]。
 *
 * 请注意，在大多数情况下，建议在组合函数中使用 [记住下拉刷新状态]。
 */
fun 下拉刷新状态(): PullToRefreshState = PullToRefreshState()


//===========================================================================================


/**
 * 一个包装器，负责处理下拉刷新指示器的尺寸、偏移、裁剪、阴影和背景绘制，适用于实现自定义指示器。
 * PullToRefreshDefaults.Indicator 将其作为容器使用。
 *
 * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
 * @param 是否刷新中 是否正在刷新中
 * @param 修饰符 应用于此布局的修饰符。
 * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
 * @param 形状 该指示器的形状（[Shape]）。
 * @param 容器颜色 该指示器的容器颜色。
 * @param 阴影 指示器的阴影高度（elevation）。
 * @param 内容 此 [指示器框] 的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun PullToRefreshDefaults.指示器框(
    状态: PullToRefreshState,
    是否刷新中: Boolean,
    修饰符: Modifier = Modifier,
    最大距离: Dp = IndicatorMaxDistance,
    形状: Shape = indicatorShape,
    容器颜色: Color = Color.Unspecified,
    阴影: Dp = this.Elevation,
    内容: @Composable BoxScope.() -> Unit,
) {
    this.IndicatorBox(
        state = 状态,
        isRefreshing = 是否刷新中,
        modifier = 修饰符,
        maxDistance = 最大距离,
        shape = 形状,
        containerColor = 容器颜色,
        elevation = 阴影,
        content = 内容,
    )
}

/**
 * [指示器框] 的默认指示器。
 *
 * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
 * @param 是否刷新中 是否正在刷新中
 * @param 修饰符 应用于此布局的修饰符。
 * @param 容器颜色 该指示器的容器颜色。
 * @param 颜色 该指示器的颜色。
 * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun PullToRefreshDefaults.指示器(
    状态: PullToRefreshState,
    是否刷新中: Boolean,
    修饰符: Modifier = Modifier,
    容器颜色: Color = this.indicatorContainerColor,
    颜色: Color = this.indicatorColor,
    最大距离: Dp = IndicatorMaxDistance,
) {
    this.Indicator(
        state = 状态,
        isRefreshing = 是否刷新中,
        modifier = 修饰符,
        containerColor = 容器颜色,
        color = 颜色,
        maxDistance = 最大距离,
    )
}

/**
 * 用于 [指示器框] 的 [加载指示器]。
 *
 * @param 状态 该修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
 * @param 是否刷新中 是否正在刷新中
 * @param 修饰符 应用于此布局的修饰符。
 * @param 容器颜色 该指示器的容器颜色。
 * @param 颜色 该指示器的颜色。
 * @param 阴影 该指示器的阴影高度（elevation）。
 * @param 最大距离 在释放时触发刷新之前，指示器最多可以被下拉的距离。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun PullToRefreshDefaults.加载指示器(
    状态: PullToRefreshState,
    是否刷新中: Boolean,
    修饰符: Modifier = Modifier,
    容器颜色: Color = this.loadingIndicatorContainerColor,
    颜色: Color = this.loadingIndicatorColor,
    阴影: Dp = Elevation,
    最大距离: Dp = IndicatorMaxDistance,
) {
    this.LoadingIndicator(
        state = 状态,
        isRefreshing = 是否刷新中,
        modifier = 修饰符,
        containerColor = 容器颜色,
        color = 颜色,
        elevation = 阴影,
        maxDistance = 最大距离,
    )
}

