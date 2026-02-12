package 安卓x.组合.材质3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * [Material Design snackbar](https://m3.material.io/components/snackbar/overview)
 *
 * Snackbars 在屏幕底部提供关于应用进程的简短消息。
 *
 * ![Snackbarimage](https://developer.android.com/images/reference/androidx/compose/material3/snackbar.png)
 *
 * 提示条 用于告知用户应用已执行或将要执行的操作。它们临时出现在屏幕底部，不应打断用户体验，且无需用户输入即可自动消失。
 *
 * 提示条 可包含单个操作。"关闭"或"取消"操作为可选。
 *
 * 带操作的 提示条 不应超时或自动消失，直到用户执行其他操作为止。此处，将键盘焦点指示器移至页面中的交互元素进行导航不被视为操作。
 *
 * 此组件仅提供 提示条 的视觉效果。如需使用默认设置在屏幕上显示 提示条，请使用 [SnackbarHostState.showSnackbar]：
 *
 * 如需自定义 提示条 的外观，可将自己的版本作为 [SnackbarHost] 的子项传递给 [脚手架]：
 *
 * 如需遵循 Material 规范（最多 2 行）的多行示例，请参阅：
 *
 * @param 修饰符 要应用于此 提示条 的 [Modifier]
 * @param 动作 要作为操作添加到 提示条 的 动作/按钮组件。如果没有预定义的颜色，建议使用 [ColorScheme.inversePrimary] 作为操作的颜色。
 * @param 关闭动作 当 提示条 非自动消失时，作为额外关闭操作添加的 动作/按钮组件。如果没有预定义的颜色，建议使用 [ColorScheme.inverseOnSurface] 作为操作的颜色。
 * @param 动作新行回调 操作是否应放在单独的行上。建议用于操作文本较长的情况。
 * @param 形状 定义此 提示条 容器的形状
 * @param 容器颜色 此 提示条 背景所用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 提示条 内部内容的首选颜色
 * @param 动作内容颜色 此 提示条 内可选 [动作] 的首选内容颜色
 * @param 关闭动作内容颜色 此 提示条 内可选 [关闭动作] 的首选内容颜色
 * @param 内容 展示应用已执行或将要执行的操作相关信息的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 提示条(
    修饰符: Modifier = Modifier,
    动作: @Composable (() -> Unit)? = null,
    关闭动作: @Composable (() -> Unit)? = null,
    动作新行回调: Boolean = false,
    形状: Shape = SnackbarDefaults.shape,
    容器颜色: Color = SnackbarDefaults.color,
    内容颜色: Color = SnackbarDefaults.contentColor,
    动作内容颜色: Color = SnackbarDefaults.actionContentColor,
    关闭动作内容颜色: Color = SnackbarDefaults.dismissActionContentColor,
    内容: @Composable () -> Unit,
) {
    Snackbar(
        modifier = 修饰符,
        action = 动作,
        dismissAction= 关闭动作,
        actionOnNewLine = 动作新行回调,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        actionContentColor = 动作内容颜色,
        dismissActionContentColor = 关闭动作内容颜色,
        content = 内容,
    )
}

/**
 * [Material Design snackbar](https://m3.material.io/components/snackbar/overview)
 *
 * Snackbars 在屏幕底部提供关于应用进程的简短消息。
 *
 * ![Snackbarimage](https://developer.android.com/images/reference/androidx/compose/material3/snackbar.png)
 *
 * 提示条 用于告知用户应用已执行或将要执行的操作。它们临时出现在屏幕底部，不应打断用户体验，且无需用户输入即可自动消失。
 *
 * 提示条 可包含单个操作。"关闭"或"取消"操作为可选。
 *
 * 带操作的 提示条 不应超时或自动消失，直到用户执行其他操作为止。此处，将键盘焦点指示器移至页面中的交互元素进行导航不被视为操作。
 *
 * 此版本 提示条 设计用于与 [SnackbarHost] 提供的 [SnackbarData] 配合使用，通常用于 [脚手架] 内部。
 *
 * 此组件仅提供 提示条 的视觉效果。如需使用默认设置在屏幕上显示 提示条，请使用 [SnackbarHostState.showSnackbar]：
 *
 * 如需自定义 提示条 的外观，可将自己的版本作为 [SnackbarHost] 的子项传递给 [脚手架]：
 *
 * 当 [SnackbarData.visuals] 将 Snackbar 的持续时间设置为 [SnackbarDuration.Indefinite] 时，建议显示额外的关闭操作。
 * 请参阅 [SnackbarVisuals.withDismissAction]：
 *
 * @param 提示条数据 通过 [SnackbarHostState] 显示的当前 提示条 的数据
 * @param 修饰符 要应用于此 Snackbar 的 [Modifier]
 * @param 动作新行回调 操作是否应放在单独的行上。建议用于操作文本较长的情况。
 * @param 形状 定义此 提示条 容器的形状
 * @param 容器颜色 此 提示条 背景所用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 提示条 内部内容的首选颜色
 * @param 动作颜色 提示条 操作的颜色
 * @param 动作内容颜色 此 提示条 内可选操作的首选内容颜色。请参阅 [SnackbarVisuals.actionLabel]。
 * @param 关闭动作内容颜色 此 提示条 内可选关闭操作的首选内容颜色。请参阅 [SnackbarVisuals.withDismissAction]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 提示条(
    提示条数据: SnackbarData,
    修饰符: Modifier = Modifier,
    动作新行回调: Boolean = false,
    形状: Shape = SnackbarDefaults.shape,
    容器颜色: Color = SnackbarDefaults.color,
    内容颜色: Color = SnackbarDefaults.contentColor,
    动作颜色: Color = SnackbarDefaults.actionColor,
    动作内容颜色: Color = SnackbarDefaults.actionContentColor,
    关闭动作内容颜色: Color = SnackbarDefaults.dismissActionContentColor,
) {
    Snackbar(
        snackbarData = 提示条数据,
        modifier = 修饰符,
        actionOnNewLine = 动作新行回调,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        actionColor = 动作颜色,
        actionContentColor = 动作内容颜色,
        dismissActionContentColor = 关闭动作内容颜色,
    )
}

/** 包含 [提示条] 使用的默认值。 */
object 提示条默认值 { //SnackbarDefaults
    /** 提示条 的默认形状。 */
    val 形状: Shape
        @Composable get() = SnackbarDefaults.shape

    /** 提示条 的默认颜色。 */
    val 颜色: Color
        @Composable get() = SnackbarDefaults.color

    /** 提示条 的默认内容颜色。 */
    val 内容颜色: Color
        @Composable get() = SnackbarDefaults.contentColor

    /** 提示条 的默认操作颜色。 */
    val 动作颜色: Color
        @Composable get() = SnackbarDefaults.actionColor

    /** 提示条 的默认操作内容颜色。 */
    val 动作内容颜色: Color
        @Composable get() = SnackbarDefaults.actionContentColor

    /** 提示条 的默认关闭操作内容颜色。 */
    val 关闭动作内容颜色: Color
        @Composable get() = SnackbarDefaults.dismissActionContentColor
}

//====================================================================

/** 提示条 的默认形状。 */
val SnackbarDefaults.形状: Shape
    @Composable get() = this.shape

/** 提示条 的默认颜色。 */
val SnackbarDefaults.颜色: Color
    @Composable get() = this.color

/** 提示条 的默认内容颜色。 */
val SnackbarDefaults.内容颜色: Color
    @Composable get() = this.contentColor

/** 提示条 的默认操作颜色。 */
val SnackbarDefaults.动作颜色: Color
    @Composable get() = this.actionColor

/** 提示条 的默认操作内容颜色。 */
val SnackbarDefaults.动作内容颜色: Color
    @Composable get() = this.actionContentColor

/** 提示条 的默认关闭操作内容颜色。 */
val SnackbarDefaults.关闭动作内容颜色: Color
    @Composable get() = this.dismissActionContentColor
