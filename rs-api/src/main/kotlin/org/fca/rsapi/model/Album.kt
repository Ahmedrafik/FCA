package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.time.temporal.TemporalAmount
import java.util.*
import javax.persistence.*

@Entity
data class Album (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val albumId: Long?,

        val name: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "owner")
        @JsonBackReference
        var owner: Userfca? = null
) {
        override fun toString(): String {
                return "Album(albumId=$albumId, name='$name', owner=$owner)"
        }
}