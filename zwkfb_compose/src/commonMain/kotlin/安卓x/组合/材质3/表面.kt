package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// TODO(b/197880751): 在 Material.io 上添加规范的链接。
/**
 * Material 的“面”是 Material Design 的核心理喻。每一块面都处在一个确定的高度；这个高度决定了它与其他面在视觉上的层级关系，
 * 也决定了色调变化如何在其上呈现。
 *
 * 其他重载版本提供了可点击、可选中和可切换的 表面，请参见对应声明。
 *
 * 表面 负责完成以下四项工作：
 *
 * 1) 裁剪：按照 [形状] 指定的外形，对子元素进行裁剪。
 * 2) 边框：若 [形状] 带有边框，则一并绘制。
 * 3) 背景：用 [颜色] 填充 [形状] 区域。若 [颜色] 为 ColorScheme.surface，则会叠加一层颜色遮罩；遮罩颜色取决于本 表面
 * 的 [色调阴影] 以及所有父级 表面 累积的 [LocalAbsoluteTonalElevation]。这样可保证任一 表面 的叠加色不会低于其祖先的高度总和。
 * 4) 内容色：通过 [内容颜色] 为本面内的内容指定默认色彩，Text 与 Icon 等组件会将其作为缺省颜色使用。
 *
 * 如果未指定 [内容颜色]，本 表面 会尝试将背景色与主题 [ColorScheme] 中的某个色槽匹配，并返回对应的内容色。
 * 例如，当 表面 的 [颜色] 为 ColorScheme.surface 时，[内容颜色] 会被自动设为 ColorScheme.onSurface；
 * 若 [颜色] 不在主题调色板内，则 [内容颜色] 保持上一层组件所设定的值不变。
 *
 * 如需在 表面 内部手动获取当前内容色，请使用 [LocalContentColor]。
 * 5) 阻止触摸事件穿透到 表面 背后的区域。
 *
 * @param 修饰符 要应用到 表面 布局上的修饰符（Modifier）。
 * @param 形状 定义 表面 的外形及其阴影效果。
 * @param 颜色 背景色。如需无背景，请使用 [Color.Transparent]。
 * @param 内容颜色 本 表面 为其子元素提供的首选内容色。默认取值为：若 [颜色] 与主题色槽匹配，则使用对应的“on-”色；若 [颜色] 不在主题调色板内，
 * 则沿用上一层组件所设定的 内容颜色 值。
 * @param 色调阴影 当 [颜色] 为 ColorScheme.surface 时，高度越高，在浅色主题下背景会越深，在深色主题下则会越浅。
 * @param 视觉阴影 表面 下方阴影的大小。为避免“阴影扩散”问题，请仅在确实需要视觉分离时才使用 视觉阴影，例如 表面 必须脱离带纹理的背景。
 * 注意：视觉阴影 不会改变 表面 的 z-index；如需调整绘制顺序，请使用 `Modifier.zIndex`。
 * @param 边框 可选，绘制在 表面 上方的边框。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 表面(
    修饰符: Modifier = Modifier,
    形状: Shape = RectangleShape,
    颜色: Color = 材质主题.颜色方案.surface,
    内容颜色: Color = 内容颜色为了(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    内容: @Composable () -> Unit,
) {
    Surface(
        modifier = 修饰符,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        content = 内容,
    )
}

/**
 * Material 的“面”是 Material Design 的核心理念。每一块面都处在一个给定的高度，该高度决定了它与其他面在视觉上的层级关系，也决定了色调变化如何在其上体现。
 *
 * 本版本 表面 在承担常规 表面 全部职责的基础上，额外负责点击事件处理：
 *
 * 可点击 表面 负责以下六项：
 *
 * 1) 裁剪：按 [形状] 指定的外形裁剪子元素。
 * 2) 边框：若 [形状] 带边框，则一并绘制。
 * 3) 背景：用 [颜色] 填充 [形状] 区域。若 [颜色] 为 ColorScheme.surface，则可能叠加色调遮罩；遮罩颜色取决于本
 * 表面 的 [色调阴影] 与所有父级 表面 累积的 [LocalAbsoluteTonalElevation]，确保视觉上不会出现“子面比祖先面高度低”的错觉。
 * 4) 内容色：通过 [内容颜色] 为子元素提供默认颜色（Text、Icon 等会沿用）。若未显式设置，表面 会尝试将背景色与主题
 * [ColorScheme] 匹配，并返回对应的“on-”色；若背景色不在主题调色板内，则沿用上层组件设定的 内容颜色。
 * 5) 点击处理：响应点击事件，调用 [单击回调] 回调，在发生 [PressInteraction] 时更新 [交互源]，并显示波纹反馈。若无需点击，
 * 请使用不带 [单击回调] 参数的 表面 重载；如需为 [单击回调] 设置自定义标签，可给 表面 加 `Modifier.semantics
 * { onClick(label = "YOUR_LABEL", action = null) }`。
 * 6) 点击语义：与 [Modifier.clickable] 类似，可点击 表面 会自动生成“可点击”语义信息。默认不指定任何 Role，
 * 如需可通过 [Modifier.semantics] 自行传入。
 *
 * 如需在 表面 内部手动获取当前内容色，请使用 [LocalContentColor]。
 *
 * @param 单击回调 表面 被点击时的回调。
 * @param 修饰符 要应用到 表面 布局上的修饰符（Modifier）。
 * @param 已启用 控制 表面 的启用状态。当设为 `false` 时，该 表面 不可点击。
 * @param 形状 定义 表面 的外形及其阴影效果。 仅当 [色调阴影] 大于零时，才会显示阴影。
 * @param 颜色 背景色。如需无背景，请使用 [Color.Transparent]。
 * @param 内容颜色 本 表面 为其子元素提供的首选内容色。默认取值为：若 [颜色] 与主题色槽匹配，则使用对应的“on-”色；
 * 若 [颜色] 不在主题调色板内，则沿用上一层组件所设定的 内容颜色 值。
 * @param 边框 可选，绘制在 表面 上方的边框。
 * @param 色调阴影 当 [颜色] 为 ColorScheme.surface 时，高度越高，在浅色主题下背景会越深，在深色主题下则会越浅。
 * @param 视觉阴影 表面 下方阴影的大小。注意：它不会影响 表面 的 z-index；如需调整绘制顺序，请使用 `Modifier.zIndex`。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该 表面 的 [Interaction]。
 * 借助它，你可以改变 表面 的外观，或在不同状态下预览 表面。注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 表面(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = RectangleShape,
    颜色: Color = 材质主题.颜色方案.surface,
    内容颜色: Color = 内容颜色为了(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    Surface(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * Material 的“面”是 Material Design 的核心理念。每一块面都处在一个给定的高度，该高度决定了它与其他面在视觉上的层级关系，也决定了色调变化如何在其上体现。
 *
 * 本版本 表面 在承担常规 表面 全部职责的基础上，额外负责“选中”状态的处理：
 *
 * 可选中 表面 负责以下六项：
 *
 * 1) 裁剪：按 [形状] 指定的外形裁剪子元素。
 * 2) 边框：若 [形状] 带边框，则一并绘制。
 * 3) 背景：用 [颜色] 填充 [形状] 区域。若 [颜色] 为 ColorScheme.surface，则可能叠加色调遮罩；遮罩颜色取决于本 表面
 * 的 [色调阴影] 与所有父级 表面 累积的 [LocalAbsoluteTonalElevation]，确保视觉上不会出现“子面比祖先面高度低”的错觉。
 * 4) 内容色：通过 [内容颜色] 为子元素提供默认颜色（Text、Icon 等会沿用）。若未显式设置，表面 会尝试将背景色与主题 [ColorScheme] 匹配，
 * 并返回对应的“on-”色；若背景色不在主题调色板内，则沿用上层组件设定的 内容颜色。
 * 5) 点击处理：响应点击事件，调用 [单击回调] 回调，在发生 [PressInteraction] 时更新 [交互源]，并显示波纹反馈。若无需点击，
 * 请使用不带 [单击回调] 参数的 表面 重载。
 * 6) 选中语义：与 [Modifier.selectable] 类似，可选中 表面 会自动生成“可选中”语义信息。默认不指定任何 Role，
 * 如需可通过 [Modifier.semantics] 自行传入。
 *
 * 如需在 表面 内部手动获取当前内容色，请使用 [LocalContentColor]。
 *
 * @param 已选择 该 表面 是否处于“选中”状态。
 * @param 单击回调 表面 被点击时的回调。
 * @param 修饰符 要应用到 表面 布局上的修饰符（Modifier）。
 * @param 已启用 控制 表面 的启用状态。当设为 `false` 时，该 表面 不可点击。
 * @param 形状 定义 表面 的外形及其阴影效果。 仅当 [色调阴影] 大于零时才会显示阴影。
 * @param 颜色 背景色。如需无背景，请使用 [Color.Transparent]。
 * @param 内容颜色 本 表面 为其子元素提供的首选内容色。默认取值为：若 [颜色] 与主题色槽匹配，则使用对应的“on-”色；
 * 若 [颜色] 不在主题调色板内，则沿用上一层组件所设定的 内容颜色 值。
 * @param 边框 可选，绘制在 表面 上方的边框。
 * @param 色调阴影 当 [颜色] 为 ColorScheme.surface 时，高度越高，在浅色主题下背景会越深，在深色主题下则会越浅。
 * @param 视觉阴影 表面 下方阴影的大小。注意：它不会影响 表面 的 z-index；如需调整绘制顺序，请使用 `Modifier.zIndex`。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该 表面 的 [Interaction]。借助它，
 * 你可以改变 表面 的外观，或在不同状态下预览 表面。注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 表面(
    已选择: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = RectangleShape,
    颜色: Color = 材质主题.颜色方案.surface,
    内容颜色: Color = 内容颜色为了(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    Surface(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * Material 的“面”是 Material Design 的核心理念。每一块面都处在一个给定的高度，该高度决定了它与其他面在视觉上的层级关系，也决定了色调变化如何在其上体现。
 *
 * 本版本 表面 在承担常规 表面 全部职责的基础上，额外负责“开关/勾选”状态的切换：
 *
 * 可切换 表面 负责以下六项：
 *
 * 1) 裁剪：按 [形状] 指定的外形裁剪子元素。
 * 2) 边框：若 [形状] 带边框，则一并绘制。
 * 3) 背景：用 [颜色] 填充 [形状] 区域。若 [颜色] 为 ColorScheme.surface，则可能叠加色调遮罩；遮罩颜色取决于本 表面
 * 的 [色调阴影] 与所有父级 表面 累积的 [LocalAbsoluteTonalElevation]，确保视觉上不会出现“子面比祖先面高度低”的错觉。
 * 4) 内容色：通过 [内容颜色] 为子元素提供默认颜色（Text、Icon 等会沿用）。若未显式设置，表面 会尝试将背景色与主题 [ColorScheme]
 * 匹配，并返回对应的“on-”色；若背景色不在主题调色板内，则沿用上层组件设定的 内容颜色。
 * 5) 切换处理：响应点击事件，调用 [已选中改变回调] 回调，在发生 [PressInteraction] 时更新 [交互源]，并显示波纹反馈。
 * 若无需切换功能，请使用不带 [已选中改变回调] 参数的 表面 重载。
 * 6) 切换语义：与 [Modifier.toggleable] 类似，可切换 表面 会自动生成“已勾选/未勾选”语义信息。默认不指定任何 Role，
 * 如需可通过 [Modifier.semantics] 自行传入。
 *
 * 如需在 表面 内部手动获取当前内容色，请使用 [LocalContentColor]。
 *
 * @param 已选中 该 表面 是否处于“开启/勾选”状态。
 * @param 已选中改变回调 在可切换 表面 被点击时调用的回调。
 * @param 修饰符 要应用到 表面 布局上的修饰符（Modifier）。
 * @param 已启用 控制 表面 的启用状态。当设为 `false` 时，该 表面 不可点击。
 * @param 形状 定义 表面 的外形及其阴影效果。 仅当 [色调阴影] 大于零时才会显示阴影。
 * @param 颜色 背景色。如需无背景，请使用 [Color.Transparent]。
 * @param 内容颜色 本 表面 为其子元素提供的首选内容色。默认取值为：若 [颜色] 与主题色槽匹配，则使用对应的“on-”色；
 * 若 [颜色] 不在主题调色板内，则沿用上一层组件所设定的 内容颜色 值。
 * @param 边框 可选，绘制在 表面 上方的边框。
 * @param 色调阴影 当 [颜色] 为 ColorScheme.surface 时，高度越高，在浅色主题下背景会越深，在深色主题下则会越浅。
 * @param 视觉阴影 表面 下方阴影的大小。注意：它不会影响 表面 的 z-index；如需调整绘制顺序，请使用 `Modifier.zIndex`。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送该 表面 的 [Interaction]。
 * 借助它，你可以改变 表面 的外观，或在不同状态下预览 表面。注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 表面(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = RectangleShape,
    颜色: Color = 材质主题.颜色方案.surface,
    内容颜色: Color = 内容颜色为了(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    Surface(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * `CompositionLocal` 提供由 [表面] 组件设置的当前“绝对高度”值。该绝对高度是此前所有 [表面] 层高度的累加和，
 * 仅用于计算 [表面] 的色调颜色，不会用于绘制 [表面] 的阴影。
 */
// TODO(b/179787782)：在目录应用进入AOSP后添加示例。
@Suppress("CompositionLocalNaming")
val 本地绝对色调阴影 = LocalAbsoluteTonalElevation
