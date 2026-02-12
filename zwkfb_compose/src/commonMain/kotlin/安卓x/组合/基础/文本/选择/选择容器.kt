package 安卓x.组合.基础.文本.选择

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * 允许直接或间接子元素的文本选择
 *
 * 在选择容器（Selection Container）中使用惰性布局（如 LazyRow 或 LazyColumn）时，对于尚未实际组合（composed）
 * 的文本项，其行为是未定义的。例如，这些未被组合的文本将不会被包含在复制操作中，且“全选”操作也不会把选择范围扩展到它们。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 选择容器(修饰符: Modifier = Modifier, 内容: @Composable () -> Unit) =
    SelectionContainer(modifier = 修饰符, content = 内容)

/**
 * 禁用其直接或间接子元素的文本选择。要使用此功能，只需将其添加到包裹一个或多个文本可组合项的组件中。
 */
@Suppress("ComposableNaming")
@Composable
fun 禁用选择(内容: @Composable () -> Unit) = DisableSelection(content = 内容)


