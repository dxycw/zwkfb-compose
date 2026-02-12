package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 默认标签页，亦称主导航标签页。标签页用于在不同屏幕、数据集及其他交互之间组织内容。
 *
 * ![Tabsimage](https://developer.android.com/images/reference/androidx/compose/material3/secondary-tabs.png)
 *
 * 标签页使用文本标签和/或图标表示单个内容页面。它通过使用 [已选中内容颜色] 为文本标签和/或图片着色来表示其选中状态。
 *
 * 此组件通常应在 [标签行] 内部使用，有关示例用法请参阅相应文档。
 *
 * 此标签页提供 [文本] 和/或 [图标] 槽位 —— 如需对内容无预设限制的通用标签页，请参阅其他 Tab 重载版本。
 *
 * @param 已选中 判断此标签页是否已选中
 * @param 单击回调 当此标签页被点击时调用
 * @param 修饰符 要应用于此标签页的 [Modifier]
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，且在视觉效果和无障碍服务中均呈现为禁用状态。
 * @param 文本 此标签页中显示的文本标签
 * @param 图标 此标签页中显示的图标
 * @param 已选中内容颜色 此标签页选中时内容及涟漪效果的颜色
 * @param 非已选中内容颜色 此标签页未选中时内容的颜色
 * @param 交互源 一个可选的提升 [MutableInteractionSource]，用于观察和发出此标签页的 [Interaction]。
 * 你可以用它来改变标签页的外观，或在不同状态下预览标签页。请注意，如果传入 `null`，交互行为仍会在内部发生。
 * @see LeadingIconTab
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 标签(
    已选中: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本: @Composable (() -> Unit)? = null,
    图标: @Composable (() -> Unit)? = null,
    已选中内容颜色: Color = LocalContentColor.current,
    非已选中内容颜色: Color = 已选中内容颜色,
    交互源: MutableInteractionSource? = null,
) {
    Tab(
        selected = 已选中,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        text = 文本,
        icon = 图标,
        selectedContentColor = 已选中内容颜色,
        unselectedContentColor = 非已选中内容颜色,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 标签页（Tabs）用于在不同屏幕、数据集及其他交互之间组织内容。
 *
 * LeadingIconTab 使用文本标签和前置图标（位于标签前部的图标）来表示单个内容页面。它通过将文本标签和图标渲染为 [selectedContentColor] 颜色来表现其选中状态。
 *
 * 此组件通常应在 [标签行] 内部使用，有关示例用法请参阅相应文档。
 *
 * @param 已选中 判断此标签页是否已选中
 * @param 单击回调 当此标签页被点击时调用
 * @param 文本 此标签页中显示的文本标签
 * @param 图标 此标签页中显示的图标. 应该是24.dp
 * @param 修饰符 要应用于此标签页的 [Modifier]
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，且在视觉效果和无障碍服务中均呈现为禁用状态。
 * @param 已选中内容颜色 此标签页选中时内容及涟漪效果的颜色
 * @param 非已选中内容颜色 此标签页未选中时内容的颜色
 * @param 交互源 一个可选的提升 [MutableInteractionSource]，用于观察和发出此标签页的 [Interaction]。
 * 你可以用它来改变标签页的外观，或在不同状态下预览标签页。请注意，如果传入 `null`，交互行为仍会在内部发生。
 * @see Tab
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 前导图标标签(
    已选中: Boolean,
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    已选中内容颜色: Color = LocalContentColor.current,
    非已选中内容颜色: Color = 已选中内容颜色,
    交互源: MutableInteractionSource? = null,
) {
    LeadingIconTab(
        selected = 已选中,
        onClick = 单击回调,
        text = 文本,
        icon = 图标,
        modifier = 修饰符,
        enabled = 已启用,
        selectedContentColor = 已选中内容颜色,
        unselectedContentColor = 非已选中内容颜色,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 标签页（Tabs）用于在不同屏幕、数据集及其他交互之间组织内容。
 *
 * ![Tabsimage](https://developer.android.com/images/reference/androidx/compose/material3/secondary-tabs.png)
 *
 * 通用的 [标签] 重载函数，不强制限定内容与颜色。如需使用带有文本和/或图标特定槽位，并自动提供选中/未选中状态正确颜色的标签页，请查看其他重载版本。
 *
 * @param 已选中 判断此标签页是否已选中
 * @param 单击回调 当此标签页被点击时调用
 * @param 修饰符 要应用于此标签页的 [Modifier]
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，且在视觉效果和无障碍服务中均呈现为禁用状态。
 * @param 已选中内容颜色 此标签页选中时内容及涟漪效果的颜色
 * @param 非已选中内容颜色 此标签页未选中时内容的颜色
 * @param 交互源 一个可选的提升 [MutableInteractionSource]，用于观察和发出此标签页的 [Interaction]。
 * 你可以用它来改变标签页的外观，或在不同状态下预览标签页。请注意，如果传入 `null`，交互行为仍会在内部发生。
 * @param 内容 此标签页的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 标签(
    已选中: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    已选中内容颜色: Color = LocalContentColor.current,
    非已选中内容颜色: Color = 已选中内容颜色,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Tab(
        selected = 已选中,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        selectedContentColor = 已选中内容颜色,
        unselectedContentColor = 非已选中内容颜色,
        interactionSource = 交互源,
        content = 内容,
    )
}



