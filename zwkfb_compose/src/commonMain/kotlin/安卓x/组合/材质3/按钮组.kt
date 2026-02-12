package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ButtonGroupMenuState
import androidx.compose.material3.ButtonGroupScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.ToggleButtonShapes
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

// TODO 当 mio 页面可用时添加链接。
// TODO 当图片可用时添加链接。
/**
 * 一种布局组件，可将其子项按水平顺序排列。当某个子项使用带有相关 [MutableInteractionSource] 的 [Modifier.animateWidth] 时，
 * 该按钮组能够监听交互事件，并在按压时扩展该子项的宽度，同时压缩相邻子项的宽度。
 *
 * 相连按钮组是按钮组的一种变体，其首、尾按钮形状不对称，专用于完成选择操作。
 *
 * @param 修饰符 应用于此按钮组的 [Modifier]。
 * @param 扩展比率 用于控制交互子项宽度变化比例的浮点数。该值决定被按压的子项在水平方向上扩展自身、同时压缩相邻子项的幅度。
 * 默认值采用 [ButtonGroupDefaults.ExpandedRatio]，按压时交互子项将按该比例扩展，并将变化传导给相邻子项。若传入 0f，
 * 则交互子项完全不扩展，相邻子项也不被压缩。若传入 1f，则交互子项在按压时将扩展至其默认宽度的 200%。
 * @param 水平排列 按钮组子项的水平排列方式。
 * @param 内容 按钮组中显示的内容，建议使用 Material3 组件，或使用带有 [Modifier.interactionSourceData] 标记的可组合项。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Deprecated(
    message =
        "请使用带 `overflowIndicator` 参数的重载。当前重载会在项目过多、屏幕无法整齐容纳时直接把内容截断。",
    replaceWith =
        ReplaceWith("ButtonGroup(overflowIndicator, modifier, expandedRatio, horizontalArrangement, content)"),
    level = DeprecationLevel.WARNING,
)
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 按钮组(
    修饰符: Modifier = Modifier,
    @FloatRange(0.0) 扩展比率: Float = 按钮组默认值.扩展比率,
    水平排列: Arrangement.Horizontal = 按钮组默认值.水平排列,
    内容: @Composable ButtonGroupScope.() -> Unit,
) {
    ButtonGroup(
        modifier = 修饰符,
        expandedRatio = 扩展比率,
        horizontalArrangement = 水平排列,
        content = 内容,
    )
}

// TODO 当 mio 页面可用时添加链接。
// TODO 当图片可用时添加链接。
/**
 * 一种布局组件，可将其子项按水平顺序排列。当某个子项使用带有相关 [MutableInteractionSource] 的 [Modifier.animateWidth] 时，
 * 该按钮组能够监听交互事件，并在按压时扩展该子项的宽度，同时压缩相邻子项的宽度。此外，如果项目过多或单个项目过宽导致无法全部显示在屏幕上，
 * 多余的项目将自动溢出到下拉菜单中。
 *
 * 相连按钮组是按钮组的一种变体，其首、尾按钮形状不对称，专用于完成选择操作。
 *
 * @param 溢出指示器 当按钮组需要溢出时显示在末尾的可组合项，它接收一个 [ButtonGroupMenuState] 参数。
 * @param 修饰符 应用于此按钮组的 [Modifier]。
 * @param 扩展比率 一个浮点数，表示交互子项宽度的百分比，用于在按压时扩展该子项并压缩相邻子项。默认情况下，标准按钮组会按
 * [ButtonGroupDefaults.ExpandedRatio] 的比例扩展被按压的子项，并将变化传导给相邻子项。若传入 0f，则被按压的子项不会扩展，
 * 相邻子项也不会被压缩。若传入 1f，则被按压的子项在按压时将扩展至其默认宽度的 200%。
 * @param 水平排列 按钮组子项的水平排列方式。
 * @param 垂直对齐 按钮组子项的垂直对齐方式。
 * @param 内容 按钮组中显示的内容，建议使用带有 [Modifier.animateWidth] 标记的可组合项。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 按钮组(
    溢出指示器: @Composable (ButtonGroupMenuState) -> Unit,
    修饰符: Modifier = Modifier,
    @FloatRange(0.0) 扩展比率: Float = 按钮组默认值.扩展比率,
    水平排列: Arrangement.Horizontal = 按钮组默认值.水平排列,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    内容: ButtonGroupScope.() -> Unit,
) {
    ButtonGroup(
        overflowIndicator = 溢出指示器,
        modifier = 修饰符,
        expandedRatio = 扩展比率,
        horizontalArrangement = 水平排列,
        verticalAlignment = 垂直对齐,
        content = 内容,
    )
}

/** [按钮组] 使用的默认值。 */
@ExperimentalMaterial3ExpressiveApi
object 按钮组默认值 { //ButtonGroupDefaults
    /**
     * 默认的浮点数值，表示交互子项宽度的百分比。标准按钮组默认会把被按压的子项扩展其自身宽度的 15%，并将这一变化传导给相邻子项，
     * 同时压缩相邻子项的宽度。
     */
    val 扩展比率 = ButtonGroupDefaults.ExpandedRatio

