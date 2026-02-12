package 安卓x.组合.动画

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 *`AnimatedVisibility` 可组合项会在其 `可见的` 值变化时，对内容的**出现**和**消失**做动画。可以通过 `进入` 和 `退出`
 * 参数分别指定不同的 `EnterTransition`（进入动画）和 `ExitTransition`（退出动画）。目前共有 4 类进入/退出过渡：**淡入淡出（Fade）**、
 * **展开/收缩（Expand/Shrink）**、**缩放（Scale）** 和 **滑动（Slide）**。进入动画之间可以用 `+` 运算符组合，退出动画也一样。
 * 组合顺序无关紧要，所有动画会**同时开始**。详见 `EnterTransition` 与 `ExitTransition` 的文档。
 *
 * 除了上述三种内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。
 * 例如，你可能想对形状、缩放、颜色等属性做个性化动画。这类自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState>
 * 对象（即 AnimatedVisibilityScope.transition）来创建；下方第二个示例代码片段给出了具体做法。这些自定义动画会与你在 enter 和 exit 中指定的内置动画同时运行。
 * 如果你希望完全接管进入或退出逻辑，可把 enter 和/或 exit 显式设为 EnterTransition.None 和/或 ExitTransition.None。
 * AnimatedVisibility 会等待所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态；内容也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。
 * 所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。如果你需要在进入/退出状态变化时额外做一些事（例如删除数据、触发后续动画等），
 * 请使用带 MutableTransitionState 参数的那个 AnimatedVisibility 重载版本。
 *
 * 默认情况下，进入动画是 [fadeIn] 与 [expandIn] 的组合，内容会从右下角开始展开；退出动画则是 [fadeOut] 与 [shrinkOut] 的组合，
 * 内容会朝右下角收缩并淡出。由于展开/收缩会改变尺寸，若父布局或兄弟节点依赖该尺寸，它们也会被联动动画影响。当 AnimatedVisibility 直接放在 Row 或 Column
 * 里时，默认的进入/退出动画会被自动调整为适合该容器的形式；详见 RowScope.AnimatedVisibility 与 ColumnScope.AnimatedVisibility 的文档。
 *
 * 下面给出两个 `AnimatedVisibility` 的示例：第一个使用**内置的进入/退出过渡动画**；第二个展示如何**自定义进入/退出动画**。
 *
 * 下面的示例展示了如何利用 AnimatedVisibilityScope 提供的 Transition<EnterExitState> 对象来创建自定义的进入/退出动画。
 *
 * @param 可见的 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认为淡入（fadeIn）并同时展开（expand）。
 * @param 退出 用于消失动画的 ExitTransition，默认为淡出（fadeOut）并同时收缩（shrink）。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见的]` 的值来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 动画可见性(
    可见的: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = 可见的,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}

/**
 * 当 `AnimatedVisibility` 位于 `Row` 内部时，`RowScope.AnimatedVisibility` 可组合项会为其内容的出现与消失添加动画效果。
 * 默认动画已针对 **Row 水平布局** 做了专门优化，详见下方说明。
 *
 * 在 enter 和 退出 参数里可以分别指定不同的 EnterTransition（进入动画）和 ExitTransition（退出动画）。目前共有 4 类过渡效果：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 和 滑动（Slide）。进入动画之间可以用 + 运算符组合，退出动画同理；
 * 组合顺序无关紧要，所有动画会同时启动。详见 EnterTransition 与 ExitTransition 的文档。
 *
 * 默认的 [进入] 和 [退出] 过渡专为 Row 的水平布局量身定制： [进入] 默认为淡入（fadeIn） 并水平展开（expandHorizontally）；
 * 展开时以内容尾部为“前导边”，向完整宽度延伸。 [退出] 默认为水平收缩（shrinkHorizontally） 并淡出（fadeOut）；收缩时仍以内容尾部为“前导边”，向中间收拢。
 * 由于宽度变化会牵动同一 Row 内的其它元素，父容器及相邻兄弟项也会随动画联动。
 *
 * 除了上述三类内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。例如，你可以对形状、缩放、颜色等属性做个性化动画。
 * 自定义动画通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState> 对象（即 AnimatedVisibilityScope.transition）来创建；详见 EnterExitState 的示例。
 * 这些自定义动画会与你在 进入 和 退出 中指定的内置动画同时运行。若你想完全接管进入或退出逻辑，可把 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。
 * AnimatedVisibility 会等待所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态； [内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。如果你需要在进入/退出状态变化时额外做一些事（例如删除数据、触发后续动画等），
 * 请使用带 MutableTransitionState 参数的那个 AnimatedVisibility 重载版本。
 *
 * @param 可见的 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认采用**水平淡入（fadeIn）并同时水平展开（expandHorizontally）**。
 * @param 退出 用于消失动画的 ExitTransition，默认采用**水平淡出（fadeOut）并同时水平收缩（shrinkHorizontally）**。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见的]` 的值来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun RowScope.动画可见性(
    可见的: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandHorizontally(),
    退出: ExitTransition = fadeOut() + shrinkHorizontally(),
    标签: String = "动画可见性",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    this.AnimatedVisibility(
        visible = 可见的,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}

/**
 * 当 `AnimatedVisibility` 位于 `Column` 内部时，`ColumnScope.AnimatedVisibility` 可组合项会为其内容的出现与消失添加动画效果。
 * 默认动画已针对 **Column 垂直布局** 做了专门优化，详见下方说明。
 *
 * 在 进入 和 退出 参数里可以分别指定不同的 EnterTransition（进入动画）和 ExitTransition（退出动画）。 目前共有 4 类过渡效果：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 与 滑动（Slide）。进入动画之间可用 + 运算符组合，退出动画同理；
 * 组合顺序无关紧要，所有动画会同时启动。详见 EnterTransition 与 ExitTransition 的文档。
 *
 * 默认的 [进入] 和 [退出] 过渡专为 Column 的垂直布局量身定制： [进入] 默认为淡入（fadeIn） 并垂直展开（expandVertically）；
 * 展开时以内容底部为“前导边”，向完整高度延伸。 [退出] 默认为垂直收缩（shrinkVertically） 并淡出（fadeOut）；收缩时仍以内容底部为“前导边”，向上收拢。
 * 由于高度变化会牵动同一 Column 内的其它元素，父容器及相邻兄弟项也会随动画联动。
 *
 * 除了上述三类内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 也支持完全自定义的进入/退出动画。 例如，你可以针对形状、缩放、颜色等属性做个性化动画。
 * 自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState> 对象（即 AnimatedVisibilityScope.transition）来创建；
 * 详见 EnterExitState 的示例。这些自定义动画会与你在 进入 和 退出 中指定的内置动画同时运行。 若你想完全接管进入或退出逻辑，
 * 可将 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。AnimatedVisibility 会等待所有
 * （内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态； [内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。如果你需要在进入/退出状态变化时额外做一些事（例如删除数据、触发后续动画等），
 * 请使用带 MutableTransitionState 参数的那个 AnimatedVisibility 重载版本。
 *
 * @param 可见的 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认采用**垂直淡入（fadeIn）并同时垂直展开（expandVertically）**。
 * @param 退出 用于消失动画的 ExitTransition，默认采用**垂直淡出（fadeOut）并同时垂直收缩（shrinkVertically）**。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见的]` 的值来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun ColumnScope.动画可见性(
    可见的: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandVertically(),
    退出: ExitTransition = fadeOut() + shrinkVertically(),
    标签: String = "动画可见性",
    内容: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    this.AnimatedVisibility(
        visible = 可见的,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}


/**
 * AnimatedVisibility 可组合项会在 [可见状态] 的 [targetState][MutableTransitionState.targetState] 发生变化时，
 * 为其内容的出现与消失添加动画效果。[可见状态] 也可用来观察 AnimatedVisibility 的动画状态：
 * visibleState.isIdle 表示所有动画是否已播放完毕；visibleState.currentState 返回当前动画的初始状态。
 *
 * 在 进入 和 退出 参数里可以分别指定不同的 EnterTransition（进入动画）和 ExitTransition（退出动画）。目前共有 4 类过渡效果：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 与 滑动（Slide）。进入动画之间可用 + 运算符组合，退出动画同理；
 * 组合顺序无关紧要，所有动画会同时启动。 详见 EnterTransition 与 ExitTransition 的文档。
 *
 * 除了上述三类内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。
 * 例如，你可以针对形状、缩放、颜色等属性做个性化动画。自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState>
 * 对象（即 AnimatedVisibilityScope.transition）来创建；详见 EnterExitState 的示例。 这些自定义动画会与你在 enter 和 exit 中指定的内置动画同时运行。
 * 若你想完全接管进入或退出逻辑，可将 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。
 * AnimatedVisibility 会等待所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态； [内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。
 * 所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出过渡一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。此时 可见状态 的 currentState 与 targetState 都将为 false。
 *
 * 默认情况下，进入动画是 [fadeIn] 与 [expandIn] 的组合，内容会从右下角开始展开；退出动画则是 [fadeOut] 与 [shrinkOut] 的组合，内容会朝右下角收缩并淡出。
 * 由于展开/收缩会改变尺寸，若父布局或兄弟节点依赖该尺寸，它们也会被联动动画影响。当 AnimatedVisibility 直接放在 Row 或 Column 里时，
 * 默认的进入/退出动画会被自动调整为适合该容器的形式；详见 RowScope.AnimatedVisibility 与 ColumnScope.AnimatedVisibility 的文档。
 *
 * @param 可见状态 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认为淡入（fadeIn）并同时展开（expand）。
 * @param 退出 用于消失动画的 ExitTransition，默认为淡出（fadeOut）并同时收缩（shrink）。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见状态]` 的值来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = fadeOut() + shrinkOut(),
    标签: String = "动画可见性",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}

/**
 * 当 AnimatedVisibility 位于 Row 中时，RowScope.AnimatedVisibility 会在 [可见状态] 的 [targetState][MutableTransitionState.targetState]
 * 发生变化时，为其内容的出现与消失添加动画效果。默认的 [进入] 和 [退出] 过渡已针对 Row 水平布局 做了专门优化，详见下方说明。
 * [可见状态] 也可用来观察动画状态： visibleState.isIdle 表示所有动画是否已播放完毕；visibleState.currentState 返回当前动画的初始状态。
 *
 * 在 进入 和 退出 参数中，可以分别定义不同的 EnterTransition（进入动画）和 ExitTransition（退出动画）。目前共有 4 种过渡类型：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 和 滑动（Slide）。进入动画之间可用 + 运算符组合，退出动画同理；
 * 组合顺序无关紧要，所有动画会同时启动。详见 EnterTransition 与 ExitTransition 的文档。
 *
 * 默认的 [进入] 和 [退出] 过渡专为 Row 的水平布局量身定制：[进入] 默认为淡入（fadeIn） 并水平展开（expandHorizontally）；
 * 展开时以内容尾部为“前导边”，向完整宽度延伸。 [退出] 默认为水平收缩（shrinkHorizontally） 并淡出（fadeOut）；收缩时仍以内容尾部为“前导边”，向中间收拢。
 * 由于宽度变化会牵动同一 Row 内的其它元素，父容器及相邻兄弟项也会随动画联动。
 *
 * 除了上述三类内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。
 * 例如，你可以针对形状、缩放、颜色等属性做个性化动画。自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState>
 * 对象（即 AnimatedVisibilityScope.transition）来创建；详见 EnterExitState 的示例。 这些自定义动画会与你在 进入 和 退出
 * 中指定的内置动画同时运行。 若你想完全接管进入或退出逻辑，可将 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。
 * AnimatedVisibility 会等待所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态；[内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。
 * 所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。此时 可见状态 的 currentState 与 targetState 都会变成 false。
 *
 * @param 可见状态 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认采用**垂直淡入（fadeIn）并同时垂直展开（expandVertically）**。
 * @param 退出 用于消失动画的 ExitTransition，默认采用**垂直淡出（fadeOut）并同时垂直收缩（shrinkVertically）**。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见状态]` 的值来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun RowScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = expandHorizontally() + fadeIn(),
    退出: ExitTransition = shrinkHorizontally() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    this.AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}

/**
 * 当 AnimatedVisibility 位于 Column 中时，ColumnScope.AnimatedVisibility 会在 [可见状态] 的 [targetState] 发生变化时，
 * 为其内容的出现与消失添加动画。默认的 [进入] 和 [退出] 过渡已针对 Column 垂直布局 专门优化，详见下文。[可见状态] 也可用来观察动画状态：
 * visibleState.isIdle 表示所有动画是否已播放完毕；visibleState.currentState 返回当前动画的初始状态。
 *
 * 在 进入 和 退出 参数中，可以分别定义不同的 EnterTransition（进入动画）和 ExitTransition（退出动画）。目前共有 4 种过渡类型：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 和 滑动（Slide）。进入动画之间可用 + 运算符组合，退出动画同理；
 * 组合顺序无关紧要，所有动画会同时启动。详见 EnterTransition 与 ExitTransition 的文档。
 *
 * 默认的 [进入] 和 [退出] 过渡专为 Column 的垂直布局量身定制：[进入] 默认为淡入（fadeIn） 并垂直展开（expandVertically）；
 * 展开时以内容底部为“前导边”，向完整高度延伸。[退出] 默认为垂直收缩（shrinkVertically） 并淡出（fadeOut）；收缩时仍以内容底部为“前导边”，向上收拢。
 * 由于高度变化会牵动同一 Column 内的其它元素，父容器及相邻兄弟项也会随动画联动。
 *
 * 除了上述三类内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。
 * 例如，你可以针对形状、缩放、颜色等属性做个性化动画。自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState>
 * 对象（即 AnimatedVisibilityScope.transition）来创建；详见 EnterExitState 的示例。这些自定义动画会与你在 进入 和 退出 中指定的内置动画同时运行。
 * 若你想完全接管进入或退出逻辑，可将 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。
 * AnimatedVisibility 会等待所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态；[内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。
 * 所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。此时 [可见状态] 的 currentState 与 targetState 都将变为 false。
 *
 * @param 可见状态 定义内容是否应可见。
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认采用**垂直淡入（fadeIn）并同时垂直展开（expandVertically）**。
 * @param 退出 用于消失动画的 ExitTransition，默认采用**垂直淡出（fadeOut）并同时垂直收缩（shrinkVertically）**。
 * @param 标签 一个在 Android Studio 动画预览中用来与其他动画区分的标签。
 * @param 内容 根据 `[可见状态]` 的状态来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun ColumnScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = expandVertically() + fadeIn(),
    退出: ExitTransition = shrinkVertically() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    this.AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容,
    )
}

/**
 * 这个扩展函数会把新建的 [AnimatedVisibility] 作为给定 Transition 的子过渡。这意味着：进入/退出动画改由父级 [Transition]
 * 的 [targetState] 变化来触发。当 targetState 改变时，通过 [可见的] lambda 与 Transition.targetState 共同计算出是否可见。
 * [AnimatedVisibility] 里定义的进入/退出过渡（包括自定义动画）全部提升到父级 Transition 中。父级 Transition 会等待所有这些动画全部结束后，
 * 才认为自身已完成（即 Transition.currentState == Transition.targetState），并在退出时真正移除内容。
 *
 * 在 [进入] 和 [退出] 中可分别定义不同的 EnterTransition 与 ExitTransition，用于控制出现和消失动画。它们共有 4 种类型：
 * 淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale） 和 滑动（Slide）。进入动画之间可用 + 组合，退出动画亦然；
 * 顺序任意，所有动画将同时开始。 详见 EnterTransition 与 ExitTransition 文档。
 *
 * 除了上述三种内置的 EnterTransition 与 ExitTransition，AnimatedVisibility 还支持完全自定义的进入/退出动画。
 * 例如，你可以针对形状、缩放、颜色等属性做个性化动画。自定义动画可通过 AnimatedVisibilityScope 提供的 Transition<EnterExitState>
 * 对象（即 AnimatedVisibilityScope.transition）来创建；详见 EnterExitState 的示例。这些自定义动画会与你在 进入 和 退出 中指定的内置动画同时运行。
 * 若你想完全接管进入或退出逻辑，可将 进入 和/或 退出 显式设为 EnterTransition.None 和/或 ExitTransition.None。AnimatedVisibility 会等待
 * 所有（内置 + 自定义）进入或退出动画全部结束后，才认为自身处于空闲状态；[内容] 也只有在所有退出动画都播放完毕之后，才会被真正移除。
 *
 * AnimatedVisibility 会为其内容创建一个自定义的 Layout。该布局的宽高分别取所有子项中出现过的最大宽度和最大高度。
 * 所有子项都会被对齐到这个自定义布局的左上角（top-start）。
 *
 * 注意：退出动画一旦结束，[内容] 可组合项就会从组合树中被移除并销毁。
 *
 * 默认情况下，进入动画是 [fadeIn] 与 [expandIn] 的组合，内容会从右下角开始展开；退出动画则是 [fadeOut] 与 [shrinkOut] 的组合，
 * 内容会朝右下角收缩并淡出。由于展开/收缩会改变尺寸，若父布局或兄弟节点依赖该尺寸，它们也会随动画联动。
 *
 * @param 可见的 定义内容是否应可见。 基于过渡状态 T
 * @param 修饰符 为容纳 `[内容]` 而创建的 `[Layout]` 所用的修饰符。
 * @param 进入 用于出现动画的 EnterTransition，默认采用**垂直淡入（fadeIn）并同时垂直展开（expandVertically）**。
 * @param 退出 用于消失动画的 ExitTransition，默认采用**垂直淡出（fadeOut）并同时垂直收缩（shrinkVertically）**。
 * @param 内容 根据 `[Transition.targetState]` 以及提供的 `[可见的]` lambda 所计算出的可见性，来决定出现或消失的内容。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun <T> Transition<T>.动画可见性(
    可见的: (T) -> Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
): Unit = this.AnimatedVisibility(
    visible = 可见的,
    modifier = 修饰符,
    enter = 进入,
    exit = 退出,
    content = 内容,
)

/**
 * 这是 [AnimatedVisibility] 的内容作用域。在此作用域内，所有直接和间接子级均可：通过 [Modifier.动画进入退出] 使用内置选项，
 * 为自己定义进入/退出过渡；利用 [过渡] 对象定义完全自定义的进入/退出动画。[AnimatedVisibility] 会确保所有自定义 + 内置的进入/退出动画全部完成后，
 * 才认为自身处于空闲状态；若为退出，则在此之后才真正移除其内容。
 *
 * 注意：如果自定义进入/退出动画是脱离 AnimatedVisibilityScope.transition 自行创建的，
 * AnimatedVisibility 无法感知这些动画，因此无法保证它们在退出时能完整播放完毕。
 */
interface 动画可见性范围{ // AnimatedVisibilityScope
    /**
     * [过渡] 允许指定自定义的进入/退出动画，并将与 [AnimatedVisibility] 中内置的进入/退出过渡同时运行。
     */
    val 过渡: Transition<EnterExitState>

    /**
     * `[动画进入退出]` 修饰符可用于 `[AnimatedVisibility]` 的任何直接 or 间接子项，让它们拥有**与 `[AnimatedVisibility]`
     * 自身设定不同的**进入/退出动画。这些子项的最终视觉效果将是**父级动画 + 自身动画**的叠加。
     *
     * `[进入]` 和 `[退出]` 用于定义内容出现与消失时所用的 `[EnterTransition]` 与 `[ExitTransition]`。
     * 它们共有 **4 种**类型：**淡入淡出（Fade）**、**展开/收缩（Expand/Shrink）**、**缩放（Scale）** 和 **滑动（Slide）**。
     * 进入动画之间可用 `+` 组合，退出动画亦然；顺序任意，所有动画将**同时开始**。详见 `EnterTransition` 与 `ExitTransition` 的文档。
     *
     * 默认情况下，进入过渡为内容的 [fadeIn]（淡入），退出过渡为使用 [fadeOut]（淡出）。
     *
     * 在某些场景下，可能希望 `AnimatedVisibility` 本身**完全不播放进入和/或退出动画**，以便其每个子项各自拥有独立的动画效果。
     * 此时可将 `[AnimatedVisibility]` 的 `[进入]` 和/或 `[退出]` 显式设为 `EnterTransition.None` 和/或 `ExitTransition.None`。
     */
    fun Modifier.动画进入退出(
        进入: EnterTransition = fadeIn(),
        退出: ExitTransition = fadeOut(),
        标签: String = "动画进入退出",
    ): Modifier
}

//==============================================================================================

/**
 * [过渡] 允许指定自定义的进入/退出动画，并将与 [AnimatedVisibility] 中内置的进入/退出过渡同时运行。
 */
val AnimatedVisibilityScope.过渡: Transition<EnterExitState>
    get() = this.transition
