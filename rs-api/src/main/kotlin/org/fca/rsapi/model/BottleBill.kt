package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class BottleBill (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val bottleBillId: Long?,

        val quantity: Int,

        val date: Date?,

        val bottleType: String?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userid")
        val giver: Userfca
)