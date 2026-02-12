package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design filled card](https://m3.material.io/components/cards/overview)
 *
 * 卡片用于承载与某一主题相关的内容和操作。填充式卡片（Filled Card）与背景的区分度较低，视觉强调效果弱于 Elevated 或 Outlined 卡片。
 *
 * 此 Card 不处理输入事件；若需要可点击或可选择的卡片，请使用其他 Card 重载版本。
 * @param 修饰符 应用于此卡片的 [Modifier]。
 * @param 形状 定义此卡片的容器形状、边框（当 [边框] 不为 null 时）以及阴影（使用 [阴影] 时）。
 * @param 颜色 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.cardColors]。
 * @param 阴影 用于解析该卡片在不同状态下海拔阴影的 [CardElevation]。它控制卡片下方阴影的大小；此外，当容器颜色为
 * [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 边框 绘制在此卡片容器周围的边框。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = 卡片默认值.形状,
    颜色: CardColors = 卡片默认值.卡片颜色(),
    阴影: CardElevation = 卡片默认值.卡片阴影(),
    边框: BorderStroke? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        elevation = 阴影,
        border = 边框,
        content = 内容
    )
}

/**
 * [Material Design filled card](https://m3.material.io/components/cards/overview)
 *
 * 卡片用于承载与某一主题相关的内容和操作。填充式卡片（Filled Card）与背景的区分度较低，视觉强调效果弱于 Elevated 或 Outlined 卡片。
 *
 * 此 Card 会处理点击事件，并在被点击时调用其 [单击回调] 回调。
 * @param 单击回调 点击此卡片时调用。
 * @param 修饰符 要应用于此卡片的 [Modifier]。
 * @param 已启用 控制此卡片的启用状态。当设为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 形状 定义此卡片的容器形状、边框（当 [边框] 不为 null 时）以及阴影（使用 [阴影] 时）。
 * @param 颜色 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.cardColors]。
 * @param 阴影 用于解析该卡片在不同状态下海拔阴影的 [CardElevation]。它控制卡片下方阴影的大小；此外，当容器颜色
 * 为 [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 边框 绘制在此卡片容器周围的边框。
 * @param 交互源 一个可选的提举 [MutableInteractionSource]，用于观察并发出此卡片的各种 [Interaction]。
 * 你可以借助它改变卡片外观，或在不同状态下预览卡片。 注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 卡片默认值.形状,
    颜色: CardColors = 卡片默认值.卡片颜色(),
    阴影: CardElevation = 卡片默认值.卡片阴影(),
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Card(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        elevation = 阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design elevated card](https://m3.material.io/components/cards/overview)
 *
 * Elevated 卡片用于承载与某一主题相关的内容和操作，其自带投影阴影，与背景的分离度高于填充式卡片，但低于线框卡片。
 *
 * 此 ElevatedCard 不处理输入事件；若需要可点击或可选择的 ElevatedCard，请使用其他重载版本。
 * @param 修饰符 应用于此卡片的 [Modifier]。
 * @param 形状 定义此卡片的容器形状以及（使用 [阴影] 时的）阴影轮廓。
 * @param 颜色 [CardColors] 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.elevatedCardColors]。
 * @param 阴影 [CardElevation] 用于解析该卡片在不同状态下的海拔阴影。它控制卡片下方阴影的大小；此外，当容器颜色为
 * [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 阴影卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = 卡片默认值.阴影形状,
    颜色: CardColors = 卡片默认值.阴影卡片颜色(),
    阴影: CardElevation = 卡片默认值.阴影卡片阴影(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ElevatedCard(
        modifier = 修饰符,
        shape = 形状,
        elevation = 阴影,
        colors = 颜色,
        content = 内容,
    )

/**
 * [Material Design elevated card](https://m3.material.io/components/cards/overview)
 *
 * Elevated 卡片用于承载与某一主题相关的内容和操作，其自带投影阴影，与背景的分离度高于填充式卡片，但低于线框卡片。
 *
 * 此 ElevatedCard 会处理点击事件，并在被点击时调用其 [单击回调] lambda。
 * @param 单击回调 点击此卡片时调用。
 * @param 修饰符 应用于此卡片的 [Modifier]。
 * @param 已启用 控制此卡片的启用状态。当设为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 形状 定义此卡片的容器形状以及（使用 [阴影] 时的）阴影轮廓。
 * @param 颜色 [CardColors] 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.elevatedCardColors]。
 * @param 阴影 [CardElevation] 用于解析该卡片在不同状态下的海拔阴影。它控制卡片下方阴影的大小；此外，当容器颜色为
 * [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 交互源 一个可选的提举 [MutableInteractionSource]，用于观察并发出此卡片的各种 [Interaction]。
 * 你可以借助它改变卡片外观，或在不同状态下预览卡片。注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 阴影卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 卡片默认值.阴影形状,
    颜色: CardColors = 卡片默认值.阴影卡片颜色(),
    阴影: CardElevation = 卡片默认值.阴影卡片阴影(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    ElevatedCard(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined card](https://m3.material.io/components/cards/overview)
 *
 * Outlined 卡片用于承载与某一主题相关的内容和操作，其容器四周带有可见边框，因此相比其他类型能带来更强的视觉强调效果。
 *
 * 此 轮廓卡片 不处理输入事件；若需要可点击或可选择的 轮廓卡片，请使用其他重载版本。
 * @param 修饰符 应用于此卡片的 [Modifier]。
 * @param 形状 定义此卡片的容器形状、边框（当 [边框] 不为 null 时）以及阴影（使用 [阴影] 时）。
 * @param 颜色 [CardColors] 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.outlinedCardColors]。
 * @param 阴影 [CardElevation] 用于解析该卡片在不同状态下的海拔阴影。它控制卡片下方阴影的大小；此外，当容器颜色为
 * [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 边框 绘制在此卡片容器周围的边框。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 轮廓卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = 卡片默认值.轮廓形状,
    颜色: CardColors = 卡片默认值.轮廓卡片颜色(),
    阴影: CardElevation = 卡片默认值.轮廓卡片阴影(),
    边框: BorderStroke = 卡片默认值.轮廓卡片边框(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    OutlinedCard(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        elevation = 阴影,
        border = 边框,
        content = 内容,
    )

/**
 * [Material Design outlined card](https://m3.material.io/components/cards/overview)
 *
 * Outlined 卡片用于承载与某一主题相关的内容和操作，其容器四周带有可见边框，因此相比其他类型能带来更强的视觉强调效果。
 *
 * 此 轮廓卡片 会处理点击事件，并在被点击时调用其 [单击回调] 回调。
 * @param 单击回调 点击此卡片时调用。
 * @param 修饰符 要应用于此卡片的 [Modifier]。
 * @param 已启用 控制此卡片的启用状态。当设为 `false` 时，组件不会响应用户输入，视觉上呈禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 形状 定义此卡片的容器形状、边框（当 [边框] 不为 null 时）以及阴影（使用 [阴影] 时）。
 * @param 颜色 用于解析该卡片在不同状态下所需颜色的 [CardColors]。参见 [CardDefaults.outlinedCardColors]。
 * @param 阴影 用于解析该卡片在不同状态下海拔阴影的 [CardElevation]。它控制卡片下方阴影的大小；此外，当容器颜色为
 * [androidx.compose.material3.ColorScheme.surface] 时，它还决定叠 加在主色上的强度。
 * 参见 [androidx.compose.material3.Surface]。
 * @param 边框 绘制在此卡片容器周围的边框。
 * @param 交互源 一个可选的提举 [MutableInteractionSource]，用于观察并发出此卡片的各种 [Interaction]。
 * 你可以借助它改变卡片外观，或在不同状态下预览卡片。 注意：即使传入 `null`，内部仍会发生交互。
 * @param 内容 显示在卡片上的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 轮廓卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = 卡片默认值.轮廓形状,
    颜色: CardColors = 卡片默认值.轮廓卡片颜色(),
    阴影: CardElevation = 卡片默认值.轮廓卡片阴影(),
    边框: BorderStroke = 卡片默认值.轮廓卡片边框(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    OutlinedCard(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色,
        elevation = 阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/** 包含所有卡片类型所使用的默认值。 */
