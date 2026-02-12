package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 提供 [文本字段] 使用的默认值。[轮廓文本字段] 的默认值参见 [OutlinedTextFieldDefaults]。
 */
@Immutable
object 文本字段默认值 { // TextFieldDefaults
    /** 文本字段 的默认形状。 */
    val 形状: Shape
        @Composable get() = TextFieldDefaults.shape

    /**
     * 文本字段的默认最小高度。注意：你可以直接在文本字段上应用 Modifier.heightIn 来覆盖该值。
     */
    val 最小高度 = TextFieldDefaults.MinHeight

    /**
     * 文本字段的默认最小宽度。注意：你可以直接在文本字段上应用 Modifier.widthIn 来覆盖该值。
     */
    val 最小宽度 = TextFieldDefaults.MinWidth

    /** 文本字段在未聚焦状态下指示线的默认粗细。 */
    val 未聚焦指示器厚度 = TextFieldDefaults.UnfocusedIndicatorThickness

    /** 文本字段在聚焦状态下指示线的默认粗细。 */
    val 聚焦指示器厚度 = TextFieldDefaults.FocusedIndicatorThickness

    /**
     * 用于基于 Material Design 填充文本字段创建自定义文本字段的装饰器。
     * [Material Design filled text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [文本字段] 未暴露的元素（如指示线厚度），可使用此装饰器来实现所需设计。
     *
     * 例如，若想自定义底部指示线，可向该装饰器的 [容器] 参数传入自定义的 [容器]。
     *
     * 此装饰器应与接受 [TextFieldDecorator] 参数的 [BasicTextField] 重载版本配合使用。如需使用 `decorationBox`
     * 的其它 [BasicTextField] 重载，请参见 [DecorationBox]。
     *
     * @param 状态 保存文本字段内部编辑状态的 [TextFieldState] 对象。
     * @param 已启用 文本字段的启用状态。当设为 `false` 时，该装饰器将呈现视觉禁用状态。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 行限制 文本字段是 [SingleLine] 还是 [MultiLine]。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 输出转换 用于转换文本字段内容展示方式的 [OutputTransformation]。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 交互源 只读的 [InteractionSource]，代表该文本字段的交互事件流。你必须先自行创建并通过 `remember`
     * 得到一个 [MutableInteractionSource] 实例，将其传给 [BasicTextField] 以派发事件；随后把同一实例再传给此装饰器，即可观察
     * [Interaction] 并在不同状态下自定义文本字段的外观与行为。
     * @param 标签位置 标签的位置，参见 [TextFieldLabelPosition]。
     * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当输入文本为空时可选显示的占位文本，默认文字样式为 [Typography.bodyLarge]。
     * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
     * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
     * @param 前缀 显示在文本字段输入文本之前的可选前缀。
     * @param 后缀 显示在文本字段输入文本之后的可选后缀。
     * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，该装饰器将以错误颜色显示其内容。
     * @param 颜色 用于在不同状态下解析该文本字段装饰器颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰器内部元素的颜色；[BasicTextField] 自身的元素（如文字颜色、光标颜色）不受影响，需通过 [BasicTextField] 的相关参数单独设置。
     * @param 内容内边距 输入框与装饰器周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
     * 参见 [TextFieldDefaults.contentPaddingWithLabel] 与 [TextFieldDefaults.contentPaddingWithoutLabel]。
     * @param 容器 绘制在文本字段背后的容器，默认使用 [容器]，其默认颜色取自 [颜色]。
     */
    @Composable
    fun 装饰(
        状态: TextFieldState,
        已启用: Boolean,
        行限制: TextFieldLineLimits,
        输出转换: OutputTransformation?,
        交互源: InteractionSource,
        标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
        标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        是否错误: Boolean = false,
        颜色: TextFieldColors = 颜色(),
        内容内边距: PaddingValues =
            if (标签 == null || 标签位置 is TextFieldLabelPosition.Above) {
                内容内边距无标签()
            } else {
                内容内边距带标签()
            },
        容器: @Composable () -> Unit = {
            容器(
                已启用 = 已启用,
                是否错误 = 是否错误,
                交互源 = 交互源,
                颜色 = 颜色,
                形状 = 形状,
                聚焦指示线厚度 = 聚焦指示器厚度,
                非聚焦指示线厚度 = 未聚焦指示器厚度,
            )
        },
    ): TextFieldDecorator =
        TextFieldDefaults.decorator(
            state = 状态,
            enabled = 已启用,
            lineLimits = 行限制,
            outputTransformation = 输出转换,
            interactionSource = 交互源,
            labelPosition = 标签位置,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            isError = 是否错误,
            colors = 颜色,
            contentPadding = 内容内边距,
            container = 容器,
        )



    /**
     * 该组合项为 [文本字段] 绘制默认容器，并在底部带一条指示线。可通过 [decorator] 或 [DecorationBox] 将其应用于
     * [BasicTextField]，以基于 Material 填充文本字段的样式创建自定义文本字段。[文本字段] 组件会自动应用它。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 交互源 文本字段的 [InteractionSource]，用于判断其是否处于聚焦状态。
     * @param 修饰符 此容器的 [Modifier]。
     * @param 颜色 用于解析文本字段颜色的 [TextFieldColors]。
     * @param 形状 此容器的形状。
     * @param 聚焦指示线厚度 文本字段聚焦时指示线的粗细。
     * @param 非聚焦指示线厚度 文本字段未聚焦时指示线的粗细。
     */
    @Composable
    fun 容器(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        修饰符: Modifier = Modifier,
        颜色: TextFieldColors = 颜色(),
        形状: Shape = TextFieldDefaults.shape,
        聚焦指示线厚度: Dp = 聚焦指示器厚度,
        非聚焦指示线厚度: Dp = 未聚焦指示器厚度,
    ) {
        TextFieldDefaults.Container(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色,
            shape = 形状,
            focusedIndicatorLineThickness = 聚焦指示线厚度,
            unfocusedIndicatorLineThickness = 非聚焦指示线厚度,
        )
    }

    /**
     * 为 [文本字段] 绘制默认底部指示线的修饰符。可将其应用于 [BasicTextField]，以基于 Material 填充文本字段的样式创建自定义文本字段。
     *
     * 建议使用 [容器]，它会自动应用该修饰符以及其它文本字段容器的样式。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 交互源 文本字段的 [InteractionSource]，用于判断其是否处于聚焦状态。
     * @param 颜色 用于解析文本字段颜色的 [TextFieldColors]。若为 `null`，则默认使用 [TextFieldDefaults.colors]。
     * @param 文本字段形状 文本字段容器的形状，用于裁剪指示线。若为 `null`，则默认使用 [TextFieldDefaults.shape]。
     * @param 聚焦指示线厚度 文本字段聚焦时指示线的粗细。
     * @param 未聚焦指示线厚度 文本字段未聚焦时指示线的粗细。
     */
    fun Modifier.指示线(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色: TextFieldColors? = null,
        文本字段形状: Shape? = null,
        聚焦指示线厚度: Dp = 聚焦指示器厚度,
        未聚焦指示线厚度: Dp = 未聚焦指示器厚度,
    ) = this.indicatorLine(
        enabled = 已启用,
        isError = 是否错误,
        interactionSource = 交互源,
        colors = 颜色,
        textFieldShape = 文本字段形状,
        focusedIndicatorLineThickness = 聚焦指示线厚度,
        unfocusedIndicatorLineThickness = 未聚焦指示线厚度,
        )

