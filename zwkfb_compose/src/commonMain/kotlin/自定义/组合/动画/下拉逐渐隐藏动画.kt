package 自定义.组合.动画

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import 安卓.应用.窗口切换动画
import 安卓x.组合.基础.布局.盒子

/**
 * 下拉逐渐隐藏动画并启动活动
 * @param 修饰符 修饰符
 * @param 内容对齐 内容对齐, 参考[Alignment]，默认值：[Alignment.TopStart]中文意思是：左上对齐
 * @param 内容 内容代码
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 下拉逐渐隐藏动画(
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    内容: @Composable (BoxScope.() -> Unit) = {}
){
    var 拖拽距离 by remember { mutableFloatStateOf(0f) }
    val 密度 = LocalDensity.current
    val 最小密度 = with(密度) { 150.dp.toPx() } // 减小触发距离，从300.dp改为150.dp，使下拉更灵敏
    var 及时更新进度 = (拖拽距离 / 最小密度).coerceIn(0f, 1f) // 计算进度
    // 使用动画状态，调整动画参数使响应更快
    val scaleX by animateFloatAsState(
        targetValue = 1 - 及时更新进度 * 0.2f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    val scaleY by animateFloatAsState(
        targetValue = 1 - 及时更新进度 * 0.2f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    val alpha by animateFloatAsState(
        targetValue = 1 - 及时更新进度,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    Box(
        modifier = 修饰符.graphicsLayer(scaleX, scaleY, alpha)
            .pointerInput(Unit) {
                detectVerticalDragGestures(
                    onDragStart = { _ -> 拖拽距离 = 0f },// 拖拽开始 , 初始化拖拽距离为0
                    onVerticalDrag = { change, _ ->
                        // 拖拽过程中持续调用，增加拖拽距离的累积速度
                        val distance = change.positionChange().y
                        // 允许向上和向下拖拽
                        拖拽距离 += distance * 1.5f
                        // 确保拖拽距离不为负数
                        拖拽距离 = 拖拽距离.coerceAtLeast(0f)
                        及时更新进度 = (拖拽距离 / 最小密度).coerceIn(0f, 1f)
                    },
                    onDragEnd = {
                        // 正常结束拖拽，在此处重新计算进度值确保获取最新值
//                        if (及时更新进度 >= 1f) {
//                            // 当下拉距离足够时，设置导航标志
//                            上下文?.startActivity(Intent(上下文, 启动活动))
//                            上下文?.窗口切换动画(0, 0)
//                        }
                        拖拽距离 = 0f // 如果未达到阈值，重置拖拽距离，触发恢复动画
                    },
                    onDragCancel = { if (及时更新进度 < 1f) { 拖拽距离 = 0f } } // 意外取消拖拽，触发回弹动画
                )
            },
        contentAlignment = 内容对齐, content = 内容
    )
}




