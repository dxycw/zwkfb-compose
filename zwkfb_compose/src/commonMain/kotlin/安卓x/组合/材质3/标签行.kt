package 安卓x.组合.材质3

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.TabIndicatorScope
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design fixed primary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 主要标签页（Primary tabs）放置在内容窗格顶部、顶部应用栏下方。它们展示主要的内容目的地。固定标签页（Fixed tabs）同时显示一组中的所有标签页，
 * 最适合用于在相关内容之间快速切换，例如在地图中的不同交通方式之间切换。要在固定标签页之间导航，请点击单个标签页，或在内容区域左右滑动。
 *
 * TabRow 包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。TabRow 会将标签页均匀分布在整个行内，每个标签页占据相等的空间。
 * 如需使用不强制等宽且允许滚动以查看屏幕容纳不下的标签页的标签行，请参见 [PrimaryScrollableTabRow]。
 *
 * 除自定义标签页外，你还可以提供自定义的 [指示器] 来定制标签页指示器的显示方式。[指示器] 将被放置并填满整个 TabRow，
 * 因此它需要在内部处理指示器的尺寸和定位，以跟随 [已选中标签索引] 的变化。
 *
 * 我们可以复用 [TabRowDefaults.tabIndicatorOffset]，只需提供此指示器即可，因为我们并未改变指示器在不同标签页之间切换时的尺寸和位置变化逻辑：
 *
 * 您可能还希望使用自定义过渡动画，以便在指示器于标签页之间切换时动态改变其外观，例如改变颜色或尺寸。[指示器] 是堆叠在整个 TabRow 之上的，因此您只需提供一个
 * 自定义过渡动画，使其从 TabRow 的起始位置开始动画化指示器的偏移量即可。例如，请看以下示例，它使用过渡动画来同时动画化前述 FancyIndicator 的偏移量、宽度和颜色，
 * 还基于物理原理为指示器添加了运动方向上的"弹簧"效果：
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.PrimaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset] 修饰符来实现位置
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 主标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    指示器: @Composable TabIndicatorScope.() -> Unit = {
        TabRowDefaults.PrimaryIndicator(
            modifier = Modifier.tabIndicatorOffset(已选中标签索引, matchContentSize = true),
            width = Dp.Unspecified,
        )
    },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签: @Composable () -> Unit,
) {
    PrimaryTabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签,
    )
}

