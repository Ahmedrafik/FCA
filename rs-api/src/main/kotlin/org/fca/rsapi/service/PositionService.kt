package org.fca.rsapi.service

import org.fca.rsapi.dto.PositionDTO
import org.fca.rsapi.mapper.PositionMapper
import org.fca.rsapi.model.Position
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.PositionRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PositionService(private val positionRepository: PositionRepository, private val userRepository: UserRepository)  {

    fun save(dto: PositionDTO): Position{
        val res:Position
        var existing = getByUserId(dto.positionUser)
        if (existing == null){
            val userfca: Userfca? = dto.positionUser?.let { userRepository.getOne(it) }
            val position = PositionMapper.mapper(dto)
            position.positionUser = userfca
            res = positionRepository.save(position)
        }
        else{
            existing = existing
                    .copy(longitude = dto.longitude, latitude = dto.latitude)
            res = positionRepository.save(existing)
        }
        return res
    }

    fun getByUserId(id:Long?):Position? {
        var res : Position? = null
        val list = positionRepository.findAll()
        for(crt in list){
            if(id == crt.positionUser?.userId){
                res = crt
                break
            }
        }
        return res
    }
}