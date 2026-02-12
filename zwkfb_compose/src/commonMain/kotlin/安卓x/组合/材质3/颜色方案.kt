package 安卓x.组合.材质3

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DragHandleColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarColors
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTonalElevationEnabled
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.ToggleButtonColors
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.WideNavigationRailColors
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import 安卓x.组合.材质3.令牌.调色板令牌

/**
 * A color scheme holds all the named color parameters for a [材质主题].
 *
 * Color schemes are designed to be harmonious, ensure accessible text, and distinguish UI elements
 * and surfaces from one another. There are two built-in baseline schemes, [lightColorScheme] and a
 * [darkColorScheme], that can be used as-is or customized.
 *
 * The Material color system and custom schemes provide default values for color as a starting point
 * for customization.
 *
 * To learn more about colors, see
 * [Material Design colors](https://m3.material.io/styles/color/system/overview).
 *
 * @property primary The primary color is the color displayed most frequently across your app’s
 *   screens and components.
 * @property onPrimary Color used for text and icons displayed on top of the primary color.
 * @property primaryContainer The preferred tonal color of containers.
 * @property onPrimaryContainer The color (and state variants) that should be used for content on
 *   top of [primaryContainer].
 * @property inversePrimary Color to be used as a "primary" color in places where the inverse color
 *   scheme is needed, such as the button on a SnackBar.
 * @property secondary The secondary color provides more ways to accent and distinguish your
 *   product. Secondary colors are best for:
 * - Floating action buttons
 * - Selection controls, like checkboxes and radio buttons
 * - Highlighting selected text
 * - Links and headlines
 *
 * @property onSecondary Color used for text and icons displayed on top of the secondary color.
 * @property secondaryContainer A tonal color to be used in containers.
 * @property onSecondaryContainer The color (and state variants) that should be used for content on
 *   top of [secondaryContainer].
 * @property tertiary The tertiary color that can be used to balance primary and secondary colors,
 *   or bring heightened attention to an element such as an input field.
 * @property onTertiary Color used for text and icons displayed on top of the tertiary color.
 * @property tertiaryContainer A tonal color to be used in containers.
 * @property onTertiaryContainer The color (and state variants) that should be used for content on
 *   top of [tertiaryContainer].
 * @property background The background color that appears behind scrollable content.
 * @property onBackground Color used for text and icons displayed on top of the background color.
 * @property surface The surface color that affect surfaces of components, such as cards, sheets,
 *   and menus.
 * @property onSurface Color used for text and icons displayed on top of the surface color.
 * @property surfaceVariant Another option for a color with similar uses of [surface].
 * @property onSurfaceVariant The color (and state variants) that can be used for content on top of
 *   [surface].
 * @property surfaceTint This color will be used by components that apply tonal elevation and is
 *   applied on top of [surface]. The higher the elevation the more this color is used.
 * @property inverseSurface A color that contrasts sharply with [surface]. Useful for surfaces that
 *   sit on top of other surfaces with [surface] color.
 * @property inverseOnSurface A color that contrasts well with [inverseSurface]. Useful for content
 *   that sits on top of containers that are [inverseSurface].
 * @property error The error color is used to indicate errors in components, such as invalid text in
 *   a text field.
 * @property onError Color used for text and icons displayed on top of the error color.
 * @property errorContainer The preferred tonal color of error containers.
 * @property onErrorContainer The color (and state variants) that should be used for content on top
 *   of [errorContainer].
 * @property outline Subtle color used for boundaries. Outline color role adds contrast for
 *   accessibility purposes.
 * @property outlineVariant Utility color used for boundaries for decorative elements when strong
 *   contrast is not required.
 * @property scrim Color of a scrim that obscures content.
 * @property surfaceBright A [surface] variant that is always brighter than [surface], whether in
 *   light or dark mode.
 * @property surfaceDim A [surface] variant that is always dimmer than [surface], whether in light
 *   or dark mode.
 * @property surfaceContainer A [surface] variant that affects containers of components, such as
 *   cards, sheets, and menus.
 * @property surfaceContainerHigh A [surface] variant for containers with higher emphasis than
 *   [surfaceContainer]. Use this role for content which requires more emphasis than
 *   [surfaceContainer].
 * @property surfaceContainerHighest A [surface] variant for containers with higher emphasis than
 *   [surfaceContainerHigh]. Use this role for content which requires more emphasis than
 *   [surfaceContainerHigh].
 * @property surfaceContainerLow A [surface] variant for containers with lower emphasis than
 *   [surfaceContainer]. Use this role for content which requires less emphasis than
 *   [surfaceContainer].
 * @property surfaceContainerLowest A [surface] variant for containers with lower emphasis than
 *   [surfaceContainerLow]. Use this role for content which requires less emphasis than
 *   [surfaceContainerLow].
 * @property primaryFixed A [primary] variant that maintains the same tone in light and dark themes.
 *   The fixed color role may be used instead of the equivalent container role in situations where
 *   such fixed behavior is desired.
 * @property primaryFixedDim A [primary] variant that maintains the same tone in light and dark
 *   themes. Dim roles provide a stronger, more emphasized tone relative to the equivalent fixed
 *   color.
 * @property onPrimaryFixed Color used for text and icons displayed on top of [primaryFixed] or
 *   [primaryFixedDim]. Maintains the same tone in light and dark themes.
 * @property onPrimaryFixedVariant An [onPrimaryFixed] variant which provides less emphasis. Useful
 *   when a strong contrast is not required.
 * @property secondaryFixed A [secondary] variant that maintains the same tone in light and dark
 *   themes. The fixed color role may be used instead of the equivalent container role in situations
 *   where such fixed behavior is desired.
 * @property secondaryFixedDim A [secondary] variant that maintains the same tone in light and dark
 *   themes. Dim roles provide a stronger, more emphasized tone relative to the equivalent fixed
 *   color.
 * @property onSecondaryFixed Color used for text and icons displayed on top of [secondaryFixed] or
 *   [secondaryFixedDim]. Maintains the same tone in light and dark themes.
 * @property onSecondaryFixedVariant An [onSecondaryFixed] variant which provides less emphasis.
 *   Useful when a strong contrast is not required.
 * @property tertiaryFixed A [tertiary] variant that maintains the same tone in light and dark
 *   themes. The fixed color role may be used instead of the equivalent container role in situations
 *   where such fixed behavior is desired.
 * @property tertiaryFixedDim A [tertiary] variant that maintains the same tone in light and dark
 *   themes. Dim roles provide a stronger, more emphasized tone relative to the equivalent fixed
 *   color.
 * @property onTertiaryFixed Color used for text and icons displayed on top of [tertiaryFixed] or
 *   [tertiaryFixedDim]. Maintains the same tone in light and dark themes.
 * @property onTertiaryFixedVariant An [onTertiaryFixed] variant which provides less emphasis.
 *   Useful when a strong contrast is not required.
 */
