package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design date picker](https://m3.material.io/components/date-pickers/overview)
 *
 * 日期选择器让人们可以选择日期，最好嵌入到对话框中。参见 [DatePickerDialog]。
 *
 * 默认情况下，日期选择器通过日历界面让你选择日期。然而，它也允许切换到日期输入模式，以便使用键盘上的数字手动输入日期。
 *
 * ![Date pickerimage](https://developer.android.com/images/reference/androidx/compose/material3/date-picker.png)
 *
 * @param 状态 日期选择器的状态。参见 [rememberDatePickerState]。
 * @param 修饰符 应用于该日期选择器的 [Modifier]。
 * @param 日期格式化器 一个 [DatePickerFormatter]，用于为日期显示提供格式化模板。
 * @param 颜色 用于解析该日期选择器在不同状态下所用颜色的 [DatePickerColors]。参见 [DatePickerDefaults.colors]。
 * @param 标题 要在日期选择器中显示的标题。
 * @param 副标题 要在日期选择器中显示的副标题/主标题。
 * @param 显示模式切换 指示该 DatePicker 是否应显示一个模式切换操作，使其转变为日期输入模式。
 * @param 焦点请求 一个焦点请求器，用于在日期选择器处于输入模式时将焦点置于文本框。如果不希望聚焦文本框，可传入 `null`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 日期选择器(
    状态: DatePickerState,
    修饰符: Modifier = Modifier,
    日期格式化器: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    颜色: DatePickerColors = DatePickerDefaults.colors(),
    标题: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            displayMode = 状态.displayMode,
            modifier = Modifier.padding(DatePickerTitlePadding),
            contentColor = 颜色.titleContentColor,
        )
    },
    副标题: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = 状态.selectedDateMillis,
            displayMode = 状态.displayMode,
            dateFormatter = 日期格式化器,
            modifier = Modifier.padding(DatePickerHeadlinePadding),
            contentColor = 颜色.headlineContentColor,
        )
    },
    显示模式切换: Boolean = true,
    焦点请求: FocusRequester? = remember { FocusRequester() },
) {
    DatePicker(
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
 * 一个可提升（hoisted）的状态对象，用于观察日期选择器的状态。参见 [rememberDatePickerState]。
 */
@Stable
interface 日期选择器状态 { //DatePickerState

    /**
     * 一个时间戳，表示所选日期当天的**起始时间**，以**UTC 毫秒**为单位，自纪元起算。
     *
     * @throws IllegalArgumentException 当设置的值不在 [年份范围] 所指定的年份范围内时。
     */
    @get:Suppress("AutoBoxing") var 已选中日期毫秒: Long?

    /**
     * 一个时间戳，表示当前显示的月份**起始日期**，以**UTC 毫秒**为单位，自纪元起算。
     *
     * @throws IllegalArgumentException 当所设时间戳不在 [年份范围] 指定的年份范围内时。
     */
    var 显示月份毫秒: Long

    /** 一个 [DisplayMode]，表示当前 UI 模式（即选择器或输入）。 */
    var 显示模式: DisplayMode

    /** 一个 [IntRange]，用于限定日期选择器可选择的年份范围。 */
    val 年份范围: IntRange

    /**
     * 一个 [SelectableDates]，用于检查某个日期是否允许被选中。
     *
     * 如果某个日期不允许被选中，它将在界面中显示为禁用状态。
     */
    val 可选择日期: SelectableDates

    /**
     * 一个区域设置（locale），用于格式化日期、确定输入格式、星期几等。
     */
    val 本地: CalendarLocale
}

/** 一个用于控制日期选择器界面中可选日期和年份的接口。 */
@Stable
interface 可选日期 { //SelectableDates

    /**
     * 如果表示 [协调世界毫秒] 的日期项应在界面中启用以供选择，则返回 true。
     */
    fun 是否可选日期(协调世界毫秒: Long) = true

    /**
     * 如果给定的 [年] 应在界面中启用以供选择，则返回 true。
     * 当某年被定义为不可选时，该年内的所有日期也将不可选。
     */
    fun 是否可选年份(年: Int) = true
}

/** 一个由 [DatePicker] 使用的日期格式化接口。 */
interface 日期选择器格式化 {  //DatePickerFormatter

    /**
     * 将给定的 [月毫秒] 格式化为“月份 年份”的字符串（例如：January 2023）。
     *
     * @param 月毫秒 自纪元起算的 UTC 毫秒时间戳，用于表示该月份。
     * @param 本地 用于格式化月份和年份的 [CalendarLocale]。
     */
    fun 格式化月份年份(@Suppress("AutoBoxing") 月毫秒: Long?, 本地: CalendarLocale): String?

    /**
     * 将给定的 [日期毫秒] 格式化为日期字符串（例如：2021年3月27日）。
     *
     * @param 日期毫秒 自纪元起算的 UTC 毫秒时间戳，用于表示该日期。
     * @param 本地 用于格式化该日期的 [CalendarLocale]。
     * @param 用于内容描述 表示此次格式化是用于“内容描述”场景。此时返回的字符串会更具描述性，以便读屏软件朗读。
     */
    fun 格式化日期(
        @Suppress("AutoBoxing") 日期毫秒: Long?,
        本地: CalendarLocale,
        用于内容描述: Boolean = false,
    ): String?
}

/** 表示日期选择器可处于的不同模式。 */
@Immutable
object 显示模式{
    /** 日期选择器模式 */
    val 选择器 = DisplayMode.Picker

    /** 日期文本输入模式*/
    val 输入 = DisplayMode.Input
}

/**
 * 为 [DatePicker] 创建一个在重组过程中被记住（remember）的 [DatePickerState]。
 *
 * 如需在组合（composition）之外创建日期选择器状态，请使用 `DatePickerState` 函数。
 *
 * @param 初始选定日期毫秒 自纪元起算的 UTC 毫秒时间戳，用于表示日期的初始选中值；传入 `null` 表示无选中状态。
 * @param 初始显示月份毫秒数 自纪元起算的 UTC 毫秒时间戳，用于表示最初展示给用户的月份。若提供了 `初始选定日期毫秒`，
 * 则默认显示该日期所在的月份；若传 `null`，则默认显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可选择的年份范围。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates]，用于检查某个日期是否允许被选中。若日期不被允许，它将在界面中显示为禁用状态。
 */
@Composable
fun 记住日期选择器状态(
    @Suppress("AutoBoxing") 初始选定日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒数: Long? = 初始选定日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DatePickerState =
    rememberDatePickerState(
        initialSelectedDateMillis = 初始选定日期毫秒,
        initialDisplayedMonthMillis = 初始显示月份毫秒数,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选择日期,
    )

/**
 * 创建一个 [DatePickerState]。
 *
 * 在大多数情况下，建议在组合函数中使用 [记住日期选择器状态]。
 *
 * 请注意，如果你提供的 [本地] 与平台默认区域设置不同，则可能需要确保选择器的标题和副标题能被正确本地化。
 * 以下示例展示了一种可行方式：通过组合本地的 `LocalContext` 与 `LocaleConfiguration` 来实现。
 *
 * @param 本地 用于格式化日期、确定输入格式、显示星期、设置每周第一天等的 [CalendarLocale]。若所提供的 [CalendarLocale]
 * 与平台默认 Locale 不同，需确保选择器的标题和副标题已正确本地化；在某些情况下，还需应用 RTL 布局。
 * @param 初始选定日期毫秒 自纪元起算的 UTC 毫秒时间戳，用于表示日期的初始选中值；传入 `null` 表示无选中状态。
 * 请注意，状态的 [DatePickerState.selectedDateMillis] 返回的是当天**起始时刻**的时间戳，可能与传入的 初始选定日期毫秒 不同。
 * @param 初始显示月份毫秒数 自纪元起算的 UTC 毫秒时间戳，用于设置最初展示给用户的月份；若传 `null`，则默认显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可选择的年份范围。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates]，用于检查某个日期是否允许被选中；若不被允许，该日期将在界面中显示为禁用状态。
 * @throws [IllegalArgumentException] 如果初始选中的日期或要显示的月份所对应的年份超出了 [年份范围] 指定的范围，则会抛出异常。
 * @see 记住日期选择器状态
 */
fun 日期选择器状态(
    本地: CalendarLocale,
    @Suppress("AutoBoxing") 初始选定日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒数: Long? = 初始选定日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DatePickerState =
    DatePickerState(
        locale = 本地,
        initialSelectedDateMillis = 初始选定日期毫秒,
        initialDisplayedMonthMillis = 初始显示月份毫秒数,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选择日期,
    )

/** [DatePicker] 使用的默认值集合。 */
@Stable
object 日期选择器默认值 { //DatePickerDefaults

    /**
     * 创建一个 [DatePickerColors]，根据 Material 规范在提供的颜色之间进行动画过渡。
     */
    @Composable
    fun 颜色() = DatePickerDefaults.colors()

    /**
     * 创建一个 [DatePickerColors]，根据 Material 规范在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 日期选择器背景所用的颜色。
     * @param 标题内容颜色 日期选择器标题所用的颜色。
     * @param 副标题内容颜色 日期选择器副标题（headline）所用的颜色。
     * @param 工作日内容颜色 星期文字（ weekday letters ）所用的颜色。
     * @param 月年标题内容颜色 用于在 `DateRangePicker` 中显示月份时所出现的“月份与年份”副标题标签的颜色。
     * @param 导航内容颜色 在 `DatePicker` 中，用于年份选择菜单按钮与月份箭头导航的内容颜色。
     * @param 年份内容颜色 年份项内容所用的颜色。
     * @param 禁用年份内容颜色 被禁用的年份项内容所用的颜色。
     * @param 当前年份内容颜色 选择年份时，用于“当前年份”内容的颜色。
     * @param 已选年份内容颜色 用于已选中年份项内容的颜色。
     * @param 禁用已选年份内容颜色 用于“已选中但已被禁用”的年份项内容的颜色。
     * @param 已选年份容器颜色 用于已选中年份项背景容器的颜色。
     * @param 禁用已选年份容器颜色 用于“已选中但已被禁用”的年份项背景容器的颜色。
     * @param 日期内容颜色 日期数字内容所用的颜色。
     * @param 禁用日期内容颜色 被禁用的日期数字内容所用的颜色。
     * @param 已选日期内容颜色 已选中日期数字内容所用的颜色。
     * @param 禁用已选日期内容颜色 “已选中但已被禁用”的日期数字内容所用的颜色。
     * @param 已选日期容器颜色 已选中日期背景容器所用的颜色。
     * @param 禁用已选日期容器颜色 “已选中但已被禁用”的日期背景容器所用的颜色。
     * @param 今日内容颜色 用于标记“今天”的日期数字颜色。
     * @param 今天日期边框颜色 用于“今天”日期项边框的颜色。
     * @param 选中范围内容的日期颜色 用于处于日期范围选择内的日期项的内容颜色。
     * @param 选中范围容器的日期颜色 用于处于日期范围选择内的日期项的容器（背景）颜色。
     * @param 分隔线颜色 日期选择器中分隔线所用的颜色。
     * @param 日期文本字段颜色 在 [DisplayMode.Input] 模式下，日期文本框所采用的 [TextFieldColors] 默认配色。参见 [轮廓文本字段默认值.颜色]。
     */
    @Composable
    fun 颜色(
        容器颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        副标题内容颜色: Color = Color.Unspecified,
        工作日内容颜色: Color = Color.Unspecified,
        月年标题内容颜色: Color = Color.Unspecified,
        导航内容颜色: Color = Color.Unspecified,
        年份内容颜色: Color = Color.Unspecified,
        禁用年份内容颜色: Color = Color.Unspecified,
        当前年份内容颜色: Color = Color.Unspecified,
        已选年份内容颜色: Color = Color.Unspecified,
        禁用已选年份内容颜色: Color = Color.Unspecified,
        已选年份容器颜色: Color = Color.Unspecified,
        禁用已选年份容器颜色: Color = Color.Unspecified,
        日期内容颜色: Color = Color.Unspecified,
        禁用日期内容颜色: Color = Color.Unspecified,
        已选日期内容颜色: Color = Color.Unspecified,
        禁用已选日期内容颜色: Color = Color.Unspecified,
        已选日期容器颜色: Color = Color.Unspecified,
        禁用已选日期容器颜色: Color = Color.Unspecified,
        今日内容颜色: Color = Color.Unspecified,
        今天日期边框颜色: Color = Color.Unspecified,
        选中范围内容的日期颜色: Color = Color.Unspecified,
        选中范围容器的日期颜色: Color = Color.Unspecified,
        分隔线颜色: Color = Color.Unspecified,
        日期文本字段颜色: TextFieldColors? = null,
    ): DatePickerColors =
        DatePickerDefaults.colors(
            containerColor = 容器颜色,
            titleContentColor = 标题内容颜色,
            headlineContentColor = 副标题内容颜色,
            weekdayContentColor = 工作日内容颜色,
            subheadContentColor = 月年标题内容颜色,
            navigationContentColor = 导航内容颜色,
            yearContentColor = 年份内容颜色,
            disabledYearContentColor = 禁用年份内容颜色,
            currentYearContentColor = 当前年份内容颜色,
            selectedYearContentColor = 已选年份内容颜色,
            disabledSelectedYearContentColor = 禁用已选年份内容颜色,
            selectedYearContainerColor = 已选年份容器颜色,
            disabledSelectedYearContainerColor = 禁用已选年份容器颜色,
            dayContentColor = 日期内容颜色,
            disabledDayContentColor = 禁用日期内容颜色,
            selectedDayContentColor = 已选日期内容颜色,
            disabledSelectedDayContentColor = 禁用已选日期内容颜色,
            selectedDayContainerColor = 已选日期容器颜色,
            disabledSelectedDayContainerColor = 禁用已选日期容器颜色,
            todayContentColor = 今日内容颜色,
            todayDateBorderColor = 今天日期边框颜色,
            dayInSelectionRangeContentColor = 选中范围内容的日期颜色,
            dayInSelectionRangeContainerColor = 选中范围容器的日期颜色,
            dividerColor = 分隔线颜色,
            dateTextFieldColors = 日期文本字段颜色,
        )

    /**
     * 返回一个 [DatePickerFormatter]。
     *
     * 该日期格式化器会根据给定的“骨架”（skeleton）和 Locale，自动应用最合适的本地格式。骨架与 Unicode
     * <a href="http://www.unicode.org/reports/tr35/#Date_Format_Patterns">UTS #35</a> 模式使用相同的格式字符，
     * 但只保留“字段类型”而忽略具体长度。
     *
     * 其中一个区别是：顺序无关紧要。例如，骨架 `"MMMMd"` 在 `en_US` 环境下会输出 `"MMMM d"`（如 *March 27*），
     * 而在 `de_CH` 环境下则输出 `"d. MMMM"`（如 *27. März*）。
     *
     * @param 年份选择骨架 用于格式化日期选择器“年份选择菜单按钮”的日期骨架（例如 “March 2021”）。
     * @param 选定日期骨架 用于格式化已选中日期的日期骨架（例如 “Mar 27, 2021”）。
     * @param 已选日期描述框架 用于将已选日期格式化为供屏幕阅读器朗读的“内容描述”的日期骨架（例如 “Saturday, March 27, 2021”）。
     */
    fun 日期格式化器(
        年份选择骨架: String = 年月骨架,
        选定日期骨架: String = 年缩写月日骨架,
        已选日期描述框架: String = 年月星期日骨架,
    ): DatePickerFormatter =
        DatePickerDefaults.dateFormatter(
            yearSelectionSkeleton = 年份选择骨架,
            selectedDateSkeleton = 选定日期骨架,
            selectedDateDescriptionSkeleton = 已选日期描述框架,
        )

    /**
     * 一个默认的日期选择器标题组合项（composable）。
     *
     * @param 显示模式 当前的 [DisplayMode]。
     * @param 修饰符 应用于该标题的 [Modifier]。
     * @param 内容颜色 此标题的内容（文字）颜色。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 日期选择器标题(
        显示模式: DisplayMode,
        修饰符: Modifier = Modifier,
        内容颜色: Color = 颜色().titleContentColor,
    ) {
        DatePickerDefaults.DatePickerTitle(
            displayMode = 显示模式,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )
    }

    /**
     * 一个默认的日期选择器副标题组合项：未选择日期时显示默认提示文字；选择日期后显示对应的日期字符串。
     *
     * @param 选定日期毫秒 一个时间戳，表示所选日期当天的**起始时刻**，以**UTC 毫秒**为单位，自纪元起算。
     * @param 显示模式 当前的 [DisplayMode]。
     * @param 日期格式化器 一个 [DatePickerFormatter]。
     * @param 修饰符 应用于该副标题的 [Modifier]。
     * @param 内容颜色 此副标题的内容（文字）颜色。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 日期选择器副标题(
        @Suppress("AutoBoxing") 选定日期毫秒: Long?,
        显示模式: DisplayMode,
        日期格式化器: DatePickerFormatter,
        修饰符: Modifier = Modifier,
        内容颜色: Color = 颜色().headlineContentColor,
    ) {
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = 选定日期毫秒,
            displayMode = 显示模式,
            dateFormatter = 日期格式化器,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )
    }

    /** 日期选择器对话框的年份范围。 */
    val 年份范围: IntRange = DatePickerDefaults.YearRange

    /** [DatePickerDialog] 默认采用的色调高度（tonal elevation）。 */
    val 色调阴影: Dp = DatePickerDefaults.TonalElevation

    /** 日期选择器对话框的默认形状。 */
    val 形状: Shape
        @Composable get() = DatePickerDefaults.shape

    /** 一个默认的 [SelectableDates]，允许选择所有日期。 */
    val 所有日期: SelectableDates = DatePickerDefaults.AllDates

    /**
     * 用于格式化日期选择器“年份选择菜单按钮”的日期骨架（例如 “March 2021”）。
     */
    const val 年月骨架: String = DatePickerDefaults.YearMonthSkeleton

    /** 用于格式化已选日期的日期骨架（例如 “Mar 27, 2021”）。 */
    const val 年缩写月日骨架: String = DatePickerDefaults.YearAbbrMonthDaySkeleton

    /**
     * 用于将已选日期格式化为屏幕阅读器内容描述（content description）的日期骨架（例如 “Saturday, March 27, 2021”）。
     */
    const val 年月星期日骨架: String = DatePickerDefaults.YearMonthWeekdayDaySkeleton
}


/**
 * 表示日期选择器所使用的颜色集合。
 *
 * @param 容器颜色 日期选择器背景所用的颜色。
 * @param 标题内容颜色 日期选择器标题所用的颜色。
 * @param 副标题内容颜色 日期选择器副标题（headline）所用的颜色。
 * @param 工作日内容颜色 星期文字（ weekday letters ）所用的颜色。
 * @param 月年标题内容颜色 在 `DateRangePicker` 中显示月份时，用于“月份与年份”副标题标签的颜色。
 * @param 导航内容颜色 在 `DatePicker` 中，用于年份选择菜单按钮与月份箭头导航的内容颜色。
 * @param 年份内容颜色 年份项内容所用的颜色。
 * @param 禁用年份内容颜色 被禁用的年份项内容所用的颜色。
 * @param 当前年份内容颜色 选择年份时，用于“当前年份”内容的颜色。
 * @param 已选年份内容颜色 用于已选中年份项内容的颜色。
 * @param 禁用已选年份内容颜色 用于“已选中但已被禁用”的年份项内容的颜色。
 * @param 已选年份容器颜色 用于已选中年份项背景容器的颜色。
 * @param 禁用已选年份容器颜色 用于“已选中但已被禁用”的年份项背景容器的颜色。
 * @param 日期内容颜色 日期数字内容所用的颜色。
 * @param 禁用日期内容颜色 被禁用的日期数字内容所用的颜色。
 * @param 已选日期内容颜色 已选中日期数字内容所用的颜色。
 * @param 禁用已选日期内容颜色 “已选中但已被禁用”的日期数字内容所用的颜色。
 * @param 已选日期容器颜色 已选中日期背景容器所用的颜色。
 * @param 禁用已选日期容器颜色 “已选中但已被禁用”的日期背景容器所用的颜色。
 * @param 今日内容颜色 用于标记“今天”的日期数字颜色。
 * @param 今天日期边框颜色 用于标记“今天”的日期项边框颜色。
 * @param 选中范围内日期的容器颜色 用于处于日期范围选择内的日期项内容（文字）的颜色。
 * @param 选中范围内日期的内容颜色 用于处于日期范围选择内的日期项背景容器的颜色。
 * @param 分隔线颜色 日期选择器中分隔线所用的颜色。
 * @param 日期文本字段颜色 在 [DisplayMode.Input] 模式下，日期文本字段所采用的默认 [TextFieldColors]；详见 [轮廓文本字段默认值.颜色]。
 * @constructor 如需创建自定义颜色的实例，请参考遵循 Material 规范的默认实现 [DatePickerDefaults.colors]。
 */
@Immutable
class 日期选择器颜色( //DatePickerColors
    val 容器颜色: Color,
    val 标题内容颜色: Color,
    val 副标题内容颜色: Color,
    val 工作日内容颜色: Color,
    val 月年标题内容颜色: Color,
    val 导航内容颜色: Color,
    val 年份内容颜色: Color,
    val 禁用年份内容颜色: Color,
    val 当前年份内容颜色: Color,
    val 已选年份内容颜色: Color,
    val 禁用已选年份内容颜色: Color,
    val 已选年份容器颜色: Color,
    val 禁用已选年份容器颜色: Color,
    val 日期内容颜色: Color,
    val 禁用日期内容颜色: Color,
    val 已选日期内容颜色: Color,
    val 禁用已选日期内容颜色: Color,
    val 已选日期容器颜色: Color,
    val 禁用已选日期容器颜色: Color,
    val 今日内容颜色: Color,
    val 今天日期边框颜色: Color,
    val 选中范围内日期的容器颜色: Color,
    val 选中范围内日期的内容颜色: Color,
    val 分隔线颜色: Color,
    val 日期文本字段颜色: TextFieldColors,
) {
    /**
     * 返回此 DatePickerColors 的一个副本，可选择性地覆盖部分颜色值。对于普通颜色参数，使用 `Color.Unspecified` 表示“保留源值”；
     * 对于 `日期文本字段颜色` 参数，使用 `null` 表示“保留源值”。
     */
    fun 复制(
        容器颜色: Color = this.容器颜色,
        标题内容颜色: Color = this.标题内容颜色,
        副标题内容颜色: Color = this.副标题内容颜色,
        工作日内容颜色: Color = this.工作日内容颜色,
        月年标题内容颜色: Color = this.月年标题内容颜色,
        导航内容颜色: Color = this.导航内容颜色,
        年份内容颜色: Color = this.年份内容颜色,
        禁用年份内容颜色: Color = this.禁用年份内容颜色,
        当前年份内容颜色: Color = this.当前年份内容颜色,
        已选年份内容颜色: Color = this.已选年份内容颜色,
        禁用已选年份内容颜色: Color = this.禁用已选年份内容颜色,
        已选年份容器颜色: Color = this.已选年份容器颜色,
        禁用已选年份容器颜色: Color = this.禁用已选年份容器颜色,
        日期内容颜色: Color = this.日期内容颜色,
        禁用日期内容颜色: Color = this.禁用日期内容颜色,
        已选日期内容颜色: Color = this.已选日期内容颜色,
        禁用已选日期内容颜色: Color = this.禁用已选日期内容颜色,
        已选日期容器颜色: Color = this.已选日期容器颜色,
        禁用已选日期容器颜色: Color = this.禁用已选日期容器颜色,
        今日内容颜色: Color = this.今日内容颜色,
        今天日期边框颜色: Color = this.今天日期边框颜色,
        选中范围内日期的容器颜色: Color = this.选中范围内日期的容器颜色,
        选中范围内日期的内容颜色: Color = this.选中范围内日期的内容颜色,
        分隔线颜色: Color = this.分隔线颜色,
        日期文本字段颜色: TextFieldColors? = this.日期文本字段颜色,
    ) =
        DatePickerColors(
            容器颜色.takeOrElse { this.容器颜色 },
            标题内容颜色.takeOrElse { this.标题内容颜色 },
            副标题内容颜色.takeOrElse { this.副标题内容颜色 },
            工作日内容颜色.takeOrElse { this.工作日内容颜色 },
            月年标题内容颜色.takeOrElse { this.月年标题内容颜色 },
            导航内容颜色.takeOrElse { this.导航内容颜色 },
            年份内容颜色.takeOrElse { this.年份内容颜色 },
            禁用年份内容颜色.takeOrElse { this.禁用年份内容颜色 },
            当前年份内容颜色.takeOrElse { this.当前年份内容颜色 },
            已选年份内容颜色.takeOrElse { this.已选年份内容颜色 },
            禁用已选年份内容颜色.takeOrElse { this.禁用已选年份内容颜色 },
            已选年份容器颜色.takeOrElse { this.已选年份容器颜色 },
            禁用已选年份容器颜色.takeOrElse { this.禁用已选年份容器颜色 },
            日期内容颜色.takeOrElse { this.日期内容颜色 },
            禁用日期内容颜色.takeOrElse { this.禁用日期内容颜色 },
            已选日期内容颜色.takeOrElse { this.已选日期内容颜色 },
            禁用已选日期内容颜色.takeOrElse { this.禁用已选日期内容颜色 },
            已选日期容器颜色.takeOrElse { this.已选日期容器颜色 },
            禁用已选日期容器颜色.takeOrElse { this.禁用已选日期容器颜色 },
            今日内容颜色.takeOrElse { this.今日内容颜色 },
            今天日期边框颜色.takeOrElse { this.今天日期边框颜色 },
            选中范围内日期的容器颜色.takeOrElse { this.选中范围内日期的容器颜色 },
            选中范围内日期的内容颜色.takeOrElse { this.选中范围内日期的内容颜色 },
            分隔线颜色.takeOrElse { this.分隔线颜色 },
            日期文本字段颜色.takeOrElse { this.日期文本字段颜色 },
        )

    internal fun TextFieldColors?.takeOrElse(block: () -> TextFieldColors): TextFieldColors =
        this ?: block()

    override fun equals(other: Any?): Boolean {
        if (other !is DatePickerColors) return false
        if (容器颜色 != other.containerColor) return false
        if (标题内容颜色 != other.titleContentColor) return false
        if (副标题内容颜色 != other.headlineContentColor) return false
        if (工作日内容颜色 != other.weekdayContentColor) return false
        if (月年标题内容颜色 != other.subheadContentColor) return false
        if (年份内容颜色 != other.yearContentColor) return false
        if (禁用年份内容颜色 != other.disabledYearContentColor) return false
        if (当前年份内容颜色 != other.currentYearContentColor) return false
        if (已选年份内容颜色 != other.selectedYearContentColor) return false
        if (禁用已选年份内容颜色 != other.disabledSelectedYearContentColor) return false
        if (已选年份容器颜色 != other.selectedYearContainerColor) return false
        if (禁用已选年份容器颜色 != other.disabledSelectedYearContainerColor) return false
        if (日期内容颜色 != other.dayContentColor) return false
        if (禁用日期内容颜色 != other.disabledDayContentColor) return false
        if (已选日期内容颜色 != other.selectedDayContentColor) return false
        if (禁用已选日期内容颜色 != other.disabledSelectedDayContentColor) return false
        if (已选日期容器颜色 != other.selectedDayContainerColor) return false
        if (禁用已选日期容器颜色 != other.disabledSelectedDayContainerColor) return false
        if (今日内容颜色 != other.todayContentColor) return false
        if (今天日期边框颜色 != other.todayDateBorderColor) return false
        if (选中范围内日期的容器颜色 != other.dayInSelectionRangeContainerColor) return false
        if (选中范围内日期的内容颜色 != other.dayInSelectionRangeContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 标题内容颜色.hashCode()
        result = 31 * result + 副标题内容颜色.hashCode()
        result = 31 * result + 工作日内容颜色.hashCode()
        result = 31 * result + 月年标题内容颜色.hashCode()
        result = 31 * result + 年份内容颜色.hashCode()
        result = 31 * result + 禁用年份内容颜色.hashCode()
        result = 31 * result + 当前年份内容颜色.hashCode()
        result = 31 * result + 已选年份内容颜色.hashCode()
        result = 31 * result + 禁用已选年份内容颜色.hashCode()
        result = 31 * result + 已选年份容器颜色.hashCode()
        result = 31 * result + 禁用已选年份容器颜色.hashCode()
        result = 31 * result + 日期内容颜色.hashCode()
        result = 31 * result + 禁用日期内容颜色.hashCode()
        result = 31 * result + 已选日期内容颜色.hashCode()
        result = 31 * result + 禁用已选日期内容颜色.hashCode()
        result = 31 * result + 已选日期容器颜色.hashCode()
        result = 31 * result + 禁用已选日期容器颜色.hashCode()
        result = 31 * result + 今日内容颜色.hashCode()
        result = 31 * result + 今天日期边框颜色.hashCode()
        result = 31 * result + 选中范围内日期的容器颜色.hashCode()
        result = 31 * result + 选中范围内日期的内容颜色.hashCode()
        return result
    }
}


private val DatePickerTitlePadding = PaddingValues(start = 24.dp, end = 12.dp, top = 16.dp)
private val DatePickerHeadlinePadding = PaddingValues(start = 24.dp, end = 12.dp, bottom = 12.dp)

