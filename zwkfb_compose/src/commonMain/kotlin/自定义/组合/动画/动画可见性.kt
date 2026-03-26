package 自定义.组合.动画


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