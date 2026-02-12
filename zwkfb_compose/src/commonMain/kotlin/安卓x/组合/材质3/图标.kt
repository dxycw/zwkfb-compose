package 安卓x.组合.材质3

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 一个遵循 Material Design 的图标组件，使用指定的 [色调]（默认取 [LocalContentColor]）来绘制 [图像矢量]。
 * 如果 [图像矢量] 没有固有尺寸，该组件将采用推荐的默认图标大小。
 *
 * Icon 是一个“带主张”的组件，专为单色图标设计，以便它们能根据所处组件被正确着色。对于多色图标或不应着色的图标，请将 [色调] 设为 [Color.Unspecified]。
 * 对于不应着色、且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。 如需可点击的图标，请参见 [IconButton]。
 *
 * 如需进一步了解图标，请参阅 [Material Design 图标指南](https://m3.material.io/styles/icons/overview)。
 *
 * @param 图像矢量 在此图标内部绘制的 [ImageVector]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述此图标所代表的含义。除非图标仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 要应用于此图标的 [Modifier]。
 * @param 色调 要应用于 [图像矢量] 的色调（tint）。如果提供的是 [Color.Unspecified]，则不应用任何色调。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    图像矢量: ImageVector,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        imageVector = 图像矢量,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，使用指定的 [色调]（默认取 [LocalContentColor]）来绘制 [位图]。
 * 若 [位图] 没有固有尺寸，该组件将采用推荐的默认图标大小。
 *
 * Icon 是一个“带主张”的组件，专为单色图标设计，使它们能根据所处组件被正确着色。对于多色图标或不应着色的图标，请将 [色调] 设为 [Color.Unspecified]。
 * 对于不应着色、且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。如需可点击的图标，请参见 [IconButton]。
 *
 * 欲了解图标更多信息，请参阅 [Material Design 图标指南](https://m3.material.io/styles/icons/overview)。
 *
 * @param 位图 在此图标内绘制的 [ImageBitmap]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述此图标所代表的含义。除非图标仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 要应用于此图标的 [Modifier]。
 * @param 色调 要应用于[位图]的色调。如果提供的是[Color.Unspecified]，则不应用任何色调。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    位图: ImageBitmap,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        bitmap = 位图,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，使用指定的 [色调]（默认取 [LocalContentColor]）来绘制 [绘制器]。
 * 若 [绘制器] 没有固有尺寸，该组件将采用推荐的默认图标大小。
 *
 * Icon 是一个“带主张”的组件，专为单色图标设计，使它们能根据所处组件被正确着色。对于多色图标或不应着色的图标，请将 [色调] 设为 [Color.Unspecified]。
 * 对于不应着色、且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。如需可点击的图标，请参见 [IconButton]。
 *
 * 欲了解图标更多信息，请参阅 [Material Design 图标指南](https://m3.material.io/styles/icons/overview)。
 *
 * @param 绘制器 在此图标内部绘制的 [Painter]。
 * @param 内容描述 供无障碍服务使用的文本，用于描述此图标所代表的含义。除非图标仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 要应用于此图标的 [Modifier]。
 * @param 色调 要应用于 [绘制器] 的色调。如果提供的是 [Color.Unspecified]，则不应用任何色调。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    绘制器: Painter,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        painter = 绘制器,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，使用指定的 [色调] 来绘制 [绘制器]。若 [绘制器] 没有固有尺寸，该组件将采用推荐的默认图标大小。
 *
 * Icon 是一个“带主张”的组件，专为单色图标设计，使它们能根据所处组件被正确着色。对于多色图标或不应着色的图标，请将 [色调] 设为 null。
 * 对于不应着色、且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。如需可点击的图标，请参见 [IconButton]。
 *
 * 欲了解图标更多信息，请参阅 [Material Design 图标指南](https://m3.material.io/styles/icons/overview)。
 *
 * @param 绘制器 要在图标内部绘制的 [Painter]。
 * @param 色调 要应用于 [绘制器] 的色调。如果为 null，则不应用任何色调。
 * @param 内容描述 供无障碍服务使用的文本，用于描述此图标所代表的含义。除非图标仅作装饰用途，且不对应任何用户可执行的实质性操作，
 * 否则必须提供此文本。文本应进行本地化，例如通过 `[androidx.compose.ui.res.stringResource]` 或类似方式获取。
 * @param 修饰符 要应用于此图标的 [Modifier]。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    绘制器: Painter,
    色调: ColorProducer?,
    内容描述: String?,
    修饰符: Modifier = Modifier,
) {
    Icon(
        painter = 绘制器,
        tint = 色调,
        contentDescription = 内容描述,
        modifier = 修饰符,
    )
}


