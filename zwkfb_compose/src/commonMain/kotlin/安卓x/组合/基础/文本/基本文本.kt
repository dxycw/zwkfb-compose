package 安卓x.组合.基础.文本

import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

/**
 * 用于显示文本并提供语义/无障碍信息的基本元素。通常更推荐使用 `文本`，它是更上层的文本组件，
 * 已内置语义支持并会从主题中读取样式。
 *
 * @param 文本 要显示的文本。
 * @param 修饰符 应用于该布局节点的 [Modifier]。
 * @param 样式 文本的样式配置，如颜色、字体、行高等。
 * @param 文本布局回调 当新的文本布局计算完成后会被调用的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线等细节，
 * 可用于为文本添加额外装饰或功能，例如绘制选区。
 * @param 溢出 视觉溢出的处理方式。
 * @param 软换行 是否允许在“软换行符”处自动换行。若设为 `false`，文本将如同拥有无限水平空间般排布，不会主动折行。当 `软换行 = false` 时，
 * `溢出` 与 `TextAlign` 可能产生意料之外的效果。
 * @param 最大行数 文本允许的最大行数（可空）。若文本超过指定行数，将依据 `[溢出]` 与 `[软换行]` 进行截断。必须满足 `1 <= 最小行数 <= 最大行数`。
 * @param 最小行数 表示文本在高度方向上**最少要显示的行数**。必须满足 `1 <= 最小行数 <= 最大行数`。
 * @param 颜色 覆盖 [样式] 中指定的文本颜色。
 * @param 自动大小 为该文本启用**自动字号**功能：系统会在可用空间内**找到能放下的最大字体尺寸**并用来排版。此过程需要多次布局计算，性能比固定字号低。
 * 一旦启用，通过 `[样式]` 指定的字号将被忽略。详见 `androidx.compose.foundation.text.TextAutoSize` 及示例 `TextAutoSizeBasicTextSample`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 基本文本(
    文本: String,
    修饰符: Modifier = Modifier,
    样式: TextStyle = TextStyle.Default,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    颜色: ColorProducer? = null,
    自动大小: TextAutoSize? = null,
) =
    BasicText(
        text = 文本,
        modifier = 修饰符,
        style = 样式,
        onTextLayout = 文本布局回调,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        color = 颜色,
        autoSize = 自动大小,
    )


/**
 * 用于显示文本并提供语义/无障碍信息的基本元素。通常更推荐使用 `文本`，它是更上层的文本组件，已内置语义支持并会从主题中读取样式。
 *
 * @param 文本 要显示的文本。
 * @param 修饰符 应用于该布局节点的 [Modifier]。
 * @param 样式 文本的样式配置，如颜色、字体、行高等。
 * @param 文本布局回调 当新的文本布局计算完成后会被调用的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线等细节，
 * 可用于为文本添加额外装饰或功能，例如绘制选区。
 * @param 溢出 视觉溢出的处理方式。
 * @param 软换行 是否允许在“软换行符”处自动换行。若设为 `false`，文本将如同拥有无限水平空间般排布，不会主动折行。
 * 当 `软换行 = false` 时，`溢出` 与 `TextAlign` 可能产生意料之外的效果。
 * @param 最大行数 文本允许的最大行数（可空）。若文本超过指定行数，将依据 `[溢出]` 与 `[软换行]` 进行截断。
 * 必须满足 `1 <= minLines <= 最大行数`。
 * @param 最小行数 表示文本在高度方向上**最少要显示的行数**。必须满足 `1 <= 最小行数 <= 最大行数`。
 * @param 内联内容 一个用于存储“可组合项”的映射表，用来替换文本中的指定范围，从而把可组合项插入到文本布局中。
 * 详见 `androidx.compose.foundation.text.InlineTextContent`。
 * @param 颜色 覆盖 [样式] 中指定的文本颜色。
 * @param 自动大小 为该文本组件启用**自动字号**功能：系统会在可用空间内**找出能容纳的最大字体尺寸**并用于排版。由于需要多次布局计算，
 * 性能低于固定字号。启用后，`[样式]` 中指定的字号将被忽略。详见 `TextAutoSize` 及示例 `TextAutoSizeBasicTextSample`。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 基本文本(
    文本: AnnotatedString,
    修饰符: Modifier = Modifier,
    样式: TextStyle = TextStyle.Default,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    颜色: ColorProducer? = null,
    自动大小: TextAutoSize? = null,
) =
    BasicText(
        text = 文本,
        modifier = 修饰符,
        style = 样式,
        onTextLayout = 文本布局回调,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        color = 颜色,
        autoSize = 自动大小,
    )