@Immutable
class 颜色方案(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val inversePrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceTint: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val outline: Color,
    val outlineVariant: Color,
    val scrim: Color,
    val surfaceBright: Color,
    val surfaceDim: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,
    val surfaceContainerLow: Color,
    val surfaceContainerLowest: Color,
    val primaryFixed: Color,
    val primaryFixedDim: Color,
    val onPrimaryFixed: Color,
    val onPrimaryFixedVariant: Color,
    val secondaryFixed: Color,
    val secondaryFixedDim: Color,
    val onSecondaryFixed: Color,
    val onSecondaryFixedVariant: Color,
    val tertiaryFixed: Color,
    val tertiaryFixedDim: Color,
    val onTertiaryFixed: Color,
    val onTertiaryFixedVariant: Color,
) {
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "Use constructor with additional 'fixed' container roles.",
        replaceWith =
            ReplaceWith(
                "颜色方案(primary,\n" +
                        "onPrimary,\n" +
                        "primaryContainer,\n" +
                        "onPrimaryContainer,\n" +
                        "inversePrimary,\n" +
                        "secondary,\n" +
                        "onSecondary,\n" +
                        "secondaryContainer,\n" +
                        "onSecondaryContainer,\n" +
                        "tertiary,\n" +
                        "onTertiary,\n" +
                        "tertiaryContainer,\n" +
                        "onTertiaryContainer,\n" +
                        "background,\n" +
                        "onBackground,\n" +
                        "surface,\n" +
                        "onSurface,\n" +
                        "surfaceVariant,\n" +
                        "onSurfaceVariant,\n" +
                        "surfaceTint,\n" +
                        "inverseSurface,\n" +
                        "inverseOnSurface,\n" +
                        "error,\n" +
                        "onError,\n" +
                        "errorContainer,\n" +
                        "onErrorContainer,\n" +
                        "outline,\n" +
                        "outlineVariant,\n" +
                        "scrim,\n" +
                        "surfaceBright,\n" +
                        "surfaceDim,\n" +
                        "surfaceContainer,\n" +
                        "surfaceContainerHigh,\n" +
                        "surfaceContainerHighest,\n" +
                        "surfaceContainerLow,\n" +
                        "surfaceContainerLowest,)"
            ),
    )
    constructor(
        primary: Color,
        onPrimary: Color,
        primaryContainer: Color,
        onPrimaryContainer: Color,
        inversePrimary: Color,
        secondary: Color,
        onSecondary: Color,
        secondaryContainer: Color,
        onSecondaryContainer: Color,
        tertiary: Color,
        onTertiary: Color,
        tertiaryContainer: Color,
        onTertiaryContainer: Color,
        background: Color,
        onBackground: Color,
        surface: Color,
        onSurface: Color,
        surfaceVariant: Color,
        onSurfaceVariant: Color,
        surfaceTint: Color,
        inverseSurface: Color,
        inverseOnSurface: Color,
        error: Color,
        onError: Color,
        errorContainer: Color,
        onErrorContainer: Color,
        outline: Color,
        outlineVariant: Color,
        scrim: Color,
        surfaceBright: Color,
        surfaceDim: Color,
        surfaceContainer: Color,
        surfaceContainerHigh: Color,
        surfaceContainerHighest: Color,
        surfaceContainerLow: Color,
        surfaceContainerLowest: Color,
    ) : this(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceDim = surfaceDim,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        primaryFixed = Color.Unspecified,
        primaryFixedDim = Color.Unspecified,
        onPrimaryFixed = Color.Unspecified,
        onPrimaryFixedVariant = Color.Unspecified,
        secondaryFixed = Color.Unspecified,
        secondaryFixedDim = Color.Unspecified,
        onSecondaryFixed = Color.Unspecified,
        onSecondaryFixedVariant = Color.Unspecified,
        tertiaryFixed = Color.Unspecified,
        tertiaryFixedDim = Color.Unspecified,
        onTertiaryFixed = Color.Unspecified,
        onTertiaryFixedVariant = Color.Unspecified,
    )

    /** 返回此 ColorScheme 的一个副本，可选择性地覆盖其中的一些值。 */
    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
        surfaceBright: Color = this.surfaceBright,
        surfaceDim: Color = this.surfaceDim,
        surfaceContainer: Color = this.surfaceContainer,
        surfaceContainerHigh: Color = this.surfaceContainerHigh,
        surfaceContainerHighest: Color = this.surfaceContainerHighest,
        surfaceContainerLow: Color = this.surfaceContainerLow,
        surfaceContainerLowest: Color = this.surfaceContainerLowest,
        primaryFixed: Color = this.primaryFixed,
        primaryFixedDim: Color = this.primaryFixedDim,
        onPrimaryFixed: Color = this.onPrimaryFixed,
        onPrimaryFixedVariant: Color = this.onPrimaryFixedVariant,
        secondaryFixed: Color = this.secondaryFixed,
        secondaryFixedDim: Color = this.secondaryFixedDim,
        onSecondaryFixed: Color = this.onSecondaryFixed,
        onSecondaryFixedVariant: Color = this.onSecondaryFixedVariant,
        tertiaryFixed: Color = this.tertiaryFixed,
        tertiaryFixedDim: Color = this.tertiaryFixedDim,
        onTertiaryFixed: Color = this.onTertiaryFixed,
        onTertiaryFixedVariant: Color = this.onTertiaryFixedVariant,
    ): ColorScheme =
        ColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            inversePrimary = inversePrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            outline = outline,
            outlineVariant = outlineVariant,
            scrim = scrim,
            surfaceBright = surfaceBright,
            surfaceDim = surfaceDim,
            surfaceContainer = surfaceContainer,
            surfaceContainerHigh = surfaceContainerHigh,
            surfaceContainerHighest = surfaceContainerHighest,
            surfaceContainerLow = surfaceContainerLow,
            surfaceContainerLowest = surfaceContainerLowest,
            primaryFixed = primaryFixed,
            primaryFixedDim = primaryFixedDim,
            onPrimaryFixed = onPrimaryFixed,
            onPrimaryFixedVariant = onPrimaryFixedVariant,
            secondaryFixed = secondaryFixed,
            secondaryFixedDim = secondaryFixedDim,
            onSecondaryFixed = onSecondaryFixed,
            onSecondaryFixedVariant = onSecondaryFixedVariant,
            tertiaryFixed = tertiaryFixed,
            tertiaryFixedDim = tertiaryFixedDim,
            onTertiaryFixed = onTertiaryFixed,
            onTertiaryFixedVariant = onTertiaryFixedVariant,
        )

    @Deprecated(
        message =
            "Maintained for binary compatibility. Use overload with additional fixed roles " +
                    "instead",
        level = DeprecationLevel.HIDDEN,
    )
    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
    ): ColorScheme =
        copy(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            inversePrimary = inversePrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            outline = outline,
            outlineVariant = outlineVariant,
            scrim = scrim,
        )

    @Deprecated(
        message =
            "Maintained for binary compatibility. Use overload with additional fixed roles " +
                    "instead",
        level = DeprecationLevel.HIDDEN,
    )
    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
        surfaceBright: Color = this.surfaceBright,
        surfaceDim: Color = this.surfaceDim,
        surfaceContainer: Color = this.surfaceContainer,
        surfaceContainerHigh: Color = this.surfaceContainerHigh,
        surfaceContainerHighest: Color = this.surfaceContainerHighest,
        surfaceContainerLow: Color = this.surfaceContainerLow,
        surfaceContainerLowest: Color = this.surfaceContainerLowest,
    ): ColorScheme =
        copy(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            inversePrimary = inversePrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            outline = outline,
            outlineVariant = outlineVariant,
            scrim = scrim,
            surfaceBright = surfaceBright,
            surfaceDim = surfaceDim,
            surfaceContainer = surfaceContainer,
            surfaceContainerHigh = surfaceContainerHigh,
            surfaceContainerHighest = surfaceContainerHighest,
            surfaceContainerLow = surfaceContainerLow,
            surfaceContainerLowest = surfaceContainerLowest,
        )

    override fun toString(): String {
        return "颜色方案(" +
                "primary=$primary" +
                "onPrimary=$onPrimary" +
                "primaryContainer=$primaryContainer" +
                "onPrimaryContainer=$onPrimaryContainer" +
                "inversePrimary=$inversePrimary" +
                "secondary=$secondary" +
                "onSecondary=$onSecondary" +
                "secondaryContainer=$secondaryContainer" +
                "onSecondaryContainer=$onSecondaryContainer" +
                "tertiary=$tertiary" +
                "onTertiary=$onTertiary" +
                "tertiaryContainer=$tertiaryContainer" +
                "onTertiaryContainer=$onTertiaryContainer" +
                "background=$background" +
                "onBackground=$onBackground" +
                "surface=$surface" +
                "onSurface=$onSurface" +
                "surfaceVariant=$surfaceVariant" +
                "onSurfaceVariant=$onSurfaceVariant" +
                "surfaceTint=$surfaceTint" +
                "inverseSurface=$inverseSurface" +
                "inverseOnSurface=$inverseOnSurface" +
                "error=$error" +
                "onError=$onError" +
                "errorContainer=$errorContainer" +
                "onErrorContainer=$onErrorContainer" +
                "outline=$outline" +
                "outlineVariant=$outlineVariant" +
                "scrim=$scrim" +
                "surfaceBright=$surfaceBright" +
                "surfaceDim=$surfaceDim" +
                "surfaceContainer=$surfaceContainer" +
                "surfaceContainerHigh=$surfaceContainerHigh" +
                "surfaceContainerHighest=$surfaceContainerHighest" +
                "surfaceContainerLow=$surfaceContainerLow" +
                "surfaceContainerLowest=$surfaceContainerLowest" +
                "primaryFixed=$primaryFixed" +
                "primaryFixedDim=$primaryFixedDim" +
                "onPrimaryFixed=$onPrimaryContainer" +
                "onPrimaryFixedVariant=$onPrimaryFixedVariant" +
                "secondaryFixed=$secondaryFixed" +
                "secondaryFixedDim=$secondaryFixedDim" +
                "onSecondaryFixed=$onSecondaryFixed" +
                "onSecondaryFixedVariant=$onSecondaryFixedVariant" +
                "tertiaryFixed=$tertiaryFixed" +
                "tertiaryFixedDim=$tertiaryFixedDim" +
                "onTertiaryFixed=$onTertiaryFixed" +
                "onTertiaryFixedVariant=$onTertiaryFixedVariant" +
                ")"
    }

    internal var defaultButtonColorsCached: ButtonColors? = null
    internal var defaultElevatedButtonColorsCached: ButtonColors? = null
    internal var defaultFilledTonalButtonColorsCached: ButtonColors? = null
    internal var defaultOutlinedButtonColorsCached: ButtonColors? = null
    internal var defaultTextButtonColorsCached: ButtonColors? = null

    internal var defaultCardColorsCached: CardColors? = null
    internal var defaultElevatedCardColorsCached: CardColors? = null
    internal var defaultOutlinedCardColorsCached: CardColors? = null

    internal var defaultAssistChipColorsCached: ChipColors? = null
    internal var defaultElevatedAssistChipColorsCached: ChipColors? = null
    internal var defaultSuggestionChipColorsCached: ChipColors? = null
    internal var defaultElevatedSuggestionChipColorsCached: ChipColors? = null
    internal var defaultFilterChipColorsCached: SelectableChipColors? = null
    internal var defaultElevatedFilterChipColorsCached: SelectableChipColors? = null
    internal var defaultInputChipColorsCached: SelectableChipColors? = null

    internal var defaultVerticalDragHandleColorsCached: DragHandleColors? = null

    @OptIn(ExperimentalMaterial3Api::class)
    internal var defaultTopAppBarColorsCached: TopAppBarColors? = null

    internal var defaultCheckboxColorsCached: CheckboxColors? = null

    @OptIn(ExperimentalMaterial3Api::class)
    internal var defaultDatePickerColorsCached: DatePickerColors? = null

    internal var defaultIconButtonColorsCached: IconButtonColors? = null
    internal var defaultIconButtonVibrantColorsCached: IconButtonColors? = null
    internal var defaultIconToggleButtonColorsCached: IconToggleButtonColors? = null
    internal var defaultIconToggleButtonVibrantColorsCached: IconToggleButtonColors? = null
    internal var defaultFilledIconButtonColorsCached: IconButtonColors? = null
    internal var defaultFilledIconToggleButtonColorsCached: IconToggleButtonColors? = null
    internal var defaultFilledTonalIconButtonColorsCached: IconButtonColors? = null
    internal var defaultFilledTonalIconToggleButtonColorsCached: IconToggleButtonColors? = null
    internal var defaultOutlinedIconButtonColorsCached: IconButtonColors? = null
    internal var defaultOutlinedIconButtonVibrantColorsCached: IconButtonColors? = null
    internal var defaultOutlinedIconToggleButtonColorsCached: IconToggleButtonColors? = null
    internal var defaultOutlinedIconToggleButtonVibrantColorsCached: IconToggleButtonColors? = null

    internal var defaultToggleButtonColorsCached: ToggleButtonColors? = null
    internal var defaultElevatedToggleButtonColorsCached: ToggleButtonColors? = null
    internal var defaultTonalToggleButtonColorsCached: ToggleButtonColors? = null
    internal var defaultOutlinedToggleButtonColorsCached: ToggleButtonColors? = null

    internal var defaultListItemColorsCached: ListItemColors? = null
    internal var defaultSegmentedListItemColorsCached: ListItemColors? = null

    internal var defaultMenuItemColorsCached: MenuItemColors? = null
    internal var defaultMenuSelectableItemColorsCached: MenuItemColors? = null
    internal var defaultMenuSelectableItemVibrantColorsCached: MenuItemColors? = null

    internal var defaultNavigationBarItemColorsCached: NavigationBarItemColors? = null
    internal var defaultShortNavigationBarItemColorsCached: NavigationItemColors? = null

    internal var defaultNavigationRailItemColorsCached: NavigationRailItemColors? = null
    internal var defaultWideWideNavigationRailColorsCached: WideNavigationRailColors? = null
    internal var defaultWideNavigationRailItemColorsCached: NavigationItemColors? = null

    internal var defaultRadioButtonColorsCached: RadioButtonColors? = null

    internal var defaultSegmentedButtonColorsCached: SegmentedButtonColors? = null

    internal var defaultSliderColorsCached: SliderColors? = null

    internal var defaultSwitchColorsCached: SwitchColors? = null

    internal var defaultOutlinedTextFieldColorsCached: TextFieldColors? = null
    internal var defaultTextFieldColorsCached: TextFieldColors? = null

    @OptIn(ExperimentalMaterial3Api::class)
    internal var defaultTimePickerColorsCached: TimePickerColors? = null

    @OptIn(ExperimentalMaterial3Api::class)
    internal var defaultRichTooltipColorsCached: RichTooltipColors? = null

    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    internal var defaultFloatingToolbarStandardColorsCached: FloatingToolbarColors? = null
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    internal var defaultFloatingToolbarVibrantColorsCached: FloatingToolbarColors? = null

    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "Use constructor with additional 'surfaceContainer' roles.",
        replaceWith =
            ReplaceWith(
                "颜色方案(primary,\n" +
                        "onPrimary,\n" +
                        "primaryContainer,\n" +
                        "onPrimaryContainer,\n" +
                        "inversePrimary,\n" +
                        "secondary,\n" +
                        "onSecondary,\n" +
                        "secondaryContainer,\n" +
                        "onSecondaryContainer,\n" +
                        "tertiary,\n" +
                        "onTertiary,\n" +
                        "tertiaryContainer,\n" +
                        "onTertiaryContainer,\n" +
                        "background,\n" +
                        "onBackground,\n" +
                        "surface,\n" +
                        "onSurface,\n" +
                        "surfaceVariant,\n" +
                        "onSurfaceVariant,\n" +
                        "surfaceTint,\n" +
                        "inverseSurface,\n" +
                        "inverseOnSurface,\n" +
                        "error,\n" +
                        "onError,\n" +
                        "errorContainer,\n" +
                        "onErrorContainer,\n" +
                        "outline,\n" +
                        "outlineVariant,\n" +
                        "scrim,\n" +
                        "surfaceBright,\n" +
                        "surfaceDim,\n" +
                        "surfaceContainer,\n" +
                        "surfaceContainerHigh,\n" +
                        "surfaceContainerHighest,\n" +
                        "surfaceContainerLow,\n" +
                        "surfaceContainerLowest,\n" +
                        "primaryFixed,\n" +
                        "primaryFixedDim,\n" +
                        "onPrimaryFixed,\n" +
                        "onPrimaryFixedVariant,\n" +
                        "secondaryFixed,\n" +
                        "secondaryFixedDim,\n" +
                        "onSecondaryFixed,\n" +
                        "onSecondaryFixedVariant,\n" +
                        "tertiaryFixed,\n" +
                        "tertiaryFixedDim,\n" +
                        "onTertiaryFixed,\n" +
                        "onTertiaryFixedVariant" +
                        ")"
            ),
    )
    constructor(
        primary: Color,
        onPrimary: Color,
        primaryContainer: Color,
        onPrimaryContainer: Color,
        inversePrimary: Color,
        secondary: Color,
        onSecondary: Color,
        secondaryContainer: Color,
        onSecondaryContainer: Color,
        tertiary: Color,
        onTertiary: Color,
        tertiaryContainer: Color,
        onTertiaryContainer: Color,
        background: Color,
        onBackground: Color,
        surface: Color,
        onSurface: Color,
        surfaceVariant: Color,
        onSurfaceVariant: Color,
        surfaceTint: Color,
        inverseSurface: Color,
        inverseOnSurface: Color,
        error: Color,
        onError: Color,
        errorContainer: Color,
        onErrorContainer: Color,
        outline: Color,
        outlineVariant: Color,
        scrim: Color,
    ) : this(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = Color.Unspecified,
        surfaceDim = Color.Unspecified,
        surfaceContainer = Color.Unspecified,
        surfaceContainerHigh = Color.Unspecified,
        surfaceContainerHighest = Color.Unspecified,
        surfaceContainerLow = Color.Unspecified,
        surfaceContainerLowest = Color.Unspecified,
        primaryFixed = Color.Unspecified,
        primaryFixedDim = Color.Unspecified,
        onPrimaryFixed = Color.Unspecified,
        onPrimaryFixedVariant = Color.Unspecified,
        secondaryFixed = Color.Unspecified,
        secondaryFixedDim = Color.Unspecified,
        onSecondaryFixed = Color.Unspecified,
        onSecondaryFixedVariant = Color.Unspecified,
        tertiaryFixed = Color.Unspecified,
        tertiaryFixedDim = Color.Unspecified,
        onTertiaryFixed = Color.Unspecified,
        onTertiaryFixedVariant = Color.Unspecified,
    )
}

