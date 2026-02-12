package com.dxyc.zwkfb_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dxyc.zwkfb_compose.ui.theme.AppTheme
import 安卓x.活动.组合.置内容
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.脚手架
import kotlin.collections.forEachIndexed
import kotlin.collections.groupBy
import kotlin.text.first

class 欢迎窗口 : ComponentActivity() {

//    override fun 附加基础上下文(新基础上下文: Context?) {
//        super.附加基础上下文(应用语言设置.封装上下文(新基础上下文!!))
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        置内容 { 欢迎界面() }
    }

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@SuppressLint("ComposableNaming")
@Composable
fun 欢迎界面() {
    AppTheme(){
        脚手架(
            悬浮操作按钮 = {
                Button(
                    onClick = {}
                ){
                    文本(
                        文本 = stringResource(R.string.app_name),
                        颜色 = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        ){ 内边距 ->
            Column (
                modifier = Modifier.padding(内边距)
                    .fillMaxSize()
            ) {
                文本(
                    文本 = "欢迎来到灵阁！",
                    修饰符 = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 30.dp),
                    颜色 = MaterialTheme.colorScheme.primary,
                    字体大小 = 35.sp
                )

                LinearWavyProgressIndicator(
                    progress = { 0.5f },
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
                    color = MaterialTheme.colorScheme.primary,
                    stopSize = 0.dp
                )

                val 页面状态 = rememberPagerState { 3 }

                HorizontalPager(
                    state = 页面状态,
                ) { 页面 ->
                    when (页面) {
                        0 -> {
                            系统语言设置界面()
                        }
                        1 -> {
                            系统语言设置界面()
                        }
                        2 -> {
                            系统语言设置界面()
                        }
                    }
                }
            }
        }
    }
}

//=======================================================

@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 系统语言设置界面(){
    Column (modifier = Modifier.fillMaxSize()) {

        val count = 4
        val colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
        Column(
            modifier = Modifier.selectableGroup().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap),
        ) {
            var selectedIndex: Int? by rememberSaveable { mutableStateOf(null) }
            repeat(count) { idx ->
                val selected = selectedIndex == idx
                SegmentedListItem(
                    selected = selected,
                    onClick = { selectedIndex = idx },// if (selected) null else
                    colors = colors,
                    shapes = ListItemDefaults.segmentedShapes(index = idx, count = count),
                    leadingContent = { RadioButton(selected = selected, onClick = null) },
                    trailingContent = {
                        if (selected) Icon(Icons.Default.Favorite, contentDescription = null)
                    },
                    supportingContent = { Text("Additional info") },
                    content = { Text("Item ${idx + 1}") },
                )
            }
        }

//        SegmentedListDemo()

        var expanded by rememberSaveable { mutableStateOf(false) }
        val numChildren = 3
        val itemCount = 1 + if (expanded) numChildren else 0
        val childrenChecked = rememberSaveable { mutableStateListOf(*Array(numChildren) { false }) }

        val color =
            ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainer)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap),
        ) {
            Spacer(Modifier.height(100.dp))
            SegmentedListItem(
                onClick = { expanded = !expanded },
                modifier =
                    Modifier.semantics { stateDescription = if (expanded) "Expanded" else "Collapsed" },
                colors = color,
                shapes = ListItemDefaults.segmentedShapes(index = 0, count = itemCount),
                leadingContent = { Icon(Icons.Default.Favorite, contentDescription = null) },
                trailingContent = {
                    Icon(
                        if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                    )
                },
                content = { Text("Click to expand/collapse") },
            )
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(MaterialTheme.motionScheme.fastSpatialSpec()),
                exit = shrinkVertically(MaterialTheme.motionScheme.fastSpatialSpec()),
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)) {
                    repeat(numChildren) { idx ->
                        SegmentedListItem(
                            checked = childrenChecked[idx],
                            onCheckedChange = { childrenChecked[idx] = it },
                            colors = color,
                            shapes =
                                ListItemDefaults.segmentedShapes(
                                    index = idx + 1,
                                    count = itemCount
                                ),
                            leadingContent = {
                                Icon(Icons.Default.Favorite, contentDescription = null)
                            },
                            trailingContent = {
                                Checkbox(checked = childrenChecked[idx], onCheckedChange = null)
                            },
                            content = { Text("Child ${idx + 1}") },
                        )
                    }
                }
            }
        }

    }
}

