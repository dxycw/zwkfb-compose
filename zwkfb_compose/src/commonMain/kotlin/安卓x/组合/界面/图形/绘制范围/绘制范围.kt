package 安卓x.组合.界面.图形.绘制范围

import androidx.compose.ui.graphics.drawscope.DrawContext
import androidx.compose.ui.graphics.drawscope.DrawScopeMarker
import androidx.compose.ui.graphics.drawscope.DrawTransform
import androidx.annotation.FloatRange
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.rotateRad
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.toIntSize
import 安卓x.组合.界面.图形.绘制范围.绘图范围.Companion.默认混合模式
import 安卓x.组合.界面.图形.绘制范围.绘图范围.Companion.默认过滤质量

/**
 * 同时将 [DrawScope] 坐标空间沿 x 轴平移 [左]、沿 y 轴平移 [上]，并调整当前绘制区域的尺寸。该方法会提供一个回调，
 * 使你能在修改后的坐标空间内继续下发绘制指令。调用后，[DrawScope] 的有效宽度将变为 **width - (left + right)**，
 * 高度将变为 **height - (top + bottom)**；回调执行完毕后，坐标空间会自动恢复到应用 inset 之前的状态。
 *
 * @param 左 左侧绘制边界的内缩像素数。
 * @param 上 顶部绘制边界的内缩像素数。
 * @param 右 右侧绘制边界的内缩像素数。
 * @param 下 底部绘制边界的内缩像素数。
 * @param 块 在 inset 坐标空间内下发绘制指令的 lambda 回调。
 */
inline fun DrawScope.内边距(
    左: Float,
    上: Float,
    右: Float,
    下: Float,
    块: DrawScope.() -> Unit,
) {
    this.inset(left = 左, top = 上, right = 右, bottom = 下,block = 块)
}


/**
 * 便捷方法：将 [DrawScope] 的四周边界统一内缩 [内边距] 像素。调用后，坐标空间会在代码块执行完毕自动恢复到内缩前的状态。
 *
 * @param 内边距 用于将左、上、右、下四个边界向内缩进的像素值。
 * @param 块 在修改后的坐标空间内下发额外绘制指令的 lambda 代码块。
 */
inline fun DrawScope.内边距(内边距: Float, 块: DrawScope.() -> Unit) {
    this.inset(inset = 内边距, block = 块)
}



/**
 * 便捷方法：将 [DrawScope] 的左右边界各内缩 [水平] 像素，上下边界各内缩 [垂直] 像素；代码块执行完毕后，坐标空间自动恢复到内缩前的状态。
 *
 * @param 水平 左右边界内缩的像素数，默认为 0。
 * @param 垂直 上下边界内缩的像素数，可选，默认 0。
 * @param 块 在修改后的坐标空间内下发额外绘制指令的 lambda 代码块。
 */
inline fun DrawScope.内边距(
    水平: Float = 0.0f,
    垂直: Float = 0.0f,
    块: DrawScope.() -> Unit,
) {
    inset(horizontal = 水平, vertical = 垂直, block = 块)
}

/**
 * 在 x 和 y 方向上分别按给定的像素增量平移坐标空间。
 *
 * @param 左 沿 x 轴平移坐标空间的像素值。
 * @param 上 沿 y 轴平移坐标空间的像素值。
 * @param 块 在已平移的坐标空间内下发绘制指令的 lambda 代码块。
 */
inline fun DrawScope.平移(左: Float = 0.0f, 上: Float = 0.0f, 块: DrawScope.() -> Unit) =
    this.translate(left = 左, top = 上, block = 块)


/**
 * 以给定的 轴 点为旋转中心，顺时针旋转当前变换矩阵（角度单位为度）。旋转过程中，轴 点坐标保持不变；lambda 执行完毕后，旋转效果自动撤销。
 *
 * @param 角度 顺时针旋转
 * @param 轴 旋转中心点坐标，默认为当前坐标空间的中心。
 * @param 块 在旋转后的坐标空间内下发绘制指令的 lambda 代码块。
 */
inline fun DrawScope.旋转(角度: Float, 轴: Offset = center, 块: DrawScope.() -> Unit) =
    this.rotate(degrees = 角度, pivot = 轴, block = 块)

/**
 * 以给定的 轴 点为旋转中心，按弧度顺时针旋转当前变换矩阵；旋转后 轴 点坐标保持不变。
 *
 * @param 弧度 顺时针旋转
 * @param 轴 旋转中心点坐标，默认为当前坐标空间的中心。
 * @param 块 在旋转后的坐标空间内下发绘制指令的 lambda 代码块。
 */
inline fun DrawScope.旋转半径(
    弧度: Float,
    轴: Offset = center,
    块: DrawScope.() -> Unit,
) = this.rotateRad(radians = 弧度, pivot = 轴, block = 块)


/**
 * 以给定的 轴 点为缩放中心，沿水平方向按第一参数、沿垂直方向按第二参数进行轴对齐缩放；缩放过程中，轴 点坐标保持不变。
 * 方法调用结束后，坐标空间自动恢复到缩放前的状态。
 *
 * @param 缩放X X 轴的缩放比例
 * @param 缩放Y Y 轴的缩放比例
 * @param 轴 缩放中心点坐标，默认为当前坐标空间的中心。
 * @param 块 用于在缩放后的坐标空间内下发绘制指令的 lambda 代码块。
 */
inline fun DrawScope.缩放(
    缩放X: Float,
    缩放Y: Float,
    轴: Offset = center,
    块: DrawScope.() -> Unit,
) = this.scale(scaleX = 缩放X, scaleY = 缩放Y, pivot = 轴, block = 块)

