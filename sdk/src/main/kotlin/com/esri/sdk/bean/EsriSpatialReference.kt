package com.esri.sdk.bean

/**
 * 空间参考系
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
data class EsriSpatialReference(
    var wkid: Int,
    var latestWkid: Int,
)