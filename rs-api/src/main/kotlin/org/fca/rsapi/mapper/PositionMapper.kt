package org.fca.rsapi.mapper

import org.fca.rsapi.dto.BillDTO
import org.fca.rsapi.dto.PositionDTO
import org.fca.rsapi.model.Bill
import org.fca.rsapi.model.Position

class PositionMapper {
    companion object {
        fun mapper(positionDTO: PositionDTO): Position{
            return Position(positionDTO.positionId, positionDTO.latitude, positionDTO.longitude)
        }
    }


}