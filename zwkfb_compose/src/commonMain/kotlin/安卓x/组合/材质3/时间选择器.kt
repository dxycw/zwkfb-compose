package 安卓x.组合.材质3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerSelectionMode
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import 安卓x.组合.材质3.颜色

/**
 * [Material Design time picker](https://m3.material.io/components/time-pickers/overview)
 *
 * 时间选择器帮助用户选择并设定具体的时间。
 *
 * 显示一个允许用户选择时间的选择器，通过 [TimePickerState] 订阅更新。
 *
 * ![Time pickerimage](https://developer.android.com/images/reference/androidx/compose/material3/time-picker.png)
 *
 * [状态] 用于此时间选择器的状态，可订阅 [TimePickerState.hour] 与 [TimePickerState.minute] 的变化，并设置选择器的初始时间。
 *
 * @param 状态 此时间输入的状态，可订阅 [TimePickerState.hour] 与 [TimePickerState.minute] 的变化，并设置初始时间。
 * @param 修饰符 应用于该时间输入的 [Modifier]。
 * @param 颜色 用于解析该时间选择器在不同状态下所用颜色的 [TimePickerColors]。参见 [TimePickerDefaults.colors]。
 * @param 布局类型 该时间选择器支持的 [TimePickerLayoutType]，将改变其各组件的位置与尺寸。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 时间选择器(
    状态: TimePickerState,
    修饰符: Modifier = Modifier,
    颜色: TimePickerColors = TimePickerDefaults.colors(),
    布局类型: TimePickerLayoutType = TimePickerDefaults.layoutType(),
) {
    TimePicker(
        state = 状态,
        modifier = 修饰符,
        colors = 颜色,
        layoutType = 布局类型,
    )
}

/**
 * 时间选择器帮助用户选择并设定具体的时间。
 *
 * 显示一个时间输入组件，用户可通过两个文本字段分别输入小时和分钟；通过 [TimePickerState] 订阅更新。
 *
 * @param 状态 此时间选择器的状态，可订阅 [TimePickerState.hour] 与 [TimePickerState.minute] 的变化，并设置初始时间。
 * @param 修饰符 应用于该时间输入的 [Modifier]。
 * @param 颜色 用于解析该时间输入在不同状态下所用颜色的 [TimePickerColors]。参见 [TimePickerDefaults.colors]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 时间输入(
    状态: TimePickerState,
    修饰符: Modifier = Modifier,
    颜色: TimePickerColors = TimePickerDefaults.colors(),
) {
    TimeInput(
        state = 状态,
        modifier = 修饰符,
        colors = 颜色,
    )
}

/** 包含 [时间选择器] 使用的默认值。 */
@ExperimentalMaterial3Api
@Stable
object 时间选择器默认值 { //TimePickerDefaults

    /** [时间选择器] 在不同状态下使用的默认颜色。 */
    @Composable
    fun 颜色() = TimePickerDefaults.colors()

    /**
     * [时间选择器] 在不同状态下使用的默认颜色。
     *
     * @param 时钟表盘颜色 表盘的颜色。
     * @param 时钟表盘选中内容颜色 表盘上数字在被选中或与选择器重叠时的颜色。
     * @param 时钟表盘未选内容颜色 表盘上数字未被选中时的颜色。
     * @param 选择器颜色 表盘选择器的颜色。
     * @param 容器颜色 时间选择器的容器颜色。
     * @param 周期选择器边框颜色 AM/PM 切换按钮边框的颜色。
     * @param 周期选择器已选容器颜色 AM/PM 切换按钮选中时的容器颜色。
     * @param 周期选择器未选容器颜色 AM/PM 切换按钮未选中时的容器颜色。
     * @param 周期选择器已选内容颜色 AM/PM 切换按钮选中时的内容颜色。
     * @param 周期选择器未选内容颜色 AM/PM 切换按钮未选中时的内容颜色。
     * @param 时间选择器已选容器颜色 用于“小时”与“分钟”显示按钮在选中状态下的容器颜色。
     * @param 时间选择器未选容器颜色 用于“小时”与“分钟”显示按钮在未选中状态下的容器颜色。
     * @param 时间选择器已选内容颜色 用于“小时”与“分钟”显示按钮在选中状态下的内容颜色。
     * @param 时间选择器未选内容颜色 用于“小时”与“分钟”显示按钮在未选中状态下的内容颜色。
     */
    @Composable
    fun 颜色(
        时钟表盘颜色: Color = Color.Unspecified,
        时钟表盘选中内容颜色: Color = Color.Unspecified,
        时钟表盘未选内容颜色: Color = Color.Unspecified,
        选择器颜色: Color = Color.Unspecified,
        容器颜色: Color = Color.Unspecified,
        周期选择器边框颜色: Color = Color.Unspecified,
        周期选择器已选容器颜色: Color = Color.Unspecified,
        周期选择器未选容器颜色: Color = Color.Unspecified,
        周期选择器已选内容颜色: Color = Color.Unspecified,
        周期选择器未选内容颜色: Color = Color.Unspecified,
        时间选择器已选容器颜色: Color = Color.Unspecified,
        时间选择器未选容器颜色: Color = Color.Unspecified,
        时间选择器已选内容颜色: Color = Color.Unspecified,
        时间选择器未选内容颜色: Color = Color.Unspecified,
    ) =
        TimePickerDefaults.colors(
            clockDialColor = 时钟表盘颜色,
            clockDialSelectedContentColor = 时钟表盘选中内容颜色,
            clockDialUnselectedContentColor = 时钟表盘未选内容颜色,
            selectorColor = 选择器颜色,
            containerColor = 容器颜色,
            periodSelectorBorderColor = 周期选择器边框颜色,
            periodSelectorSelectedContainerColor = 周期选择器已选容器颜色,
            periodSelectorUnselectedContainerColor = 周期选择器未选容器颜色,
            periodSelectorSelectedContentColor = 周期选择器已选内容颜色,
            periodSelectorUnselectedContentColor = 周期选择器未选内容颜色,
            timeSelectorSelectedContainerColor = 时间选择器已选容器颜色,
            timeSelectorUnselectedContainerColor = 时间选择器未选容器颜色,
            timeSelectorSelectedContentColor = 时间选择器已选内容颜色,
            timeSelectorUnselectedContentColor = 时间选择器未选内容颜色,
        )

