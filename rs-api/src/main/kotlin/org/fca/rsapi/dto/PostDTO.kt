package org.fca.rsapi.dto

data class PostDTO (

        val postId: Long?,

        val title: String,

        val body: String,

        val date: String,

        var writer: Long?
)