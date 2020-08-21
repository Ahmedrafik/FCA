package org.fca.rsapi.mapper

import org.fca.rsapi.dto.UserfcaDTO
import org.fca.rsapi.model.Userfca

class UserFcaMapper {
    companion object {
        fun mapper(userfcaDTO: UserfcaDTO): Userfca{
            return Userfca(userfcaDTO.userId, userfcaDTO.login,userfcaDTO.email,userfcaDTO.pass,userfcaDTO.firstname,userfcaDTO.lastname,userfcaDTO.accessToken,null)
        }
    }


}