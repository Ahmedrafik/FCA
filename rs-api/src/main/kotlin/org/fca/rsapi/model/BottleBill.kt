package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class BottleBill (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val bottlebillid: Long?,

        val number: Int,

        val date: Date?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userid")
        val giver: Userfca
)