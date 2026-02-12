package 安卓x.组合.材质3

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme

/**
 * 创建一个浅色动态配色方案。
 *
 * 使用此函数可基于系统壁纸生成配色方案；当开发者更换壁纸时，该配色方案会随之更新。此动态方案为浅色主题变体。
 *
 * @param 上下文 获取系统资源数据所需的上下文。
 */
@RequiresApi(Build.VERSION_CODES.S)
fun 动态浅色颜色方案(上下文: Context): ColorScheme = dynamicLightColorScheme(context = 上下文)

/**
 * 创建一个深色动态配色方案。
 *
 * 使用此函数可基于系统壁纸生成配色方案；当开发者更换壁纸时，该配色方案会随之更新。此动态方案为深色主题变体。
 *
 * @param 上下文 获取系统资源数据所需的上下文。
 */
@RequiresApi(Build.VERSION_CODES.S)
fun 动态深色颜色方案(上下文: Context): ColorScheme = dynamicDarkColorScheme(context = 上下文)

