package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.IconToggleButtonShapes
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape


/**
 * [Material Design standard icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/standard-icon-button.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.iconButtonVibrantColors]
 * 和[IconButtonDefaults.iconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来更改
 * 图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 形状 此图标按钮的[Shape]。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    交互源: MutableInteractionSource? = null,
    形状: Shape = IconButtonDefaults.standardShape,
    内容: @Composable () -> Unit,
) =
    IconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        shape = 形状,
        content = 内容,
    )

/**
 * [Material Design standard icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_icon_button_round_enabled_pressed.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.iconButtonVibrantColors]
 * 和[IconButtonDefaults.iconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 图标按钮(
    单击回调: () -> Unit,
    形状: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    IconButton(
        onClick = 单击回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design standard icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/standard-icon-toggle-button.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标切换按钮在不同状态下使用的颜色。参见[IconButtonDefaults.iconToggleButtonVibrantColors]
 * 和[IconButtonDefaults.iconToggleButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 形状 此图标按钮的[Shape]。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    形状: Shape = IconButtonDefaults.standardShape,
    内容: @Composable () -> Unit,
) =
    IconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        shape = 形状,
        content = 内容,
    )

/**
 * [Material Design standard icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_icon_button_round_unselected_select.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 形状 [IconToggleButtonShapes]，图标切换按钮根据用户与此按钮的交互而在其间变形的形状。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.iconToggleButtonVibrantColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonVibrantColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    IconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-icon-button.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 填充图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_filled_icon_button_round_enabled_pressed.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 填充图标按钮(
    单击回调: () -> Unit,
    形状: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconButton(
        onClick = 单击回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-icon-toggle-button.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 填充图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色: IconToggleButtonColors = IconButtonDefaults.filledIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_filled_icon_button_round_unselected_select.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 填充图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconToggleButtonColors = IconButtonDefaults.filledIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal iconbutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled tonal icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-icon-button.png)
 *
 * 填充色调图标按钮是一种中等强调度的图标按钮，是默认[FilledIconButton]和[OutlinedIconButton]之间的替代中间方案。
 * 它们可用于较低优先级图标按钮需要比轮廓样式稍强强调度的场景。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 填充色调图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色: IconButtonColors = IconButtonDefaults.filledTonalIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal iconbutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled tonal icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_tonal_filled_icon_button_round_enabled_pressed.png)
 *
 * 填充色调图标按钮是一种中等强调度的图标按钮，是默认[FilledIconButton]和[OutlinedIconButton]之间的替代中间方案。
 * 它们可用于较低优先级图标按钮需要比轮廓样式稍强强调度的场景。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 填充色调图标按钮(
    单击回调: () -> Unit,
    形状: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconButtonColors = IconButtonDefaults.filledTonalIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconButton(
        onClick = 单击回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled tonal icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-icon-toggle-button.png)
 *
 * 填充色调切换图标按钮是一种中等强调度的图标切换按钮，是默认[FilledIconToggleButton]和[OutlinedIconToggleButton]之间的替代中间方案。
 * 它们可用于较低优先级图标按钮需要比轮廓样式稍强强调度的场景。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 填充色调图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色: IconToggleButtonColors = IconButtonDefaults.filledTonalIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Filled tonal icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_tonal_filled_icon_button_round_unselected_select.png)
 *
 * 填充色调切换图标按钮是一种中等强调度的图标切换按钮，是默认[FilledIconToggleButton]和[OutlinedIconToggleButton]之间的替代中间方案。
 * 它们可用于较低优先级图标按钮需要比轮廓样式稍强强调度的场景。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 填充色调图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconToggleButtonColors = IconButtonDefaults.filledTonalIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Outlined icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/outlined-icon-button.png)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * 当组件需要与背景更强的视觉分离时使用此"填充式"图标按钮。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 轮廓图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状 和边框（当[边框]不为null时）
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.outlinedIconButtonVibrantColors]
 * 和[IconButtonDefaults.outlinedIconButtonColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。传入`null`表示无边框。参见[IconButtonDefaults.outlinedIconButtonBorder]
 * 和[IconButtonDefaults.outlinedIconButtonBorder]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 轮廓图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.outlinedShape,
    颜色: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconButtonBorder(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Outlined icon buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_outlined_icon_button_round_enabled_pressed.png)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * 当组件需要与背景更强的视觉分离时使用此"填充式"图标按钮。
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 轮廓图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.outlinedIconButtonVibrantColors]
 * 和[IconButtonDefaults.outlinedIconButtonColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。传入`null`表示无边框。参见[IconButtonDefaults.outlinedIconButtonBorder]
 * 和[IconButtonDefaults.outlinedIconButtonBorder]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 轮廓图标按钮(
    单击回调: () -> Unit,
    形状: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconButtonBorder(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconButton(
        onClick = 单击回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Outlined icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/outlined-icon-toggle-button.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此图标按钮容器的形状 和边框（当[边框]不为null时）
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标切换按钮在不同状态下使用的颜色。参见[IconButtonDefaults.outlinedIconToggleButtonVibrantColors]
 * 和[IconButtonDefaults.outlinedIconToggleButtonColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。传入`null`表示无边框。参见[IconButtonDefaults.outlinedIconToggleButtonVibrantBorder]
 * 和[IconButtonDefaults.outlinedIconToggleButtonBorder]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 轮廓图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.outlinedShape,
    颜色: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonBorder(已启用, 已选中),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon togglebutton](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助人们通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Outlined icon toggle buttonimage](https://developer.android.com/images/reference/androidx/compose/material3/small_outlined_icon_button_round_unselected_select.png)
 *
 * [内容]通常应为[图标]（参见[androidx.compose.material.icons.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为48 x 48 dp，以符合无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 形状 此图标按钮根据用户与图标按钮的交互而在其间变形的[IconButtonShapes]。
 * @param 修饰符 要应用于此图标按钮的[Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见[IconButtonDefaults.outlinedIconToggleButtonVibrantColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。传入`null`表示无边框。参见[IconButtonDefaults.outlinedIconToggleButtonVibrantBorder]。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此图标按钮的[Interaction]。您可以使用它来
 * 更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 内容 此图标按钮的内容，通常为[图标]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 轮廓图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonVibrantColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonVibrantBorder(已启用, 已选中),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )



