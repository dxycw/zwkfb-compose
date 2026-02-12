package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * [Material Design date range picker](https://m3.material.io/components/date-pickers/overview)
 *
 * 日期范围选择器让用户可以选取一段日期区间，并且能够嵌入到对话框中使用。
 *
 * ![Date range pickerimage](https://developer.android.com/images/reference/androidx/compose/material3/range-picker.png)
 *
 * @param 状态 日期范围选择器的状态，参见 [rememberDateRangePickerState]。
 * @param 修饰符 应用于该日期范围选择器的 [Modifier]。
 * @param 日期格式化器 一个 [DatePickerFormatter]，用于提供日期显示的格式化模板。
 * @param 颜色 用于解析该日期范围选择器在不同状态下所用颜色的 [DatePickerColors]。参见 [DatePickerDefaults.colors]。
 * @param 标题 日期范围选择器中显示的标题。
 * @param 副标题 日期范围选择器中显示的副标题。
 * @param 显示模式切换 指示该 DateRangePicker 是否显示模式切换操作，以便将其转换为日期范围输入模式。
 * @param 焦点请求 用于在日期选择器处于输入模式时将焦点移至文本字段的 [FocusRequester]。如不希望自动聚焦，可传入 `null`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 日期范围选择器(
    状态: DateRangePickerState,
    修饰符: Modifier = Modifier,
    日期格式化器: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    颜色: DatePickerColors = DatePickerDefaults.colors(),
    标题: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerTitle(
            displayMode = 状态.displayMode,
            modifier = Modifier.padding(DateRangePickerTitlePadding),
            contentColor = 颜色.titleContentColor,
        )
    },
    副标题: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerHeadline(
            selectedStartDateMillis = 状态.selectedStartDateMillis,
            selectedEndDateMillis = 状态.selectedEndDateMillis,
            displayMode = 状态.displayMode,
            dateFormatter = 日期格式化器,
            modifier = Modifier.padding(DateRangePickerHeadlinePadding),
            contentColor = 颜色.headlineContentColor,
        )
    },
    显示模式切换: Boolean = true,
    焦点请求: FocusRequester? = remember { FocusRequester() },
) {
    DateRangePicker(
        state = 状态,
        modifier = 修饰符,
        dateFormatter = 日期格式化器,
        colors = 颜色,
        title = 标题,
        headline = 副标题,
        showModeToggle = 显示模式切换,
        focusRequester = 焦点请求,
    )
}

/**
 * 创建一个可在重组间记忆的 [DateRangePickerState]，供 [DateRangePicker] 使用。
 *
 * 如需在组合函数外部创建日期范围选择器状态，请使用 `DateRangePickerState` 函数。
 *
 * @param 初始选定开始日期毫秒 以 UTC 毫秒表示的初始起始日期时间戳（自 epoch 起算）。传入 `null` 表示无初始选择。
 * @param 初始选定结束日期毫秒 以 UTC 毫秒表示的初始结束日期时间戳（自 epoch 起算）。传入 `null` 表示无初始选择。
 * @param 初始显示月份毫秒数 以 UTC 毫秒表示的初始显示月份时间戳（自 epoch 起算）。若提供了 `初始选定开始日期毫秒`，
 * 则默认显示该日期所在的月份；若传入 `null`，则默认显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期范围选择器的可选年份区间。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates] 对象，用于判断某个日期是否允许被选择。若日期不允许选择，它将在界面中显示为禁用状态。
 */
