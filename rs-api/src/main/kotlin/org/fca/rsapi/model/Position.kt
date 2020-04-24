package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Position(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val positionId: Long?,

        var latitude: Double,

        val longitude: Double,

        @OneToOne
        @JoinColumn(name = "position_user")
        val positionUser: Userfca? = null

) {
        override fun toString(): String {
                return "Position(positionId=$positionId, latitude=$latitude, longitude=$longitude, positionUser=$positionUser)"
        }
}