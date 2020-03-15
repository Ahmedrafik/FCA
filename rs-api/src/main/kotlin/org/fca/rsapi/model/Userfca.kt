package org.fca.rsapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Userfca (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val userid: Long?,

        val login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        val upper: Long?,

        val profilePic: String?,

        var accessToken: String?



)