package org.fca.rsapi.dto

data class BillDTO (

        val billId: Long?,

        val amount: Double,

        val date: String?,

        var payer: Long?
)