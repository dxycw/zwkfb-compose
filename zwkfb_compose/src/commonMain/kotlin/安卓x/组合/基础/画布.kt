package 安卓x.组合.基础

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope


/**
 * 一个可在屏幕上指定区域、并在此区域内进行画布绘制的组件。必须通过 Modifier 指定尺寸：既可用精确尺寸（如 `Modifier.size`），
 * 也可用相对于父级的尺寸（如 `Modifier.fillMaxSize`、`ColumnScope.weight` 等）。若父级对该组件采用 wrap 内容的方式，
 * 则只能使用精确尺寸。
 *
 * @param 修饰符 用于为当前可组合项指定尺寸策略的必需修饰符。
 * @param 绘制回调 用于执行绘制的 lambda。意：该 lambda 会在**绘制阶段**被调用，此时无法访问 Composition 作用域；
 * 若在其中调用任何 [Composable] 函数，将直接抛出运行时异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 画布(修饰符: Modifier, 绘制回调: DrawScope.() -> Unit) =
    Canvas(modifier = 修饰符, onDraw = 绘制回调)

/**
 * 一个可在屏幕上划定区域并进行画布绘制的组件。必须通过 Modifier 指定尺寸：既可用 `Modifier.size` 设定精确值，也可用
 * `Modifier.fillMaxSize`、`ColumnScope.weight` 等相对父级的策略。若父级采用 wrap 内容模式，则只能使用精确尺寸。
 *
 * @param 修饰符 用于为当前可组合项指定尺寸策略的必需修饰符。
 * @param 内容描述 供无障碍服务使用的文本，用来说明该画布所代表的内容。除非画布仅作装饰用途，或已作为更大整体的一部分被其他方式描述，
 * 否则都应提供此文本。该文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 获取。
 * @param 绘制回调 执行绘制的 lambda。注意：该 lambda 将在绘制阶段被调用，此时无法访问 Composition 作用域；
 * 若在其中调用任何 [Composable] 函数，将抛出运行时异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 画布(修饰符: Modifier, 内容描述: String, 绘制回调: DrawScope.() -> Unit) =
    Canvas(modifier = 修饰符, contentDescription = 内容描述, onDraw = 绘制回调)
