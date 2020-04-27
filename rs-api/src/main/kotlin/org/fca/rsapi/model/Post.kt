package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
data class Post (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val postId: Long?,

        val title: String,

        val body: String,

        val date: Date,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "writer")
        @JsonBackReference
        var writer: Userfca? = null,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "postpics",
                joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "post_id")],
                inverseJoinColumns = [JoinColumn(name = "pics_id", referencedColumnName = "picture_id")])
        @JsonManagedReference
        val picsList: List<Picture> = ArrayList()
) {
        override fun toString(): String {
                return "Post(postId=$postId, title='$title', body='$body', date=$date, writer=$writer)"
        }
}