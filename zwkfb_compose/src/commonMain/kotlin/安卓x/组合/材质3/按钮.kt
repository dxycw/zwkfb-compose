package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助用户发起各种操作，从发送邮件、共享文档，到点赞帖子。
 *
 * 实心按钮是高强调按钮。在 [FloatingActionButton] 之后，实心按钮的视觉冲击力最强，应仅用于标志流程结束的重要、最终操作，
 * 例如“保存”“立即加入”或“确认”。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。
 *
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 * - 如需介于 [轮廓按钮] 与普通 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 形状 定义该按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [按钮默认值.buttonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小。参见 [按钮默认值.shadowElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 按钮默认值.shape,
    颜色集: ButtonColors = 按钮默认值.buttonColors(),
    阴影: ButtonElevation? = 按钮默认值.buttonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

// TODO：添加按钮按下状态图片的链接
/**
 * [Material Design button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。只要 [形状集] 中提供的是 [CornerBasedShape]，按钮就会根据
 * 与用户的交互状态在这些形状之间过渡变形；若 [形状集] 中的某个形状不是 [CornerBasedShape]，则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * 实心按钮属于高强调按钮。在 [FloatingActionButton] 之后，它的视觉冲击力最强，应仅用于标志流程结束的重要、最终操作，例如“保存”“立即加入”或“确认”。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 * - 如需介于 [轮廓按钮] 与普通 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 形状集 该按钮将根据用户与其的交互，在 [ButtonShapes] 提供的形状之间过渡变形。
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [按钮默认值.buttonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小。参见 [按钮默认值.shadowElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = 按钮默认值.buttonColors(),
    阴影: ButtonElevation? = 按钮默认值.buttonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.contentPaddingFor(按钮默认值.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design elevated button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。
 *
 * 阴影按钮（Elevated buttons）是一种高强调按钮，本质上是带阴影的 [填充色调按钮]。为防止阴影堆叠过度，请仅在绝对必要时使用，
 * 例如当按钮需要与带图案的容器在视觉上区分开来时。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 形状 定义该按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [按钮默认值.elevatedButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface] 时，
 * 它还控制作为主色调叠加的量。参见 [按钮默认值.elevatedButtonElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 阴影按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 按钮默认值.elevatedShape,
    颜色集: ButtonColors = 按钮默认值.elevatedButtonColors(),
    阴影: ButtonElevation? = 按钮默认值.elevatedButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ElevatedButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO：添加凸起按钮按下状态图片的链接
/**
 * [Material Design elevated button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。只要 [形状集] 中提供的是 [CornerBasedShape]，
 * 按钮就会根据与用户的交互状态在这些形状之间过渡变形；若 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * 阴影按钮（Elevated buttons）是一种高强调按钮，本质上是带阴影的 [填充色调按钮]。为防止阴影堆叠过度，请仅在绝对必要时使用，
 * 例如当按钮需要与带图案的容器在视觉上区分开来时。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 形状集 该按钮将根据用户与其的交互，在 [ButtonShapes] 提供的形状之间过渡变形。
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [ButtonDefaults.elevatedButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface] 时，
 * 它还控制作为主色调叠加的量。参见 [ButtonDefaults.elevatedButtonElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 阴影按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = 按钮默认值.elevatedButtonColors(),
    阴影: ButtonElevation? = 按钮默认值.elevatedButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.contentPaddingFor(按钮默认值.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ElevatedButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。
 *
 * 填充色调按钮是中强调按钮，介于默认的实心按钮与轮廓按钮之间的折中选择。适用于需要比轮廓按钮稍强、却又不如实心按钮突出的次要操作，
 * 例如引导流程中的“下一步”。色调按钮采用次级色彩映射。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 形状 定义该按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [按钮默认值.filledTonalButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 填充色调按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 按钮默认值.filledTonalShape,
    颜色集: ButtonColors = 按钮默认值.filledTonalButtonColors(),
    阴影: ButtonElevation? = 按钮默认值.filledTonalButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FilledTonalButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO：添加填充色调按钮按下状态图片的链接
/**
 * [Material Design filled tonal button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。只要 [形状集] 中提供的是 [CornerBasedShape]，按钮就会根据与
 * 用户的交互状态在这些形状之间过渡变形；若 [形状集] 中的某个形状不是 [CornerBasedShape]，则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * 填充色调按钮属于中强调按钮，是默认实心按钮与轮廓按钮之间的折中方案。当较低优先级的操作需要比轮廓按钮稍强、却又不如实心按钮突出的视觉强调时，
 * 可使用此类按钮，例如引导流程中的“下一步”。色调按钮采用次级色彩映射。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 形状集 该按钮将根据用户与其的交互，在 [ButtonShapes] 提供的形状之间过渡变形。
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [ButtonDefaults.filledTonalButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 填充色调按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = 按钮默认值.filledTonalButtonColors(),
    阴影: ButtonElevation? = 按钮默认值.filledTonalButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.contentPaddingFor(按钮默认值.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FilledTonalButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。
 *
 * 轮廓按钮是中强调按钮，用于重要但并非应用内首要操作的动作。与实心按钮搭配使用，可表示替代性的次要操作。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 形状 定义该按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。.
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [按钮默认值.outlinedButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。
 * @param 边框 绘制在此按钮容器周围的边框。 传入 `null` 表示无边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 轮廓按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 按钮默认值.outlinedShape,
    颜色集: ButtonColors = 按钮默认值.outlinedButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = 按钮默认值.outlinedButtonBorder(已启用),
    内容内边距: PaddingValues = 按钮默认值.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO：添加轮廓按钮按下状态图片的链接
/**
 * [Material Design outlined button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。只要 [形状集] 中提供的是 [CornerBasedShape]，按钮就会根据
 * 与用户的交互状态在这些形状之间过渡变形；若 [形状集] 中的某个形状不是 [CornerBasedShape]，则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * 轮廓按钮是中强调按钮，用于重要但并非应用内首要操作的动作。与实心按钮搭配使用，可表示替代性的次要操作。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 * - 如需无边框的低强调按钮，请参见 [文本按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 形状集 该按钮将根据用户与其的交互，在 [ButtonShapes] 提供的形状之间过渡变形。
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [ButtonDefaults.outlinedButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。
 * @param 边框 绘制在此按钮容器周围的边框。. Pass `null` for no border.
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，通常为文本、图标或图像。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 轮廓按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = 按钮默认值.outlinedButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = 按钮默认值.outlinedButtonBorder(已启用),
    内容内边距: PaddingValues = 按钮默认值.contentPaddingFor(按钮默认值.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design text button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。
 *
 * 文本按钮通常用于不太突出的操作，例如出现在对话框和卡片中的操作。在卡片中，文本按钮有助于保持对卡片内容的强调。
 * 它们适用于优先级最低的操作，尤其是在提供多个选项时。
 *
 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 形状 定义该按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [ButtonDefaults.textButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。 文本按钮 通常不带高度（阴影），默认值为 `null`。如需带高度的按钮，请参见 [阴影按钮]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，应为文本。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 文本按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 按钮默认值.textShape,
    颜色集: ButtonColors = 按钮默认值.textButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.TextButtonContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    TextButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO：添加轮廓按钮按下状态图片的链接
/**
 * [Material Design text button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、共享文档，到点赞帖子。只要 [形状集] 中提供的是 [CornerBasedShape]，按钮就会根据
 * 与用户的交互状态在这些形状之间过渡变形；若 [形状集] 中的某个形状不是 [CornerBasedShape]，则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * 文本按钮通常用于不太突出的操作，例如出现在对话框和卡片中的操作。在卡片中，文本按钮有助于保持对卡片内容的强调。它们适用于优先级最低的操作，尤其是在提供多个选项时。

 * 根据操作所需的强调程度，为其选择最合适的按钮。操作越重要，按钮的强调级别就应越高。  
 * - 如需不带阴影的高强调按钮（即实心按钮），请参见 [按钮]。
 * - 如需带阴影的 [填充色调按钮]，请参见 [阴影按钮]。
 * - 如需介于 [轮廓按钮] 与 [按钮] 之间的折中方案，请参见 [填充色调按钮]。
 * - 如需带边框的中等强调按钮，请参见 [轮廓按钮]。
 *
 * 内部 [文本] 组件的默认文本样式将被设置为 [Typography.labelLarge]。
 *
 * @param 单击回调 当此按钮被点击时调用
 * @param 形状集 该按钮将根据用户与其的交互，在 [ButtonShapes] 提供的形状之间过渡变形。
 * @param 修饰符 应用于该按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当设为 `false` 时，该组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其识别为已禁用。
 * @param 颜色集 用于在不同状态下解析该按钮颜色的 [ButtonColors]。参见 [ButtonDefaults.textButtonColors]。
 * @param 阴影 用于在不同状态下解析该按钮高度的 [ButtonElevation]，它控制按钮下方阴影的大小；此外，当容器颜色为 [ColorScheme.surface] 时，
 * 还控制作为主色调叠加的量。 文本按钮 通常不带高度（阴影），默认值为 `null`。如需带高度的按钮，请参见 [阴影按钮]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于按钮容器与内容之间的内边距（内间距）值。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察并发出该按钮的 [Interaction]。
 * 你可以借此改变按钮在不同状态下的外观，或在预览中查看其状态。注意：即使传入 `null`，按钮内部仍会发生交互。
 * @param 内容 按钮上显示的内容，应为文本。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 文本按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = 按钮默认值.textButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = 按钮默认值.TextButtonContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    TextButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO(b/201341237)：是否使用令牌值来表示 0 高度？
// TODO(b/201341237)：是否使用令牌值来表示无边框（null border）？
// TODO(b/201341237)：是否使用令牌值来表示“无色（透明）”？
/**
 * 包含全部 5 种按钮类型所使用的默认值。
 *
 * 适用于所有按钮类型的默认值为 [MinWidth]、[MinHeight]、[IconSize] 和 [IconSpacing]。
 *
 * 仅适用于 [按钮]、[阴影按钮]、[填充色调按钮] 和 [轮廓按钮] 的默认值为 [ContentPadding]。
 *
 * 仅适用于 [按钮] 的默认值有 [buttonColors] 和 [buttonElevation]；
 * 仅适用于 [阴影按钮] 的默认值有 [elevatedButtonColors] 和 [elevatedButtonElevation]；
 * 仅适用于 [填充色调按钮] 的默认值有 [filledTonalButtonColors] 和 [filledTonalButtonElevation]；
 * 仅适用于 [轮廓按钮] 的默认值是 [outlinedButtonColors]；
 * 仅适用于 [文本按钮] 的默认值有 [TextButtonContentPadding] 和 [textButtonColors]。
 */
object 按钮默认值 {

    /**
     * [按钮]、[阴影按钮]、[填充色调按钮] 与 [轮廓按钮] 默认使用的内容内边距。
     * - 关于 [文本按钮] 使用的内容内边距，请参见 [TextButtonContentPadding] 或 [TextButtonWithIconContentPadding]。
     * - 关于包含 [Icon] 的 [按钮] 使用的内容内边距，请参见 [ButtonWithIconContentPadding]。
     */
    val ContentPadding = ButtonDefaults.ContentPadding

    /** 包含 [Icon] 的 [按钮] 默认使用的内容内边距。 */
    val ButtonWithIconContentPadding = ButtonDefaults.ContentPadding


    /** The default content padding used for small [Button] */
    @ExperimentalMaterial3ExpressiveApi
    val SmallContentPadding
        get() = ButtonDefaults.SmallContentPadding

    /** Default content padding for an extra small button. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraSmallContentPadding
        get() = ButtonDefaults.ExtraSmallContentPadding

    /** Default content padding for a medium button. */
    @ExperimentalMaterial3ExpressiveApi
    val MediumContentPadding
        get() = ButtonDefaults.MediumContentPadding

    /** Default content padding for a large button. */
    @ExperimentalMaterial3ExpressiveApi
    val LargeContentPadding
        get() = ButtonDefaults.LargeContentPadding

    /** Default content padding for an extra large button. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraLargeContentPadding
        get() = ButtonDefaults.ExtraLargeContentPadding

    /**
     * The default content padding used by [TextButton].
     * - See [TextButtonWithIconContentPadding] for content padding used by [TextButton] that
     *   contains [Icon].
     */
    val TextButtonContentPadding = ButtonDefaults.TextButtonContentPadding

    /** The default content padding used by [TextButton] that contains an [Icon]. */
    val TextButtonWithIconContentPadding = ButtonDefaults.TextButtonWithIconContentPadding

    /**
     * The default min width applied for small buttons. Note that you can override it by applying
     * Modifier.widthIn directly on the button composable.
     */
    val MinWidth = ButtonDefaults.MinWidth

    /**
     * The default min height applied for small buttons. Note that you can override it by applying
     * Modifier.heightIn directly on the button composable.
     */
    val MinHeight = ButtonDefaults.MinHeight

    /** The default height for a extra small button container. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraSmallContainerHeight = ButtonDefaults.ExtraSmallContainerHeight

    /** The default height for a medium button container. */
    @ExperimentalMaterial3ExpressiveApi
    val MediumContainerHeight = ButtonDefaults.MediumContainerHeight

    /** The default height for a large button container. */
    @ExperimentalMaterial3ExpressiveApi
     val LargeContainerHeight = ButtonDefaults.LargeContainerHeight

    /** The default height for a extra large button container. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraLargeContainerHeight = ButtonDefaults.ExtraLargeContainerHeight

    /** The default size of the icon when used inside a small button. */
    // TODO update with the correct value in BaselineButtonTokens when available
    val IconSize = ButtonDefaults.IconSize

    /** The default size of the icon used inside of a extra small button. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraSmallIconSize = ButtonDefaults.ExtraSmallIconSize

    /** The expressive size of the icon used inside a small button. */
    @ExperimentalMaterial3ExpressiveApi
    val SmallIconSize = ButtonDefaults.SmallIconSize

    /** The default size of the icon used inside of a medium button. */
    @ExperimentalMaterial3ExpressiveApi
    val MediumIconSize = ButtonDefaults.MediumIconSize

    /** The default size of the icon used inside of a large button. */
    @ExperimentalMaterial3ExpressiveApi
    val LargeIconSize = ButtonDefaults.LargeIconSize

    /** The default size of the icon used inside of a extra large button. */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraLargeIconSize = ButtonDefaults.ExtraLargeIconSize

    /**
     * The default size of the spacing between an icon and a text when they used inside a small
     * button.
     */
    val IconSpacing = ButtonDefaults.IconSpacing

    /**
     * The default spacing between an icon and a text when they used inside any extra small button.
     */
    // TODO use the value from ButtonXSmallTokens.kt once it's been corrected
    @ExperimentalMaterial3ExpressiveApi
    val ExtraSmallIconSpacing = ButtonDefaults.ExtraSmallIconSpacing

    /** The default spacing between an icon and a text when they used inside any medium button. */
    @ExperimentalMaterial3ExpressiveApi
    val MediumIconSpacing = ButtonDefaults.MediumIconSpacing

    /** The default spacing between an icon and a text when they used inside any large button. */
    @ExperimentalMaterial3ExpressiveApi
    val LargeIconSpacing = ButtonDefaults.LargeIconSpacing

    /**
     * The default spacing between an icon and a text when they used inside any extra large button.
     */
    @ExperimentalMaterial3ExpressiveApi
    val ExtraLargeIconSpacing = ButtonDefaults.ExtraLargeIconSpacing

    /** Square shape for default buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val squareShape: Shape
        @Composable get() = ButtonDefaults.squareShape

    /** Pressed shape for default buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val pressedShape: Shape
        @Composable get() = ButtonDefaults.pressedShape

    /** Pressed shape for extra small buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val extraSmallPressedShape: Shape
        @Composable get() = ButtonDefaults.extraSmallPressedShape

    /** Pressed shape for medium buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val mediumPressedShape: Shape
        @Composable get() = ButtonDefaults.mediumPressedShape

    /** Pressed shape for large buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val largePressedShape: Shape
        @Composable get() = ButtonDefaults.largePressedShape

    /** Pressed shape for extra large buttons. */
    @ExperimentalMaterial3ExpressiveApi
    val extraLargePressedShape: Shape
        @Composable get() = ButtonDefaults.extraLargePressedShape

    /** Default shape for a button. */
    val shape: Shape
        @Composable get() = ButtonDefaults.shape

    /** Default shape for an elevated button. */
    val elevatedShape: Shape
        @Composable get() = ButtonDefaults.elevatedShape

    /** Default shape for a filled tonal button. */
    val filledTonalShape: Shape
        @Composable get() = ButtonDefaults.filledTonalShape

    /** Default shape for an outlined button. */
    val outlinedShape: Shape
        @Composable get() = ButtonDefaults.outlinedShape

    /** Default shape for a text button. */
    val textShape: Shape
        @Composable get() = ButtonDefaults.textShape

    /**
     * Creates a [ButtonShapes] that represents the default shape and pressed shape used in a
     * button.
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun shapes(): ButtonShapes = ButtonDefaults.shapes()

    /**
     * Creates a [ButtonShapes] that represents the default shape and pressedShape used in a
     * [Button] and its variants.
     *
     * @param shape the unchecked shape for [ButtonShapes]
     * @param pressedShape the unchecked shape for [ButtonShapes]
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun shapes(shape: Shape? = null, pressedShape: Shape? = null): ButtonShapes =
        ButtonDefaults.shapes(shape, pressedShape)


    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in a
     * [Button].
     */
    @Composable
    fun buttonColors(): ButtonColors = ButtonDefaults.buttonColors()

    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in a
     * [Button].
     *
     * @param containerColor the container color of this [Button] when enabled.
     * @param contentColor the content color of this [Button] when enabled.
     * @param disabledContainerColor the container color of this [Button] when not enabled.
     * @param disabledContentColor the content color of this [Button] when not enabled.
     */
    @Composable
    fun buttonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.buttonColors(containerColor, contentColor, disabledContainerColor, disabledContentColor)



    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [ElevatedButton].
     */
    @Composable
    fun elevatedButtonColors(): ButtonColors  = ButtonDefaults.elevatedButtonColors()

    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [ElevatedButton].
     *
     * @param containerColor the container color of this [ElevatedButton] when enabled
     * @param contentColor the content color of this [ElevatedButton] when enabled
     * @param disabledContainerColor the container color of this [ElevatedButton] when not enabled
     * @param disabledContentColor the content color of this [ElevatedButton] when not enabled
     */
    @Composable
    fun elevatedButtonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.elevatedButtonColors(containerColor, contentColor, disabledContainerColor, disabledContentColor)



    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [FilledTonalButton].
     */
    @Composable
    fun filledTonalButtonColors(): ButtonColors  = ButtonDefaults.filledTonalButtonColors()

    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [FilledTonalButton].
     *
     * @param containerColor the container color of this [FilledTonalButton] when enabled
     * @param contentColor the content color of this [FilledTonalButton] when enabled
     * @param disabledContainerColor the container color of this [FilledTonalButton] when not
     *   enabled
     * @param disabledContentColor the content color of this [FilledTonalButton] when not enabled
     */
    @Composable
    fun filledTonalButtonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.filledTonalButtonColors(containerColor, contentColor, disabledContainerColor, disabledContentColor)



    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [OutlinedButton].
     */
    @Composable
    fun outlinedButtonColors(): ButtonColors = ButtonDefaults.outlinedButtonColors()

    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in an
     * [OutlinedButton].
     *
     * @param containerColor the container color of this [OutlinedButton] when enabled
     * @param contentColor the content color of this [OutlinedButton] when enabled
     * @param disabledContainerColor the container color of this [OutlinedButton] when not enabled
     * @param disabledContentColor the content color of this [OutlinedButton] when not enabled
     */
    @Composable
    fun outlinedButtonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.outlinedButtonColors(containerColor, contentColor, disabledContainerColor, disabledContentColor)



    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in a
     * [TextButton].
     */
    @Composable
    fun textButtonColors(): ButtonColors = ButtonDefaults.textButtonColors()

    /**
     * Creates a [ButtonColors] that represents the default container and content colors used in a
     * [TextButton].
     *
     * @param containerColor the container color of this [TextButton] when enabled
     * @param contentColor the content color of this [TextButton] when enabled
     * @param disabledContainerColor the container color of this [TextButton] when not enabled
     * @param disabledContentColor the content color of this [TextButton] when not enabled
     */
    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.textButtonColors(containerColor, contentColor, disabledContainerColor, disabledContentColor)

    /**
     * Creates a [ButtonElevation] that will animate between the provided values according to the
     * Material specification for a [Button].
     *
     * @param defaultElevation the elevation used when the [Button] is enabled, and has no other
     *   [Interaction]s.
     * @param pressedElevation the elevation used when this [Button] is enabled and pressed.
     * @param focusedElevation the elevation used when the [Button] is enabled and focused.
     * @param hoveredElevation the elevation used when the [Button] is enabled and hovered.
     * @param disabledElevation the elevation used when the [Button] is not enabled.
     */
    @Composable
    fun buttonElevation(
        defaultElevation: Dp = 0.0.dp,
        pressedElevation: Dp = 0.0.dp,
        focusedElevation: Dp = 0.0.dp,
        hoveredElevation: Dp = 1.0.dp,
        disabledElevation: Dp =  0.0.dp,
    ): ButtonElevation =
        ButtonDefaults.buttonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, disabledElevation)

    /**
     * Creates a [ButtonElevation] that will animate between the provided values according to the
     * Material specification for a [ElevatedButton].
     *
     * @param defaultElevation the elevation used when the [ElevatedButton] is enabled, and has no
     *   other [Interaction]s.
     * @param pressedElevation the elevation used when this [ElevatedButton] is enabled and pressed.
     * @param focusedElevation the elevation used when the [ElevatedButton] is enabled and focused.
     * @param hoveredElevation the elevation used when the [ElevatedButton] is enabled and hovered.
     * @param disabledElevation the elevation used when the [ElevatedButton] is not enabled.
     */
    @Composable
    fun elevatedButtonElevation(
        defaultElevation: Dp = 1.0.dp,
        pressedElevation: Dp = 1.0.dp,
        focusedElevation: Dp = 1.0.dp,
        hoveredElevation: Dp = 3.0.dp,
        disabledElevation: Dp = 0.0.dp,
    ): ButtonElevation =
        ButtonDefaults.elevatedButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, disabledElevation)

    /**
     * Creates a [ButtonElevation] that will animate between the provided values according to the
     * Material specification for a [FilledTonalButton].
     *
     * @param defaultElevation the elevation used when the [FilledTonalButton] is enabled, and has
     *   no other [Interaction]s.
     * @param pressedElevation the elevation used when this [FilledTonalButton] is enabled and
     *   pressed.
     * @param focusedElevation the elevation used when the [FilledTonalButton] is enabled and
     *   focused.
     * @param hoveredElevation the elevation used when the [FilledTonalButton] is enabled and
     *   hovered.
     * @param disabledElevation the elevation used when the [FilledTonalButton] is not enabled.
     */
    @Composable
    fun filledTonalButtonElevation(
        defaultElevation: Dp = 0.0.dp,
        pressedElevation: Dp = 0.0.dp,
        focusedElevation: Dp = 0.0.dp,
        hoveredElevation: Dp = 1.0.dp,
        disabledElevation: Dp = 0.dp,
    ): ButtonElevation =
        ButtonDefaults.filledTonalButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, disabledElevation)

    /** The default [BorderStroke] used by [OutlinedButton]. */
    val outlinedButtonBorder: BorderStroke
        @Composable
        @Deprecated(
            message =
                "Please use the version that takes an `enabled` param to get the " +
                        "`BorderStroke` with the correct opacity",
            replaceWith = ReplaceWith("outlinedButtonBorder(enabled)"),
        )
        get() = ButtonDefaults.outlinedButtonBorder

    /**
     * The default [BorderStroke] used by [OutlinedButton].
     *
     * @param 已启用 whether the button is enabled
     */
    @Composable
    fun outlinedButtonBorder(已启用: Boolean = true): BorderStroke =
        ButtonDefaults.outlinedButtonBorder(已启用)

    /**
     * Recommended [ButtonShapes] for a provided button height.
     *
     * @param buttonHeight The height of the button
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun shapesFor(buttonHeight: Dp): ButtonShapes = ButtonDefaults.shapesFor(buttonHeight)

    /**
     * Recommended [PaddingValues] for a provided button height.
     *
     * @param buttonHeight The height of the button
     */
    @ExperimentalMaterial3ExpressiveApi
    fun contentPaddingFor(buttonHeight: Dp): PaddingValues = ButtonDefaults.contentPaddingFor(buttonHeight)

    /**
     * Recommended Icon size for a provided button height.
     *
     * @param buttonHeight The height of the button
     */
    @ExperimentalMaterial3ExpressiveApi
    fun iconSizeFor(buttonHeight: Dp): Dp = ButtonDefaults.iconSizeFor(buttonHeight)

    /**
     * Recommended spacing after an [Icon] for a provided button height.
     *
     * @param buttonHeight The height of the button
     */
    @ExperimentalMaterial3ExpressiveApi
    fun iconSpacingFor(buttonHeight: Dp): Dp = ButtonDefaults.iconSpacingFor(buttonHeight)

    /**
     * Recommended [TextStyle] for a [Text] provided a button height.
     *
     * @param buttonHeight The height of the button
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun textStyleFor(buttonHeight: Dp): TextStyle = ButtonDefaults.textStyleFor(buttonHeight)
}

/**
 * Represents the elevation for a button in different states.
 * - See [ButtonDefaults.buttonElevation] for the default elevation used in a [Button].
 * - See [ButtonDefaults.elevatedButtonElevation] for the default elevation used in a
 *   [ElevatedButton].
 */
