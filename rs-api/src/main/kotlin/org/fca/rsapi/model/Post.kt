package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Post (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val postId: Long?,

        val title: String,

        val body: String?,

        val date: Date?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userId")
        val writer: Userfca,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "eventId")
        val event: Event,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "Post_Pics",
                joinColumns = [JoinColumn(name = "postId", referencedColumnName = "postId")],
                inverseJoinColumns = [JoinColumn(name = "pictureId", referencedColumnName = "pictureId")])
        var picsList: List<Picture> = mutableListOf()
)