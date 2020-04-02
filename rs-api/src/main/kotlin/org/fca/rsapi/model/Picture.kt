package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Picture (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val pictureid: Long?,

        val name: String,

        val path: String?,

        @ManyToMany(mappedBy = "picsList")
        val postsList: List<Posts>,

        @OneToOne(mappedBy = "profilepic")
        val userProfile: Userfca,

        @OneToMany(mappedBy = "eventPics", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val eventList: List<Event>,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "albumid")
        var album: Album? = null


)