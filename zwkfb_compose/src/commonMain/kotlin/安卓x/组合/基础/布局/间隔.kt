package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier

/**
 * 这是一个用于表示“空白区域”的布局组件，其大小可通过 `Modifier.width`、`Modifier.height` 和 `Modifier.size` 修饰符来设定。
 *
 * @param 修饰符 用于设置此 间隔 的修饰符
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 间隔(修饰符: Modifier) = Spacer(修饰符)


