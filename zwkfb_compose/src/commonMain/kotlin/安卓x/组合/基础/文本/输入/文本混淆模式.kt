package 安卓x.组合.基础.文本.输入

import androidx.compose.foundation.text.input.TextObfuscationMode

object 文本混淆模式{
    /**
     * 不对任何内容做混淆处理，全部文本可见。
     *
     * 当你希望通过切换“显示”图标短暂露出内容时，它会很有用。
     */
    val 可见 = TextObfuscationMode.Visible

    /**
     * 短暂显示最后输入的字符，随后自动隐藏。
     *
     * 注意：在 Android 上，该功能还依赖系统设置 `Settings.System.TEXT_SHOW_PASSWORD`。
     * 若此系统设置被关闭，则该选项行为与 [隐藏] 完全一致。
     */
    val 显示最后输入 = TextObfuscationMode.RevealLastTyped

    /** 所有字符均被隐藏。 */
    val 隐藏 = TextObfuscationMode.Hidden

}