object 卡片默认值 {
    // 默认形状
    /** 卡片的默认形状。 */
    val 形状: Shape
        @Composable get() = CardDefaults.shape

    /** 阴影卡片 的默认形状。 */
    val 阴影形状: Shape
        @Composable get() = CardDefaults.elevatedShape

    /** 轮廓卡片 的默认形状。 */
    val 轮廓形状: Shape
        @Composable get() = CardDefaults.outlinedShape

    /**
     * 创建一个 [CardElevation]，它将根据 Material 规范为 [卡片] 在不同状态间提供动画过渡的海拔阴影值。
     *
     * @param 默认阴影 [卡片] 在没有其他交互状态时所使用的海拔阴影。
     * @param 按压阴影 [卡片] 被按下时所使用的海拔阴影。
     * @param 聚焦阴影 [卡片] 获得焦点时所使用的海拔阴影。
     * @param 悬停阴影 [卡片] 悬停时所使用的海拔阴影。
     * @param 拖动阴影 [卡片] 被拖动时所使用的海拔阴影。
     * @param 禁用阴影 [卡片] 被禁用时的海拔阴影。
     */
    @Composable
    fun 卡片阴影(
        默认阴影: Dp = 0.0.dp,
        按压阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        拖动阴影: Dp = 6.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): CardElevation =
        CardDefaults.cardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖动阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardElevation]，根据 Material 规范为 [阴影卡片] 在不同状态间提供动画过渡的海拔阴影值。
     * @param 默认阴影 [阴影卡片] 在没有其他交互状态时所使用的海拔阴影。
     * @param 按压阴影 [阴影卡片] 被按下时所使用的海拔阴影。
     * @param 聚焦阴影 [阴影卡片] 获得焦点时所使用的海拔阴影。
     * @param 悬停阴影 [阴影卡片] 悬停时所使用的海拔阴影。
     * @param 拖动阴影 [阴影卡片] 被拖动时所使用的海拔阴影。
     * @param 禁用阴影 [阴影卡片] 被禁用时的海拔阴影。
     */
    @Composable
    fun 阴影卡片阴影(
        默认阴影: Dp = 1.0.dp,
        按压阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
        拖动阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 1.0.dp,
    ): CardElevation =
        CardDefaults.elevatedCardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖动阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardElevation]，根据 Material 规范为 [轮廓卡片] 在不同状态间提供动画过渡的海拔阴影值。
     * @param 默认阴影 [轮廓卡片] 在没有其他交互状态时所使用的海拔阴影。
     * @param 按压阴影 [轮廓卡片] 被按下时所使用的海拔阴影。
     * @param 聚焦阴影 [轮廓卡片] 获得焦点时所使用的海拔阴影。
     * @param 悬停阴影 [轮廓卡片] 悬停时所使用的海拔阴影。
     * @param 拖动阴影 [轮廓卡片] 被拖动时所使用的海拔阴影。
     * @param 禁用阴影 [轮廓卡片] 被禁用时的海拔阴影。
     */
    @Composable
    fun 轮廓卡片阴影(
        默认阴影: Dp = 0.0.dp,
        按压阴影: Dp = 默认阴影,
        聚焦阴影: Dp = 默认阴影,
        悬停阴影: Dp = 默认阴影,
        拖动阴影: Dp = 6.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): CardElevation =
        CardDefaults.outlinedCardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖动阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardColors]，用于表示 [卡片] 中默认的容器颜色和内容颜色。
     */
    @Composable fun 卡片颜色() = CardDefaults.cardColors()

    /**
     * 创建一个 [CardColors]，用于表示 [卡片] 中默认的容器颜色和内容颜色。
     * @param 容器颜色 [卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 [卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 [卡片] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 [卡片] 在未启用状态下的内容颜色。
     */
    @Composable
    fun 卡片颜色(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = 内容颜色为了(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = 内容颜色.copy(0.38f),
    ): CardColors =
        CardDefaults.cardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )



    /**
     * 创建一个 [CardColors]，用于表示 [阴影卡片] 中默认的容器颜色和内容颜色。
     */
    @Composable fun 阴影卡片颜色(): CardColors = CardDefaults.elevatedCardColors()

    /**
     * 创建一个 [CardColors]，用于表示 [阴影卡片] 中默认的容器颜色和内容颜色。
     * @param 容器颜色 [阴影卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 [阴影卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 [阴影卡片] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 [阴影卡片] 在未启用状态下的内容颜色。
     */
    @Composable
    fun 阴影卡片颜色(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = 内容颜色为了(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = 内容颜色.copy(0.38f),
    ): CardColors =
        CardDefaults.elevatedCardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /**
     * 创建一个 [CardColors]，用于表示 [轮廓卡片] 中默认的容器颜色和内容颜色。
     */
    @Composable fun 轮廓卡片颜色(): CardColors = CardDefaults.outlinedCardColors()

    /**
     * 创建一个 [CardColors]，用于表示 [轮廓卡片] 中默认的容器颜色和内容颜色。
     *
     * @param 容器颜色 [轮廓卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 [轮廓卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 [轮廓卡片] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 [轮廓卡片] 在未启用状态下的内容颜色。
     */
    @Composable
    fun 轮廓卡片颜色(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = 内容颜色为了(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = 内容颜色为了(容器颜色).copy(0.38f),
    ): CardColors =
        CardDefaults.outlinedCardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /**
     * 创建一个 [BorderStroke]，用于表示 [轮廓卡片] 中的默认边框。
     * @param 已启用 卡片是否启用
     */
    @Composable
    fun 轮廓卡片边框(已启用: Boolean = true): BorderStroke {
        return CardDefaults.outlinedCardBorder(已启用)
    }
}

/**
 * 表示卡片在不同状态下的海拔阴影。
 * - 参见 [CardDefaults.cardElevation] 用于 [卡片] 中默认的海拔阴影值。
 * - 参见 [CardDefaults.elevatedCardElevation] 用于 [阴影卡片] 的默认海拔阴影值。
 * - 参见 [CardDefaults.outlinedCardElevation] 用于 [轮廓卡片] 的默认海拔阴影值。
 */
@Immutable
class 卡片阴影
internal constructor(
    private val  默认阴影: Dp,
    private val 按压阴影: Dp,
    private val 聚焦阴影: Dp,
    private val 悬停阴影: Dp,
    private val 禁用阴影: Dp,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is 卡片阴影) return false

        if (默认阴影 != other.默认阴影) return false
        if (按压阴影 != other.按压阴影) return false
        if (聚焦阴影 != other.聚焦阴影) return false
        if (悬停阴影 != other.悬停阴影) return false
        if (禁用阴影 != other.禁用阴影) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 默认阴影.hashCode()
        result = 31 * result + 按压阴影.hashCode()
        result = 31 * result + 聚焦阴影.hashCode()
        result = 31 * result + 悬停阴影.hashCode()
        result = 31 * result + 禁用阴影.hashCode()
        return result
    }
}

