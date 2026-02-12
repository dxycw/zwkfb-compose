package 安卓x.活动.组合

import android.annotation.SuppressLint
import androidx.activity.compose.LocalActivity
import androidx.compose.ui.platform.LocalContext


/**
 * 提供当前 [LocalContext] 所属的 [android.app.Activity]。
 *
 * 请注意，只要可行，你应始终优先使用粒度更细、已提供的 CompositionLocal。仅当所需 API 只能通过 [android.app.Activity] 获取时，才应回退使用此 API。
 *
 * 看 [androidx.compose.ui.platform.LocalConfiguration][androidx.compose.ui.platform.LocalLifecycleOwner]
 * [androidx.compose.ui.platform.LocalView]
 */
@SuppressLint("CompositionLocalNaming")
val 本地活动 = LocalActivity

