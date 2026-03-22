package com.dxyc.zwkfb_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxyc.zwkfb_compose.ui.theme.AppTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import 安卓x.活动.启用边缘到边缘
import 安卓x.活动.组件活动
import 安卓x.活动.组合.本地活动
import 安卓x.活动.组合.置内容
import 安卓x.组合.基础.布局.列
import 安卓x.组合.基础.文本.选择.选择容器
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.日期选择器
import 安卓x.组合.材质3.模态底部面板
import 安卓x.组合.材质3.线性进度指示器
import 安卓x.组合.材质3.脚手架
import 安卓x.组合.界面.修饰符


class MainActivity : 组件活动() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        启用边缘到边缘()
        置内容 {
            Home()
            //SimpleDrawer()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_DESK)
@Composable
fun Home() {
    AppTheme {
        val 上下文 = 本地活动.current
        val 状态 = remember { SnackbarHostState() }
        val 范围 = rememberCoroutineScope()
        脚手架(
            修饰符 = 修饰符.fillMaxSize(),
            提示条容器 = { SnackbarHost(状态) },
            悬浮操作按钮 = {
                ExtendedFloatingActionButton(
                    onClick = {
                        范围.launch {
                            val result = 状态.showSnackbar(
                                message = "Snackbar Message",//消息内容文字
                                // Action 按钮显示文字,设置后会有一个 Action 按钮
                                actionLabel = "确定",
                                // 显示时长 Short、Long 参考 Toast, Indefinite 一直显示 不会自动消失
                                duration = SnackbarDuration.Short,//Indefinite,
                                // 是否显示 Dismiss Action 按钮 ，true 的话最右边会有一个 X 的按钮
    //                            withDismissAction = true
                            )

                            when (result) {
                                //点击了 显示时配置的 Action 按钮
                                SnackbarResult.ActionPerformed -> {}
                                //点击了 X 按钮
                                SnackbarResult.Dismissed -> {}
                            }
                        }
//                        上下文!!.切换窗口(欢迎窗口::class.java)
                    }
                ) { 文本(文本 = "显示") }
            },
        ) { 内边距 ->

            var 显示日期选择器 by remember { mutableStateOf(false) }
            选择容器{
                列(
                    修饰符 = 修饰符.padding(内边距)
//                        .verticalScroll(rememberScrollState())
                ) {
//                    ClickToLoadLinear()

                    按钮(单击回调 = { 显示日期选择器 = !显示日期选择器 }) { 文本(文本 = "显示") }

                    图标按钮(
                        单击回调 = {}
                    ){ 图标(Icons.Filled.ArrowDropDown, 内容描述 = null) }
                    var 状态2 by remember { mutableStateOf(false) }
                    RadioButton(
                        selected = 状态2,
                        onClick = {
                            状态2 = !状态2
                        }
                    )

                    var 状态1 by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = 状态1,
                        onCheckedChange = {
                            状态1 = it
                        }
                    )

                    var 状态 by remember { mutableStateOf(ToggleableState.Indeterminate) }
                    TriStateCheckbox(
                        state = 状态,
                        onClick = {
                            if (状态 == ToggleableState.Off) {
                                状态 = ToggleableState.On
                            } else if (状态 == ToggleableState.On) {
                                状态 = ToggleableState.Indeterminate
                            } else {
                                状态 = ToggleableState.Off
                            }
                        }
                    )

                }
            }

            if (显示日期选择器) {

                模态底部面板(
                    取消请求回调 = { 显示日期选择器 = false },
                    拖动手柄 = null
                ) {
                    列(水平对齐 = Alignment.CenterHorizontally) {
                        BottomSheetDefaults.DragHandle()
                        日期选择器(
                            状态 = rememberDatePickerState(),
                            颜色 = DatePickerDefaults.colors(
                                containerColor = BottomSheetDefaults.ContainerColor,//MaterialTheme.colorScheme.background,
//                                navigationContentColor = Color.Red,
                            ),
                        )
                    }
                }

            }

        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDrawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope  = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("抽屉标题", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text("首页") },
                    selected = true,
                    onClick = { scope.launch { drawerState.close() } }
                )
                NavigationDrawerItem(
                    label = { Text("设置") },
                    selected = false,
                    onClick = { scope.launch { drawerState.close() } }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("主界面") },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "打开抽屉")
                        }
                    }
                )
            }
        ) { innerPadding ->
            // 主屏幕内容
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("主屏幕")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ClickToLoadLinear() {
    // 当前进度：0..100
    var 进度 by remember { mutableIntStateOf(0) }
    // 是否正在加载（防止重复点击）
    var 加载中 by remember { mutableStateOf(false) }
    // 是否暂停状态
    var 暂停 by remember { mutableStateOf(false) }
    // 添加一个job引用以便能够取消
    var 加载中Job by remember { mutableStateOf<Job?>(null) }

    val scope = rememberCoroutineScope()
    //    保存协程作用域
    列 (
        修饰符 = Modifier.padding(10.dp),
        水平对齐 = Alignment.CenterHorizontally
    ) {
        // 进度条
        线性进度指示器(
//            进度 = { progress / 100f },
            修饰符 = Modifier.fillMaxWidth().padding(16.dp),
//            绘制终止指示器 = {}
        )

        线性进度指示器(
            进度 = { 进度 / 100f },
            修饰符 = Modifier.fillMaxWidth().padding(16.dp),
            绘制停止指示器 = {}
        )

        LinearWavyProgressIndicator(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        LinearWavyProgressIndicator(
            progress = { 进度 / 100f },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            stopSize = 0.dp
        )

        文本(文本 = "单击进度条开始加载：$进度%")

        按钮 (
            单击回调 = {
                if (!加载中 || 暂停) {
                    // 如果未运行或已暂停，则开始/恢复加载
                    加载中 = true
                    暂停 = false
                    加载中Job = scope.launch {
                        while (进度 < 100 && 加载中 && !暂停) {
                            delay(50)  // 每 50 ms 前进一次
                            进度 += 1
                        }
                        // 只有正常完成才设为false
                        if (进度 >= 100) {
                            加载中 = false
                            暂停 = false
                        }
                    }
                }
            },
            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
            已启用 = !加载中 || 暂停 // 未运行或已暂停时可用
        ) {
            文本(
                文本 = when {
                    暂停 -> "继续"
                    加载中 -> "加载中..."
                    else -> "加载"
                }
            )
        }

        按钮(
            单击回调 = {
                // 如果正在运行，则暂停加载
                if (加载中 && !暂停) {
                    暂停 = true
                    加载中Job?.cancel()
                }
            },
            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
            已启用 = 加载中 && !暂停 // 正在运行且未暂停时可用
        ) { 文本(文本 = "暂停") }

        按钮(
            单击回调 = {
                // 停止加载并重置进度
                加载中 = false
                暂停 = false
                进度 = 0
                加载中Job?.cancel()
            },
            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
            已启用 = 加载中 || 进度 > 0 // 正在运行或有进度时可用
        ) { 文本(文本 = "重置") }

    }
}

