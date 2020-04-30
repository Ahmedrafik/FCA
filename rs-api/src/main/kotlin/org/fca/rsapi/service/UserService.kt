package org.fca.rsapi.service

import org.fca.rsapi.dto.UserfcaDTO
import org.fca.rsapi.mapper.UserFcaMapper
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.PictureRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val pictureRepository: PictureRepository)  {

    fun getByUserId(id:Long?):List<Userfca> {
        val res : MutableList<Userfca> = ArrayList()
        val list = userRepository.findAll()
        for(crt in list){
            if(id == crt.upper?.userId){
                res += crt
            }
        }
        return res
    }

    fun save(dto: UserfcaDTO): Userfca{
        val userfca: Userfca? = dto.upper?.let { userRepository.getOne(it) }
        val user = UserFcaMapper.mapper(dto)
        user.upper = userfca
        return userRepository.save(user)
    }
}