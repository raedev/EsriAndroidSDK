package com.esri.test

import android.util.Log
import androidx.swift.sword.provider.RetrofitFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.esri.sdk.EsriMapServerApi
import com.esri.sdk.bean.EsriQueryParams
import com.google.gson.Gson
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EsriSdkTest {

    val api: EsriMapServerApi by lazy {
        RetrofitFactory.newBuilder("https://19.15.12.35:8081/gis/")
            .ignoreSSL()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EsriMapServerApi::class.java)
    }

    @Test
    fun testMapServerQuery() {

        val baseUrl =
            "https://19.15.12.35:8081/gis/arcgis/rest/services/demo/MapServer"

        val serverInfo = api.queryMapServerInfo("$baseUrl?f=pjson").blockingFirst()
        Log.i("esri.api", "图层结果：${Gson().toJson(serverInfo)}")

        val legend = api.queryLegend("$baseUrl/legend?f=pjson").blockingFirst()
        Log.i("esri.api", "图例结果：${Gson().toJson(legend)}")


        val params = EsriQueryParams()
        params.where = "xzqdm=440882"
        val data = api.query(
            "$baseUrl/0/query",
            params
        ).blockingFirst()
        Log.i("esri.api", "查询结果[${data.features?.size}]：\n${Gson().toJson(data)}")


    }

}