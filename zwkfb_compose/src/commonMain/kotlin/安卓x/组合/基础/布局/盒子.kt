package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * 一个包含 `[内容]` 的布局组合件。`[盒子]` 会根据传入的约束条件自行为自身 sizing 以适应内容。当子项尺寸小于父级时，默认会按照 `[内容对齐]`
 * 在 `[盒子]` 内对齐；若需为每个子项单独指定对齐方式，请使用 `[BoxScope.align]` 修饰符。默认情况下，**内容在测量时不会继承 `[盒子]`
 * 的传入最小约束**，除非将 `[传播最小约束]` 设为 `true`。例如，当 `[盒子]`内的内容无法直接设置修饰符、但又需要给内容指定最小尺寸时，
 * 将 `[传播最小约束]`设为 `true` 即可让最小尺寸同时作用于内容与`[盒子]`；否则最小尺寸仅应用于 `[盒子]` 本身。当内容包含多个布局子项时，
 * 这些子项将按组合顺序**堆叠**（一层盖一层），并依照上述规则进行定位。
 *
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 框内的默认对齐方式。
 * @param 传播最小约束 是否应将传入的最小约束传递给内容。
 * @param 内容 [盒子] 的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
inline fun 盒子(
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    传播最小约束: Boolean = false,
    内容: @Composable BoxScope.() -> Unit,
) =
    Box(
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        propagateMinConstraints = 传播最小约束,
        content = 内容,
    )


/**
 * 一个**不含内容**的空白 盒子，仅通过所应用的 `[修饰符]` 参与布局、绘制和指针输入处理。
 *
 * @param 修饰符 要应用于该布局的修饰符。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 盒子(修饰符: Modifier) = Box(modifier = 修饰符)


/** `盒子范围` 为 `[盒子]` 与 `[BoxWithConstraints]` 的子元素提供了作用域。 */
@LayoutScopeMarker
@Immutable
interface 盒子范围 { // BoxScope
    /**
     * 将内容元素拉向 [盒子] 内的某个指定 [Alignment]。该对齐优先级高于 [盒子] 自身的 `对齐` 参数。
     */
    @Stable
    fun Modifier.对齐(对齐: Alignment): Modifier

    /**
     * 在所有其他内容元素测量完成后，将该元素的尺寸设置为与 [盒子] 相同。
     *
     * 使用此修饰符的元素**不会参与** [盒子] 的尺寸计算；相反，它会在所有**未使用** `匹配父级大小()` 的子项测量完成后，
     * 再将自身尺寸设为与 [盒子] 相同。相比之下，通用的 `[Modifier.fillMaxSize]` 会让元素**占用全部可用空间**，
     * 并参与 [盒子] 的尺寸定义；因此在 [盒子] 内对某个元素使用 `fillMaxSize()` 会导致整个 [盒子] 始终填满可用空间。
     */
    @Stable
    fun Modifier.匹配父级大小(): Modifier
}