/**
 * [Material Design fixed secondary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 次要标签页（Secondary tabs）用于内容区域内，以进一步区分相关内容并建立层级关系。固定标签页会同时显示一组中的所有标签页。
 * 要在固定标签页之间切换，可点击单个标签页，或在内容区域内左右滑动。
 *
 * 标签行 包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。Fixed TabRow 将标签页均匀分布在整个行内，每个标签页占据相等的空间。
 * 如需使用不强制等宽且允许滚动以查看屏幕容纳不下的标签页的标签行，请参见 [SecondaryScrollableTabRow]。
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.SecondaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset]
 * 修饰符来实现位置动画。请注意，此指示器将被强制填满整个标签行，因此您应使用 [TabRowDefaults.tabIndicatorOffset]或类似
 * 修饰符在该空间内为实际绘制的指示器添加动画，并提供相对于起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 次标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.secondaryContainerColor,
    内容颜色: Color = TabRowDefaults.secondaryContentColor,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(已选中标签索引, matchContentSize = false)
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签: @Composable () -> Unit,
) {
    SecondaryTabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签,
    )
}

/**
 * [Material Design scrollable primary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 主要标签页放置在内容窗格顶部、顶部应用栏下方。它们展示主要的内容导航目标。当一组标签页无法在屏幕上完整显示时，请使用可滚动标签页。
 * 可滚动标签页可以使用较长的文本标签和更多的标签数量。它们最适用于触摸屏界面上的浏览操作。
 *
 * 可滚动标签行包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。它将标签页从起始边缘偏移放置，并支持滚动查看屏幕外的标签页。
 * 如需使用不允许滚动且标签页均匀分布的固定标签行，请参见 [PrimaryTabRow]。
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 滚动状态 此标签行的 [ScrollState]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行左右边缘与内部标签页之间的内边距。此内边距可提示用户该标签行支持滚动，与[标签行]不同。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.PrimaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset] 修饰符来实现位置
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 最小标签宽度 此标签行中 [标签] 的最小宽度，不受内容大小影响。即使标签内容很短，Tab 宽度也不会小于此值。
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 主可滚动标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    滚动状态: ScrollState = rememberScrollState(),
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.PrimaryIndicator(
                Modifier.tabIndicatorOffset(已选中标签索引, matchContentSize = true),
                width = Dp.Unspecified,
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    最小标签宽度: Dp = TabRowDefaults.ScrollableTabRowMinTabWidth,
    标签: @Composable () -> Unit,
) {
    PrimaryScrollableTabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        scrollState = 滚动状态,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        minTabWidth = 最小标签宽度,
        tabs = 标签,
    )
}

/**
 * [Material Design scrollable secondary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 次要标签页用于内容区域内，以进一步区分相关内容并建立层级关系。当一组标签页无法在屏幕上完整显示时，请使用可滚动标签页。
 * 可滚动标签页可以使用较长的文本标签和更多的标签数量。它们最适用于触摸屏界面上的浏览操作。
 *
 * 可滚动标签行包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。它将标签页从起始边缘偏移放置，并允许滚动查看屏幕外的标签页。
 * 如需使用不允许滚动且标签页均匀分布的固定标签行，请参见 [SecondaryTabRow]。
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 滚动状态 此标签行的 [ScrollState]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行左右边缘与内部标签页之间的内边距。此内边距可提示用户该标签行支持滚动，与[TabRow]不同。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.SecondaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset]
 * 修饰符来实现位置动画。请注意，此指示器将被强制填满整个 标签行，因此您应使用 [TabRowDefaults.tabIndicatorOffset]
 * 或类似修饰符在该空间内为实际绘制的指示器添加动画，并提供相对于起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 最小标签宽度 此标签行中 [标签] 的最小宽度，不受内容大小影响。即使标签内容很短，标签 宽度也不会小于此值。
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 次可滚动标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    滚动状态: ScrollState = rememberScrollState(),
    容器颜色: Color = TabRowDefaults.secondaryContainerColor,
    内容颜色: Color = TabRowDefaults.secondaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(已选中标签索引, matchContentSize = false)
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    最小标签宽度: Dp = TabRowDefaults.ScrollableTabRowMinTabWidth,
    标签: @Composable () -> Unit,
) {
    SecondaryScrollableTabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        scrollState = 滚动状态,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        minTabWidth = 最小标签宽度,
        tabs = 标签,
    )
}

/** 包含 TabRow 的默认实现和值。 */
object 标签行默认值 { //TabRowDefaults
    /**
     * [PrimaryScrollableTabRow] 或 [SecondaryScrollableTabRow] 中标签页的默认最小宽度。
     */
    val 可滚动标签行最小标签宽度 = TabRowDefaults.ScrollableTabRowMinTabWidth

    /**
     * [PrimaryScrollableTabRow] 或 [SecondaryScrollableTabRow] 中从起始边缘到首个标签页之前的默认内边距。
     */
    val 可滚动标签行起始内边距 = TabRowDefaults.ScrollableTabRowEdgeStartPadding

    /** 标签行的默认容器颜色。 */
    @Deprecated(
        message = "Use TabRowDefaults.primaryContainerColor instead",
        replaceWith = ReplaceWith("primaryContainerColor"),
    )
    val 容器颜色: Color
        @Composable get() = TabRowDefaults.containerColor

    /** [PrimaryTabRow] 的默认容器颜色。 */
    val 主容器颜色: Color
        @Composable get() = TabRowDefaults.primaryContainerColor

