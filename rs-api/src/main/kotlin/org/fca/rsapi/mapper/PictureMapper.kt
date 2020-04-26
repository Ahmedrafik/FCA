package org.fca.rsapi.mapper

import org.fca.rsapi.dto.PictureDTO
import org.fca.rsapi.model.Picture

class PictureMapper {
    companion object {
        fun mapper(dto: PictureDTO): Picture{
            return Picture(dto.pictureId, dto.name, dto.path)
        }
    }


}