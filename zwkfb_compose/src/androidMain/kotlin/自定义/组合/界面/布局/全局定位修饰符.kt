package 自定义.组合.界面.布局

import android.graphics.Rect
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import 自定义.状态栏类.状态栏沉浸式类

/**
 * 修复网页打开编辑框键盘显示的Bug
 */
@Stable
fun Modifier.修复网页打开编辑框键盘显示的Bug(): Modifier = composed {
    val 上下文 = LocalActivity.current
    val 预览模式 = LocalInspectionMode.current
    val 根布局 = LocalView.current
    var 导航栏高度 by remember { mutableIntStateOf(0) }
    // 监听键盘状态
    val 事件 = ViewTreeObserver.OnGlobalLayoutListener {
        val rect = Rect()
        根布局.getWindowVisibleDisplayFrame(rect)
        //val screenHeight = 根布局.height
        //val newKeyboardHeight = screenHeight - rect.bottom
        // 当键盘高度超过屏幕高度的15%时，认为键盘已显示
        //是否键盘显示 = newKeyboardHeight > screenHeight * 0.15
    }
    根布局.viewTreeObserver.addOnGlobalLayoutListener(事件)
    // 修复键盘遮挡问题的工具类
    if (!预览模式){
        val content: FrameLayout = 上下文!!.findViewById(android.R.id.content)
        val rootView = content.getChildAt(0)
        ViewCompat.setOnApplyWindowInsetsListener(rootView!!) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, 0)
            insets
        }
        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)
            val screenHeight = rootView.rootView.height
            val currentKeyboardHeight = screenHeight - rect.bottom
            if (currentKeyboardHeight > screenHeight * 0.15) {
                // 键盘显示时，动态调整WebView底部内边距
                rootView.layoutParams = (rootView.layoutParams as ViewGroup.MarginLayoutParams).apply {
                    bottomMargin = currentKeyboardHeight - 导航栏高度 - 状态栏沉浸式类.获取导航栏高度(上下文)
                }
            } else {
                // 键盘隐藏时恢复原始状态
                rootView.layoutParams = (rootView.layoutParams as ViewGroup.MarginLayoutParams).apply {
                    bottomMargin = 0
                }
            }
            rootView.requestLayout()
        }
    }
    this.onGloballyPositioned { coordinates ->
        导航栏高度 = coordinates.size.height // 获取底部栏的实际高度(单位:像素)
    }
}
