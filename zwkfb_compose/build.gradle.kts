plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.android.lint)

    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

kotlin {

    // 目标声明 - 根据需要添加或删除以下内容。这些定义了此 KMP 模块支持的平台。
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "zwkfb.compose"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        minSdk = 24

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    // 源集合声明。 声明一个目标会自动创建一个同名的源代码集（source set）。默认情况下，Kotlin Gradle 插件会创建相互依赖的额外源代码集，
    // 因为在相关目标之间共享源代码是很常见的做法。
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // 在此添加KMP依赖项

//                implementation("org.jetbrains.compose.runtime:runtime:1.9.3")
//                implementation("org.jetbrains.compose.foundation:foundation:1.9.3")
//                implementation("org.jetbrains.compose.material:material:1.9.3")
//                implementation("org.jetbrains.compose.ui:ui:1.9.3")
//                implementation("org.jetbrains.compose.ui:ui-tooling:1.9.3")
//                implementation("org.jetbrains.compose.components:components-ui-tooling-preview:1.9.3")
//                implementation("org.jetbrains.compose.components:components-resources:1.9.3")

                //========================================================================

                api("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")
                api("androidx.activity:activity-compose:1.13.0")

                //========================================================================

                api("androidx.compose:compose-bom:2026.03.00")

                //========================================================================

                // 是 Jetpack Compose 的「核心 UI 框架」依赖库，它提供了构建任何 Compose 界面所必需的最底层 API 和运行时能力。
                // 就是 Compose 世界的“地基”：没有它，任何 @Composable 函数都无法绘制到屏幕上。
                api("androidx.compose.ui:ui:1.11.0-beta01")
                // 是 Jetpack Compose 官方提供的图形绘制与图像处理库，属于 compose.ui 体系中的 图形子模块。
                api("androidx.compose.ui:ui-graphics:1.11.0-beta01")
                api("androidx.compose.ui:ui-tooling:1.11.0-beta01")
                // 是 Jetpack Compose 官方提供的“预览注解支持库”，仅包含在开发阶段用于 Android Studio 预览功能的注解与接口，不会被打包进正式发布的 APK 中。
                api("androidx.compose.ui:ui-tooling-preview:1.11.0-beta01")

                //========================================================================

                // 是 Jetpack Compose 官方提供的 Material Design 组件库，包含 Material Design 的所有组件，
                // 适用于 Jetpack Compose 项目。
                api("androidx.compose.material3:material3:1.5.0-alpha15")

                //========================================================================

//                api("androidx.compose.material:material:1.10.1")

                // 是 Jetpack Compose 官方提供的「完整版」Material Design 图标扩展库，包含 全部 Material Icons（超过 2,000 个图标），
                // 可直接在 Compose 代码中以 ImageVector 形式使用。
                api("androidx.compose.material:material-icons-extended:1.7.8")

                // 是 Jetpack Compose 中 Material Icons 的官方实现库，包含了 1000 多个 Material Icons，
                // 可直接在 Compose 代码中以 ImageVector 形式使用。
//                api("androidx.compose.material:material-icons-core:1.7.8")

                //========================================================================

                // 是 Jetpack Compose 中 Foundation Layout 模块的 Android 专用实现版本，它提供了用于构建响应式 UI 的核心布局组件和工具。
                api("androidx.compose.foundation:foundation:1.11.0-beta01")

                //========================================================================

                //  是 Navigation 组件在 Jetpack Compose 中的官方集成库，简称 “Compose Navigation”。
                // 它让你在 100% Compose 项目 里，用声明式 API 完成导航图的构建、路由跳转、参数传递、深层链接、返回栈管理等所有导航需求。
                api("androidx.navigation:navigation-compose:2.10.0-alpha01") // 导航

                //========================================================================



            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // 在此处添加 Android 特定的依赖项。请注意，此源代码集默认依赖于 commonMain，并且会正确拉取在 commonMain
                // 中声明的任何 KMP 依赖项的 Android 构件。

//                implementation(compose.preview)
//                implementation(compose.ui)
//                implementation(compose.uiTooling)
//                implementation(compose.uiUtil)
//                implementation(libs.androidx.compose.ui)
//                implementation(libs.androidx.compose.ui.graphics)
//                implementation(libs.androidx.compose.ui.tooling)
//                implementation(libs.androidx.compose.ui.tooling.preview)
//                implementation(libs.androidx.compose.material3)
//                implementation(libs.androidx.activity.compose)

                api("com.github.dxycw:zwkfb_view:0.3.6"){

//                    exclude("mysql", "mysql-connector-java")
//
//                    exclude("androidx.webkit", "webkit")
//
//                    exclude("com.github.OCNYang.ImmersionBar", "immersionbar-ktx")
//                    exclude("com.gitee.zackratos", "UltimateBarX")
//
//                    // 如果使用了“media3”的"media3-datasource-okhttp"这个也要注释掉。
//                    exclude("com.squareup.okhttp3", "okhttp")
//                    exclude("com.google.code.gson", "gson")
//                    exclude("io.noties.markwon", "core")
//
//                    exclude("androidx.media3", "media3-exoplayer")
//                    exclude("androidx.media3", "media3-datasource-okhttp")
//                    exclude("androidx.media3", "media3-ui")
//
//                    exclude("com.github.CarGuo.GSYVideoPlayer", "gsyvideoplayer")
//                    exclude("com.github.bilibili.DanmakuFlameMaster", "DanmakuFlameMaster")
//
//                    // 使用下面库需要 需要添加 “https://maven.mozilla.org/maven2” 仓库，否则不要注释掉，不添加仓库会报错。
//                    exclude("org.mozilla.geckoview", "geckoview-nightly")
//                    exclude("org.mozilla.geckoview", "geckoview-exoplayer2-nightly")
//
//                    exclude("com.github.jenly1314", "zxing-lite")

                }

            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.junit)
            }
        }

    }

}