/**
 * 以给定的 轴 点为缩放中心，在水平方向和垂直方向进行相同的轴对齐缩放；缩放过程中，轴 点坐标保持不变。
 * 方法调用结束后，坐标空间自动恢复到缩放前的状态。
 *
 * @param 缩放 在 X、Y 两个方向上统一的缩放比例。
 * @param 轴 缩放中心点坐标，默认为当前坐标空间的中心。
 * @param 块 用于在缩放后的坐标空间内下发绘制指令的 lambda 代码块。
 */
inline fun DrawScope.缩放(缩放: Float, 轴: Offset = center, 块: DrawScope.() -> Unit) =
    this.scale(scale = 缩放, pivot = 轴, block = 块)

/**
 * 将裁剪区域缩小为当前裁剪区域与给定矩形（由 left、top、right、bottom 界定）的交集，并提供一个回调，用于在该裁剪区域内下发绘制指令；
 * 方法调用结束后，此裁剪效果自动撤销。
 *
 * 使用 [ClipOp.Difference] 可从当前裁剪区域中减去所提供的矩形区域。
 *
 * @param 左 裁剪矩形的左边界
 * @param 上 裁剪矩形的上边界
 * @param 右 裁剪矩形的右边界
 * @param 下 裁剪矩形的下边界
 * @param 裁剪操作 对给定边界执行的裁剪操作，默认为 [ClipOp.Intersect]。
 * @param 块 以 CanvasScope 为接收者作用域的 lambda 回调，用于在指定的裁剪区域内下发绘制指令。
 */
inline fun DrawScope.裁剪矩形(
    左: Float = 0.0f,
    上: Float = 0.0f,
    右: Float = size.width,
    下: Float = size.height,
    裁剪操作: ClipOp = ClipOp.Intersect,
    块: DrawScope.() -> Unit,
) = this.clipRect(left = 左, top = 上, right = 右, bottom = 下, clipOp = 裁剪操作, block = 块)

/**
 * 将裁剪区域缩减为当前裁剪区域与所给路径的交集，并提供一个回调，用于在该裁剪区域内下发绘制指令；方法调用结束后，此裁剪效果自动撤销。
 *
 * @param 路径 用于裁剪绘制内容的外形（路径）。
 * @param 裁剪操作 对给定边界执行的裁剪操作，默认为 [ClipOp.Intersect]。
 * @param 块 以 CanvasScope 为接收者作用域的 lambda 回调，用于在指定的裁剪区域内下发绘制指令。
 */
inline fun DrawScope.裁剪路径(
    路径: Path,
    裁剪操作: ClipOp = ClipOp.Intersect,
    块: DrawScope.() -> Unit,
) = this.clipPath(path = 路径, clipOp = 裁剪操作, block = 块)

/**
 * 提供直接操作底层 [Canvas] 的入口，便于在复用其他绘制逻辑时与 [DrawScope] 配合使用。
 *
 * @param 块 在提供的 [Canvas] 上执行绘制指令的 lambda 回调。
 */
inline fun DrawScope.绘制到画布(块: (Canvas) -> Unit) = this.drawIntoCanvas(block = 块)

/**
 * 执行一项或多项变换，并在应用这些变换的状态下执行绘制指令；调用结束后，自动恢复至变换前的状态。
 *
 * @param 变换块 在绘制操作执行前用于下发所需变换的回调。
 * @param 绘制块 在应用变换之后，用于下发绘制操作的回调。
 */
inline fun DrawScope.带变换执行(
    变换块: DrawTransform.() -> Unit,
    绘制块: DrawScope.() -> Unit,
) = this.withTransform(transformBlock = 变换块, drawBlock = 绘制块)

@Deprecated(
    message = "Please use a new overload accepting nullable GraphicsLayer",
    level = DeprecationLevel.HIDDEN,
)
inline fun DrawScope.绘制(
    密度: Density,
    布局方向: LayoutDirection,
    画布: Canvas,
    大小: Size,
    块: DrawScope.() -> Unit,
) = this.draw(density = 密度, layoutDirection = 布局方向, canvas = 画布, size = 大小, block = 块)


/**
 * 以当前 [DrawScope] 为接收者，在提供的 [Canvas] 上执行 lambda 中指定的绘制指令。
 *
 * @param 密度 用于将密度无关像素（dp）转换为实际绘制所需的原始像素的 [Density]。
 * @param 布局方向 正在绘制的布局的 [LayoutDirection]（布局方向）。
 * @param 画布 目标绘制画布
 * @param 大小 相对于当前画布平移后的边界，[DrawScope] 应在此范围内进行绘制。
 * @param 图形图层 当前正在绘制的 [GraphicsLayer]，若画布并非由 [GraphicsLayer] 提供（例如使用软件加速绘制），则可能为 null。
 * @param 块 在此 [DrawScope] 上执行绘制指令的 lambda 回调。
 */
inline fun DrawScope.绘制(
    密度: Density,
    布局方向: LayoutDirection,
    画布: Canvas,
    大小: Size,
    图形图层: GraphicsLayer? = null,
    块: DrawScope.() -> Unit,
) = this.draw(density = 密度, layoutDirection = 布局方向, canvas = 画布, size = 大小, graphicsLayer = 图形图层, block = 块)


/**
 * 使用提供的 [Canvas] 创建一个受控的绘制环境，以声明式、无状态的方式绘制形状与路径，无需调用方维护底层 [Canvas] 的状态信息。
 * [DrawScope] 实现还会提供尺寸信息，所有变换均相对于本地平移进行：左侧与顶部坐标始终为原点，右侧与底部坐标始终等于指定的宽高。
 * 绘制内容不会被裁剪，因此可以在指定边界之外进行绘制。
 */
@DrawScopeMarker
interface 绘图范围 : DrawScope {

    /**
     * 当前的 [DrawContext]，其中包含了构建绘制环境所需的各项依赖。
     */
    val 绘制上下文: DrawContext
        get() = drawContext