    /** 标准按钮组在子项之间使用的默认排列方式。 */
    val 水平排列: Arrangement.Horizontal =
        ButtonGroupDefaults.HorizontalArrangement

    /** 相连按钮组在子项之间使用的默认间距。 */
    val 已连接空间: Dp = ButtonGroupDefaults.ConnectedSpaceBetween

    /** 相连按钮组中首个按钮的默认形状。 */
    val 已连接前导按钮形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedLeadingButtonShape

    /** 相连按钮组中首个按钮在按压状态下的默认形状。 */
    val 已连接前导按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedLeadingButtonPressShape

    /** 相连按钮组中末尾按钮的默认形状。 */
    val 已连接尾随按钮形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedTrailingButtonShape

    /** 相连按钮组中末尾按钮在按压状态下的默认形状。 */
    val 已连接尾随按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedTrailingButtonPressShape

    /** 相连按钮组中按钮处于选中状态时的默认形状。 */
    val 已连接按钮已选中形状 = ButtonGroupDefaults.connectedButtonCheckedShape

    /** 相连按钮组中中间按钮在按压状态下的默认形状。 */
    val 已连接中间按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedMiddleButtonPressShape

    /** [ConnectedButtonGroup] 中起始按钮的默认形状。 */
    @Composable
    fun 已连接前导按钮形状(
        形状: Shape = 已连接前导按钮形状,
        按压形状: Shape = 已连接前导按钮按压形状,
        已选中形状: Shape = 已连接按钮已选中形状,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedLeadingButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

    /**
     * [ConnectedButtonGroup] 中“中间按钮”的默认形状。中间按钮指既非起始也非末尾的按钮。
     */
    @Composable
    fun 已连接中间按钮形状(
        形状: Shape = ShapeDefaults.Small,
        按压形状: Shape = 已连接中间按钮按压形状,
        已选中形状: Shape = 已连接按钮已选中形状,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedMiddleButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

    /** [ConnectedButtonGroup] 中末尾按钮的默认形状。*/
    @Composable
    fun 已连接尾随按钮形状(
        形状: Shape = 已连接尾随按钮形状,
        按压形状: Shape = 已连接尾随按钮按压形状,
        已选中形状: Shape = 已连接按钮已选中形状,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedTrailingButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

    /**
     * [按钮组] 的默认溢出指示器，使用 [FilledIconButton]。点击后会打开与所提供的 [ButtonGroupMenuState] 关联的菜单。
     *
     * @param 菜单状态 用于显示或关闭溢出菜单的 [ButtonGroupMenuState]。
     * @param 修饰符 应用于溢出指示器的 [Modifier]。
     * @param 已启用 控制该图标按钮的启用状态。当设为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且辅助功能服务也会将其标记为禁用。
     * @param 形状 定义该图标按钮容器的形状。
     * @param 颜色 用于解析该图标按钮在不同状态下颜色的 [IconButtonColors]。参见 [IconButtonDefaults.filledIconButtonColors]。
     * @param 交互源 一个可选的受控 [MutableInteractionSource]，用于观察和发送该图标按钮的 [Interaction]。
     * 你可以借助它改变图标按钮的外观，或在不同状态下预览图标按钮。注意：即使传入 `null`，内部仍会发生交互。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun 溢出指示器(
        菜单状态: ButtonGroupMenuState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        形状: Shape = IconButtonDefaults.filledShape,
        颜色: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
        交互源: MutableInteractionSource? = null,
    ) {
        ButtonGroupDefaults.OverflowIndicator(
            menuState = 菜单状态,
            modifier = 修饰符,
            enabled = 已启用,
            shape = 形状,
            colors = 颜色,
            interactionSource = 交互源,
        )
    }
}

/** State class for the overflow menu in [ButtonGroup]. */
class 按钮组菜单状态(初始显示: Boolean = false) { //ButtonGroupMenuState
    /** Indicates whether the overflow menu is currently expanded. */
    @Deprecated("Keeping for binary compatibility", level = DeprecationLevel.HIDDEN)
    var 是否展开 = 初始显示
        get() = 显示显示
        private set

    /** Indicates whether the overflow menu is currently showing. */
    var 显示显示 by mutableStateOf(初始显示)
        private set

    /** Closes the overflow menu. */
    fun 关闭() {
        显示显示 = false
    }

    /** Show the overflow menu. */
    fun 显示() {
        显示显示 = true
    }
}


/**
 * 按钮组 作用域，用于为子元素指定 [Modifier.weight] 和 [Modifier.animateWidth]，同时提供构建 [按钮组] 内容的 DSL。
 */
@ExperimentalMaterial3ExpressiveApi
interface 按钮组范围 { //ButtonGroupScope
    /**
     * 按照该元素在 [ButtonGroup] 中相对于其他加权兄弟元素的 [权重] 比例来设置其宽度。父容器会先测量未设置权重的子项，
     * 然后将剩余的水平空间按权重比例分配给各加权子项。
     *
     * @param 权重 该元素相对于所有加权兄弟元素总和所应占的宽度比例，必须为正数。
     */
    fun Modifier.权重(@FloatRange(from = 0.0, fromInclusive = false) 权重: Float): Modifier

    /**
     * 指定此子项使用的 InteractionSource，用于监听按压事件，并据此动画扩展被按按钮、同时压缩相邻按钮。
     *
     * @param 交互源 按钮组将要监听的 [InteractionSource]。
     */
    fun Modifier.动画宽度(交互源: InteractionSource): Modifier

    /**
     * 设置该元素在 [ButtonGroup] 内部的垂直对齐方式，此对齐优先级高于 [ButtonGroup] 的 `verticalAlignment` 参数。
     *
     * @param 对齐 该元素的垂直对齐方式。
     */
    @Stable
    fun Modifier.对齐(对齐: Alignment.Vertical): Modifier

    /**
     * 向[ButtonGroup]添加一个可点击的项目
     *
     * @param 单击回调 点击该项时要执行的操作。
     * @param 标签 该项的文本标签。
     * @param 图标 可选项，用于展示该项图标的可组合内容。
     * @param 权重 应用于该项的权重，详见 [ButtonGroupScope.weight]。
     * @param 已启用 该项是否启用。
     */
    fun 可点击项(
        单击回调: () -> Unit,
        标签: String,
        图标: (@Composable () -> Unit)? = null,
        权重: Float = Float.NaN,
        已启用: Boolean = true,
    )

    /**
     * 向 [ButtonGroup] 添加一个可切换（toggleable）的项。
     *
     * @param 已选中 该项当前是否处于选中状态。
     * @param 已选中改变回调 当该项的选中状态发生变化时要执行的操作。
     * @param 图标 可选项，用于展示该项图标的可组合内容。
     * @param 已启用 该项是否启用。
     * @param 权重 应用于该项的权重，详见 [ButtonGroupScope.weight]。
     * @param 标签: 该项的文本标签。
     */
    fun 可切换项(
        已选中: Boolean,
        标签: String,
        已选中改变回调: (Boolean) -> Unit,
        图标: (@Composable () -> Unit)? = null,
        权重: Float = Float.NaN,
        已启用: Boolean = true,
    )

    /**
     * 向 [ButtonGroup] 添加一个自定义项。
     *
     * @param 按钮组内容 要显示在应用栏中的可组合内容。
     * @param 菜单内容 要在溢出菜单中显示的可组合内容，它会接收一个 [ButtonGroupMenuState] 实例。
     */
    fun 自定义项(
        按钮组内容: @Composable () -> Unit,
        菜单内容: @Composable (ButtonGroupMenuState) -> Unit,
    )
}

//=======================================================================

/**
 * 默认的浮点数值，表示交互子项宽度的百分比。标准按钮组默认会把被按压的子项扩展其自身宽度的 15%，并将这一变化传导给相邻子项，
 * 同时压缩相邻子项的宽度。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.扩展比率
    get() = this.ExpandedRatio

/** 标准按钮组在子项之间使用的默认排列方式。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.水平排列: Arrangement.Horizontal
    get() = this.HorizontalArrangement

/** 相连按钮组在子项之间使用的默认间距。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接空间: Dp
    get() = this.ConnectedSpaceBetween

/** 相连按钮组中首个按钮的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接前导按钮形状: Shape
    @Composable
    get() = this.connectedLeadingButtonShape

/** 相连按钮组中首个按钮在按压状态下的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接前导按钮按压形状: Shape
    @Composable
    get() = this.connectedLeadingButtonPressShape

/** 相连按钮组中末尾按钮的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接尾随按钮形状: Shape
    @Composable
    get() = this.connectedTrailingButtonShape

/** 相连按钮组中末尾按钮在按压状态下的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接尾随按钮按压形状: Shape
    @Composable
    get() = this.connectedTrailingButtonPressShape

/** 相连按钮组中按钮处于选中状态时的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接按钮已选中形状
    get() = this.connectedButtonCheckedShape

/** 相连按钮组中中间按钮在按压状态下的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val ButtonGroupDefaults.已连接中间按钮按压形状: Shape
    @Composable
    get() = this.connectedMiddleButtonPressShape

/** [ConnectedButtonGroup] 中起始按钮的默认形状。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonGroupDefaults.已连接前导按钮形状(
    形状: Shape = connectedLeadingButtonShape,
    按压形状: Shape = connectedLeadingButtonPressShape,
    已选中形状: Shape = connectedButtonCheckedShape,
): ToggleButtonShapes =
    this.connectedLeadingButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

/**
 * [ConnectedButtonGroup] 中“中间按钮”的默认形状。中间按钮指既非起始也非末尾的按钮。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonGroupDefaults.已连接中间按钮形状(
    形状: Shape = ShapeDefaults.Small,
    按压形状: Shape = connectedMiddleButtonPressShape,
    已选中形状: Shape = connectedButtonCheckedShape,
): ToggleButtonShapes =
    this.connectedMiddleButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

/** [ConnectedButtonGroup] 中末尾按钮的默认形状。*/
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonGroupDefaults.已连接尾随按钮形状(
    形状: Shape = connectedTrailingButtonShape,
    按压形状: Shape = connectedTrailingButtonPressShape,
    已选中形状: Shape = connectedButtonCheckedShape,
): ToggleButtonShapes =
    this.connectedTrailingButtonShapes(shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状)

/**
 * [按钮组] 的默认溢出指示器，使用 [FilledIconButton]。点击后会打开与所提供的 [ButtonGroupMenuState] 关联的菜单。
 *
 * @param 菜单状态 用于显示或关闭溢出菜单的 [ButtonGroupMenuState]。
 * @param 修饰符 应用于溢出指示器的 [Modifier]。
 * @param 已启用 控制该图标按钮的启用状态。当设为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且辅助功能服务也会将其标记为禁用。
 * @param 形状 定义该图标按钮容器的形状。
 * @param 颜色 用于解析该图标按钮在不同状态下颜色的 [IconButtonColors]。参见 [IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的受控 [MutableInteractionSource]，用于观察和发送该图标按钮的 [Interaction]。
 * 你可以借助它改变图标按钮的外观，或在不同状态下预览图标按钮。注意：即使传入 `null`，内部仍会发生交互。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonGroupDefaults.溢出指示器(
    菜单状态: ButtonGroupMenuState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    交互源: MutableInteractionSource? = null,
) {
    this.OverflowIndicator(
        menuState = 菜单状态,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        interactionSource = 交互源,
    )
}

