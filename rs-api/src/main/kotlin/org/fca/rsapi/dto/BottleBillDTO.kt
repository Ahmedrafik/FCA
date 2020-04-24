package org.fca.rsapi.dto

import org.fca.rsapi.enum.BottleType
import java.util.*

data class BottleBillDTO (

        val bottleBillId: Long?,

        val quantity: Int,

        val date: String?,

        val bottleType: String,

        val giver: Long?
)