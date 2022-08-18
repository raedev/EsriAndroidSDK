package com.esri.sdk.bean

/**
 * 矢量属性信息
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
data class EsriFeature(
    var attributes: EsriAttribute,
    var geometry: EsriGeometry?
) {

    /**
     * 转换为对象
     */
    fun <T> toBean(clazz: Class<T>): T {
        return attributes.toBean(clazz)
    }
}