    /** 当前绘制环境边界的中心点 */
    val 中心: Offset
        get() = center

    /** 提供当前绘制环境的尺寸。 */
    val 大小: Size
        get() = size

    /** 正在绘制的布局的布局方向。 */
    val 布局方向: LayoutDirection
        get() = layoutDirection

    /**
     * 用指定画笔在两点之间绘制一条线（仅描边，不填充）。
     *
     * @param 画刷 要应用到线条上的颜色或填充。
     * @param 开始 待绘制线段的第一个点
     * @param 结束 待绘制线段的第二个点
     * @param 描边宽度 应用于该线段的描边宽度。
     * @param 端点样式 线段两端的端点样式处理。
     * @param 路径效果 可选的线段效果或图案。
     * @param 透明度 应用于画刷的不透明度，范围 0.0f（完全透明）到 1.0f（完全不透明）。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于 [画刷] 的混合算法。
     */
    fun 绘制线(
        画刷: Brush,
        开始: Offset,
        结束: Offset,
        描边宽度: Float = 描边.发丝线宽度,
        端点样式: StrokeCap = 描边.默认端点样式,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawLine(
        brush = 画刷,
        start = 开始,
        end = 结束,
        strokeWidth = 描边宽度,
        cap = 端点样式,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 用指定画笔在两点之间绘制一条线段，仅描边。
     *
     * @param 颜色 要应用到线段上的颜色。
     * @param 开始 待绘制线段的起点。
     * @param 结束 待绘制线段的终点。
     * @param 描边宽度 应用于该线段的描边宽度。
     * @param 端点样式 线段两端端点的处理方式。
     * @param 路径效果 可选的线段效果或图案。
     * @param 透明度 应用于该颜色的不透明度，取值范围 0.0f（完全透明）到 1.0f（完全不透明）。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于该颜色的混合算法。
     */
    fun 绘制线(
        颜色: Color,
        开始: Offset,
        结束: Offset,
        描边宽度: Float = 描边.发丝线宽度,
        端点样式: StrokeCap = 描边.默认端点样式,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawLine(
        color = 颜色,
        start = 开始,
        end = 结束,
        strokeWidth = 描边宽度,
        cap = 端点样式,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 绘制一个矩形，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
     *
     * @param 画刷 要应用到矩形的颜色或填充。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 要绘制的矩形的尺寸。
     * @param 透明度 应用于画刷的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 矩形是否使用描边或填充。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于目标的混合算法。
     */
    fun 绘制矩形(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawRect(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 绘制一个矩形，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
     *
     * @param 颜色 应用于矩形的颜色。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制矩形的尺寸。
     * @param 透明度 应用于该颜色的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 矩形是否使用描边或填充。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于目标的混合算法。
     */
    fun 绘制矩形(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawRect(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 将给定的 [ImageBitmap] 绘制到画布上，其左上角位于指定的 [Offset] 处；使用给定的 [Paint] 将图像合成到画布中。
     *
     * @param 图像 要绘制的 [ImageBitmap]。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 透明度 应用于 [图像] 的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 图像是否使用描边或填充。
     * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于目标的混合算法。
     */
    fun 绘制图像(
        图像: ImageBitmap,
        左上角: Offset = Offset.Zero,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawImage(
        image = 图像,
        topLeft = 左上角,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


    /**
     * 将给定图像中由 `src` 描述的子区域，绘制到画布上由 `dst` 指定的轴对齐矩形区域内。
     *
     * 如果未提供源矩形（`src`），则整张图像会被缩放并绘制到目标矩形（`dst`）区域内。
     *
     * @param 图像 要绘制的源图像。
     * @param 源偏移 可选偏移量，表示源图像待绘制区域的左上角起点；若未指定，默认使用源图像的原点 (0, 0)。
     * @param 源大小 可选的源图像绘制区域尺寸，相对于 [源偏移] 计算；若未指定，默认使用 [图像] 的完整宽高。
     * @param 目标偏移 可选偏移量，表示在目标画布上绘制图像的左上角位置；若未指定，默认使用当前平移后的原点 (0, 0)。
     * @param 目标大小 可选的目标绘制区域尺寸；若未指定，默认使用 [源大小]。
     * @param 透明度 应用于 [图像] 的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定图像是填充绘制还是作为矩形描边。
     * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于目标的混合算法。
     */
    @Deprecated(
        "Prefer usage of drawImage that consumes an optional FilterQuality parameter",
        level = DeprecationLevel.HIDDEN,
        replaceWith =
            ReplaceWith(
                "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, " +
                        "colorFilter, blendMode, FilterQuality.Low)",
                "androidx.compose.ui.graphics.drawscope",
                "androidx.compose.ui.graphics.FilterQuality",
            ),
    ) // 二进制 API 兼容性
    fun 绘制图像(
        图像: ImageBitmap,
        源偏移: IntOffset = IntOffset.Zero,
        源大小: IntSize = IntSize(图像.width, 图像.height),
        目标偏移: IntOffset = IntOffset.Zero,
        目标大小: IntSize = 源大小,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawImage(
        image = 图像,
        srcOffset = 源偏移,
        srcSize = 源大小,
        dstOffset = 目标偏移,
        dstSize = 目标大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 将给定图像中由 `src` 指定的子区域，绘制到画布上由 `dst` 指定的轴对齐矩形区域内。
     *
     * 如果未提供源矩形（`src`），则整张图像会被缩放并绘制到目标矩形（`dst`）区域内。
     *
     * @param 图像 要绘制的源图像。
     * @param 源偏移 可选偏移量，表示源图像待绘制区域的左上角起点；若未指定，默认使用源图像的原点 (0, 0)。
     * @param 源大小 可选的源图像绘制区域尺寸，相对于 [源偏移] 计算；若未指定，默认使用 [图像] 的完整宽高。
     * @param 目标偏移 可选偏移量，表示在目标画布上绘制图像的左上角位置；若未指定，默认使用当前平移后的原点 (0, 0)。
     * @param 目标大小 可选的目标绘制区域尺寸；若未指定，则默认使用 [源大小]。
     * @param 透明度 应用于 [图像] 的不透明度，取值范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定图像是填充绘制还是作为矩形描边。
     * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于目标的混合算法。默认值为 [默认混合模式]。
     * @param 过滤质量 对 [图像] 进行缩放并绘制到目标区域时所采用的采样算法。默认值为 [FilterQuality.Low]，即使用双线性采样算法。
     */
    fun 绘制图像(
        图像: ImageBitmap,
        源偏移: IntOffset = IntOffset.Zero,
        源大小: IntSize = IntSize(图像.width, 图像.height),
        目标偏移: IntOffset = IntOffset.Zero,
        目标大小: IntSize = 源大小,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
        过滤质量: FilterQuality = 默认过滤质量,
    ) = drawImage(
            image = 图像,
            srcOffset = 源偏移,
            srcSize = 源大小,
            dstOffset = 目标偏移,
            dstSize = 目标大小,
            alpha = 透明度,
            style = 样式,
            colorFilter = 颜色过滤器,
            blendMode = 混合模式,
            filterQuality = 过滤质量,
        )


    /**
     * 绘制一个圆角矩形，使用给定的大小、偏移量以及 X/Y 轴的圆角半径。矩形使用提供的 [Brush] 进行填充或描边，具体取决于给定的 [DrawStyle]。
     *
     * @param 画刷 要应用到圆角矩形的颜色或填充。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制矩形的尺寸。
     * @param 圆角半径 圆角矩形的圆角半径；若为负值，则自动视为 0。
     * @param 透明度 应用于圆角矩形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆角矩形使用描边还是填充。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制圆角矩形(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        圆角半径: CornerRadius = CornerRadius.Zero,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawRoundRect(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        cornerRadius = 圆角半径,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 使用给定的 [Paint] 绘制圆角矩形；矩形是填充、描边还是两者兼有，由 [Paint.style] 决定。
     *
     * @param 颜色 应用于圆角矩形的颜色。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制矩形的尺寸。
     * @param 圆角半径 圆角矩形的圆角半径；若为负值，则自动视为 0。
     * @param 透明度 应用于圆角矩形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆角矩形使用描边还是填充。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于颜色的混合算法。
     */
    fun 绘制圆角矩形(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        圆角半径: CornerRadius = CornerRadius.Zero,
        样式: DrawStyle = Fill,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawRoundRect(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        cornerRadius = 圆角半径,
        style = 样式,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 在指定的中心坐标和半径处绘制一个圆；若未提供中心点，则使用当前边界的中心。
     *
     * @param 画刷 要应用到圆的颜色或填充。
     * @param 半径 圆的半径。
     * @param 中心 待绘制圆的中心坐标。
     * @param 透明度 应用于圆形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆形使用描边还是填充。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制圆形(
        画刷: Brush,
        半径: Float = size.minDimension / 2.0f,
        中心: Offset = this.center,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawCircle(
        brush = 画刷,
        radius = 半径,
        center = 中心,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 在指定的中心坐标和半径处绘制一个圆；若未提供中心点，则使用当前边界的中心。
     *
     * @param 颜色 要应用到圆的颜色或填充。
     * @param 半径 圆的半径。
     * @param 中心 待绘制圆的中心坐标。
     * @param 透明度 应用于圆形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆形使用描边还是填充。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制圆形(
        颜色: Color,
        半径: Float = size.minDimension / 2.0f,
        中心: Offset = this.center,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawCircle(
        color = 颜色,
        radius = 半径,
        center = 中心,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 绘制一个椭圆，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
     *
     * @param 画刷 要应用于椭圆的颜色或填充。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制矩形的尺寸。
     * @param 透明度 应用于椭圆的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定椭圆使用描边还是填充。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制椭圆(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawOval(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 绘制一个椭圆，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
     *
     * @param 颜色 要应用到椭圆的颜色。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制矩形的尺寸。
     * @param 透明度 应用于椭圆的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定椭圆使用描边还是填充。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制椭圆(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawOval(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 在给定矩形内绘制一段圆弧。起始角度为 `startAngle`（0° 为矩形中心水平向右的点，顺时针为正方向），扫过角度为 `sweepAngle`，沿椭圆顺时针延伸。
     * 若 `useCenter = true`，圆弧两端与圆心相连，形成**扇形**；若 `useCenter = false`，圆弧不闭合，形成**弓形**。
     *
     * @param 画刷 要应用到圆弧的颜色或填充。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制圆弧的外接矩形尺寸。
     * @param 起始角度 起始角度，以度为单位；0° 对应 3 点钟方向（水平向右）。
     * @param 扫过角度 相对于 [起始角度] 顺时针绘制的圆弧角度大小（以度为单位）。
     * @param 使用中心 是否关闭圆弧的中心，形成一个圆扇区。否则，圆弧不关闭，形成一个圆片段。
     * @param 透明度 应用于圆弧的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆弧使用描边还是填充。
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于画刷的混合算法。
     */
    fun 绘制圆弧(
        画刷: Brush,
        起始角度: Float,
        扫过角度: Float,
        使用中心: Boolean,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawArc(
        brush = 画刷,
        startAngle = 起始角度,
        sweepAngle = 扫过角度,
        useCenter = 使用中心,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 在给定矩形内绘制一段圆弧。起始角度为 `startAngle`（0° 对应矩形中心水平向右的 3 点钟方向，顺时针角度增大），
     * 扫过角度为 `sweepAngle`，沿椭圆顺时针延伸。若 `useCenter = true`，圆弧两端与圆心相连，形成**扇形**；
     * 若 `useCenter = false`，圆弧不闭合，形成**弓形**。
     *
     * @param 颜色 应用于圆弧的颜色。
     * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
     * @param 大小 待绘制圆弧的外接矩形尺寸。
     * @param 起始角度 起始角度，以度为单位；0° 对应 3 点钟方向（水平向右）。
     * @param 扫过角度 相对于 [起始角度] 顺时针绘制的圆弧角度大小（以度为单位）。
     * @param 使用中心 标志位，指示是否将圆弧闭合至边界中心。若 `true`，圆弧两端与圆心相连，形成**扇形**；
     * 若 `false`，圆弧不闭合，形成**弓形**。
     * @param 透明度 应用于圆弧的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定圆弧使用描边还是填充。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 圆弧绘制时所应用的混合算法。
     */
    fun 绘制圆弧(
        颜色: Color,
        起始角度: Float,
        扫过角度: Float,
        使用中心: Boolean,
        左上角: Offset = Offset.Zero,
        大小: Size = this.size.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawArc(
        color = 颜色,
        startAngle = 起始角度,
        sweepAngle = 扫过角度,
        useCenter = 使用中心,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 使用给定的 [Color] 绘制指定 [Path]。该路径是填充、描边还是两者兼有，由 [DrawStyle] 控制；若采用填充，
     * 则路径中的子路径会被隐式闭合（参见 [Path.close]）。
     *
     * @param 路径 要绘制的路径。
     * @param 颜色 应用于路径的颜色。
     * @param 透明度 路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定路径是填充还是描边。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于路径的混合算法。
     */
    fun 绘制路径(
        路径: Path,
        颜色: Color,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawPath(
        path = 路径,
        color = 颜色,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 使用给定的 [Color] 绘制指定 [Path]。该路径是填充、描边还是两者兼有，由 [DrawStyle] 控制；若采用填充，
     * 则路径中的子路径会被隐式闭合（参见 [Path.close]）。
     *
     * @param 路径 要绘制的路径。
     * @param 画刷 应用于路径的画刷。
     * @param 透明度 路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 样式 指定路径是填充还是描边。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 应用于路径的混合算法。
     */
    fun 绘制路径(
        路径: Path,
        画刷: Brush,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawPath(
        path = 路径,
        brush = 画刷,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 按照给定的 [PointMode] 绘制一系列点。
     *
     * `points` 参数中的每个坐标均相对于当前原点进行偏移。
     *
     * @param 点集 按指定 [PointMode] 绘制的点列表。
     * @param 点模式 [PointMode]，用于指定点的绘制方式。
     * @param 颜色 要应用到点的颜色。
     * @param 透明度 应用于路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
     * @param 描边宽度 应用于线条的描边宽度。
     * @param 端点样式 线段两端的端点样式处理。
     * @param 路径效果 可选的点效果或图案。
     * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 路径绘制时所应用的混合算法。
     */
    fun 绘制点(
        点集: List<Offset>,
        点模式: PointMode,
        颜色: Color,
        描边宽度: Float = Stroke.HairlineWidth,
        端点样式: StrokeCap = StrokeCap.Butt,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawPoints(
        points = 点集,
        pointMode = 点模式,
        color = 颜色,
        strokeWidth = 描边宽度,
        cap = 端点样式,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 按照给定的 [PointMode] 绘制一系列点。
     *
     * `points` 参数中的每个坐标均相对于当前原点进行偏移。
     *
     * @param 点集 按指定 [PointMode] 绘制的点列表。
     * @param 点模式 [PointMode]，用于指定点的绘制方式。
     * @param 画刷 应用于点的画刷。
     * @param 描边宽度 应用于线条的描边宽度。
     * @param 端点样式 线段两端的端点样式处理。
     * @param 路径效果 可选的点效果或图案。
     * @param 透明度 应用于路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。.
     * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
     * @param 混合模式 路径绘制时所应用的混合算法。
     */
    fun 绘制点(
        点集: List<Offset>,
        点模式: PointMode,
        画刷: Brush,
        描边宽度: Float = Stroke.HairlineWidth,
        端点样式: StrokeCap = StrokeCap.Butt,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = 默认混合模式,
    ) = drawPoints(
        points = 点集,
        pointMode = 点模式,
        brush = 画刷,
        strokeWidth = 描边宽度,
        cap = 端点样式,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

    /**
     * 使用由所提供 [DrawScope] 中的 [Density]、[LayoutDirection] 和 [IntSize] 作为默认值，记录针对此 [GraphicsLayer] 实例的对应绘制指令。
     * 在此过程中，会将底层画布重定向到在该图层内部进行绘制，并在方法调用结束时恢复为原始画布。
     */
    fun GraphicsLayer.记录(
        大小: IntSize = this@绘图范围.size.toIntSize(),
        块: DrawScope.() -> Unit,
    ) = record(this@绘图范围, this@绘图范围.layoutDirection, 大小) {
            this@绘图范围.draw(
                // 我们可以直接使用 this@record.drawContext，因为 this@DrawScope 与 this@record 里的值是相同的。
                drawContext.density,
                drawContext.layoutDirection,
                drawContext.canvas,
                drawContext.size,
                drawContext.graphicsLayer,
                block = 块,
            )
        }

    companion object {

        /**
         * 默认混合模式，用于每个绘制操作，确保绘制内容覆盖在目标像素之上。
         */
        val 默认混合模式: BlendMode = DrawScope.DefaultBlendMode

        /**
         * 默认 FilterQuality，用于在缩放 [ImageBitmap] 对象时确定所采用的过滤算法；对应双线性过滤的默认行为。
         */
        val 默认过滤质量: FilterQuality = DrawScope.DefaultFilterQuality
    }
}

object 描边 {
    /** 宽度值，用于表示 1 像素的发丝描边。 */
    const val 发丝线宽度 = Stroke.HairlineWidth

    /** 与连接样式配合使用的默认斜接长度 */
    const val 默认斜接长度: Float = Stroke.DefaultMiter

    /** 默认线段端点样式 */
    val 默认端点样式 = Stroke.DefaultCap

    /** 线段与曲线段之间连接的默认转角样式。 */
    val 默认转角样式 = Stroke.DefaultJoin
}


//============================================================================


/**
 * 用指定画笔在两点之间绘制一条线（仅描边，不填充）。
 *
 * @param 画刷 要应用到线条上的颜色或填充。
 * @param 开始 待绘制线段的第一个点
 * @param 结束 待绘制线段的第二个点
 * @param 描边宽度 应用于该线段的描边宽度。
 * @param 端点样式 线段两端的端点样式处理。
 * @param 路径效果 可选的线段效果或图案。
 * @param 透明度 应用于画刷的不透明度，范围 0.0f（完全透明）到 1.0f（完全不透明）。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于 [画刷] 的混合算法。
 */
fun DrawScope.绘制线(
    画刷: Brush,
    开始: Offset,
    结束: Offset,
    描边宽度: Float = 描边.发丝线宽度,
    端点样式: StrokeCap = 描边.默认端点样式,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawLine(
    brush = 画刷,
    start = 开始,
    end = 结束,
    strokeWidth = 描边宽度,
    cap = 端点样式,
    pathEffect = 路径效果,
    alpha = 透明度,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 用指定画笔在两点之间绘制一条线段，仅描边。
 *
 * @param 颜色 要应用到线段上的颜色。
 * @param 开始 待绘制线段的起点。
 * @param 结束 待绘制线段的终点。
 * @param 描边宽度 应用于该线段的描边宽度。
 * @param 端点样式 线段两端端点的处理方式。
 * @param 路径效果 可选的线段效果或图案。
 * @param 透明度 应用于该颜色的不透明度，取值范围 0.0f（完全透明）到 1.0f（完全不透明）。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于该颜色的混合算法。
 */
fun DrawScope.绘制线(
    颜色: Color,
    开始: Offset,
    结束: Offset,
    描边宽度: Float = 描边.发丝线宽度,
    端点样式: StrokeCap = 描边.默认端点样式,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawLine(
    color = 颜色,
    start = 开始,
    end = 结束,
    strokeWidth = 描边宽度,
    cap = 端点样式,
    pathEffect = 路径效果,
    alpha = 透明度,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 绘制一个矩形，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
 *
 * @param 画刷 要应用到矩形的颜色或填充。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 要绘制的矩形的尺寸。
 * @param 透明度 应用于画刷的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 矩形是否使用描边或填充。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于目标的混合算法。
 */
fun DrawScope.绘制矩形(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawRect(
    brush = 画刷,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 绘制一个矩形，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
 *
 * @param 颜色 应用于矩形的颜色。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制矩形的尺寸。
 * @param 透明度 应用于该颜色的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 矩形是否使用描边或填充。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于目标的混合算法。
 */
fun DrawScope.绘制矩形(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawRect(
    color = 颜色,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 将给定的 [ImageBitmap] 绘制到画布上，其左上角位于指定的 [Offset] 处；使用给定的 [Paint] 将图像合成到画布中。
 *
 * @param 图像 要绘制的 [ImageBitmap]。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 透明度 应用于 [图像] 的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 图像是否使用描边或填充。
 * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于目标的混合算法。
 */
fun DrawScope.绘制图像(
    图像: ImageBitmap,
    左上角: Offset = Offset.Zero,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawImage(
    image = 图像,
    topLeft = 左上角,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)


/**
 * 将给定图像中由 `src` 描述的子区域，绘制到画布上由 `dst` 指定的轴对齐矩形区域内。
 *
 * 如果未提供源矩形（`src`），则整张图像会被缩放并绘制到目标矩形（`dst`）区域内。
 *
 * @param 图像 要绘制的源图像。
 * @param 源偏移 可选偏移量，表示源图像待绘制区域的左上角起点；若未指定，默认使用源图像的原点 (0, 0)。
 * @param 源大小 可选的源图像绘制区域尺寸，相对于 [源偏移] 计算；若未指定，默认使用 [图像] 的完整宽高。
 * @param 目标偏移 可选偏移量，表示在目标画布上绘制图像的左上角位置；若未指定，默认使用当前平移后的原点 (0, 0)。
 * @param 目标大小 可选的目标绘制区域尺寸；若未指定，默认使用 [源大小]。
 * @param 透明度 应用于 [图像] 的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定图像是填充绘制还是作为矩形描边。
 * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于目标的混合算法。
 */
@Deprecated(
    "Prefer usage of drawImage that consumes an optional FilterQuality parameter",
    level = DeprecationLevel.HIDDEN,
    replaceWith =
        ReplaceWith(
            "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, " +
                    "colorFilter, blendMode, FilterQuality.Low)",
            "androidx.compose.ui.graphics.drawscope",
            "androidx.compose.ui.graphics.FilterQuality",
        ),
) // 二进制 API 兼容性
fun DrawScope.绘制图像(
    图像: ImageBitmap,
    源偏移: IntOffset = IntOffset.Zero,
    源大小: IntSize = IntSize(图像.width, 图像.height),
    目标偏移: IntOffset = IntOffset.Zero,
    目标大小: IntSize = 源大小,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawImage(
    image = 图像,
    srcOffset = 源偏移,
    srcSize = 源大小,
    dstOffset = 目标偏移,
    dstSize = 目标大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 将给定图像中由 `src` 指定的子区域，绘制到画布上由 `dst` 指定的轴对齐矩形区域内。
 *
 * 如果未提供源矩形（`src`），则整张图像会被缩放并绘制到目标矩形（`dst`）区域内。
 *
 * @param 图像 要绘制的源图像。
 * @param 源偏移 可选偏移量，表示源图像待绘制区域的左上角起点；若未指定，默认使用源图像的原点 (0, 0)。
 * @param 源大小 可选的源图像绘制区域尺寸，相对于 [源偏移] 计算；若未指定，默认使用 [图像] 的完整宽高。
 * @param 目标偏移 可选偏移量，表示在目标画布上绘制图像的左上角位置；若未指定，默认使用当前平移后的原点 (0, 0)。
 * @param 目标大小 可选的目标绘制区域尺寸；若未指定，则默认使用 [源大小]。
 * @param 透明度 应用于 [图像] 的不透明度，取值范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定图像是填充绘制还是作为矩形描边。
 * @param 颜色过滤器 将 [图像] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于目标的混合算法。默认值为 [默认混合模式]。
 * @param 过滤质量 对 [图像] 进行缩放并绘制到目标区域时所采用的采样算法。默认值为 [FilterQuality.Low]，即使用双线性采样算法。
 */
fun DrawScope.绘制图像(
    图像: ImageBitmap,
    源偏移: IntOffset = IntOffset.Zero,
    源大小: IntSize = IntSize(图像.width, 图像.height),
    目标偏移: IntOffset = IntOffset.Zero,
    目标大小: IntSize = 源大小,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
    过滤质量: FilterQuality = 默认过滤质量,
) = this.drawImage(
    image = 图像,
    srcOffset = 源偏移,
    srcSize = 源大小,
    dstOffset = 目标偏移,
    dstSize = 目标大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
    filterQuality = 过滤质量,
)


/**
 * 绘制一个圆角矩形，使用给定的大小、偏移量以及 X/Y 轴的圆角半径。矩形使用提供的 [Brush] 进行填充或描边，具体取决于给定的 [DrawStyle]。
 *
 * @param 画刷 要应用到圆角矩形的颜色或填充。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制矩形的尺寸。
 * @param 圆角半径 圆角矩形的圆角半径；若为负值，则自动视为 0。
 * @param 透明度 应用于圆角矩形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆角矩形使用描边还是填充。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制圆角矩形(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    圆角半径: CornerRadius = CornerRadius.Zero,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawRoundRect(
    brush = 画刷,
    topLeft = 左上角,
    size = 大小,
    cornerRadius = 圆角半径,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 使用给定的 [Paint] 绘制圆角矩形；矩形是填充、描边还是两者兼有，由 [Paint.style] 决定。
 *
 * @param 颜色 应用于圆角矩形的颜色。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制矩形的尺寸。
 * @param 圆角半径 圆角矩形的圆角半径；若为负值，则自动视为 0。
 * @param 透明度 应用于圆角矩形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆角矩形使用描边还是填充。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于颜色的混合算法。
 */
fun DrawScope.绘制圆角矩形(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    圆角半径: CornerRadius = CornerRadius.Zero,
    样式: DrawStyle = Fill,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawRoundRect(
    color = 颜色,
    topLeft = 左上角,
    size = 大小,
    cornerRadius = 圆角半径,
    style = 样式,
    alpha = 透明度,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 在指定的中心坐标和半径处绘制一个圆；若未提供中心点，则使用当前边界的中心。
 *
 * @param 画刷 要应用到圆的颜色或填充。
 * @param 半径 圆的半径。
 * @param 中心 待绘制圆的中心坐标。
 * @param 透明度 应用于圆形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆形使用描边还是填充。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制圆形(
    画刷: Brush,
    半径: Float = size.minDimension / 2.0f,
    中心: Offset = this.center,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawCircle(
    brush = 画刷,
    radius = 半径,
    center = 中心,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 在指定的中心坐标和半径处绘制一个圆；若未提供中心点，则使用当前边界的中心。
 *
 * @param 颜色 要应用到圆的颜色或填充。
 * @param 半径 圆的半径。
 * @param 中心 待绘制圆的中心坐标。
 * @param 透明度 应用于圆形的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆形使用描边还是填充。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制圆形(
    颜色: Color,
    半径: Float = size.minDimension / 2.0f,
    中心: Offset = this.center,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawCircle(
    color = 颜色,
    radius = 半径,
    center = 中心,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 绘制一个椭圆，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
 *
 * @param 画刷 要应用于椭圆的颜色或填充。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制矩形的尺寸。
 * @param 透明度 应用于椭圆的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定椭圆使用描边还是填充。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制椭圆(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawOval(
    brush = 画刷,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 绘制一个椭圆，起点为给定偏移量（左上角）。若未指定偏移，则从当前平移后的原点开始绘制；若未指定尺寸，则使用当前环境的尺寸。
 *
 * @param 颜色 要应用到椭圆的颜色。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制矩形的尺寸。
 * @param 透明度 应用于椭圆的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定椭圆使用描边还是填充。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制椭圆(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawOval(
    color = 颜色,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 在给定矩形内绘制一段圆弧。起始角度为 `startAngle`（0° 为矩形中心水平向右的点，顺时针为正方向），扫过角度为 `sweepAngle`，沿椭圆顺时针延伸。
 * 若 `useCenter = true`，圆弧两端与圆心相连，形成**扇形**；若 `useCenter = false`，圆弧不闭合，形成**弓形**。
 *
 * @param 画刷 要应用到圆弧的颜色或填充。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制圆弧的外接矩形尺寸。
 * @param 起始角度 起始角度，以度为单位；0° 对应 3 点钟方向（水平向右）。
 * @param 扫过角度 相对于 [起始角度] 顺时针绘制的圆弧角度大小（以度为单位）。
 * @param 使用中心 是否关闭圆弧的中心，形成一个圆扇区。否则，圆弧不关闭，形成一个圆片段。
 * @param 透明度 应用于圆弧的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆弧使用描边还是填充。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于画刷的混合算法。
 */
fun DrawScope.绘制圆弧(
    画刷: Brush,
    起始角度: Float,
    扫过角度: Float,
    使用中心: Boolean,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawArc(
    brush = 画刷,
    startAngle = 起始角度,
    sweepAngle = 扫过角度,
    useCenter = 使用中心,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 在给定矩形内绘制一段圆弧。起始角度为 `startAngle`（0° 对应矩形中心水平向右的 3 点钟方向，顺时针角度增大），
 * 扫过角度为 `sweepAngle`，沿椭圆顺时针延伸。若 `useCenter = true`，圆弧两端与圆心相连，形成**扇形**；
 * 若 `useCenter = false`，圆弧不闭合，形成**弓形**。
 *
 * @param 颜色 应用于圆弧的颜色。
 * @param 左上角 相对于当前平移后原点 (0, 0) 的偏移量。
 * @param 大小 待绘制圆弧的外接矩形尺寸。
 * @param 起始角度 起始角度，以度为单位；0° 对应 3 点钟方向（水平向右）。
 * @param 扫过角度 相对于 [起始角度] 顺时针绘制的圆弧角度大小（以度为单位）。
 * @param 使用中心 标志位，指示是否将圆弧闭合至边界中心。若 `true`，圆弧两端与圆心相连，形成**扇形**；
 * 若 `false`，圆弧不闭合，形成**弓形**。
 * @param 透明度 应用于圆弧的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定圆弧使用描边还是填充。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 圆弧绘制时所应用的混合算法。
 */
fun DrawScope.绘制圆弧(
    颜色: Color,
    起始角度: Float,
    扫过角度: Float,
    使用中心: Boolean,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawArc(
    color = 颜色,
    startAngle = 起始角度,
    sweepAngle = 扫过角度,
    useCenter = 使用中心,
    topLeft = 左上角,
    size = 大小,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 使用给定的 [Color] 绘制指定 [Path]。该路径是填充、描边还是两者兼有，由 [DrawStyle] 控制；若采用填充，
 * 则路径中的子路径会被隐式闭合（参见 [Path.close]）。
 *
 * @param 路径 要绘制的路径。
 * @param 颜色 应用于路径的颜色。
 * @param 透明度 路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定路径是填充还是描边。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于路径的混合算法。
 */
fun DrawScope.绘制路径(
    路径: Path,
    颜色: Color,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawPath(
    path = 路径,
    color = 颜色,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 使用给定的 [Color] 绘制指定 [Path]。该路径是填充、描边还是两者兼有，由 [DrawStyle] 控制；若采用填充，
 * 则路径中的子路径会被隐式闭合（参见 [Path.close]）。
 *
 * @param 路径 要绘制的路径。
 * @param 画刷 应用于路径的画刷。
 * @param 透明度 路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 样式 指定路径是填充还是描边。
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 应用于路径的混合算法。
 */
fun DrawScope.绘制路径(
    路径: Path,
    画刷: Brush,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawPath(
    path = 路径,
    brush = 画刷,
    alpha = 透明度,
    style = 样式,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 按照给定的 [PointMode] 绘制一系列点。
 *
 * `points` 参数中的每个坐标均相对于当前原点进行偏移。
 *
 * @param 点集 按指定 [PointMode] 绘制的点列表。
 * @param 点模式 [PointMode]，用于指定点的绘制方式。
 * @param 颜色 要应用到点的颜色。
 * @param 透明度 应用于路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。
 * @param 描边宽度 应用于线条的描边宽度。
 * @param 端点样式 线段两端的端点样式处理。
 * @param 路径效果 可选的点效果或图案。
 * @param 颜色过滤器 将 [颜色] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 路径绘制时所应用的混合算法。
 */
fun DrawScope.绘制点(
    点集: List<Offset>,
    点模式: PointMode,
    颜色: Color,
    描边宽度: Float = Stroke.HairlineWidth,
    端点样式: StrokeCap = StrokeCap.Butt,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawPoints(
    points = 点集,
    pointMode = 点模式,
    color = 颜色,
    strokeWidth = 描边宽度,
    cap = 端点样式,
    pathEffect = 路径效果,
    alpha = 透明度,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)

/**
 * 按照给定的 [PointMode] 绘制一系列点。
 *
 * `points` 参数中的每个坐标均相对于当前原点进行偏移。
 *
 * @param 点集 按指定 [PointMode] 绘制的点列表。
 * @param 点模式 [PointMode]，用于指定点的绘制方式。
 * @param 画刷 应用于点的画刷。
 * @param 描边宽度 应用于线条的描边宽度。
 * @param 端点样式 线段两端的端点样式处理。
 * @param 路径效果 可选的点效果或图案。
 * @param 透明度 应用于路径的不透明度，范围 0.0f（完全透明）至 1.0f（完全不透明）。.
 * @param 颜色过滤器 将 [画刷] 绘制到目标时所应用的颜色过滤器。
 * @param 混合模式 路径绘制时所应用的混合算法。
 */
fun DrawScope.绘制点(
    点集: List<Offset>,
    点模式: PointMode,
    画刷: Brush,
    描边宽度: Float = Stroke.HairlineWidth,
    端点样式: StrokeCap = StrokeCap.Butt,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = 默认混合模式,
) = this.drawPoints(
    points = 点集,
    pointMode = 点模式,
    brush = 画刷,
    strokeWidth = 描边宽度,
    cap = 端点样式,
    pathEffect = 路径效果,
    alpha = 透明度,
    colorFilter = 颜色过滤器,
    blendMode = 混合模式,
)


/** 辅助方法，用于将所提供的尺寸按盒型宽度和高度的偏移量进行偏移。 */
private fun Size.offsetSize(offset: Offset): Size =
    Size(this.width - offset.x, this.height - offset.y)