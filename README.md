# EsriAndroidSDK

本项目只对常用的Arcgis服务接口进行封装。

# 开始使用

```groovy

// 添加仓库地址
repositories {
    maven { url 'https://maven.raeblog.com/repository/public/' }
}

// 引用库
dependencies {

    implementation 'com.github.raedev:esri-sdk:1.0.0'

    // 以下的依赖库，根据项目需要引用。
    implementation 'io.reactivex.rxjava3:rxkotlin:3.0.1'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:4.10.0'
    implementation 'com.google.code.gson:gson:2.9.1'
}

```

# 使用说明

```kotlin

fun demo() {
    // 使用Retrofit创建接口并调用
    val params = EsriQueryParams()
    params.where = "1=1"
    retrofit.create(EsriMapServerApi::class.java).query(
        "http://192.168.0.1:6080/arcgis/rest/services/test/MapServer/0/query",
        params
    )
}

```