/** Returns a light Material color scheme. */
fun 浅色颜色方案(
    primary: Color = 调色板令牌.Primary40,
    onPrimary: Color = 调色板令牌.Primary100,
    primaryContainer: Color = 调色板令牌.Primary90,
    onPrimaryContainer: Color = 调色板令牌.Primary10,
    inversePrimary: Color = 调色板令牌.Primary80,
    secondary: Color = 调色板令牌.Secondary40,
    onSecondary: Color = 调色板令牌.Secondary100,
    secondaryContainer: Color = 调色板令牌.Secondary90,
    onSecondaryContainer: Color = 调色板令牌.Secondary10,
    tertiary: Color = 调色板令牌.Tertiary40,
    onTertiary: Color = 调色板令牌.Tertiary100,
    tertiaryContainer: Color = 调色板令牌.Tertiary90,
    onTertiaryContainer: Color = 调色板令牌.Tertiary10,
    background: Color = 调色板令牌.Neutral98,
    onBackground: Color = 调色板令牌.Neutral10,
    surface: Color = 调色板令牌.Neutral98,
    onSurface: Color = 调色板令牌.Neutral10,
    surfaceVariant: Color = 调色板令牌.NeutralVariant90,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant30,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral20,
    inverseOnSurface: Color = 调色板令牌.Neutral95,
    error: Color = 调色板令牌.Error40,
    onError: Color = 调色板令牌.Error100,
    errorContainer: Color = 调色板令牌.Error90,
    onErrorContainer: Color = 调色板令牌.Error10,
    outline: Color = 调色板令牌.NeutralVariant50,
    outlineVariant: Color = 调色板令牌.NeutralVariant80,
    scrim: Color = 调色板令牌.Neutral0,
    surfaceBright: Color = 调色板令牌.Neutral98,
    surfaceContainer: Color = 调色板令牌.Neutral94,
    surfaceContainerHigh: Color = 调色板令牌.Neutral92,
    surfaceContainerHighest: Color = 调色板令牌.Neutral90,
    surfaceContainerLow: Color = 调色板令牌.Neutral96,
    surfaceContainerLowest: Color = 调色板令牌.Neutral100,
    surfaceDim: Color = 调色板令牌.Neutral87,
    primaryFixed: Color = 调色板令牌.Primary90,
    primaryFixedDim: Color = 调色板令牌.Primary80,
    onPrimaryFixed: Color = 调色板令牌.Primary10,
    onPrimaryFixedVariant: Color = 调色板令牌.Primary30,
    secondaryFixed: Color = 调色板令牌.Secondary90,
    secondaryFixedDim: Color = 调色板令牌.Secondary80,
    onSecondaryFixed: Color = 调色板令牌.Secondary10,
    onSecondaryFixedVariant: Color = 调色板令牌.Secondary30,
    tertiaryFixed: Color = 调色板令牌.Tertiary90,
    tertiaryFixedDim: Color = 调色板令牌.Tertiary80,
    onTertiaryFixed: Color = 调色板令牌.Tertiary10,
    onTertiaryFixedVariant: Color = 调色板令牌.Tertiary30,
): ColorScheme =
    lightColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceDim = surfaceDim,
        primaryFixed = primaryFixed,
        primaryFixedDim = primaryFixedDim,
        onPrimaryFixed = onPrimaryFixed,
        onPrimaryFixedVariant = onPrimaryFixedVariant,
        secondaryFixed = secondaryFixed,
        secondaryFixedDim = secondaryFixedDim,
        onSecondaryFixed = onSecondaryFixed,
        onSecondaryFixedVariant = onSecondaryFixedVariant,
        tertiaryFixed = tertiaryFixed,
        tertiaryFixedDim = tertiaryFixedDim,
        onTertiaryFixed = onTertiaryFixed,
        onTertiaryFixedVariant = onTertiaryFixedVariant,
    )

