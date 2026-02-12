package 安卓x.组合.材质3

import android.text.format.DateFormat.is24HourFormat
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

internal actual val is24HourFormat: Boolean
    @Composable @ReadOnlyComposable get() = is24HourFormat(LocalContext.current)
