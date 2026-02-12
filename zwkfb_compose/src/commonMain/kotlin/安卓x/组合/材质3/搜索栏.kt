package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.AppBarWithSearch
import androidx.compose.material3.AppBarWithSearchColors
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExpandedDockedSearchBar
import androidx.compose.material3.ExpandedDockedSearchBarWithGap
import androidx.compose.material3.ExpandedFullScreenContainedSearchBar
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarScrollBehavior
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopSearchBar
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.annotation.FrequentlyChangingValue
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.PopupProperties

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏是一个允许用户输入关键词或短语并获取相关信息的字段，可通过搜索查询在应用内进行导航。
 *
 * ![Search barimage](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [SearchBar] 组件表示处于折叠状态的搜索栏。应与 [ExpandedFullScreenSearchBar] 或 [ExpandedDockedSearchBar] 配合使用，以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及展开后的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于折叠状态下搜索栏的 [Modifier]。
 * @param 形状 搜索栏在折叠状态下的形状。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 */
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition","ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
) {
    SearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
    )
}

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏是一个允许用户输入关键词或短语并获取相关信息的字段，可通过搜索查询在应用内进行导航。
 *
 * ![Search barimage](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * TopSearchBar 是 SearchBar 的扩展版本，额外处理了顶部应用栏行为，如窗口边距和滚动。将 TopSearchBar 用作 Scaffold 的 topBar 可确保搜索栏始终固定在屏幕顶部。
 * 与 SearchBar 一样，TopSearchBar 也需配合 ExpandedFullScreenSearchBar 或 ExpandedDockedSearchBar 使用，以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及展开后的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于折叠状态下搜索栏的 [Modifier]。
 * @param 形状 搜索栏在折叠状态下的形状。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 窗口插入 搜索栏在折叠状态下应遵守的窗口边距。
 * @param 滚动行为 [SearchBarScrollBehavior]，用于与滚动内容配合，在滚动过程中改变搜索栏外观。若为 null，搜索栏不会自动响应滚动。
 */
@Deprecated(
    message = "Renamed to `AppBarWithSearch`",
    replaceWith =
        ReplaceWith(
            "AppBarWithSearch(state, inputField, modifier, navigationIcon, actions, shape, " +
                    "colors, tonalElevation, windowInsets, scrollBehavior)"
        ),
)
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition","ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 顶部搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    滚动行为: SearchBarScrollBehavior? = null,
) {
    TopSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )
}

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏是一个允许用户输入关键词或短语并获取相关信息的字段，可通过搜索查询在应用内进行导航。
 *
 * ![Search barimage](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * AppBarWithSearch 是 SearchBar 的扩展版本，额外处理了顶部应用栏行为，如窗口边距和滚动。将 AppBarWithSearch 用作 Scaffold 的 topBar
 * 可确保搜索栏始终固定在屏幕顶部。与 SearchBar 一样，AppBarWithSearch 也需配合 ExpandedFullScreenSearchBar 或 ExpandedDockedSearchBar 使用，
 * 以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及展开后的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于折叠状态下搜索栏的 [Modifier]。
 * @param 导航图标 显示在搜索栏之前、应用栏起始位置的图标，通常为 [IconButton] 或 [IconToggleButton]。
 * @param 动作 显示在搜索栏之后、应用栏末尾的图标，通常为 [IconButton]。默认使用 [Row] 布局，因此图标会水平排列。
 * @param 形状 搜索栏在折叠状态下的形状。
 * @param 颜色 [SearchBarColors] 用于解析该搜索栏颜色的默认值，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 内容内边距 容器与内容之间在内部使用的间距值。
 * @param 窗口插入 搜索栏在折叠状态下应遵守的窗口边距。
 * @param 滚动行为 [SearchBarScrollBehavior]，用于与滚动内容配合，在滚动过程中改变搜索栏外观。若为 null，搜索栏不会自动响应滚动。
 */
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition","ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 应用栏带搜索(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable (() -> Unit)? = null,
    动作: @Composable (RowScope.() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: AppBarWithSearchColors = SearchBarDefaults.appBarWithSearchColors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    内容内边距: PaddingValues = SearchBarDefaults.AppBarContentPadding,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    滚动行为: SearchBarScrollBehavior? = null,
) {
    AppBarWithSearch(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 动作,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )
}

/**
 * [ExpandedFullScreenContainedSearchBar] 表示正处于展开或已展开状态的搜索栏，用于显示搜索结果。它保留 [inputField]
 * 的折叠形状且不带分割线，并以全新的全屏对话框形式呈现。若不希望使用这种全屏展开行为（例如在平板等中大屏幕上），可改用 [ExpandedDockedSearchBar]。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及折叠状态的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于该展开搜索栏的 [Modifier]。
 * @param 折叠形状 搜索栏折叠时的形状；完全展开后形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.containedColors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 窗口插入 该搜索栏在展开时所遵循的窗口边距。
 * @param 属性 用于配置对话框行为的平台相关属性。任何限制对话框尺寸的属性（如 [DialogProperties.usePlatformDefaultWidth]）都会被忽略。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 展开全屏内置搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    折叠形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.containedColors(state = 状态),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: @Composable () -> WindowInsets = { SearchBarDefaults.fullScreenWindowInsets },
    属性: DialogProperties = DialogProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) {
    ExpandedFullScreenContainedSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        collapsedShape = 折叠形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        properties = 属性,
        content = 内容,
    )
}

/**
 * [ExpandedFullScreenSearchBar] 表示正处于展开或已展开状态的搜索栏，用于显示搜索结果。该组件将以全新的全屏对话框形式呈现。
 * 若不希望使用这种全屏展开行为（例如在平板等中大屏幕上），可改用 [ExpandedDockedSearchBar]。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及折叠状态的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于该展开搜索栏的 [Modifier]。
 * @param 折叠形状 搜索栏折叠时的形状；完全展开后形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 窗口插入 该搜索栏在展开时所遵循的窗口边距。
 * @param 属性 用于配置对话框行为的平台相关属性。任何限制对话框尺寸的属性（如 [DialogProperties.usePlatformDefaultWidth]）都会被忽略。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 展开全屏搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    折叠形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: @Composable () -> WindowInsets = { SearchBarDefaults.fullScreenWindowInsets },
    属性: DialogProperties = DialogProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) {
    ExpandedFullScreenSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        collapsedShape = 折叠形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        properties = 属性,
        content = 内容,
    )
}

/**
 * [ExpandedDockedSearchBarWithGap] 表示正处于展开或已展开状态的搜索栏，用于显示搜索结果。该组件以弹出框形式出现在折叠搜索栏**下方并留有空隙**。
 * 推荐在平板等中大屏设备上使用 [ExpandedDockedSearchBarWithGap]，而在手机等紧凑屏幕上改用 [ExpandedFullScreenSearchBar]。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及折叠状态的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于该展开搜索栏的 [Modifier]。
 * @param 下拉形状 下拉搜索结果容器的形状。
 * @param 下拉间隙大小 搜索结果下拉框与搜索栏之间的间隙大小。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 属性 用于配置对话框行为的平台相关属性。任何限制对话框尺寸的属性（如 [DialogProperties.usePlatformDefaultWidth]）都会被忽略。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 扩展停靠搜索栏带间隙(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    下拉形状: Shape = SearchBarDefaults.dockedDropdownShape,
    下拉间隙大小: Dp = SearchBarDefaults.dockedDropdownGapSize,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    属性: PopupProperties = PopupProperties(focusable = true, clippingEnabled = false),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedDockedSearchBarWithGap(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        dropdownShape = 下拉形状,
        dropdownGapSize = 下拉间隙大小,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        properties = 属性,
        content = 内容,
    )

/**
 * [ExpandedDockedSearchBar] 表示正处于展开或已展开状态的搜索栏，用于显示搜索结果。该组件以弹出框形式**覆盖在折叠搜索栏上方**。
 * 推荐在平板等中大屏设备上使用 [ExpandedDockedSearchBar]，而在手机等紧凑屏幕上改用 [ExpandedDockedSearchBar]。
 *
 * @param 状态 搜索栏的状态。该状态也应同时传给 [输入字段] 以及折叠状态的搜索栏。
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于该展开搜索栏的 [Modifier]。
 * @param 形状 包裹 [输入字段] 与 [内容] 的容器形状。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 属性 用于配置对话框行为的平台相关属性。任何限制对话框尺寸的属性（如 [DialogProperties.usePlatformDefaultWidth]）都会被忽略。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 展开停靠搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    属性: PopupProperties = PopupProperties(focusable = true, clippingEnabled = false),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedDockedSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        properties = 属性,
        content = 内容,
    )



/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏是一种悬浮的搜索输入框，允许用户输入关键词或短语并获取相关信息，可通过搜索查询在应用内进行导航。
 *
 * 搜索栏可展开为搜索“视图”，用于显示动态建议或搜索结果。
 *
 * ![Search barimage](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [SearchBar] 在展开时会尽可能占满其所允许的全部空间。若要符合 Material 指南规定的全屏行为，其父布局**不得传递任何限制其尺寸的 [Constraints]**，
 * 且宿主 Activity 应调用`WindowCompat.setDecorFitsSystemWindows(window, false)`。
 *
 * 若不希望出现这种全屏展开行为（例如在大型平板屏幕上），可改用 [DockedSearchBar]。
 *
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 扩展 该搜索栏是否处于展开状态并正在显示搜索结果。
 * @param 扩展改变回调 当该搜索栏的展开状态发生变化时将调用的回调。
 * @param 修饰符 应用于该搜索栏的 [Modifier]。
 * @param 形状 搜索栏在**未展开**时的形状；一旦**展开**，形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 该搜索栏下方阴影的 elevation 值。
 * @param 窗口插入 该搜索栏所遵循的窗口边距。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    输入字段: @Composable () -> Unit,
    扩展: Boolean,
    扩展改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) {
    SearchBar(
        inputField = 输入字段,
        expanded = 扩展,
        onExpandedChange = 扩展改变回调,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )
}

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏是一种悬浮的搜索输入框，允许用户输入关键词或短语并获取相关信息，可通过搜索查询在应用内进行导航。
 *
 * 搜索栏可展开为搜索“视图”，用于显示动态建议或搜索结果。
 *
 * ![Search barimage](https://developer.android.com/images/reference/androidx/compose/material3/docked-search-bar.png)
 *
 * [DockedSearchBar] 在输入框下方以**有界列表**形式展示搜索结果。当在大屏设备（如平板）上不希望展开到全屏时，可作为 [SearchBar] 的替代方案。
 *
 * @param 输入字段 该搜索栏的输入框，用于输入查询，通常为 [SearchBarDefaults.InputField]。
 * @param 扩展 该搜索栏是否处于展开状态并正在显示搜索结果。
 * @param 扩展改变回调 当该搜索栏的展开状态发生变化时将调用的回调。
 * @param 修饰符 应用于该搜索栏的 [Modifier]。
 * @param 形状 该搜索栏的形状。
 * @param 颜色 用于在不同状态下解析该搜索栏颜色的 [SearchBarColors]，参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 提高色调高度（tonal elevation）会在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 视觉阴影 搜索栏下方阴影的 elevation 值。
 * @param 内容 该搜索栏的内容，用于在 [输入字段] 下方展示搜索结果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3Api
@Composable
fun 停靠搜索栏(
    输入字段: @Composable () -> Unit,
    扩展: Boolean,
    扩展改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DockedSearchBar(
        inputField = 输入字段,
        expanded = 扩展,
        onExpandedChange = 扩展改变回调,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        content = 内容,
    )
}



/** [SearchBarState] 的可能取值 */
@ExperimentalMaterial3Api
object 搜索栏值 {
    /** 搜索栏处于折叠状态时的值。 */
    val 已折叠 = SearchBarValue.Collapsed

    /** 搜索栏处于展开状态时的值。 */
    val 已展开 = SearchBarValue.Expanded
}


/** 搜索栏的状态。 */
@ExperimentalMaterial3Api
@Stable
class 搜索栏状态 // SearchBarState
private constructor(
    private val 可动画: Animatable<Float, AnimationVector1D>,
    private val 动画展开规格: AnimationSpec<Float>,
    private val 动画折叠规格: AnimationSpec<Float>,
) {
    /**
     * 构建一个 [SearchBarState]。
     *
     * @param 初始值 搜索栏初始处于折叠还是展开的布尔值。
     * @param 动画展开规格 搜索栏展开时使用的动画规格。
     * @param 动画折叠规格 搜索栏折叠时使用的动画规格。
     */
    constructor(
        初始值: SearchBarValue,
        动画展开规格: AnimationSpec<Float>,
        动画折叠规格: AnimationSpec<Float>,
    ) : this(
        可动画 = Animatable(if (初始值 == SearchBarValue.Expanded) Expanded else Collapsed),
        动画展开规格 = 动画展开规格,
        动画折叠规格 = 动画折叠规格,
    )

    /**
     * 搜索栏折叠时的布局坐标（若有），用于协调展开动画。
     */
    var 折叠坐标: LayoutCoordinates? by mutableStateOf(null)

    /**
     * 搜索栏的动画进度，其中 0 表示 [SearchBarValue.Collapsed]，1 表示 [SearchBarValue.Expanded]。
     */
    @get:FloatRange(from = 0.0, to = 1.0)
    val 进度: Float
        get() = 可动画.value.coerceIn(0f, 1f)

    /** Whether the state is currently animating */
    val 是否动画中: Boolean
        get() = 可动画.isRunning

    /** 搜索栏即将展开还是折叠。 */
    val 目标值: SearchBarValue
        get() =
            if (可动画.targetValue == Expanded) {
                SearchBarValue.Expanded
            } else {
                SearchBarValue.Collapsed
            }

    /**
     * 搜索栏当前处于展开还是折叠状态。若搜索栏正在展开/折叠动画中，则 [当前值] 始终为 [SearchBarValue.Expanded]，直到动画结束。
     */
    val 当前值: SearchBarValue by derivedStateOf {
        if (可动画.value == Collapsed) {
            SearchBarValue.Collapsed
        } else {
            SearchBarValue.Expanded
        }
    }

    /** 将搜索栏动画展开至展开状态。 */
    suspend fun 动画至展开() {
        可动画.animateTo(targetValue = Expanded, animationSpec = 动画展开规格)
    }

    /** 将搜索栏动画折叠至折叠状态。 */
    suspend fun 动画至折叠() {
        可动画.animateTo(targetValue = Collapsed, animationSpec = 动画折叠规格)
    }

    /**
     * 将搜索栏进度瞬间置为给定比例，其中 0 对应 [SearchBarValue.Collapsed]，1 对应 [SearchBarValue.Expanded]。
     */
    suspend fun 捕捉到(fraction: Float) {
        可动画.snapTo(fraction)
    }

    companion object {
        private const val Collapsed = 0f
        private const val Expanded = 1f

        /** SearchBarState 的默认 [Saver] 实现，用于状态保存与恢复。 */
        fun Saver(
            动画展开规格: AnimationSpec<Float>,
            动画折叠规格: AnimationSpec<Float>,
        ): Saver<SearchBarState, *> =
            SearchBarState.Saver(
                animationSpecForExpand = 动画展开规格,
                animationSpecForCollapse = 动画折叠规格,
            )
    }
}

/**
 * 创建并记住一个 [SearchBarState] 实例。
 *
 * @param 初始值 搜索栏初始处于折叠还是展开的布尔值。
 * @param 动画展开规格 搜索栏展开时使用的动画规格。
 * @param 动画折叠规格 搜索栏折叠时使用的动画规格。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@ExperimentalMaterial3Api
@Composable
fun 记住搜索栏状态(
    初始值: SearchBarValue = SearchBarValue.Collapsed,
    动画展开规格: AnimationSpec<Float> = MaterialTheme.motionScheme.slowSpatialSpec(),
    动画折叠规格: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultSpatialSpec(),
): SearchBarState =
    rememberSearchBarState(
        initialValue = 初始值,
        animationSpecForExpand = 动画展开规格,
        animationSpecForCollapse = 动画折叠规格,
    )



/**
 * [搜索栏滚动行为]指当用户上下滑动页面内容时，搜索栏的收起/展开/固定等响应规则。
 * @see [SearchBarDefaults.enterAlwaysSearchBarScrollBehavior]
 */
@ExperimentalMaterial3Api
@Stable
interface 搜索栏滚动行为 { //SearchBarScrollBehavior

    /**
     * 搜索栏因滚动而产生的当前偏移量（单位：像素）。该偏移量作用于搜索栏的固定尺寸，用于在内容滚动时控制其显示大小。
     *
     * 该值通常为负数。
     *
     * 对 [滚动偏移] 的更新会被限制在 [滚动偏移限制] 与 0 之间。
     */
    @get:FrequentlyChangingValue var 滚动偏移: Float

    /**
     * 搜索栏因滚动而产生的偏移量上限（单位：像素）。
     *
     * 该值通常为负数。
     *
     * 在更新 [滚动偏移] 时使用此上限进行限制。
     */
    var 滚动偏移限制: Float

    /**
     * 搜索栏下方内容的总滚动偏移量。
     *
     * 内容偏移量用于计算 [overlappedFraction]，后续可由实现读取。
     *
     * 每当嵌套滚动连接消费滚动事件时，该值由 [SearchBarScrollBehavior] 更新。常见实现为累加所有 [NestedScrollConnection.onPostScroll] 中 `consumed.y` 的值。
     */
    @get:FrequentlyChangingValue var 内容偏移: Float

    /**
     * 应附加到 Modifier.nestedScroll 的 NestedScrollConnection，用于跟踪滚动事件。
     */
    val 嵌套滚动连接: NestedScrollConnection

    /**
     * 为搜索栏组件添加滚动行为的修饰符，[AppBarWithSearch] 会自动应用它。
     */
    fun Modifier.搜索栏滚动行为(): Modifier
}


/** [SearchBar] 与 [DockedSearchBar] 使用的默认值集合。 */
@ExperimentalMaterial3Api
object 搜索栏默认值 { //SearchBarDefaults
    /** 搜索栏默认的色调高度。 */
    val 色调阴影: Dp = SearchBarDefaults.TonalElevation

    /** 搜索栏默认的阴影高度。 */
    val 视觉阴影: Dp = SearchBarDefaults.ShadowElevation

    @Deprecated(
        message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.",
        replaceWith = ReplaceWith("TonalElevation"),
        level = DeprecationLevel.WARNING,
    )
    val 阴影: Dp = SearchBarDefaults.Elevation

    /** 搜索栏输入框（或未展开状态）的默认高度。 */
    val 输入字段高度: Dp = SearchBarDefaults.InputFieldHeight

    /** 搜索栏输入框（或未展开状态）的默认形状。 */
    val 输入字段形状: Shape
        @Composable get() = SearchBarDefaults.inputFieldShape

    /** [SearchBar] 展开状态下的默认形状。 */
    val 全屏形状: Shape
        @Composable get() = SearchBarDefaults.fullScreenShape

    /**
     * [ExpandedFullScreenContainedSearchBar] 在折叠状态下的默认容器颜色。
     */
    val 折叠内置搜索栏颜色: Color
        @Composable get() = SearchBarDefaults.collapsedContainedSearchBarColor

    /**
     * [ExpandedFullScreenContainedSearchBar] 在展开状态下的默认容器颜色。
     */
    val 全屏内置搜索栏颜色: Color
        @Composable
        get() = SearchBarDefaults.fullScreenContainedSearchBarColor // TODO: replace with token.

    /** [DockedSearchBar] 的默认形状。 */
    val 停靠形状: Shape
        @Composable get() = SearchBarDefaults.dockedShape

    /** 与 [DockedSearchBar] 连接的搜索结果下拉框的默认形状。 */
    val 停靠下拉形状: Shape
        get() = SearchBarDefaults.dockedDropdownShape // TODO: replace with token.

    /** 与 [DockedSearchBar] 连接的搜索结果下拉框的默认间隙大小。 */
    val  停靠下拉间隙大小: Dp = SearchBarDefaults.dockedDropdownGapSize // TODO: replace with token.

    /** [AppBarWithSearch] 内容的默认内边距。 */
    val 应用栏内容内边距 = SearchBarDefaults.AppBarContentPadding

    /** [AppBarWithSearch] 的默认窗口边距。 */
    val 窗口插入: WindowInsets
        @Composable get() = SearchBarDefaults.windowInsets

    /** [ExpandedFullScreenSearchBar] 默认使用并消耗的窗口边距。 */
    val 全屏窗口插入: WindowInsets
        @Composable get() = SearchBarDefaults.fullScreenWindowInsets

    /**
     * 返回 [SearchBarScrollBehavior]。配置此行为的搜索栏将在内容上滑时立即向上移出屏幕，下滑时立即重新出现。
     *
     * 返回的 [SearchBarScrollBehavior] 会在重组间被记住。
     *
     * @param 初始偏移 [SearchBarScrollBehavior.scrollOffset] 的初始值，应在 [初始偏移限制] 与 0 之间。
     * @param 初始偏移限制 [SearchBarScrollBehavior.scrollOffsetLimit] 的初始值，表示搜索栏在内容滚动时允许向上滚出屏幕的像素上限。
     * @param 初始内容偏移 [SearchBarScrollBehavior.contentOffset] 的初始值。`可以滚动` 回调用于
     * 决定滚动事件是否由本 [SearchBarScrollBehavior] 处理。
     * @param 捕捉动画规格 [AnimationSpec] 定义当快速滑动或拖动使搜索栏停在中间位置时，其滚动偏移量如何吸附到极限值或 0。
     * @param 抛动画规格 [DecayAnimationSpec] 定义当用户对搜索栏本身或其下方内容进行快速滑动时，搜索栏的抛滑动画效果。
     * @param 反向布局 表示此行为应用于滚动和布局方向**相反**的可滚动内容。
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    @ExperimentalMaterial3Api
    @Composable
    fun 始终进入搜索栏滚动行为(
        初始偏移: Float = 0f,
        初始偏移限制: Float = -Float.MAX_VALUE,
        初始内容偏移: Float = 0f,
        可以滚动: () -> Boolean = { true },
        // TODO 从组件令牌文件加载motionScheme令牌
        捕捉动画规格: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultEffectsSpec(),
        抛动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        反向布局: Boolean = false,
    ): SearchBarScrollBehavior =
        SearchBarDefaults.enterAlwaysSearchBarScrollBehavior(
            initialOffset = 初始偏移,
            initialOffsetLimit = 初始偏移限制,
            initialContentOffset = 初始内容偏移,
            canScroll = 可以滚动,
            reverseLayout = 反向布局,
            snapAnimationSpec = 捕捉动画规格,
            flingAnimationSpec = 抛动画规格,
        )


    /**
     * 创建一个 [SearchBarColors]，表示搜索栏各部分使用的不同颜色。
     *
     * @param 容器颜色 搜索栏的容器颜色。
     * @param 分隔线颜色 输入框与搜索结果之间分隔线的颜色。
     * @param 输入字段颜色 输入框的颜色。可通过 [SearchBarColors.inputFieldColors] 获取，并应传入搜索栏的 `inputField` 插槽。
     */
    @Composable
    fun 颜色(
        容器颜色: Color = SearchBarDefaults.colors().containerColor,
        分隔线颜色: Color = SearchBarDefaults.colors().dividerColor,
        输入字段颜色: TextFieldColors = 输入字段颜色(),
    ): SearchBarColors =
        SearchBarDefaults.colors(
            containerColor = 容器颜色,
            dividerColor = 分隔线颜色,
            inputFieldColors = 输入字段颜色,
        )

    /**
     * 基于 [SearchBarState] 创建 [SearchBarColors]，表示搜索栏各部分使用的不同颜色。
     *
     * 此值应与 [ExpandedFullScreenContainedSearchBar] 配合使用，并将其 [inputFieldColors] 传入对应的 [InputField]。
     *
     * @param 状态 搜索栏的状态。
     */
    @Composable
    fun 内置颜色(状态: SearchBarState): SearchBarColors =
        SearchBarDefaults.containedColors(state = 状态,)

    /**
     * 创建一个 [AppBarWithSearchColors]，表示 [AppBarWithSearch] 各部分使用的不同颜色。
     *
     * @param 搜索栏颜色 搜索栏的颜色。
     * @param 滚动搜索栏容器颜色 搜索栏的容器颜色。 当内容被滚动时
     * @param 应用栏容器颜色 应用栏容器的颜色。
     * @param 滚动应用栏容器颜色 内容滚动时应用栏容器的颜色。
     * @param 应用栏导航图标颜色 应用栏导航图标的颜色。
     * @param 应用栏操作图标颜色 应用栏操作图标的颜色。
     */
    @Composable
    fun 应用栏带搜索颜色(
        搜索栏颜色: SearchBarColors = 颜色(),
        // TODO 从组件令牌文件中加载颜色令牌。
        滚动搜索栏容器颜色: Color = SearchBarDefaults.appBarWithSearchColors().scrolledSearchBarContainerColor,
        应用栏容器颜色: Color = SearchBarDefaults.appBarWithSearchColors().appBarContainerColor,
        滚动应用栏容器颜色: Color = SearchBarDefaults.appBarWithSearchColors().scrolledAppBarContainerColor,
        应用栏导航图标颜色: Color = SearchBarDefaults.appBarWithSearchColors().appBarNavigationIconColor,
        应用栏操作图标颜色: Color = SearchBarDefaults.appBarWithSearchColors().appBarActionIconColor,
    ): AppBarWithSearchColors =
        SearchBarDefaults.appBarWithSearchColors(
            searchBarColors = 搜索栏颜色,
            scrolledSearchBarContainerColor = 滚动搜索栏容器颜色,
            appBarContainerColor = 应用栏容器颜色,
            scrolledAppBarContainerColor = 滚动应用栏容器颜色,
            appBarNavigationIconColor = 应用栏导航图标颜色,
            appBarActionIconColor = 应用栏操作图标颜色,
        )

    /**
     * 创建 [TextFieldColors]，表示搜索栏输入框在不同状态下使用的各类颜色。
     *
     * 仅使用 [TextFieldColors] 参数列表的子集，其余参数无效果。
     *
     * @param 聚焦文本颜色 输入框聚焦时输入文本的颜色。
     * @param 非聚焦文本颜色 输入框未聚焦时输入文本的颜色。
     * @param 禁用文本颜色 输入框禁用时输入文本的颜色。
     * @param 光标颜色 输入框光标颜色。
     * @param 选择颜色 输入框选中文本的颜色。
     * @param 聚焦前导图标颜色 输入框聚焦时前置图标颜色。
     * @param 非聚焦前导图标颜色 输入框未聚焦时前置图标颜色。
     * @param 禁用前导图标颜色 输入框禁用时前置图标颜色。
     * @param 聚焦尾随图标颜色 输入框聚焦时后置图标颜色。
     * @param 非聚焦尾随图标颜色 输入框未聚焦时后置图标颜色。
     * @param 禁用尾随图标颜色 输入框禁用时后置图标颜色。
     * @param 聚焦占位符颜色 输入框聚焦时占位符颜色。
     * @param 非聚焦占位符颜色 输入框未聚焦时占位符颜色。
     * @param 禁用占位符颜色 输入框禁用时占位符颜色。
     * @param 聚焦前缀颜色 输入框聚焦时前缀颜色。
     * @param 非聚焦前缀颜色 输入框未聚焦时前缀颜色。
     * @param 禁用前缀颜色 输入框禁用时前缀颜色。
     * @param 聚焦后缀颜色 输入框聚焦时后缀颜色。
     * @param 非聚焦后缀颜色 输入框未聚焦时后缀颜色。
     * @param 禁用后缀颜色 输入框禁用时后缀颜色。
     * @param 聚焦容器颜色 输入框聚焦时容器颜色。
     * @param 非聚焦容器颜色 输入框未聚焦时容器颜色。
     * @param 禁用容器颜色 输入框禁用时容器颜色。
     */
    @Composable
    fun 输入字段颜色(
        聚焦文本颜色: Color = SearchBarDefaults.inputFieldColors().focusedTextColor,
        非聚焦文本颜色: Color = SearchBarDefaults.inputFieldColors().unfocusedTextColor,
        禁用文本颜色: Color = SearchBarDefaults.inputFieldColors().disabledTextColor.copy(alpha = 0.38f),
        光标颜色: Color = SearchBarDefaults.inputFieldColors().cursorColor,
        选择颜色: TextSelectionColors = LocalTextSelectionColors.current,
        聚焦前导图标颜色: Color = SearchBarDefaults.inputFieldColors().focusedLeadingIconColor,
        非聚焦前导图标颜色: Color = SearchBarDefaults.inputFieldColors().unfocusedLeadingIconColor,
        禁用前导图标颜色: Color = SearchBarDefaults.inputFieldColors().disabledLeadingIconColor.copy(alpha = 0.38f),
        聚焦尾随图标颜色: Color = SearchBarDefaults.inputFieldColors().focusedTrailingIconColor,
        非聚焦尾随图标颜色: Color = SearchBarDefaults.inputFieldColors().unfocusedTrailingIconColor,
        禁用尾随图标颜色: Color = SearchBarDefaults.inputFieldColors().disabledTrailingIconColor.copy(alpha = 0.38f),
        聚焦占位符颜色: Color = SearchBarDefaults.inputFieldColors().focusedPlaceholderColor,
        非聚焦占位符颜色: Color = SearchBarDefaults.inputFieldColors().unfocusedPlaceholderColor,
        禁用占位符颜色: Color = SearchBarDefaults.inputFieldColors().disabledPlaceholderColor.copy(alpha = 0.38f),
        聚焦前缀颜色: Color = SearchBarDefaults.inputFieldColors().focusedPrefixColor,
        非聚焦前缀颜色: Color =SearchBarDefaults.inputFieldColors().unfocusedPrefixColor,
        禁用前缀颜色: Color = SearchBarDefaults.inputFieldColors().disabledPrefixColor.copy(alpha = 0.38f),
        聚焦后缀颜色: Color = SearchBarDefaults.inputFieldColors().focusedSuffixColor,
        非聚焦后缀颜色: Color = SearchBarDefaults.inputFieldColors().unfocusedSuffixColor,
        禁用后缀颜色: Color = SearchBarDefaults.inputFieldColors().disabledSuffixColor.copy(alpha = 0.38f),
        聚焦容器颜色: Color = Color.Transparent,
        非聚焦容器颜色: Color = Color.Transparent,
        禁用容器颜色: Color = Color.Transparent,
    ): TextFieldColors =
        SearchBarDefaults.inputFieldColors(
            focusedTextColor = 聚焦文本颜色,
            unfocusedTextColor = 非聚焦文本颜色,
            disabledTextColor = 禁用文本颜色,
            cursorColor = 光标颜色,
            selectionColors = 选择颜色,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 非聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 非聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 非聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 非聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 非聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 非聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
        )


    /**
     * 创建一个文本字段，用于在搜索栏中输入查询。
     *
     * 该 [输入字段] 重载使用 [TextFieldState] 记录文本内容及光标/选区位置，并使用 [SearchBarState] 记录搜索栏状态。
     * 应与同样接受 [SearchBarState] 的搜索栏 API 配合使用。
     *
     * @param 文本字段状态 保存输入框内部编辑状态的 [TextFieldState]。
     * @param 搜索栏状态 搜索栏整体的状态。
     * @param 搜索回调 当输入法触发 [ImeAction.Search] 动作时调用的回调，[文本字段状态] 中的当前查询作为回调参数传入。
     * @param 修饰符 应用于该输入框的 [Modifier]。
     * @param 已启用 该输入框的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
     * @param 只读 控制输入框的只读状态。当设为 `true` 时，输入框不可修改，但用户仍可聚焦并复制其中的文本。
     * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
     * @param 占位符 输入文本为空时显示的占位文本。
     * @param 前导图标 显示在输入框起始位置的图标。
     * @param 尾随图标 显示在输入框末尾的图标。
     * @param 前缀 可选显示在输入文本之前的前缀。
     * @param 后缀 可选显示在输入文本之后的后缀。
     * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。该转换会作用于
     * 以下所有输入方式：实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [文本字段状态]，
     * 变换规则本身被动态修改时若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [文本字段状态]。
     * @param 输出转换 可选的 [OutputTransformation]，用于改变文本字段内容的展示方式。
     * @param 键盘选项 软件键盘选项，包含 [KeyboardType] 等配置。注意：[ImeAction] 将被强制覆盖为 [ImeAction.Search]。
     * @param 行限制 控制输入框是单行水平滚动并忽略换行，还是多行垂直扩展与滚动。
     * @param 滚动状态 管理输入框水平滚动的滚动状态。
     * @param 形状 输入框的形状。
     * @param 颜色 用于在不同状态下解析该输入框颜色的 [TextFieldColors]，参见 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 可选的已提升 [MutableInteractionSource]，用于观察和发送该输入框的 [Interaction]。可借此改变搜索栏
     * 外观或在不同状态下预览搜索栏。注意：即使传入 `null`，内部交互仍会发生。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        文本字段状态: TextFieldState,
        搜索栏状态: SearchBarState,
        搜索回调: (String) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        只读: Boolean = false,
        文本样式: TextStyle = LocalTextStyle.current,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        输入转换: InputTransformation? = null,
        输出转换: OutputTransformation? = null,
        键盘选项: KeyboardOptions = KeyboardOptions.Default,
        行限制: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
        滚动状态: ScrollState = rememberScrollState(),
        形状: Shape = 输入字段形状,
        颜色: TextFieldColors = 输入字段颜色(),
        交互源: MutableInteractionSource? = null,
    ) {
        SearchBarDefaults.InputField(
            textFieldState = 文本字段状态,
            searchBarState = 搜索栏状态,
            onSearch = 搜索回调,
            modifier = 修饰符,
            enabled = 已启用,
            readOnly = 只读,
            textStyle = 文本样式,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            inputTransformation = 输入转换,
            outputTransformation = 输出转换,
            keyboardOptions = 键盘选项,
            lineLimits = 行限制,
            scrollState = 滚动状态,
            shape = 形状,
            colors = 颜色,
            interactionSource = 交互源,
        )
    }

    /**
     * 在搜索栏中用于输入查询的文本字段。
     *
     * 该重载的 [输入字段] 使用 [TextFieldState] 记录输入框的文本内容、光标或选区位置，同时使用 [扩展] 和 [onExpandedChange]
     * 来跟踪搜索栏整体的展开/收起状态。它应与同样接受 [扩展] 和 [onExpandedChange] 的搜索栏 API 配套使用。
     *
     * @param 状态 保存输入框内部编辑状态的 [TextFieldState]。
     * @param 搜索回调 当输入法触发 [ImeAction.Search] 动作时调用的回调，[状态] 中的当前查询作为回调参数传入。
     * @param 扩展 搜索栏是否处于展开状态并正在显示搜索结果。
     * @param 扩展改变回调 当搜索栏的展开状态发生变化时将调用的回调。
     * @param 修饰符 应用于该输入框的 [Modifier]。
     * @param 已启用 该输入框的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
     * @param 只读 控制输入框的只读状态。当设为 `true` 时，输入框不可修改，但用户仍可聚焦并复制其中的文本。
     * @param 文本样式 应用于输入文本的样式，默认使用 [LocalTextStyle]。
     * @param 占位符 输入框为空时显示的占位符。
     * @param 前导图标 输入框起始位置显示的图标。
     * @param 尾随图标 输入框结束位置显示的图标。
     * @param 前缀 输入框文本前显示的可选前缀。
     * @param 后缀 输入框文本后显示的可选后缀。
     * @param 输入转换 可选的 [InputTransformation]，用于对用户造成的 [TextFieldState] 变更进行转换。
     * 该转换会作用于以下所有输入方式：实体/软件键盘、粘贴或拖放文本、无障碍服务以及测试代码。**不会** 在以下场景生效：以编程方式直接修改 [状态]，
     * 变换规则本身被动态修改时若在文本字段已存在的情况下更改变换规则，新规则仅对**下一次用户编辑**生效，不会立即影响当前的 [状态]。
     * @param 输出转换 可选的 [OutputTransformation]，用于改变文本字段内容的展示方式。
     * @param 滚动状态 管理输入框水平滚动的滚动状态。
     * @param 形状 输入框的形状。
     * @param 颜色 用于在不同状态下解析该输入框颜色的 [TextFieldColors]，参见 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 可选的已提升 [MutableInteractionSource]，用于观察和发送该输入框的 [Interaction]。
     * 可借此改变搜索栏外观或在不同状态下预览搜索栏。注意：即使传入 `null`，内部交互仍会发生。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        状态: TextFieldState,
        搜索回调: (String) -> Unit,
        扩展: Boolean,
        扩展改变回调: (Boolean) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        只读: Boolean = false,
        文本样式: TextStyle = LocalTextStyle.current,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        输入转换: InputTransformation? = null,
        输出转换: OutputTransformation? = null,
        滚动状态: ScrollState = rememberScrollState(),
        形状: Shape = 输入字段形状,
        颜色: TextFieldColors = 输入字段颜色(),
        交互源: MutableInteractionSource? = null,
    ) {
        SearchBarDefaults.InputField(
            state = 状态,
            onSearch = 搜索回调,
            expanded = 扩展,
            onExpandedChange = 扩展改变回调,
            modifier = 修饰符,
            enabled = 已启用,
            readOnly = 只读,
            textStyle = 文本样式,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            inputTransformation = 输入转换,
            outputTransformation = 输出转换,
            scrollState = 滚动状态,
            shape = 形状,
            colors = 颜色,
            interactionSource = 交互源,
        )
    }

    /**
     * 在搜索栏中用于输入查询的文本字段。
     *
     * 该 [输入字段] 重载通过 [查询] 与 [查询改变回调] 回调来跟踪文本内容；建议使用接受 [TextFieldState] 的重载版本。
     *
     * @param 查询 在输入框中显示的查询文本。
     * @param 查询改变回调 当输入法更新查询文本时调用的回调，更新后的文本作为回调参数传入。
     * @param 搜索回调 当输入法触发 [ImeAction.Search] 动作时调用的回调，当前 [查询] 作为回调参数传入。
     * @param 扩展 搜索栏是否处于展开状态并正在显示搜索结果。
     * @param 扩展改变回调 当搜索栏的展开状态发生变化时将调用的回调。
     * @param 修饰符 应用于该输入框的 [Modifier]。
     * @param 已启用 该输入框的启用状态。当设为 `false` 时，组件将不响应用户输入，视觉上呈禁用状态，且对无障碍服务也表现为已禁用。
     * @param 占位符 当 [查询] 为空时显示的占位文本。
     * @param 前导图标 显示在输入框起始位置的图标。
     * @param 尾随图标 显示在输入框末尾的图标。
     * @param 颜色 用于在不同状态下解析该输入框颜色的 [TextFieldColors]，参见 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 可选的已提升 [MutableInteractionSource]，用于观察和发送该输入框的 [Interaction]。
     * 可借此改变搜索栏外观或在不同状态下预览搜索栏。注意：即使传入 `null`，内部交互仍会发生。
     */
    @Suppress("ComposableNaming","ModifierParameter")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        查询: String,
        查询改变回调: (String) -> Unit,
        搜索回调: (String) -> Unit,
        扩展: Boolean,
        扩展改变回调: (Boolean) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        颜色: TextFieldColors = 输入字段颜色(),
        交互源: MutableInteractionSource? = null,
    ) {
        SearchBarDefaults.InputField(
            query = 查询,
            onQueryChange = 查询改变回调,
            onSearch = 搜索回调,
            expanded = 扩展,
            onExpandedChange = 扩展改变回调,
            modifier = 修饰符,
            enabled = 已启用,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            colors = 颜色,
            interactionSource = 交互源,
        )
    }

}

/**
 * 表示搜索栏所使用的颜色集合。
 *
 * 默认实现遵循 Material 规范的搜索栏颜色，详见 [SearchBarDefaults.colors]。
 */
@ExperimentalMaterial3Api
@Immutable
class 搜索栏颜色(  // SearchBarColors
    val 容器颜色: Color,
    val 分隔线颜色: Color,
    val 输入字段颜色: TextFieldColors,
) {
    @Deprecated(
        message = "Use overload that takes `inputFieldColors`",
        replaceWith = ReplaceWith("SearchBarColors(containerColor, dividerColor, inputFieldColors)"),
    )
    constructor(
        容器颜色: Color,
        分隔线颜色: Color,
    ) : this(容器颜色, 分隔线颜色, UnspecifiedTextFieldColors)

    /** 返回此 SearchBarColors 的副本，可选择性地覆盖其中的部分值。 */
    fun 复制(
        容器颜色: Color = this.容器颜色,
        分隔线颜色: Color = this.分隔线颜色,
        输入字段颜色: TextFieldColors = this.输入字段颜色,
    ) =
        SearchBarColors(
            containerColor = 容器颜色,
            dividerColor = 分隔线颜色,
            inputFieldColors = 输入字段颜色,
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SearchBarColors) return false

        if (容器颜色 != other.containerColor) return false
        if (分隔线颜色 != other.dividerColor) return false
        if (输入字段颜色 != other.inputFieldColors) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 分隔线颜色.hashCode()
        result = 31 * result + 输入字段颜色.hashCode()
        return result
    }
}