/** Returns a dark Material color scheme. */
fun 深色颜色方案(
    primary: Color = 调色板令牌.Primary80,
    onPrimary: Color = 调色板令牌.Primary20,
    primaryContainer: Color = 调色板令牌.Primary30,
    onPrimaryContainer: Color = 调色板令牌.Primary90,
    inversePrimary: Color = 调色板令牌.Primary40,
    secondary: Color = 调色板令牌.Secondary80,
    onSecondary: Color = 调色板令牌.Secondary20,
    secondaryContainer: Color = 调色板令牌.Secondary30,
    onSecondaryContainer: Color = 调色板令牌.Secondary90,
    tertiary: Color = 调色板令牌.Tertiary80,
    onTertiary: Color = 调色板令牌.Tertiary20,
    tertiaryContainer: Color = 调色板令牌.Tertiary30,
    onTertiaryContainer: Color = 调色板令牌.Tertiary90,
    background: Color = 调色板令牌.Neutral6,
    onBackground: Color = 调色板令牌.Neutral90,
    surface: Color = 调色板令牌.Neutral6,
    onSurface: Color = 调色板令牌.Neutral90,
    surfaceVariant: Color = 调色板令牌.NeutralVariant30,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant80,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral90,
    inverseOnSurface: Color = 调色板令牌.Neutral20,
    error: Color = 调色板令牌.Error80,
    onError: Color = 调色板令牌.Error20,
    errorContainer: Color = 调色板令牌.Error30,
    onErrorContainer: Color = 调色板令牌.Error90,
    outline: Color = 调色板令牌.NeutralVariant60,
    outlineVariant: Color = 调色板令牌.NeutralVariant30,
    scrim: Color = 调色板令牌.Neutral0,
    surfaceBright: Color = 调色板令牌.Neutral24,
    surfaceContainer: Color = 调色板令牌.Neutral12,
    surfaceContainerHigh: Color = 调色板令牌.Neutral17,
    surfaceContainerHighest: Color = 调色板令牌.Neutral22,
    surfaceContainerLow: Color = 调色板令牌.Neutral10,
    surfaceContainerLowest: Color = 调色板令牌.Neutral4,
    surfaceDim: Color = 调色板令牌.Neutral6,
    primaryFixed: Color = 调色板令牌.Primary90,
    primaryFixedDim: Color = 调色板令牌.Primary80,
    onPrimaryFixed: Color = 调色板令牌.Primary10,
    onPrimaryFixedVariant: Color = 调色板令牌.Primary30,
    secondaryFixed: Color = 调色板令牌.Secondary90,
    secondaryFixedDim: Color = 调色板令牌.Secondary80,
    onSecondaryFixed: Color = 调色板令牌.Secondary10,
    onSecondaryFixedVariant: Color = 调色板令牌.Secondary30,
    tertiaryFixed: Color = 调色板令牌.Tertiary90,
    tertiaryFixedDim: Color = 调色板令牌.Tertiary80,
    onTertiaryFixed: Color = 调色板令牌.Tertiary10,
    onTertiaryFixedVariant: Color = 调色板令牌.Tertiary30,
): ColorScheme =
    darkColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceDim = surfaceDim,
        primaryFixed = primaryFixed,
        primaryFixedDim = primaryFixedDim,
        onPrimaryFixed = onPrimaryFixed,
        onPrimaryFixedVariant = onPrimaryFixedVariant,
        secondaryFixed = secondaryFixed,
        secondaryFixedDim = secondaryFixedDim,
        onSecondaryFixed = onSecondaryFixed,
        onSecondaryFixedVariant = onSecondaryFixedVariant,
        tertiaryFixed = tertiaryFixed,
        tertiaryFixedDim = tertiaryFixedDim,
        onTertiaryFixed = onTertiaryFixed,
        onTertiaryFixedVariant = onTertiaryFixedVariant,
    )

