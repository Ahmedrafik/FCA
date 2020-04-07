package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Album (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val albumId: Long?,

        val name: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId")
        val owner: Userfca,

        @OneToMany(mappedBy = "album", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val photoList: List<Picture>
)