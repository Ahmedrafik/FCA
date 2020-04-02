package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Posts (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val postid: Long?,

        val title: String,

        val body: String?,

        val date: Date?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userid")
        val writer: Userfca,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "eventid")
        val event: Event,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "Post_Pics",
                joinColumns = [JoinColumn(name = "postid", referencedColumnName = "postid")],
                inverseJoinColumns = [JoinColumn(name = "pictureid", referencedColumnName = "pictureid")])
        var picsList: List<Picture> = mutableListOf()
)