package 安卓x.组合.材质3

import android.view.WindowManager
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.runtime.Immutable
import androidx.compose.ui.window.SecureFlagPolicy

/** [模态底部面板] 的默认值*/
@Immutable
@ExperimentalMaterial3Api
object 模态底部面板默认值 { // ModalBottomSheetDefaults

    /** 用于自定义 [模态底部面板] 行为的属性。 */
    val 属性
        get() = ModalBottomSheetDefaults.properties

    /**
     * 用于自定义【模态底部面板】行为的属性。
     *
     * @param 安全策略 用于在底部工作表窗口上设置 [WindowManager.LayoutParams.FLAG_SECURE] 的策略。
     * @param 是否聚焦 模态底部面板是否可获取焦点。设为 true 时，模态底部面板将接收输入法事件和按键事件（例如按下返回键）。
     * @param 是否按返回键关闭 模态底部面板是否可通过按返回键关闭。若为 true，按下返回键将触发 onDismissRequest。
     * 注意：必须将 [是否聚焦] 设为 true 才能接收到返回键等按键事件——若模态底部面板不可聚焦，则该属性无效。
     */
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "'isFocusable' param is no longer used. Use value without this parameter.",
        replaceWith = ReplaceWith("properties"),
    )
    @Suppress("UNUSED_PARAMETER")
    fun 属性(
        安全策略: SecureFlagPolicy = SecureFlagPolicy.Inherit,
        是否聚焦: Boolean = true,
        是否按返回键关闭: Boolean = true,
    ) =
        ModalBottomSheetDefaults.properties(
            securePolicy = 安全策略,
            isFocusable = 是否聚焦,
            shouldDismissOnBackPress = 是否按返回键关闭,
        )
}

//===============================================================================

/** 用于自定义 [模态底部面板] 行为的属性。 */
@OptIn(ExperimentalMaterial3Api::class)
val ModalBottomSheetDefaults.属性
    get() = this.properties

/**
 * 用于自定义【模态底部面板】行为的属性。
 *
 * @param 安全策略 用于在底部工作表窗口上设置 [WindowManager.LayoutParams.FLAG_SECURE] 的策略。
 * @param 是否聚焦 模态底部面板是否可获取焦点。设为 true 时，模态底部面板将接收输入法事件和按键事件（例如按下返回键）。
 * @param 是否按返回键关闭 模态底部面板是否可通过按返回键关闭。若为 true，按下返回键将触发 onDismissRequest。
 * 注意：必须将 [是否聚焦] 设为 true 才能接收到返回键等按键事件——若模态底部面板不可聚焦，则该属性无效。
 */
@OptIn(ExperimentalMaterial3Api::class)
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "'isFocusable' param is no longer used. Use value without this parameter.",
    replaceWith = ReplaceWith("properties"),
)
@Suppress("UNUSED_PARAMETER")
fun ModalBottomSheetDefaults.属性(
    安全策略: SecureFlagPolicy = SecureFlagPolicy.Inherit,
    是否聚焦: Boolean = true,
    是否按返回键关闭: Boolean = true,
) =
    this.properties(
        securePolicy = 安全策略,
        isFocusable = 是否聚焦,
        shouldDismissOnBackPress = 是否按返回键关闭,
    )
