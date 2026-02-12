package 安卓x.导航.组合

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import kotlin.reflect.KClass
import kotlin.reflect.KType


/**
 * 为 Compose 层级中**自成一体的导航**提供一处“容身之所”。
 *
 * 一旦调用完毕，[NavGraphBuilder] 内定义的任何 Composable 都能通过传入的 [导航控制器] 进行跳转。
 *
 * 传入本方法的 构建器 会被 `remember` 缓存，因此在该 NavHost 的整个生命周期内，构建器 的内容**不可再变**。
 *
 * @param 导航控制器 此 NavHost 对应的 导航控制器
 * @param 初始目标 起始目的地对应的路由
 * @param 修饰符 要应用到该布局上的 Modifier。
 * @param 内容对齐 `AnimatedContent` 的 `Alignment`（对齐方式）。
 * @param 路由 图（Graph）对应的路由
 * @param 进入过渡 用于定义该宿主内各目的地**进入过渡动画**的回调。
 * @param 退出过渡 定义该宿主内各目的地**退出过渡动画**的回调。
 * @param 弹出进入过渡 定义该宿主内各目的地**通过返回操作进入时的过渡动画**的回调。
 * @param 弹出退出过渡 定义该宿主内各目的地 **“弹出返回”时的退出过渡动画** 的回调。
 * @param 大小转换 定义该宿主内各目的地**尺寸变换动画**的回调。
 * @param 构建器 用于构建该导航图的构建器
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 导航容器(
    导航控制器: NavHostController,
    初始目标: String,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: String? = null,
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = 导航控制器,
        startDestination = 初始目标,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 为 Compose 层级中**自成一体的导航**提供一处“容身之所”。
 *
 * 一旦调用完毕，[NavGraphBuilder] 内定义的任何 Composable 都能通过传入的 [导航控制器] 进行跳转。
 *
 * 传入本方法的 构建器 会被 `remember` 缓存，因此在该 NavHost 的整个生命周期内，构建器 的内容**不可再变**。
 *
 * @param 导航控制器 此 NavHost 对应的 导航控制器
 * @param 初始目标 由 `KClass` 生成的起始目的地路由
 * @param 修饰符 要应用到该布局上的 Modifier。
 * @param 内容对齐 `AnimatedContent` 的 `Alignment`（对齐方式）。
 * @param 路由 由 `KClass` 生成的图路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[route]` 未使用自定义 NavType，则可为空。
 * @param 进入过渡 用于定义该宿主内各目的地**进入过渡动画**的回调。
 * @param 退出过渡 定义该宿主内各目的地**退出过渡动画**的回调。
 * @param 弹出进入过渡 定义该宿主内各目的地**通过返回操作进入时的过渡动画**的回调。
 * @param 弹出退出过渡 定义该宿主内各目的地 **“弹出返回”时的退出过渡动画** 的回调。
 * @param 大小转换 定义该宿主内各目的地**尺寸变换动画**的回调。
 * @param 构建器 用于构建该导航图的构建器
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 导航容器(
    导航控制器: NavHostController,
    初始目标: KClass<*>,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: KClass<*>? = null,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = 导航控制器,
        startDestination = 初始目标,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        typeMap = 类型映射,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 在 Compose 层级中为**自成一体的导航**提供一处“落脚点”。
 *
 * 一旦调用完毕，[NavGraphBuilder] 内定义的任何 Composable 都能通过传入的 [导航控制器] 进行跳转。
 *
 * 传入本方法的 构建器 会被 `remember` 缓存，因此在该 NavHost 的整个生命周期内，构建器 的内容**不可再变**。
 *
 * @param 导航控制器 此 NavHost 对应的 导航控制器
 * @param 初始目标 由对象（Object）生成的起始目的地路由
 * @param 修饰符 要应用到该布局上的 Modifier。
 * @param 内容对齐 `AnimatedContent` 的 `Alignment`（对齐方式）。
 * @param 路由 由 `[KClass]` 生成的导航图路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[路由]` 未使用自定义 NavType，则可为空。
 * @param 进入过渡 用于定义该宿主内各目的地**进入过渡动画**的回调。
 * @param 退出过渡 定义该宿主内各目的地**退出过渡动画**的回调。
 * @param 弹出进入过渡 定义该宿主内各目的地**通过返回操作进入时的过渡动画**的回调。
 * @param 弹出退出过渡 定义该宿主内各目的地 **“弹出返回”时的退出过渡动画** 的回调。
 * @param 大小转换 定义该宿主内各目的地**尺寸变换动画**的回调。
 * @param 构建器 用于构建该导航图的构建器
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 导航容器(
    导航控制器: NavHostController,
    初始目标: Any,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: KClass<*>? = null,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = 导航控制器,
        startDestination = 初始目标,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        typeMap = 类型映射,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 为 Compose 层级中**自成一体的导航**提供一处“容身之所”。
 *
 * 一旦调用完毕，[NavGraphBuilder] 内定义的任何 Composable 都能通过传入的 [导航控制器] 进行跳转。
 *
 * @param 导航控制器 此 NavHost 对应的 导航控制器
 * @param 图 此 NavHost 对应的导航图
 * @param 修饰符 要应用到该布局上的 Modifier。
 * @param 内容对齐 `AnimatedContent` 的 `Alignment`（对齐方式）。
 * @param 进入过渡 用于定义该宿主内各目的地**进入过渡动画**的回调。
 * @param 退出过渡 定义该宿主内各目的地**退出过渡动画**的回调。
 * @param 弹出进入过渡 定义该宿主内各目的地**通过返回操作进入时的过渡动画**的回调。
 * @param 弹出退出过渡 定义该宿主内各目的地 **“弹出返回”时的退出过渡动画** 的回调。
 * @param 大小转换 定义该宿主内各目的地**尺寸变换动画**的回调。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 导航容器(
    导航控制器: NavHostController,
    图: NavGraph,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null
) {
    NavHost(
        navController = 导航控制器,
        graph = 图,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换
    )
}