/**
 * 表示 [AppBarWithSearch] 所使用的颜色集合。
 *
 * 默认实现遵循 Material 规范的 AppBarWithSearch 颜色，详见 [SearchBarDefaults.appBarWithSearchColors]。
 *
 * @param 搜索栏颜色 该应用栏中 [SearchBar] 所使用的颜色。
 * @param 滚动搜索栏容器颜色 搜索栏的容器颜色。 当内容被滚动时
 * @param 应用栏容器颜色 应用栏容器的颜色。使用 [Color.Transparent] 可设置为无颜色。
 * @param 滚动应用栏容器颜色 内容滚动时应用栏容器的颜色。
 * @param 应用栏导航图标颜色 应用栏导航图标的颜色。
 * @param 应用栏操作图标颜色 应用栏操作图标的颜色。
 */
@ExperimentalMaterial3Api
@Immutable
class 应用栏带搜索颜色( //AppBarWithSearchColors
    val 搜索栏颜色: SearchBarColors,
    val 滚动搜索栏容器颜色: Color,
    val 应用栏容器颜色: Color,
    val 滚动应用栏容器颜色: Color,
    val 应用栏导航图标颜色: Color,
    val 应用栏操作图标颜色: Color,
) {

    constructor(
        搜索栏颜色: SearchBarColors,
        应用栏容器颜色: Color,
        应用栏导航图标颜色: Color,
        应用栏操作图标颜色: Color,
    ) : this(
        搜索栏颜色,
        Color.Unspecified,
        应用栏容器颜色,
        Color.Unspecified,
        应用栏导航图标颜色,
        应用栏操作图标颜色,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AppBarWithSearchColors) return false

        if (搜索栏颜色 != other.searchBarColors) return false
        if (滚动搜索栏容器颜色 != other.scrolledSearchBarContainerColor) return false
        if (应用栏容器颜色 != other.appBarContainerColor) return false
        if (滚动应用栏容器颜色 != other.scrolledAppBarContainerColor) return false
        if (应用栏导航图标颜色 != other.appBarNavigationIconColor) return false
        if (应用栏操作图标颜色 != other.appBarActionIconColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 搜索栏颜色.hashCode()
        result = 31 * result + 滚动搜索栏容器颜色.hashCode()
        result = 31 * result + 应用栏容器颜色.hashCode()
        result = 31 * result + 滚动应用栏容器颜色.hashCode()
        result = 31 * result + 应用栏导航图标颜色.hashCode()
        result = 31 * result + 应用栏操作图标颜色.hashCode()
        return result
    }
}