    /** 默认布局类型，根据屏幕尺寸选择合适的布局。 */
    @ReadOnlyComposable
    @Composable
    fun 布局类型(): TimePickerLayoutType = TimePickerDefaults.layoutType()
}


/**
 * 创建一个可在重组与配置更改间记忆的 [TimePickerState]，供时间选择器使用。
 *
 * @param 初始小时 该状态的初始小时，将在时间选择器启动时显示，范围为 0 到 23。
 * @param 初始分钟 该状态的初始分钟，将在时间选择器启动时显示，范围为 0 到 59。
 * @param 是否24小时 该时间选择器的格式。`false` 表示 12 小时制并带 AM/PM 切换；`true` 表示 24 小时制，无切换按钮。默认跟随系统设置。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住时间选择器状态(
    初始小时: Int = 0,
    初始分钟: Int = 0,
    是否24小时: Boolean = is24HourFormat,
): TimePickerState {
    return rememberTimePickerState(
        initialHour = 初始小时,
        initialMinute = 初始分钟,
        is24Hour = 是否24小时,
    )
}

/** 表示时间选择器布局的不同配置方式。 */
@Immutable
object 时间选择器布局类型{
    /** 以水平布局显示时间选择器，适用于横屏模式。 */
    val 水平 = TimePickerLayoutType.Horizontal

    /** 以垂直布局显示时间选择器，适用于竖屏模式。 */
    val 垂直 = TimePickerLayoutType.Vertical
}


/**
 * 表示所选时间是否处于 12:00（含）至 24:00（不含）之间。
 */
val TimePickerState.是否下午: Boolean
    get() = hour >= 12

/** 若当前 `hourInput` 为有效小时（0–23），则返回 `true`。 */
val TimePickerState.是否小时输入有效: Boolean
    get() = hourInput in 0..23

/** 若当前 `minuteInput` 为有效分钟（0–59），则返回 `true`。 */
val TimePickerState.是否分钟输入有效: Boolean
    get() = minuteInput in 0..59

/** 如果时间输入值有效，则返回 `true`。 */
val TimePickerState.是否输入有效: Boolean
    get() = 是否分钟输入有效 && 是否小时输入有效

/**
 * 默认实现 [TimePickerState] 的工厂函数；在大多数情况下应使用 [rememberTimePickerState]。
 *
 * @param 初始小时 该状态的初始小时，将在时间选择器启动时显示，范围为 0 到 23。
 * @param 初始分钟 该状态的初始分钟，将在时间选择器启动时显示，范围为 0 到 59。
 * @param is24Hour 该时间选择器的格式。`false` 表示 12 小时制并带 AM/PM 切换；`true` 表示 24 小时制，无切换按钮。默认跟随系统设置。
 */
@ExperimentalMaterial3Api
fun 时间选择器状态(
    初始小时: Int,
    初始分钟: Int,
    是否24小时: Boolean
): TimePickerState =
    TimePickerState(
        initialHour = 初始小时,
        initialMinute = 初始分钟,
        is24Hour = 是否24小时
    )

/** 时间选择器的选择模式。 */
@ExperimentalMaterial3Api
object 时间选择模式{
    val 小时 = TimePickerSelectionMode.Hour
    val 分钟 = TimePickerSelectionMode.Minute
}


