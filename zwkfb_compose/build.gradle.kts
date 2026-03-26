plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.android.lint)

    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

kotlin {

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

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                //========================================================================

                api("org.jetbrains.compose.runtime:runtime:1.10.3")
                api("org.jetbrains.compose.foundation:foundation:1.10.3")
                api("org.jetbrains.compose.material3:material3:1.11.0-alpha04")
                api("org.jetbrains.compose.ui:ui:1.11.0-alpha04")
                api("org.jetbrains.compose.ui:ui-graphics:1.11.0-alpha04")
                api("org.jetbrains.compose.ui:ui-tooling:1.11.0-alpha04")
                api("org.jetbrains.compose.ui:ui-tooling-preview:1.11.0-alpha04")
                api("org.jetbrains.compose.components:components-resources:1.11.0-alpha04")

                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0-alpha01")
                api("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.11.0-alpha01")

                //========================================================================

//                api("org.jetbrains.compose.material:material:1.11.0-alpha04")
                api("org.jetbrains.compose.material:material-icons-extended:1.7.3")
//                api("org.jetbrains.compose.material:material-icons-core:1.7.3")

                //========================================================================

                api("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
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