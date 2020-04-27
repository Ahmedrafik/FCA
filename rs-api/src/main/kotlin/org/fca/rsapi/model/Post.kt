package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
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
        var writer: Userfca? = null
) {
        override fun toString(): String {
                return "Post(postId=$postId, title='$title', body='$body', date=$date, writer=$writer)"
        }
}