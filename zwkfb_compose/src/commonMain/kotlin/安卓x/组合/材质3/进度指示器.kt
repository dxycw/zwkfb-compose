package 安卓x.组合.材质3

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp

/**
 * [Material Design determinate linear progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器表示未指定的等待时间或显示过程的持续时间。
 *
 * 默认情况下，[进度] 值之间没有动画。你可以使用 [ProgressIndicatorDefaults.ProgressAnimationSpec] 作为默认
 * 推荐的 [AnimationSpec] 来实现进度动画，如下例所示：
 *
 * @param 进度 此进度指示器的进度值，其中 0.0 表示无进度，1.0 表示完成。超出该范围的值将被强制限制在此范围内。
 * @param 修饰符 应用于该进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 轨迹颜色 指示器后方轨道的颜色，当进度尚未覆盖到整个指示器区域时可见。
 * @param 描边端点 此进度指示器两端所使用的线条端点样式（stroke cap）。
 * @param 间隙大小 进度指示器与轨道之间的间隙大小。
 * @param 绘制停止指示器 用于绘制停止指示器的 lambda 表达式。请注意，自定义指示器实现也应支持 RTL（从右到左）布局。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 线性进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.线性颜色,
    轨迹颜色: Color = 进度指示器默认值.线性轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.线性描边端点,
    间隙大小: Dp = 进度指示器默认值.线性指示器轨迹间隙大小,
    绘制停止指示器: DrawScope.() -> Unit = {
        进度指示器默认值.绘制停止指示器(
            绘制范围 = this,
            停止大小 = 进度指示器默认值.线性轨迹停止指示器大小,
            颜色 = 颜色,
            描边端点 = 描边端点,
        )
    },
) {
    LinearProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
        drawStopIndicator = 绘制停止指示器,
    )
}

/**
 * [Material Design indeterminate linear progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表达未指定的等待时间或展示某个过程的持续时间。
 *
 * @param 修饰符 应用于该进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 轨迹颜色 指示器后方轨道的颜色，当进度尚未覆盖到整个指示器区域时可见。
 * @param 描边端点 此进度指示器两端所使用的线条端点样式（stroke cap）。
 * @param 间隙大小 进度指示器与轨道之间的间隙大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 线性进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.线性颜色,
    轨迹颜色: Color = 进度指示器默认值.线性轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.线性描边端点,
    间隙大小: Dp = 进度指示器默认值.线性指示器轨迹间隙大小,
) {
    LinearProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}

@Suppress("ComposableNaming","ModifierParameter")
@Deprecated(
    message = "Use the overload that takes `progress` as a lambda",
    replaceWith =
        ReplaceWith(
            "LinearProgressIndicator(\n" +
                    "progress = { progress },\n" +
                    "modifier = modifier,\n" +
                    "color = color,\n" +
                    "trackColor = trackColor,\n" +
                    "strokeCap = strokeCap,\n" +
                    ")"
        ),
)
@Composable
fun 线性进度指示器(
    进度: Float,
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.线性颜色,
    轨迹颜色: Color = 进度指示器默认值.线性轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.线性描边端点,
) =
    LinearProgressIndicator(
        progress = 进度 ,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
    )

/**
 * [Material Design determinate circular progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示未指定的等待时间或显示某个过程的持续时间。
 *
 * 默认情况下，[进度] 值之间没有动画。在动画化进度时，你可以使用 [ProgressIndicatorDefaults.ProgressAnimationSpec]
 * 作为默认推荐的 [AnimationSpec]，如下例所示：
 *
 * @param 进度 此进度指示器的进度值，其中 0.0 表示无进度，1.0 表示完成。超出该范围的值将被强制限制在此范围内。
 * @param 修饰符 应用于该进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 描边宽度 此进度指示器的描边宽度。
 * @param 轨迹颜色 指示器后方轨道的颜色，当进度尚未覆盖到整个指示器区域时可见。
 * @param 描边端点 此进度指示器两端所使用的线条端点样式（stroke cap）。
 * @param 间隙大小 进度指示器与轨道之间的间隙大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 圆形进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.圆形颜色,
    描边宽度: Dp = 进度指示器默认值.圆形描边宽度,
    轨迹颜色: Color = 进度指示器默认值.圆形确定轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.圆形确定描边端点,
    间隙大小: Dp = 进度指示器默认值.圆形指示器轨迹间隙大小,
) {
    CircularProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}

/**
 * [Material Design determinate circular progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示未指定的等待时间或显示某个过程的持续时间。
 *
 * @param 修饰符 应用于该进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 描边宽度 此进度指示器的描边宽度。
 * @param 轨迹颜色 指示器后方轨道的颜色，当进度尚未覆盖到整个指示器区域时可见。
 * @param 描边端点 此进度指示器两端所使用的线条端点样式（stroke cap）。
 * @param 间隙大小 进度指示器与轨道之间的间隙大小。
 */
