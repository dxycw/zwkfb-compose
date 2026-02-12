package 安卓x.组合.材质3

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BasicAlertDialogOverride
import androidx.compose.material3.DefaultBasicAlertDialogOverride
import androidx.compose.material3.DefaultBasicAlertDialogOverride.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ComponentOverrideApi
import androidx.compose.material3.LocalBasicAlertDialogOverride
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties


/**
 * [Basic alert dialog dialog](https://m3.material.io/components/dialogs/overview)
 *
 * 对话在用户流程中提供重要提示。它们可以要求用户执行操作、传达信息或帮助用户完成任务。
 *
 * 这个基本的警报对话框期望由调用者定义任意内容。请注意你的内容需要定义自己的样式。
 *
 * 默认情况下，显示的对话框具有 Material Design 规范定义的最小高度和宽度。如果需要，可以通过提供 `width` 或 `height` [Modifier] 来覆盖这些限制。
 *
 * @param 取消请求回调 当用户尝试通过点击对话框外部或按返回按钮来关闭对话框时会调用此方法。点击取消按钮时不会调用此方法。
 * @param 修饰符 应用于此对话内容的[修饰符]。
 * @param 属性 通常是特定平台的属性，用于进一步配置对话框。
 * @param 内容 对话的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ComponentOverrideApi::class)
@ExperimentalMaterial3Api
@Composable
fun 基本警告对话框(
    取消请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    属性: DialogProperties = DialogProperties(),
    内容: @Composable () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = 取消请求回调,
        modifier = 修饰符,
        properties = 属性,
        content = 内容,
    )
}

/**
 * [Basic alert dialog dialog](https://m3.material.io/components/dialogs/overview)
 *
 * 对话在用户流程中提供重要提示。它们可以要求用户执行操作、传达信息或帮助用户完成任务。
 *
 * 这个基本的警报对话框期望由调用者定义任意内容。请注意你的内容需要定义自己的样式。
 *
 * 默认情况下，显示的对话框具有 Material Design 规范定义的最小高度和宽度。如果需要，可以通过提供 `width` 或 `height` [Modifier] 来覆盖这些限制。
 *
 * @param 取消请求回调 当用户尝试通过点击对话框外部或按返回按钮来关闭对话框时会调用此方法。点击取消按钮时不会调用此方法。
 * @param 修饰符 应用于此对话内容的[修饰符]
 * @param 属性 通常是特定平台的属性，用于进一步配置对话框。
 * @param 内容 对话的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Deprecated(
    "改用 基本警告对话框",
    replaceWith = ReplaceWith("警告对话框(取消请求回调, 修饰符, 属性, 内容)"),
)
@ExperimentalMaterial3Api
@Composable
fun 警告对话框(
    取消请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    属性: DialogProperties = DialogProperties(),
    内容: @Composable () -> Unit,
) = AlertDialog(onDismissRequest = 取消请求回调, modifier = 修饰符, properties = 属性, content = 内容)

/** 包含用于[警告对话框]和[基本警告对话框]的默认值 */
object 警报对话框默认值 {
    /** 警报对话框的默认形状 */
    val 形状: Shape
        @Composable get() = AlertDialogDefaults.shape

    /** 警报对话框的默认容器颜色 */
    val 容器颜色: Color
        @Composable get() = AlertDialogDefaults.containerColor

    /** 警报对话框的默认图标颜色 */
    val 图标内容颜色: Color
        @Composable get() = AlertDialogDefaults.iconContentColor

    /** 警报对话框的默认标题颜色 */
    val 标题内容颜色: Color
        @Composable get() = AlertDialogDefaults.titleContentColor

    /** 警告对话框的默认文字颜色 */
    val 文本内容颜色: Color
        @Composable get() = AlertDialogDefaults.textContentColor

    /** 警报对话框的默认色调阴影 */
    val 色调阴影: Dp = AlertDialogDefaults.TonalElevation
}

/** 包含当前选中的 [BasicAlertDialogOverride] 的 CompositionLocal */
@Suppress("CompositionLocalNaming")
@ExperimentalMaterial3ComponentOverrideApi
val 本地基本警告对话框覆盖: ProvidableCompositionLocal<BasicAlertDialogOverride> =
    LocalBasicAlertDialogOverride

