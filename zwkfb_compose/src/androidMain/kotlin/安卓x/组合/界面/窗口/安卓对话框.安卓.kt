package 安卓x.组合.界面.窗口

import android.annotation.SuppressLint
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.SecureFlagPolicy
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.window.DialogProperties
import androidx.core.view.WindowCompat

/**
 * 用于自定义[Dialog]行为的属性
 *
 * @property dismissOnBackPress 对话框是否可以通过按返回或退出按钮关闭。如果为真，按返回按钮将调用 onDismissRequest。
 * @property dismissOnClickOutside 对话框是否可以通过点击对话框边界外部来关闭。如果为真，点击对话框外部将调用 onDismissRequest。
 * @property securePolicy 在对话框窗口上设置[WindowManager.LayoutParams.FLAG_SECURE]的策略。
 * @property usePlatformDefaultWidth 对话框内容的宽度是否应限制为* 平台默认值，该值小于屏幕宽度。建议在 [usePlatformDefaultWidth]
 * 为 false 时将 [decorFitsSystemWindows] 设置为 `false` 以支持* 使用整个屏幕，并在输入法动画弹出时避免某些设备上的 UI 错误。
 * @property decorFitsSystemWindows 设置 [WindowCompat.setDecorFitsSystemWindows] 的值。设置为`false` 以使用 WindowInsets。
 * 如果为 `false`，[软输入模式][WindowManager.LayoutParams.softInputMode] 将在 [Build.VERSION_CODES.R]及以下版本中更改
 * 为[WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE]，在 [Build.VERSION_CODES.S] 及以上版本中更改为
 * [WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING]。当 decorFitsSystemWindows 为 `false` 时，[Window.isFloating] 将为 `false`。
 * @property windowTitle 对话框窗口的标题
 */
@Immutable
class 对话框属性(
    val dismissOnBackPress: Boolean = true,
    val dismissOnClickOutside: Boolean = true,
    val securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit,
    val usePlatformDefaultWidth: Boolean = true,
    val decorFitsSystemWindows: Boolean = true,
    val windowTitle: String = "",
) {
    constructor(
        dismissOnBackPress: Boolean,
        dismissOnClickOutside: Boolean,
        usePlatformDefaultWidth: Boolean,
    ) : this(
        dismissOnBackPress = dismissOnBackPress,
        dismissOnClickOutside = dismissOnClickOutside,
        securePolicy = SecureFlagPolicy.Inherit,
        usePlatformDefaultWidth = usePlatformDefaultWidth,
        decorFitsSystemWindows = true,
    )

    @Deprecated("Maintained for binary compatibility", level = DeprecationLevel.HIDDEN)
    constructor(
        dismissOnBackPress: Boolean = true,
        dismissOnClickOutside: Boolean = true,
        securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit,
        usePlatformDefaultWidth: Boolean = true,
        decorFitsSystemWindows: Boolean = true,
    ) : this(
        dismissOnBackPress = dismissOnBackPress,
        dismissOnClickOutside = dismissOnClickOutside,
        securePolicy = SecureFlagPolicy.Inherit,
        usePlatformDefaultWidth = usePlatformDefaultWidth,
        decorFitsSystemWindows = true,
        windowTitle = "",
    )

    @Deprecated("Maintained for binary compatibility", level = DeprecationLevel.HIDDEN)
    constructor(
        dismissOnBackPress: Boolean = true,
        dismissOnClickOutside: Boolean = true,
        securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit,
    ) : this(
        dismissOnBackPress = dismissOnBackPress,
        dismissOnClickOutside = dismissOnClickOutside,
        securePolicy = securePolicy,
        usePlatformDefaultWidth = true,
        decorFitsSystemWindows = true,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DialogProperties) return false

        if (dismissOnBackPress != other.dismissOnBackPress) return false
        if (dismissOnClickOutside != other.dismissOnClickOutside) return false
        if (securePolicy != other.securePolicy) return false
        if (usePlatformDefaultWidth != other.usePlatformDefaultWidth) return false
        if (decorFitsSystemWindows != other.decorFitsSystemWindows) return false

        return true
    }

    override fun hashCode(): Int {
        var result = dismissOnBackPress.hashCode()
        result = 31 * result + dismissOnClickOutside.hashCode()
        result = 31 * result + securePolicy.hashCode()
        result = 31 * result + usePlatformDefaultWidth.hashCode()
        result = 31 * result + decorFitsSystemWindows.hashCode()
        return result
    }
}

/**
 * 打开一个包含给定内容的对话框。
 *
 * 对话框是一个小窗口，提示用户做出决定或输入额外信息。对话框不会填满整个屏幕，通常用于模态事件，需要用户在继续之前采取某些操作。
 *
 * 只要对话框是组成层次的一部分，它就是可见的。为了让用户关闭对话框，[取消请求回调] 的实现应包含一种从组成层次中移除对话框的方法。
 *
 * @param 取消请求回调 当用户尝试关闭对话框时执行。
 * @param 属性 用于进一步自定义此对话框行为的[DialogProperties]
 * @param 内容 要在对话框中显示的内容
 */
@SuppressLint("ComposableNaming")
@Composable
fun 对话框(
    取消请求回调: () -> Unit,
    属性: DialogProperties,
    内容: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = 取消请求回调,
        properties = 属性,
        content = 内容,
    )
}

