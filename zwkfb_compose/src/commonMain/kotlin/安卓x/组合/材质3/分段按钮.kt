package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * [Material Design segmented Button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 分段按钮帮助人们选择选项、切换视图或对元素进行排序。
 *
 * 默认的可切换分段按钮。也称为轮廓分段按钮。参见[Modifier.toggleable]。
 *
 * 可切换分段按钮应用于选择并非互斥的情况。
 *
 * 这通常应在[MultiChoiceSegmentedButtonRow]内部使用。
 *
 * @param 已选中 此按钮是否被选中
 * @param 已选中改变回调 当按钮被点击时调用的回调，因此请求更改选中状态。
 * @param 形状 此按钮的形状
 * @param 修饰符 要应用于此按钮的[Modifier]
 * @param 已启用 控制此按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [SegmentedButtonColors]，用于解析此分段按钮所使用的颜色。
 * @param 边框 此按钮的边框，参见[SegmentedButtonColors]中不同状态下的按钮。
 * @param 内容内边距 要应用于容器与内容之间内部的间距值。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此按钮的[Interaction]。您可以使用它来更改
 * 按钮的外观或在不同状态下预览按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 图标 此按钮的图标槽位，您可以在未选中状态下传入null，此时内容将位移以显示选中图标；或者为未选中和选中状态传入不同的图标lambda，
 * 此时图标将进行交叉淡入淡出。
 * @param 标签 此按钮内部要渲染的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun MultiChoiceSegmentedButtonRowScope.分段按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    边框: BorderStroke = SegmentedButtonDefaults.borderStroke(颜色.边框颜色(已启用, 已选中)),
    内容内边距: PaddingValues = SegmentedButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    图标: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(已选中) },
    标签: @Composable () -> Unit,
) {
    this.SegmentedButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shape = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        icon = 图标,
        label = 标签,
    )
}

/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 分段按钮帮助人们选择选项、切换视图或对元素进行排序。
 *
 * 默认的可切换分段按钮。也称为轮廓分段按钮。参见[Modifier.selectable]。
 *
 * 可选中分段按钮应用于选择互斥的情况，即一次只能选中一个按钮。
 *
 * 这通常应在[SingleChoiceSegmentedButtonRow]内部使用。
 *
 * @param 已选择 此按钮是否被选中
 * @param 单击回调 当按钮被点击时调用的回调，因此请求更改选中状态。
 * @param 形状 此按钮的形状
 * @param 修饰符 要应用于此按钮的[Modifier]
 * @param 已启用 控制此按钮的启用状态。当为`false`时，此组件将不响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色 [SegmentedButtonColors]，用于解析此分段按钮所使用的颜色。
 * @param 边框 此按钮的边框，参见[SegmentedButtonColors]中不同状态下的按钮。
 * @param 内容内边距 要应用于容器与内容之间内部的间距值。
 * @param 交互源 一个可选的提升的[MutableInteractionSource]，用于观察和发出此按钮的[Interaction]。您可以使用它来更改
 * 按钮的外观或在不同状态下预览按钮。请注意，如果提供`null`，交互仍将在内部发生。
 * @param 图标 此按钮的图标槽位，您可以在未选中状态下传入null，此时内容将位移以显示选中图标；或者为未选中和选中状态传入不同的图标lambda，
 * 此时图标将进行交叉淡入淡出。
 * @param 标签 此按钮内部要渲染的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun SingleChoiceSegmentedButtonRowScope.分段按钮(
    已选择: Boolean,
    单击回调: () -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    边框: BorderStroke = SegmentedButtonDefaults.borderStroke(颜色.边框颜色(已启用, 已选择)),
    内容内边距: PaddingValues = SegmentedButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    图标: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(已选择) },
    标签: @Composable () -> Unit,
) {
    this.SegmentedButton(
        selected = 已选择,
        onClick = 单击回调,
        shape = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        icon = 图标,
        label = 标签,
    )
}

//==============================================================================

@Stable
private fun SegmentedButtonColors.边框颜色(已启用: Boolean, 活动: Boolean): Color {
    return when {
        已启用 && 活动 -> this.activeBorderColor
        已启用 && !活动 -> this.inactiveBorderColor
        !已启用 && 活动 -> this.disabledActiveBorderColor
        else -> this.disabledInactiveBorderColor
    }
}

//==============================================================================

