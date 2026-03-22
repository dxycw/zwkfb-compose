# zwkfb_compose

[![](https://jitpack.io/v/dxycw/zwkfb_compose.svg)](https://jitpack.io/#dxycw/zwkfb_compose)

本项目是中文开发的开发包项目，适用于Android的Jetpack Compose版。
如果你使用的的是xml布局项目，请使用[zwkfb_view](https://github.com/dxycw/zwkfb_view)。

# 使用方法

1、在项目的 settings.gradle 文件中添加 JitPack 仓库：

* Groovy 版本：
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }  // 添加 JitPack 仓库
        maven { url 'https://maven.mozilla.org/maven2' } // 使用org.mozilla.geckoview依赖库需要添加此仓库
    }
}
```

* Kotlin 版本：
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
        maven { url = uri("https://maven.mozilla.org/maven2") } // 使用org.mozilla.geckoview依赖库需要添加此仓库
    }
}
```

2、在项目的 build.gradle 文件中添加依赖项：

* Groovy 版本：
```groovy
dependencies {
    implementation 'com.github.dxycw:zwkfb_compose:0.1.3'
}
```

* Kotlin 版本：
```kotlin
dependencies {
    implementation("com.github.dxycw:zwkfb_compose:0.1.3")
}
```

3、就可以在项目中使用了。

# 使用的依赖库

下面是本依赖库所有使用的依赖库。

## 官方依赖库

* androidx.lifecycle:lifecycle-runtime-ktx:2.10.0
* androidx.activity:activity-compose:1.13.0
* androidx.compose:compose-bom:2026.03.00
* androidx.compose.ui:ui:1.11.0-beta01
* androidx.compose.ui:ui-graphics:1.11.0-beta01
* androidx.compose.ui:ui-tooling:1.11.0-beta01
* androidx.compose.ui:ui-tooling-preview:1.11.0-beta01
* androidx.compose.material3:material3:1.5.0-alpha15
* androidx.compose.material:material-icons-extended:1.7.8
* androidx.compose.foundation:foundation:1.11.0-beta01
* androidx.navigation:navigation-compose:2.10.0-alpha01

## 其他依赖库

* com.github.dxycw:zwkfb_view:0.3.6

# 打包体积压缩

如果使用混淆并且使用了“MySQL”、“Geckoview”依赖库，请查看[打包体积压缩](%E6%89%93%E5%8C%85%E4%BD%93%E7%A7%AF%E5%8E%8B%E7%BC%A9.md)。


# 更新内容

## 0.1.3

* 更新 com.github.dxycw:zwkfb_view依赖库版本为0.3.6；
* 更新 androidx.compose.material3:material3依赖库版本为1.5.0-alpha15；
* 更新 androidx.compose.ui的所有依赖库版本为1.11.0-beta01；
* 更新 androidx.activity:activity-compose依赖库版本为1.13.0；
* 更新 androidx.compose.foundation:foundation依赖库版本为1.11.0-beta01；
* 更新 androidx.navigation:navigation-compose依赖库版本为2.10.0-alpha01；
* 更新 androidx.compose:compose-bom依赖库版本为2026.03.00；
* 修复 “菜单”更新material3后报错的Bug；

## 0.1.2

