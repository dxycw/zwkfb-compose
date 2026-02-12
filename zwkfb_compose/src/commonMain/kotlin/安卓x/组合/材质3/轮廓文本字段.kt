package 安卓x.组合.材质3

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

/**
 * [Material Design outlined text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段供用户在界面中输入文本，通常出现在表单和对话框中。描边文本字段的视觉强调程度低于填充文本字段。当它们成组出现在表单等场景时，
 * 这种较低的强调度有助于简化整体布局。
 *
 * ![Outlined text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/outlined-text-field.png)
 *
 * 如果你需要填充版本的文本字段，请参见 [FilledTextField]；如果需要专门用于密码或其他敏感内容的描边文本字段，请参见 [OutlinedSecureTextField]。
 *
 * 这个 [OutlinedTextField] 重载版本使用 [TextFieldState] 来记录文本内容以及光标或选区的位置。
 *
 * @param 状态 [TextFieldState] 对象用于保存文本字段内部的编辑状态。
 * @param 修饰符 应用于该文本字段的 [Modifier]。
 * @param 已启用 控制该文本字段的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
 * @param 只读 控制文本字段的只读状态。当设为 `true` 时，文本字段无法被修改，但用户仍可将其聚焦并复制其中的文本。只读文本字段通常用于展示用户不可编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
 * @param 标签位置 标签的位置，参见 [TextFieldLabelPosition]。
 * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
 * @param 占位符 输入框为空时可选显示的占位文本，默认文字样式为 [Typography.bodyLarge]。
 * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
 * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
 * @param 前缀 显示在文本字段输入文本前面的可选前缀。
 * @param 后缀 显示在文本字段输入文本后面的可选后缀。
 * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，文本字段各组件将以错误颜色显示，并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。该转换会作用于以下所有输入方式：
 * 实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [状态]，变换规则本身被动态
 * 修改时若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 输出转换 可选的 [OutputTransformation]，用于变换文本字段内容的展示方式。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 和 [ImeAction] 等配置。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在实体键盘上按回车键时调用。默认值为 `null`，此时将执行接收到 IME
 * 动作时的默认行为：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦项
 * @param 行限制 控制文本字段是 [SingleLine]（单行，水平滚动，忽略换行符），还是 [MultiLine]（多行，垂直扩展和滚动）。
 * 如果传入 [SingleLine]，文本中的所有换行符（'\n'）将被替换为普通空格（' '）。
 * @param 文本布局回调 当文本布局可被查询时执行的回调。回调会收到一个函数，该函数在布局可计算时返回 [TextLayoutResult]，否则返回 null。
 * 此函数从快照状态对象中读取布局结果，并在布局结果变化时使其调用方失效。[TextLayoutResult] 对象包含段落信息、文本尺寸、基线等详情。
 * 提供的 [Density] 作用域即为创建该文本布局时所使用的密度环境。
 * @param 滚动状态 管理文本字段水平或垂直滚动的滚动状态。若 [行限制] 为 [SingleLine]，则该文本字段被视为单行，采用水平滚动；否则为垂直滚动。
 * @param 形状 定义该文本字段边框的形状。
 * @param 颜色 TextFieldColors，用于为 OutlinedTextField 的不同状态设置颜色。
 * @param 内容内边距 内层文本字段与周围元素之间的内边距。注意：若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
 * 详见 [OutlinedTextFieldDefaults.contentPadding]。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该文本字段的 [Interaction]。你可以借助它
 * 改变文本字段的外观，或在不同状态下预览文本字段。注意：即使传入 `null`，内部仍会发生交互。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 轮廓文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
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
    输出转换: OutputTransformation? = null,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作回调: KeyboardActionHandler? = null,
    行限制: TextFieldLineLimits = TextFieldLineLimits.Default,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    滚动状态: ScrollState = rememberScrollState(),
    形状: Shape = OutlinedTextFieldDefaults.shape,
    颜色: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    内容内边距: PaddingValues = OutlinedTextFieldDefaults.contentPadding(),
    交互源: MutableInteractionSource? = null,
) {
    OutlinedTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
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
        outputTransformation = 输出转换,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        lineLimits = 行限制,
        onTextLayout = 文本布局回调,
        scrollState = 滚动状态,
        shape = 形状,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design outlined text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段供用户在界面中输入文本，通常出现在表单和对话框中。描边文本字段的视觉强调程度低于填充文本字段；当它们成组出现在表单等场景时，这种较低的强调度有助于简化整体布局。
 *
 * ![Outlined text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/outlined-text-field.png)
 *
 * 如果你除了想监听输入文本的变化，还想同时观察光标位置、选区范围或 IME 组合状态，请改用参数为 [TextFieldValue] 的 OutlinedTextField 重载版本。
 *
 * @param 值 要在文本字段中显示的输入文本。
 * @param 值改变回调 当输入法服务更新文本时触发的回调，更新后的文本会作为回调的参数传入。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制该文本字段的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
 * @param 只读 控制文本字段的只读状态。当设为 `true` 时，文本字段无法被修改，但用户仍可将其聚焦并复制其中的文本。只读文本字段通常用于展示用户不可编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
 * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当文本字段获得焦点且输入文本为空时，可选显示的占位文本。内部 [文本] 的默认文字样式为 [Typography.bodyLarge]。
 * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
 * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
 * @param 前缀 显示在文本字段输入文本之前的可选前缀。
 * @param 后缀 显示在文本字段输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。若设为 true，默认情况下标签、底部指示器和尾部图标都会以错误颜色显示。
 * @param 视觉转换 对输入的“值”进行视觉层面的转换。例如，可使用[PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * 来创建密码文本字段。默认不应用任何视觉转换。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 与 [ImeAction] 等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，会触发对应的回调。注意：此 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的值不同。
 * @param 单行 当设为 `true` 时，该文本字段变为单行水平滚动，不再自动换行；系统会通知键盘不显示回车键作为 [ImeAction]。
 * 注意：此时 [最大行数] 参数将被忽略，最大行数会自动设为 1。
 * @param 最大行数 文本框的最大高度，以最多可见行数表示。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 文本框的最小高度，以最少可见行数表示。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该文本字段的 [Interaction]。你可以借助它
 * 改变文本字段的外观，或在不同状态下预览文本字段。注意：即使传入 `null`，内部仍会发生交互。
 * @param 形状 定义该文本字段边框的形状。
 * @param 颜色 TextFieldColors，用于为 OutlinedTextField 的不同状态设置颜色。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 轮廓文本字段(
    值: String,
    值改变回调: (String) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = LocalTextStyle.current,
    标签: @Composable (() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    视觉转换: VisualTransformation = VisualTransformation.None,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    交互源: MutableInteractionSource? = null,
    形状: Shape = OutlinedTextFieldDefaults.shape,
    颜色: TextFieldColors = OutlinedTextFieldDefaults.colors(),
) {
    OutlinedTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        visualTransformation = 视觉转换,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        interactionSource = 交互源,
        shape = 形状,
        colors = 颜色,
    )
}

/**
 * [Material Design outlined text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段供用户在界面中输入文本，通常出现在表单和对话框中。描边文本字段的视觉强调程度低于填充文本字段；当它们成组出现在表单等场景时，这种较低的强调度有助于简化整体布局。
 *
 * ![Outlined text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/outlined-text-field.png)
 *
 * 该重载版本可访问输入文本、光标位置、选区范围以及 IME 组合状态。若仅需监听输入文本的变化，请改用参数为 [String] 的 OutlinedTextField 重载。
 *
 * @param 值 要在文本字段中显示的输入 [TextFieldValue]。
 * @param 值改变回调 当输入法服务更新 [TextFieldValue] 中的值时触发的回调，更新后的 [TextFieldValue] 会作为回调的参数传入。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制该文本字段的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
 * @param 只读 控制文本字段的只读状态。当设为 `true` 时，文本字段无法被修改，但用户仍可将其聚焦并复制其中的文本。只读文本字段通常用于展示用户不可编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
 * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当文本字段获得焦点且输入文本为空时，可选显示的占位文本。内部 [文本] 的默认文字样式为 [Typography.bodyLarge]。
 * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
 * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
 * @param 前缀 显示在文本字段输入文本之前的可选前缀。
 * @param 后缀 显示在文本字段输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。若设为 true，默认情况下标签、底部指示器和尾部图标都会以错误颜色显示。
 * @param 视觉转换 对输入的“值”进行视觉层面的转换。例如，可使用[PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * 来创建密码文本字段。默认不应用任何视觉转换。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 与 [ImeAction] 等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，会触发对应的回调。注意：此 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的值不同。
 * @param 单行 当设为 `true` 时，该文本字段变为单行水平滚动，不再自动换行；系统会通知键盘不显示回车键作为 [ImeAction]。
 * 注意：此时 [最大行数] 参数将被忽略，最大行数会自动设为 1。
 * @param 最大行数 文本框的最大高度，以最多可见行数表示。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 文本框的最小高度，以最少可见行数表示。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该文本字段的 [Interaction]。你可以借助它
 * 改变文本字段的外观，或在不同状态下预览文本字段。注意：即使传入 `null`，内部仍会发生交互。
 * @param 形状 定义该文本字段边框的形状。
 * @param 颜色 TextFieldColors，用于为 OutlinedTextField 的不同状态设置颜色。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 轮廓文本字段(
    值: TextFieldValue,
    值改变回调: (TextFieldValue) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = LocalTextStyle.current,
    标签: @Composable (() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    视觉转换: VisualTransformation = VisualTransformation.None,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    交互源: MutableInteractionSource? = null,
    形状: Shape = OutlinedTextFieldDefaults.shape,
    颜色: TextFieldColors = OutlinedTextFieldDefaults.colors(),
) {
    OutlinedTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        visualTransformation = 视觉转换,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        interactionSource = 交互源,
        shape = 形状,
        colors = 颜色,
    )
}