@Suppress("ComposableNaming","ModifierParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 圆形进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.圆形颜色,
    描边宽度: Dp = 进度指示器默认值.圆形描边宽度,
    轨迹颜色: Color = 进度指示器默认值.圆形不确定轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.圆形进度指示器描边端点,
    间隙大小: Dp = 进度指示器默认值.圆形指示器轨迹间隙大小,
) {
    CircularProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}

@Suppress("DEPRECATION","ComposableNaming","ModifierParameter")
@Deprecated(
    message = "Use the overload that takes `progress` as a lambda",
    replaceWith =
        ReplaceWith(
            "CircularProgressIndicator(\n" +
                    "progress = { progress },\n" +
                    "modifier = modifier,\n" +
                    "color = color,\n" +
                    "strokeWidth = strokeWidth,\n" +
                    "trackColor = trackColor,\n" +
                    "strokeCap = strokeCap,\n" +
                    ")"
        ),
)
@Composable
fun 圆形进度指示器(
    进度: Float,
    修饰符: Modifier = Modifier,
    颜色: Color = 进度指示器默认值.圆形颜色,
    描边宽度: Dp = 进度指示器默认值.圆形描边宽度,
    轨迹颜色: Color = 进度指示器默认值.圆形轨道颜色,
    描边端点: StrokeCap = 进度指示器默认值.圆形确定描边端点,
) =
    CircularProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨迹颜色,
        strokeCap = 描边端点,
    )



/**
 * 包含 [线性进度指示器] 和 [圆形进度指示器] 所使用的默认值。
 */
object 进度指示器默认值 { //ProgressIndicatorDefaults
    /** 线性进度指示器的默认颜色。 */
    val 线性颜色: Color
        @Composable get() = ProgressIndicatorDefaults.linearColor

    /** 圆形进度指示器的默认颜色。 */
    val 圆形颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularColor

    /** 线性进度指示器的默认轨道颜色。 */
    val 线性轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.linearTrackColor

    /** 圆形进度指示器的默认轨道颜色。 */
    @Deprecated(
        "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor",
        ReplaceWith("ProgressIndicatorDefaults.circularIndeterminateTrackColor"),
        DeprecationLevel.WARNING,
    )
    val 圆形轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularTrackColor

    /** 圆形确定性进度指示器的默认轨道颜色。 */
    val 圆形确定轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularDeterminateTrackColor

    /** 圆形不确定性进度指示器的默认轨道颜色。 */
    val 圆形不确定轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularIndeterminateTrackColor

    /** 圆形进度指示器的默认描边宽度。 */
    val 圆形描边宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth

    /** 线性进度指示器的默认端点样式。*/
    val 线性描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap

    /** 确定性圆形进度指示器的默认描边端点样式。 */
    val 圆形确定描边端点: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap

    /** 不确定性圆形进度指示器的默认描边端点样式。 */
    val 圆形进度指示器描边端点: StrokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap

    /** 线性进度指示器的默认轨道停止指示器大小。 */
    @ExperimentalMaterial3Api
    val 线性轨迹停止指示器大小: Dp = ProgressIndicatorDefaults.LinearTrackStopIndicatorSize

    /** 线性进度指示器的默认指示器与轨道之间的间隙大小。 */
    @ExperimentalMaterial3Api
    val 线性指示器轨迹间隙大小: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize

    /** 圆形进度指示器的默认指示器与轨道之间的间隙大小。 */
    @ExperimentalMaterial3Api
    val 圆形指示器轨迹间隙大小: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize

    /**
     * 在确定性进度指示器中，用于在进度值之间进行动画的默认 [AnimationSpec]。
     */
    val 进度动画规范 = ProgressIndicatorDefaults.ProgressAnimationSpec