* 重写项目，迁移到 Gradle 守护进程工具链；
* 升级 gradle版本为9.2.1，kotlin版本为2.3.10
* 更新 com.github.dxycw:zwkfb_view依赖库版本为0.2.5；
* 添加 com.github.dxycw:zwkfb_view依赖库添加com.mysql:mysql-connector-j依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加com.github.OCNYang.ImmersionBar:immersionbar-ktx依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加com.gitee.zackratos:UltimateBarX依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加org.mozilla.geckoview:geckoview-nightly依赖库(注意：添加此依赖库需要添加 “https://maven.mozilla.org/maven2” 仓库，请查看使用方法)；
* 添加 com.github.dxycw:zwkfb_view依赖库添加org.mozilla.geckoview:geckoview-exoplayer2-nightly依赖库(注意：添加此依赖库需要添加 “https://maven.mozilla.org/maven2” 仓库，请查看使用方法)；

## 0.1.1

* 新增 四个“导航容器()”、“徽章盒()”、“徽章()”、两个“提示条()”、“提示条容器()”、两个“标签()”、“前导图标标签()”、“主标签行()”、“次标签行()”、“主可滚动标签行()”、“次可滚动标签行()”、“标签行()”、“可滚动标签行()”、两个“图标按钮()”、两个“图标切换按钮()”、两个“填充图标按钮()”、两个“填充图标切换按钮()”、两个“填充色调图标按钮()”、两个“填充色调图标切换按钮()”、两个“轮廓图标按钮()”、两个“轮廓图标切换按钮()”、“单选分段按钮行()”、“多选分段按钮行()”组件；
* 新增 NavGraphBuilder的三个“可组合()”，五个“导航()”、三个“对话框()”函数；
* 新增 “徽章默认值”、“提示条默认值”、“标签行默认值”、“分段按钮默认值”对象类；
* 新增 BadgeDefaults“容器颜色”属性；
* 新增 SnackbarDefaults“形状”、“颜色”、“内容颜色”、“动作颜色”、“动作内容颜色”、“关闭动作内容颜色”属性；
* 新增 TabRowDefaults“可滚动标签行最小标签宽度”、“可滚动标签行起始内边距”、“容器颜色”、“主容器颜色”、“次容器颜色”、“内容颜色”、“主内容颜色”、“次内容颜色”属性；
* 新增 TabRowDefaults“指示器()”、“主指示器()”、“次指示器()”属性；
* 新增 SingleChoiceSegmentedButtonRowScope添加“分段按钮()”函数；
* 新增 MultiChoiceSegmentedButtonRowScope添加“分段按钮()”函数；
* 新增 SegmentedButtonDefaults添加“基础形状”、“边框宽度”、“图标大小”、“内容内边距”属性，两个“颜色()”、“项形状()”、“活动图标()”、“图标()”、“边框描边()”函数；
* 添加 com.github.dxycw:zwkfb_view依赖库添加androidx.media3:media3-exoplayer依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加androidx.media3:media3-datasource-okhttp依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加androidx.media3:media3-ui依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加com.github.CarGuo.GSYVideoPlayer:gsyvideoplayer依赖库；
* 添加 com.github.dxycw:zwkfb_view依赖库添加com.github.bilibili.DanmakuFlameMaster:DanmakuFlameMaster依赖库；

## 0.1.0

* 新增 三个“文本字段()”、三个“基本文本字段()”、三个“轮廓文本字段()”、“加密文本字段()”、“轮廓加密文本字段()”、“基础加密文本字段()”、三个“搜索栏()”、“顶部搜索栏()”、“应用栏带搜索()”、“展开全屏内置搜索栏()”、“展开全屏搜索栏()”、“扩展停靠搜索栏带间隙()”、“展开停靠搜索栏()”、两个“停靠搜索栏()”、“日期选择器()”、两个“顶部应用栏()”、“居中顶部应用栏()”、“中等顶部应用栏()”、“中等伸缩顶部应用栏()”、“大型顶部应用栏()”、“大型伸缩顶部应用栏()”、“双行顶部应用栏()”、四个“底部应用栏()”、“伸缩底部应用栏()”、“模态底部面板()”、“底部面板脚手架()”、“日期范围选择器()”、“时间选择器()”、“时间输入()”、“日期选择器对话框()”、“下拉菜单()”、“下拉菜单弹出()”、“下拉菜单组()”、四个“下拉菜单项()”、“水平分页器()”、“垂直分页器()”组件；
* 新增 “文本字段颜色”、“搜索栏状态”、“搜索栏颜色”、“应用栏带搜索颜色”、“日期选择器颜色”、“顶部应用栏颜色”类；
* 新增 “文本字段标签范围” 、“搜索栏滚动行为”、“日期选择器状态”、“可选日期”、“日期选择器格式化”接口类；
* 新增 “文本字段默认值”、“轮廓文本字段默认值”、“文本混淆模式”、“搜索栏值”、“搜索栏默认值”、“显示模式”、“日期选择器默认值”、“顶部应用栏默认值”、“底部应用栏默认值”、“模态底部面板默认值”、“日期范围选择器默认值”、“时间选择器默认值”、“时间选择器布局类型”、“时间选择模式”、“分页器默认值”对象类；
* 新增 “记住搜索栏状态()”、“记住日期选择器状态()”、“日期选择器状态()”、“记住顶部应用栏状态()”、“记住底部应用栏状态()”、“底部应用栏状态()”、“记住模态底部面板状态()”、“记住底部面板脚手架状态()”、“记住标准底部表状态()”、“记住日期范围选择器状态()”、“日期范围选择器状态()”、“记住时间选择器状态()”、“时间选择器状态()”函数；
* 新增 “本地单行顶部应用栏重写”、“本地双行顶部应用栏重写”属性；
* 新增 ModalBottomSheetDefaults添加“属性”属性及“属性()”函数；
* 新增 TimePickerState添加“是否下午”、“是否小时输入有效”、“是否分钟输入有效”、“是否输入有效”属性；
* 新增 PagerDefaults添加“超出视图页面数”属性、“抛掷行为()”、“页面嵌套滚动连接()”函数；
* 新增 androidx.navigation:navigation-compose版本为2.9.6的依赖库；
* 更新 androidx.compose.material3:material3版本为[1.5.0-alpha12](https://developer.android.google.cn/jetpack/androidx/releases/compose-material3?hl=zh-cn#1.5.0-alpha12)；
* 更新 androidx.compose.ui:ui版本为[1.10.1](https://developer.android.google.cn/jetpack/androidx/releases/compose-ui?hl=zh-cn#1.10.1)；
* 更新 androidx.compose.ui:ui-graphics版本为[1.10.1](https://developer.android.google.cn/jetpack/androidx/releases/compose-ui?hl=zh-cn#1.10.1)；
* 更新 androidx.compose.ui:ui-tooling版本为[1.10.1](https://developer.android.google.cn/jetpack/androidx/releases/compose-ui?hl=zh-cn#1.10.1)；
* 更新 androidx.compose.ui:ui-tooling-preview版本为[1.10.1](https://developer.android.google.cn/jetpack/androidx/releases/compose-ui?hl=zh-cn#1.10.1)；
* 更新 androidx.activity:activity-compose:[1.13.0-alpha01](https://developer.android.google.cn/jetpack/androidx/releases/activity?hl=zh-cn#1.13.0-alpha01)；
* 更新 androidx.compose.foundation:foundation:[1.11.0-alpha03](https://developer.android.google.cn/jetpack/androidx/releases/compose-foundation?hl=zh-cn#1.11.0-alpha03)；

# 老版本更新日志

[0.0.x系列更新内容](%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.0.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E5%86%85%E5%AE%B9.md)