//=======================================================

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SegmentedListDemo() {
    // 模拟数据：按首字母分组
    val data = remember {
        listOf(
            "Apple",
            "Apricot",
            "Banana",
            "Blueberry",
            "Cherry",
            "Cranberry",
            "Date",
            "Grape",
            "Kiwi",
            "Lemon",
            "Mango",
            "Melon",
            "Orange",
            "Peach",
            "Pear",
            "Pineapple",
            "Plum",
            "Raspberry",
            "Strawberry",
            "Tangerine",
            "Watermelon"
        )
            .groupBy { it.first() }   // Map<A,List<>>
    }

    LazyColumn(Modifier.fillMaxSize()) {
        data.forEach { (initial, items) ->
            stickyHeader {                 // 分段标题
                Text(
                    text = initial.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFEEEEEE))
                        .padding(12.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            items(items) { fruit ->        // 分段内的行
                Text(
                    text = fruit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* todo */ }
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
        }
    }
}

//=======================================================

@Composable
fun SegmentedColumn(
    list: List<String>,
    current: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.selectableGroup()) {
        list.forEachIndexed { idx, txt ->
            val selected = txt == current
            val bg  by animateColorAsState(
                if (selected) MaterialTheme.colorScheme.primaryContainer
                else Color.Transparent,
                tween(120)
            )
            val tint by animateColorAsState(
                if (selected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                tween(120)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shapeFor(idx, list.size))          // 只切圆角，不加 border
                    .background(bg)
                    .toggleable(
                        value = selected,
                        role = Role.RadioButton,
                        onValueChange = { onSelect(txt) }
                    )
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Text(
                    text = txt,
                    style = MaterialTheme.typography.bodyLarge,
                    color = tint,
                    modifier = Modifier.weight(1f)
                )
                if (selected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

/* 圆角工具 */
private fun shapeFor(index: Int, total: Int): Shape = when {
    total == 1 -> RoundedCornerShape(12.dp)
    index == 0 -> RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
    index == total - 1 -> RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp)
    else -> RectangleShape
}

//=======================================================

//@Preview
//@SuppressLint("ComposableNaming")
//@Composable
//fun 欢迎界面1() {
//    AppTheme {
//        val 上下文 = 本地活动.current
//        脚手架(
//            内容窗口插入 = WindowInsets.statusBars
//        ) { 内边距 ->
//            Column(
//                modifier = Modifier.padding(内边距).fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
////                stringResource(R.string.切换语言)
//                文本(文本 = "切换语言",
//                    修饰符 = Modifier.padding(16.dp))
//
//                Button(
//                    onClick = {
//                        val 语言集 = listOf("","en", "zh", "ja") // 支持的语言
//                        val 语言名称集 = listOf("系统默认", "English", "中文", "日本語")
//                        val 当前语言 = 应用语言设置.取应用语言(上下文)
//                        val 选中索引 = 语言集.indexOf(当前语言)
//
//                        AlertDialog.Builder(上下文)
//                            .setTitle("选择语言")
//                            .setSingleChoiceItems(
//                                语言名称集.toTypedArray(), 选中索引
//                            ) { 对话框, 序号 ->
//                                val 已选择的语言 = 语言集[序号]
//                                if (已选择的语言 != 当前语言) {
//                                    应用语言设置.置应用语言(上下文, 已选择的语言)
//                                }
//                                对话框.dismiss()
//                            }
//                            .show()
//
//                    }
//                ){ 文本(文本 = "语言选择对话框") }
//
//                Button (onClick = { 应用语言设置.置应用语言(上下文!!, "") }
//                ){ 文本(文本 = "系统默认") }
//
//                Button(onClick = { 应用语言设置.置应用语言(上下文!!, "zh") }
//                ){ 文本(文本 = "中文") }
//
//                Button(onClick = { 应用语言设置.置应用语言(上下文!!, "zh-TW") }
//                ){ 文本(文本 = "台湾") }
//
//                Button(onClick = { 应用语言设置.置应用语言(上下文!!, "zh-HK") }
//                ){ 文本(文本 = "香港") }
//
//                Button(onClick = { 应用语言设置.置应用语言(上下文!!, "en") }
//                ){ 文本(文本 = "English") }
//
//                Button(onClick = { 应用语言设置.置应用语言(上下文!!, "ja") }
//                ){ 文本(文本 = "日本語") }
//
//                Button(onClick = { 应用语言设置.打开系统设置语言界面(上下文!!) }
//                ){ 文本(文本 = "系统设置") }
//            }
//        }
////        stringResource(R.string.hello)
//    }
//}


