package 安卓x.组合.材质3

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.ReadOnlyComposable

/**
 * Material Theming 指的是对你的 Material Design 应用进行定制，使其更好地体现产品品牌特色。
 *
 * Material 组件（如 [Button] 和 [Checkbox]）在获取默认值时会使用此处提供的值。
 *
 * 你可以通过为 材质主题 提供 [ColorScheme][颜色方案]、[Typography][排版] 和 [Shapes][形状] 属性来设定所有值，
 * 从而配置该 材质主题 内部元素的整体主题。
 *
 * 任何未显式设置的值都会从上层主题继承；若不存在父级 材质主题，则回退至默认值。这样你就可以在应用顶层放置一个 材质主题，
 * 然后在不同屏幕或 UI 片段中再嵌套新的 材质主题，仅覆盖需要变动的主题部分即可。
 *
 * @param 颜色方案 该层级完整的 Material 颜色主题定义。
 * @param 形状 一组圆角形状，用作该层级的形状系统。
 * @param 排版 一组文本样式，用作该层级的排版系统。
 * @param 内容 继承此主题的内容。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 材质主题(
    颜色方案: ColorScheme = 材质主题.颜色方案,
    形状: Shapes = 材质主题.形状,
    排版: Typography = 材质主题.排版,
    内容: @Composable () -> Unit,
) =
    材质主题(
        颜色方案 = 颜色方案,
        动效方案 = 材质主题.动效方案,
        形状 = 形状,
        排版 = 排版,
        内容 = 内容,
    )

/**
 * Material 主题定制（Material Theming）是指对 Material Design 应用进行个性化调整，使其更准确地体现产品品牌风格。
 *
 * Material 组件（如 [Button] 和 [Checkbox]）在获取默认值时会使用此处提供的值。
 *
 * 你可以通过为 材质主题 指定 [ColorScheme][颜色方案] 和 [Typography][排版] 属性来设定所有值，从而配置该 材质主题 内部元素的整体主题。
 *
 * 任何未显式设置的值都会自动继承上层主题的对应值；若无父级 材质主题，则回退至默认值。
 * 因此，你可以在应用顶层放置一个 材质主题，再于不同屏幕或 UI 片段中嵌套新的 材质主题，仅覆盖需要变动的主题部分即可。
 *
 * @param 颜色方案 该层级完整的 Material 颜色主题定义。
 * @param 动效方案 该层级完整的 Material 动效方案定义。
 * @param 形状 一组圆角形状，用作该层级的形状系统。
 * @param 排版 一组文本样式，用作该层级的排版系统。
 * @param 内容 继承此主题的内容。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 材质主题(
    颜色方案: ColorScheme = 材质主题.颜色方案,
    动效方案: MotionScheme = 材质主题.动效方案,
    形状: Shapes = 材质主题.形状,
    排版: Typography = 材质主题.排版,
    内容: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = 颜色方案,
        motionScheme = 动效方案,
        shapes = 形状,
        typography = 排版,
        content = 内容,
    )
}

/**
 * 包含用于访问在调用点所处层级中提供的当前主题值的函数。
 */
object 材质主题 {
    /**
     * 获取调用点在当前层级位置处的 [颜色方案]。
     */
    val 颜色方案: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    /**
     * 获取调用点在当前层级位置处的 [Typography]。
     */
    val 排版: Typography
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography

    /**
     * 获取调用点在当前层级位置处的 [Shapes]。
     */
    val 形状: Shapes
        @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

    /** 获取调用点在当前层级位置处的 [MotionScheme]。 */
    @ExperimentalMaterial3ExpressiveApi
    val 动效方案: MotionScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.motionScheme

    /**
     * 一个只读的 `CompositionLocal`，负责为 Material 3 组件提供当前层级的 [MotionScheme]。
     *
     * 运动方案通常由 [MaterialTheme.motionScheme] 提供，也可以通过在外层再包裹一个 [材质主题] 来为特定 UI 子树覆盖该方案。
     *
     * 公开此 API 是为了让 `CompositionLocalConsumerModifierNode` 的实现内部也能取到运动值，但大多数情况下仍建议
     * 直接读取 [MaterialTheme.motionScheme] 中的运动值。
     */
    @ExperimentalMaterial3ExpressiveApi
    val 本地动效方案: CompositionLocal<MotionScheme>
        get() = MaterialTheme.LocalMotionScheme
}

/**
 * Material Expressive Theming 是指对 Material Design 应用进行个性化定制，使其更准确地体现产品品牌风格。
 *
 * Material 组件（如 [Button] 和 [Checkbox]）在获取默认值时会使用此处提供的值。
 *
 * 你可以通过为 材质主题 指定 [ColorScheme][颜色方案]、[Typography][排版] 和 [Shapes][形状] 属性来设定所有值，
 * 从而配置该 材质主题 内部元素的整体主题风格。
 *
 * 任何未设置的值都会回退到默认值。如需继承当前主题中的值，只需在后续调用中继续传入这些参数，并仅覆盖主题定义中需要更改的部分即可。
 *
 * 或者，仅在应用顶层调用一次此函数，随后在各个屏幕 / UI 片段中再调用 [材质主题]，只为需要变化的部分覆盖主题定义即可。
 * @param 颜色方案 针对该层级完整的 Material 颜色主题定义。
 * @param 动效方案 针对该层级完整的 Material 动效主题定义。
 * @param 形状 一组圆角形状，用作该层级的形状系统。
 * @param 排版 一组文字样式，用作该层级的排版系统。
 * @param 内容 继承此主题的内容。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 材质表现主题(
    颜色方案: ColorScheme? = null,
    动效方案: MotionScheme? = null,
    形状: Shapes? = null,
    排版: Typography? = null,
    内容: @Composable () -> Unit,
) {
    MaterialExpressiveTheme(
        colorScheme = 颜色方案,
        motionScheme = 动效方案 ,
        shapes = 形状,
        typography = 排版,
        content = 内容,
    )
}

