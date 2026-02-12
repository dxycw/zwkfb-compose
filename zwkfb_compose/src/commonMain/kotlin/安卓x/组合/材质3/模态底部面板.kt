package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SheetValue.Expanded
import androidx.compose.material3.SheetValue.Hidden
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design modal bottom sheet](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 模态底部面板在移动设备上用作内嵌菜单或简单对话框的替代方案，尤其适用于以下场景：提供一长串操作选项；选项需要较长的文字说明和图标。
 * 与对话框类似，模态底部面板会浮现在应用内容之上，出现时会屏蔽其他所有应用功能，并一直停留在屏幕上，直到用户确认、关闭或完成所需操作为止。
 *
 * ![Bottom sheetimage](https://developer.android.com/images/reference/androidx/compose/material3/bottom_sheet.png)
 *
 * @param 取消请求回调 当用户点击底部面板外部区域，并在面板动画至 [Hidden] 状态后执行。
 * @param 修饰符 底部面板的可选 [Modifier]。
 * @param 面板状态 底部面板的状态。
 * @param 面板最大宽度 定义面板最大宽度的 [Dp] 值。传入 [Dp.Unspecified] 即可让面板占满整个屏幕宽度。
 * @param 面板手势启用 底部面板是否可通过手势进行交互。
 * @param 形状 底部面板的形状。
 * @param 容器颜色 此底部面板背景所用的颜色。
 * @param 内容颜色 此底部面板内部内容的推荐用色。默认取值为：与 [容器颜色] 相对应的内容配色；若 [容器颜色]并非来自主题色，则使用当前 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器表面叠加一层半透明的“主色”遮罩。提高色调高度（tonal elevation）值，
 * 将在浅色主题下使颜色更深，在深色主题下使颜色更浅。另见：[Surface]。
 * @param 遮罩颜色 底部面板打开时，用于遮挡背后内容的遮罩颜色。
 * @param 拖动手柄 可选的视觉滑动手柄，用于滑动关闭底部面板。
 * @param 内容窗口插入 回调函数，负责提供窗口内边距，并通过 [Modifier.windowInsetsPadding] 传递给底部面板内容。
 * [模态底部面板] 会根据当前偏移量预先占用顶部内边距，从而确保内容在任何位置都不会超出预期的窗口内边距范围。
 * @param 属性 用于进一步自定义此模态底部面板窗口行为的 [ModalBottomSheetProperties]。
 * @param 内容 要在底部面板内部显示的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
@ExperimentalMaterial3Api
fun 模态底部面板(
    取消请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    面板状态: SheetState = rememberModalBottomSheetState(),
    面板最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    面板手势启用: Boolean = true,
    形状: Shape = BottomSheetDefaults.ExpandedShape,
    容器颜色: Color = BottomSheetDefaults.ContainerColor,
    内容颜色: Color = 内容颜色为了(容器颜色),
    色调阴影: Dp = 0.dp,
    遮罩颜色: Color = BottomSheetDefaults.ScrimColor,
    拖动手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    内容窗口插入: @Composable () -> WindowInsets = { BottomSheetDefaults.windowInsets },
    属性: ModalBottomSheetProperties = ModalBottomSheetProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = 取消请求回调,
        modifier = 修饰符,
        sheetState = 面板状态,
        sheetMaxWidth = 面板最大宽度,
        sheetGesturesEnabled = 面板手势启用,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        scrimColor = 遮罩颜色,
        dragHandle = 拖动手柄,
        contentWindowInsets = 内容窗口插入,
        properties = 属性,
        content = 内容,
    )
}



/**
 * 创建并 [remember] 一个用于 [ModalBottomSheet] 的 [SheetState]。
 *
 * @param 跳过部分展开 是否跳过“部分展开”状态（前提是面板足够高）。若为 true，则无论通过代码还是用户操作，
 * 面板都将始终直接展开至 [Expanded] 状态，并在隐藏时直接回到 [Hidden] 状态。
 * @param 确认值改变 可选回调，用于确认或否决即将发生的状态变化。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住模态底部面板状态(
    跳过部分展开: Boolean = false,
    确认值改变: (SheetValue) -> Boolean = { true },
) =
    rememberModalBottomSheetState(
        skipPartiallyExpanded = 跳过部分展开,
        confirmValueChange = 确认值改变,
    )

