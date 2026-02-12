package 安卓x.组合.材质3

import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.graphics.shapes.RoundedPolygon

// TODO 更新文档中的图片，使其指向加载指示器。
/**
 * 一个 Material Design 风格的加载指示器。
 *
 * 该版本加载指示器会根据 [进度] 值在其 [多边形] 形状之间进行形变。
 *
 * 可以这样创建：
 *
 * @param 进度 此加载指示器的进度值，其中 0.0 表示无进度，1.0 表示完成。超出该范围的值将被强制限制在此范围内。
 * 指示器会根据进度值在提供的 [多边形] 形状之间进行形变。
 * @param 修饰符 应用于该加载指示器的 [Modifier]。
 * @param 颜色 加载指示器的颜色
 * @param 多边形 一个 [RoundedPolygon] 列表，定义该加载指示器从 0.0 到 1.0 进度过程中形变的形状序列。列表中至少需要包含两个形状。
 * @throws IllegalArgumentException 如果 [多边形] 列表中的项少于两个
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 加载指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = 加载指示器默认值.指示器颜色,
    多边形: List<RoundedPolygon> = 加载指示器默认值.确定指示器多边形,
) =
    LoadingIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        polygons = 多边形,
    )

// TODO 更新文档中的图片，使其指向加载指示器。.
/**
 * 一个 Material Design 风格的加载指示器。
 *
 * 该版本加载指示器在可见期间会持续播放动画，并在多种形状之间不断形变。
 *
 * 可以这样创建：
 *
 * @param 修饰符 应用于该加载指示器的 [Modifier]。
 * @param 颜色 加载指示器的颜色
 * @param 多边形 一个 [RoundedPolygon] 列表，定义该加载指示器在动画过程中形变的形状序列。列表中至少需要包含两个形状。
 * @throws IllegalArgumentException 如果 [多边形] 列表中的项少于两个
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 加载指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = 加载指示器默认值.指示器颜色,
    多边形: List<RoundedPolygon> = 加载指示器默认值.不确定指示器多边形,
) =
    LoadingIndicator(
        modifier = 修饰符,
        color = 颜色,
        polygons = 多边形,
    )

// TODO 更新文档中的图片，使其指向加载指示器。
/**
 * 一个 Material Design 风格的内嵌加载指示器。
 *
 * 该版本加载指示器会根据 [进度] 值在其 [多边形] 形状之间进行形变。 此变体中的形状被包含在一个有颜色的 [容器形状] 内部。
 *
 * 可以这样创建：
 *
 * 它也可以像这样用作 [下拉刷新框] 的指示器：
 *
 * @param 进度 此加载指示器的进度值，其中 0.0 表示无进度，1.0 表示完成。超出该范围的值将被强制限制在此范围内。指示器会根据进度值在提供的 [多边形] 形状之间进行形变。
 * @param 修饰符 应用于该加载指示器的 [Modifier]。
 * @param 容器颜色 加载指示器容器的背景色。
 * @param 指示器颜色 加载指示器的颜色
 * @param 容器形状 加载指示器容器的外形（圆角、圆、切角等）。
 * @param 多边形 一个 [RoundedPolygon] 列表，定义该加载指示器从 0.0 到 1.0 进度过程中形变的形状序列。列表中至少需要包含两个形状。
 * @throws IllegalArgumentException 如果 [多边形] 列表中的项少于两个
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 容器加载指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    容器颜色: Color = 加载指示器默认值.容器容器颜色,
    指示器颜色: Color = 加载指示器默认值.容器指示器颜色,
    容器形状: Shape = 加载指示器默认值.容器形状,
    多边形: List<RoundedPolygon> = 加载指示器默认值.确定指示器多边形,
) =
    ContainedLoadingIndicator(
        progress = 进度,
        modifier = 修饰符,
        containerColor = 容器颜色,
        indicatorColor = 指示器颜色,
        containerShape = 容器形状,
        polygons = 多边形,
    )

// TODO 更新文档中的图片，使其指向加载指示器。
/**
 * 一个 Material Design 风格的内嵌加载指示器。
 *
 * 该版本加载指示器在可见期间会持续播放动画，并在多种形状之间不断形变。 此变体中的形状被包含在一个有颜色的 [容器形状] 内部。
 *
 * 可以这样创建：
 *
 * @param 修饰符 应用于该加载指示器的 [Modifier]。
 * @param 容器颜色 加载指示器容器的背景色。
 * @param 指示器颜色 加载指示器的颜色
 * @param 容器形状 加载指示器容器的外形（圆角、圆、切角等）。
 * @param 多边形 一个 [RoundedPolygon] 列表，定义该加载指示器在动画过程中形变的形状序列。列表中至少需要包含两个形状。
 * @throws IllegalArgumentException 如果 [多边形] 列表中的项少于两个
 */
