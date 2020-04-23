package org.fca.rsapi.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Userfca(

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val userId: Long?,

        var login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        var accessToken: String?,

        @OneToMany(mappedBy = "payer", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        @JsonManagedReference
        var bills: List<Bill> = emptyList()
) {
        override fun toString(): String {
                return "Userfca(userId=$userId, login='$login', email=$email, pass=$pass, firstname=$firstname, lastname=$lastname, accessToken=$accessToken)"
        }
}