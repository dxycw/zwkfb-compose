package 自定义.组合.基础

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput


/**
 * 单击回调变灰
 */
@Suppress("UnnecessaryComposedModifier")
@Stable
fun Modifier.单击回调变灰(
    是否禁用: Boolean = false,
    单击回调: () -> Unit = {}
): Modifier = composed {
    var 图标变灰 by remember { mutableStateOf(false) }
    this.pointerInput(是否禁用) {
        awaitPointerEventScope {
            while (!是否禁用) {
                val event = awaitPointerEvent()
                when (event.type) {
                    PointerEventType.Press -> 图标变灰 = true // 按下时图标变灰
                    PointerEventType.Release -> 图标变灰 = false // 松开时图标恢复
                }
            }
        }
    }
        .alpha(if (!是否禁用) { if (图标变灰) 0.25f else 1f } else { 1f })
        .单击回调没有波纹(启动 = !是否禁用) { 单击回调() }
}