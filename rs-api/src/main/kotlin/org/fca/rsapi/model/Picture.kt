package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Picture (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val pictureId: Long?,

        val name: String,

        val path: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "album")
        @JsonBackReference
        var album: Album? = null
) {
        override fun toString(): String {
                return "Picture(pictureId=$pictureId, name='$name', path='$path', album=$album)"
        }
}