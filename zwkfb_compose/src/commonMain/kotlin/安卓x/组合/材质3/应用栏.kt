package 安卓x.组合.材质3

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.BottomAppBarState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ComponentOverrideApi
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LocalSingleRowTopAppBarOverride
import androidx.compose.material3.LocalTwoRowsTopAppBarOverride
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumFlexibleTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.SingleRowTopAppBarOverride
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.TwoRowsTopAppBar
import androidx.compose.material3.TwoRowsTopAppBarOverride
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design small top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * 这种小型 TopAppBar 提供标题、导航图标和操作按钮的插槽。
 *
 * ![Small top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/small-top-app-bar.png)
 *
 * @param 标题 要在顶部应用栏中显示的标题。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 展开高度 该应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，此值代表其允许展开的最大高度。
 * 必须提供且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于该 TopAppBar 内容的内边距（padding）。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    TopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )

/**
 * [Material Design center-aligned small top appbar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * 这种小型顶部应用栏的标题在水平方向上居中对齐。
 *
 * ![Center-aligned top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/center-aligned-top-app-bar.png)
 *
 * 这种 CenterAlignedTopAppBar 提供标题、导航图标和操作按钮的插槽，且标题居中对齐。
 *
 * 一个居中对齐的顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 展开高度 该应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，此值代表其允许展开的最大高度。
 * 必须提供且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于该 TopAppBar 内容的内边距（padding）。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 居中顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    CenterAlignedTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )

/**
 * [Material Design small top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * 这种小型 TopAppBar 提供标题、副标题、导航图标和操作按钮的插槽。
 *
 * ![Small top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/small-top-app-bar.png)
 *
 * 一个顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。
 * @param 副标题 要在顶部应用栏中显示的副标题。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 标题水平对齐 标题与副标题的水平对齐方式。
 * @param 展开高度 该应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，此值代表其允许展开的最大高度。
 * 必须提供且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于该 TopAppBar 内容的内边距（padding）。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 顶部应用栏(
    标题: @Composable () -> Unit,
    副标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    TopAppBar(
        title = 标题,
        subtitle = 副标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        titleHorizontalAlignment = 标题水平对齐,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )

/**
 * [Material Design medium top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * ![Medium top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 这种 MediumTopAppBar 提供标题、导航图标和操作按钮的插槽。默认展开状态下，标题会显示在第二行，位于导航图标与操作按钮的下方。
 *
 * 一个中等高度的顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。该标题将在应用栏的展开与折叠状态下使用，不过在折叠状态时会以较小的 [TextStyle] 呈现。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 折叠高度 该应用栏在被提供的 [滚动行为] 折叠后的高度。此值必须指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 展开高度 该应用栏的最大高度。当指定的 [滚动行为] 导致其折叠或展开时，此值代表允许展开到的最高高度。该值必须 ≥ [折叠高度]，
 * 否则抛出 [IllegalArgumentException]；也必须为有限值，否则将被忽略并替换为 [TopAppBarDefaults.MediumAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [展开高度] 小于 [折叠高度]，则抛出异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 中等顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight,
    展开高度: Dp = TopAppBarDefaults.MediumAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    MediumTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        collapsedHeight = 折叠高度,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design medium flexible top appbar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * ![Medium top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 这个 `MediumFlexibleTopAppBar` 提供标题、副标题、导航图标和操作按钮的插槽。默认展开状态下，标题与副标题会显示在第二行，位于导航图标与操作按钮的下方。
 *
 * 一个“中等可折叠”顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。. 该标题将在应用栏的展开与折叠状态下使用，不过在折叠状态时会以较小的 [TextStyle] 呈现。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 副标题 可选的副标题，显示在顶部应用栏中。该副标题将在应用栏的展开与折叠状态下均可见。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 标题水平对齐 标题与副标题的水平对齐方式。
 * @param 折叠高度 该应用栏在被提供的 [滚动行为] 折叠后的高度。此值必须指定且为有限值，否则将被忽略并替换
 * 为 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 展开高度 该应用栏的最大高度。当指定的 [滚动行为] 导致其折叠或展开时，此值代表允许展开到的最高高度。
 * 该值必须 ≥ [折叠高度]，否则抛出 [IllegalArgumentException]；也必须为有限值，否则将被忽略并替换为
 * [TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight]（含副标题）或
 * [TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight]（不含副标题）。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [展开高度] 小于 [折叠高度]，则抛出异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 中等伸缩顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable () -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight,
    展开高度: Dp =
        if (副标题 != null) {
            TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight
        } else {
            TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight
        },
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    MediumFlexibleTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 动作,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 折叠高度,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design large top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * ![Large top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/large-top-app-bar.png)
 *
 * 这种 LargeTopAppBar 提供标题、导航图标和操作按钮的插槽。默认展开状态下，标题会显示在第二行，位于导航图标与操作按钮的下方。
 *
 * 一个大型顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。. 该标题将在应用栏的展开与折叠状态下使用，不过在折叠状态时会以较小的 [TextStyle] 呈现。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 折叠高度 该应用栏在被提供的 [滚动行为] 折叠后的高度。此值必须指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.LargeAppBarCollapsedHeight]。
 * @param 展开高度 该应用栏的最大高度。当指定的 [滚动行为] 导致其折叠或展开时，此值代表允许展开到的最高高度。该值必须 ≥ [折叠高度]，
 * 否则抛出 [IllegalArgumentException]；也必须为有限值，否则将被忽略并替换为[TopAppBarDefaults.LargeAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [展开高度] 小于 [折叠高度]，将抛出异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 大型顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight,
    展开高度: Dp = TopAppBarDefaults.LargeAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    LargeTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        collapsedHeight = 折叠高度,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design large flexible top appbar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * ![Large top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/large-top-app-bar.png)
 *
 * 这个 `LargeFlexibleTopAppBar` 提供标题、副标题、导航图标和操作按钮的插槽。默认展开状态下，标题与副标题会显示在第二行，位于导航图标与操作按钮的下方。
 *
 * 一个“大型可折叠”顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 要在顶部应用栏中显示的标题。. 该标题将在应用栏的展开与折叠状态下使用，不过在折叠状态时会以较小的 [TextStyle] 呈现。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 副标题 可选的副标题，显示在顶部应用栏中，在应用栏的展开与折叠状态下均会显示。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 标题水平对齐 标题与副标题的水平对齐方式。
 * @param 折叠高度 该应用栏在被提供的 [滚动行为] 折叠后的高度。此值必须指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.LargeAppBarCollapsedHeight]。
 * @param 展开高度 该应用栏的最大高度。当指定的 [滚动行为] 导致其折叠或展开时，此值代表允许展开到的最高高度。该值必须 ≥ [折叠高度]，
 * 否则抛出 [IllegalArgumentException]；也必须为有限值，否则将被忽略并替换为[TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight]
 * （含副标题）或[TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight]（不含副标题）。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [展开高度] 小于 [折叠高度]，将抛出异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 大型伸缩顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable () -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight,
    展开高度: Dp =
        if (副标题 != null) {
            TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight
        } else {
            TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight
        },
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    LargeFlexibleTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 动作,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 折叠高度,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
    )

/**
 * 一款基本的 Material Design 双行顶部应用栏。
 *
 * 顶部应用栏（Top app bars）在屏幕顶部展示信息与操作按钮。
 *
 * ![Two rows top app barimage](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 这款双行顶部应用栏提供标题、副标题、导航图标和操作按钮的插槽。默认展开状态下，展开的标题与副标题会显示在第二行，位于导航图标与操作按钮的下方。
 *
 * 默认情况下，双行顶部应用栏会为展开与折叠状态的标题应用 [MediumFlexibleTopAppBar] 的文本样式；你可以通过向对应的标题插槽传入自己的样式来覆盖默认值。
 *
 *一个“双行”顶部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * @param 标题 用于提供顶部应用栏在折叠与展开状态下所显示标题的 lambda。默认会对其应用小型应用栏的 [TextStyle]；你可以
 * 通过 CompositionLocal 包裹自定义组件来覆盖样式。注意：与 Large/Medium TopAppBar 不同，`TwoRowsTopAppBar` 默认
 * 不会给展开的标题 Composable 追加底部内边距；如需留白，请直接给传入的展开标题或其下方的 [副标题] 设置 padding。
 * @param 修饰符 应用于该顶部应用栏的 [Modifier]。
 * @param 副标题 一个 lambda，用于在顶部应用栏的折叠与展开状态下提供可选的副标题。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在顶部应用栏末尾的操作按钮，通常为 [IconButton]。默认使用 [Row] 布局，图标将水平排列。
 * @param 标题水平对齐 标题与副标题的水平对齐方式。
 * @param 折叠高度 应用栏折叠状态的高度。注意：为支持更大字号，该值可能会被自动调整。若传入 [Dp.Unspecified] 或 [Dp.Infinity]，
 * 则默认使用 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 展开高度 应用栏展开状态的总高度。当指定的 [滚动行为] 导致其折叠或展开时，此值代表允许展开到的最高高度，必须 ≥ [折叠高度]，
 * 否则抛出 [IllegalArgumentException]。为支持更大字号，该值可能会被自动调整。若传入 [Dp.Unspecified]或 [Dp.Infinity]，则：
 * 提供了 [expandedSubtitle] 时默认使用 [TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight]；
 * 未提供时默认使用 [TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 颜色 用于解析该顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它保存了该顶部应用栏用于设置高度和颜色所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使顶部应用栏的外观随内容滚动而变化。详见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [展开高度] 小于 [折叠高度]，将抛出异常。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 双行顶部应用栏(
    标题: @Composable (expanded: Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable (expanded: Boolean) -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    动作: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    折叠高度: Dp = Dp.Unspecified,
    展开高度: Dp = Dp.Unspecified,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) {
    TwoRowsTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 动作,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 折叠高度,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        colors = 颜色,
        scrollBehavior = 滚动行为,
    )
}

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏（Bottom app bar）在小屏幕底部显示导航与关键操作按钮。
 *
 * ![Bottom app barimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * 它可以选择在 BottomAppBar 的末端嵌入一个 [FloatingActionButton]。
 *
 * 另请参见 [NavigationBar]。
 *
 * @param 动作 BottomAppBar 的图标内容区域。默认使用 [Row] 布局，内部内容将水平排列。
 * @param 修饰符 应用于该 BottomAppBar 的 [Modifier]。
 * @param 悬浮操作按钮 可选的悬浮操作按钮，显示在该 BottomAppBar 的末端。
 * @param 容器颜色 该 BottomAppBar 背景所用的颜色；使用 [Color.Transparent] 可设为透明背景。
 * @param 内容颜色 该 BottomAppBar 内部内容的默认颜色。若 [容器颜色] 来自主题，则自动匹配对应的 content 颜色；
 * 否则使用当前 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的 primary 色。
 * 色调高度（tonal elevation）越大，在浅色主题下颜色越深，在深色主题下颜色越浅。参见 [Surface]。
 * @param 内容内边距 应用于该 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 底部应用栏(
    动作: @Composable RowScope.() -> Unit,
    修饰符: Modifier = Modifier,
    悬浮操作按钮: @Composable (() -> Unit)? = null,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
) =
    BottomAppBar(
        actions = 动作,
        modifier = 修饰符,
        floatingActionButton = 悬浮操作按钮,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏（Bottom app bar）在小屏幕底部显示导航与关键操作按钮。
 *
 * ![Bottom app barimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * 它可以选择在 BottomAppBar 的末端嵌入一个 [FloatingActionButton]。
 *
 *一个底部应用栏，它通过 [滚动行为] 与滚动内容协同工作，自定义其嵌套滚动行为，效果如下：
 *
 * 另请参见 [NavigationBar]。
 *
 * @param 动作 BottomAppBar 的图标内容区域。默认使用 [Row] 布局，内部内容将水平排列。
 * @param 修饰符 应用于该 BottomAppBar 的 [Modifier]。
 * @param 悬浮操作按钮 可选的悬浮操作按钮，显示在该 BottomAppBar 的末端。
 * @param 容器颜色 该 BottomAppBar 背景所用的颜色；使用 [Color.Transparent] 可设为透明背景。
 * @param 内容颜色 该 BottomAppBar 内部内容的默认颜色。若 [容器颜色] 来自主题，则自动匹配对应的 content 颜色；
 * 否则使用当前 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的 primary 色。
 * 色调高度（tonal elevation）越大，在浅色主题下颜色越深，在深色主题下颜色越浅。参见 [Surface]。
 * @param 内容内边距 应用于该 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它保存了该底部应用栏用于设置高度所需的各种偏移值。滚动行为旨在与可滚动内容协同工作，
 * 使底部应用栏的外观随内容滚动而变化。注意：当触摸探索服务（如 TalkBack）处于活动状态时，底部应用栏不会对滚动做出反应。
 * 详见 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 底部应用栏(
    动作: @Composable RowScope.() -> Unit,
    修饰符: Modifier = Modifier,
    悬浮操作按钮: @Composable (() -> Unit)? = null,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
) =
    BottomAppBar(
        actions = 动作,
        modifier = 修饰符,
        floatingActionButton = 悬浮操作按钮,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏（Bottom app bar）在小屏幕底部显示导航与关键操作按钮。
 *
 * ![Bottom app barimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * 如果你想显示 [FloatingActionButton]，请使用另一个重载版本。
 *
 * 另请参见 [NavigationBar]。
 *
 * @param 修饰符 应用于该 BottomAppBar 的 [Modifier]。
 * @param 容器颜色 该 BottomAppBar 背景所用的颜色；使用 [Color.Transparent] 可设为透明背景。
 * @param 内容颜色 该 BottomAppBar 内部内容的默认颜色。若 [容器颜色] 来自主题，则自动匹配对应的 content 颜色；
 * 否则使用当前 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的 primary 色。
 * 色调高度（tonal elevation）越大，在浅色主题下颜色越深，在深色主题下颜色越浅。参见 [Surface]。
 * @param 内容内边距 应用于该 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param content 该 BottomAppBar 的内容区域。默认使用 [Row] 布局，内部内容将水平排列。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    内容: @Composable RowScope.() -> Unit,
) =
    BottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        content = 内容,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏（Bottom app bar）在小屏幕底部显示导航与关键操作按钮。
 *
 * ![Bottom app barimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * 若想同时显示 [FloatingActionButton]，请使用另一个支持该参数的重载版本。
 *
 * 另请参见 [NavigationBar]。
 *
 * @param 修饰符 应用于该 BottomAppBar 的 [Modifier]。
 * @param 容器颜色 该 BottomAppBar 背景所用的颜色；使用 [Color.Transparent] 可设为透明背景。
 * @param 内容颜色 该 BottomAppBar 内部内容的默认颜色。若 [容器颜色] 来自主题，则自动匹配对应的 content 颜色；
 * 否则使用当前 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的 primary 色。
 * 色调高度（tonal elevation）越大，在浅色主题下颜色越深，在深色主题下颜色越浅。参见 [Surface]。
 * @param 内容内边距 应用于该 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它保存该 BottomAppBar 用来设定高度所需的各类偏移值。该滚动行为会与可滚动内容协同，
 * 使 BottomAppBar 随滚动改变外观。注意：当触摸探索服务（如 TalkBack）处于启用状态时，BottomAppBar 不会对滚动做出反应。
 * 详见 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容 此 BottomAppBar 的内容区域；默认采用 [Row] 布局，内部元素将水平排列。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    BottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
        content = 内容,
    )
}

// TODO 缺失的灵活底部应用栏图片。
/**
 * [Material Design flexible bottom appbar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 灵活底部应用栏在小屏幕底部显示导航与关键操作按钮，并可根据滚动行为动态调整高度或隐藏。
 *
 * 此版本的 底部应用栏 提供 [水平排列] 参数来控制内容的排列方式，并通过 [展开高度] 更灵活地控制栏的展开高度。
 *
 * 若想同时显示 [FloatingActionButton]，请使用另一个带有 [滚动行为] 参数的重载版本。
 *
 * 另请参见 [NavigationBar]。
 *
 * 一个指定了 [水平排列] 并使用 [滚动行为] 与滚动内容协同、自定义嵌套滚动行为的底部应用栏，效果如下：
 *
 * @param 修饰符 应用于该 底部应用栏 的 [Modifier]。
 * @param 容器颜色 该 底部应用栏 背景所用的颜色；使用 [Color.Transparent] 可设为透明背景。
 * @param 内容颜色 该 底部应用栏 内部内容的默认颜色。若 [容器颜色] 来自主题，则自动匹配对应的 content 颜色；否则使用当前 [LocalContentColor]。
 * @param 内容内边距 应用于该 底部应用栏 内容的内边距。
 * @param 水平排列 该 底部应用栏 内部内容的水平排列方式。
 * @param 展开高度 该底部栏完全展开时可达到的最大高度。若提供了 [滚动行为]，栏会根据滚动折叠或展开，此值即为展开时的上限；
 * 该 [Dp] 必须指定、有限且大于 0，否则默认使用 [BottomAppBarDefaults.FlexibleBottomAppBarHeight]；若 [滚动行为] 为 `null`，此值即为底部栏的固定高度。
 * @param 窗口插入 应用栏将遵循的窗口内边距（window insets）。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它保存该 底部应用栏 用来设定高度所需的各类偏移值。该滚动行为会与可滚动内容协同，
 * 使 底部应用栏 随滚动改变外观。注意：当触摸探索服务（如 TalkBack）处于启用状态时，底部应用栏 不会对滚动做出反应。
 * 详见 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容 此 底部应用栏 的内容区域；默认采用 [Row] 布局，内部元素将水平排列。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 伸缩底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    内容内边距: PaddingValues = BottomAppBarDefaults.FlexibleContentPadding,
    水平排列: Arrangement.Horizontal = BottomAppBarDefaults.FlexibleHorizontalArrangement,
    展开高度: Dp = BottomAppBarDefaults.FlexibleBottomAppBarHeight,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    FlexibleBottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        contentPadding = 内容内边距,
        horizontalArrangement = 水平排列,
        expandedHeight = 展开高度,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
        content = 内容,
    )
}


/** 包含顶部应用栏各实现所用的默认值。 */
object 顶部应用栏默认值 {  // TopAppBarDefaults

