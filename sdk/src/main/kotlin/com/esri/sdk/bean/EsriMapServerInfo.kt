package com.esri.sdk.bean

/**
 * MapServer 图层信息
 * @author RAE
 * @date 2022/08/26
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
class EsriMapServerInfo {
    var currentVersion = 0.0
    var serviceDescription: String? = null
    var mapName: String? = null
    var description: String? = null
    var copyrightText: String? = null
    var supportsDynamicLayers = false
    var layers: List<EsriLayers>? = null
    var spatialReference: EsriSpatialReference? = null
    var singleFusedMapCache = false
    var initialExtent: EsriExtent? = null
    var fullExtent: EsriExtent? = null
    var minScale = 0
    var maxScale = 0
    var units: String? = null
    var supportedImageFormatTypes: String? = null
    var documentInfo: EsriDocumentInfo? = null
    var capabilities: String? = null
    var supportedQueryFormats: String? = null
    var exportTilesAllowed = false
    var maxRecordCount: Long = 0
    var maxImageHeight = 0
    var maxImageWidth = 0
    var supportedExtensions: String? = null
}