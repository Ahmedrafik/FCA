package org.fca.rsapi.model

import java.time.temporal.TemporalAmount
import java.util.*
import javax.persistence.*

@Entity
data class Bill (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val billId: Long?,

        val amount: Double,

        val date: Date?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userid")
        val payer: Userfca
)