    /**
     * 为小型 [TopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在提供的颜色之间进行动画过渡。
     */
    @Composable
    fun 顶部应用栏颜色() = TopAppBarDefaults.topAppBarColors()

    /**
     * 为小型 [TopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 容器颜色。
     * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
     * @param 导航图标内容颜色 用于导航图标的内容颜色。
     * @param 标题内容颜色 用于标题的内容颜色。
     * @param 动作图标内容颜色 用于操作按钮的内容颜色。
     * @param subtitleContentColor 用于副标题的内容颜色。
     * @return 最终用于顶部应用栏的 [TopAppBarColors]。
     */
    @Composable
    fun 顶部应用栏颜色(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        动作图标内容颜色: Color = Color.Unspecified,
        副标题内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.topAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 动作图标内容颜色,
            subtitleContentColor = 副标题内容颜色,
        )

    /** [TopAppBar] 内容使用的默认内边距。 */
    val 内容内边距 = TopAppBarDefaults.ContentPadding

    /** 顶部应用栏默认使用并消耗的窗口内边距（insets）。 */
    val 窗口插入: WindowInsets
        @Composable get() = TopAppBarDefaults.windowInsets

    /**
     * 为 [CenterAlignedTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在提供的颜色之间进行动画过渡。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 居中对齐顶部应用栏颜色() = TopAppBarDefaults.centerAlignedTopAppBarColors()

    /**
     * 为 [CenterAlignedTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 容器颜色。
     * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
     * @param 导航图标内容颜色 用于导航图标的内容颜色。
     * @param 标题内容颜色 用于标题的内容颜色。
     * @param 动作图标内容颜色 用于操作按钮的内容颜色。
     * @return 最终用于顶部应用栏的 [TopAppBarColors]。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 居中对齐顶部应用栏颜色(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        动作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 动作图标内容颜色,
        )

    /**
     * 为 [MediumTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在应用栏滚动过程中对提供的颜色进行插值过渡。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 中等顶部应用栏颜色() = TopAppBarDefaults.mediumTopAppBarColors()

    /**
     * 为 [MediumTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在应用栏滚动过程中对提供的颜色进行插值过渡。
     *
     * @param 容器颜色 容器颜色。
     * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
     * @param 导航图标内容颜色 用于导航图标的内容颜色。
     * @param 标题内容颜色 用于标题的内容颜色。
     * @param 动作图标内容颜色 用于操作按钮的内容颜色。
     * @return 最终用于顶部应用栏的 [TopAppBarColors]。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 中等顶部应用栏颜色(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        动作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 动作图标内容颜色,
        )

    /**
     * 为 [LargeTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在应用栏滚动过程中对提供的颜色进行插值过渡。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 大型顶部应用栏颜色() = TopAppBarDefaults.largeTopAppBarColors()

    /**
     * 为 [LargeTopAppBar] 创建一个 [TopAppBarColors]。默认实现会依据 Material Design 规范，在应用栏滚动过程中对提供的颜色进行插值过渡。
     *
     * @param 容器颜色 容器颜色。
     * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
     * @param 导航图标内容颜色 用于导航图标的内容颜色。
     * @param 标题内容颜色 用于标题的内容颜色。
     * @param 动作图标内容颜色 用于操作按钮的内容颜色。
     * @return 最终用于顶部应用栏的 [TopAppBarColors]。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 大型顶部应用栏颜色(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        动作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.largeTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 动作图标内容颜色,
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，它会跟踪嵌套滚动回调并相应地更新其 [TopAppBarState.contentOffset]。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组之间被记住（remembered）。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需在重组间被记住的状态，请参见 [rememberTopAppBarState]。
     * @param 可以滚动 用于决定滚动事件是否由此固定（pinned）[TopAppBarScrollBehavior] 处理的回调。
     */
    @ExperimentalMaterial3Api
    @Composable
    fun 固定滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(state = 状态, canScroll = 可以滚动)

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置此行为的顶部应用栏将在内容上拉时立即折叠，下拉时立即重新出现。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组之间被记住（remembered）。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需在重组间被记住的状态，请参见 [rememberTopAppBarState]。
     * @param 可以滚动 用于决定滚动事件是否由此 [EnterAlwaysScrollBehavior] 处理的回调。
     * @param 捕捉动画规格 可选的 [AnimationSpec]，定义当顶部应用栏被快速滑动或拖动到中间位置后，如何动画吸附至完全折叠或完全展开状态。
     * @param 抛掷动画规格 可选的 [DecayAnimationSpec]，定义当用户对顶部应用栏本身或其下方内容进行快速滑动（fling）时，应用栏的惯性飞滚动画行为。
     * @param 反向布局 表示此行为应用于滚动和布局方向相反的滚动内容（即 reverse 方向）。
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    @ExperimentalMaterial3Api
    @Composable
    fun 始终进入滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        // TODO 从组件令牌文件中加载 motionScheme 令牌。
        捕捉动画规格: AnimationSpec<Float>? = MaterialTheme.motionScheme.defaultEffectsSpec(),
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
        反向布局: Boolean = false,
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 捕捉动画规格,
            flingAnimationSpec = 抛掷动画规格,
            reverseLayout = 反向布局
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]，它会调整自身属性以影响顶部应用栏的颜色和高度。
     *
     * 配置此 [TopAppBarScrollBehavior] 的顶部应用栏，将在嵌套内容上拉时立即折叠，并在内容完全下拉时重新展开已折叠区域。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组之间被记住（remembered）。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需在重组间被记住的状态，请参见 [rememberTopAppBarState]。
     * @param 可以滚动 用于决定滚动事件是否由此 [ExitUntilCollapsedScrollBehavior] 处理的回调。
     * @param 捕捉动画规格 可选的 [AnimationSpec]，定义当顶部应用栏被快速滑动或拖动到中间位置后，如何动画吸附至完全折叠或完全展开状态。
     * @param 抛掷动画规格 可选的 [DecayAnimationSpec]，定义当用户对顶部应用栏本身或其下方内容进行快速滑动（fling）时，应用栏的惯性飞滚动画行为。
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    @ExperimentalMaterial3Api
    @Composable
    fun 退出直至折叠滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        // TODO Load the motionScheme tokens from the component tokens file
        捕捉动画规格: AnimationSpec<Float>? = MaterialTheme.motionScheme.defaultEffectsSpec(),
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 捕捉动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /** [TopAppBar] 与 [CenterAlignedTopAppBar] 的默认展开高度。 */
    val 顶部应用栏展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight

    /** [MediumTopAppBar] 被 [TopAppBarScrollBehavior] 折叠后的默认高度。 */
    val 中等应用栏折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight

    /** [MediumTopAppBar] 的默认展开高度。 */
    val 中等应用栏展开高度: Dp = TopAppBarDefaults.MediumAppBarExpandedHeight

    /** 不带副标题的 [MediumFlexibleTopAppBar] 的默认展开高度。 */
    val 中等伸缩应用栏无副标题展开高度: Dp =
        TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight

    /** 带副标题的 [MediumFlexibleTopAppBar] 的默认展开高度。 */
    val 中等伸缩应用栏带副标题展开高度: Dp =
        TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight

    /** [LargeTopAppBar] 被 [TopAppBarScrollBehavior] 折叠后的默认高度。 */
    val 大型应用栏折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight

    /** [LargeTopAppBar] 的默认展开高度。 */
    val 大型应用栏展开高度: Dp = TopAppBarDefaults.LargeAppBarExpandedHeight

    /** 不带副标题的 [LargeFlexibleTopAppBar] 的默认展开高度。 */
    val 大型伸缩应用栏无副标题展开高度: Dp =
        TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight

    /** 带副标题的 [LargeFlexibleTopAppBar] 的默认展开高度。 */
    val 大型伸缩应用栏带副标题展开高度: Dp =
        TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight
}