/**
 * The Material color system contains pairs of colors that are typically used for the background and
 * content color inside a component. For example, a [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [背景颜色] to a 'background' color in this
 * [ColorScheme], and then will return the corresponding color used for content. For example, when
 * [背景颜色] is [ColorScheme.primary], this will return [ColorScheme.onPrimary].
 *
 * If [背景颜色] does not match a background color in the theme, this will return
 * [Color.Unspecified].
 *
 * @return the matching content color for [背景颜色]. If [背景颜色] is not present in
 *   the theme's [ColorScheme], then returns [Color.Unspecified].
 * @see 内容颜色为了
 */
@Stable
fun ColorScheme.内容颜色为了(背景颜色: Color): Color = this.contentColorFor(背景颜色)

/**
 * The Material color system contains pairs of colors that are typically used for the background and
 * content color inside a component. For example, a [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [背景颜色] to a 'background' color in this
 * [ColorScheme], and then will return the corresponding color used for content. For example, when
 * [背景颜色] is [ColorScheme.primary], this will return [ColorScheme.onPrimary].
 *
 * If [背景颜色] does not match a background color in the theme, this will return the current
 * value of [LocalContentColor] as a best-effort color.
 *
 * @return the matching content color for [背景颜色]. If [背景颜色] is not present in
 *   the theme's [ColorScheme], then returns the current value of [LocalContentColor].
 * @see ColorScheme.内容颜色为了
 */
