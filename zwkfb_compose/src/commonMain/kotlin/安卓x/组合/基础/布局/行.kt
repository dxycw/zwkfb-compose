package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Measured

/**
 * 一个将子项按水平顺序依次放置的布局型可组合项。若需垂直顺序排列，请参见 [列]。默认情况下子项不会滚动；可用 `Modifier.horizontalScroll`
 * 添加滚动行为。如需仅组合并布局当前可见项的水平滚动列表，请使用 `LazyRow`。
 *
 * [行] 布局可根据子项通过 [RowScope.weight] 修饰符设置的权重来分配宽度。 若某子项未指定权重，系统会先询问其理想宽度，
 * 再将剩余空间按权重比例分配给带权重的子项。注意：若 [行] 本身可水平滚动，或位于可水平滚动的容器内，则所有权重会被忽略，
 * 因为此时剩余空间为无限大。
 *
 * 当 [行] 的所有子项都没有设置权重时，它会尽可能缩小，使各子项仅并排相接。若想改变 [行] 的宽度，可使用 [Modifier.width]
 * 系列修饰符；例如，用 [Modifier.fillMaxWidth] 令其占满可用宽度。只要 [行] 中至少有一个子项使用了 [权重][RowScope.weight]，
 * [行] 就会自动占满可用宽度，此时无需再手动添加 [Modifier.fillMaxWidth]。不过，若需限制 [行] 的尺寸，
 * 仍应显式应用 [Modifier.width] 或 [Modifier.size] 等布局修饰符。
 *
 * 当 [行] 的总宽度大于其子项宽度之和时，可通过指定 [水平排列] 来定义子项在 [行] 内部的水平排布方式。
 * 可用排布行为详见 [Arrangement]；也可通过 [Arrangement] 的构造函数自定义排布策略。不同水平排布方式的示例如下：
 *
 * 请注意，如果在一个 [行] 中放置两个或更多的 文本 组件，通常应按第一基线对齐。[行] 作为通用容器不会自动完成这一对齐，
 * 开发者需手动处理：为每个 文本 添加 [RowScope.alignByBaseline] 修饰符即可；该修饰符默认按 [FirstBaseline] 对齐。
 * 若需按 [LastBaseline] 等其他基线对齐，可使用更通用的 [RowScope.alignBy] 修饰符。
 *
 * @param 修饰符 应用于该 行 的修饰符。
 * @param 水平排列 子项在水平方向上的排列方式。
 * @param 垂直对齐 子项在垂直方向上的对齐方式。
 * @param 内容 行 的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
inline fun 行(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    内容: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = 修饰符,
        horizontalArrangement = 水平排列,
        verticalAlignment = 垂直对齐,
        content = 内容,
    )
}

/** [行]孩子的活动空间。 */
@LayoutScopeMarker
@Immutable
interface 行范围 {
    /**
     * 按 [权重] 比例设置元素宽度，相对于 [行] 中其他带权重兄弟元素。父容器会先测量无权重子元素，再将剩余水平空间按权重分配。
     * 当 [填充] 为 true 时，元素必须占满所分配的全部宽度；为 false 时，元素可小于该宽度——未用部分不会重新分配，[行] 整体会随之缩小。
     *
     * @param 权重 该元素相对于所有带权重兄弟元素总权重的宽度比例。必须为正值。
     * @param 填充 当值为 `true` 时，该元素将占满为其分配的全部宽度。
     */
    @Stable
    fun Modifier.权重(
        @FloatRange(from = 0.0, fromInclusive = false) 权重: Float,
        填充: Boolean = true,
    ): Modifier

    /**
     * 在 [行] 内部对该元素进行垂直对齐；此对齐设置优先于 [行] 的 `verticalAlignment` 参数。
     */
    @Stable
    fun Modifier.对齐(对齐: Alignment.Vertical): Modifier

    /**
     * 将元素垂直摆放，使其 [对齐线] 与同样使用 `对齐方式` 的兄弟元素对齐。`对齐方式` 本质上是 [对齐] 的一种，
     * 因此同一布局上两者不能同时使用。在 [行] 中，所有带 `对齐方式` 的组件会按指定的 [HorizontalAlignmentLine]
     * 或其他 `对齐方式` 重载给出的值形成“兄弟对齐组”。组内至少有一个元素按 [Alignment.Top] 的方式定位，其余兄弟元素
     * 再据此调整垂直位置，使各对齐线重合。注意：若 [行] 里仅有一个元素使用 `对齐方式`，则该元素会表现得像被设为 [Alignment.Top] 一样。
     * @see 按基线对齐
     */
    @Stable
    fun Modifier.对齐方式(对齐线: HorizontalAlignmentLine): Modifier

    /**
     * 将元素垂直摆放，使其**第一基线**与同样使用了 `按基线对齐` 或 `对齐方式` 的兄弟元素对齐。此修饰符属于 [对齐]
     * 的一种，因此在同一布局上两者不可同时使用。`按基线对齐` 是 `对齐方式` 的特例，更多细节参见 `对齐方式`。
     * @see 对齐方式
     */
    @Stable
    fun Modifier.按基线对齐(): Modifier

    /**
     * 将元素垂直摆放，使其由 [对齐线块] 计算出的对齐线与同样使用 `对齐方式` 的兄弟元素对齐。`对齐方式` 本质上是 [对齐]
     * 的一种，因此同一布局上两者不能同时使用。在 [行] 中，所有带 `对齐方式` 的组件会按指定的 [HorizontalAlignmentLine]
     * 或 [对齐线块] 返回的值形成“兄弟对齐组”。组内至少有一个元素按 [Alignment.Top] 的方式定位，其余兄弟元素再据此调整垂直位置，
     * 使各对齐线重合。注意：若 [行] 里仅有一个元素使用 `对齐方式`，则该元素会表现得像被设为 [Alignment.Top] 一样。
     */
    @Stable
    fun Modifier.对齐方式(对齐线块: (Measured) -> Int): Modifier
}