/**
 * 创建一个在重组之间被记住（remember）的 [TopAppBarState]。
 *
 * @param 初始高度偏移限制 [TopAppBarState.heightOffsetLimit] 的初始值，表示当可滚动内容滚动时，顶部应用栏被允许折叠的像素上限。
 * @param 初始高度偏移 [TopAppBarState.heightOffset] 的初始值，应在 0 与 [初始高度偏移限制] 之间。
 * @param 初始内容偏移 [TopAppBarState.contentOffset] 的初始值。
 */
@Composable
fun 记住顶部应用栏状态(
    初始高度偏移限制: Float = -Float.MAX_VALUE,
    初始高度偏移: Float = 0f,
    初始内容偏移: Float = 0f,
): TopAppBarState = rememberTopAppBarState(
    initialHeightOffsetLimit = 初始高度偏移限制,
    initialHeightOffset = 初始高度偏移,
    initialContentOffset = 初始内容偏移
)

/**
 * 表示顶部应用栏在不同状态下所使用的颜色。该实现会根据应用栏的滚动状态对容器颜色进行动画过渡，而导航图标、标题与操作按钮的颜色不做动画。
 *
 * @param 容器颜色 该 TopAppBar 背景所用的颜色；使用 [Color.Transparent] 可设为透明。
 * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
 * @param 导航图标内容颜色 用于导航图标的内容颜色。
 * @param 标题内容颜色 用于标题的内容颜色。
 * @param 动作图标内容颜色 用于操作按钮的内容颜色。
 * @param 副标题内容颜色 用于副标题的内容颜色。
 * @constructor 如需创建自定义颜色的实例，请使用 [TopAppBarColors] 的工厂方法，该方法遵循默认 Material 3 规范。
 */
