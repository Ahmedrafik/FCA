package org.fca.rsapi.mapper

import org.fca.rsapi.dto.AlbumDTO
import org.fca.rsapi.model.Album

class AlbumMapper {
    companion object {
        fun mapper(dto: AlbumDTO): Album{
            return Album(dto.albumId, dto.name)
        }
    }


}