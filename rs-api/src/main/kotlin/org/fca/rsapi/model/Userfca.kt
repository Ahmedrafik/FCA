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

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userid")
        val upper: Userfca?,

        val accessToken: String?,

        @OneToMany(mappedBy = "upper", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val lowers: List<Userfca>,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "positionid")
        val position: Position,

        @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val albumList: List<Album>,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pictureid")
        val profilePic: Picture?,

        @OneToMany(mappedBy = "writer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val postList: List<Posts>,

        @OneToMany(mappedBy = "giver", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val bottleBillList: List<BottleBill>,

        @OneToMany(mappedBy = "payer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val billList: List<Bill>,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "Plus_Un",
                joinColumns = [JoinColumn(name = "userid", referencedColumnName = "userid")],
                inverseJoinColumns = [JoinColumn(name = "userid", referencedColumnName = "userid")])
        var plusUnList: List<Userfca> = mutableListOf()

)