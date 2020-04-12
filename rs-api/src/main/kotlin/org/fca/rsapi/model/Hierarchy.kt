package org.fca.rsapi.model

import javax.persistence.*

@Entity
data class Hierarchy (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val hierarchyId: Long?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
        val upper: Userfca?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
        val lower: Userfca?

)