@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
@Deprecated(
    message = "Use overload which takes inputField as a parameter",
    replaceWith =
        ReplaceWith(
            "SearchBar(\n" +
                    "    inputField = {\n" +
                    "        SearchBarDefaults.InputField(\n" +
                    "            textFieldState = textFieldState,\n" +
                    "            searchBarState = searchBarState,\n" +
                    "            onSearch = onSearch,\n" +
                    "            modifier = modifier,\n" +
                    "            enabled = enabled,\n" +
                    "            readOnly = readOnly,\n" +
                    "            textStyle = textStyle,\n" +
                    "            placeholder = placeholder,\n" +
                    "            leadingIcon = leadingIcon,\n" +
                    "            trailingIcon = trailingIcon,\n" +
                    "            prefix = prefix,\n" +
                    "            suffix = suffix,\n" +
                    "            inputTransformation = inputTransformation,\n" +
                    "            outputTransformation = outputTransformation,\n" +
                    "            keyboardOptions = keyboardOptions,\n" +
                    "            lineLimits = lineLimits,\n" +
                    "            scrollState = scrollState,\n" +
                    "            shape = shape,\n" +
                    "            colors = colors,\n" +
                    "            interactionSource = interactionSource,\n" +
                    "        )\n" +
                    "    },\n" +
                    "    expanded = active,\n" +
                    "    onExpandedChange = onActiveChange,\n" +
                    "    modifier = modifier,\n" +
                    "    shape = shape,\n" +
                    "    colors = colors,\n" +
                    "    tonalElevation = tonalElevation,\n" +
                    "    shadowElevation = shadowElevation,\n" +
                    "    windowInsets = windowInsets,\n" +
                    "    content = content,\n" +
                    ")"
        ),
)
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    查询: String,
    查询改变回调: (String) -> Unit,
    搜索回调: (String) -> Unit,
    活动: Boolean,
    活动改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    SearchBar(
        query = 查询,
        onQueryChange = 查询改变回调,
        onSearch = 搜索回调,
        active = 活动,
        onActiveChange = 活动改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        interactionSource = 交互源,
        content = 内容,
    )