    /**
     * 用于基于 Material Design 填充文本字段创建自定义文本字段的装饰框。
     * [Material Design filled text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [文本字段] 未暴露的元素，可使用此装饰框来实现所需设计。
     *
     * 例如，若想自定义底部指示线，可向该装饰框的 [容器] 参数传入自定义的 [容器]。
     *
     * 此装饰框应与接受 `decorationBox` 参数的 [BasicTextField] 重载版本配合使用。如需使用 [TextFieldDecorator]
     * 的其它 [BasicTextField] 重载，请参见 [decorator]。
     *
     * @param 值 文本字段显示的输入字符串。
     * @param 内部文本字段 此装饰框包裹的输入文本字段。请从 [BasicTextField] 的 `decorationBox` lambda 中传入框架控制的 `innerTextField` 参数。
     * @param 已启用 文本字段的启用状态。当设为 `false` 时，此装饰框将呈现视觉禁用状态。该值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 单行 指示该文本字段是单行还是多行。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 视觉转换 对输入的 [值] 进行视觉转换。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 交互源 只读的 [InteractionSource]，代表该文本字段的交互事件流。你必须先自行创建并通过 `remember`
     * 得到一个 [MutableInteractionSource] 实例，将其传给 [BasicTextField] 以派发事件；随后把同一实例再传给此装饰框，即可观察
     * [Interaction] 并在不同状态下自定义文本字段的外观与行为。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，此装饰框将以错误颜色显示其内容。
     * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当文本字段获得焦点且输入文本为空时，可选显示的占位文本。内部 [文本] 的默认文字样式为 [Typography.bodyLarge]。
     * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
     * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
     * @param 前缀 显示在文本字段输入文本之前的可选前缀。
     * @param 后缀 显示在文本字段输入文本之后的可选后缀。
     * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
     * @param 形状 定义此装饰框容器的形状。
     * @param 颜色 用于在不同状态下解析该文本字段装饰框颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框内部元素的颜色；[BasicTextField] 自身的元素（如文字颜色、光标颜色）不受影响，需通过 [BasicTextField] 的相关参数单独设置。
     * @param 内容内边距 输入框与装饰框周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
     * 参见 [TextFieldDefaults.contentPaddingWithLabel] 与 [TextFieldDefaults.contentPaddingWithoutLabel]。
     * @param 容器 绘制在文本字段背后的容器，默认使用 [容器]，其默认颜色取自 [颜色]。
     */
    @Composable
    fun 装饰盒(
        值: String,
        内部文本字段: @Composable () -> Unit,
        已启用: Boolean,
        单行: Boolean,
        视觉转换: VisualTransformation,
        交互源: InteractionSource,
        是否错误: Boolean = false,
        标签: @Composable (() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        形状: Shape = TextFieldDefaults.shape,
        颜色: TextFieldColors = 颜色(),
        内容内边距: PaddingValues =
            if (标签 == null) {
                内容内边距无标签()
            } else {
                内容内边距带标签()
            },
        容器: @Composable () -> Unit = {
            容器(
                已启用 = 已启用,
                是否错误 = 是否错误,
                交互源 = 交互源,
                修饰符 = Modifier,
                颜色 = 颜色,
                形状 = 形状,
                聚焦指示线厚度 = 聚焦指示器厚度,
                非聚焦指示线厚度 = 未聚焦指示器厚度,
            )
        },
    ) {
        TextFieldDefaults.DecorationBox(
            value = 值,
            innerTextField = 内部文本字段,
            enabled = 已启用,
            singleLine = 单行,
            visualTransformation = 视觉转换,
            interactionSource = 交互源,
            isError = 是否错误,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            shape = 形状,
            colors = 颜色,
            contentPadding = 内容内边距,
            container = 容器,
        )
    }

    /**
     * TextField 带内标签时，输入框的默认内容内边距。注意：顶部内边距指标签在聚焦状态下上方的间距，输入框紧贴标签下方放置。
     *
     * 水平内边距表示输入框与前置/后置图标（如有）之间的距离；若无图标，则为与容器水平边缘的距离。
     */
    fun 内容内边距带标签(
        开始: Dp = 16.dp,
        结束: Dp = 16.dp,
        上: Dp = 8.dp,
        下: Dp = 8.dp,
    ): PaddingValues = TextFieldDefaults.contentPaddingWithLabel(开始, 上, 结束, 下)

    /**
     * 当标签为 null 或位于 [TextFieldLabelPosition.Above] 时，TextField 输入框的默认内容内边距。
     *
     * 水平内边距表示输入框与前置/后置图标（如有）之间的距离；若无图标，则为与容器水平边缘的距离。
     */
    fun 内容内边距无标签(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues = TextFieldDefaults.contentPaddingWithoutLabel(开始, 上, 结束, 下)

    /**
     * 创建一个 [TextFieldColors]，表示 TextField 中使用的默认输入文本、容器及内容颜色（包括标签、占位符、图标等）。
     */
    @Composable
    fun 颜色() = TextFieldDefaults.colors()

    /**
     * 创建一个 [TextFieldColors]，表示 TextField 中使用的默认输入文本、容器及内容颜色（包括标签、占位符、图标等）。
     *
     * @param 聚焦文本颜色 文本字段聚焦时输入文本的颜色。
     * @param 非聚焦文本颜色 文本字段未聚焦时输入文本的颜色。
     * @param 禁用文本颜色 文本字段禁用时输入文本的颜色。
     * @param 错误文本颜色 文本字段处于错误状态时输入文本的颜色。
     * @param 聚焦容器颜色 文本字段聚焦时的容器颜色。
     * @param 非聚焦容器颜色 文本字段未聚焦时的容器颜色。
     * @param 禁用容器颜色 文本字段禁用时的容器颜色。
     * @param 错误容器颜色 文本字段处于错误状态时的容器颜色。
     * @param 光标颜色 文本字段的光标颜色。
     * @param 错误光标颜色 文本字段处于错误状态时的光标颜色。
     * @param 选择颜色 文本字段输入文本被选中时的颜色。
     * @param 聚焦指示器颜色 文本字段聚焦时的指示线颜色。
     * @param 非聚焦指示器颜色 文本字段未聚焦时的指示线颜色。
     * @param 禁用指示器颜色 文本字段禁用时的指示线颜色。
     * @param 错误指示器颜色 文本字段处于错误状态时的指示线颜色。
     * @param 聚焦前导图标颜色 文本字段聚焦时前置图标的颜色。
     * @param 非聚焦前导图标颜色 文本字段未聚焦时前置图标的颜色。
     * @param 禁用前导图标颜色 文本字段禁用时前置图标的颜色。
     * @param 错误前导图标颜色 文本字段处于错误状态时前置图标的颜色。
     * @param 聚焦尾随图标颜色 文本字段聚焦时尾部图标的颜色。
     * @param 非聚焦尾随图标颜色 文本字段未聚焦时尾部图标的颜色。
     * @param 禁用尾随图标颜色 文本字段禁用时尾部图标的颜色。
     * @param 错误尾随图标颜色 文本字段处于错误状态时尾部图标的颜色。
     * @param 聚焦标签颜色 文本字段聚焦时标签的颜色。
     * @param 非聚焦标签颜色 文本字段未聚焦时标签的颜色。
     * @param 禁用标签颜色 文本字段禁用时标签的颜色。
     * @param 错误标签颜色 文本字段处于错误状态时标签的颜色。
     * @param 聚焦占位符颜色 文本字段聚焦时占位符的颜色。
     * @param 非聚焦占位符颜色 文本字段未聚焦时占位符的颜色。
     * @param 禁用占位符颜色 文本字段禁用时占位符的颜色。
     * @param 错误占位符颜色 文本字段处于错误状态时占位符的颜色。
     * @param 聚焦辅助文本颜色 文本字段聚焦时辅助说明文字的颜色。
     * @param 非聚焦辅助文本颜色 文本字段未聚焦时辅助说明文字的颜色。
     * @param 禁用辅助文本颜色 文本字段禁用时辅助说明文字的颜色。
     * @param 错误辅助文本颜色 文本字段处于错误状态时辅助说明文字的颜色。
     * @param 聚焦前缀颜色 文本字段聚焦时前缀的颜色。
     * @param 非聚焦前缀颜色 文本字段未聚焦时前缀的颜色。
     * @param 禁用前缀颜色 文本字段禁用时前缀的颜色。
     * @param 错误前缀颜色 文本字段处于错误状态时前缀的颜色。
     * @param 聚焦后缀颜色 文本字段聚焦时后缀的颜色。
     * @param 非聚焦后缀颜色 文本字段未聚焦时后缀的颜色。
     * @param 禁用后缀颜色 文本字段禁用时后缀的颜色。
     * @param 错误后缀颜色 文本字段处于错误状态时后缀的颜色。
     */
    @Composable
    fun 颜色(
        聚焦文本颜色: Color = Color.Unspecified,
        非聚焦文本颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        错误文本颜色: Color = Color.Unspecified,
        聚焦容器颜色: Color = Color.Unspecified,
        非聚焦容器颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        错误容器颜色: Color = Color.Unspecified,
        光标颜色: Color = Color.Unspecified,
        错误光标颜色: Color = Color.Unspecified,
        选择颜色: TextSelectionColors? = null,
        聚焦指示器颜色: Color = Color.Unspecified,
        非聚焦指示器颜色: Color = Color.Unspecified,
        禁用指示器颜色: Color = Color.Unspecified,
        错误指示器颜色: Color = Color.Unspecified,
        聚焦前导图标颜色: Color = Color.Unspecified,
        非聚焦前导图标颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        错误前导图标颜色: Color = Color.Unspecified,
        聚焦尾随图标颜色: Color = Color.Unspecified,
        非聚焦尾随图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        错误尾随图标颜色: Color = Color.Unspecified,
        聚焦标签颜色: Color = Color.Unspecified,
        非聚焦标签颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        错误标签颜色: Color = Color.Unspecified,
        聚焦占位符颜色: Color = Color.Unspecified,
        非聚焦占位符颜色: Color = Color.Unspecified,
        禁用占位符颜色: Color = Color.Unspecified,
        错误占位符颜色: Color = Color.Unspecified,
        聚焦辅助文本颜色: Color = Color.Unspecified,
        非聚焦辅助文本颜色: Color = Color.Unspecified,
        禁用辅助文本颜色: Color = Color.Unspecified,
        错误辅助文本颜色: Color = Color.Unspecified,
        聚焦前缀颜色: Color = Color.Unspecified,
        非聚焦前缀颜色: Color = Color.Unspecified,
        禁用前缀颜色: Color = Color.Unspecified,
        错误前缀颜色: Color = Color.Unspecified,
        聚焦后缀颜色: Color = Color.Unspecified,
        非聚焦后缀颜色: Color = Color.Unspecified,
        禁用后缀颜色: Color = Color.Unspecified,
        错误后缀颜色: Color = Color.Unspecified,
    ): TextFieldColors =
        TextFieldDefaults.colors(
            focusedTextColor = 聚焦文本颜色,
            unfocusedTextColor = 非聚焦文本颜色,
            disabledTextColor = 禁用文本颜色,
            errorTextColor = 错误文本颜色,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 非聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
            errorContainerColor = 错误容器颜色,
            cursorColor = 光标颜色,
            errorCursorColor = 错误光标颜色,
            selectionColors = 选择颜色,
            focusedIndicatorColor = 聚焦指示器颜色,
            unfocusedIndicatorColor = 非聚焦指示器颜色,
            disabledIndicatorColor = 禁用指示器颜色,
            errorIndicatorColor = 错误指示器颜色,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 非聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            errorLeadingIconColor = 错误前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 非聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            errorTrailingIconColor = 错误尾随图标颜色,
            focusedLabelColor = 聚焦标签颜色,
            unfocusedLabelColor = 非聚焦标签颜色,
            disabledLabelColor = 禁用标签颜色,
            errorLabelColor = 错误标签颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 非聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            errorPlaceholderColor = 错误占位符颜色,
            focusedSupportingTextColor = 聚焦辅助文本颜色,
            unfocusedSupportingTextColor = 非聚焦辅助文本颜色,
            disabledSupportingTextColor = 禁用辅助文本颜色,
            errorSupportingTextColor = 错误辅助文本颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 非聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            errorPrefixColor = 错误前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 非聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            errorSuffixColor = 错误后缀颜色,
        )


    @Deprecated(
        message = "Renamed to TextFieldDefaults.Container",
        replaceWith =
            ReplaceWith(
                "Container(\n" +
                        "    enabled = enabled,\n" +
                        "    isError = isError,\n" +
                        "    interactionSource = interactionSource,\n" +
                        "    colors = colors,\n" +
                        "    shape = shape,\n" +
                        ")"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 容器盒(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色: TextFieldColors,
        形状: Shape = TextFieldDefaults.shape,
    ) =
        TextFieldDefaults.ContainerBox(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            colors = 颜色,
            shape = 形状,
        )

    @Deprecated(
        message = "Renamed to `OutlinedTextFieldDefaults.shape`",
        replaceWith =
            ReplaceWith(
                "OutlinedTextFieldDefaults.shape",
                "androidx.compose.material.OutlinedTextFieldDefaults",
            ),
        level = DeprecationLevel.WARNING,
    )
    val 轮廓形状: Shape
        @Composable get() = TextFieldDefaults.outlinedShape

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.shape`",
        replaceWith = ReplaceWith("TextFieldDefaults.shape"),
        level = DeprecationLevel.WARNING,
    )
    val 填充形状: Shape
        @Composable get() = TextFieldDefaults.filledShape

    @Deprecated(
        message =
            "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and " +
                    "`OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.",
        replaceWith = ReplaceWith("TextFieldDefaults.UnfocusedIndicatorThickness"),
        level = DeprecationLevel.WARNING,
    )
    val 非聚焦边框厚度 = TextFieldDefaults.UnfocusedBorderThickness

    @Deprecated(
        message =
            "Split into `TextFieldDefaults.FocusedIndicatorThickness` and " +
                    "`OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.",
        replaceWith = ReplaceWith("TextFieldDefaults.FocusedIndicatorThickness"),
        level = DeprecationLevel.WARNING,
    )
    val 聚焦边框厚度 = TextFieldDefaults.FocusedBorderThickness

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`",
        replaceWith =
            ReplaceWith(
                "TextFieldDefaults.contentPaddingWithLabel(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )"
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 文本字段带标签内边距(
        开始: Dp = 16.dp,
        结束: Dp = 16.dp,
        上: Dp = 8.dp,
        下: Dp = 8.dp,
    ): PaddingValues = TextFieldDefaults.textFieldWithLabelPadding(start = 开始, top = 上, end = 结束, bottom = 下)

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`",
        replaceWith =
            ReplaceWith(
                "TextFieldDefaults.contentPaddingWithoutLabel(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )"
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 文本字段无标签内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues =
        TextFieldDefaults.textFieldWithoutLabelPadding(start = 开始, top = 上, end = 结束, bottom = 下)

    @Deprecated(
        message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`",
        replaceWith =
            ReplaceWith(
                "OutlinedTextFieldDefaults.contentPadding(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )",
                "androidx.compose.material.OutlinedTextFieldDefaults",
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 轮廓文本字段内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues =
        TextFieldDefaults.outlinedTextFieldPadding(start = 开始, top = 上, end = 结束, bottom = 下,)
}

/**
 * 提供 [OutlinedTextField] 使用的默认值。[TextField] 的默认值参见 [TextFieldDefaults]。
 */
@Immutable
object 轮廓文本字段默认值 { //OutlinedTextFieldDefaults
    /** [OutlinedTextField] 的默认形状。 */
    val 形状: Shape
        @Composable get() = OutlinedTextFieldDefaults.shape

    /**
     * OutlinedTextField 的默认最小高度。注意：你可以直接在文本字段上应用 Modifier.heightIn 来覆盖该值。
     */
    val 最小高度 = OutlinedTextFieldDefaults.MinHeight

    /**
     * OutlinedTextField 的默认最小宽度。注意：你可以直接在文本字段上应用 Modifier.widthIn 来覆盖该值。
     */
    val 最小宽度 = OutlinedTextFieldDefaults.MinWidth

    /** OutlinedTextField 在未聚焦状态下边框的默认粗细。 */
    val 非聚焦边框厚度 = OutlinedTextFieldDefaults.UnfocusedBorderThickness

    /** OutlinedTextField 在聚焦状态下边框的默认粗细。 */
    val 聚焦边框厚度 = OutlinedTextFieldDefaults.FocusedBorderThickness

    /**
     * 用于基于 Material Design 描边文本字段创建自定义文本字段的装饰器。
     * [Material Design outlined text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 OutlinedTextField 未暴露的元素（如边框粗细），可使用此装饰器来实现所需设计。
     *
     * 例如，若想自定义边框粗细，可向该装饰框的 [容器] 参数传入自定义的 [容器]。
     *
     * 此装饰器应与接受 [TextFieldDecorator] 参数的 [BasicTextField] 重载版本配合使用。如需使用 `decorationBox`
     * 的其它 [BasicTextField] 重载，请参见 [DecorationBox]。
     *
     * @param 状态 保存文本字段内部编辑状态的 [TextFieldState] 对象。
     * @param 已启用 文本字段的启用状态。当设为 `false` 时，该装饰器将呈现视觉禁用状态。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 行限制 文本字段是 [SingleLine] 还是 [MultiLine]。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 输出转换 用于转换文本字段内容展示方式的 [OutputTransformation]。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 交互源 只读的 [InteractionSource]，代表该文本字段的交互事件流。你必须先自行创建并通过 `remember`
     * 得到一个 [MutableInteractionSource] 实例，将其传给 [BasicTextField] 以派发事件；随后把同一实例再传给此装饰器，即可观察 [Interaction]
     * 并在不同状态下自定义文本字段的外观与行为。
     * @param 标签位置 标签的位置，参见 [TextFieldLabelPosition]。
     * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当输入文本为空时可选显示的占位文本，默认文字样式为 [Typography.bodyLarge]。
     * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
     * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
     * @param 前缀 显示在文本字段输入文本之前的可选前缀。
     * @param 后缀 显示在文本字段输入文本之后的可选后缀。
     * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，该装饰器将以错误颜色显示其内容。
     * @param 颜色 用于在不同状态下解析该文本字段装饰器颜色的 [TextFieldColors]。参见 [OutlinedTextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框内部元素的颜色；[BasicTextField] 自身的元素（如文字颜色、光标颜色）不受影响，需通过 [BasicTextField] 的相关参数单独设置。
     * @param 内容内边距 输入框与装饰器周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
     * 参见 [OutlinedTextFieldDefaults.contentPadding]。
     * @param 容器 绘制在文本字段背后的容器。默认透明，仅含边框；框架会自动在边框上为 [标签] 留出缺口。容器的默认颜色取自 [颜色]。
     */
    @Composable
    fun 装饰(
        状态: TextFieldState,
        已启用: Boolean,
        行限制: TextFieldLineLimits,
        输出转换: OutputTransformation?,
        交互源: InteractionSource,
        标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
        标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        是否错误: Boolean = false,
        颜色: TextFieldColors = 颜色(),
        内容内边距: PaddingValues = 内容内边距(),
        容器: @Composable () -> Unit = {
            容器(
                已启用 = 已启用,
                是否错误 = 是否错误,
                交互源 = 交互源,
                颜色 = 颜色,
                形状 = 形状,
                聚焦指示线厚度 = 聚焦边框厚度,
                非聚焦指示线厚度 = 非聚焦边框厚度,
            )
        },
    ): TextFieldDecorator =
        OutlinedTextFieldDefaults.decorator(
            state = 状态,
            enabled = 已启用,
            lineLimits = 行限制,
            outputTransformation = 输出转换,
            interactionSource = 交互源,
            labelPosition = 标签位置,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            isError = 是否错误,
            colors = 颜色,
            contentPadding = 内容内边距,
            container = 容器,
        )



    /**
     * 该组合项为 [OutlinedTextField] 绘制默认容器，并带边框描边。可通过 [decorator] 或 [DecorationBox] 将其应用于
     * [BasicTextField]，以基于 Material 描边文本字段的样式创建自定义文本字段。[OutlinedTextField] 组件会自动应用它。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 交互源 文本字段的 [InteractionSource]，用于判断其是否处于聚焦状态。
     * @param 修饰符 此容器的 [Modifier]。
     * @param 颜色 用于解析文本字段颜色的 [TextFieldColors]。
     * @param 形状 此容器的形状。
     * @param 聚焦指示线厚度 文本字段聚焦时边框的粗细。
     * @param 非聚焦指示线厚度 文本字段未聚焦时边框的粗细。
     */
    @Composable
    fun 容器(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        修饰符: Modifier = Modifier,
        颜色: TextFieldColors = 颜色(),
        形状: Shape = OutlinedTextFieldDefaults.shape,
        聚焦指示线厚度: Dp = 聚焦边框厚度,
        非聚焦指示线厚度: Dp = 非聚焦边框厚度,
    ) {
        OutlinedTextFieldDefaults.Container(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色,
            shape = 形状,
            focusedBorderThickness = 聚焦指示线厚度,
            unfocusedBorderThickness = 非聚焦指示线厚度,
        )
    }

    /**
     * 用于基于 Material Design 描边文本字段创建自定义文本字段的装饰框。
     * [Material Design outlined text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 OutlinedTextField 未暴露的元素，可使用此装饰框来实现所需设计。
     *
     * 例如，若想自定义边框粗细，可向该装饰框的 [容器] 参数传入自定义的 [容器]。
     *
     * 此装饰框应与接受 `decorationBox` 参数的 [BasicTextField] 重载版本配合使用。如需使用 [TextFieldDecorator]
     * 的其它 [BasicTextField] 重载，请参见 [装饰]。
     *
     * @param 值 文本字段显示的输入字符串。
     * @param 内部文本字段 此装饰框包裹的输入文本字段。请从 [BasicTextField] 的 `decorationBox` lambda 中传入框架控制的 `innerTextField` 参数。
     * @param 已启用 文本字段的启用状态。当设为 `false` 时，此装饰框将呈现视觉禁用状态。该值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 单行 指示该文本字段是单行还是多行。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 视觉转换 对输入的 [值] 进行视觉转换。此值必须与传入 [BasicTextField] 的参数保持一致。
     * @param 交互源 只读的 [InteractionSource]，代表该文本字段的交互事件流。你必须先自行创建并通过 `remember`
     * 得到一个 [MutableInteractionSource] 实例，将其传给 [BasicTextField] 以派发事件；随后把同一实例再传给此装饰框，即可观察 [Interaction]
     * 并在不同状态下自定义文本字段的外观与行为。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设为 `true` 时，此装饰框将以错误颜色显示其内容。
     * @param 标签 与该文本字段一起显示的可选标签。默认文字样式：标签缩小时使用 [Typography.bodySmall]，展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当文本字段获得焦点且输入文本为空时，可选显示的占位文本。内部 [文本] 的默认文字样式为 [Typography.bodyLarge]。
     * @param 前导图标 显示在文本字段容器起始位置的可选前置图标。
     * @param 尾随图标 显示在文本字段容器末尾的可选后置图标。
     * @param 前缀 显示在文本字段输入文本之前的可选前缀。
     * @param 后缀 显示在文本字段输入文本之后的可选后缀。
     * @param 辅助文本 显示在文本字段下方的可选辅助说明文字。
     * @param 颜色 用于在不同状态下解析该文本字段装饰框颜色的 [TextFieldColors]。参见 [OutlinedTextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框内部元素的颜色；[BasicTextField] 自身的元素（如文字颜色、光标颜色）不受影响，需通过 [BasicTextField] 的相关参数单独设置。
     * @param 内容内边距 输入框与装饰框周围元素之间的内边距。若这些内边距值与文本字段的尺寸约束或布局不兼容，可能不会被完全应用。
     * 参见 [OutlinedTextFieldDefaults.contentPadding]。
     * @param 容器 绘制在文本字段背后的容器。默认透明，仅含边框；框架会自动在边框上为 [标签] 留出缺口。容器的默认颜色取自 [颜色]。
     */
    @Composable
    fun 装饰盒(
        值: String,
        内部文本字段: @Composable () -> Unit,
        已启用: Boolean,
        单行: Boolean,
        视觉转换: VisualTransformation,
        交互源: InteractionSource,
        是否错误: Boolean = false,
        标签: @Composable (() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        颜色: TextFieldColors = 颜色(),
        内容内边距: PaddingValues = 内容内边距(),
        容器: @Composable () -> Unit = {
            容器(
                已启用 = 已启用,
                是否错误 = 是否错误,
                交互源 = 交互源,
                修饰符 = Modifier,
                颜色 = 颜色,
                形状 = 形状,
                聚焦指示线厚度 = 聚焦边框厚度,
                非聚焦指示线厚度 = 非聚焦边框厚度,
            )
        },
    ) {
        OutlinedTextFieldDefaults.DecorationBox(
            value = 值,
            innerTextField = 内部文本字段,
            enabled = 已启用,
            singleLine = 单行,
            visualTransformation = 视觉转换,
            interactionSource = 交互源,
            isError = 是否错误,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            colors = 颜色,
            contentPadding = 内容内边距,
            container = 容器,
        )
    }

    /**
     * OutlinedTextField 输入框的默认内容内边距。
     *
     * 水平内边距表示输入框与前置/后置图标（如有）之间的距离；若无图标，则为与容器水平边缘的距离。
     */
    fun 内容内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues = OutlinedTextFieldDefaults.contentPadding(开始, 上, 结束, 下)

    /**
     * 创建一个 [TextFieldColors]，表示 OutlinedTextField 中使用的默认输入文本、容器及内容颜色（包括标签、占位符、图标等）。
     */
    @Composable
    fun 颜色() = OutlinedTextFieldDefaults.colors()

    /**
     * 创建一个 [TextFieldColors]，表示 OutlinedTextField 中使用的默认输入文本、容器及内容颜色（包括标签、占位符、图标等）。
     *
     * @param 聚焦文本颜色 文本字段聚焦时输入文本的颜色。
     * @param 非聚焦文本颜色 文本字段未聚焦时输入文本的颜色。
     * @param 禁用文本颜色 文本字段禁用时输入文本的颜色。
     * @param 错误文本颜色 文本字段处于错误状态时输入文本的颜色。
     * @param 聚焦容器颜色 文本字段聚焦时的容器颜色。
     * @param 非聚焦容器颜色 文本字段未聚焦时的容器颜色。
     * @param 禁用容器颜色 文本字段禁用时的容器颜色。
     * @param 错误容器颜色 文本字段处于错误状态时的容器颜色。
     * @param 光标颜色 文本字段的光标颜色。
     * @param 错误光标颜色 文本字段处于错误状态时的光标颜色。
     * @param 选择颜色 文本字段输入文本被选中时的颜色。
     * @param 聚焦边框颜色 文本字段聚焦时的边框颜色。
     * @param 非聚焦边框颜色 文本字段未聚焦时的边框颜色。
     * @param 禁用边框颜色 文本字段禁用时的边框颜色。
     * @param 错误边框颜色 文本字段处于错误状态时的边框颜色。
     * @param 聚焦前导图标颜色 文本字段聚焦时前置图标的颜色。
     * @param 非聚焦前导图标颜色 文本字段未聚焦时前置图标的颜色。
     * @param 禁用前导图标颜色 文本字段禁用时前置图标的颜色。
     * @param 错误前导图标颜色 文本字段处于错误状态时前置图标的颜色。
     * @param 聚焦尾随图标颜色 文本字段聚焦时尾部图标的颜色。
     * @param 非聚焦尾随图标颜色 文本字段未聚焦时尾部图标的颜色。
     * @param 禁用尾随图标颜色 文本字段禁用时尾部图标的颜色。
     * @param 错误尾随图标颜色 文本字段处于错误状态时尾部图标的颜色。
     * @param 聚焦标签颜色 文本字段聚焦时标签的颜色。
     * @param 非聚焦标签颜色 文本字段未聚焦时标签的颜色。
     * @param 禁用标签颜色 文本字段禁用时标签的颜色。
     * @param 错误标签颜色 文本字段处于错误状态时标签的颜色。
     * @param 聚焦占位符颜色 文本字段聚焦时占位符的颜色。
     * @param 非聚焦占位符颜色 文本字段未聚焦时占位符的颜色。
     * @param 禁用占位符颜色 文本字段禁用时占位符的颜色。
     * @param 错误占位符颜色 文本字段处于错误状态时占位符的颜色。
     * @param 聚焦辅助文本颜色 文本字段聚焦时辅助说明文字的颜色。
     * @param 非聚焦辅助文本颜色 文本字段未聚焦时辅助说明文字的颜色。
     * @param 禁用辅助文本颜色 文本字段禁用时辅助说明文字的颜色。
     * @param 错误辅助文本颜色 文本字段处于错误状态时辅助说明文字的颜色。
     * @param 聚焦前缀颜色 文本字段聚焦时前缀的颜色。
     * @param 非聚焦前缀颜色 文本字段未聚焦时前缀的颜色。
     * @param 禁用前缀颜色 文本字段禁用时前缀的颜色。
     * @param 错误前缀颜色 文本字段处于错误状态时前缀的颜色。
     * @param 聚焦后缀颜色 文本字段聚焦时后缀的颜色。
     * @param 非聚焦后缀颜色 文本字段未聚焦时后缀的颜色。
     * @param 禁用后缀颜色 文本字段禁用时后缀的颜色。
     * @param 错误后缀颜色 文本字段处于错误状态时后缀的颜色。
     */
    @Composable
    fun 颜色(
        聚焦文本颜色: Color = Color.Unspecified,
        非聚焦文本颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        错误文本颜色: Color = Color.Unspecified,
        聚焦容器颜色: Color = Color.Unspecified,
        非聚焦容器颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        错误容器颜色: Color = Color.Unspecified,
        光标颜色: Color = Color.Unspecified,
        错误光标颜色: Color = Color.Unspecified,
        选择颜色: TextSelectionColors? = null,
        聚焦边框颜色: Color = Color.Unspecified,
        非聚焦边框颜色: Color = Color.Unspecified,
        禁用边框颜色: Color = Color.Unspecified,
        错误边框颜色: Color = Color.Unspecified,
        聚焦前导图标颜色: Color = Color.Unspecified,
        非聚焦前导图标颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        错误前导图标颜色: Color = Color.Unspecified,
        聚焦尾随图标颜色: Color = Color.Unspecified,
        非聚焦尾随图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        错误尾随图标颜色: Color = Color.Unspecified,
        聚焦标签颜色: Color = Color.Unspecified,
        非聚焦标签颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        错误标签颜色: Color = Color.Unspecified,
        聚焦占位符颜色: Color = Color.Unspecified,
        非聚焦占位符颜色: Color = Color.Unspecified,
        禁用占位符颜色: Color = Color.Unspecified,
        错误占位符颜色: Color = Color.Unspecified,
        聚焦辅助文本颜色: Color = Color.Unspecified,
        非聚焦辅助文本颜色: Color = Color.Unspecified,
        禁用辅助文本颜色: Color = Color.Unspecified,
        错误辅助文本颜色: Color = Color.Unspecified,
        聚焦前缀颜色: Color = Color.Unspecified,
        非聚焦前缀颜色: Color = Color.Unspecified,
        禁用前缀颜色: Color = Color.Unspecified,
        错误前缀颜色: Color = Color.Unspecified,
        聚焦后缀颜色: Color = Color.Unspecified,
        非聚焦后缀颜色: Color = Color.Unspecified,
        禁用后缀颜色: Color = Color.Unspecified,
        错误后缀颜色: Color = Color.Unspecified,
    ): TextFieldColors =
        OutlinedTextFieldDefaults.colors(
            focusedTextColor = 聚焦文本颜色,
            unfocusedTextColor = 非聚焦文本颜色,
            disabledTextColor = 禁用文本颜色,
            errorTextColor = 错误文本颜色,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 非聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
            errorContainerColor = 错误容器颜色,
            cursorColor = 光标颜色,
            errorCursorColor = 错误光标颜色,
            selectionColors = 选择颜色,
            focusedBorderColor = 聚焦边框颜色,
            unfocusedBorderColor = 非聚焦边框颜色,
            disabledBorderColor = 禁用边框颜色,
            errorBorderColor = 错误边框颜色,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 非聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            errorLeadingIconColor = 错误前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 非聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            errorTrailingIconColor = 错误尾随图标颜色,
            focusedLabelColor = 聚焦标签颜色,
            unfocusedLabelColor = 非聚焦标签颜色,
            disabledLabelColor = 禁用标签颜色,
            errorLabelColor = 错误标签颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 非聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            errorPlaceholderColor = 错误占位符颜色,
            focusedSupportingTextColor = 聚焦辅助文本颜色,
            unfocusedSupportingTextColor = 非聚焦辅助文本颜色,
            disabledSupportingTextColor = 禁用辅助文本颜色,
            errorSupportingTextColor = 错误辅助文本颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 非聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            errorPrefixColor = 错误前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 非聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            errorSuffixColor = 错误后缀颜色,
        )

    @Deprecated(
        message = "Renamed to OutlinedTextFieldDefaults.Container",
        replaceWith =
            ReplaceWith(
                "Container(\n" +
                        "    enabled = enabled,\n" +
                        "    isError = isError,\n" +
                        "    interactionSource = interactionSource,\n" +
                        "    colors = colors,\n" +
                        "    shape = shape,\n" +
                        "    focusedBorderThickness = focusedBorderThickness,\n" +
                        "    unfocusedBorderThickness = unfocusedBorderThickness,\n" +
                        ")"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 容器盒(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色: TextFieldColors = 颜色(),
        形状: Shape = OutlinedTextFieldDefaults.shape,
        聚焦指示线厚度: Dp = 聚焦边框厚度,
        非聚焦指示线厚度: Dp = 非聚焦边框厚度,
    ) =
        OutlinedTextFieldDefaults.ContainerBox(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            colors = 颜色,
            shape = 形状,
            focusedBorderThickness = 聚焦指示线厚度,
            unfocusedBorderThickness = 非聚焦指示线厚度,
        )
}

/**
 * 表示文本字段在不同状态下，输入文本、容器及内容（包括标签、占位符、前置和后置图标）所使用的颜色。
 *
 * @param 聚焦文本颜色 文本字段聚焦时输入文本的颜色。
 * @param 非聚焦文本颜色 文本字段未聚焦时输入文本的颜色。
 * @param 禁用文本颜色 文本字段禁用时输入文本的颜色。
 * @param 错误文本颜色 文本字段处于错误状态时输入文本的颜色。
 * @param 聚焦容器颜色 文本字段聚焦时的容器颜色。
 * @param 非聚焦容器颜色 文本字段未聚焦时的容器颜色。
 * @param 禁用容器颜色 文本字段禁用时的容器颜色。
 * @param 错误容器颜色 文本字段处于错误状态时的容器颜色。
 * @param 光标颜色 文本字段的光标颜色。
 * @param 错误光标颜色 文本字段处于错误状态时的光标颜色。
 * @param 文本选择颜色 文本字段输入文本被选中时的颜色。
 * @param 聚焦指示器颜色 文本字段聚焦时的指示线颜色。
 * @param 非聚焦指示器颜色 文本字段未聚焦时的指示线颜色。
 * @param 禁用指示器颜色 文本字段禁用时的指示线颜色。
 * @param 错误指示器颜色 文本字段处于错误状态时的指示线颜色。
 * @param 聚焦前导图标颜色 文本字段聚焦时前置图标的颜色。
 * @param 非聚焦前导图标颜色 文本字段未聚焦时前置图标的颜色。
 * @param 禁用前导图标颜色 文本字段禁用时前置图标的颜色。
 * @param 错误前导图标颜色 文本字段处于错误状态时前置图标的颜色。
 * @param 聚焦尾随图标颜色 文本字段聚焦时尾部图标的颜色。
 * @param 非聚焦尾随图标颜色 文本字段未聚焦时尾部图标的颜色。
 * @param 禁用尾随图标颜色 文本字段禁用时尾部图标的颜色。
 * @param 错误尾随图标颜色 文本字段处于错误状态时尾部图标的颜色。
 * @param 聚焦标签颜色 文本字段聚焦时标签的颜色。
 * @param 非聚焦标签颜色 文本字段未聚焦时标签的颜色。
 * @param 禁用标签颜色 文本字段禁用时标签的颜色。
 * @param 错误标签颜色 文本字段处于错误状态时标签的颜色。
 * @param 聚焦占位符颜色 文本字段聚焦时占位符的颜色。
 * @param 非聚焦占位符颜色 文本字段未聚焦时占位符的颜色。
 * @param 禁用占位符颜色 文本字段禁用时占位符的颜色。
 * @param 错误占位符颜色 文本字段处于错误状态时占位符的颜色。
 * @param 聚焦辅助文本颜色 文本字段聚焦时辅助说明文字的颜色。
 * @param 非聚焦辅助文本颜色 文本字段未聚焦时辅助说明文字的颜色。
 * @param 禁用辅助文本颜色 文本字段禁用时辅助说明文字的颜色。
 * @param 错误辅助文本颜色 文本字段处于错误状态时辅助说明文字的颜色。
 * @param 聚焦前缀颜色 文本字段聚焦时前缀的颜色。
 * @param 非聚焦前缀颜色 文本字段未聚焦时前缀的颜色。
 * @param 禁用前缀颜色 文本字段禁用时前缀的颜色。
 * @param 错误前缀颜色 文本字段处于错误状态时前缀的颜色。
 * @param 聚焦后缀颜色 文本字段聚焦时后缀的颜色。
 * @param 非聚焦后缀颜色 文本字段未聚焦时后缀的颜色。
 * @param 禁用后缀颜色 文本字段禁用时后缀的颜色。
 * @param 错误后缀颜色 文本字段处于错误状态时后缀的颜色。
 * @constructor 可用来创建具有任意颜色的实例。[文本字段] 的默认颜色参见 [TextFieldDefaults.colors]，[轮廓文本字段]
 * 的默认颜色参见 [OutlinedTextFieldDefaults.colors]。
 */
@Immutable
class 文本字段颜色   //TextFieldColors
constructor(
    val 聚焦文本颜色: Color,
    val 非聚焦文本颜色: Color,
    val 禁用文本颜色: Color,
    val 错误文本颜色: Color,
    val 聚焦容器颜色: Color,
    val 非聚焦容器颜色: Color,
    val 禁用容器颜色: Color,
    val 错误容器颜色: Color,
    val 光标颜色: Color,
    val 错误光标颜色: Color,
    val 文本选择颜色: TextSelectionColors,
    val 聚焦指示器颜色: Color,
    val 非聚焦指示器颜色: Color,
    val 禁用指示器颜色: Color,
    val 错误指示器颜色: Color,
    val 聚焦前导图标颜色: Color,
    val 非聚焦前导图标颜色: Color,
    val 禁用前导图标颜色: Color,
    val 错误前导图标颜色: Color,
    val 聚焦尾随图标颜色: Color,
    val 非聚焦尾随图标颜色: Color,
    val 禁用尾随图标颜色: Color,
    val 错误尾随图标颜色: Color,
    val 聚焦标签颜色: Color,
    val 非聚焦标签颜色: Color,
    val 禁用标签颜色: Color,
    val 错误标签颜色: Color,
    val 聚焦占位符颜色: Color,
    val 非聚焦占位符颜色: Color,
    val 禁用占位符颜色: Color,
    val 错误占位符颜色: Color,
    val 聚焦辅助文本颜色: Color,
    val 非聚焦辅助文本颜色: Color,
    val 禁用辅助文本颜色: Color,
    val 错误辅助文本颜色: Color,
    val 聚焦前缀颜色: Color,
    val 非聚焦前缀颜色: Color,
    val 禁用前缀颜色: Color,
    val 错误前缀颜色: Color,
    val 聚焦后缀颜色: Color,
    val 非聚焦后缀颜色: Color,
    val 禁用后缀颜色: Color,
    val 错误后缀颜色: Color,
) {

    /**
     * 返回此 ChipColors 的副本，可选择性地覆盖部分值。使用 Color.Unspecified 表示“沿用源值”。
     */
    fun 复制(
        聚焦文本颜色: Color = this.聚焦文本颜色,
        非聚焦文本颜色: Color = this.非聚焦文本颜色,
        禁用文本颜色: Color = this.禁用文本颜色,
        错误文本颜色: Color = this.错误文本颜色,
        聚焦容器颜色: Color = this.聚焦容器颜色,
        非聚焦容器颜色: Color = this.非聚焦容器颜色,
        禁用容器颜色: Color = this.禁用容器颜色,
        错误容器颜色: Color = this.错误容器颜色,
        光标颜色: Color = this.光标颜色,
        错误光标颜色: Color = this.错误光标颜色,
        文本选择颜色: TextSelectionColors? = this.文本选择颜色,
        聚焦指示器颜色: Color = this.聚焦指示器颜色,
        非聚焦指示器颜色: Color = this.非聚焦指示器颜色,
        禁用指示器颜色: Color = this.禁用指示器颜色,
        错误指示器颜色: Color = this.错误指示器颜色,
        聚焦前导图标颜色: Color = this.聚焦前导图标颜色,
        非聚焦前导图标颜色: Color = this.非聚焦前导图标颜色,
        禁用前导图标颜色: Color = this.禁用前导图标颜色,
        错误前导图标颜色: Color = this.错误前导图标颜色,
        聚焦尾随图标颜色: Color = this.聚焦尾随图标颜色,
        非聚焦尾随图标颜色: Color = this.非聚焦尾随图标颜色,
        禁用尾随图标颜色: Color = this.禁用尾随图标颜色,
        错误尾随图标颜色: Color = this.错误尾随图标颜色,
        聚焦标签颜色: Color = this.聚焦标签颜色,
        非聚焦标签颜色: Color = this.非聚焦标签颜色,
        禁用标签颜色: Color = this.禁用标签颜色,
        错误标签颜色: Color = this.错误标签颜色,
        聚焦占位符颜色: Color = this.聚焦占位符颜色,
        非聚焦占位符颜色: Color = this.非聚焦占位符颜色,
        禁用占位符颜色: Color = this.禁用占位符颜色,
        错误占位符颜色: Color = this.错误占位符颜色,
        聚焦辅助文本颜色: Color = this.聚焦辅助文本颜色,
        非聚焦辅助文本颜色: Color = this.非聚焦辅助文本颜色,
        禁用辅助文本颜色: Color = this.禁用辅助文本颜色,
        错误辅助文本颜色: Color = this.错误辅助文本颜色,
        聚焦前缀颜色: Color = this.聚焦前缀颜色,
        非聚焦前缀颜色: Color = this.非聚焦前缀颜色,
        禁用前缀颜色: Color = this.禁用前缀颜色,
        错误前缀颜色: Color = this.错误前缀颜色,
        聚焦后缀颜色: Color = this.聚焦后缀颜色,
        非聚焦后缀颜色: Color = this.非聚焦后缀颜色,
        禁用后缀颜色: Color = this.禁用后缀颜色,
        错误后缀颜色: Color = this.错误后缀颜色,
    ) =
        TextFieldColors(
            focusedTextColor = 聚焦文本颜色,
            unfocusedTextColor = 非聚焦文本颜色,
            disabledTextColor = 禁用文本颜色,
            errorTextColor = 错误文本颜色,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 非聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
            errorContainerColor = 错误容器颜色,
            cursorColor = 光标颜色,
            errorCursorColor = 错误光标颜色,
            textSelectionColors = 文本选择颜色!!,
            focusedIndicatorColor = 聚焦指示器颜色,
            unfocusedIndicatorColor = 非聚焦指示器颜色,
            disabledIndicatorColor = 禁用指示器颜色,
            errorIndicatorColor = 错误指示器颜色,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 非聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            errorLeadingIconColor = 错误前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 非聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            errorTrailingIconColor = 错误尾随图标颜色,
            focusedLabelColor = 聚焦标签颜色,
            unfocusedLabelColor = 非聚焦标签颜色,
            disabledLabelColor = 禁用标签颜色,
            errorLabelColor = 错误标签颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 非聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            errorPlaceholderColor = 错误占位符颜色,
            focusedSupportingTextColor = 聚焦辅助文本颜色,
            unfocusedSupportingTextColor = 非聚焦辅助文本颜色,
            disabledSupportingTextColor = 禁用辅助文本颜色,
            errorSupportingTextColor = 错误辅助文本颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 非聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            errorPrefixColor = 错误前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 非聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            errorSuffixColor = 错误后缀颜色,
        )

    /**
     * 表示该文本字段前置图标所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 前导图标颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用前导图标颜色
            是否错误 -> 错误前导图标颜色
            已聚焦 -> 聚焦前导图标颜色
            else -> 非聚焦前导图标颜色
        }

    /**
     * 表示该文本字段尾随图标所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 尾随图标颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用尾随图标颜色
            是否错误 -> 错误尾随图标颜色
            已聚焦 -> 聚焦尾随图标颜色
            else -> 非聚焦尾随图标颜色
        }

    /**
     * 表示该文本字段指示器所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 指示器颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用指示器颜色
            是否错误 -> 错误指示器颜色
            已聚焦 -> 聚焦指示器颜色
            else -> 非聚焦指示器颜色
        }

    /**
     * 表示该文本字段的容器颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 容器颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用容器颜色
            是否错误 -> 错误容器颜色
            已聚焦 -> 聚焦容器颜色
            else -> 非聚焦容器颜色
        }

    /**
     * 表示该文本字段占位符所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 占位符颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用占位符颜色
            是否错误 -> 错误占位符颜色
            已聚焦 -> 聚焦占位符颜色
            else -> 非聚焦占位符颜色
        }

    /**
     * 表示该文本字段标签所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 标签颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用标签颜色
            是否错误 -> 错误标签颜色
            已聚焦 -> 聚焦标签颜色
            else -> 非聚焦标签颜色
        }

    /**
     * 表示此文本框输入字段使用的颜色
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 文本颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用文本颜色
            是否错误 -> 错误文本颜色
            已聚焦 -> 聚焦文本颜色
            else -> 非聚焦文本颜色
        }

    /**
     * 表示该文本字段辅助说明文字所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 辅助文本颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用辅助文本颜色
            是否错误 -> 错误辅助文本颜色
            已聚焦 -> 聚焦辅助文本颜色
            else -> 非聚焦辅助文本颜色
        }

    /**
     * 表示该文本字段前缀所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 前缀颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用前缀颜色
            是否错误 -> 错误前缀颜色
            已聚焦 -> 聚焦前缀颜色
            else -> 非聚焦前缀颜色
        }

    /**
     * 表示该文本字段后缀所使用的颜色。
     *
     * @param 已启用 文本字段是否启用。
     * @param 是否错误 文本字段当前值是否处于错误状态。
     * @param 已聚焦 文本字段是否处于聚焦状态。
     */
    @Stable
    fun 后缀颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用后缀颜色
            是否错误 -> 错误后缀颜色
            已聚焦 -> 聚焦后缀颜色
            else -> 非聚焦后缀颜色
        }

    /**
     * 表示该文本字段光标所使用的颜色。
     *
     * @param 是否错误 文本字段当前值是否处于错误状态。
     */
    @Stable
    fun 光标颜色(是否错误: Boolean): Color = if (是否错误) 错误光标颜色 else 光标颜色

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is TextFieldColors) return false

        if (聚焦文本颜色 != other.focusedTextColor) return false
        if (非聚焦文本颜色 != other.unfocusedTextColor) return false
        if (禁用文本颜色 != other.disabledTextColor) return false
        if (错误文本颜色 != other.errorTextColor) return false
        if (聚焦容器颜色 != other.focusedContainerColor) return false
        if (非聚焦容器颜色 != other.unfocusedContainerColor) return false
        if (禁用容器颜色 != other.disabledContainerColor) return false
        if (错误容器颜色 != other.errorContainerColor) return false
        if (光标颜色 != other.cursorColor) return false
        if (错误光标颜色 != other.errorCursorColor) return false
        if (文本选择颜色 != other.textSelectionColors) return false
        if (聚焦指示器颜色 != other.focusedIndicatorColor) return false
        if (非聚焦指示器颜色 != other.unfocusedIndicatorColor) return false
        if (禁用指示器颜色 != other.disabledIndicatorColor) return false
        if (错误指示器颜色 != other.errorIndicatorColor) return false
        if (聚焦前导图标颜色 != other.focusedLeadingIconColor) return false
        if (非聚焦前导图标颜色 != other.unfocusedLeadingIconColor) return false
        if (禁用前导图标颜色 != other.disabledLeadingIconColor) return false
        if (错误前导图标颜色 != other.errorLeadingIconColor) return false
        if (聚焦尾随图标颜色 != other.focusedTrailingIconColor) return false
        if (非聚焦尾随图标颜色 != other.unfocusedTrailingIconColor) return false
        if (禁用尾随图标颜色 != other.disabledTrailingIconColor) return false
        if (错误尾随图标颜色 != other.errorTrailingIconColor) return false
        if (聚焦标签颜色 != other.focusedLabelColor) return false
        if (非聚焦标签颜色 != other.unfocusedLabelColor) return false
        if (禁用标签颜色 != other.disabledLabelColor) return false
        if (错误标签颜色 != other.errorLabelColor) return false
        if (聚焦占位符颜色 != other.focusedPlaceholderColor) return false
        if (非聚焦占位符颜色 != other.unfocusedPlaceholderColor) return false
        if (禁用占位符颜色 != other.disabledPlaceholderColor) return false
        if (错误占位符颜色 != other.errorPlaceholderColor) return false
        if (聚焦辅助文本颜色 != other.focusedSupportingTextColor) return false
        if (非聚焦辅助文本颜色 != other.unfocusedSupportingTextColor) return false
        if (禁用辅助文本颜色 != other.disabledSupportingTextColor) return false
        if (错误辅助文本颜色 != other.errorSupportingTextColor) return false
        if (聚焦前缀颜色 != other.focusedPrefixColor) return false
        if (非聚焦前缀颜色 != other.unfocusedPrefixColor) return false
        if (禁用前缀颜色 != other.disabledPrefixColor) return false
        if (错误前缀颜色 != other.errorPrefixColor) return false
        if (聚焦后缀颜色 != other.focusedSuffixColor) return false
        if (非聚焦后缀颜色 != other.unfocusedSuffixColor) return false
        if (禁用后缀颜色 != other.disabledSuffixColor) return false
        if (错误后缀颜色 != other.errorSuffixColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 聚焦文本颜色.hashCode()
        result = 31 * result + 非聚焦文本颜色.hashCode()
        result = 31 * result + 禁用文本颜色.hashCode()
        result = 31 * result + 错误文本颜色.hashCode()
        result = 31 * result + 聚焦容器颜色.hashCode()
        result = 31 * result + 非聚焦容器颜色.hashCode()
        result = 31 * result + 禁用容器颜色.hashCode()
        result = 31 * result + 错误容器颜色.hashCode()
        result = 31 * result + 光标颜色.hashCode()
        result = 31 * result + 错误光标颜色.hashCode()
        result = 31 * result + 文本选择颜色.hashCode()
        result = 31 * result + 聚焦指示器颜色.hashCode()
        result = 31 * result + 非聚焦指示器颜色.hashCode()
        result = 31 * result + 禁用指示器颜色.hashCode()
        result = 31 * result + 错误指示器颜色.hashCode()
        result = 31 * result + 聚焦前导图标颜色.hashCode()
        result = 31 * result + 非聚焦前导图标颜色.hashCode()
        result = 31 * result + 禁用前导图标颜色.hashCode()
        result = 31 * result + 错误前导图标颜色.hashCode()
        result = 31 * result + 聚焦尾随图标颜色.hashCode()
        result = 31 * result + 非聚焦尾随图标颜色.hashCode()
        result = 31 * result + 禁用尾随图标颜色.hashCode()
        result = 31 * result + 错误尾随图标颜色.hashCode()
        result = 31 * result + 聚焦标签颜色.hashCode()
        result = 31 * result + 非聚焦标签颜色.hashCode()
        result = 31 * result + 禁用标签颜色.hashCode()
        result = 31 * result + 错误标签颜色.hashCode()
        result = 31 * result + 聚焦占位符颜色.hashCode()
        result = 31 * result + 非聚焦占位符颜色.hashCode()
        result = 31 * result + 禁用占位符颜色.hashCode()
        result = 31 * result + 错误占位符颜色.hashCode()
        result = 31 * result + 聚焦辅助文本颜色.hashCode()
        result = 31 * result + 非聚焦辅助文本颜色.hashCode()
        result = 31 * result + 禁用辅助文本颜色.hashCode()
        result = 31 * result + 错误辅助文本颜色.hashCode()
        result = 31 * result + 聚焦前缀颜色.hashCode()
        result = 31 * result + 非聚焦前缀颜色.hashCode()
        result = 31 * result + 禁用前缀颜色.hashCode()
        result = 31 * result + 错误前缀颜色.hashCode()
        result = 31 * result + 聚焦后缀颜色.hashCode()
        result = 31 * result + 非聚焦后缀颜色.hashCode()
        result = 31 * result + 禁用后缀颜色.hashCode()
        result = 31 * result + 错误后缀颜色.hashCode()
        return result
    }
}

/** [文本字段] 或 [轮廓文本字段] 标签的作用域。 */
@Stable
interface 文本字段标签范围 { // TextFieldLabelScope
    /**
     * 标签在展开与最小化尺寸之间的动画进度，其中 0 表示标签展开，1 表示标签最小化。
     *
     * 当使用读取 [本地文本样式] 的组件（如默认 [文本]）时，标签动画由框架自动处理。此 [标签最小化进度] 值可用于与默认动画同步其他自定义动画。
     */
    @get:FloatRange(from = 0.0, to = 1.0) val 标签最小化进度: Float
}
