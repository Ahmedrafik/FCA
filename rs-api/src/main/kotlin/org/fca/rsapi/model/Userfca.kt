package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Userfca(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userId: Long?,

        var login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        var accessToken: String?,

        @OneToOne(mappedBy = "positionUser")
        @JsonManagedReference
        val position: Position? = null,

        @OneToMany(mappedBy = "payer", cascade = [CascadeType.ALL])
        @JsonManagedReference
        var bills: List<Bill> = emptyList(),

        @OneToMany(mappedBy = "giver", cascade = [CascadeType.ALL])
        @JsonManagedReference
        var bottleBills: List<BottleBill> = emptyList(),

        @OneToMany(mappedBy = "writer", cascade = [CascadeType.ALL])
        @JsonManagedReference
        var postList: List<Post> = emptyList(),

        @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL])
        @JsonManagedReference
        var albumList: List<Album> = emptyList(),

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "upper")
        @JsonBackReference
        var upper: Userfca? = null,

        @OneToMany(mappedBy = "upper", cascade = [CascadeType.ALL])
        @JsonManagedReference
        var lowerList: List<Userfca> = emptyList(),

        @ManyToMany
        @JoinTable(name = "plus_un",
                joinColumns = [JoinColumn(name = "user1_id", referencedColumnName = "userId")],
                inverseJoinColumns = [JoinColumn(name = "user2_id", referencedColumnName = "userId")])
        @JsonManagedReference
        var plusUnList: List<Userfca> = emptyList()
) {
        override fun toString(): String {
                return "Userfca(userId=$userId, login='$login', email=$email, pass=$pass, firstname=$firstname, lastname=$lastname, accessToken=$accessToken)"
        }
}