package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Event (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val eventId: Long?,

        val name: String?,

        val startDate: Date?,

        val endDate: Date?,

        val place: String?,

        val description:String?,

        @OneToOne(mappedBy = "event")
        val postEvent: Posts,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pictureid")
        val eventPics: Picture
)