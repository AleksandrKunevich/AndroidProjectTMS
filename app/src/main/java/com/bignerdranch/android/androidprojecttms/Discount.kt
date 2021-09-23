package com.bignerdranch.android.androidprojecttms

class Discount {
    var title: String? = null
        get() = field?.uppercase()
    var description: String? = null
        set(value) {
            if (value != null)
                field = if (value.length <= 100) value else value.substring(0, 100)
        }
    var discountAmount: Int = 0
    var imageUrl: String? = null
    var siteUrl: String? = null
}