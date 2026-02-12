package 安卓x.组合.材质3

import android.text.format.DateFormat
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

// `@file:JvmName` 在这里不起作用，因为 Android 和桌面版本使用了不同的名称发布
// 请注意，桌面版的二进制兼容性仅在 JetBrains 分支中跟踪
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 警告对话框(
    取消请求回调: () -> Unit,
    确认按钮: @Composable () -> Unit,
    修饰符: Modifier,
    关闭按钮: @Composable (() -> Unit)?,
    图标: @Composable (() -> Unit)?,
    标题: @Composable (() -> Unit)?,
    文本: @Composable (() -> Unit)?,
    形状: Shape,
    容器颜色: Color,
    图标内容颜色: Color,
    标题内容颜色: Color,
    文本内容颜色: Color,
    色调阴影: Dp,
    属性: DialogProperties,
): Unit =
    AlertDialog(
        onDismissRequest = 取消请求回调,
        confirmButton = 确认按钮,
        modifier = 修饰符,
        dismissButton = 关闭按钮,
        icon = 图标,
        title = 标题,
        text = 文本,
        shape = 形状,
        containerColor = 容器颜色,
        iconContentColor = 图标内容颜色,
        titleContentColor = 标题内容颜色,
        textContentColor = 文本内容颜色,
        tonalElevation = 色调阴影,
        properties = 属性,
    )


