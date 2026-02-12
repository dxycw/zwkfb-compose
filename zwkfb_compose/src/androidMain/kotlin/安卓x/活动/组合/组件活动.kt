package 安卓x.活动.组合

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.platform.ComposeView

/**
 * 将给定的 Composable 内容组合到指定的 Activity 中，该 [内容] 会成为此 Activity 的根视图。
 *
 * 这大致相当于用 [ComposeView] 调用 [ComponentActivity.setContentView]，即:
 * ```
 * setContentView(
 *   ComposeView(this).apply {
 *     置内容 {
 *       MyComposableContent()
 *     }
 *   }
 * )
 * ```
 * @param 父级 父级组合引用，用于协调组合更新的调度
 * @param 内容 一个用 `@Composable` 标注、用于声明 UI 内容的函数
 */
fun ComponentActivity.置内容(
    父级: CompositionContext? = null,
    内容: @Composable () -> Unit,
) = this.setContent(parent = 父级, content = 内容)


