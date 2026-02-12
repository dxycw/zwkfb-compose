package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DropdownMenuGroup
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuGroupShapes
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.MenuItemShapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 菜单在临时表面上显示一系列选项，当用户与按钮、操作或其他控件交互时出现。
 *
 * ![Dropdown menuimage](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * [下拉菜单] 的行为类似于 [Popup]，会依据父布局的位置在屏幕上定位。通常将 [下拉菜单] 放在一个 [Box] 中，并与一个同级组件作为“锚点”配合使用。
 * 注意：[下拉菜单] 本身不会在布局中占据任何空间，因为菜单显示在单独的窗口、覆盖在其他内容之上。
 *
 * [下拉菜单] 的 [内容] 通常是 [下拉菜单项] 以及自定义内容。使用 [下拉菜单项] 可使菜单符合 Material 设计规范。
 * 注意：[内容] 会被放置在一个可滚动的 [Column] 中，因此**不**支持在 [内容] 根节点再使用 [LazyColumn]。
 *
 * 当菜单需要关闭时（例如点击菜单外部或按下返回键）将调用 [取消请求回调]。
 *
 * [下拉菜单] 会根据可用空间自动调整位置，始终尝试保持完全可见。水平方向上，它依次尝试：1. 与父容器起始对齐2. 与父容器末尾对齐、
 * 3. 与窗口边缘对齐；垂直方向上，依次尝试：1. 与父容器底部对齐、2. 与父容器顶部对齐、3. 与窗口边缘对齐
 *
 * 可以提供 [偏移]，在父布局边界与其视觉边界不一致时微调菜单位置。
 *
 * @param 扩展 菜单是否展开。
 * @param 取消请求回调 当用户请求关闭菜单时调用（例如点击菜单外部区域）。
 * @param 修饰符 应用于菜单内容的 [Modifier]。
 * @param 偏移 相对于菜单位始位置的 [DpOffset]。该偏移量会随 [LayoutDirection] 调整：在 LTR 中 x 坐标为相加，在 RTL 中为相减。
 * @param 滚动状态 菜单内容用于垂直滚动条目的 [ScrollState]。
 * @param 属性 用于进一步自定义此弹出窗口行为的 [PopupProperties]。
 * @param 形状 菜单的形状。
 * @param 容器颜色 菜单的容器颜色。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器表面叠加一层半透明的“主色”遮罩。
 * 提高色调高度（tonal elevation）值，将在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 菜单下方阴影的海拔高度。
 * @param 边框 围绕菜单容器绘制的边框。传入 `null` 表示无边框。
 * @param 内容 此下拉菜单的内容，通常为 [下拉菜单项]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
expect fun 下拉菜单(
    扩展: Boolean,
    取消请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    偏移: DpOffset = DpOffset(0.dp, 0.dp),
    滚动状态: ScrollState = rememberScrollState(),
    属性: PopupProperties = DefaultMenuProperties,
    形状: Shape = MenuDefaults.shape,
    容器颜色: Color = MenuDefaults.containerColor,
    色调阴影: Dp = MenuDefaults.TonalElevation,
    视觉阴影: Dp = MenuDefaults.ShadowElevation,
    边框: BorderStroke? = null,
    内容: @Composable ColumnScope.() -> Unit,
)

// TODO 如有对应 MIO 页面，可在此添加链接。
// TODO 如有可用图片，可在此添加链接。
/**
 * 一个提供自定义菜单基础的 [Popup]。
 *
 * 该组合项为菜单提供 [Popup] 与布局行为，可用于构建需要与默认下拉菜单不同内容排布或样式的自定义菜单。
 *
 * @param 扩展 菜单是否展开。
 * @param 取消请求回调 当用户请求关闭菜单时调用（例如点击菜单外部区域）。
 * @param 修饰符 应用于菜单内容的 [Modifier]。
 * @param 偏移 相对于菜单位置的 [DpOffset]。
 * @param 属性 用于进一步自定义此弹出窗口行为的 [PopupProperties]。
 * @param 内容 此下拉菜单的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
expect fun 下拉菜单弹出(
    扩展: Boolean,
    取消请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    偏移: DpOffset = DpOffset(0.dp, 0.dp),
    属性: PopupProperties = DefaultMenuProperties,
    内容: @Composable ColumnScope.() -> Unit,
)

// TODO 如有对应 MIO 页面，可在此添加链接。
// TODO 如有可用图片，可在此添加链接。
/**
 * 用于在 [下拉菜单弹出] 内创建视觉上明显分组的组合项。
 *
 * 该组件为 [内容] 添加额外样式，用于将相关菜单项分组。
 *
 * @param 形状 菜单组的 [MenuGroupShapes]。所提供的形状应根据菜单中组的数量及其位置确定，可借助便捷函数 [MenuDefaults.groupShape] 轻松获取所需形状。
 * @param 修饰符 应用于该菜单组的 [Modifier]。
 * @param 容器颜色 菜单的容器颜色。预定义了两种容器颜色，分别位于 [MenuDefaults.groupStandardContainerColor]
 * 与 [MenuDefaults.groupVibrantContainerColor]，可直接使用。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器表面叠加一层半透明的“主色”遮罩。
 * 提高色调高度（tonal elevation）值，将在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 菜单下方阴影的海拔高度。
 * @param 边框 围绕菜单组容器绘制的边框。
 * @param 内容内边距 应用于该菜单组内容的内边距。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察并发送该菜单组的 [Interaction]。
 * @param 内容 此菜单组的内容，通常为 [DropdownMenuItem]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单组(
    形状: MenuGroupShapes,
    修饰符: Modifier = Modifier,
    容器颜色: Color = MenuDefaults.groupStandardContainerColor,
    色调阴影: Dp = MenuDefaults.TonalElevation,
    视觉阴影: Dp = MenuDefaults.ShadowElevation,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuGroupContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DropdownMenuGroup(
        shapes = 形状,
        modifier = 修饰符,
        containerColor = 容器颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 菜单在临时表面上显示一系列选项，当用户与按钮、操作或其他控件交互时出现。
 *
 * ![Dropdown menuimage](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * @param 文本 菜单项的文本。
 * @param 单击回调 点击该菜单项时调用。
 * @param 修饰符 应用于该菜单项的 [Modifier]。
 * @param 前导图标 可选的头部图标，显示在菜单项文本开头。
 * @param 尾随图标 可选的尾部图标，显示在菜单项文本末尾。该位置也可使用 [文本] 来指示键盘快捷键。
 * @param 已启用 控制该菜单项的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为禁用。
 * @param 颜色 用于解析该菜单项在不同状态下所用颜色的 [MenuItemColors]。参见 [MenuDefaults.itemColors]。
 * @param 内容内边距 应用于该菜单项内容的内边距。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察并发送该菜单项的 [Interaction]。
 * 可借此改变菜单项外观或在不同状态下预览菜单项。注意：即使传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
expect fun 下拉菜单项(
    文本: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色: MenuItemColors = MenuDefaults.itemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    交互源: MutableInteractionSource? = null,
)

// TODO 如有对应 MIO 页面，可在此添加链接。
// TODO 如有可用图片，可在此添加链接。
/**
 * 菜单在临时表面上显示一系列选项，当用户与按钮、操作或其他控件交互时出现。
 *
 * @param 单击回调 点击该菜单项时调用。
 * @param 文本 菜单项的文本。
 * @param 形状 该菜单项的 [Shape]。形状应根据组或菜单中的项数及该项所处位置决定：列表首项请使用 [MenuDefaults.leadingItemShape]
 * 列表中间项使用 [MenuDefaults.middleItemShape]、列表末项使用 [MenuDefaults.trailingItemShape]
 * @param 修饰符 应用于该菜单项的 [Modifier]。
 * @param 前导图标 可选的头部图标，在菜单项未选中时显示。
 * @param 尾随图标 可选的尾部图标，显示在菜单项文本末尾。
 * @param 已启用 控制该菜单项的启用状态。当为 `false` 时，组件不会响应用户输入。
 * @param 颜色 用于解析该菜单项在不同状态下所用颜色的 [MenuItemColors]。
 * @param 内容内边距 应用于该菜单项内容的内边距。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察并发送该菜单项的 [Interaction]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色: MenuItemColors = MenuDefaults.itemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    交互源: MutableInteractionSource? = null,
) {
    DropdownMenuItem(
        onClick = 单击回调,
        text = 文本,
        shape = 形状,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

// TODO 如有对应 MIO 页面，可在此添加链接。
// TODO 如有可用图片，可在此添加链接。
/**
 * 一个根据 [已选中] 状态改变样式的菜单项。
 *
 * 该组合项适用于表示“开/关”设置的菜单项，在菜单中表现为复选框或开关。
 *
 * @param 已选中 该菜单项当前是否被选中。
 * @param 已选中改变回调 点击该菜单项时调用，并返回新的选中状态。
 * @param 文本 菜单项的文本。
 * @param 形状 用于解析该菜单项形状的 [MenuItemShapes]。其形状由 [已选中] 值决定，并应依据组或菜单中的项数及该项所处位置选择。
 * 可借助便捷函数 [MenuDefaults.itemShape] 快速获取所需形状。
 * @param 修饰符 应用于该菜单项的 [Modifier]。
 * @param 前导图标 可选的头部图标，在菜单项未选中时显示。
 * @param 已选中前导图标 可选的头部图标，在菜单项被选中时显示。
 * @param 尾随图标 可选的尾部图标，显示在菜单项文本末尾。
 * @param 已启用 控制该菜单项的启用状态。当为 `false` 时，组件不会响应用户输入。
 * @param 颜色 用于解析该菜单项在不同状态下所用颜色的 [MenuItemColors]。 预定义了两个 [MenuItemColors]，分别位于
 * [MenuDefaults.selectableItemColors] 和 [MenuDefaults.selectableItemVibrantColors]，可直接使用或按需修改。
 * @param 内容内边距 应用于该菜单项内容的内边距。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察并发送该菜单项的 [Interaction]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    文本: @Composable () -> Unit,
    形状: MenuItemShapes,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    已选中前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色: MenuItemColors = MenuDefaults.selectableItemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    交互源: MutableInteractionSource? = null,
) {
    DropdownMenuItem(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        text = 文本,
        shapes = 形状,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        checkedLeadingIcon = 已选中前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

// TODO 如有对应 MIO 页面，可在此添加链接。
// TODO 如有可用图片，可在此添加链接。
/**
 * 一个根据 [已选择] 状态改变样式的菜单项。
 *
 * 该组合项适用于表示“开/关”设置的菜单项，在菜单中表现为单选按钮。
 *
 * @param 已选择 该菜单项当前是否被选中。
 * @param 单击回调 点击该菜单项时调用。
 * @param 文本 菜单项的文本。
 * @param 形状 用于解析该菜单项形状的 [MenuItemShapes]。其形状由 [已选择] 值决定，并应依据组或菜单中的项数及该项所处位置选择。
 * 可借助便捷函数 [MenuDefaults.itemShape] 快速获取所需形状。
 * @param 修饰符 应用于该菜单项的 [Modifier]。
 * @param 前导图标 可选的头部图标，在菜单项未选中时显示。
 * @param 已选中前导图标 可选的头部图标，在菜单项被选中时显示。
 * @param 尾随图标 可选的尾部图标，显示在菜单项文本末尾。
 * @param 已启用 控制该菜单项的启用状态。当为 `false` 时，组件不会响应用户输入。
 * @param 颜色 用于解析该菜单项在不同状态下所用颜色的 [MenuItemColors]。 预定义了两个 [MenuItemColors]，分别位于
 * [MenuDefaults.selectableItemColors] 和 [MenuDefaults.selectableItemVibrantColors]，可直接使用或按需修改。
 * @param 内容内边距 应用于该菜单项内容的内边距。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察并发送该菜单项的 [Interaction]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    已选择: Boolean,
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    形状: MenuItemShapes,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    已选中前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色: MenuItemColors = MenuDefaults.selectableItemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    交互源: MutableInteractionSource? = null,
) {
    DropdownMenuItem(
        selected = 已选择,
        onClick = 单击回调,
        text = 文本,
        shapes = 形状,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        checkedLeadingIcon = 已选中前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

// TODO: 考虑将其移至公共 [MenuDefaults] 中。
internal expect val DefaultMenuProperties: PopupProperties




