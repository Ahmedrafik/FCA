package org.fca.rsapi.model

import javax.persistence.*

@Entity
data class PlusUn (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val plusUnId: Long?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
        val me: Userfca?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
        val myPlusUn: Userfca?

)