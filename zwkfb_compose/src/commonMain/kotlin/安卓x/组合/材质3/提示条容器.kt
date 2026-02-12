package 安卓x.组合.材质3

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * [提示条] 的宿主，用于 [脚手架] 中，根据 Material 规范和 [容器状态] 正确显示、隐藏和关闭项目。
 *
 * 此组件带有默认参数，内置于 [脚手架] 中。如需显示默认 [提示条]，请使用 [SnackbarHostState.showSnackbar]。
 *
 * 如需自定义 [提示条] 的外观，可将自己的版本作为 [SnackbarHost] 的子项传递给 [脚手架]：
 *
 * @param 容器状态 此组件的状态，用于读取并相应显示 [提示条]
 * @param 修饰符 要应用于此组件的 [Modifier]
 * @param 提示条 要在适当时机显示的 [提示条] 实例，其外观基于作为参数提供的 [SnackbarData]
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 提示条容器(
    容器状态: SnackbarHostState,
    修饰符: Modifier = Modifier,
    提示条: @Composable (SnackbarData) -> Unit = { Snackbar(it) },
) {
    SnackbarHost(
        hostState = 容器状态,
        modifier = 修饰符,
        snackbar = 提示条,
    )
}

