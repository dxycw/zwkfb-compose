package 安卓x.组合.材质3

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * 显示文本并提供语义/可访问性信息的高级元素
 *
 * 默认的[样式]使用[MaterialTheme]/组件提供的[本地文本样式]。如果你要设置自己的样式，你可能需要先获取[本地文本样式]，
 * 并使用[TextStyle.copy]来保留任何主题定义的属性，只修改你想覆盖的特定属性。
 *
 * 为了使用方便，[TextStyle]中常用的参数也出现在这里。优先顺序如下：
 * - 如果在此明确设置了一个参数（即，它不是 `null` 或 [TextUnit.Unspecified]），则*该参数将始终被使用。
 * - 如果参数未设置（`null` 或 [TextUnit.Unspecified]），则将使用来自 [style] 的对应值。
 *
 * 此外，对于[颜色]，如果未设置[颜色]，并且[style]没有颜色，则*将使用[LocalContentColor]。
 *
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的[修饰符]
 * @param 颜色 应用于文本的[颜色]。如果是[Color.Unspecified]，且[style]未设置颜色， 此时将使用[LocalContentColor]。
 * @param 自动大小 为此文本可组合组件启用自动调整大小。查找可在可用空间中适用的最大字体大小，并使用该大小布局文本。
 * 这会执行多次布局遍历，可能比使用固定字体大小慢。这优先于通过[字体大小]和[style]定义的大小。参见[TextAutoSize]。
 * @param 字体大小 绘制文本时使用字形的大小。参见[TextStyle.fontSize]。
 * @param 字体样式 绘制字母时使用的字体变体类型（例如，斜体）。参见  [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时使用的字体系列。参见 [TextStyle.fontFamily]。
 * @param 字间距 在每个字母之间增加的空间量。参见 [TextStyle.letterSpacing]。
 * @param 文本装饰 文本上的装饰（例如下划线）。参见 [TextStyle.textDecoration]。
 * @param 文本对齐 段落中各行文字的对齐方式。参见 [TextStyle.textAlign]。
 * @param 行高 [Paragraph]中[TextUnit]单位的行高，例如SP或EM。参见 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处折断。如果为假，则文本中的字形将按无限水平空间进行定位。如果[软换行]为假，
 * [溢出]和TextAlign可能会有意外效果。
 * @param 最大行数 文本可跨越的可选最大行数，如有必要可换行。如果文本超过给定行数，将根据[溢出]和[软换行]进行截断。
 * 必须满足1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 最小高度以可见行的最少数量表示。要求 1 <= [最小行数] <= [最大行数]。
 * @param 文本布局回调 当计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本大小、
 * 基线和其他细节。回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 文本(
    文本: String,
    修饰符: Modifier = Modifier,
    颜色: Color = Color.Unspecified,
    自动大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    样式: TextStyle = 本地文本样式.current,
) {
    Text(
        text = 文本,
        modifier = 修饰符,
        color = 颜色,
        autoSize = 自动大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        onTextLayout = 文本布局回调,
        style = 样式
    )
}

/**
 * 显示文本并提供语义/可访问性信息的高级元素
 *
 * 默认的[样式]使用[MaterialTheme]/组件提供的[本地文本样式]。如果你要设置自己的样式，你可能需要先获取[本地文本样式]，
 * 并使用[TextStyle.copy]来保留任何主题定义的属性，只修改你想覆盖的特定属性。
 *
 * 为了使用方便，[TextStyle]中常用的参数也出现在这里。优先顺序如下：
 * - 如果在此明确设置了一个参数（即，它不是 `null` 或 [TextUnit.Unspecified]），则*该参数将始终被使用。
 * - 如果参数未设置（`null` 或 [TextUnit.Unspecified]），则将使用来自 [style] 的对应值。
 *
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的[修饰符]
 * @param 颜色 返回[Color]的[ColorProducer]。在提供频繁变化而无需重新组合的颜色值时非常有用。会覆盖[style]中提供的文本颜色
 * @param 自动大小 为此文本可组合组件启用自动调整大小。查找可在可用空间中适用的最大字体大小，并使用该大小布局文本。
 * 这会执行多次布局遍历，可能比使用固定字体大小慢。这优先于通过[字体大小]和[style]定义的大小。参见[TextAutoSize]。
 * @param 字体大小 绘制文本时使用字形的大小。参见[TextStyle.fontSize]。
 * @param 字体样式 绘制字母时使用的字体变体类型（例如，斜体）。参见 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时使用的字体系列。参见 [TextStyle.fontFamily]。
 * @param 字间距 在每个字母之间增加的空间量。参见 [TextStyle.letterSpacing]。
 * @param 文本装饰 文本上的装饰（例如下划线）。参见 [TextStyle.textDecoration]。
 * @param 文本对齐 段落中各行文字的对齐方式。参见 [TextStyle.textAlign]。
 * @param 行高 [Paragraph]中[TextUnit]单位的行高，例如SP或EM。参见 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处折断。如果为假，则文本中的字形将按无限水平空间进行定位。如果[软换行]为假，[溢出]和TextAlign可能会有意外效果。
 * @param 最大行数 文本可跨越的可选最大行数，如有必要可换行。如果文本超过给定行数，将根据[溢出]和[软换行]进行截断。
 * 必须满足1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 最小高度以可见行的最少数量表示。要求 1 <= [最小行数] <= [最大行数]。
 * @param 文本布局回调 当计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本大小、
 * 基线和其他细节。回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 文本(
    文本: String,
    颜色: ColorProducer,
    修饰符: Modifier = Modifier,
    自动大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    样式: TextStyle = 本地文本样式.current,
) {
    Text(
        text = 文本,
        color = 颜色,
        modifier = 修饰符,
        autoSize = 自动大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        onTextLayout = 文本布局回调,
        style = 样式
    )
}

/**
 * 显示文本并提供语义/可访问性信息的高级元素
 *
 * 默认的[样式]使用[MaterialTheme]/组件提供的[本地文本样式]。如果你要设置自己的样式，你可能需要先获取[本地文本样式]，
 * 并使用[TextStyle.copy]来保留任何主题定义的属性，只修改你想覆盖的特定属性。
 *
 * 为了使用方便，[TextStyle]中常用的参数也出现在这里。优先顺序如下：
 * - 如果在此明确设置了一个参数（即，它不是 `null` 或 [TextUnit.Unspecified]），则该参数将始终被使用。
 * - 如果参数未设置（`null` 或 [TextUnit.Unspecified]），则将使用来自 [style] 的对应值。
 *
 * 此外，对于[颜色]，如果未设置[颜色]，并且[style]没有颜色，则将使用[LocalContentColor]。
 *
 * 查看一个显示带有链接文本的示例，其中链接应用主题的样式：
 *
 * @sample androidx.compose.material3.samples.TextWithLinks
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的[修饰符]
 * @param 颜色 应用于文本的[颜色]。如果是[Color.Unspecified]，且[style]未设置颜色， 此时将使用[LocalContentColor]。
 * @param 自动大小 为此文本可组合组件启用自动调整大小。查找可在可用空间中适用的最大字体大小，并使用该大小布局文本。
 * 这会执行多次布局遍历，可能比使用固定字体大小慢。这优先于通过[字体大小]和[style]定义的大小。参见[TextAutoSize]。
 * @param 字体大小 绘制文本时使用字形的大小。参见[TextStyle.fontSize]。
 * @param 字体样式 绘制字母时使用的字体变体类型（例如，斜体）。参见 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时使用的字体系列。参见 [TextStyle.fontFamily]。
 * @param 字间距 在每个字母之间增加的空间量。参见 [TextStyle.letterSpacing]。
 * @param 文本装饰 文本上的装饰（例如下划线）。参见 [TextStyle.textDecoration]。
 * @param 文本对齐 段落中各行文字的对齐方式。参见 [TextStyle.textAlign]。
 * @param 行高 [Paragraph]中[TextUnit]单位的行高，例如SP或EM。参见 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处折断。如果为假，则文本中的字形将按无限水平空间进行定位。如果[软换行]为假，
 * [溢出]和TextAlign可能会有意外效果。
 * @param 最大行数 文本可跨越的可选最大行数，如有必要可换行。如果文本超过给定行数，将根据[溢出]和[软换行]进行截断。
 * 必须满足1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 最小高度以可见行的最少数量表示。要求 1 <= [最小行数] <= [最大行数]。
 * @param 内联内容 一个存储可组合元素的映射，用于替换文本的某些范围，用于 将可组合元素插入文本布局。见[InlineTextContent]。
 * @param 文本布局回调 当计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本大小、
 * 基线和其他细节。回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 文本(
    文本: AnnotatedString,
    修饰符: Modifier = Modifier,
    颜色: Color = Color.Unspecified,
    自动大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    文本布局回调: (TextLayoutResult) -> Unit = {},
    样式: TextStyle = 本地文本样式.current,
) {
    Text(
        text = 文本,
        modifier = 修饰符,
        color = 颜色,
        autoSize = 自动大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        onTextLayout = 文本布局回调,
        style = 样式
    )
}

/**
 * 显示文本并提供语义/可访问性信息的高级元素
 *
 * 默认的[样式]使用[MaterialTheme]/组件提供的[本地文本样式]。如果你要设置自己的样式，你可能需要先获取[本地文本样式]，
 * 并使用[TextStyle.copy]来保留任何主题定义的属性，只修改你想覆盖的特定属性。
 *
 * 为了使用方便，[TextStyle]中常用的参数也出现在这里。优先顺序如下：
 * - 如果在此明确设置了一个参数（即，它不是 `null` 或 [TextUnit.Unspecified]），则*该参数将始终被使用。
 * - 如果参数未设置（`null` 或 [TextUnit.Unspecified]），则将使用来自 [style] 的对应值。
 *
 * 查看一个显示带有链接文本的示例，其中链接应用主题的样式：
 *
 * @sample androidx.compose.material3.samples.TextWithLinks
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的[修饰符]
 * @param 颜色 返回[Color]的[ColorProducer]。在提供频繁变化而无需重新组合的颜色值时非常有用。会覆盖[style]中提供的文本颜色
 * @param 自动大小 为此文本可组合组件启用自动调整大小。查找可在可用空间中适用的最大字体大小，并使用该大小布局文本。
 * 这会执行多次布局遍历，可能比使用固定字体大小慢。这优先于通过[字体大小]和[style]定义的大小。参见[TextAutoSize]。
 * @param 字体大小 绘制文本时使用字形的大小。参见[TextStyle.fontSize]。
 * @param 字体样式 绘制字母时使用的字体变体类型（例如，斜体）。参见 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时使用的字体系列。参见 [TextStyle.fontFamily]。
 * @param 字间距 在每个字母之间增加的空间量。参见 [TextStyle.letterSpacing]。
 * @param 文本装饰 文本上的装饰（例如下划线）。参见 [TextStyle.textDecoration]。
 * @param 文本对齐 段落中各行文字的对齐方式。参见 [TextStyle.textAlign]。
 * @param 行高 [Paragraph]中[TextUnit]单位的行高，例如SP或EM。参见 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处折断。如果为假，则文本中的字形将按无限水平空间进行定位。如果[软换行]为假，
 * [溢出]和TextAlign可能会有意外效果。
 * @param 最大行数 文本可跨越的可选最大行数，如有必要可换行。如果文本超过给定行数，将根据[溢出]和[软换行]进行截断。
 * 必须满足1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 最小高度以可见行的最少数量表示。要求 1 <= [最小行数] <= [最大行数]。
 * @param 内联内容 一个存储可组合元素的映射，用于替换文本的某些范围，用于 将可组合元素插入文本布局。见[InlineTextContent]。
 * @param 文本布局回调 当计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本大小、
 * 基线和其他细节。回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 文本(
    文本: AnnotatedString,
    颜色: ColorProducer,
    修饰符: Modifier = Modifier,
    自动大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    文本布局回调: (TextLayoutResult) -> Unit = {},
    样式: TextStyle = 本地文本样式.current,
) {
    Text(
        text = 文本,
        color = 颜色,
        modifier = 修饰符,
        autoSize = 自动大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        onTextLayout = 文本布局回调,
        style = 样式
    )
}

/**
 * CompositionLocal包含首选的[TextStyle]，该样式将默认用于[文本]组件。要为此CompositionLocal设置值，请参阅[提供文本样式]，
 * 该方法将把任何缺失的[TextStyle]属性与此CompositionLocal中现有的[TextStyle]合并。
 *
 * @see 提供文本样式
 */
@Suppress("CompositionLocalNaming")
val 本地文本样式 = LocalTextStyle

// TODO(b/156598010): 删除此内容并使用备份 CompositionLocal 上的折叠定义替换
/**
 * 此函数用于设置[本地文本样式]的当前值，将给定样式与缺失属性的当前样式值合并。此组件的[内容]中包含的任何[文本]
 * 组件将使用此样式，除非有明确的样式设置。
 * @see 本地文本样式
 */
@Suppress("ComposableNaming")
@Composable
fun 提供文本样式(值: TextStyle, 内容: @Composable () -> Unit) {
    ProvideTextStyle(value = 值, content = 内容)
}


