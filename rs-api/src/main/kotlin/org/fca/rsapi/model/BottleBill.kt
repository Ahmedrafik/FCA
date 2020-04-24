package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.fca.rsapi.enum.BottleType
import java.time.temporal.TemporalAmount
import java.util.*
import javax.persistence.*

@Entity
data class BottleBill (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val bottleBillId: Long?,

        val quantity: Int,

        val date: Date?,

        val bottleType:Int,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "giver")
        @JsonBackReference
        var giver:Userfca? = null
) {
        override fun toString(): String {
                return "BottleBill(bottleBillId=$bottleBillId, quantity=$quantity, date=$date, bottleType=$bottleType, giver=$giver)"
        }
}