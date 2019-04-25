package org.fca.rsapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Userfca (

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val userid: Long,

        val login: String = "",

        val email: String ="",

        val pass: String ="",

        val firstname: String,

        val lastname: String,

        val upper: String,

        val profilePic: String

)