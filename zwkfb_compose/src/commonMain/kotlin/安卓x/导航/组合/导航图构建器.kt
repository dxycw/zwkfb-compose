package 安卓x.导航.组合

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.ComposeNavigatorDestinationBuilder
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.DialogNavigatorDestinationBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.get
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]
 *
 * @param 路由 目的地的路由
 * @param 参数 要与该目的地关联的参数列表
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于确定该目的地**进入过渡动画**的回调
 * @param 退出过渡 用于确定该目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于确定该目的地 **“弹出返回”时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于确定该目的地 **“弹出返回”时的退出过渡动画** 的回调
 * @param 大小转换 用于确定该目的地 **尺寸变换动画** 的回调
 * @param 内容 目的地的 Composable（可组合函数）
 */
fun NavGraphBuilder.可组合(
    路由: String,
    参数: List<NamedNavArgument> = emptyList(),
    深度链接: List<NavDeepLink> = emptyList(),
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable(
        route = 路由,
        arguments = 参数,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]
 *
 * @param T 由 `[KClass]` 生成的目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[T]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于确定该目的地**进入过渡动画**的回调
 * @param 退出过渡 用于确定该目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于确定该目的地 **“弹出返回”时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于确定该目的地 **“弹出返回”时的退出过渡动画** 的回调
 * @param 大小转换 用于确定该目的地 **尺寸变换动画** 的回调
 * @param 内容 目的地的 Composable（可组合函数）
 */
inline fun <reified T : Any> NavGraphBuilder.可组合(
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    noinline 内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable<T>(
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]
 *
 * @param 路由 由 `[KClass]` 生成的目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[route]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于确定该目的地**进入过渡动画**的回调
 * @param 退出过渡 用于确定该目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于确定该目的地 **“弹出返回”时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于确定该目的地 **“弹出返回”时的退出过渡动画** 的回调
 * @param 大小转换 用于确定该目的地 **尺寸变换动画** 的回调
 * @param 内容 目的地的 Composable（可组合函数）
 */
fun <T : Any> NavGraphBuilder.可组合(
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable(
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}


/**
 * 构建嵌套的 [NavGraph]
 *
 * @param 初始目标 此 NavGraph 的起始目的地路由
 * @param 路由 该目的地的唯一路由
 * @param 参数 要与该目的地关联的参数列表
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于定义此 NavGraph 内各目的地**进入过渡动画**的回调
 * @param 退出过渡 用于定义此 NavGraph 内各目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的退出过渡动画** 的回调
 * @param 大小转换 用于定义此 NavGraph 内各目的地**尺寸变换动画**的回调
 * @param 构建器 用于构建该导航图的构建器
 * @return 新构建的嵌套 NavGraph
 */
fun NavGraphBuilder.导航(
    初始目标: String,
    路由: String,
    参数: List<NamedNavArgument> = emptyList(),
    深度链接: List<NavDeepLink> = emptyList(),
    进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
    弹出进入过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = 进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = 退出过渡,
    大小转换: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 初始目标,
        route = 路由,
        arguments = 参数,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建嵌套的 [NavGraph]
 *
 * @param T 该目的地的唯一路由 from a KClass
 * @param 初始目标 由 `[KClass]` 生成的此 NavGraph 起始目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[T]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于定义此 NavGraph 内各目的地**进入过渡动画**的回调
 * @param 退出过渡 用于定义此 NavGraph 内各目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的退出过渡动画** 的回调
 * @param 大小转换 用于定义此 NavGraph 内各目的地**尺寸变换动画**的回调
 * @param 构建器 用于构建该导航图的构建器
 * @return 新构建的嵌套 NavGraph
 */
inline fun <reified T : Any> NavGraphBuilder.导航(
    初始目标: KClass<*>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    noinline 构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation<T>(
        startDestination = 初始目标,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建嵌套的 [NavGraph]
 *
 * @param 路由 该目的地的唯一路由 from a KClass
 * @param 初始目标 由 `[KClass]` 生成的此 NavGraph 起始目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[路由]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于定义此 NavGraph 内各目的地**进入过渡动画**的回调
 * @param 退出过渡 用于定义此 NavGraph 内各目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的退出过渡动画** 的回调
 * @param 大小转换 用于定义此 NavGraph 内各目的地**尺寸变换动画**的回调
 * @param 构建器 用于构建该导航图的构建器
 * @return 新构建的嵌套 NavGraph
 */
fun <T : Any> NavGraphBuilder.导航(
    初始目标: KClass<*>,
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 初始目标,
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建嵌套的 [NavGraph]
 *
 * @param T 该目的地的唯一路由 来自 KClass
 * @param 初始目标 由对象（Object）生成的此 NavGraph 起始目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[T]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于定义此 NavGraph 内各目的地**进入过渡动画**的回调
 * @param 退出过渡 用于定义此 NavGraph 内各目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的退出过渡动画** 的回调
 * @param 大小转换 用于定义此 NavGraph 内各目的地**尺寸变换动画**的回调
 * @param 构建器 用于构建该导航图的构建器
 * @return 新构建的嵌套 NavGraph
 */
inline fun <reified T : Any> NavGraphBuilder.导航(
    初始目标: Any,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    noinline 构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation<T>(
        startDestination = 初始目标,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建嵌套的 [NavGraph]
 *
 * @param 路由 该目的地的唯一路由 来自 KClass
 * @param 初始目标 由对象（Object）生成的此 NavGraph 起始目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[路由]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 进入过渡 用于定义此 NavGraph 内各目的地**进入过渡动画**的回调
 * @param 退出过渡 用于定义此 NavGraph 内各目的地**退出过渡动画**的回调
 * @param 弹出进入过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的进入过渡动画** 的回调
 * @param 弹出退出过渡 用于定义此 NavGraph 内各目的地 **"弹出返回"时的退出过渡动画** 的回调
 * @param 大小转换 用于定义此 NavGraph 内各目的地**尺寸变换动画**的回调
 * @param 构建器 用于构建该导航图的构建器
 * @return 新构建的嵌套 NavGraph
 */
fun <T : Any> NavGraphBuilder.导航(
    初始目标: Any,
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = 进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = 退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? = null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 初始目标,
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]，它将在 [androidx.compose.ui.window.Dialog] 中承载。仅当此对话框
 * 代表应用中独立的界面、需要自身独立的生命周期和保存状态时适用，独立于导航图中任何其他目的地。对于 `AlertDialog` 等用例，
 * 应直接在需要显示该对话框的 [composable] 目的地中使用相关 API。
 *
 * @param 路由 目的地的路由
 * @param 参数 要与该目的地关联的参数列表
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 对话框属性 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地 Composable 内容
 */
fun NavGraphBuilder.对话框(
    路由: String,
    参数: List<NamedNavArgument> = emptyList(),
    深度链接: List<NavDeepLink> = emptyList(),
    对话框属性: DialogProperties = DialogProperties(),
    内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog(
        route = 路由,
        arguments = 参数,
        deepLinks = 深度链接,
        dialogProperties = 对话框属性,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]，它将在 [androidx.compose.ui.window.Dialog] 中承载。仅当此对话框
 * 代表应用中独立的界面、需要自身独立的生命周期和保存状态时适用，独立于导航图中任何其他目的地。对于 `AlertDialog` 等用例，
 * 应直接在需要显示该对话框的 [composable] 目的地中使用相关 API。
 *
 * @param T 由 KClass 生成的目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[T]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 对话框属性 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地 Composable 内容
 */
inline fun <reified T : Any> NavGraphBuilder.对话框(
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    对话框属性: DialogProperties = DialogProperties(),
    noinline 内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog<T>(
        typeMap = 类型映射,
        deepLinks = 深度链接,
        dialogProperties = 对话框属性,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder]，它将在 [androidx.compose.ui.window.Dialog] 中承载。仅当此对话框
 * 代表应用中独立的界面、需要自身独立的生命周期和保存状态时适用，独立于导航图中任何其他目的地。对于 `AlertDialog` 等用例，
 * 应直接在需要显示该对话框的 [composable] 目的地中使用相关 API。
 *
 * @param 路由 由 [T] 的 [KClass] 生成的目的地路由
 * @param 类型映射 目的地参数 Kotlin 类型 `[KType]` 到其对应自定义 `[NavType]` 的映射表；若 `[路由]` 未使用自定义 NavType，则可为空。
 * @param 深度链接 要与这些目的地关联的深层链接列表
 * @param 对话框属性 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地 Composable 内容
 */
fun <T : Any> NavGraphBuilder.对话框(
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接: List<NavDeepLink> = emptyList(),
    对话框属性: DialogProperties = DialogProperties(),
    内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog(
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接,
        dialogProperties = 对话框属性,
        content = 内容
    )
}
