package 自定义.动画

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Transition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import 安卓x.组合.动画.动画可见性范围


//@Composable
//fun 动画可见性(
//    visible: Boolean,
//    modifier: Modifier = Modifier,
//    enter: EnterTransition = fadeIn() + expandIn(),
//    exit: ExitTransition = shrinkOut() + fadeOut(),
//    label: String = "AnimatedVisibility",
//    content: @Composable() 动画可见性范围.() -> Unit,
//) {
//    AnimatedVisibility(
//        visible = visible,
//        modifier = modifier,
//        enter = enter,
//        exit = exit,
//        label = label,
//        content = {
//            content(
//                object : 动画可见性范围 {
//                    override val 过渡: Transition<EnterExitState>
//                        get() = transition
//
//                    override fun Modifier.动画进入退出(
//                        enter: EnterTransition,
//                        exit: ExitTransition,
//                        label: String,
//                    ): Modifier = this.animateEnterExit(enter = enter, exit = exit, label = label,)
//                }
//            )
//        },
//    )
//}