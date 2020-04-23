package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
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
        @JoinColumn(name = "user_id")
        @JsonBackReference
        var payer: Userfca? = null
)