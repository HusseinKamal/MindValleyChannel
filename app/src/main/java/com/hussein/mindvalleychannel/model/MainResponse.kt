package com.hussein.mindvalleychannel.model

/** This Class Model for make list of home adapter.You can use it for adding more sections in Home**/
class MainResponse {
    companion object{
        val VIEW_TYPE_EPISODE = 0
        val VIEW_TYPE_CHANNEL = 1
        val VIEW_TYPE_CATEGORY = 2
    }
    var viewType = 0
        get() = field
        set(value) { field = value }

    var model: Any? = null
        get() = field
        set(value) { field = value }
}