package org.fca.rsapi.dto

data class BottleBillDTO (

        val bottleBillId: Long?,

        val name: String?,

        var quantity: Int,

        val date: String?,

        val color: String?,

        val legendFontColor: String = "white",

        val legendFontSize: Int = 15
)