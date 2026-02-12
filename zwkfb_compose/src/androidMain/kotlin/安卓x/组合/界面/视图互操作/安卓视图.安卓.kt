package 安卓x.组合.界面.视图互操作

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReusableContentHost
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner

/**
 * 组成一个从 [工厂] 获取的 Android [View]。[工厂] 块将被调用一次以获取正在组成的 [View]，并且保证在 UI 线程上调用。
 * 因此，除了创建 [View] 之外，[工厂] 块还可以用于执行一次性初始化和设置 [View] 的常量属性。[更新]块可能会因为重组而多次
 * 运行（也在 UI 线程上），这是设置新属性的合适位置。请注意，该块在 [工厂] 块完成后也会运行一次。
 *
 * [安卓视图] 通常用于需要使用无法在  Compose 中重新实现且没有对应 Compose API 的视图。目前常见的例子包括 WebView、
 * SurfaceView、AdView 等。
 *
 * [安卓视图] 的这个重载不会自动池化或重用视图。如果放置在一个可重用的容器中（包括在 [LazyRow]
 * [androidx.compose.foundation.lazy.LazyRow] 或[LazyColumn][androidx.compose.foundation.lazy.LazyColumn] 内），
 * 当包含 安卓视图 的组合层次结构发生变化时，视图实例将始终被丢弃并重新创建，即使其组结构没有变化，并且视图本可以被重用。
 *
 * 要选择使用视图重用，请调用接受 `onReset` 回调的 [安卓视图] 重载，并为该回调提供非空实现。由于丢弃和重新创建视图实例成本高，
 * 重用视图可以显著提高性能——尤其是在构建滚动列表的 [AndroidViews][安卓视图] 时。强烈建议在可能时选择使用视图重用。
 *
 * [安卓视图] 不会将其内容裁剪到布局边界。如果需要裁剪内容，请在子视图上使用 [View.setClipToOutline]。
 * 开发者可能希望对所有 SurfaceView 的子类都执行此操作，以保持其内容在边界内。
 *
 * [安卓视图] 具有嵌套滚动交互功能，如果包含的视图启用了嵌套滚动。这意味着如果此 Composable 被放置在参与嵌套滚动的容器内，
 * 它可以传递滚动增量。有关如何启用嵌套滚动交互的更多信息：
 *
 * @param 工厂 创建要组合的[View]的块。
 * @param 修饰符 要应用于布局的修饰符
 * @param 更新 在布局被填充后以及在重新组合时调用的回调，用于更新视图的信息和状态。
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
@UiComposable
fun <T : View> 安卓视图(
    工厂: (Context) -> T,
    修饰符: Modifier = Modifier,
    更新: (T) -> Unit = 无操作更新,
) {
    AndroidView(factory = 工厂, modifier = 修饰符, update = 更新, onRelease = 无操作更新)
}

/**
 * 组成一个从 [工厂] 获取的 Android [View]。[工厂] 块将被调用一次以获取正在组成的 [View]，并且保证在 UI 线程上调用。
 * 因此，除了创建 [View] 之外，[工厂] 块还可以用于执行一次性初始化和设置 [View] 的常量属性。[更新] 块可能会因为重组而多次
 * 运行（也在 UI 线程上），这是设置新属性的合适位置。请注意，该块在 [工厂] 块完成后也会运行一次。
 *
 * [安卓视图] 通常用于需要使用无法在 Compose 中重新实现且没有对应 Compose API 的视图。
 * 目前的常见示例包括 WebView、 SurfaceView、AdView 等。
 *
 * 默认情况下，[安卓视图] 不会自动池化或重用视图。如果放置在可重用容器中（包括在 [LazyRow]
 * [androidx.compose.foundation.lazy.LazyRow] 或  [LazyColumn][androidx.compose.foundation.lazy.LazyColumn] 内），
 * 当包含 安卓视图 的组合层次结构发生变化时，视图实例将始终被丢弃并重新创建，即使其组结构未发生变化且视图原本可以被重用。
 *
 * 如果为[安卓视图]提供了非空的[重置回调]回调，则视图可以重复使用。由于丢弃和重新创建视图实例的开销很大，
 * 重复使用视图可以带来显著的性能提升——尤其是在构建[AndroidViews][安卓视图]的滚动列表时。
 * 强烈建议指定[重置回调]实现，并在可能的情况下选择视图复用。
 *
 * 当指定 [重置回调] 时，[View] 实例在被容器托管时可以被重用，该容器支持可重用元素。当兼容的 [安卓视图]
 * 实例在重组过程中被插入和移除时，会发生重用。两个 `安卓视图` 实例如果在相同的可组合组结构下调用，则被认为是兼容的。
 * 最常见的场景是在像 `LazyRow` 和 `LazyColumn` 这样的惰性布局 API 中，当滚动时，它们可以在项目之间重用布局节点（在此情况下是 Views）。
 *
 * [重置回调] 在 UI 线程上调用，当视图将被重用时，表示视图应准备在组合层次结构中的新上下文中显示。此回调在 [更新]
 * 之前调用，可用于重置任何临时视图状态，如动画或用户输入。
 *
 * 请注意，[重置回调] 可能不会紧接着调用 [更新]。如果视图被停用但未从组合中释放，Compose 可能会暂时将其从组合层次结构中分离。
 * 这可能发生在视图出现在当前未激活的 [ReusableContentHost] 中，或在正在移动的 [movable content]
 * [androidx.compose.runtime.movableContentOf] 块内。如果发生这种情况，视图将从其父视图中移除，但会由 Compose 保留，
 * 以便在其内容宿主再次激活时重用。如果视图再也不会激活，而是完全被丢弃，当 Compose 释放视图时，[重置回调] 回调将直接从此停用状态调用。
 *
 * 如果你需要观察视图当前是否在组合层级中使用，你可以通过 [View.addOnAttachStateChangeListener] 观察它是否已附加。视图也可以
 * 通过 [findViewTreeLifecycleOwner] 观察其宿主的生命周期。此函数返回的生命周期将与[LocalLifecycleOwner] 匹配。
 * 请注意，生命周期在视图附加之前未设置且无法使用。
 *
 * 当视图从组合中永久移除时，[释放回调] 将被调用（也在 UI 线程上）。一旦该回调返回，Compose 将不会尝试重复使用之前的视图实例，
 * 无论是否提供了 [重置回调] 实现。如果将来再次需要该视图，将创建一个新的实例，并以调用 [工厂] 开始的全新生命周期。
 *
 * [安卓视图] 不会将其内容裁剪到布局边界。如果需要裁剪内容，请在子视图上使用 [View.setClipToOutline]。
 * 开发者可能希望对所有 SurfaceView 的子类都执行此操作，以保持其内容在范围内。
 *
 * [安卓视图] 具有嵌套滚动交互功能，如果包含的视图启用了嵌套滚动。这意味着如果此 Composable 被放置在参与嵌套滚动的容器内，
 * 它可以传递滚动增量。有关如何启用嵌套滚动交互的更多信息：
 *
 * @param 工厂 创建要组合的[View]的块。
 * @param 修饰符 要应用于布局的修饰符
 * @param 重置回调 回调作为信号调用，表示视图即将以与其原始创建不同的上下文附加到组合层次结构中。此回调在[更新]之前调用，
 * 应为视图的通用重用做好准备。如果为`null`或未指定，`安卓视图`实例将不支持重用，每当安卓视图从组合层次结构中移动
 * 或移除时，View实例将始终被丢弃。
 * @param 释放回调 回调被调用以作为信号，表明此视图实例已完全退出组合层次结构，并且不会再次使用。此时应释放视图使用的任何额外资源。
 * @param 更新 在布局被填充后以及在重新组合时调用的回调，用于更新视图的信息和状态。
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
@UiComposable
fun <T : View> 安卓视图(
    工厂: (Context) -> T,
    修饰符: Modifier = Modifier,
    重置回调: ((T) -> Unit)? = null,
    释放回调: (T) -> Unit = 无操作更新,
    更新: (T) -> Unit = 无操作更新,
) {
    AndroidView(factory = 工厂, modifier = 修饰符, onReset = 重置回调, onRelease = 释放回调, update = 更新)
}

/** [安卓视图]使用的空更新块。 */
val 无操作更新: View.() -> Unit = {}


