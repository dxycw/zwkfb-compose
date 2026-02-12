package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

/**
 * [Material Design date picker dialog](https://m3.material.io/components/date-pickers/overview)
 *
 * 用于显示 [日期选择器] 的对话框。日期选择器让用户能够选择日期。
 *
 * @param 取消请求回调 当用户点击对话框外部或按返回键尝试关闭对话框时调用；点击“关闭”按钮时不会触发。
 * @param 确认按钮 用于确认提议操作并结束对话框的按钮。对话框不会为该按钮预设任何事件，也不控制其启用状态，因此需由调用者自行设置。
 * @param 修饰符 应用于该对话框内容的 [Modifier]。
 * @param 关闭按钮 用于关闭对话框的按钮。对话框不会为该按钮预设任何事件，因此需由调用者自行设置。
 * @param 形状 定义对话框表面的形状及其阴影效果。
 * @param 色调阴影 当 [DatePickerColors.containerColor] 为 [ColorScheme.surface] 时，提高阴影高度（elevation）
 * 将在浅色主题下使颜色更深，在深色主题下使颜色更浅。
 * @param 颜色 用于解析该日期选择器在不同状态下所用颜色的 [DatePickerColors]。参见 [DatePickerDefaults.colors]。
 * @param 属性 通常为平台相关属性，用于进一步配置对话框。
 * @param 内容 对话框的内容（例如 [日期选择器]）。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
actual fun 日期选择器对话框(
    取消请求回调: () -> Unit,
    确认按钮: @Composable () -> Unit,
    修饰符: Modifier,
    关闭按钮: @Composable (() -> Unit)? ,
    形状: Shape,
    色调阴影: Dp ,
    颜色: DatePickerColors,
    属性: DialogProperties,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DatePickerDialog(
        onDismissRequest = 取消请求回调,
        confirmButton = 确认按钮,
        modifier = 修饰符,
        dismissButton = 关闭按钮,
        shape = 形状,
        tonalElevation = 色调阴影,
        colors = 颜色,
        properties = 属性,
        content = 内容,
    )
}


