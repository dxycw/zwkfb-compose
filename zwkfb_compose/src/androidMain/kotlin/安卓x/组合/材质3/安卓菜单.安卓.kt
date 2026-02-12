package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuPopup
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MenuItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.window.PopupProperties

@Suppress("ComposableNaming","ModifierParameter")
@Composable
actual fun 下拉菜单(
    扩展: Boolean,
    取消请求回调: () -> Unit,
    修饰符: Modifier,
    偏移: DpOffset,
    滚动状态: ScrollState,
    属性: PopupProperties,
    形状: Shape,
    容器颜色: Color,
    色调阴影: Dp,
    视觉阴影: Dp,
    边框: BorderStroke?,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DropdownMenu(
        expanded = 扩展,
        onDismissRequest = 取消请求回调,
        modifier = 修饰符,
        offset = 偏移,
        scrollState = 滚动状态,
        properties = 属性,
        shape = 形状,
        containerColor = 容器颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        content = 内容,
    )
}

@Suppress("ComposableNaming","ModifierParameter")
@ExperimentalMaterial3ExpressiveApi
@Composable
actual fun 下拉菜单弹出(
    扩展: Boolean,
    取消请求回调: () -> Unit,
    修饰符: Modifier,
    偏移: DpOffset,
    属性: PopupProperties,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DropdownMenuPopup(
        expanded = 扩展,
        onDismissRequest = 取消请求回调,
        modifier = 修饰符,
        offset = 偏移,
        properties = 属性,
        content = 内容,
    )
}


@Suppress("ComposableNaming","ModifierParameter")
@Composable
actual fun 下拉菜单项(
    文本: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier,
    前导图标: @Composable (() -> Unit)?,
    尾随图标: @Composable (() -> Unit)?,
    已启用: Boolean,
    颜色: MenuItemColors,
    内容内边距: PaddingValues,
    交互源: MutableInteractionSource?,
) {
    DropdownMenuItem(
        text = 文本,
        onClick = 单击回调,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

internal actual val DefaultMenuProperties = PopupProperties(focusable = true)
