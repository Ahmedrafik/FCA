package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Picture (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val pictureId: Long?,

        val name: String,

        val path: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "albumId")
        var album: Album?,

        @OneToOne(mappedBy = "profilepic")
        val userProfile: Userfca,

        @ManyToMany(mappedBy = "picsList")
        val postsList: List<Posts>,

        @OneToMany(mappedBy = "eventPics", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val eventList: List<Event>,


)