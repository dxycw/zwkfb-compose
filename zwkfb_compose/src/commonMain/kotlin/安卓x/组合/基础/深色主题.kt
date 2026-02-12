package 安卓x.组合.基础

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * 返回操作系统是否处于暗色主题
 *
 * 此函数用于帮助构建遵循系统设置的响应式界面，避免在应用切换时出现生硬的对比度变化。
 *
 * 建议在应用顶层使用此函数，用来创建主题对象（例如一套颜色集），并沿层级向下提供。这样，各屏幕和组件无需关心系统的主题设置，
 * 只需从主题对象中读取属性即可；同时也更方便支持用户手动覆盖，例如强制浅色/深色模式而忽略系统设置。
 *
 * @return 如果系统被认为处于“深色主题”，则为`true`。
 */
@Composable
@ReadOnlyComposable
fun 是否系统为深色主题(): Boolean = isSystemInDarkTheme()

