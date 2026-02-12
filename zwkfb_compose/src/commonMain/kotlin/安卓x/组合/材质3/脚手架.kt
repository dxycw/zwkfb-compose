package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [Material Design layout](https://m3.material.io/foundations/layout/understanding-layout/)
 *
 * 脚手架 实现了 Material Design 的基本视觉布局结构。
 *
 * 该组件提供 API，用于将多个 Material 组件组合成完整屏幕：它既保证这些组件的布局策略正确，又收集必要数据，使它们能够协同工作。
 *
 * 一个简单的 脚手架 示例，包含 [TopAppBar] 和 [FloatingActionButton]：
 *
 * 要显示 [Snackbar]，请使用 [SnackbarHostState.showSnackbar]。
 *
 * @param 修饰符 应用于该 脚手架 的 [Modifier]。
 * @param 顶部栏 屏幕的顶部应用栏，通常是一个 [TopAppBar]。
 * @param 底部栏 屏幕底部的导航栏，通常是一个 [NavigationBar]。
 * @param 提示条容器 用于承载通过 [SnackbarHostState.showSnackbar] 触发显示的 [Snackbar] 的组件，通常为 [SnackbarHost]。
 * @param 悬浮操作按钮 屏幕的主操作按钮，通常是一个 [FloatingActionButton]。
 * @param 悬浮操作按钮位置 FAB 在屏幕上的位置，参见 [FabPosition]。
 * @param 容器颜色 此 脚手架 背景所用的颜色。使用 [Color.Transparent] 表示无背景色。
 * @param 内容颜色 该 脚手架 内部内容的默认配色。若 [容器颜色] 来自主题调色板，则使用与之匹配的内容色；否则沿用当前 [LocalContentColor]。
 * @param 内容窗口插入 要传递给 [内容] 插槽的窗口边距（通过 [PaddingValues] 参数）。只有当 [顶部栏]或 [底部栏] 不存在时，
 * 脚手架 才会把对应方向的边距算进 [内容]；否则它假定由 [顶部栏]/[底部栏]自行处理边距。此外，若父级布局已通过其他 inset-padding
 * 修饰符或 [consumeWindowInsets] 消费过部分边距，这部分将不会出现在 [内容窗口插入] 中。
 * @param 内容 屏幕的内容区域。lambda 会收到一个 [PaddingValues]，必须通过 [Modifier.padding] 和[Modifier.consumeWindowInsets]
 * 应用到内容根节点，才能正确避开顶部/底部栏。如果使用 [Modifier.verticalScroll]，请把这两个修饰符加在 滚动子项 上，而不是直接加在滚动容器本身。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 脚手架(
    修饰符: Modifier = Modifier,
    顶部栏: @Composable () -> Unit = {},
    底部栏: @Composable () -> Unit = {},
    提示条容器: @Composable () -> Unit = {},
    悬浮操作按钮: @Composable () -> Unit = {},
    悬浮操作按钮位置: FabPosition = 悬浮位置.末端,
    容器颜色: Color = 材质主题.颜色方案.background,
    内容颜色: Color = 内容颜色为了(容器颜色),
    内容窗口插入: WindowInsets = 脚手架默认值.内容窗口插入,
    内容: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = 修饰符,
        topBar = 顶部栏,
        bottomBar = 底部栏,
        snackbarHost = 提示条容器,
        floatingActionButton = 悬浮操作按钮,
        floatingActionButtonPosition = 悬浮操作按钮位置,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        contentWindowInsets = 内容窗口插入,
        content = 内容
    )
}

/** 包含 [脚手架] 组件各类默认值的对象。 */
object 脚手架默认值 {
    /** 脚手架 的 content 插槽默认使用和消费的窗口边距。 */
    val 内容窗口插入: WindowInsets
        @Composable get() = ScaffoldDefaults.contentWindowInsets
}

/** [FloatingActionButton] 在 [脚手架] 上可附加的位置选项。 */
object 悬浮位置 {
    /**
     * 将 FAB 放置在屏幕底部起始位置，位于 [NavigationBar]（如果存在）之上。
     */
    val 起始端 = FabPosition.Start

    /**
     * 将 FAB 置于屏幕底部中央，位于 [NavigationBar]（若存在）之上。
     */
    val 居中 = FabPosition.Center

    /**
     * 将 FAB 置于屏幕底部末端，位于 [NavigationBar]（若存在）之上。
     */
    val 末端 = FabPosition.End

    /**
     * 将 FAB 置于屏幕底部末端，覆盖在 [NavigationBar]（若存在）之上。
     */
    val 末端覆盖 = FabPosition.EndOverlay

}

//=============================================================

val ScaffoldDefaults.内容窗口插入: WindowInsets
    @Composable get() = this.contentWindowInsets


