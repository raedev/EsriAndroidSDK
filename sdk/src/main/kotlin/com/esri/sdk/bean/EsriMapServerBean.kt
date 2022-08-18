package com.esri.sdk.bean

/**
 * MapServer查询返回结果
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
data class EsriMapServerBean(

    /** 当前图层显示的字段名 */
    var displayFieldName: String,

    /** 图层矢量类型 */
    var geometryType: String,

    /** 字段别名列表 */
    var fieldAliases: EsriFieldAliases,

    /** 空间参考系 */
    var spatialReference: EsriSpatialReference,

    /** 字段列表 */
    var fields: List<EsriFields>,

    /** 矢量列表 */
    var features: List<EsriFeature>
)
