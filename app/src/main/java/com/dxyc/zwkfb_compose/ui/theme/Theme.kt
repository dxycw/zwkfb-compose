package com.dxyc.zwkfb_compose.ui.theme

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import 安卓x.组合.基础.是否系统为深色主题
import 安卓x.组合.材质3.动态浅色颜色方案
import 安卓x.组合.材质3.动态深色颜色方案
import 安卓x.组合.材质3.材质主题
import 安卓x.组合.材质3.浅色颜色方案
import 安卓x.组合.材质3.深色颜色方案

private val DarkColorScheme = 深色颜色方案(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = 浅色颜色方案(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* 其他可覆盖的默认颜色。
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AppTheme(
    深色主题: Boolean = 是否系统为深色主题(),
    动态颜色: Boolean = true,  // 动态颜色功能在Android 12及以上版本可用。
    内容: @Composable () -> Unit
) {
    val 颜色方案 = when {
        动态颜色 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val 上下文 = LocalContext.current
            if (深色主题) 动态深色颜色方案(上下文) else 动态浅色颜色方案(上下文)
        }
        深色主题 -> DarkColorScheme
        else -> LightColorScheme
    }
    材质主题(
        颜色方案 = 颜色方案,
        排版 = Typography,
        内容 = 内容
    )
}