@Composable
@ReadOnlyComposable
fun 内容颜色为了(背景颜色: Color) = contentColorFor(背景颜色)

/**
 * 在不同阴影级别（如 surface1 至 surface5）下计算表面的色调颜色。
 *
 * @param 阴影 用于计算颜色叠加层不透明度（alpha）的高程值。
 * @return 在 [ColorScheme.surface] 颜色之上，以 [ColorScheme.surfaceTint] 颜色的不透明度进行叠加后得到的颜色。
 */
@Stable
fun ColorScheme.表面颜色阴影(阴影: Dp): Color = this.surfaceColorAtElevation(阴影)

/**
 * 返回一套 Material 浅色配色方案。
 *
 * [材质表现主题] 的默认配色方案；若处于深色模式，请改用 [darkColorScheme]。
 *
 * Material 主题切换示例：在浅色与深色主题之间动态切换，展示表现性（Expressive）浅色配色方案与暗色主题的对比效果。
 */
@ExperimentalMaterial3ExpressiveApi
fun 表达性浅色颜色方案(): ColorScheme = expressiveLightColorScheme()

@Deprecated(
    message =
        "Maintained for binary compatibility. Use overload with additional Fixed roles instead",
    level = DeprecationLevel.HIDDEN,
)
/** 返回一套 Material 浅色配色方案。 */
fun 浅色颜色方案(
    primary: Color = 调色板令牌.Primary40,
    onPrimary: Color = 调色板令牌.Primary100,
    primaryContainer: Color = 调色板令牌.Primary90,
    onPrimaryContainer: Color = 调色板令牌.Primary10,
    inversePrimary: Color = 调色板令牌.Primary80,
    secondary: Color = 调色板令牌.Secondary40,
    onSecondary: Color = 调色板令牌.Secondary100,
    secondaryContainer: Color = 调色板令牌.Secondary90,
    onSecondaryContainer: Color = 调色板令牌.Secondary10,
    tertiary: Color = 调色板令牌.Tertiary40,
    onTertiary: Color = 调色板令牌.Tertiary100,
    tertiaryContainer: Color = 调色板令牌.Tertiary90,
    onTertiaryContainer: Color = 调色板令牌.Tertiary10,
    background: Color = 调色板令牌.Neutral98,
    onBackground: Color = 调色板令牌.Neutral10,
    surface: Color = 调色板令牌.Neutral98,
    onSurface: Color = 调色板令牌.Neutral10,
    surfaceVariant: Color = 调色板令牌.NeutralVariant90,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant30,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral20,
    inverseOnSurface: Color = 调色板令牌.Neutral95,
    error: Color = 调色板令牌.Error40,
    onError: Color = 调色板令牌.Error100,
    errorContainer: Color = 调色板令牌.Error90,
    onErrorContainer: Color = 调色板令牌.Error10,
    outline: Color = 调色板令牌.NeutralVariant50,
    outlineVariant: Color = 调色板令牌.NeutralVariant80,
    scrim: Color = 调色板令牌.Neutral0,
    surfaceBright: Color = 调色板令牌.Neutral98,
    surfaceContainer: Color = 调色板令牌.Neutral94,
    surfaceContainerHigh: Color = 调色板令牌.Neutral92,
    surfaceContainerHighest: Color = 调色板令牌.Neutral90,
    surfaceContainerLow: Color = 调色板令牌.Neutral96,
    surfaceContainerLowest: Color = 调色板令牌.Neutral100,
    surfaceDim: Color = 调色板令牌.Neutral87,
): ColorScheme =
    浅色颜色方案(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceDim = surfaceDim,
    )

