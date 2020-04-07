package org.fca.rsapi.model

import javax.persistence.*

@Entity
data class Userfca (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val userId: Long?,

        val login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        val accessToken: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId")
        val upper: Userfca?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pictureId")
        val profilePic: Picture?,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "positionId")
        val position: Position,

        @OneToMany(mappedBy = "upper", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val lowerList: List<Userfca>,

        @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val albumList: List<Album>,

        @OneToMany(mappedBy = "writer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val postList: List<Posts>,

        @OneToMany(mappedBy = "giver", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val bottleBillList: List<BottleBill>,

        @OneToMany(mappedBy = "payer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val billList: List<Bill>,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "Plus_Un",
                joinColumns = [JoinColumn(name = "userId", referencedColumnName = "userId")],
                inverseJoinColumns = [JoinColumn(name = "userId", referencedColumnName = "userId")])
        var plusUnList: List<Userfca> = mutableListOf()

)