@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 容器加载指示器(
    修饰符: Modifier = Modifier,
    容器颜色: Color = 加载指示器默认值.容器容器颜色,
    指示器颜色: Color = 加载指示器默认值.容器指示器颜色,
    容器形状: Shape = 加载指示器默认值.容器形状,
    多边形: List<RoundedPolygon> = 加载指示器默认值.不确定指示器多边形,
) =
    ContainedLoadingIndicator(
        modifier = 修饰符,
        containerColor = 容器颜色,
        indicatorColor = 指示器颜色,
        containerShape = 容器形状,
        polygons = 多边形,
    )


/** 包含 [加载指示器] 使用的默认值。 */
@ExperimentalMaterial3ExpressiveApi
object 加载指示器默认值 {

    /** [LoadingIndicator] 的默认容器宽度。 */
    val 容器宽度: Dp = LoadingIndicatorDefaults.ContainerWidth

    /** [LoadingIndicator] 的默认容器高度。 */
    val 容器高度: Dp = LoadingIndicatorDefaults.ContainerHeight

    /** [LoadingIndicator] 的默认活动指示器尺寸。 */
    val 指示器大小 = LoadingIndicatorDefaults.IndicatorSize

    /** [LoadingIndicator] 的默认容器 [Shape]。 */
    val 容器形状: Shape
        @Composable get() = LoadingIndicatorDefaults.containerShape

    /** 使用无容器 [LoadingIndicator] 时，其默认的活动指示器 [Color]。 */
    val 指示器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.indicatorColor

    /** 使用 [ContainedLoadingIndicator] 时，[LoadingIndicator] 的默认活动指示器 [Color]。 */
    val 容器指示器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.containedIndicatorColor

    /** 使用 [ContainedLoadingIndicator] 时，[LoadingIndicator] 的默认容器 [Color]。 */
    val 容器容器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.containedContainerColor

    /**
     * 不确定性 [LoadingIndicator] 在动画过程中将形变的 [RoundedPolygon] 序列。
     *
     * 默认情况下，不确定性加载指示器会在七种形状之间形变；调用 API 时你也可以提供自己的形状序列。
     */
    val 不确定指示器多边形 = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons

    /**
     * 确定性 [LoadingIndicator] 在动画过程中将形变的 [RoundedPolygon] 序列。随着进度从 0 增长到 1，指示器会在这些形状之间逐渐过渡。
     *
     * 默认情况下，确定性加载指示器只会在两个形状之间形变；调用 API 时你也可以提供自己的形状序列。
     */
    val 确定指示器多边形 = LoadingIndicatorDefaults.DeterminateIndicatorPolygons

}

//=========================================================================

/** [LoadingIndicator] 的默认容器宽度。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.容器宽度: Dp
    get() = this.ContainerWidth

/** [LoadingIndicator] 的默认容器高度。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.容器高度: Dp
    get() = this.ContainerHeight

/** [LoadingIndicator] 的默认活动指示器尺寸。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.指示器大小
    get() = this.IndicatorSize

/** [LoadingIndicator] 的默认容器 [Shape]。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.容器形状: Shape
    @Composable get() = this.containerShape

/** 使用无容器 [LoadingIndicator] 时，其默认的活动指示器 [Color]。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.指示器颜色: Color
    @Composable get() = this.indicatorColor

/** 使用 [ContainedLoadingIndicator] 时，[LoadingIndicator] 的默认活动指示器 [Color]。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.容器指示器颜色: Color
    @Composable get() = this.containedIndicatorColor

/** 使用 [ContainedLoadingIndicator] 时，[LoadingIndicator] 的默认容器 [Color]。 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.容器容器颜色: Color
    @Composable get() = this.containedContainerColor

/**
 * 不确定性 [LoadingIndicator] 在动画过程中将形变的 [RoundedPolygon] 序列。
 *
 * 默认情况下，不确定性加载指示器会在七种形状之间形变；调用 API 时你也可以提供自己的形状序列。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.不确定指示器多边形
    get() = this.IndeterminateIndicatorPolygons

/**
 * 确定性 [LoadingIndicator] 在动画过程中将形变的 [RoundedPolygon] 序列。随着进度从 0 增长到 1，指示器会在这些形状之间逐渐过渡。
 *
 * 默认情况下，确定性加载指示器只会在两个形状之间形变；调用 API 时你也可以提供自己的形状序列。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val LoadingIndicatorDefaults.确定指示器多边形
    get() = this.DeterminateIndicatorPolygons

