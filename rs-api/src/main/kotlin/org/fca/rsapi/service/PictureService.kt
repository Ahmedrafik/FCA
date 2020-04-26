package org.fca.rsapi.service

import org.fca.rsapi.dto.PictureDTO
import org.fca.rsapi.mapper.PictureMapper
import org.fca.rsapi.model.Album
import org.fca.rsapi.model.Picture
import org.fca.rsapi.repository.AlbumRepository
import org.fca.rsapi.repository.PictureRepository
import org.springframework.stereotype.Service

@Service
class PictureService(private val pictureRepository: PictureRepository, private val albumRepository: AlbumRepository)  {

    fun getByAlbumId(id:Long?):List<Picture> {
        val res : MutableList<Picture> = ArrayList()
        val list = pictureRepository.findAll()
        for(crt in list){
            if(id == crt.album?.albumId){
                res += crt
            }
        }
        return res
    }

    fun save(dto: PictureDTO): Picture{
        val album: Album? = dto.album?.let { albumRepository.getOne(it) }
        val picture = PictureMapper.mapper(dto)
        picture.album = album
        return pictureRepository.save(picture)
    }
}