@Stable
class 顶部应用栏颜色( // TopAppBarColors
    val 容器颜色: Color,
    val 滚动容器颜色: Color,
    val 导航图标内容颜色: Color,
    val 标题内容颜色: Color,
    val 动作图标内容颜色: Color,
    val 副标题内容颜色: Color,
) {
    @Deprecated(
        "Use the TopAppBarColors constructor with subtitleContentColor",
        replaceWith =
            ReplaceWith(
                "TopAppBarColors(containerColor, scrolledContainerColor," +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor, " +
                        "subtitleContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    constructor(
        容器颜色: Color,
        滚动容器颜色: Color,
        导航图标内容颜色: Color,
        标题内容颜色: Color,
        动作图标内容颜色: Color,
    ) : this(
        容器颜色 = 容器颜色,
        滚动容器颜色 = 滚动容器颜色,
        导航图标内容颜色 = 导航图标内容颜色,
        标题内容颜色 = 标题内容颜色,
        动作图标内容颜色 = 动作图标内容颜色,
        副标题内容颜色 = 标题内容颜色,
    )

    /**
     * 返回此 TopAppBarColors 的一个副本，可选择性地覆盖部分颜色值；使用 `Color.Unspecified` 表示“保留原值”。
     */
    fun 复制(
        容器颜色: Color = this.容器颜色,
        滚动容器颜色: Color = this.滚动容器颜色,
        导航图标内容颜色: Color = this.导航图标内容颜色,
        标题内容颜色: Color = this.标题内容颜色,
        动作图标内容颜色: Color = this.动作图标内容颜色,
        副标题内容颜色: Color = this.副标题内容颜色,
    ) =
        TopAppBarColors(
            容器颜色.takeOrElse { this.容器颜色 },
            滚动容器颜色.takeOrElse { this.滚动容器颜色 },
            导航图标内容颜色.takeOrElse { this.导航图标内容颜色 },
            标题内容颜色.takeOrElse { this.标题内容颜色 },
            动作图标内容颜色.takeOrElse { this.动作图标内容颜色 },
            副标题内容颜色.takeOrElse { this.副标题内容颜色 },
        )

    /**
     * Represents 容器颜色。 用于顶部应用栏。
     *
     * [colorTransitionFraction] 提供一个 0–1 的百分比值，用于生成过渡颜色。通常，应用栏实现会传入从 [TopAppBarState.collapsedFraction]
     * 或 [TopAppBarState.overlappedFraction] 读取的百分比。
     *
     * @param colorTransitionFraction 一个 `0.0` 到 `1.0` 的数值，表示颜色过渡的百分比。
     */
    @Stable
    internal fun containerColor(colorTransitionFraction: Float): Color {
        return lerp(
            容器颜色, 滚动容器颜色,
            FastOutLinearInEasing.transform(colorTransitionFraction),
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is TopAppBarColors) return false

        if (容器颜色 != other.containerColor) return false
        if (滚动容器颜色 != other.scrolledContainerColor) return false
        if (导航图标内容颜色 != other.navigationIconContentColor) return false
        if (标题内容颜色 != other.titleContentColor) return false
        if (动作图标内容颜色 != other.actionIconContentColor) return false
        if (副标题内容颜色 != other.subtitleContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 滚动容器颜色.hashCode()
        result = 31 * result + 导航图标内容颜色.hashCode()
        result = 31 * result + 标题内容颜色.hashCode()
        result = 31 * result + 动作图标内容颜色.hashCode()
        result = 31 * result + 副标题内容颜色.hashCode()

        return result
    }
}



/** 包含底部应用栏各实现所用的默认值。 */
object 底部应用栏默认值 { //BottomAppBarDefaults

    /** [BottomAppBar] 容器的默认颜色。 */
    val 容器颜色: Color
        @Composable get() = BottomAppBarDefaults.containerColor

    /** [BottomAppBar] 的默认高度（elevation）。 */
    val 容器阴影: Dp = BottomAppBarDefaults.ContainerElevation

    /**
     * 当 [BottomAppBar] 内的内容为默认尺寸（24 dp）且置于满足最小触摸目标（48 dp）的 [IconButton] 中时，所使用的默认内边距。
     */
    val 内容内边距 = BottomAppBarDefaults.ContentPadding

    /** [BottomAppBar] 默认使用并消耗的窗口内边距（insets）。 */
    val 窗口插入: WindowInsets
        @Composable get() = BottomAppBarDefaults.windowInsets

    /** [BottomAppBar] 中 [FloatingActionButton] 的颜色 */
    val 底部应用栏浮动按钮颜色: Color
        @Composable get() = BottomAppBarDefaults.bottomAppBarFabColor

    /** [FlexibleBottomAppBar] 使用的默认内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 伸缩内容内边距 = BottomAppBarDefaults.FlexibleContentPadding

    /**
     * 灵活底部应用栏 [FlexibleBottomAppBar] 的默认高度。此高度表示底部应用栏在展开状态下的高度。
     */
    @ExperimentalMaterial3ExpressiveApi
    val 伸缩底部应用栏高度 = BottomAppBarDefaults.FlexibleBottomAppBarHeight

    /** 用于分配 [FlexibleBottomAppBar] 内容间距的默认 [Arrangement]。 */
    @ExperimentalMaterial3ExpressiveApi
    val 伸缩水平排列: Arrangement.Horizontal = BottomAppBarDefaults.FlexibleHorizontalArrangement

    /**
     * 用于以固定间距排列 [FlexibleBottomAppBar] 内容的 [Arrangement]。
     */
    @ExperimentalMaterial3ExpressiveApi
    val 伸缩固定水平排列: Arrangement.Horizontal = BottomAppBarDefaults.FlexibleFixedHorizontalArrangement

    // TODO: 请注意，此滚动行为可能会影响辅助技术，导致该组件无法访问。 请参阅示例 `androidx.compose.material3.samples.ExitAlwaysBottomAppBar`，
    //  了解如何在开启触摸探索时禁用滚动。
    /**
     * 返回一个 [BottomAppBarScrollBehavior]。配置了此 [BottomAppBarScrollBehavior] 的底部应用栏会在内容向上滚动时立即收起，
     * 并在内容向下滚动时立即重新显示。
     *
     * 返回的 [BottomAppBarScrollBehavior] 会在多次重组之间被记住（即保持不变）。
     *
     * @param 状态 用于控制或观察底部应用栏滚动状态的状态对象。如需在多次重组间保持不变的状态，请使用 [rememberBottomAppBarState]。
     * @param 可以滚动 用于决定滚动事件是否由该 [ExitAlwaysScrollBehavior] 处理的回调函数。
     * @param 捕捉动画规格 可选的 [AnimationSpec]，用于定义当底部应用栏在快速滑动或拖拽后停在中间状态时，如何动画过渡到完全收起或完全展开的状态。
     * @param 抛掷动画规格 可选的 [DecayAnimationSpec]，用于定义当用户快速滑动底部应用栏本身或其下方内容时，应用栏的惯性飞掷（fling）动画行为。
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    @ExperimentalMaterial3Api
    @Composable
    fun 退出始终滚动行为(
        状态: BottomAppBarState = rememberBottomAppBarState(),
        可以滚动: () -> Boolean = { true },
        // TODO 从组件令牌文件中加载 motionScheme 令牌。
        捕捉动画规格: AnimationSpec<Float>? = MaterialTheme.motionScheme.fastSpatialSpec() ,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): BottomAppBarScrollBehavior =
        BottomAppBarDefaults.exitAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 捕捉动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )
}

/**
 * 创建一个在重组之间保持记忆的 [BottomAppBarState]。
 *
 * @param 初始高度偏移限制 [BottomAppBarState.heightOffsetLimit] 的初始值，表示当可滚动内容发生滚动时，底部应用栏允许收起的像素上限。
 * @param 初始高度偏移 [BottomAppBarState.heightOffset] 的初始值。该初始高度偏移量应在 0 与 [初始高度偏移限制] 之间。
 * @param 初始内容偏移 [BottomAppBarState.contentOffset] 的初始值。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住底部应用栏状态(
    初始高度偏移限制: Float = -Float.MAX_VALUE,
    初始高度偏移: Float = 0f,
    初始内容偏移: Float = 0f,
): BottomAppBarState =
    rememberBottomAppBarState(
        initialHeightOffsetLimit = 初始高度偏移限制,
        initialHeightOffset = 初始高度偏移,
        initialContentOffset = 初始内容偏移,
    )

/**
 * 创建一个 [BottomAppBarState]。
 *
 * @param 初始高度偏移限制 [BottomAppBarState.heightOffsetLimit] 的初始值，表示当可滚动内容发生滚动时，
 * 底部应用栏允许收起的最大像素高度限制。
 * @param 初始高度偏移 [BottomAppBarState.heightOffset] 的初始值。该初始高度偏移量必须在 0 与 [初始高度偏移限制] 之间。
 * @param 初始内容偏移 [BottomAppBarState.contentOffset] 的初始值。
 */
@ExperimentalMaterial3Api
fun 底部应用栏状态(
    初始高度偏移限制: Float,
    初始高度偏移: Float,
    初始内容偏移: Float,
): BottomAppBarState =
    BottomAppBarState(
        initialHeightOffsetLimit = 初始高度偏移限制,
        initialHeightOffset = 初始高度偏移,
        initialContentOffset = 初始内容偏移
    )


/** 包含当前选中的 [SingleRowTopAppBarOverride] 的 CompositionLocal。 */
@Suppress("CompositionLocalNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ComponentOverrideApi
val 本地单行顶部应用栏重写: ProvidableCompositionLocal<SingleRowTopAppBarOverride> =
    LocalSingleRowTopAppBarOverride

/** 包含当前选中的 [TwoRowsTopAppBarOverride] 的 CompositionLocal。 */
@Suppress("CompositionLocalNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ComponentOverrideApi
val 本地双行顶部应用栏重写: ProvidableCompositionLocal<TwoRowsTopAppBarOverride> =
    LocalTwoRowsTopAppBarOverride

