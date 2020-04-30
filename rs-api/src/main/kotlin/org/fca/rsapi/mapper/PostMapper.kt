package org.fca.rsapi.mapper

import org.fca.rsapi.dto.PostDTO
import org.fca.rsapi.model.Post
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class PostMapper {
    companion object {
        fun mapper(dto: PostDTO): Post{
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
            val date = Date.from(LocalDate.parse(dto.date, formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            return Post(dto.postId, dto.title, dto.body, date)
        }

        fun mapper(post: Post): PostDTO {
            val date = SimpleDateFormat("dd/MM/yyyy").format(post.date)
            val picList = ArrayList<Long?>()
            post.picsList.forEach {
                picList += it.pictureId
            }
            return PostDTO(post.postId, post.title,post.body, date, post.writer?.userId, picList)

        }
    }


}