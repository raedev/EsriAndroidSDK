package com.esri.sdk.bean

import com.google.gson.Gson

/**
 * 属性信息
 * @author RAE
 * @date 2022/08/18
 * @copyright Copyright (c) https://github.com/raedev All rights reserved.
 */
class EsriAttribute : HashMap<String, Any>() {

    /**
     * 转换为对象
     */
    fun <T> toBean(clazz: Class<T>): T {
        val gson = Gson()
        val json = gson.toJson(this)
        return gson.fromJson(json, clazz)
    }
}