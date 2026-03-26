package 自定义.组合.界面.图形

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

/**
 * 旋转动画
 *
 * @param 旋转角度 旋转角度
 * @return
 */
@Stable
fun Modifier.旋转动画(
    旋转角度: Float
): Modifier = composed {
    val 旋转角度 by animateFloatAsState(
        targetValue = 旋转角度, // 0度到180度切换
        animationSpec = tween(
            durationMillis = 500, // 动画时长
            easing = FastOutSlowInEasing
        ), label = "可控旋转"
    )
    this.graphicsLayer{
        rotationZ = 旋转角度
        // 设置旋转中心点为组件中心
        transformOrigin = TransformOrigin(0.5f, 0.5f)
    }
}