    /** [SecondaryTabRow] 的默认容器颜色。 */
    val 次容器颜色: Color
        @Composable get() = TabRowDefaults.secondaryContainerColor

    /** 标签行的默认内容颜色 */
    @Deprecated(
        message = "Use TabRowDefaults.primaryContentColor instead",
        replaceWith = ReplaceWith("primaryContentColor"),
    )
    val 内容颜色: Color
        @Composable get() = TabRowDefaults.contentColor

    /** [PrimaryTabRow] 的默认内容颜色。*/
    val 主内容颜色: Color
        @Composable get() = TabRowDefaults.primaryContentColor

    /** [SecondaryTabRow] 的默认内容颜色。 */
    val 次内容颜色: Color
        @Composable get() = TabRowDefaults.secondaryContentColor

    /**
     * 默认指示器，将被置于 [TabRow] 底部、分隔线上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    @Deprecated(
        message = "Use SecondaryIndicator instead.",
        replaceWith = ReplaceWith("SecondaryIndicator(modifier, height, color)"),
    )
    fun 指示器(
        修饰符: Modifier = Modifier,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
    ) {
        TabRowDefaults.Indicator(modifier = 修饰符, height = 高度, color = 颜色)
    }

    /**
     * 主要指示器，将被置于 [TabRow] 底部、分隔线上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 宽度 指示器的宽度
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     * @param 形状 指示器的形状
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 主指示器(
        修饰符: Modifier = Modifier,
        宽度: Dp = 24.dp,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
        形状: Shape = RoundedCornerShape(3.0.dp),
    ) {
        TabRowDefaults.PrimaryIndicator(modifier = 修饰符, width = 宽度, height = 高度, color = 颜色, shape = 形状)
    }

    /**
     * 次要指示器，将被置于 [标签行] 底部、分隔线上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @Composable
    fun 次指示器(
        修饰符: Modifier = Modifier,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
    ) {
        TabRowDefaults.SecondaryIndicator(modifier = 修饰符, height = 高度, color = 颜色)
    }

    /**
     * 占据 [标签行] 内所有可用宽度的 [Modifier]，会根据 [当前标签位置] 动画化其所应用指示器的偏移量。
     *
     * @param 当前标签位置 当前选中标签页的 [TabPosition]。用于计算此修饰符所应用指示器的偏移量及其宽度。
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message =
            "Solely for use alongside deprecated TabRowDefaults.Indicator method. For " +
                    "recommended PrimaryIndicator and SecondaryIndicator methods, please use " +
                    "TabIndicatorScope.tabIndicatorOffset method.",
    )
    fun Modifier.标签指示器偏移(当前标签位置: TabPosition): Modifier =
        this.tabIndicatorOffset(currentTabPosition = 当前标签位置)
}


/**
 * [Material Design tabs](https://m3.material.io/components/tabs/overview)
 *
 * 对于主要指示器标签页，使用 [PrimaryTabRow]。对于次要指示器标签页，使用 [SecondaryTabRow]。
 *
 * 固定标签页会同时显示一组中的所有标签页。它们最适合用于在相关内容之间快速切换，例如在地图中的不同交通方式之间切换。要在固定标签页之间导航，
 * 请点击单个标签页，或在内容区域左右滑动。
 *
 * 标签行 包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。TabRow 将标签页均匀分布在整个行内，每个标签页占据相等的空间。
 * 如需使用不强制等宽且允许滚动以查看屏幕容纳不下的标签页的标签行，请参见 [ScrollableTabRow]。
 *
 * 除了自定义标签页，你还可以提供自定义的 [指示器] 来定制标签页的指示器。[指示器] 会被放置并填满整个 标签行，因此它需要在内部处理指示器的尺寸和定位，
 * 以跟随 [已选中标签索引] 的变化。
 *
 * 我们可以复用 [TabRowDefaults.tabIndicatorOffset]，只需提供此指示器即可，因为我们并未改变指示器在不同标签页之间切换时的尺寸和位置变化逻辑：
 *
 * 您可能还希望使用自定义过渡动画，以便在指示器于标签页之间切换时动态改变其外观，例如改变颜色或尺寸。[指示器] 是堆叠在整个 标签行 之上的，
 * 因此您只需提供一个自定义过渡动画，使其从 TabRow 的起始位置开始动画化指示器的偏移量即可。例如，请看以下示例，它使用过渡动画来同时动画化前述
 * FancyIndicator 的偏移量、宽度和颜色，还基于物理原理为指示器添加了运动方向上的"弹簧"效果：
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.SecondaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset]
 * 修饰符来实现位置动画。请注意，此指示器将被强制填满整个 TabRow，因此您应使用 [TabRowDefaults.tabIndicatorOffset]
 * 或类似修饰符在该空间内为实际绘制的指示器添加动画，并提供相对于起始位置的偏移量。
 * @param 分隔线 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.SecondaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset]
 * 修饰符来实现位置动画。请注意，此指示器将被强制填满整个 TabRow，因此您应使用 [TabRowDefaults.tabIndicatorOffset]
 * 或类似修饰符在该空间内为实际绘制的指示器添加动画，并提供相对于起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Composable
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Replaced with PrimaryTabRow and SecondaryTabRow.",
    replaceWith =
        ReplaceWith(
            "SecondaryTabRow(selectedTabIndex, modifier, containerColor, contentColor, indicator, divider, tabs)"
        ),
)
@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
fun 标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    指示器: @Composable (tabPositions: List<TabPosition>) -> Unit =
        @Composable { tabPositions ->
            if (已选中标签索引 < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[已选中标签索引])
                )
            }
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签: @Composable () -> Unit,
) {
    TabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签,
    )
}

/**
 * [Material Design tabs](https://m3.material.io/components/tabs/overview)
 *
 * 对于主要指示器标签页，使用 [PrimaryScrollableTabRow]。对于次要指示器标签页，使用 [SecondaryScrollableTabRow]。
 *
 * 当一组标签页无法在屏幕上完整显示时，请使用可滚动标签页。可滚动标签页可以使用较长的文本标签和更多的标签数量。它们最适用于触摸屏界面上的浏览操作。
 *
 * ScrollableTabRow 包含一行 [标签]，并在当前选中的标签页下方显示一个指示器。ScrollableTabRow 将标签页从起始边缘偏移放置，
 * 并允许滚动查看屏幕外的标签页。如需使用不允许滚动且标签页均匀分布的固定标签行，请参见 [标签行]。
 *
 * @param 已选中标签索引 当前选中标签页的索引
 * @param 修饰符 应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无背景色（透明）。
 * @param 内容颜色 此标签行中内容的首选颜色。默认为 [容器颜色] 对应的内容颜色；若 [容器颜色] 不是主题颜色，则默认为当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行左右边缘与内部标签页之间的内边距。此内边距可提示用户该标签行支持滚动，与[标签行]不同。
 * @param 指示器 用于表示当前选中标签页的指示器。默认使用 [TabRowDefaults.SecondaryIndicator]，并配合 [TabRowDefaults.tabIndicatorOffset]
 * 修饰符来实现位置动画。请注意，此指示器将被强制填满整个 TabRow，因此您应使用 [TabRowDefaults.tabIndicatorOffset]
 * 或类似修饰符在该空间内为实际绘制的指示器添加动画，并提供相对于起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与其下方显示的内容之间提供一层分隔
 * @param 标签 此标签行中的标签页。通常包含多个 [标签]。lambda 内的每个元素都将被测量并均匀分布于整行，每个占据相等的空间。
 */
@Composable
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.",
    replaceWith =
        ReplaceWith(
            "SecondaryScrollableTabRow(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, indicator, divider, tabs)"
        ),
)
@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
fun 可滚动标签行(
    已选中标签索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable (tabPositions: List<TabPosition>) -> Unit =
        @Composable { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(tabPositions[已选中标签索引])
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签: @Composable () -> Unit,
) {
    ScrollableTabRow(
        selectedTabIndex = 已选中标签索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签,
    )
}


//==============================================================


/**
 * [PrimaryScrollableTabRow] 或 [SecondaryScrollableTabRow] 中标签页的默认最小宽度。
 */
val TabRowDefaults.可滚动标签行最小标签宽度
    get() = this.ScrollableTabRowMinTabWidth

/**
 * [PrimaryScrollableTabRow] 或 [SecondaryScrollableTabRow] 中从起始边缘到首个标签页之前的默认内边距。
 */
val TabRowDefaults.可滚动标签行起始内边距
    get() = this.ScrollableTabRowEdgeStartPadding

/** 标签行的默认容器颜色。 */
@Deprecated(
    message = "Use TabRowDefaults.primaryContainerColor instead",
    replaceWith = ReplaceWith("primaryContainerColor"),
)
val TabRowDefaults.容器颜色: Color
    @Composable get() = this.containerColor

/** [PrimaryTabRow] 的默认容器颜色。 */
val TabRowDefaults.主容器颜色: Color
    @Composable get() = this.primaryContainerColor

/** [SecondaryTabRow] 的默认容器颜色。 */
val TabRowDefaults.次容器颜色: Color
    @Composable get() = this.secondaryContainerColor

/** 标签行的默认内容颜色 */
@Deprecated(
    message = "Use TabRowDefaults.primaryContentColor instead",
    replaceWith = ReplaceWith("primaryContentColor"),
)
val TabRowDefaults.内容颜色: Color
    @Composable get() = this.contentColor

/** [PrimaryTabRow] 的默认内容颜色。*/
val TabRowDefaults.主内容颜色: Color
    @Composable get() = this.primaryContentColor

/** [SecondaryTabRow] 的默认内容颜色。 */
val TabRowDefaults.次内容颜色: Color
    @Composable get() = this.secondaryContentColor

/**
 * 默认指示器，将被置于 [TabRow] 底部、分隔线上方。
 *
 * @param 修饰符 指示器的布局修饰符
 * @param 高度 指示器的高度
 * @param 颜色 指示器的颜色
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@Deprecated(
    message = "Use SecondaryIndicator instead.",
    replaceWith = ReplaceWith("SecondaryIndicator(modifier, height, color)"),
)
fun TabRowDefaults.指示器(
    修饰符: Modifier = Modifier,
    高度: Dp = 3.0.dp,
    颜色: Color = MaterialTheme.colorScheme.primary,
) {
    this.Indicator(modifier = 修饰符, height = 高度, color = 颜色)
}

/**
 * 主要指示器，将被置于 [TabRow] 底部、分隔线上方。
 *
 * @param 修饰符 指示器的布局修饰符
 * @param 宽度 指示器的宽度
 * @param 高度 指示器的高度
 * @param 颜色 指示器的颜色
 * @param 形状 指示器的形状
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun TabRowDefaults.主指示器(
    修饰符: Modifier = Modifier,
    宽度: Dp = 24.dp,
    高度: Dp = 3.0.dp,
    颜色: Color = MaterialTheme.colorScheme.primary,
    形状: Shape = RoundedCornerShape(3.0.dp),
) {
    this.PrimaryIndicator(modifier = 修饰符, width = 宽度, height = 高度, color = 颜色, shape = 形状)
}

/**
 * 次要指示器，将被置于 [标签行] 底部、分隔线上方。
 *
 * @param 修饰符 指示器的布局修饰符
 * @param 高度 指示器的高度
 * @param 颜色 指示器的颜色
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun TabRowDefaults.次指示器(
    修饰符: Modifier = Modifier,
    高度: Dp = 3.0.dp,
    颜色: Color = MaterialTheme.colorScheme.primary,
) {
    this.SecondaryIndicator(modifier = 修饰符, height = 高度, color = 颜色)
}