@Deprecated(
    message =
        "Maintained for binary compatibility. Use overload with additional surface roles instead",
    level = DeprecationLevel.HIDDEN,
)
fun 浅色颜色方案(
    primary: Color = 调色板令牌.Primary40,
    onPrimary: Color = 调色板令牌.Primary100,
    primaryContainer: Color = 调色板令牌.Primary90,
    onPrimaryContainer: Color = 调色板令牌.Primary10,
    inversePrimary: Color = 调色板令牌.Primary80,
    secondary: Color = 调色板令牌.Secondary40,
    onSecondary: Color = 调色板令牌.Secondary100,
    secondaryContainer: Color = 调色板令牌.Secondary90,
    onSecondaryContainer: Color = 调色板令牌.Secondary10,
    tertiary: Color = 调色板令牌.Tertiary40,
    onTertiary: Color = 调色板令牌.Tertiary100,
    tertiaryContainer: Color = 调色板令牌.Tertiary90,
    onTertiaryContainer: Color = 调色板令牌.Tertiary10,
    background: Color = 调色板令牌.Neutral98,
    onBackground: Color = 调色板令牌.Neutral10,
    surface: Color = 调色板令牌.Neutral98,
    onSurface: Color = 调色板令牌.Neutral10,
    surfaceVariant: Color = 调色板令牌.NeutralVariant90,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant30,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral20,
    inverseOnSurface: Color = 调色板令牌.Neutral95,
    error: Color = 调色板令牌.Error40,
    onError: Color = 调色板令牌.Error100,
    errorContainer: Color = 调色板令牌.Error90,
    onErrorContainer: Color = 调色板令牌.Error10,
    outline: Color = 调色板令牌.NeutralVariant50,
    outlineVariant: Color = 调色板令牌.NeutralVariant80,
    scrim: Color = 调色板令牌.Neutral0,
): ColorScheme =
    浅色颜色方案(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
    )

