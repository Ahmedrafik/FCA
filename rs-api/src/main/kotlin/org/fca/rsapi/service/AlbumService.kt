package org.fca.rsapi.service

import org.fca.rsapi.dto.AlbumDTO
import org.fca.rsapi.mapper.AlbumMapper
import org.fca.rsapi.model.Album
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.AlbumRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AlbumService(private val albumRepository: AlbumRepository, private val userRepository: UserRepository)  {

    fun getByUserId(id:Long?):List<Album> {
        val res : MutableList<Album> = ArrayList()
        val list = albumRepository.findAll()
        for(crt in list){
            if(id == crt.owner?.userId){
                res += crt
            }
        }
        return res
    }

    fun save(dto: AlbumDTO): Album{
        val userfca: Userfca? = dto.owner?.let { userRepository.getOne(it) }
        val album = AlbumMapper.mapper(dto)
        album.owner = userfca
        return albumRepository.save(album)
    }
}