@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
@Deprecated(
    message = "Use overload which takes inputField as a parameter",
    replaceWith =
        ReplaceWith(
            "DockedSearchBar(\n" +
                    "    inputField = {\n" +
                    "        SearchBarDefaults.InputField(\n" +
                    "            textFieldState = textFieldState,\n" +
                    "            searchBarState = searchBarState,\n" +
                    "            onSearch = onSearch,\n" +
                    "            modifier = modifier,\n" +
                    "            enabled = enabled,\n" +
                    "            readOnly = readOnly,\n" +
                    "            textStyle = textStyle,\n" +
                    "            placeholder = placeholder,\n" +
                    "            leadingIcon = leadingIcon,\n" +
                    "            trailingIcon = trailingIcon,\n" +
                    "            prefix = prefix,\n" +
                    "            suffix = suffix,\n" +
                    "            inputTransformation = inputTransformation,\n" +
                    "            outputTransformation = outputTransformation,\n" +
                    "            keyboardOptions = keyboardOptions,\n" +
                    "            lineLimits = lineLimits,\n" +
                    "            scrollState = scrollState,\n" +
                    "            shape = shape,\n" +
                    "            colors = colors,\n" +
                    "            interactionSource = interactionSource,\n" +
                    "        )\n" +
                    "    },\n" +
                    "    expanded = active,\n" +
                    "    onExpandedChange = onActiveChange,\n" +
                    "    modifier = modifier,\n" +
                    "    shape = shape,\n" +
                    "    colors = colors,\n" +
                    "    tonalElevation = tonalElevation,\n" +
                    "    shadowElevation = shadowElevation,\n" +
                    "    content = content,\n" +
                    ")"
        ),
)
@ExperimentalMaterial3Api
@Composable
fun 停靠搜索栏(
    查询: String,
    查询改变回调: (String) -> Unit,
    搜索回调: (String) -> Unit,
    活动: Boolean,
    活动改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    DockedSearchBar(
        query = 查询,
        onQueryChange = 查询改变回调,
        onSearch = 搜索回调,
        active = 活动,
        onActiveChange = 活动改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        interactionSource = 交互源,
        content = 内容,
    )



private val UnspecifiedTextFieldColors: TextFieldColors =
    TextFieldColors(
        focusedTextColor = Color.Unspecified,
        unfocusedTextColor = Color.Unspecified,
        disabledTextColor = Color.Unspecified,
        errorTextColor = Color.Unspecified,
        focusedContainerColor = Color.Unspecified,
        unfocusedContainerColor = Color.Unspecified,
        disabledContainerColor = Color.Unspecified,
        errorContainerColor = Color.Unspecified,
        cursorColor = Color.Unspecified,
        errorCursorColor = Color.Unspecified,
        textSelectionColors = TextSelectionColors(Color.Unspecified, Color.Unspecified),
        focusedIndicatorColor = Color.Unspecified,
        unfocusedIndicatorColor = Color.Unspecified,
        disabledIndicatorColor = Color.Unspecified,
        errorIndicatorColor = Color.Unspecified,
        focusedLeadingIconColor = Color.Unspecified,
        unfocusedLeadingIconColor = Color.Unspecified,
        disabledLeadingIconColor = Color.Unspecified,
        errorLeadingIconColor = Color.Unspecified,
        focusedTrailingIconColor = Color.Unspecified,
        unfocusedTrailingIconColor = Color.Unspecified,
        disabledTrailingIconColor = Color.Unspecified,
        errorTrailingIconColor = Color.Unspecified,
        focusedLabelColor = Color.Unspecified,
        unfocusedLabelColor = Color.Unspecified,
        disabledLabelColor = Color.Unspecified,
        errorLabelColor = Color.Unspecified,
        focusedPlaceholderColor = Color.Unspecified,
        unfocusedPlaceholderColor = Color.Unspecified,
        disabledPlaceholderColor = Color.Unspecified,
        errorPlaceholderColor = Color.Unspecified,
        focusedSupportingTextColor = Color.Unspecified,
        unfocusedSupportingTextColor = Color.Unspecified,
        disabledSupportingTextColor = Color.Unspecified,
        errorSupportingTextColor = Color.Unspecified,
        focusedPrefixColor = Color.Unspecified,
        unfocusedPrefixColor = Color.Unspecified,
        disabledPrefixColor = Color.Unspecified,
        errorPrefixColor = Color.Unspecified,
        focusedSuffixColor = Color.Unspecified,
        unfocusedSuffixColor = Color.Unspecified,
        disabledSuffixColor = Color.Unspecified,
        errorSuffixColor = Color.Unspecified,
    )


