package org.fca.rsapi.model

import java.util.*
import javax.persistence.*

@Entity
data class Album (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val albumid: Long?,

        val name: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userid")
        val owner: Userfca,

        @OneToMany(mappedBy = "album", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val photoList: List<Picture>
)