package org.fca.rsapi.dto

data class PositionDTO (

        val positionId: Long?,

        val latitude: Double,

        val longitude: Double,

        var positionUser: Long?
)