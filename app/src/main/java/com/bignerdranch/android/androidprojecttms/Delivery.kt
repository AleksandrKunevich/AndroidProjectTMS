package com.bignerdranch.android.androidprojecttms

sealed class Delivery(open val coast: Int, var deliver: (Order) -> Unit) {
    data class DpdBy(override val coast: Int) : Delivery(1, {
        println(
            """
            Deliver: Dpd.by
            Id: ${it.idOrder}
            Price: ${it.price}
            
            """.trimIndent()
        )
    })

    data class BoxAgentCom(override val coast: Int) : Delivery(2, {
        println(
            ("""
            Deliver: BoxAgent.com
            Id: ${it.idOrder}
            Product: ${it.product}
            Price: ${it.price}
            
            """).trimIndent()
        )
    })

    data class VozimBy(override val coast: Int) : Delivery(3, {
        println(
            """
            Deliver: Vozim.by
            We are best of the best!  
            Consumer: ${it.consumer}
            Address: ${it.address}
            
            """.trimIndent()
        )
    })

    override fun toString(): String {
        return when (this) {
            is BoxAgentCom -> "BoxAgent.com"
            is DpdBy -> "DPD.by"
            is VozimBy -> "Vozim.by"
        }
    }
}
