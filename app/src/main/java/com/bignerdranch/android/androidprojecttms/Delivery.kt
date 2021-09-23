package com.bignerdranch.android.androidprojecttms

sealed class Delivery(var deliver: (Order) -> Unit) {
    data class DpdBy(val coast: Int) : Delivery({
        println(
            """
            Deliver: Dpd.by
            Id: ${it.getIdOrder()}
            Price: ${it.getPrice()}
            
            """.trimIndent()
        )
    })

    data class BoxAgentCom(val coast: Int) : Delivery({
        println(
            ("""
            Deliver: BoxAgent.com
            Id: ${it.getIdOrder()}
            Product: ${it.getProduct()}
            Price: ${it.getPrice()}
            
            """).trimIndent()
        )
    })

    data class VozimBy(val coast: Int) : Delivery({
        println(
            """
            Deliver: Vozim.by
            We are best of the best!  
            Consumer: ${it.getConsumer()}
            Address: ${it.getAddress()}
            
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