    /**
     * 在轨道末端绘制停止指示器。
     *
     * @param 绘制范围 [DrawScope]
     * @param 停止大小 此停止指示器的尺寸，其大小不能超过轨道的高度。
     * @param 颜色 此停止指示器的颜色。
     * @param 描边端点 此停止指示器两端所使用的描边端点样式。
     */
    fun 绘制停止指示器(绘制范围: DrawScope, 停止大小: Dp, 颜色: Color, 描边端点: StrokeCap) =
        ProgressIndicatorDefaults.drawStopIndicator(drawScope = 绘制范围, stopSize = 停止大小, color = 颜色, strokeCap = 描边端点)

}

//======================================================================


/** 线性进度指示器的默认颜色。 */
val ProgressIndicatorDefaults.线性颜色: Color
    @Composable get() = this.linearColor

/** 圆形进度指示器的默认颜色。 */
val ProgressIndicatorDefaults.圆形颜色: Color
    @Composable get() = this.circularColor

/** 线性进度指示器的默认轨道颜色。 */
val ProgressIndicatorDefaults.线性轨道颜色: Color
    @Composable get() = this.linearTrackColor

/** 圆形进度指示器的默认轨道颜色。 */
@Deprecated(
    "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor",
    ReplaceWith("ProgressIndicatorDefaults.circularIndeterminateTrackColor"),
    DeprecationLevel.WARNING,
)
val ProgressIndicatorDefaults.圆形轨道颜色: Color
    @Composable get() = this.circularTrackColor

/** 圆形确定性进度指示器的默认轨道颜色。 */
val ProgressIndicatorDefaults.圆形确定轨道颜色: Color
    @Composable get() = this.circularDeterminateTrackColor

/** 圆形不确定性进度指示器的默认轨道颜色。 */
val ProgressIndicatorDefaults.圆形不确定轨道颜色: Color
    @Composable get() = this.circularIndeterminateTrackColor

/** 圆形进度指示器的默认描边宽度。 */
val ProgressIndicatorDefaults.圆形描边宽度: Dp
    get() = this.CircularStrokeWidth

/** 线性进度指示器的默认端点样式。*/
val ProgressIndicatorDefaults.线性描边端点: StrokeCap
    get() = this.LinearStrokeCap

/** 确定性圆形进度指示器的默认描边端点样式。 */
val ProgressIndicatorDefaults.圆形确定描边端点: StrokeCap
    get() = this.CircularDeterminateStrokeCap

/** 不确定性圆形进度指示器的默认描边端点样式。 */
val ProgressIndicatorDefaults.圆形进度指示器描边端点: StrokeCap
    get() = this.CircularIndeterminateStrokeCap

/** 线性进度指示器的默认轨道停止指示器大小。 */
@ExperimentalMaterial3Api
val ProgressIndicatorDefaults.线性轨迹停止指示器大小: Dp
    get() = this.LinearTrackStopIndicatorSize

/** 线性进度指示器的默认指示器与轨道之间的间隙大小。 */
@ExperimentalMaterial3Api
val ProgressIndicatorDefaults.线性指示器轨迹间隙大小: Dp
    get() = this.LinearIndicatorTrackGapSize

/** 圆形进度指示器的默认指示器与轨道之间的间隙大小。 */
@ExperimentalMaterial3Api
val ProgressIndicatorDefaults.圆形指示器轨迹间隙大小: Dp
    get() = this.CircularIndicatorTrackGapSize

/**
 * 在确定性进度指示器中，用于在进度值之间进行动画的默认 [AnimationSpec]。
 */
val ProgressIndicatorDefaults.进度动画规范
    get() = this.ProgressAnimationSpec

/**
 * 在轨道末端绘制停止指示器。
 *
 * @param 绘制范围 [DrawScope]
 * @param 停止大小 此停止指示器的尺寸，其大小不能超过轨道的高度。
 * @param 颜色 此停止指示器的颜色。
 * @param 描边端点 此停止指示器两端所使用的描边端点样式。
 */
fun ProgressIndicatorDefaults.绘制停止指示器(绘制范围: DrawScope, 停止大小: Dp, 颜色: Color, 描边端点: StrokeCap) =
    this.drawStopIndicator(drawScope = 绘制范围, stopSize = 停止大小, color = 颜色, strokeCap = 描边端点)

