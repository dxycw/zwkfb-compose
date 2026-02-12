package 安卓x.组合.基础.文本

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

/**
 * 基础文本组合件，提供一个可通过软件或硬件键盘输入文本的交互框，但不提供任何装饰（如提示或占位文本）。
 *
 * 该组合件的所有编辑状态都通过 [状态] 进行 hoist。每当用户输入或语义操作导致内容变化时，[TextFieldState.text] 会同步更新；
 * 同样，对 [状态] 的任何程序化修改也会立即反映到组合件上。
 *
 * 若想为文本框添加装饰（如图标等）并扩大点击响应区域，请使用装饰器（decorator）。
 *
 * 如需对用户输入进行过滤（例如仅允许数字、限制字符数）或修改（例如将所有字符转为大写），请使用 [InputTransformation]。
 *
 * 可通过 [TextFieldLineLimits] 按行数限制 [基本文本字段] 的高度，并选择滚动方向。
 *
 * 组合件的滚动状态也被提升（hoisted），以便开发者观察和操控滚动行为，例如：在不聚焦的情况下通过滚动将搜索到的关键字带入视野或调整选区位置
 *
 * 也可以对现有的 TextFieldState 进行内部封装，并通过一个“值”来驱动 TextField 的内容，同时提供一个 onValueChange 回调将变更通知出去，从而实现更轻量的状态 hoist 机制。
 *
 * @param 状态 保存 [基本文本字段] 内部编辑状态的 [TextFieldState] 对象。
 * @param 修饰符 该文本框的可选 [Modifier]。
 * @param 已启用 控制 [基本文本字段] 的启用状态。当值为 `false` 时，文本框既不可编辑也无法获得焦点，且其中的文本将无法被选中。
 * @param 只读 控制 [基本文本字段] 的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。
 * 只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 输入转换 可选的 [InputTransformation]，用于对用户引发的 [TextFieldState] 变更进行转换。该转换会作用于：硬件与软件键盘输入,
 * 粘贴或拖放文本,无障碍服务操作,测试代码产生的修改,以下情况**不会**应用转换：程序化地直接修改 [状态],转换规则本身被更换时,
 * 若在已有文本框上更换转换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
 * @param 文本样式 编辑器中所显示文本的排版与图形样式配置。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作回调 当用户在输入法编辑器（IME）中点击动作按钮，或在硬件键盘上按回车键（且 [行限制] 为 [SingleLine]）时调用。
 * 默认值为 null，此时会执行接收到 IME Action 的默认行为：[ImeAction.Done] 收起键盘,[ImeAction.Next] 将焦点切换到屏幕上下一个可聚焦项
 * @param 行限制 控制文本框是 [SingleLine]（单行，水平滚动，忽略换行），还是 [MultiLine]（多行，垂直扩展并滚动）。若传入 [SingleLine]，
 * 文本中的所有换行符（'\n'）将被替换为普通空格（' '），确保内容始终单行显示。
 * @param 文本布局回调 当文本布局变得可查询时执行的回调。该回调会收到一个函数：若布局可计算，此函数返回 [TextLayoutResult]；若无法计算，则返回 null。
 * 该函数从快照状态对象中读取布局结果，并在布局结果变化时使其调用方失效。[TextLayoutResult] 包含段落信息、文本尺寸、基线位置等详细数据。
 * 借助此回调，可为文本添加额外装饰或功能，例如在文本周围绘制光标或选区。[Density] 作用域即为创建该文本布局时所使用的密度环境。
 * @param 交互源 用于表示该 TextField 的 [Interaction] 流的 [MutableInteractionSource]。如果你想观察 [Interaction]
 * 并根据不同的 [Interaction] 自定义此 TextField 的外观或行为，可以创建并传入自己记住的 [MutableInteractionSource]。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 输出转换 一个 [OutputTransformation]，用于改变文本框内容的呈现方式。
 * @param 装饰 允许在文本框四周添加装饰元素（如图标、占位文本、辅助消息等），并自动扩大文本框的点击响应区域。
 * @param 滚动状态 管理 TextField 水平或垂直滚动的滚动状态。若 [行限制] 为 [SingleLine]，则文本框按单行处理，
 * 具备水平滚动行为；否则文本框变为垂直滚动。
 */
