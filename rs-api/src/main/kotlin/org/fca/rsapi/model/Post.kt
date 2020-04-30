package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

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

        @ManyToMany
        @JoinTable(name = "post_pics",
                joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "postId")],
                inverseJoinColumns = [JoinColumn(name = "pics_id", referencedColumnName = "pictureId")])
        @JsonManagedReference
        var picsList: List<Picture> = emptyList()
) {
        override fun toString(): String {
                return "Post(postId=$postId, title='$title', body='$body', date=$date, writer=$writer)"
        }
}