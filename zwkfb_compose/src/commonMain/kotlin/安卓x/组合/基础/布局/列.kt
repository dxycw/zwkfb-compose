package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.layout.VerticalAlignmentLine

/**
 * 一个将子项按垂直顺序依次放置的布局型可组合项。若需要水平顺序排列，请使用 [行]。默认情况下，子项不会滚动；可通过
 * `Modifier.verticalScroll` 添加滚动行为。如需仅组合并布局当前可见项的垂直滚动列表，请使用 `LazyColumn`。
 *
 * [列] 布局可根据子项通过 [ColumnScope.weight] 修饰符设置的权重来分配高度。若某子项未指定权重，系统会先询问其理想高度，
 * 再将剩余空间按权重比例分配给带权重的子项。注意：若 [列] 本身可垂直滚动，或位于可垂直滚动的容器内，则所有权重会被忽略，
 * 因为此时剩余空间为无限大。
 *
 * 当 [列] 的所有子项都没有设置权重时，它会尽可能缩小，以刚好能自上而下堆叠全部子项。若想改变 [列] 的高度，可使用
 * [Modifier.height] 系列修饰符；例如，用 [Modifier.fillMaxHeight] 让它占满可用高度。只要 [列] 中至少有一个子项
 * 使用了 [weight][ColumnScope.weight]，[列] 就会自动占满可用高度，此时无需再手动加 [Modifier.fillMaxHeight]。
 * 不过，若需要限制 [列] 的尺寸，仍应显式应用 [Modifier.height] 或 [Modifier.size] 等布局修饰符。
 *
 * 当 [列] 的总高度大于其子项高度之和时，可通过指定 [verticalArrangement] 来定义子项在 [列] 内部的垂直排布方式。
 * 可用排布行为详见 [Arrangement]；也可通过 [Arrangement] 的构造函数自定义排布策略。不同垂直排布方式的示例如下：
 *
 * @param 修饰符 应用于该 列 的修饰符。
 * @param 垂直排列 子项在垂直方向上的排布方式。
 * @param 水平对齐 子项在水平方向上的对齐方式。
 * @param 内容 列 的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
inline fun 列(
    修饰符: Modifier = Modifier,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    水平对齐: Alignment.Horizontal = Alignment.Start,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = 修饰符,
        verticalArrangement = 垂直排列,
        horizontalAlignment = 水平对齐,
        content = 内容,
    )
}


/** [列]儿童的活动范围。 */
@LayoutScopeMarker
@Immutable
interface 列范围 {
    /**
     * 按 [权重] 比例设置元素高度，相对于 [列] 中其他带权重兄弟元素。父容器会先测量无权重子元素，再将剩余垂直空间按权重分配。
     * 当 [填充] 为 true 时，元素必须占满所分配的全部高度；为 false 时，元素可小于该高度——未用部分不会重新分配，[列] 整体会随之缩小。
     *
     * 在 [FlowColumn] 中，当某个元素被赋予 权重 时，其大小将依据该元素所在列中所有带权重元素的总权重进行缩放。
     *
     * @param 权重 该元素相对于所有带权重兄弟元素总权重的垂直比例高度。必须为正值。
     * @param 填充 当值为 `true` 时，该元素将占满为其分配的全部高度。
     */
    @Stable
    fun Modifier.权重(
        @FloatRange(from = 0.0, fromInclusive = false) 权重: Float,
        填充: Boolean = true,
    ): Modifier

    /**
     * 在 [列] 内部对该元素进行水平对齐；此对齐设置优先于 [列]] 的 `horizontalAlignment` 参数。
     */
    @Stable
    fun Modifier.对齐(对齐: Alignment.Horizontal): Modifier

    /**
     * 将元素水平摆放，使其 [对齐线] 与同样使用了 [对齐方式] 的兄弟元素对齐。[对齐方式] 本质上是 [对齐] 的一种，
     * 因此同一布局上两者不能同时使用。在 [列] 中，所有带 [对齐方式] 的组件会按指定的 [VerticalAlignmentLine]
     * 或其他 [对齐方式] 重载给出的值形成“兄弟对齐组”。组内至少有一个元素按 [Alignment.Start] 的方式定位，其余兄弟元素
     * 再据此调整水平位置，使各对齐线重合。注意：若 [列] 里仅有一个元素使用 [对齐方式]，则该元素会表现得像被设为 [Alignment.Start] 一样。
     */
    @Stable
    fun Modifier.对齐方式(对齐线: VerticalAlignmentLine): Modifier

    /**
     * 将元素水平摆放，使其由 [alignmentLineBlock] 计算出的对齐线与同样使用 [对齐方式] 的兄弟元素对齐。[对齐方式]
     * 本质上是 [对齐] 的一种，因此同一布局上两者不能同时使用。在 [列] 中，所有带 [对齐方式] 的组件会按指定的
     * [VerticalAlignmentLine] 或 [alignmentLineBlock] 返回的值形成“兄弟对齐组”。组内至少有一个元素按 [Alignment.Start]
     * 的方式定位，其余兄弟元素再据此调整水平位置，使各对齐线重合。注意：若 [列] 里仅有一个元素使用 [对齐方式]，
     * 则该元素会表现得像被设为 [Alignment.Start] 一样。
     */
    @Stable
    fun Modifier.对齐方式(对齐线块: (Measured) -> Int): Modifier
}