package 自定义.组合.界面.输入.嵌套滚动

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Velocity
import kotlinx.coroutines.launch

/**
 * 滑动回弹
 */
@Stable
fun Modifier.滑动回弹(): Modifier = composed{
    val scrollState = rememberScrollState()
    val offsetY = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    // 嵌套滚动连接：只处理边界溢出
    val nested = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset = Offset.Zero

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                if (source != NestedScrollSource.UserInput) return Offset.Zero

                val atTop    = scrollState.value <= 0 && available.y > 0
                val atBottom = !scrollState.canScrollForward && available.y < 0

                return if (atTop || atBottom) {
                    scope.launch {
                        offsetY.snapTo(offsetY.value + available.y * 0.5f)
                    }
                    available
                } else Offset.Zero
            }

            override suspend fun onPostFling(
                consumed: Velocity,
                available: Velocity
            ): Velocity {
                offsetY.animateTo(0f, spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness    = Spring.StiffnessLow
                ))
                return super.onPostFling(consumed, available)
            }
        }
    }
    this.nestedScroll(nested, remember { NestedScrollDispatcher() })
        .verticalScroll(scrollState)
        .graphicsLayer { translationY = offsetY.value }
}