@Stable
class 按钮阴影
internal constructor(
    private val defaultElevation: Dp,
    private val pressedElevation: Dp,
    private val focusedElevation: Dp,
    private val hoveredElevation: Dp,
    private val disabledElevation: Dp,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is 按钮阴影) return false

        if (defaultElevation != other.defaultElevation) return false
        if (pressedElevation != other.pressedElevation) return false
        if (focusedElevation != other.focusedElevation) return false
        if (hoveredElevation != other.hoveredElevation) return false
        if (disabledElevation != other.disabledElevation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = defaultElevation.hashCode()
        result = 31 * result + pressedElevation.hashCode()
        result = 31 * result + focusedElevation.hashCode()
        result = 31 * result + hoveredElevation.hashCode()
        result = 31 * result + disabledElevation.hashCode()
        return result
    }
}

/**
 * Represents the container and content colors used in a button in different states.
 *
 * @param containerColor the container color of this [Button] when enabled.
 * @param contentColor the content color of this [Button] when enabled.
 * @param disabledContainerColor the container color of this [Button] when not enabled.
 * @param disabledContentColor the content color of this [Button] when not enabled.
 *     @constructor create an instance with arbitrary colors.
 * - See [ButtonDefaults.buttonColors] for the default colors used in a [Button].
 * - See [ButtonDefaults.elevatedButtonColors] for the default colors used in a [ElevatedButton].
 * - See [ButtonDefaults.textButtonColors] for the default colors used in a [TextButton].
 */
