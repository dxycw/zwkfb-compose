package 安卓x.组合.基础

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

/**
 * 一个可组合项，用于对给定的 **[ImageBitmap]** 进行布局与绘制。该组件会尝试按照 **[ImageBitmap]** 原有的宽度和高度来确定自身尺寸；
 * 但也可通过可选的 **[Modifier]** 参数来调整尺寸或绘制额外内容（例如背景）。对于任何未指定的尺寸，将使用 **[ImageBitmap]** 的对应边长作为最小约束。
 *
 * 以下示例展示了 Image 可组合项的基本用法：在屏幕上定位并绘制一张 [ImageBitmap]。
 *
 * 若只需绘制 [ImageBitmap] 的某个矩形区域，可使用本示例中提供的、接收 [Painter] 参数的重载版本。
 *
 * @param 位图 要绘制的 [ImageBitmap]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述该图像所代表的内容。除非图像仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 用于调整布局逻辑或绘制装饰性内容（如背景）的 Modifier。
 * @param 对齐方式 可选的对齐参数，用于将 [ImageBitmap] 放置在由宽度和高度所定义的边界内。
 * @param 内容缩放 可选的缩放参数，用于在边界尺寸与 [ImageBitmap] 固有尺寸不一致时，确定所采用的宽高比缩放方式。
 * @param 透明度 可选的不透明度，用于在屏幕上渲染 [ImageBitmap] 时施加透明效果。
 * @param 颜色过滤器 可选的 ColorFilter，用于在屏幕上渲染 [ImageBitmap] 时施加颜色滤镜效果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@Deprecated(
    "Consider usage of the Image composable that consumes an optional FilterQuality parameter",
    level = DeprecationLevel.HIDDEN,
    replaceWith =
        ReplaceWith(
            expression =
                "Image(bitmap, contentDescription, modifier, alignment, contentScale, " +
                        "alpha, colorFilter, DefaultFilterQuality)",
            "androidx.compose.foundation",
            "androidx.compose.ui.graphics.DefaultAlpha",
            "androidx.compose.ui.Alignment",
            "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality",
            "androidx.compose.ui.layout.ContentScale.Fit",
        ),
)
@NonRestartableComposable
fun 图像(
    位图: ImageBitmap,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐方式: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色过滤器: ColorFilter? = null,
) {
    Image(
        bitmap = 位图,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐方式,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
    )
}

/**
 * 一个可组合项，用于对给定的 [ImageBitmap] 进行布局与绘制。它会优先按照 [ImageBitmap] 的原始宽高来确定自身尺寸；
 * 也可以通过可选的 [Modifier] 参数调整尺寸或绘制额外内容（如背景）。任何未指定的边长都会以 [ImageBitmap] 的对应边长作为最小约束。
 *
 * 以下示例展示了 Image 可组合项的基本用法：在屏幕上定位并绘制一张 [ImageBitmap]。
 *
 * 若用例仅需绘制 [ImageBitmap] 的某一矩形子区域，可使用本示例所示、接收 [Painter] 参数的重载版本。
 *
 * @param 位图 要绘制的 [ImageBitmap]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述该图像所代表的内容。除非图像仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 用于调整布局逻辑或绘制装饰性内容（如背景）的 Modifier。
 * @param 对齐方式 可选的对齐参数，用于将 [ImageBitmap] 放置在由宽度和高度所定义的边界内。
 * @param 内容缩放 可选的缩放参数，用于在边界尺寸与 [ImageBitmap] 固有尺寸不一致时，确定所采用的宽高比缩放方式。
 * @param 透明度 可选的不透明度，用于在屏幕上渲染 [ImageBitmap] 时施加透明效果。
 * @param 颜色过滤器 可选的 ColorFilter，用于在屏幕上渲染 [ImageBitmap] 时施加颜色滤镜效果。
 * @param 过滤质量 在将 [位图] 缩放并绘制到目标区域时所采用的采样算法。默认值为 [FilterQuality.Low]，即使用双线性采样算法进行缩放。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 图像(
    位图: ImageBitmap,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐方式: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色过滤器: ColorFilter? = null,
    过滤质量: FilterQuality = DefaultFilterQuality,
) {
    Image(
        bitmap = 位图,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐方式,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        filterQuality = 过滤质量,
    )
}

/**
 * 一个可组合项，用于对给定的 [ImageVector] 进行布局与绘制。它会优先按照 [ImageVector] 的原始宽高来确定自身尺寸；
 * 也可以通过可选的 [Modifier] 参数调整尺寸或绘制额外内容（如背景）。任何未指定的边长都会以 [ImageVector] 的对应边长作为最小约束。
 *
 * @param 图像矢量 要绘制的 [ImageVector]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述该图像所代表的内容。除非图像仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 用于调整布局逻辑或绘制装饰性内容（如背景）的 Modifier。
 * @param 对齐方式 可选的对齐参数，用于将 [ImageVector] 置于由宽度与高度所定义的边界内。
 * @param 内容缩放 可选的缩放参数，用于在边界尺寸与 [ImageVector] 固有尺寸不一致时，确定所采用的宽高比缩放方式。
 * @param 透明度 可选的不透明度，用于在屏幕上渲染 [ImageVector] 时施加透明效果。
 * @param 颜色过滤器 可选的 ColorFilter，用于在屏幕上渲染 [ImageVector] 时施加颜色滤镜效果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@NonRestartableComposable
fun 图像(
    图像矢量: ImageVector,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐方式: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色过滤器: ColorFilter? = null,
) =
    Image(
        imageVector = 图像矢量,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐方式,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
    )

/**
 * 创建一个可组合项，用于对给定的 [Painter] 进行布局与绘制。它会优先按照 [Painter] 的固有尺寸来确定自身大小；
 * 也可以通过可选的 [Modifier] 参数调整尺寸或绘制额外内容（如背景）。
 *
 * **注意**：Painter 可能不具备固有尺寸；因此，如果 Modifier 链中未提供任何 LayoutModifier，就可能导致 [Image]
 * 可组合项的宽高被设为零，从而无法绘制任何内容。这种情况会出现在那些始终试图填满边界的 Painter 实现（如 [ColorPainter]）中。
 *
 * @param 绘制器 绘制
 * @param 内容描述 供无障碍服务使用的文本，用于描述该图像所代表的内容。除非图像仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 用于调整布局逻辑或绘制装饰性内容（如背景）的 Modifier。
 * @param 对齐方式 可选的对齐参数，用于将 [Painter] 置于由宽度和高度所定义的边界内。
 * @param 内容缩放 可选的缩放参数，用于在边界尺寸与 [Painter] 固有尺寸不一致时，确定所采用的宽高比缩放方式。
 * @param 透明度 可选的不透明度，用于在屏幕上渲染 [Painter] 时施加透明效果；默认值为完全不透明。
 * @param 颜色过滤器 可选的 ColorFilter，用于在屏幕上渲染 [Painter] 时施加颜色滤镜效果。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图像(
    绘制器: Painter,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐方式: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色过滤器: ColorFilter? = null,
) {
    Image(
        painter = 绘制器,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐方式,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
    )
}
