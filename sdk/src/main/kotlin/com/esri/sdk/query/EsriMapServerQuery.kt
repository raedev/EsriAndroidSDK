package com.esri.sdk.query

import com.esri.sdk.EsriMapServerApi
import com.esri.sdk.bean.EsriQueryResult
import com.esri.sdk.bean.EsriQueryParams
import kotlin.math.ceil
import kotlin.math.min

/**
 * MapServer 分页查询
 * @author RAE
 * @date 2022/08/25
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
open class EsriMapServerQuery(
    protected val url: String,
    protected val api: EsriMapServerApi
) {

    interface Callback {

        /**
         * 请求之前
         */
        fun onBeforeQuery(page: Int, totalPage: Int) = Unit


        /**
         * 请求之后
         */
        fun onAfterQuery(page: Int, totalPage: Int, data: EsriQueryResult) = Unit
    }


    /** 查询参数 */
    val params: EsriQueryParams = EsriQueryParams()

    /** id列表 */
    private val objectIds = mutableListOf<String>()

    /** 数据量 */
    private val totalCount: Int
        get() = objectIds.size

    /** 每一页大小 */
    var pageSize = 200

    /** 当前页面 */
    var page = 0
        private set

    /** 分多少页 */
    val totalPage: Int
        get() {
            return ceil(totalCount * 0.1 / (pageSize * 0.1)).toInt()
        }

    /**
     * 开始请求
     */
    fun query(callback: Callback) {
        // 查询数量
        val p = params.clone().apply { returnIdsOnly = true }
        val data = api.queryOnlyObjectId(url, p).blockingFirst()
        objectIds.clear()
        objectIds.addAll(data.objectIds!!)
        // 开始分页请求
        for (i in 0 until totalPage) {
            this.page = i
            val start = i * pageSize
            val end = min(totalCount, start + pageSize)
            params.where = null
            params.returnIdsOnly = false
            params.objectIds = toWhereIn(objectIds.subList(start, end))
            callback.onBeforeQuery(i, totalPage)
            val features = api.query(url, params).blockingFirst()
            callback.onAfterQuery(i, totalPage, features)
        }
    }

    private fun toWhereIn(list: List<String>): String {
        val sb = StringBuilder()
        for (i in list.indices) {
            if (i != 0) {
                sb.append(",")
            }
            sb.append(list[i])
        }
        return sb.toString()
    }
}