/**
 * 表示卡片在不同状态下所使用的容器与内容颜色。
 *
 * @param 容器颜色 [卡片] 在启用状态下的容器颜色。
 * @param 内容颜色 [卡片] 在启用状态下的内容颜色。
 * @param 禁用容器颜色 [卡片] 在未启用状态下的容器颜色。
 * @param 禁用内容颜色 [卡片] 在未启用状态下的内容颜色。
 * @constructor 创建一个可使用任意颜色的实例。
 */
@Immutable
class 卡片颜色(
    val 容器颜色: Color,
    val 内容颜色: Color,
    val 禁用容器颜色: Color,
    val 禁用内容颜色: Color,
) {
    /**
     * 返回此 CardColors 的一个副本，并可选择性地覆盖其中的部分值。这里使用 Color.Unspecified 表示“沿用源值”。
     */
    fun copy(
        容器颜色: Color = this.容器颜色,
        内容颜色: Color = this.内容颜色,
        禁用容器颜色: Color = this.禁用容器颜色,
        禁用内容颜色: Color = this.禁用内容颜色,
    ): CardColors =
        CardColors(
            容器颜色.takeOrElse { this.容器颜色 },
            内容颜色.takeOrElse { this.内容颜色 },
            禁用容器颜色.takeOrElse { this.禁用容器颜色 },
            禁用内容颜色.takeOrElse { this.禁用内容颜色 },
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is CardColors) return false

        if (容器颜色 != other.containerColor) return false
        if (内容颜色 != other.contentColor) return false
        if (禁用容器颜色 != other.disabledContainerColor) return false
        if (禁用内容颜色 != other.disabledContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 内容颜色.hashCode()
        result = 31 * result + 禁用容器颜色.hashCode()
        result = 31 * result + 禁用内容颜色.hashCode()
        return result
    }
}