/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 一个用于在行中正确放置和调整[分段按钮]大小的布局。它处理重叠项，使各项的描边正确地位于彼此之上。当选择仅允许一个值时，
 * 使用[单选分段按钮行]以获得正确的语义。
 *
 * @param 修饰符 要应用于此行的[Modifier]。
 * @param 间隔 按钮之间重叠的尺寸。应等于各项上使用的描边宽度。
 * @param 内容 此分段按钮行的内容，通常为一系列[分段按钮]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 单选分段按钮行(
    修饰符: Modifier = Modifier,
    间隔: Dp = SegmentedButtonDefaults.BorderWidth,
    内容: @Composable SingleChoiceSegmentedButtonRowScope.() -> Unit,
) {
    SingleChoiceSegmentedButtonRow(
        modifier = 修饰符,
        space = 间隔,
        content = 内容,
    )
}

/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 一个用于在行中正确放置、调整大小并添加语义的[分段按钮]布局。它处理重叠项，使各项的描边正确地位于彼此之上。
 *
 * [多选分段按钮行] 当选择允许多个值时使用，以获得正确的语义。
 *
 * @param 修饰符 要应用于此行的[Modifier]。
 * @param 间隔 按钮之间重叠的尺寸。应等于各项上使用的描边宽度。
 * @param 内容 此分段按钮行的内容，通常为一系列[分段按钮]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 多选分段按钮行(
    修饰符: Modifier = Modifier,
    间隔: Dp = SegmentedButtonDefaults.BorderWidth,
    内容: @Composable MultiChoiceSegmentedButtonRowScope.() -> Unit,
) {
    MultiChoiceSegmentedButtonRow(
        modifier = 修饰符,
        space = 间隔,
        content = 内容,
    )
}


/* 包含用于[分段按钮行]和[分段按钮]的默认值。 */
@Stable
object 分段按钮默认值 { // SegmentedButtonDefaults

    /**
     * 创建一个[SegmentedButtonColors]，用于表示[分段按钮]在不同状态下使用的不同颜色。
     */
    @Composable
    fun 颜色() = SegmentedButtonDefaults.colors()

    /**
     * 创建一个[SegmentedButtonColors]，用于表示[分段按钮]在不同状态下使用的不同颜色。
     *
     * @param 活动容器颜色 启用且激活状态下容器使用的颜色。
     * @param 活动内容颜色 启用且激活状态下内容使用的颜色。
     * @param 活动边框颜色 启用且激活状态下边框使用的颜色。
     * @param 非活动容器颜色 启用且未激活状态下容器使用的颜色。
     * @param 非活动内容颜色 启用且未激活状态下内容使用的颜色。
     * @param 非活动边框颜色 启用且未激活状态下边框使用的颜色。
     * @param 禁用活动容器颜色 禁用且激活状态下容器使用的颜色。
     * @param 禁用活动内容颜色 禁用且激活状态下内容使用的颜色。
     * @param 禁用活动边框颜色 禁用且激活状态下边框使用的颜色。
     * @param 禁用非活动容器颜色 禁用且未激活状态下容器使用的颜色。
     * @param 禁用非活动内容颜色 禁用且未选中状态下内容使用的颜色。
     * @param 禁用非活动边框颜色 禁用且未激活状态下边框使用的颜色。
     */
    @Composable
    fun 颜色(
        活动容器颜色: Color = Color.Unspecified,
        活动内容颜色: Color = Color.Unspecified,
        活动边框颜色: Color = Color.Unspecified,
        非活动容器颜色: Color = Color.Unspecified,
        非活动内容颜色: Color = Color.Unspecified,
        非活动边框颜色: Color = Color.Unspecified,
        禁用活动容器颜色: Color = Color.Unspecified,
        禁用活动内容颜色: Color = Color.Unspecified,
        禁用活动边框颜色: Color = Color.Unspecified,
        禁用非活动容器颜色: Color = Color.Unspecified,
        禁用非活动内容颜色: Color = Color.Unspecified,
        禁用非活动边框颜色: Color = Color.Unspecified,
    ): SegmentedButtonColors =
        SegmentedButtonDefaults.colors(
            activeContainerColor = 活动容器颜色,
            activeContentColor = 活动内容颜色,
            activeBorderColor = 活动边框颜色,
            inactiveContainerColor = 非活动容器颜色,
            inactiveContentColor = 非活动内容颜色,
            inactiveBorderColor = 非活动边框颜色,
            disabledActiveContainerColor = 禁用活动容器颜色,
            disabledActiveContentColor = 禁用活动内容颜色,
            disabledActiveBorderColor = 禁用活动边框颜色,
            disabledInactiveContainerColor = 禁用非活动容器颜色,
            disabledInactiveContentColor = 禁用非活动内容颜色,
            disabledInactiveBorderColor = 禁用非活动边框颜色,
        )


