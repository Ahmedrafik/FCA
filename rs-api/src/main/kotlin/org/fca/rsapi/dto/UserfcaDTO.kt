package org.fca.rsapi.dto

data class UserfcaDTO (

        val userId: Long?,

        val login: String,

        val email: String?,

        var pass: String?,

        val firstname: String?,

        val lastname: String?,

        var accessToken: String?,

        val upper: Long?,

        val plusUnList: ArrayList<Long?> = ArrayList()
)