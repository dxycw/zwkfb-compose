package 安卓x.组合.基础.文本

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Density

/**
 * 基础加密文本字段 专为密码输入而设计，是 [基础文本字段] 的预配置替代方案。它仅支持单行内容，并默认提供适用于敏感信息输入的
 * [KeyboardOptions]、[InputTransformation] 与 [CodepointTransformation] 设置。此外，为增强安全性，剪切、复制及拖拽等部分上下文菜单操作将被禁用。
 *
 * @param 状态 TextFieldState：保存 基础加密文本字段 内部状态的对象。
 * @param 修饰符 文本字段的 [Modifier]。
 * @param 已启用 控制 基础加密文本字段 的启用状态。当设为 `false` 时，文本字段既不可编辑也无法聚焦，且其内容将无法被选中。
 * @param 只读 控制 基础加密文本字段 的只读状态。当设为 `true` 时，文本字段不可修改，但用户仍可聚焦。只读文本字段通常用于展示用户无法编辑的预填表单。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。该转换会作用于以下所有输入方式：
 * 实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [状态]，变换规则本身被动态修改时
 * 若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 文本样式 编辑器中文本内容的样式配置。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 与 [ImeAction] 等配置。该组合项默认已为安全文本字段配置 [KeyboardOptions]：
 * 关闭自动纠正，并将 [KeyboardType] 设为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在实体键盘上按回车键时调用。默认值为 `null`，此时将执行接收到 IME
 * 动作时的默认行为：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦项
 * @param 文本布局回调 当文本布局可供查询时执行的回调。回调会收到一个函数：若布局可计算，该函数返回 [TextLayoutResult]，否则返回 null。
 * 此函数从快照状态对象读取布局结果，并在结果变化时使其调用方失效。[TextLayoutResult] 包含段落信息、文本尺寸、基线等详情，
 * 可用于为文本添加额外装饰或功能（例如绘制光标或选区）。所提供的 [Density] 作用域即为创建该文本布局时使用的密度环境。
 * @param 交互源 代表此 文本字段 交互事件流的 [MutableInteractionSource]。如果你想观察 [Interaction] 并根据不同的
 * 交互来自定义 文本字段 的外观或行为，可以自行创建并传入一个 remembered 的 [MutableInteractionSource]。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是带 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 装饰 允许在文本字段周围添加装饰（如图标、占位符、辅助消息等），并自动扩大其可点击区域。
 * @param 文本混淆模式 决定隐藏输入文本的方式。
 * @param 文本混淆字符 用于混淆文本的字符。当 [visualTransformation] 设为 [TextObfuscationMode.Visible] 时，该设置无效。
 * @param 滚动状态 文本字段的滚动状态。由于 基础加密文本字段 始终为单行，此滚动状态始终控制水平滚动。
 */
// 它接收一个 composable lambda，但本质上并不是一个容器。
@Suppress("ComposableLambdaParameterPosition","ComposableNaming","ModifierParameter")
@Composable
fun 基础加密文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    输入转换: InputTransformation? = null,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions(autoCorrectEnabled = false, keyboardType = KeyboardType.Password),
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰: TextFieldDecorator? = null,
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.RevealLastTyped,
    文本混淆字符: Char = DefaultObfuscationCharacter,
    滚动状态: ScrollState = rememberScrollState(),
) {
    BasicSecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        inputTransformation = 输入转换,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorator = 装饰,
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        scrollState = 滚动状态,
    )
}


private const val DefaultObfuscationCharacter: Char = '\u2022'


