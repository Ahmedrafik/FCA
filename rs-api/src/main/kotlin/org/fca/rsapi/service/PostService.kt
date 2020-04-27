package org.fca.rsapi.service

import org.fca.rsapi.dto.PostDTO
import org.fca.rsapi.mapper.PostMapper
import org.fca.rsapi.model.Post
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.PostRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository, private val userRepository: UserRepository)  {

    fun getByUserId(id:Long?):List<Post> {
        val res : MutableList<Post> = ArrayList()
        val list = postRepository.findAll()
        for(crt in list){
            if(id == crt.writer?.userId){
                res += crt
            }
        }
        return res
    }

    fun save(dto: PostDTO): Post{
        val userfca: Userfca? = dto.writer?.let { userRepository.getOne(it) }
        val album = PostMapper.mapper(dto)
        album.writer = userfca
        return postRepository.save(album)
    }
}