    /**
     * 分段按钮容器的形状，为获得正确行为，此形状或所需的[CornerBasedShape]应与[项形状]一起使用，并传递给每个分段按钮。
     */
    val 基础形状: CornerBasedShape
        @Composable @ReadOnlyComposable
        get() = SegmentedButtonDefaults.baseShape

    /** 分段按钮中使用的默认边框宽度。 */
    val 边框宽度: Dp = SegmentedButtonDefaults.BorderWidth

    /**
     * 当容器中有[计算]个按钮时，[索引]位置的按钮应具有的形状构造器。
     *
     * @param 索引 此按钮在行中的索引。
     * @param 计算 此行中按钮的数量。
     * @param 基础形状 [CornerBasedShape]，应用于不在起始或结束位置的按钮的基础形状。
     */
    @Composable
    @ReadOnlyComposable
    fun 项形状(索引: Int, 计算: Int, 基础形状: CornerBasedShape = this.基础形状): Shape {
        return SegmentedButtonDefaults.itemShape(
            index = 索引,
            count = 计算,
            baseShape = 基础形状,
        )
    }

    /** [分段按钮]中使用的图标尺寸。 */
    val 图标大小 = SegmentedButtonDefaults.IconSize

    /** 分段按钮使用的默认内容内边距。 */
    val 内容内边距 = SegmentedButtonDefaults.ContentPadding

    /** 用于指示分段按钮已选中或被选中的图标。 */
    @Suppress("ComposableNaming")
    @Composable
    fun 活动图标() = SegmentedButtonDefaults.ActiveIcon()


    /**
     * 分段按钮图标的默认实现。
     *
     * @param 活动 按钮是否被激活。
     * @param 活动内容 通常为[图标大小]尺寸的勾选图标。
     * @param 非活动内容 通常为[图标大小]大小的图标。仅在按钮未选中时显示。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 图标(
        活动: Boolean,
        活动内容: @Composable () -> Unit = { 活动图标() },
        非活动内容: (@Composable () -> Unit)? = null,
    ) {
        SegmentedButtonDefaults.Icon(
            active = 活动,
            activeContent = 活动内容,
            inactiveContent = 非活动内容,
        )
    }

    /**
     * 分段按钮[BorderStroke]的默认工厂，可通过[宽度]和[颜色]进行自定义。当使用与默认不同的宽度时，请确保同时更新
     * [多选分段按钮行]或[单选分段按钮行]的space参数。
     */
    fun 边框描边(颜色: Color, 宽度: Dp = this.边框宽度): BorderStroke =
        SegmentedButtonDefaults.borderStroke(color = 颜色, width = 宽度)

}

//==============================================================================


/**
 * 创建一个[SegmentedButtonColors]，用于表示[分段按钮]在不同状态下使用的不同颜色。
 */
@Composable
fun SegmentedButtonDefaults.颜色() = this.colors()

/**
 * 创建一个[SegmentedButtonColors]，用于表示[分段按钮]在不同状态下使用的不同颜色。
 *
 * @param 活动容器颜色 启用且激活状态下容器使用的颜色。
 * @param 活动内容颜色 启用且激活状态下内容使用的颜色。
 * @param 活动边框颜色 启用且激活状态下边框使用的颜色。
 * @param 非活动容器颜色 启用且未激活状态下容器使用的颜色。
 * @param 非活动内容颜色 启用且未激活状态下内容使用的颜色。
 * @param 非活动边框颜色 启用且未激活状态下边框使用的颜色。
 * @param 禁用活动容器颜色 禁用且激活状态下容器使用的颜色。
 * @param 禁用活动内容颜色 禁用且激活状态下内容使用的颜色。
 * @param 禁用活动边框颜色 禁用且激活状态下边框使用的颜色。
 * @param 禁用非活动容器颜色 禁用且未激活状态下容器使用的颜色。
 * @param 禁用非活动内容颜色 禁用且未选中状态下内容使用的颜色。
 * @param 禁用非活动边框颜色 禁用且未激活状态下边框使用的颜色。
 */