@Immutable
class 按钮颜色
constructor(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {
    /**
     * Returns a copy of this ButtonColors, optionally overriding some of the values. This uses the
     * Color.Unspecified to mean “use the value from the source”
     */
    fun copy(
        containerColor: Color = this.containerColor,
        contentColor: Color = this.contentColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        disabledContentColor: Color = this.disabledContentColor,
    ) =
        ButtonColors(
            containerColor.takeOrElse { this.containerColor },
            contentColor.takeOrElse { this.contentColor },
            disabledContainerColor.takeOrElse { this.disabledContainerColor },
            disabledContentColor.takeOrElse { this.disabledContentColor },
        )

    /**
     * Represents the container color for this button, depending on [enabled].
     *
     * @param enabled whether the button is enabled
     */
    @Stable
    internal fun containerColor(enabled: Boolean): Color =
        if (enabled) containerColor else disabledContainerColor

    /**
     * Represents the content color for this button, depending on [enabled].
     *
     * @param enabled whether the button is enabled
     */
    @Stable
    internal fun contentColor(enabled: Boolean): Color =
        if (enabled) contentColor else disabledContentColor

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonColors) return false

        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledContentColor != other.disabledContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + disabledContentColor.hashCode()
        return result
    }
}

/**
 * The shapes that will be used in buttons. Button will morph between these shapes depending on the
 * interaction of the button, assuming all of the shapes are [CornerBasedShape]s.
 *
 * @property shape is the active shape.
 * @property pressedShape is the pressed shape.
 */
@ExperimentalMaterial3ExpressiveApi
@Immutable
class 按钮形状(val shape: Shape, val pressedShape: Shape) {
    /** Returns a copy of this ButtonShapes, optionally overriding some of the values. */
    fun copy(shape: Shape? = this.shape, pressedShape: Shape? = this.pressedShape) =
        ButtonShapes(
            shape = shape.takeOrElse { this.shape },
            pressedShape = pressedShape.takeOrElse { this.pressedShape },
        )

    internal fun Shape?.takeOrElse(block: () -> Shape): Shape = this ?: block()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonShapes) return false

        if (shape != other.shape) return false
        if (pressedShape != other.pressedShape) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shape.hashCode()
        result = 31 * result + pressedShape.hashCode()

        return result
    }
}