@Composable
fun 记住日期范围选择器状态(
    @Suppress("AutoBoxing") 初始选定开始日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始选定结束日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒数: Long? = 初始选定开始日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DateRangePickerState {
    return rememberDateRangePickerState(
            initialSelectedStartDateMillis = 初始选定开始日期毫秒,
            initialSelectedEndDateMillis = 初始选定结束日期毫秒,
            initialDisplayedMonthMillis = 初始显示月份毫秒数,
            yearRange = 年份范围,
            initialDisplayMode = 初始显示模式,
            selectableDates = 可选择日期,
        )
}

/**
 * 创建一个 [DateRangePickerState]。
 *
 * 在大多数情况下，建议在组合函数中使用 [rememberDateRangePickerState]。
 *
 * 请注意，如果你提供的 [本地] 与系统默认区域设置不同，可能需要确保选择器的标题和副标题已正确本地化。
 * 以下示例展示了一种可行方式：通过局部注入 `LocalContext` 与 `LocaleConfiguration` 来实现本地化。
 *
 * @param 本地 用于格式化日期、决定输入格式、显示星期、确定每周起始日等的 [CalendarLocale]。若提供的 [CalendarLocale] 与系统默认 Locale 不同，
 * 需确保选择器的标题和副标题已正确本地化；在某些情况下，还需应用 RTL 布局。
 * @param 初始选定开始日期毫秒 以 UTC 毫秒表示的初始起始日期时间戳（自 epoch 起算）。传入 `null` 表示无初始选择。
 * @param 初始选定结束日期毫秒 以 UTC 毫秒表示的初始结束日期时间戳（自 epoch 起算）。传入 `null` 表示无初始选择。
 * @param 初始显示月份的毫秒数 以 UTC 毫秒表示的初始显示月份时间戳（自 epoch 起算）。若提供了 `初始选定开始日期毫秒`，
 * 则默认显示该日期所在的月份；若传入 `null`，则默认显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可供选择的年份范围。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates] 对象，用于判断某个日期是否允许被选择。若日期不允许选择，它将在界面中显示为禁用状态。
 * @throws IllegalArgumentException 如果初始时间戳不在创建状态时指定的年份范围内，或结束日期早于开始日期，或仅提供了结束日期而未提供开始
 * 日期（例如开始日期为 null，结束日期不为 null），则会抛出异常。
 * @see rememberDateRangePickerState
 */
fun 日期范围选择器状态(
    本地: CalendarLocale,
    @Suppress("AutoBoxing") 初始选定开始日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始选定结束日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份的毫秒数: Long? = 初始选定开始日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DateRangePickerState =
    DateRangePickerState(
        locale = 本地,
        initialSelectedStartDateMillis = 初始选定开始日期毫秒,
        initialSelectedEndDateMillis = 初始选定结束日期毫秒,
        initialDisplayedMonthMillis = 初始显示月份的毫秒数,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选择日期,
    )

/** 包含 [DateRangePicker] 使用的默认值。 */
@Stable
object 日期范围选择器默认值 {  //DateRangePickerDefaults

    /**
     * 默认的日期范围选择器标题组合项。
     *
     * @param 显示模式 当前的 [DisplayMode]。
     * @param 修饰符 应用于标题的 [Modifier]。
     * @param 内容颜色 此标题的内容颜色。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 日期范围选择器标题(
        显示模式: DisplayMode,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().titleContentColor,
    ) {
        DateRangePickerDefaults.DateRangePickerTitle (
            displayMode = 显示模式,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )
    }

    /**
     * 默认的日期选择器副标题组合项 Lambda：未选择日期时显示默认提示文本；已选择日期时显示对应日期字符串。
     *
     * @param 选定开始日期毫秒数 一个时间戳，表示所选起始日期当天的起始时刻，以 UTC 毫秒（自 epoch 起算）计。
     * @param 选定结束日期毫秒数 一个时间戳，表示所选结束日期当天的起始时刻，以 UTC 毫秒（自 epoch 起算）计。
     * @param 显示模式 当前的 [DisplayMode]。
     * @param 日期格式化器 一个 [DatePickerFormatter]，用于格式化日期字符串。
     * @param 修饰符 应用于副标题的 [Modifier]。
     * @param 内容颜色 此副标题的内容颜色。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 日期范围选择器副标题(
        @Suppress("AutoBoxing") 选定开始日期毫秒数: Long?,
        @Suppress("AutoBoxing") 选定结束日期毫秒数: Long?,
        显示模式: DisplayMode,
        日期格式化器: DatePickerFormatter,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().headlineContentColor,
    ) {
        DateRangePickerDefaults.DateRangePickerHeadline(
            selectedStartDateMillis = 选定开始日期毫秒数,
            selectedEndDateMillis = 选定结束日期毫秒数,
            displayMode = 显示模式,
            dateFormatter = 日期格式化器,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )
    }

}



private val DateRangePickerTitlePadding = PaddingValues(start = 64.dp, end = 12.dp)
private val DateRangePickerHeadlinePadding =
    PaddingValues(start = 64.dp, end = 12.dp, bottom = 12.dp)


