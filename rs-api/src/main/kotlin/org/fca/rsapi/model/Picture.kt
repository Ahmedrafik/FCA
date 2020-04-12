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

        @OneToMany(mappedBy = "profilePic", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val userProfile: List<Userfca>,

        @ManyToMany(mappedBy = "picsList")
        val postsList: List<Post>,

        @OneToMany(mappedBy = "eventPics", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val eventList: List<Event>
)