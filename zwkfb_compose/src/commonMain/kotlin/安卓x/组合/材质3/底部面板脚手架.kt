package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SheetValue.Expanded
import androidx.compose.material3.SheetValue.PartiallyExpanded
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design standard bottom sheetscaffold](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 标准底部面板与屏幕主 UI 区域共存，用户可同时查看并操作这两个区域。它们通常用于：在主 UI 内容频繁滚动或平移时，让某项功能或次要内容始终保留在屏幕上。
 *
 * ![Bottom sheetimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom_sheet.png)
 *
 * 该组件通过确保正确的布局策略并收集必要数据，使多个 Material 组件协同工作，从而帮助你构建完整的界面。
 *
 * @param 面板内容 底部面板的内容
 * @param 修饰符 应用于 脚手架 根节点的 [Modifier]。
 * @param 脚手架状态 底部面板脚手架（scaffold）的状态。
 * @param 面板预览高度 底部面板折叠时的高度。该值必须大于 0.dp；若传入 0.dp，则该锚点会被视为 Hidden 状态。
 * @param 面板最大宽度 定义面板最大宽度的 [Dp] 值。传入 [Dp.Unspecified] 即可让面板占满整个屏幕宽度。
 * @param 面板形状 底部面板的形状。
 * @param 面板容器颜色 底部面板的背景颜色。
 * @param 面板内容颜色 底部面板为其子组件推荐的正文颜色。默认取与 [面板容器颜色] 相对应的正文颜色；若该颜色并非来自主题色，则保留底部面板上方设定的正文颜色。
 * @param 面板色调阴影 当 [面板容器颜色] 为 [ColorScheme.surface] 时，会在容器表面叠加一层半透明的“主色”遮罩。
 * 提高色调高度（tonal elevation）值，将在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 面板视觉阴影 底部面板的阴影高度。
 * @param 面板拖动手柄 可选的视觉拖动手柄，用于拖动 脚手架 的底部面板。
 * @param 面板滑动启动 是否启用手势滑动功能，让面板响应用户的滑动操作。
 * @param 顶部栏 屏幕的顶部应用栏，通常为 [TopAppBar]。
 * @param 提示条容器 用于承载通过 [SnackbarHostState.showSnackbar] 推送显示的 [Snackbar] 组件，通常为 [SnackbarHost]。
 * @param 容器颜色 此 脚手架 的背景颜色。使用 [Color.Transparent] 可设置为透明背景。
 * @param 内容颜色 此 脚手架 内部内容的推荐用色。默认取与 [容器颜色] 相对应的内容配色；若 [容器颜色] 并非来自主题色，则使用当前 [LocalContentColor]。
 * @param 内容 屏幕的内容区域。该 lambda 会收到一个 [PaddingValues]，应通过 [Modifier.padding] 和 [Modifier.consumeWindowInsets]
 * 应用到内容根节点，以正确避开顶部和底部栏所占区域。如果使用 [Modifier.verticalScroll]，请把该修饰符用在“滚动子项”上，而不是直接用在滚动组件本身。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 底部面板脚手架(
    面板内容: @Composable ColumnScope.() -> Unit,
    修饰符: Modifier = Modifier,
    脚手架状态: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    面板预览高度: Dp = BottomSheetDefaults.SheetPeekHeight,
    面板最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    面板形状: Shape = BottomSheetDefaults.ExpandedShape,
    面板容器颜色: Color = BottomSheetDefaults.ContainerColor,
    面板内容颜色: Color = 内容颜色为了(面板容器颜色),
    面板色调阴影: Dp = 0.dp,
    面板视觉阴影: Dp = BottomSheetDefaults.Elevation,
    面板拖动手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    面板滑动启动: Boolean = true,
    顶部栏: @Composable (() -> Unit)? = null,
    提示条容器: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    容器颜色: Color = MaterialTheme.colorScheme.surface,
    内容颜色: Color = 内容颜色为了(容器颜色),
    内容: @Composable (PaddingValues) -> Unit,
) {
    BottomSheetScaffold(
        sheetContent = 面板内容,
        modifier = 修饰符,
        scaffoldState = 脚手架状态,
        sheetPeekHeight = 面板预览高度,
        sheetMaxWidth = 面板最大宽度,
        sheetShape = 面板形状,
        sheetContainerColor = 面板容器颜色,
        sheetContentColor = 面板内容颜色,
        sheetTonalElevation = 面板色调阴影,
        sheetShadowElevation = 面板视觉阴影,
        sheetDragHandle = 面板拖动手柄,
        sheetSwipeEnabled = 面板滑动启动,
        topBar = 顶部栏,
        snackbarHost = 提示条容器,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        content = 内容,
    )
}


/**
 * 创建并 [remember] 一个 [BottomSheetScaffoldState]。
 *
 * @param 底部面板状态 标准底部面板的状态。参见 [rememberStandardBottomSheetState]。
 * @param 提示条容器状态 用于在 scaffold 内部显示 Snackbar 的 [SnackbarHostState]。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住底部面板脚手架状态(
    底部面板状态: SheetState = rememberStandardBottomSheetState(),
    提示条容器状态: SnackbarHostState = remember { SnackbarHostState() },
): BottomSheetScaffoldState =
     rememberBottomSheetScaffoldState(
         bottomSheetState = 底部面板状态,
         snackbarHostState = 提示条容器状态,
     )



/**
 * 创建并 [remember] 一个用于 [BottomSheetScaffold] 的 [SheetState]。
 *
 * @param 初始值 状态的初始值。若 [跳过隐藏状态] 为 true，则应设为 [PartiallyExpanded] 或 [Expanded]。
 * @param 确认值改变 可选回调，用于确认或否决即将发生的状态变更。
 * @param 跳过隐藏状态 是否跳过 [BottomSheetScaffold] 的 Hidden 状态。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住标准底部面板状态(
    初始值: SheetValue = PartiallyExpanded,
    确认值改变: (SheetValue) -> Boolean = { true },
    跳过隐藏状态: Boolean = true,
) =
    rememberStandardBottomSheetState(
        initialValue = 初始值,
        confirmValueChange = 确认值改变,
        skipHiddenState = 跳过隐藏状态,
    )




