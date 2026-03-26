package 自定义.组合.基础

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role

/**
 * 单击回调没有波纹
 */
@Stable
fun Modifier.单击回调没有波纹(
    交互源: MutableInteractionSource? = null,
    指示: Indication? = null,
    启动: Boolean = true,
    单击调回标签: String? = null,
    角色: Role? = null,
    单击回调: () -> Unit
): Modifier = composed {
    this.clickable(
        interactionSource = 交互源 ?: remember { MutableInteractionSource() },
        indication = 指示,
        enabled = 启动,
        onClickLabel = 单击调回标签,
        role = 角色,
        onClick = 单击回调
    )
}
