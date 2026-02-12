package 安卓x.组合.材质3

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalRuler
import androidx.compose.ui.layout.VerticalRuler
import androidx.compose.ui.unit.dp

/**
 * Material Design 徽标框（Badge Box）
 *
 * 徽章 用于展示动态信息，例如导航栏中的待处理请求数量。
 *
 * 徽章 可以仅显示图标，或包含简短文本。
 *
 * ![Badgeimage](https://developer.android.com/images/reference/androidx/compose/material3/badge.png)
 *
 * 常见用例是在导航栏项中显示 Badge。更多信息请参阅[Navigation Bar](https://m3.material.io/components/navigation-bar/overview)
 *
 * @param 徽章 要显示的徽标 —— 通常为 [徽章]
 * @param 修饰符 要应用于此 徽章盒 的 [Modifier]
 * @param 内容 此徽标将定位到的锚点
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 徽章盒(
    徽章: @Composable BoxScope.() -> Unit,
    修饰符: Modifier = Modifier,
    内容: @Composable BoxScope.() -> Unit,
) {
    BadgedBox(
        badge = 徽章,
        modifier = 修饰符,
        content = 内容,
    )
}

/**
 * 徽章 用于展示动态信息，例如导航栏中的待处理请求数量。
 *
 * 徽章 可以仅显示图标，或包含简短文本。
 *
 * ![Badgeimage](https://developer.android.com/images/reference/androidx/compose/material3/badge.png)
 *
 * 如需将 徽章 相对于文本或图标等内容进行正确放置，请参阅顶层布局 [徽章盒]。
 *
 * @param 修饰符 要应用于此 徽章 的 [Modifier]
 * @param 容器颜色 此 徽章 背景所用的颜色
 * @param 内容颜色 此 徽章 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，若 [容器颜色] 非主题中的颜色，则默认为当前 [LocalContentColor]。
 * @param 内容 可选的，在此 徽章 内部渲染的内容
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 徽章(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BadgeDefaults.containerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    内容: @Composable (RowScope.() -> Unit)? = null,
) {
    Badge(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        content = 内容,
    )
}

/** [徽章] 的默认容器颜色. */
object 徽章默认值 { //BadgeDefaults
    /** Badge 的默认容器颜色 */
    val 容器颜色: Color
        @Composable get() = BadgeDefaults.containerColor
}


//============================================================

/** Badge 的默认容器颜色 */
val BadgeDefaults.容器颜色: Color
    @Composable get() = this.containerColor

