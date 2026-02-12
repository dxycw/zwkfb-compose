package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Density

/**
 * [Material Design filled text field for securecontent](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段供用户在界面中输入文本。[SecureTextField] 专为密码输入设计，仅支持单行内容，并默认启用适合输入敏感信息的配置。此外，
 * 为增强安全性，剪切、复制及拖拽等部分上下文菜单操作将被禁用。
 *
 * 填充文本字段的视觉强调度高于描边文本字段，在与其他内容或组件并排展示时更显突出。如需描边样式，请使用 OutlinedSecureTextField。
 *
 * @param 状态 TextFieldState：文本字段的编辑状态。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制该文本字段的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
 * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
 * @param 标签位置 标签的位置，参见 [TextFieldLabelPosition]。
 * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当输入文本为空时可选显示的占位文本，默认文字样式为 [Typography.bodyLarge]。
 * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
 * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
 * @param 前缀 显示在文本字段输入文本之前的可选前缀。
 * @param 后缀 显示在文本字段输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，文本字段各组件将以错误颜色显示，并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。转换会作用于以下所有输入方式：
 * 实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [状态]，变换规则本身被动态修改时
 * 若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 文本混淆模式 用于隐藏输入文本的方法。
 * @param 文本混淆字符 用于混淆文本的字符。当 [visualTransformation] 设为 [TextObfuscationMode.Visible] 时，该设置无效。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 与 [ImeAction] 等配置。默认情况下，该组件已为安全文本字段配置 [KeyboardOptions]：
 * 关闭自动纠正，并将 [KeyboardType] 设为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在实体键盘上按回车键时调用。默认值为 `null`，此时将执行接收到 IME
 * 动作时的默认行为：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦项
 * @param 文本布局回调 当文本布局可供查询时执行的回调。回调会收到一个函数：若布局可计算，该函数返回 [TextLayoutResult]，否则返回 null。
 * 此函数从快照状态对象读取布局结果，并在结果变化时使其调用方失效。[TextLayoutResult] 包含段落信息、文本尺寸、基线等详情；所提供的 [Density] 作用域即为创建该布局时使用的密度环境。
 * @param 形状 定义该文本字段容器的形状。
 * @param 颜色 用于在不同状态下解析该文本字段颜色的 [TextFieldColors]，参见 [TextFieldDefaults.colors]。
 * @param 内容内边距 内层文本字段与周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
 * 参见 [TextFieldDefaults.contentPaddingWithLabel] 与 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 可选的已提升的 [MutableInteractionSource]，用于观察并发送该文本字段的 [Interaction]。可借此改变文本字段的外观，
 * 或在不同状态下预览效果。注意：即使传入 `null`，内部交互仍会发生。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 加密文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本样式: TextStyle = LocalTextStyle.current,
    标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
    标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    输入转换: InputTransformation? = null,
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.RevealLastTyped,
    文本混淆字符: Char = DefaultObfuscationCharacter,
    键盘选项: KeyboardOptions = SecureTextFieldKeyboardOptions,
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    形状: Shape = TextFieldDefaults.shape,
    颜色: TextFieldColors = TextFieldDefaults.colors(),
    内容内边距: PaddingValues =
        if (标签 == null || 标签位置 is TextFieldLabelPosition.Above) {
            TextFieldDefaults.contentPaddingWithoutLabel()
        } else {
            TextFieldDefaults.contentPaddingWithLabel()
        },
    交互源: MutableInteractionSource? = null,
) {
    SecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        textStyle = 文本样式,
        labelPosition = 标签位置,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        inputTransformation = 输入转换,
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        shape = 形状,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design outlined text field for securecontent](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段供用户在界面中输入文本。[OutlinedSecureTextField] 专为密码输入设计，仅支持单行内容，并默认启用适合输入敏感信息的配置。
 * 此外，为增强安全性，剪切、复制及拖拽等部分上下文菜单操作将被禁用。
 *
 * 描边文本字段的视觉强调度低于填充文本字段；当它们成组出现在表单等场景时，这种较低的强调度有助于简化整体布局。如需填充样式，请参见 [SecureTextField]。
 *
 * @param 状态 TextFieldState：文本字段的编辑状态。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制该文本字段的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
 * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
 * @param 标签位置 标签的位置，参见 [TextFieldLabelPosition]。
 * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当输入文本为空时可选显示的占位文本，默认文字样式为 [Typography.bodyLarge]。
 * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
 * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
 * @param 前缀 显示在文本字段输入文本之前的可选前缀。
 * @param 后缀 显示在文本字段输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，文本字段各组件将以错误颜色显示，并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。该转换会作用于以下所有输入方式：
 * 实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [状态]，变换规则本身被动态修改时
 * 若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 文本混淆模式 用于隐藏输入文本的方法。
 * @param 文本混淆字符 用于混淆文本的字符。当 [visualTransformation] 设为 [TextObfuscationMode.Visible] 时，该设置无效。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 与 [ImeAction] 等配置。默认情况下，该组件已为安全文本字段配置 [KeyboardOptions]：
 * 关闭自动纠正，并将 [KeyboardType] 设为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在实体键盘上按回车键时调用。默认值为 `null`，此时将执行接收到 IME
 * 动作时的默认行为：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦项
 * @param 文本布局回调 当文本布局可供查询时执行的回调。回调会收到一个函数：若布局可计算，该函数返回 [TextLayoutResult]，否则返回 null。
 * 此函数从快照状态对象读取布局结果，并在结果变化时使其调用方失效。[TextLayoutResult] 包含段落信息、文本尺寸、基线等详情；
 * 所提供的 [Density] 作用域即为创建该布局时使用的密度环境。
 * @param 形状 定义该文本字段容器的形状。
 * @param 颜色 用于在不同状态下解析该文本字段颜色的 [TextFieldColors]，参见 [TextFieldDefaults.colors]。
 * @param 内容内边距 内层文本字段与周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
 * 参见 [TextFieldDefaults.contentPaddingWithLabel] 与 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 可选的已提升的 [MutableInteractionSource]，用于观察并发送该文本字段的 [Interaction]。
 * 可借此改变文本字段的外观，或在不同状态下预览效果。注意：即使传入 `null`，内部交互仍会发生。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 轮廓加密文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本样式: TextStyle = LocalTextStyle.current,
    标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
    标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    输入转换: InputTransformation? = null,
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.RevealLastTyped,
    文本混淆字符: Char = DefaultObfuscationCharacter,
    键盘选项: KeyboardOptions = SecureTextFieldKeyboardOptions,
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    形状: Shape = OutlinedTextFieldDefaults.shape,
    颜色: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    内容内边距: PaddingValues = OutlinedTextFieldDefaults.contentPadding(),
    交互源: MutableInteractionSource? = null,
) {
    OutlinedSecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        textStyle = 文本样式,
        labelPosition = 标签位置,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        inputTransformation = 输入转换,
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        shape = 形状,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

private val SecureTextFieldKeyboardOptions =
    KeyboardOptions(autoCorrectEnabled = false, keyboardType = KeyboardType.Password)

private const val DefaultObfuscationCharacter: Char = '\u2022'
