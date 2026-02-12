package 安卓x.组合.材质3

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design divider](https://m3.material.io/components/divider/overview)
 *
 * 分隔线是一条细线，用于在列表和布局中分组内容。
 *
 * @param 修饰符 将应用于此分隔线的[修饰符]
 * @param 厚度 此分隔线的厚度。使用 [Dp.Hairline] 将无论屏幕密度如何，都生成单像素分隔线。
 * @param 颜色 此分隔线的颜色
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 水平分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = 分隔线默认值.厚度,
    颜色: Color = 分隔线默认值.颜色,
) =
    Canvas(修饰符.fillMaxWidth().height(厚度)) {
        drawLine(
            color = 颜色,
            strokeWidth = 厚度.toPx(),
            start = Offset(0f, 厚度.toPx() / 2),
            end = Offset(size.width, 厚度.toPx() / 2),
        )
    }



/**
 * [Material Design divider](https://m3.material.io/components/divider/overview)
 *
 * 分隔线是一条细线，用于在列表和布局中分组内容。
 *
 * @param 修饰符 将应用于此分隔线的[修饰符]。
 * @param 厚度 此分隔线的厚度。使用 [Dp.Hairline] 将无论屏幕密度如何都生成单像素分隔线。
 * @param 颜色 此分隔线的颜色
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 垂直分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = 分隔线默认值.厚度,
    颜色: Color = 分隔线默认值.颜色,
) =
    Canvas(修饰符.fillMaxHeight().width(厚度)) {
        drawLine(
            color = 颜色,
            strokeWidth = 厚度.toPx(),
            start = Offset(厚度.toPx() / 2, 0f),
            end = Offset(厚度.toPx() / 2, size.height),
        )
    }

@Suppress("ComposableNaming","ModifierParameter")
@Deprecated(
    message = "Renamed to HorizontalDivider",
    replaceWith = ReplaceWith("HorizontalDivider(modifier, thickness, color)"),
)
@Composable
fun 分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = 分隔线默认值.厚度,
    颜色: Color = 分隔线默认值.颜色,
) {
    val targetThickness =
        if (厚度 == Dp.Hairline) {
            (1f / LocalDensity.current.density).dp
        } else { 厚度 }
    Box(修饰符.fillMaxWidth().height(targetThickness).background(color = 颜色))
}

/** [分隔线]的默认值 */
object 分隔线默认值 {
    /** 分隔线的默认厚度。 */
    val 厚度: Dp = DividerDefaults.Thickness

    /** 分隔线的默认颜色。 */
    val 颜色: Color
        @Composable get() = DividerDefaults.color
}