/** Returns a dark Material color scheme. */
@Deprecated(
    message =
        "Maintained for binary compatibility. Use overload with additional surface roles instead",
    level = DeprecationLevel.HIDDEN,
)
fun 深色颜色方案(
    primary: Color = 调色板令牌.Primary80,
    onPrimary: Color = 调色板令牌.Primary20,
    primaryContainer: Color = 调色板令牌.Primary30,
    onPrimaryContainer: Color = 调色板令牌.Primary90,
    inversePrimary: Color = 调色板令牌.Primary40,
    secondary: Color = 调色板令牌.Secondary80,
    onSecondary: Color = 调色板令牌.Secondary20,
    secondaryContainer: Color = 调色板令牌.Secondary30,
    onSecondaryContainer: Color = 调色板令牌.Secondary90,
    tertiary: Color = 调色板令牌.Tertiary80,
    onTertiary: Color = 调色板令牌.Tertiary20,
    tertiaryContainer: Color = 调色板令牌.Tertiary30,
    onTertiaryContainer: Color = 调色板令牌.Tertiary90,
    background: Color = 调色板令牌.Neutral6,
    onBackground: Color = 调色板令牌.Neutral90,
    surface: Color = 调色板令牌.Neutral6,
    onSurface: Color = 调色板令牌.Neutral90,
    surfaceVariant: Color = 调色板令牌.NeutralVariant30,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant80,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral90,
    inverseOnSurface: Color = 调色板令牌.Neutral20,
    error: Color = 调色板令牌.Error80,
    onError: Color = 调色板令牌.Error20,
    errorContainer: Color = 调色板令牌.Error30,
    onErrorContainer: Color = 调色板令牌.Error90,
    outline: Color = 调色板令牌.NeutralVariant60,
    outlineVariant: Color = 调色板令牌.NeutralVariant30,
    scrim: Color = 调色板令牌.Neutral0,
    surfaceBright: Color = 调色板令牌.Neutral24,
    surfaceContainer: Color = 调色板令牌.Neutral12,
    surfaceContainerHigh: Color = 调色板令牌.Neutral17,
    surfaceContainerHighest: Color = 调色板令牌.Neutral22,
    surfaceContainerLow: Color = 调色板令牌.Neutral10,
    surfaceContainerLowest: Color = 调色板令牌.Neutral4,
    surfaceDim: Color = 调色板令牌.Neutral6,
): ColorScheme =
    深色颜色方案(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceDim = surfaceDim,
    )

@Deprecated(
    message =
        "Maintained for binary compatibility. Use overload with additional surface roles instead",
    level = DeprecationLevel.HIDDEN,
)
fun 深色颜色方案(
    primary: Color = 调色板令牌.Primary80,
    onPrimary: Color = 调色板令牌.Primary20,
    primaryContainer: Color = 调色板令牌.Primary30,
    onPrimaryContainer: Color = 调色板令牌.Primary90,
    inversePrimary: Color = 调色板令牌.Primary40,
    secondary: Color = 调色板令牌.Secondary80,
    onSecondary: Color = 调色板令牌.Secondary20,
    secondaryContainer: Color = 调色板令牌.Secondary30,
    onSecondaryContainer: Color = 调色板令牌.Secondary90,
    tertiary: Color = 调色板令牌.Tertiary80,
    onTertiary: Color = 调色板令牌.Tertiary20,
    tertiaryContainer: Color = 调色板令牌.Tertiary30,
    onTertiaryContainer: Color = 调色板令牌.Tertiary90,
    background: Color = 调色板令牌.Neutral6,
    onBackground: Color = 调色板令牌.Neutral90,
    surface: Color = 调色板令牌.Neutral6,
    onSurface: Color = 调色板令牌.Neutral90,
    surfaceVariant: Color = 调色板令牌.NeutralVariant30,
    onSurfaceVariant: Color = 调色板令牌.NeutralVariant80,
    surfaceTint: Color = primary,
    inverseSurface: Color = 调色板令牌.Neutral90,
    inverseOnSurface: Color = 调色板令牌.Neutral20,
    error: Color = 调色板令牌.Error80,
    onError: Color = 调色板令牌.Error20,
    errorContainer: Color = 调色板令牌.Error30,
    onErrorContainer: Color = 调色板令牌.Error90,
    outline: Color = 调色板令牌.NeutralVariant60,
    outlineVariant: Color = 调色板令牌.NeutralVariant30,
    scrim: Color = 调色板令牌.Neutral0,
): ColorScheme =
    深色颜色方案(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
    )


/**
 * 用于检查 [ColorScheme.applyTonalElevation] 是否会在组合树向下传递时被应用的 CompositionLocal。
 *
 * 如果将该值设置为 false，组合树中所有后续的 Surface 将不再应用色调高程（tonalElevation）。
 */
@Suppress("CompositionLocalNaming")
val 本地色调阴影启用 = LocalTonalElevationEnabled
