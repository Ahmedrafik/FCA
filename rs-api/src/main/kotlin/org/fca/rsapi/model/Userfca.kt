package org.fca.rsapi.model

import javax.persistence.*

@Entity
data class Userfca (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val userId: Long,

        val login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        var accessToken: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pictureId")
        val profilePic: Picture?,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "positionId")
        val position: Position?,

        @OneToMany(mappedBy = "upper", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val hierarchyList: List<Hierarchy>?,

        @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val albumList: List<Album>?,

        @OneToMany(mappedBy = "writer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val postList: List<Post>?,

        @OneToMany(mappedBy = "giver", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val bottleBillList: List<BottleBill>?,

        @OneToMany(mappedBy = "payer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val billList: List<Bill>?,

        @OneToMany(mappedBy="me")
        var plusUnList: List<PlusUn>?
)