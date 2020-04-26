package org.fca.rsapi.dto

data class PictureDTO (

        val pictureId: Long?,

        val name: String,

        val path: String,

        var album: Long?
)