// 虽然它接收一个 composable lambda，但它本质上并不是一个“容器”组件。
@Suppress("ComposableLambdaParameterPosition","ComposableNaming","ModifierParameter")
@Composable
fun 基本文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    输入转换: InputTransformation? = null,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作回调: KeyboardActionHandler? = null,
    行限制: TextFieldLineLimits = TextFieldLineLimits.Default,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    输出转换: OutputTransformation? = null,
    装饰: TextFieldDecorator? = null,
    滚动状态: ScrollState = rememberScrollState(),
) {
    BasicTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        inputTransformation = 输入转换,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        lineLimits = 行限制,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        outputTransformation = 输出转换,
        decorator = 装饰,
        scrollState = 滚动状态,
    )
}



/**
 * 基础组合件，允许用户通过硬件或软件键盘编辑文本，但不提供任何装饰（如提示或占位文本）。
 *
 * 每当用户编辑文本时，都会通过 [值改变回调] 回调返回最新的 [String] 状态，开发者应据此更新自己的状态。
 *
 * 与 [TextFieldValue] 重载不同，该组合件不允许开发者控制选区、光标及文本合成信息。如需相关功能，请参见 [TextFieldValue] 及对应的 [基本文本字段] 重载。
 *
 * 务必把 `onValueChange` 收到的新值**立刻**（下一帧之前）回传给 `BasicTextField`，否则会出现光标跳动、文字闪烁等异常。
 * 回传值可以**不同于**回调给出的原始值（例如做过滤），但频繁改动会导致输入法重连、键盘闪烁，因此只建议在需要过滤/替换场景下使用，普通自由输入不应每次都改值。
 *
 * 该组合件仅提供基础文本编辑能力，不带任何装饰（边框、提示/占位文本等）。大多数场景应直接使用基于设计系统的实现（如 Material Design 的填充文本框）。
 * 只有当需要为其它设计系统做自定义实现时，才应使用此基础组合件。
 *
 * 例如，若需要在 TextField 里加入占位文本，可借助 decoration box 这样编写组合件：
 *
 * 如果想给文本框添加装饰（如图标等）并扩大点击响应区域，请使用 decoration box：
 *
 * 如需创建格式化文本框（例如输入电话号码或社会保障号），可使用 [视觉转换] 参数。下方是输入信用卡号的示例：
 *
 * 注意：该重载不支持 [KeyboardOptions.showKeyboardOnFocus]。
 *
 * @param 值 要在文本框中显示的输入字符串。
 * @param 值改变回调 当输入服务更新文本时触发的回调，更新后的文本会作为参数传入。
 * @param 修饰符 该文本框的可选 [Modifier]。
 * @param 已启用 控制 [基本文本字段] 的启用状态。当值为 `false` 时，文本框不可编辑且无法获得焦点，其中的文本也无法被选中。
 * @param 只读 控制 [基本文本字段] 的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。
 * 只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 文本样式 作用于字符级别的样式配置，如颜色、字体等。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，将触发对应的回调。注意，该 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的不一致。
 * @param 单行 设为 true 时，文本框变为单行水平滚动，不再自动换行；键盘也会隐藏回车键，并将 [最大行数] 与 [最小行数] 自动设为 1。
 * @param 最大行数 文本框的最大高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 最小行数 文本框的最小高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 视觉转换 用于改变输入内容视觉表现的转换过滤器；默认不应用任何视觉转换。
 * @param 文本布局回调 当新的文本布局被计算完成后触发的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线位置等详细数据，
 * 可用来为文本添加额外装饰或功能，例如绘制光标或选区。
 * @param 交互源 一个可选的提升（hoisted）[MutableInteractionSource]，用于观察并发送该文本框的 [Interaction]。
 * 你可以借助它在不同状态下改变文本框的外观或进行预览。注意，即使传入 `null`，交互事件仍会在内部发生。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是 [Color.Unspecified] 的 [SolidColor]，将不绘制光标。
 * @param 装饰盒 Composable lambda，用来在文本框四周添加装饰（图标、占位文本、辅助消息等），并自动扩大点击响应区域。为了让你控制内部
 * 文本框与装饰的相对位置，框架会把由系统管理的 composable 参数 `innerTextField` 传给你提供的 decorationBox lambda。
 * 你必须**且只能**调用一次 `innerTextField`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 基本文本字段(
    值: String,
    值改变回调: (String) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    视觉转换: VisualTransformation = VisualTransformation.None,
    文本布局回调: (TextLayoutResult) -> Unit = {},
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰盒: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
) {
    BasicTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        visualTransformation = 视觉转换,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorationBox = 装饰盒,
    )
}

/**
 * 基础组合件，允许用户通过硬件或软件键盘编辑文本，但不提供任何装饰（如提示或占位文本）。
 *
 * 每当用户编辑文本时，都会通过 [值改变回调] 回调返回最新的 [TextFieldValue] 状态，其中包含用户输入的文本，以及选区、光标和文本合成信息。
 * 有关详细内容，请参见 [TextFieldValue] 的说明。
 *
 * 务必把 `值改变回调` 收到的新值**立刻**（下一帧之前）回传给 `基本文本字段`，否则会出现光标跳动、文字闪烁等异常。回传值可以**不同于**回调
 * 给出的原始值（例如做过滤），但频繁改动会导致输入法重连、键盘闪烁，因此只建议在需要过滤/替换场景下使用，普通自由输入不应每次都改值。
 *
 * 该组合件仅提供基础文本编辑能力，不带任何装饰（边框、提示/占位文本等）。大多数场景应直接使用基于设计系统的实现（如 Material Design 的填充文本框）。
 * 只有当需要为其它设计系统做自定义实现时，才应使用此基础组合件。
 *
 * 例如，若需要在 TextField 里加入占位文本，可借助 decoration box 这样编写组合件：
 *
 * 如果想给文本框添加装饰（如图标等）并扩大点击响应区域，请使用 decoration box：
 *
 * 注意：该重载不支持 [KeyboardOptions.showKeyboardOnFocus]。
 *
 * @param 值 要在 [基本文本字段] 中显示的 [androidx.compose.ui.text.input.TextFieldValue]。
 * @param 值改变回调 当输入服务更新 [TextFieldValue] 中的值时调用。
 * @param 修饰符 该文本框的可选 [Modifier]。
 * @param 已启用 控制 [基本文本字段] 的启用状态。当值为 `false` 时，文本框不可编辑且无法获得焦点，其中的文本也无法被选中。
 * @param 只读 控制 [基本文本字段] 的编辑状态。当值为 `true` 时，文本框内容不可被用户修改，但仍可获得焦点并复制其中的文本。
 * 只读文本框通常用于展示用户无法编辑的预填表单。
 * @param 文本样式 作用于字符级别的样式配置，如颜色、字体等。
 * @param 键盘选项 软件键盘选项，包含 [KeyboardType]（键盘类型）和 [ImeAction]（输入法动作）等配置。
 * @param 键盘操作 当输入法发出 IME 动作时，将触发对应的回调。注意，该 IME 动作可能与你在 [KeyboardOptions.imeAction] 中指定的不一致。
 * @param 单行 设为 true 时，文本框变为单行水平滚动，不再自动换行；键盘也会隐藏回车键，并将 [最大行数] 与 [最小行数] 自动设为 1。
 * @param 最大行数 文本框的最大高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 最小行数 文本框的最小高度，以可见行数计。必须满足 1 ≤ [最小行数] ≤ [最大行数]。当 [单行] 为 true 时，此参数被忽略。
 * @param 视觉转换 用于改变输入内容视觉表现的转换过滤器；默认不应用任何视觉转换。
 * @param 文本布局回调 当新的文本布局被计算完成后触发的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线位置等详细数据，
 * 可用来为文本添加额外装饰或功能，例如绘制光标或选区。
 * @param 交互源 一个可选的提升（hoisted）[MutableInteractionSource]，用于观察并发送该文本框的 [Interaction]。
 * 你可以借助它在不同状态下改变文本框的外观或进行预览。注意，即使传入 `null`，交互事件仍会在内部发生。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是 [Color.Unspecified] 的 [SolidColor]，将不绘制光标。
 * @param 装饰盒 Composable lambda，用来在文本框四周添加装饰（图标、占位文本、辅助消息等），并自动扩大点击响应区域。为了让你控制内部
 * 文本框与装饰的相对位置，框架会把由系统管理的 composable 参数 `innerTextField` 传给你提供的 decorationBox lambda。
 * 你必须**且只能**调用一次 `innerTextField`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 基本文本字段(
    值: TextFieldValue,
    值改变回调: (TextFieldValue) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    视觉转换: VisualTransformation = VisualTransformation.None,
    文本布局回调: (TextLayoutResult) -> Unit = {},
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰盒: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
) {
    BasicTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        visualTransformation = 视觉转换,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorationBox = 装饰盒,
    )
}


