package 安卓x.组合.材质3

import androidx.compose.foundation.ScrollState
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
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

/**
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本框允许用户在界面中输入文本，通常出现在表单和对话框中。填充式文本框比边框式文本框更具视觉强调效果，能在周围内容和组件中更显眼。
 *
 * ![Filled text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如果你需要带边框的版本，请参见 [OutlinedTextField]；如需专为密码或其他敏感内容设计的文本框，请参见 [SecureTextField]。
 *
 * 该 [TextField] 重载使用 [TextFieldState] 来记录文本内容以及光标或选区的位置。
 *
 * 一个简单的单行文本框如下：
 *
 * 你可以控制初始输入的文本和选区：
 *
 * 使用输入与输出转换来控制用户输入的内容及其显示效果：
 *
 * 你可以设置占位文本：
 *
 * 你还可以添加头部图标和尾部图标：
 *
 * 你也可以为文本添加前缀或后缀：
 *
 * 要处理输入错误状态，可使用 [是否错误] 参数：
 *
 * 此外，你还可以在底部显示额外的提示信息：
 *
 * 你可以通过修改内边距来创建紧凑的文本框：
 *
 * 在 IME 操作执行时隐藏软件键盘：
 *
 * @param 状态 [TextFieldState] 对象，用于保存文本框的内部编辑状态。
 * @param 修饰符 应用于该文本框的 [Modifier]。
 * @param 已启用 控制文本框的启用状态。当值为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，同时无障碍服务也会将其标记为已禁用。
 * @param 只读 控制文本框的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式。默认使用 [LocalTextStyle]。
 * @param 标签位置 标签的位置。详见 [TextFieldLabelPosition]。
 * @param 标签 可选的标签，与该文本框一起显示。默认文本样式：标签缩小时使用 [Typography.bodySmall]，标签展开时使用 [Typography.bodyLarge]
 * @param 占位符 可选的占位文本，当输入框为空时显示。默认文本样式为 [Typography.bodyLarge]。
 * @param 前导图标 可选的头部图标，显示在文本框容器的起始位置。
 * @param 尾随图标 可选的尾部图标，显示在文本框容器的末端。
 * @param 前缀 可选的前缀，显示在文本框输入文本之前。
 * @param 后缀 可选的后缀，显示在文本框输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本框下方。
 * @param 是否错误 标记文本框当前值是否处于错误状态。当值为 `true` 时，文本框各组件将以错误颜色显示，并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户引发的 [TextFieldState] 变更进行转换。该转换会作用于：
 * 硬件与软件键盘输入,粘贴或拖放文本 ,无障碍服务操作, 测试代码产生的修改以下情况**不会**应用转换：程序化地直接修改 [状态],转换规则本身被更换时 。
 * 若在已有文本框上更换转换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 输出转换 可选的 [OutputTransformation]，用于变换文本框内容的呈现方式。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在实体键盘上按下回车键时调用。默认情况下该参数为 null，
 * 此时会执行接收到 IME Action 的默认行为，例如：[ImeAction.Done] 会收起键盘.[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦项.
 * @param 行限制 指定文本框应为 [SingleLine]（单行，水平滚动，忽略换行），还是 [MultiLine]（多行，垂直扩展并滚动）。
 * 若传入 [SingleLine]，文本中的所有换行符（'\n'）将被替换为普通空格（' '）。
 * @param 文本布局回调 当文本布局变得可查询时执行的回调。该回调会收到一个函数：若布局可计算，此函数返回 [TextLayoutResult]；
 * 若无法计算，则返回 null。该函数从快照状态对象中读取布局结果，并在布局结果变化时使其调用方失效。[TextLayoutResult] 包含段落信息、
 * 文本尺寸、基线位置等详细数据。回调提供的 [Density] 作用域即为创建该文本布局时所使用的密度环境。
 * @param 滚动状态 用于管理文本框水平或垂直滚动的滚动状态。若 [行限制] 为 [SingleLine]，则该文本框被视为单行，具备水平滚动行为；否则，文本框将支持垂直滚动。
 * @param 形状 定义该文本框容器的外形轮廓。
 * @param 颜色 用于在不同状态下解析该文本框颜色的 [TextFieldColors]。详见 [TextFieldDefaults.colors]。
 * @param 内容内边距 应用于内部文本框的内边距，用来把它与文本框周围的元素隔开。请注意，如果这些内边距值与文本框的尺寸约束或布局不兼容，
 * 可能不会被实际采用。详见 [TextFieldDefaults.contentPaddingWithLabel] 与 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 一个可选的提升（hoisted）[`MutableInteractionSource`]，用于观察并发出该文本框的 [`Interaction`]。
 * 你可以借助它改变文本框的外观，或在不同状态下预览文本框。注意，即使传入 `null`，交互事件仍会在内部发生。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
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
    TextField(
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
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本框允许用户在界面中输入文本，通常出现在表单和对话框中。填充式文本框比边框式文本框更具视觉强调效果，能在周围内容和组件中更显眼。
 *
 * ![Filled text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如需带边框的版本，请参见 [OutlinedTextField]。
 *
 * 如果你除了监听文本变化外，还想观察光标位置、选区范围或 IME 组合输入，请改用带 [TextFieldValue] 参数的 TextField 重载。
 *
 * @param 值 要在文本框中显示的输入文本。
 * @param 值改变回调 当输入服务更新文本时触发的回调，更新后的文本会作为回调的参数传入。
 * @param 修饰符 应用于该文本框的 [Modifier]。
 * @param 已启用 控制文本框的启用状态。当值为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，同时无障碍服务也会将其标记为已禁用。
 * @param 只读 控制文本框的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式。默认使用 [LocalTextStyle]。
 * @param 标签 可选的标签，与该文本框一起显示。默认文本样式：标签缩小时使用 [Typography.bodySmall]，标签展开时使用 [Typography.bodyLarge]
 * @param 占位符 可选的占位文本，在文本框获得焦点且输入为空时显示。内部 [文本] 的默认样式为 [Typography.bodyLarge]。
 * @param 前导图标 可选的头部图标，显示在文本框容器的起始位置。
 * @param 尾随图标 可选的尾部图标，显示在文本框容器的末端。
 * @param 前缀 可选的前缀，显示在文本框输入文本之前。
 * @param 后缀 可选的后缀，显示在文本框输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本框下方。
 * @param 是否错误 标记文本框当前值是否处于错误状态。若设为 true，标签、底部指示器及尾部图标默认将以错误色显示。
 * @param 视觉转换 对输入的 [值] 进行视觉转换。例如，可使用 [PasswordVisualTransformation] 创建密码文本框。默认不应用任何视觉转换。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，将触发对应的回调。注意：该 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的不一致。
 * @param 单行 当设为 `true` 时，文本框变为单行水平滚动，不再自动换行；系统也会隐藏键盘上的回车键，并将 最大行数 强制设为 1。
 * @param 最大行数 文本框的最大高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 最小行数 文本框的最小高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 交互源 一个可选的提升（hoisted）[`MutableInteractionSource`]，用于观察并发出该文本框的 [`Interaction`]。
 * 你可以借助它改变文本框的外观，或在不同状态下预览文本框。注意，即使传入 `null`，交互事件仍会在内部发生。
 * @param 形状 定义该文本框容器的外形轮廓。
 * @param 颜色 用于在不同状态下解析该文本框颜色的 [TextFieldColors]。详见 [TextFieldDefaults.colors]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
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
    形状: Shape = TextFieldDefaults.shape,
    颜色: TextFieldColors = TextFieldDefaults.colors(),
) {
    TextField(
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
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本框允许用户在界面中输入文本，通常出现在表单和对话框中。填充式文本框比边框式文本框更具视觉强调效果，能在周围内容和组件中更显眼。
 *
 * ![Filled text fieldimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如需带边框的版本，请参见 [OutlinedTextField]。
 *
 * 该重载可访问输入文本、光标位置、选区范围及 IME 组合输入。若只需监听文本变化，请使用带 [String] 参数的 TextField 重载。
 *
 * @param 值 要在文本框中显示的输入 [TextFieldValue]。
 * @param 值改变回调 当输入服务更新 [TextFieldValue] 中的值时触发的回调，更新后的 [TextFieldValue] 会作为回调的参数传入。
 * @param 修饰符 应用于该文本框的 [Modifier]。
 * @param 已启用 控制文本框的启用状态。当值为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，同时无障碍服务也会将其标记为已禁用。
 * @param 只读 控制文本框的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 文本样式 应用于输入文本的样式。默认使用 [LocalTextStyle]。
 * @param 标签 可选的标签，与该文本框一起显示。默认文本样式：标签缩小时使用 [Typography.bodySmall]，标签展开时使用 [Typography.bodyLarge]
 * @param 占位符 可选的占位文本，在文本框获得焦点且输入为空时显示。内部 [文本] 的默认样式为 [Typography.bodyLarge]。
 * @param 前导图标 可选的头部图标，显示在文本框容器的起始位置。
 * @param 尾随图标 可选的尾部图标，显示在文本框容器的末端。
 * @param 前缀 可选的前缀，显示在文本框输入文本之前。
 * @param 后缀 可选的后缀，显示在文本框输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本框下方。
 * @param 是否错误 指示文本框当前值是否处于错误状态。若设为 true，标签、底部指示器和尾部图标默认将以错误颜色显示。
 * @param 视觉转换 对输入的 [值] 进行视觉转换。例如，可使用 [PasswordVisualTransformation] 创建密码文本框。默认不应用任何视觉转换。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，将触发对应的回调。注意：该 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的不一致。
 * @param 单行 当设为 `true` 时，文本框变为单行水平滚动，不再自动换行；系统也会隐藏键盘上的回车键，并将 最大行数 强制设为 1。
 * @param 最大行数 文本框的最大高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 最小行数 文本框的最小高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 交互源 一个可选的提升（hoisted）[`MutableInteractionSource`]，用于观察并发出该文本框的 [`Interaction`]。
 * 你可以借助它改变文本框的外观，或在不同状态下预览文本框。注意，即使传入 `null`，交互事件仍会在内部发生。
 * @param 形状 定义该文本框容器的外形轮廓。
 * @param 颜色 用于在不同状态下解析该文本框颜色的 [TextFieldColors]。详见 [TextFieldDefaults.colors]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
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
    形状: Shape = TextFieldDefaults.shape,
    颜色: TextFieldColors = TextFieldDefaults.colors(),
) {
    TextField(
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