@Composable
fun SegmentedButtonDefaults.颜色(
    活动容器颜色: Color = Color.Unspecified,
    活动内容颜色: Color = Color.Unspecified,
    活动边框颜色: Color = Color.Unspecified,
    非活动容器颜色: Color = Color.Unspecified,
    非活动内容颜色: Color = Color.Unspecified,
    非活动边框颜色: Color = Color.Unspecified,
    禁用活动容器颜色: Color = Color.Unspecified,
    禁用活动内容颜色: Color = Color.Unspecified,
    禁用活动边框颜色: Color = Color.Unspecified,
    禁用非活动容器颜色: Color = Color.Unspecified,
    禁用非活动内容颜色: Color = Color.Unspecified,
    禁用非活动边框颜色: Color = Color.Unspecified,
): SegmentedButtonColors =
    this.colors(
        activeContainerColor = 活动容器颜色,
        activeContentColor = 活动内容颜色,
        activeBorderColor = 活动边框颜色,
        inactiveContainerColor = 非活动容器颜色,
        inactiveContentColor = 非活动内容颜色,
        inactiveBorderColor = 非活动边框颜色,
        disabledActiveContainerColor = 禁用活动容器颜色,
        disabledActiveContentColor = 禁用活动内容颜色,
        disabledActiveBorderColor = 禁用活动边框颜色,
        disabledInactiveContainerColor = 禁用非活动容器颜色,
        disabledInactiveContentColor = 禁用非活动内容颜色,
        disabledInactiveBorderColor = 禁用非活动边框颜色,
    )


/**
 * 分段按钮容器的形状，为获得正确行为，此形状或所需的[CornerBasedShape]应与[项形状]一起使用，并传递给每个分段按钮。
 */
val SegmentedButtonDefaults.基础形状: CornerBasedShape
    @Composable @ReadOnlyComposable
    get() = this.baseShape

/** 分段按钮中使用的默认边框宽度。 */
val SegmentedButtonDefaults.边框宽度: Dp
    get() = this.BorderWidth

/**
 * 当容器中有[计算]个按钮时，[索引]位置的按钮应具有的形状构造器。
 *
 * @param 索引 此按钮在行中的索引。
 * @param 计算 此行中按钮的数量。
 * @param 基础形状 [CornerBasedShape]，应用于不在起始或结束位置的按钮的基础形状。
 */
@Composable
@ReadOnlyComposable
fun SegmentedButtonDefaults.项形状(索引: Int, 计算: Int, 基础形状: CornerBasedShape = this.基础形状): Shape {
    return this.itemShape(
        index = 索引,
        count = 计算,
        baseShape = 基础形状,
    )
}

/** [分段按钮]中使用的图标尺寸。 */
val SegmentedButtonDefaults.图标大小
    get() = this.IconSize

/** 分段按钮使用的默认内容内边距。 */
val SegmentedButtonDefaults.内容内边距
    get() = this.ContentPadding

/** 用于指示分段按钮已选中或被选中的图标。 */
@Suppress("ComposableNaming")
@Composable
fun SegmentedButtonDefaults.活动图标() = this.ActiveIcon()


/**
 * 分段按钮图标的默认实现。
 *
 * @param 活动 按钮是否被激活。
 * @param 活动内容 通常为[图标大小]尺寸的勾选图标。
 * @param 非活动内容 通常为[图标大小]大小的图标。仅在按钮未选中时显示。
 */
@Suppress("ComposableNaming")
@Composable
fun SegmentedButtonDefaults.图标(
    活动: Boolean,
    活动内容: @Composable () -> Unit = { 活动图标() },
    非活动内容: (@Composable () -> Unit)? = null,
) {
    this.Icon(
        active = 活动,
        activeContent = 活动内容,
        inactiveContent = 非活动内容,
    )
}

/**
 * 分段按钮[BorderStroke]的默认工厂，可通过[宽度]和[颜色]进行自定义。当使用与默认不同的宽度时，请确保同时更新
 * [多选分段按钮行]或[单选分段按钮行]的space参数。
 */
fun SegmentedButtonDefaults.边框描边(颜色: Color, 宽度: Dp = BorderWidth): BorderStroke =
    this.borderStroke(color = 颜色, width = 宽度)
