@file:Suppress("DEPRECATION")

package 安卓x.组合.界面.布局

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MultiContentMeasurePolicy
import androidx.compose.ui.layout.MultiMeasureLayout


/**
 * [布局] 是布局的核心组件，用于对零个或多个子项进行测量与定位。
 *
 * 该布局的测量、摆放以及固有尺寸测量行为，均由 [测量策略] 实例定义。详见 [MeasurePolicy]。
 *
 * 如需使用一个可根据传入约束条件来动态定义其内容的可组合项，请参考[androidx.compose.foundation.layout.BoxWithConstraints]。
 *
 * @param 内容 要被布局的子可组合项。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义该布局测量与定位策略的 Policy。
 */
@Suppress("ComposableLambdaParameterPosition", "ComposableNaming", "ModifierParameter")
@UiComposable
@Composable
inline fun 布局(
    内容: @Composable @UiComposable () -> Unit,
    修饰符: Modifier = Modifier,
    测量策略: MeasurePolicy,
) {
    Layout(content = 内容, modifier = 修饰符, measurePolicy = 测量策略)
}


/**
 * [布局] 是“叶子”节点布局的核心组件，可用来对零个子项进行测量与定位。
 *
 * 该布局的测量、摆放以及固有尺寸测量行为，均由 [测量策略] 实例定义。详见 [MeasurePolicy]。
 *
 * 如需使用可根据传入约束动态定义内容的可组合项，请参考[androidx.compose.foundation.layout.BoxWithConstraints].
 *
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义该布局测量与定位策略的 Policy。
 */
@Suppress("NOTHING_TO_INLINE", "ComposableNaming", "ModifierParameter")
@Composable
@UiComposable
inline fun 布局(修饰符: Modifier = Modifier, 测量策略: MeasurePolicy) {
    Layout(modifier = 修饰符, measurePolicy = 测量策略)
}



/**
 * [布局] 是布局的核心组件，用于对零个或多个子项进行测量与定位。
 *
 * 该重载版本接受多个可组合内容 lambda 列表，从而允许对不同 lambda 中的 Measurable 区别对待：测量策略收到的不再是一个简单
 * 列表，而是一个“列表的列表”。该列表的大小与传入 [布局] 的 contents 列表一致，并按相同顺序存放对应 content lambda 中的 Measurable。
 *
 * 请注意，所有 [内容集] lambda 中发出的布局都会成为该 [布局] 的直接子项。这意味着，如果你为某些子项设置了自定义的 z-index，
 * 它们的绘制顺序将被视为如同它们都在同一个 lambda 中提供的一样进行计算。
 *
 * @param 内容集 待布局的子可组合内容列表。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义该布局测量与定位策略的 Policy。
 * @see 布局 适用于仅有一个 content lambda 的简单场景。
 */
@Suppress("ComposableLambdaParameterPosition", "NOTHING_TO_INLINE", "ComposableNaming", "ModifierParameter")
@UiComposable
@Composable
inline fun 布局(
    内容集: List<@Composable @UiComposable () -> Unit>,
    修饰符: Modifier = Modifier,
    测量策略: MultiContentMeasurePolicy,
) {
    Layout(contents = 内容集, modifier = 修饰符, measurePolicy = 测量策略)
}



@Suppress("ComposableLambdaParameterPosition", "ComposableNaming", "ModifierParameter")
@Composable
@UiComposable
@Deprecated("此 API 在大规模 UI 场景下存在性能风险——使用不当会引发指数级性能劣化，应尽可能避免使用。")
fun 多次测量布局(
    修饰符: Modifier = Modifier,
    内容: @Composable @UiComposable () -> Unit,
    测量策略: MeasurePolicy,
) {
    MultiMeasureLayout(modifier = 修饰符, content = 内容, measurePolicy = 测量策略)
}



