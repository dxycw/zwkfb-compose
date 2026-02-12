package 安卓x.组合.材质3

import androidx.annotation.IntRange
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.SliderState
import androidx.compose.material3.VerticalSlider
import androidx.compose.material3.rememberRangeSliderState
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从一系列数值中进行选择。
 *
 * 它使用 [SliderDefaults.Thumb] 作为滑块的拇指（拖动手柄），使用 [SliderDefaults.Track] 作为滑块的轨道。
 *
 * 滑块在水平条上呈现一段数值范围，用户可从中选择单个值。它们非常适合用于调节音量、亮度或应用图像滤镜等设置。
 *
 * 使用连续滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * @param 值 滑块的当前值；若超出所设 [值范围]，将被强制限制在该范围内。
 * @param 值改变回调 用于更新数值的回调函数
 * @param 修饰符 应用于该滑块的 [Modifier]。
 * @param 已启用 控制滑块的启用状态。当为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 值范围 该滑块可选取的数值范围。传入的 [值] 将被强制限制在此范围内。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 值改变完成回调 当数值更改结束时调用。此回调不应被用于更新滑块数值（应使用 [值改变回调]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 颜色 [SliderColors] 用于解析该滑块在不同状态下所使用颜色的对象。参见 [SliderDefaults.colors]。
 * @param 交互源 用于表示该滑块 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例，
 * 以观察 [Interaction] 并在不同状态下自定义滑块的外观或行为。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 滑块(
    值: Float,
    值改变回调: (Float) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) 刻度数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    颜色: SliderColors = 滑块默认值.颜色(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Slider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        steps = 刻度数,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从一系列数值中进行选择。
 *
 * 滑块在水平条上呈现一段数值范围，用户可从中选择单个值。它们非常适合用于调节音量、亮度或应用图像滤镜等设置。
 *
 * 使用连续滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * 使用自定义滑块拇指的 Slider：
 *
 * 使用自定义轨道和滑块拇指的 Slider：
 *
 * 使用轨道图标的滑块：
 *
 * 带有居中轨道的滑块：
 *
 * @param 值 滑块的当前值；若超出所设 [值范围]，将被强制限制在该范围内。
 * @param 值改变回调 用于更新数值的回调函数
 * @param 修饰符 应用于该滑块的 [Modifier]。
 * @param 已启用 控制滑块的启用状态。当为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 值改变完成回调 当数值更改结束时调用。此回调不应被用于更新滑块数值（应使用 [值改变回调]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 颜色 [SliderColors] 用于解析该滑块在不同状态下所使用颜色的对象。参见 [SliderDefaults.colors]。
 * @param 交互源 用于表示该滑块 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过
 * `remember` 传入实例，以观察 [Interaction] 并在不同状态下自定义滑块的外观或行为。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 滑块 要在滑块上显示的拇指，它位于轨道之上。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 * @param 轨道 要在滑块上显示的轨道，它位于拇指下方。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 * @param 值范围 该滑块可选取的数值范围。传入的 [值] 将被强制限制在此范围内。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 滑块(
    值: Float,
    值改变回调: (Float) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值改变完成回调: (() -> Unit)? = null,
    颜色: SliderColors = 滑块默认值.颜色(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    @IntRange(from = 0) 刻度数: Int = 0,
    滑块: @Composable (SliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        滑块默认值.轨道(颜色 = 颜色, 已启用 = 已启用, 滑块状态 = sliderState)
    },
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
) {
    Slider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色,
        interactionSource = 交互源,
        steps = 刻度数,
        thumb = 滑块,
        track = 轨道,
        valueRange = 值范围,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从一系列数值中进行选择。
 *
 * 滑块在水平条上呈现一段数值范围，用户可从中选择单个值。它们非常适合用于调节音量、亮度或应用图像滤镜等设置。
 *
 * 使用连续滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * 使用自定义滑块拇指的 Slider：
 *
 * 使用自定义轨道和滑块拇指的 Slider：
 *
 * 使用轨道图标的滑块：
 *
 * 带有居中轨道的滑块：
 *
 * @param 状态 [SliderState]，其中包含滑块的当前值。
 * @param 修饰符 应用于该滑块的 [Modifier]。
 * @param 已启用 控制滑块的启用状态。当为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 [SliderColors] 用于解析该滑块在不同状态下所使用颜色的对象。参见 [SliderDefaults.colors]。
 * @param 交互源 用于表示该滑块 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过
 * `remember` 传入实例，以观察 [Interaction] 并在不同状态下自定义滑块的外观或行为。
 * @param 滑块 要在滑块上显示的拇指，它位于轨道之上。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 * @param 轨道 要在滑块上显示的轨道，它位于拇指下方。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 滑块(
    状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 滑块默认值.颜色(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    滑块: @Composable (SliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        滑块默认值.轨道(颜色 = 颜色, 已启用 = 已启用, 滑块状态 = sliderState)
    },
) {
    Slider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        interactionSource = 交互源,
        thumb = 滑块,
        track = 轨道,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 垂直 滑块允许用户从一系列数值中进行选择。
 *
 * 垂直滑块在垂直条上呈现一段数值范围，用户可从中选择单个值。它们非常适合用于调节音量、亮度或应用图像滤镜等设置。
 *
 * 垂直滑块：
 *
 * 带有居中轨道的垂直滑块：
 *
 * @param 状态 [SliderState]，其中包含滑块的当前值。
 * @param 修饰符 应用于该滑块的 [Modifier]。
 * @param 已启用 控制滑块的启用状态。当为 `false` 时，该组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 反转方向 控制该滑块的方向，默认从上到下。
 * @param 颜色 [SliderColors] 用于解析该滑块在不同状态下所使用颜色的对象。参见 [SliderDefaults.colors]。
 * @param 交互源 用于表示该滑块 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过
 * `remember` 传入实例，以观察 [Interaction] 并在不同状态下自定义滑块的外观或行为。
 * @param 滑块 要在滑块上显示的拇指，它位于轨道之上。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 * @param 轨道 要在滑块上显示的轨道，它位于拇指下方。该 lambda 接收一个 [SliderState]，用于获取当前活动轨道。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 垂直滑块(
    状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    反转方向: Boolean = false,
    颜色: SliderColors = 滑块默认值.颜色(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    滑块: @Composable (SliderState) -> Unit = { sliderState ->
        滑块默认值.滑块(
            交互源 = 交互源,
            滑块状态 = sliderState,
            颜色 = 颜色,
            已启用 = 已启用,
            滑块大小 = DpSize(44.0.dp, 4.0.dp),
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        滑块默认值.轨道(
            颜色 = 颜色,
            已启用 = 已启用,
            滑块状态 = sliderState,
            轨道圆角大小 = Dp.Unspecified,
        )
    },
) {
    VerticalSlider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        reverseDirection = 反转方向,
        colors = 颜色,
        interactionSource = 交互源,
        thumb = 滑块,
        track = 轨道,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上扩展，沿用相同的概念，但允许用户同时选择两个值。
 *
 * 这两个值仍受整体数值范围的限制，且彼此不能交叉。
 *
 * 使用连续范围滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * @param 值 范围滑块的当前值。如果任一值超出所提供的 [值范围]，将被强制限制在此范围内。
 * @param 值改变回调 用于更新数值的 lambda 回调
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用，以及是否可以与之交互。
 * @param 值范围 范围滑块数值可选取的区间。传入的 [值] 将被强制限制在此范围内。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 值改变完成回调 当数值更改结束时调用的 lambda。此回调不应被用于更新范围滑块的值（应使用 [值改变回调]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 颜色 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors] 以进行自定义。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 范围滑块(
    值: ClosedFloatingPointRange<Float>,
    值改变回调: (ClosedFloatingPointRange<Float>) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) 刻度数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    颜色: SliderColors = 滑块默认值.颜色(),
) {
    RangeSlider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        steps = 刻度数,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上扩展，沿用相同的概念，但允许用户同时选择两个值。
 *
 * 这两个值仍受整体数值范围的限制，且彼此不能交叉。
 *
 * 它使用提供的 startThumb 作为滑块的起始拇指，endThumb 作为结束拇指，并使用提供的 track 作为滑块的轨道。如果这些参数未传入，
 * 则默认使用 [SliderDefaults.Thumb] 和 [SliderDefaults.Track]。
 *
 * 使用连续范围滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * 可以自定义起始/结束拇指和轨道：
 *
 * @param 值 范围滑块的当前值。如果任一值超出所提供的 [值范围]，将被强制限制在此范围内。
 * @param 值改变回调 用于更新数值的 lambda 回调
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用，以及是否可以与之交互。
 * @param 值改变完成回调 当数值更改结束时调用的 lambda。此回调不应被用于更新范围滑块的值（应使用 [值改变回调]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 颜色 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors] 以进行自定义。
 * @param 开始交互源 用于表示起始拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 结束交互源 用于表示结束拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 开始滑块 要在范围滑块上显示的起始拇指。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 * @param 结束滑块 要在范围滑块上显示的结束拇指。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 * @param 轨道 要在范围滑块上显示的轨道，它位于拇指下方。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 * @param 值范围 范围滑块数值可选取的区间。传入的 [值] 将被强制限制在此范围内。.
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 范围滑块(
    值: ClosedFloatingPointRange<Float>,
    值改变回调: (ClosedFloatingPointRange<Float>) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    值改变完成回调: (() -> Unit)? = null,
    颜色: SliderColors = 滑块默认值.颜色(),
    开始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    结束交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    开始滑块: @Composable (RangeSliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 开始交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    结束滑块: @Composable (RangeSliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 结束交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    轨道: @Composable (RangeSliderState) -> Unit = { rangeSliderState ->
        滑块默认值.轨道(
            颜色 = 颜色,
            已启用 = 已启用,
            范围滑块状态 = rangeSliderState,
        )
    },
    @IntRange(from = 0) 刻度数: Int = 0,
) {
    RangeSlider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色,
        startInteractionSource = 开始交互源,
        endInteractionSource = 结束交互源,
        startThumb = 开始滑块,
        endThumb = 结束滑块,
        track = 轨道,
        steps = 刻度数,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上扩展，沿用相同的概念，但允许用户同时选择两个值。
 *
 * 这两个值仍受整体数值范围的限制，且彼此不能交叉。
 *
 * 它使用提供的 startThumb 作为滑块的起始拇指，endThumb 作为结束拇指，并使用提供的 track 作为滑块的轨道。如果这些参数未传入，
 * 则默认使用 [SliderDefaults.Thumb] 和 [SliderDefaults.Track]。
 *
 * 使用连续范围滑块，让用户可以做出无需精确数值的有意义选择：
 *
 * 你可以通过指定最小值与最大值之间的步数，让用户仅在预定义的一组数值中进行选择：
 *
 * 可以自定义起始/结束拇指和轨道：
 *
 * @param 状态 [RangeSliderState]，其中包含范围滑块的当前值。
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用，以及是否可以与之交互。
 * @param 颜色 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors] 以进行自定义。
 * @param 开始交互源 用于表示起始拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 结束交互源 用于表示结束拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 开始滑块 要在范围滑块上显示的起始拇指。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 * @param 结束滑块 要在范围滑块上显示的结束拇指。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 * @param 轨道 要在范围滑块上显示的轨道，它位于拇指下方。该 lambda 接收一个 [RangeSliderState]，用于获取当前活动轨道。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 范围滑块(
    状态: RangeSliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 滑块默认值.颜色(),
    开始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    结束交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    开始滑块: @Composable (RangeSliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 开始交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    结束滑块: @Composable (RangeSliderState) -> Unit = {
        滑块默认值.滑块(
            交互源 = 结束交互源,
            颜色 = 颜色,
            已启用 = 已启用,
        )
    },
    轨道: @Composable (RangeSliderState) -> Unit = { rangeSliderState ->
        滑块默认值.轨道(
            颜色 = 颜色,
            已启用 = 已启用,
            范围滑块状态 = rangeSliderState,
        )
    },
) {
    RangeSlider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        startInteractionSource = 开始交互源,
        endInteractionSource = 结束交互源,
        startThumb = 开始滑块,
        endThumb = 结束滑块,
        track = 轨道,
    )
}




/** 用于保存 [Slider] 默认设置的对象。 */
@Stable
object 滑块默认值 { //SliderDefaults

    /**
     * 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下所使用的不同颜色。
     */
    @Composable
    fun 颜色() = SliderDefaults.colors()

    /**
     * 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下所使用的不同颜色。
     *
     * 下文中的“active（活动）”与“inactive（非活动）”含义如下：滑块中被进度填充的部分称为活动部分。例如，当滑块进度为 100%
     * 中的 30% 时，左侧（RTL 布局下为右侧）30% 的轨道为活动状态，其余则为非活动状态。
     *
     * @param 滑块颜色 启用时的滑块拇指颜色
     * @param 活动轨道颜色 轨道“活动”部分的颜色，即拇指所在位置之前的部分。
     * @param 活动刻度颜色 当指定了 `steps` 时，用于在活动轨道上绘制刻度标记的颜色。
     * @param 非活动道迹颜色 轨道“非活动”部分的颜色，即拇指所在位置之前的部分。
     * @param 非活动刻度颜色 当在滑块上指定了 `steps` 时，用于在非活动轨道上绘制刻度标记的颜色。
     * @param 禁用滑块颜色 禁用时的滑块拇指颜色
     * @param 禁用活动轨道颜色 滑块禁用时，轨道“活动”部分的颜色。
     * @param 禁用活动刻度颜色 当滑块被禁用且指定了 `steps` 时，用于在活动轨道上绘制刻度标记的颜色。
     * @param 禁用非活动轨道颜色 滑块禁用时，轨道“非活动”部分的颜色。
     * @param 禁用非活动刻度颜色 当滑块被禁用且指定了 `steps` 时，用于在非活动轨道上绘制刻度标记的颜色。
     */
    @Composable
    fun 颜色(
        滑块颜色: Color = Color.Unspecified,
        活动轨道颜色: Color = Color.Unspecified,
        活动刻度颜色: Color = Color.Unspecified,
        非活动道迹颜色: Color = Color.Unspecified,
        非活动刻度颜色: Color = Color.Unspecified,
        禁用滑块颜色: Color = Color.Unspecified,
        禁用活动轨道颜色: Color = Color.Unspecified,
        禁用活动刻度颜色: Color = Color.Unspecified,
        禁用非活动轨道颜色: Color = Color.Unspecified,
        禁用非活动刻度颜色: Color = Color.Unspecified,
    ): SliderColors =
        SliderDefaults.colors(
            thumbColor = 滑块颜色,
            activeTrackColor = 活动轨道颜色,
            activeTickColor = 活动刻度颜色,
            inactiveTrackColor = 非活动道迹颜色,
            inactiveTickColor = 非活动刻度颜色,
            disabledThumbColor = 禁用滑块颜色,
            disabledActiveTrackColor = 禁用活动轨道颜色,
            disabledActiveTickColor = 禁用活动刻度颜色,
            disabledInactiveTrackColor = 禁用非活动轨道颜色,
            disabledInactiveTickColor = 禁用非活动刻度颜色,
        )

    /**
     * [Slider] 和 [RangeSlider] 的默认滑块拇指。
     *
     * @param 交互源 用于表示该滑块拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
     * @param 修饰符 应用于滑块拇指的 [Modifier]。
     * @param 颜色 用于解析该拇指在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 滑块大小 滑块拇指的大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 滑块(
        交互源: MutableInteractionSource,
        修饰符: Modifier = Modifier,
        颜色: SliderColors = 颜色(),
        已启用: Boolean = true,
        滑块大小: DpSize = DpSize(4.0.dp, 44.0.dp),
    ) =
        SliderDefaults.Thumb(
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色,
            enabled = 已启用,
            thumbSize = 滑块大小,
        )

    /**
     * [Slider]、[VerticalSlider] 和 [RangeSlider] 的默认滑块拇指。
     *
     * @param 交互源 用于表示该滑块拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
     * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
     * @param 修饰符 应用于滑块拇指的 [Modifier]。
     * @param 颜色 用于解析该拇指在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 滑块大小 滑块拇指的大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 滑块(
        交互源: MutableInteractionSource,
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        颜色: SliderColors = 颜色(),
        已启用: Boolean = true,
        滑块大小: DpSize = DpSize(4.0.dp, 44.0.dp),
    ) =
        SliderDefaults.Thumb(
            interactionSource = 交互源,
            sliderState = 滑块状态,
            modifier = 修饰符,
            colors = 颜色,
            enabled = 已启用,
            thumbSize = 滑块大小,
        )

    /**
     * [Slider] 和 [RangeSlider] 的默认轨道。
     *
     * @param 滑块位置 [SliderPositions]，用于获取当前活动轨道以及当滑块为离散模式时刻度的位置。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     */
    @Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
    @Composable
    @Deprecated("Use version that supports slider state")
    fun 轨道(
        滑块位置: SliderPositions,
        修饰符: Modifier = Modifier,
        颜色: SliderColors = 颜色(),
        已启用: Boolean = true,
    ) {
        SliderDefaults.Track(
            sliderPositions = 滑块位置,
            modifier = 修饰符,
            colors = 颜色,
            enabled = 已启用,
        )
    }

    /**
     * [Slider] 的默认轨道。
     *
     * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
     * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
     * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
     * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @ExperimentalMaterial3Api
    @Composable
    fun 轨道(
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色: SliderColors = 颜色(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            绘制停止指示器(
                偏移 = it,
                颜色 = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
                大小 = 轨道停止指示器大小,
            )
        },
        绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            绘制停止指示器(偏移 = offset, 颜色 = color, 大小 = 轨道大小)
        },
        滑块轨道间隙大小: Dp = 6.0.dp,
        轨道内侧圆角大小: Dp = 2.dp,
    ) {
        SliderDefaults.Track(
            sliderState = 滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度线,
            thumbTrackGapSize = 滑块轨道间隙大小,
            trackInsideCornerSize = 轨道内侧圆角大小,
        )
    }

    /**
     * [Slider] 的默认轨道。 and [VerticalSlider]
     *
     * 该轨道采用特殊圆角处理：当拇指靠近时，圆角尺寸逐渐减小。
     *
     * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
     * @param 轨道圆角大小 外部圆角的大小。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
     * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
     * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
     * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 轨道(
        滑块状态: SliderState,
        轨道圆角大小: Dp,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色: SliderColors = 颜色(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            绘制停止指示器(
                偏移 = it,
                颜色 = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
                大小 = 轨道停止指示器大小,
            )
        },
        绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            绘制停止指示器(偏移 = offset, 颜色 = color, 大小 = 轨道大小)
        },
        滑块轨道间隙大小: Dp = 6.0.dp,
        轨道内侧圆角大小: Dp = 2.dp,
    ) {
        SliderDefaults.Track(
            sliderState = 滑块状态,
            trackCornerSize = 轨道圆角大小,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度线,
            thumbTrackGapSize = 滑块轨道间隙大小,
            trackInsideCornerSize = 轨道内侧圆角大小,
        )
    }

    /**
     * [Slider] 和 [VerticalSlider] 的默认居中轨道。
     *
     * 该轨道从滑块的中心开始延伸。
     *
     * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
     * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
     * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
     * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
     * @param 轨道圆角大小 外部圆角的大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 居中轨道(
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色: SliderColors = 颜色(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            绘制停止指示器(
                偏移 = it,
                颜色 = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
                大小 = 轨道停止指示器大小,
            )
        },
        绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            绘制停止指示器(偏移 = offset, 颜色 = color, 大小 = 轨道大小)
        },
        滑块轨道间隙大小: Dp = 6.0.dp,
        轨道内侧圆角大小: Dp = 2.0.dp,
        轨道圆角大小: Dp = Dp.Unspecified,
    ) {
        SliderDefaults.CenteredTrack(
            sliderState = 滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度线,
            thumbTrackGapSize = 滑块轨道间隙大小,
            trackInsideCornerSize = 轨道内侧圆角大小,
            trackCornerSize = 轨道圆角大小,
        )
    }

    /**
     * [RangeSlider] 的默认轨道。
     *
     * @param 范围滑块状态 [RangeSliderState]，用于获取当前活动轨道。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道起始/结束位置绘制停止指示器的 lambda 函数。
     * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
     * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
     * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun 轨道(
        范围滑块状态: RangeSliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色: SliderColors = 颜色(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            绘制停止指示器(
                偏移 = it,
                颜色 = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
                大小 = 轨道停止指示器大小,
            )
        },
        绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            绘制停止指示器(偏移 = offset, 颜色 = color, 大小 = 轨道大小)
        },
        滑块轨道间隙大小: Dp = 6.0.dp,
        轨道内侧圆角大小: Dp = 2.dp,
    ) {
        SliderDefaults.Track(
            rangeSliderState = 范围滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度线,
            thumbTrackGapSize = 滑块轨道间隙大小,
            trackInsideCornerSize = 轨道内侧圆角大小,
        )
    }

    /**
     * [RangeSlider] 的默认轨道。
     *
     * @param 范围滑块状态 [RangeSliderState]，用于获取当前活动轨道。
     * @param 轨道圆角大小 外部圆角的大小。
     * @param 修饰符 应用于轨道的 [Modifier]。
     * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
     * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道起始/结束位置绘制停止指示器的 lambda 函数。
     * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
     * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
     * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 轨道(
        范围滑块状态: RangeSliderState,
        轨道圆角大小: Dp,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色: SliderColors = 颜色(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            绘制停止指示器(
                偏移 = it,
                颜色 = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
                大小 = 轨道停止指示器大小,
            )
        },
        绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            绘制停止指示器(偏移 = offset, 颜色 = color, 大小 = 轨道大小)
        },
        滑块轨道间隙大小: Dp = 6.0.dp,
        轨道内侧圆角大小: Dp = 2.dp,
    ) {
        SliderDefaults.Track(
            rangeSliderState = 范围滑块状态,
            trackCornerSize = 轨道圆角大小,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度线,
            thumbTrackGapSize = 滑块轨道间隙大小,
            trackInsideCornerSize = 轨道内侧圆角大小,
        )
    }

    /**
     * 默认的停止指示器。
     *
     * @param 偏移 指示器将要绘制的坐标位置。
     * @param 大小 指示器的大小。
     * @param 颜色 指示器的颜色。
     */
    fun DrawScope.绘制停止指示器(偏移: Offset, 大小: Dp, 颜色: Color) {
        drawCircle(color = 颜色, center = 偏移, radius = 大小.toPx() / 2f)
    }

    /** 轨道末端停止指示器的默认大小。 */
    val 轨道停止指示器大小: Dp = SliderDefaults.TrackStopIndicatorSize

    /** 当 steps 大于 0 时刻度线的默认大小。 */
    val 轨道大小: Dp = SliderDefaults.TickSize

}


/**
 * 创建一个在重组过程中被记住的 [SliderState]。
 *
 * 如果状态已经创建，对提供的初始值所做的任何更改都不会导致状态被重新创建或以任何方式更改。
 *
 * @param 值 表示滑块拇指初始位置的 [Float]；若超出所设 [值范围]，将被强制限制在该范围内。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 值改变完成回调 当数值更改结束时调用的 lambda。此回调不应被用于更新范围滑块值（应使用 [SliderState.onValueChange]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 值范围 滑块数值可选取的范围。[值] 将被强制限制在此范围内。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住滑块状态(
    值: Float = 0f,
    @IntRange(from = 0) 刻度数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
): SliderState = rememberSliderState(
    value = 值,
    steps = 刻度数,
    onValueChangeFinished = 值改变完成回调,
    valueRange = 值范围,
)



/**
 * 创建一个在重组过程中被记住的 [SliderState]。
 *
 * 如果状态已经创建，对提供的初始值所做的任何更改都不会导致状态被重新创建或以任何方式更改。
 *
 * @param 活动范围开始 表示滑块活动范围起始位置的 [Float]；若超出所设 [值范围]，将被强制限制在该范围内。
 * @param 活动范围结束 表示滑块活动范围结束位置的 [Float]；若超出所设 [值范围]，将被强制限制在该范围内。
 * @param 刻度数 若为正数，表示在 [值范围] 两端之间允许的离散取值数量。例如，范围 0 到 10 且 [刻度数] 为 4，则允许 0 与 10
 * 之间均匀分布的 4 个值（即 2、4、6、8）。若 [刻度数] 为 0，滑块将表现为连续模式，允许范围内的任意值。该值不能为负。
 * @param 值改变完成回调 当数值更改结束时调用的 lambda。此回调不应被用于更新该回调不应被用于更新范围滑块值（应使用 [RangeSliderState.onValueChange]），
 * 而是用于获知用户通过结束拖动或点击完成了新值的选择。
 * @param 值范围 范围滑块数值可选取的范围。[活动范围开始] 与 [活动范围结束] 将被强制限制在此范围内。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住范围滑块状态(
    活动范围开始: Float = 0f,
    活动范围结束: Float = 1f,
    @IntRange(from = 0) 刻度数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
): RangeSliderState = rememberRangeSliderState(
    activeRangeStart = 活动范围开始,
    activeRangeEnd = 活动范围结束,
    steps = 刻度数,
    onValueChangeFinished = 值改变完成回调,
    valueRange = 值范围,
)



private fun SliderColors.轨道颜色(
    已启用: Boolean,
    活动: Boolean,
): Color {
    return if (已启用) {
        if (活动) this.activeTrackColor else this.inactiveTrackColor
    } else {
        if (活动) this.disabledActiveTrackColor else this.disabledInactiveTrackColor
    }
}


//==============================================================


/**
 * 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下所使用的不同颜色。
 */
@Composable
fun SliderDefaults.颜色() = this.colors()

/**
 * 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下所使用的不同颜色。
 *
 * 下文中的“active（活动）”与“inactive（非活动）”含义如下：滑块中被进度填充的部分称为活动部分。例如，当滑块进度为 100%
 * 中的 30% 时，左侧（RTL 布局下为右侧）30% 的轨道为活动状态，其余则为非活动状态。
 *
 * @param 滑块颜色 启用时的滑块拇指颜色
 * @param 活动轨道颜色 轨道“活动”部分的颜色，即拇指所在位置之前的部分。
 * @param 活动刻度颜色 当指定了 `steps` 时，用于在活动轨道上绘制刻度标记的颜色。
 * @param 非活动道迹颜色 轨道“非活动”部分的颜色，即拇指所在位置之前的部分。
 * @param 非活动刻度颜色 当在滑块上指定了 `steps` 时，用于在非活动轨道上绘制刻度标记的颜色。
 * @param 禁用滑块颜色 禁用时的滑块拇指颜色
 * @param 禁用活动轨道颜色 滑块禁用时，轨道“活动”部分的颜色。
 * @param 禁用活动刻度颜色 当滑块被禁用且指定了 `steps` 时，用于在活动轨道上绘制刻度标记的颜色。
 * @param 禁用非活动轨道颜色 滑块禁用时，轨道“非活动”部分的颜色。
 * @param 禁用非活动刻度颜色 当滑块被禁用且指定了 `steps` 时，用于在非活动轨道上绘制刻度标记的颜色。
 */
@Composable
fun SliderDefaults.颜色(
    滑块颜色: Color = Color.Unspecified,
    活动轨道颜色: Color = Color.Unspecified,
    活动刻度颜色: Color = Color.Unspecified,
    非活动道迹颜色: Color = Color.Unspecified,
    非活动刻度颜色: Color = Color.Unspecified,
    禁用滑块颜色: Color = Color.Unspecified,
    禁用活动轨道颜色: Color = Color.Unspecified,
    禁用活动刻度颜色: Color = Color.Unspecified,
    禁用非活动轨道颜色: Color = Color.Unspecified,
    禁用非活动刻度颜色: Color = Color.Unspecified,
): SliderColors =
    this.colors(
        thumbColor = 滑块颜色,
        activeTrackColor = 活动轨道颜色,
        activeTickColor = 活动刻度颜色,
        inactiveTrackColor = 非活动道迹颜色,
        inactiveTickColor = 非活动刻度颜色,
        disabledThumbColor = 禁用滑块颜色,
        disabledActiveTrackColor = 禁用活动轨道颜色,
        disabledActiveTickColor = 禁用活动刻度颜色,
        disabledInactiveTrackColor = 禁用非活动轨道颜色,
        disabledInactiveTickColor = 禁用非活动刻度颜色,
    )

/**
 * [Slider] 和 [RangeSlider] 的默认滑块拇指。
 *
 * @param 交互源 用于表示该滑块拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 修饰符 应用于滑块拇指的 [Modifier]。
 * @param 颜色 用于解析该拇指在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 滑块大小 滑块拇指的大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun SliderDefaults.滑块(
    交互源: MutableInteractionSource,
    修饰符: Modifier = Modifier,
    颜色: SliderColors = 颜色(),
    已启用: Boolean = true,
    滑块大小: DpSize = DpSize(4.0.dp, 44.0.dp),
) =
    this.Thumb(
        interactionSource = 交互源,
        modifier = 修饰符,
        colors = 颜色,
        enabled = 已启用,
        thumbSize = 滑块大小,
    )

/**
 * [Slider]、[VerticalSlider] 和 [RangeSlider] 的默认滑块拇指。
 *
 * @param 交互源 用于表示该滑块拇指的 [Interaction] 流的 [MutableInteractionSource]。你可以自行创建并通过 `remember` 传入实例以进行观察。
 * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
 * @param 修饰符 应用于滑块拇指的 [Modifier]。
 * @param 颜色 用于解析该拇指在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 滑块大小 滑块拇指的大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun SliderDefaults.滑块(
    交互源: MutableInteractionSource,
    滑块状态: SliderState,
    修饰符: Modifier = Modifier,
    颜色: SliderColors = 颜色(),
    已启用: Boolean = true,
    滑块大小: DpSize = DpSize(4.0.dp, 44.0.dp),
) =
    this.Thumb(
        interactionSource = 交互源,
        sliderState = 滑块状态,
        modifier = 修饰符,
        colors = 颜色,
        enabled = 已启用,
        thumbSize = 滑块大小,
    )

/**
 * [Slider] 和 [RangeSlider] 的默认轨道。
 *
 * @param 滑块位置 [SliderPositions]，用于获取当前活动轨道以及当滑块为离散模式时刻度的位置。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 */
@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
@Composable
@Deprecated("Use version that supports slider state")
fun SliderDefaults.轨道(
    滑块位置: SliderPositions,
    修饰符: Modifier = Modifier,
    颜色: SliderColors = 颜色(),
    已启用: Boolean = true,
) {
    this.Track(
        sliderPositions = 滑块位置,
        modifier = 修饰符,
        colors = 颜色,
        enabled = 已启用,
    )
}

/**
 * [Slider] 的默认轨道。
 *
 * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
 * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
 * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
 * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun SliderDefaults.轨道(
    滑块状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 颜色(),
    绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
        drawStopIndicator(
            offset = it,
            color = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
            size = 轨道停止指示器大小,
        )
    },
    绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
        drawStopIndicator(offset = offset, color = color, size = 轨道大小,)
    },
    滑块轨道间隙大小: Dp = 6.0.dp,
    轨道内侧圆角大小: Dp = 2.dp,
) {
    this.Track(
        sliderState = 滑块状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        drawStopIndicator = 绘制停止指示器,
        drawTick = 绘制刻度线,
        thumbTrackGapSize = 滑块轨道间隙大小,
        trackInsideCornerSize = 轨道内侧圆角大小,
    )
}

/**
 * [Slider] 的默认轨道。 and [VerticalSlider]
 *
 * 该轨道采用特殊圆角处理：当拇指靠近时，圆角尺寸逐渐减小。
 *
 * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
 * @param 轨道圆角大小 外部圆角的大小。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
 * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
 * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
 * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun SliderDefaults.轨道(
    滑块状态: SliderState,
    轨道圆角大小: Dp,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 颜色(),
    绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
        drawStopIndicator(
            offset = it,
            color = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
            size = 轨道停止指示器大小,
        )
    },
    绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
        drawStopIndicator(offset = offset, color = color, size = 轨道大小)
    },
    滑块轨道间隙大小: Dp = 6.0.dp,
    轨道内侧圆角大小: Dp = 2.dp,
) {
    this.Track(
        sliderState = 滑块状态,
        trackCornerSize = 轨道圆角大小,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        drawStopIndicator = 绘制停止指示器,
        drawTick = 绘制刻度线,
        thumbTrackGapSize = 滑块轨道间隙大小,
        trackInsideCornerSize = 轨道内侧圆角大小,
    )
}

/**
 * [Slider] 和 [VerticalSlider] 的默认居中轨道。
 *
 * 该轨道从滑块的中心开始延伸。
 *
 * @param 滑块状态 [SliderState]，用于获取当前活动轨道。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda 函数。
 * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
 * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
 * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
 * @param 轨道圆角大小 外部圆角的大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun SliderDefaults.居中轨道(
    滑块状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 颜色(),
    绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
        drawStopIndicator(
            offset = it,
            color = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
            size = 轨道停止指示器大小,
        )
    },
    绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
        drawStopIndicator(offset = offset, color = color, size = 轨道大小)
    },
    滑块轨道间隙大小: Dp = 6.0.dp,
    轨道内侧圆角大小: Dp = 2.0.dp,
    轨道圆角大小: Dp = Dp.Unspecified,
) {
    this.CenteredTrack(
        sliderState = 滑块状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        drawStopIndicator = 绘制停止指示器,
        drawTick = 绘制刻度线,
        thumbTrackGapSize = 滑块轨道间隙大小,
        trackInsideCornerSize = 轨道内侧圆角大小,
        trackCornerSize = 轨道圆角大小,
    )
}

/**
 * [RangeSlider] 的默认轨道。
 *
 * @param 范围滑块状态 [RangeSliderState]，用于获取当前活动轨道。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 绘制停止指示器 用于在轨道起始/结束位置绘制停止指示器的 lambda 函数。
 * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
 * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
 * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderDefaults.轨道(
    范围滑块状态: RangeSliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 颜色(),
    绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
        drawStopIndicator(
            offset = it,
            color = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
            size = 轨道停止指示器大小,
        )
    },
    绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
        drawStopIndicator(offset = offset, color = color, size = 轨道大小)
    },
    滑块轨道间隙大小: Dp = 6.0.dp,
    轨道内侧圆角大小: Dp = 2.dp,
) {
    this.Track(
        rangeSliderState = 范围滑块状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        drawStopIndicator = 绘制停止指示器,
        drawTick = 绘制刻度线,
        thumbTrackGapSize = 滑块轨道间隙大小,
        trackInsideCornerSize = 轨道内侧圆角大小,
    )
}

/**
 * [RangeSlider] 的默认轨道。
 *
 * @param 范围滑块状态 [RangeSliderState]，用于获取当前活动轨道。
 * @param 轨道圆角大小 外部圆角的大小。
 * @param 修饰符 应用于轨道的 [Modifier]。
 * @param 已启用 控制该滑块的启用状态。当为 `false` 时，组件不会响应用户输入，视觉上呈现为禁用状态，且无障碍服务也会将其视为已禁用。
 * @param 颜色 用于解析该轨道在不同状态下颜色的 [SliderColors]。参见 [SliderDefaults.colors]。
 * @param 绘制停止指示器 用于在轨道起始/结束位置绘制停止指示器的 lambda 函数。
 * @param 绘制刻度线 当 steps 大于 0 时，用于绘制刻度的 lambda 函数。
 * @param 滑块轨道间隙大小 滑块拇指与轨道之间的间隙大小。
 * @param 轨道内侧圆角大小 设置间隙时，轨道朝向拇指一侧的圆角大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun SliderDefaults.轨道(
    范围滑块状态: RangeSliderState,
    轨道圆角大小: Dp,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色: SliderColors = 颜色(),
    绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
        drawStopIndicator(
            offset = it,
            color = 颜色.轨道颜色(已启用 = 已启用, 活动 = true),
            size = 轨道停止指示器大小,
        )
    },
    绘制刻度线: DrawScope.(Offset, Color) -> Unit = { offset, color ->
        drawStopIndicator(offset = offset, color = color, size = 轨道大小)
    },
    滑块轨道间隙大小: Dp = 6.0.dp,
    轨道内侧圆角大小: Dp = 2.dp,
) {
    this.Track(
        rangeSliderState = 范围滑块状态,
        trackCornerSize = 轨道圆角大小,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色,
        drawStopIndicator = 绘制停止指示器,
        drawTick = 绘制刻度线,
        thumbTrackGapSize = 滑块轨道间隙大小,
        trackInsideCornerSize = 轨道内侧圆角大小,
    )
}


/** 轨道末端停止指示器的默认大小。 */
val SliderDefaults.轨道停止指示器大小: Dp
    get() = this.TrackStopIndicatorSize

/** 当 steps 大于 0 时刻度线的默认大小。 */
val SliderDefaults.轨道大小: Dp
    get() = this.TickSize
