package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Position (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val positionId: Long?,

        val longitude: String,

        val latitude: String?,

        @OneToOne(mappedBy = "position")
        val positionUser: Userfca

)