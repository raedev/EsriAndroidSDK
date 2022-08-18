package com.esri.sdk

import com.esri.sdk.bean.EsriQueryParams
import com.esri.sdk.bean.EsriMapServerBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.FormUrlEncoded
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
    @FormUrlEncoded
    fun query(@Url url: String, params: EsriQueryParams): Observable<EsriMapServerBean>
}