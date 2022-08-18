package com.esri.sdk.bean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okio.BufferedSink

/**
 * ArcGIS服务图层查询参数
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
class EsriQueryParams : RequestBody() {

    var text: String? = ""
    var objectIds: String? = ""
    var time: String? = ""
    var geometry: String? = ""
    var geometryType: String? = "esriGeometryEnvelope"
    var inSR: String? = ""
    var spatialRel: String? = "esriSpatialRelIntersects"
    var relationParam: String? = ""
    var outFields: String? = "*"
    var returnGeometry: String? = "true"
    var returnIdsOnly: String? = "false"
    var returnCountOnly: String? = "false"
    var returnDistinctValues: String? = "false"
    var maxAllowableOffset: String? = ""
    var geometryPrecision: String? = ""
    var outSR: String? = ""
    var orderByFields: String? = ""
    var groupByFieldsForStatistics: String? = ""
    var outStatistics: String? = ""
    var returnZ: String? = "false"
    var returnM: String? = "false"
    var gdbVersion: String? = ""
    var f: String? = "pjson"

    /**
     * where语句，复杂的查询直接写语句
     */
    var where: String? = ""

    /** where子句构造器 */

    private val whereBuilder = StringBuilder("1=1")

    /** and name=value */
    fun eq(name: String, value: Any) {
        whereBuilder.append(" and ").append(name).append("=").append(value)
        where = whereBuilder.toString()
    }

    /** and name like value */
    fun like(name: String, value: Any) {
        whereBuilder.append(" and ").append(name).append(" like ").append(value)
        where = whereBuilder.toString()
    }

    /** and name like %value% */
    fun likeFuzzy(name: String, value: Any) {
        whereBuilder.append(" and ")
            .append(name)
            .append(" like ").append("%").append(value).append("%")
        where = whereBuilder.toString()
    }

    override fun contentType(): MediaType? {
        return "application/x-www-form-urlencoded".toMediaTypeOrNull()
    }

    override fun writeTo(sink: BufferedSink) {
        val gson = Gson()
        val json = gson.toJson(this)
        val type = object : TypeToken<Map<String, Any?>>() {}.type
        val map = gson.fromJson<Map<String, Any?>>(json, type)
        val builder = FormBody.Builder()
        map.forEach {
            it.value?.apply {
                builder.addEncoded(it.key, this.toString())
            }
        }
        builder.build().writeTo(sink)
    }
}