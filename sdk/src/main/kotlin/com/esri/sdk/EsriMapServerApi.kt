package com.esri.sdk

import com.esri.sdk.bean.EsriMapServerInfo
import com.esri.sdk.bean.EsriQueryParams
import com.esri.sdk.bean.EsriQueryResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * MapServer接口查询
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
interface EsriMapServerApi {


    /**
     * 查询数据
     */
    @POST
    fun queryOnlyObjectId(
        @Url url: String,
        @Body params: EsriQueryParams
    ): Observable<EsriQueryResult>


    /**
     * 查询图层
     */
    @POST
    fun queryMapServerInfo(@Url url: String): Observable<EsriMapServerInfo>

    /**
     * 查询 Legend
     */
    @POST
    fun queryLegend(@Url url: String): Observable<EsriMapServerInfo>

    /**
     * 查询数据
     */
    @POST
    fun query(@Url url: String, @Body params: EsriQueryParams): Observable<EsriQueryResult>
}