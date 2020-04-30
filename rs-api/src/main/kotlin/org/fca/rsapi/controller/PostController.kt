package org.fca.rsapi.controller

import org.fca.rsapi.dto.PostDTO
import org.fca.rsapi.model.Post
import org.fca.rsapi.repository.PictureRepository
import org.fca.rsapi.repository.PostRepository
import org.fca.rsapi.repository.UserRepository
import org.fca.rsapi.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/post")
class PostController (private val postRepository: PostRepository, private val postService: PostService,private val userRepository: UserRepository, private val pictureRepository: PictureRepository) {

    @GetMapping("/")
    fun getAll(): List<Post> =
            postRepository.findAll()


    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: PostDTO): ResponseEntity<Post> {
        return ResponseEntity.ok(postService.save(dto))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Post> {
        return postRepository.findById(id).map { post ->
            ResponseEntity.ok(post)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Post): ResponseEntity<Post> {

        return postRepository.findById(id).map { existing ->
            val updated: Post = existing
                    .copy(title = new.title, body = new.body, date = new.date, writer = new.writer)
            ResponseEntity.ok().body(postRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return postRepository.findById(id).map { post  ->
            postRepository.delete(post)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/user/{id}")
    fun getByUserId(@PathVariable(value = "id") id: Long): ResponseEntity<List<Post>> {
        val res = postService.getByUserId(id)
        return if (res.isEmpty()){
            ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND)
        }
        else{
            ResponseEntity.ok(res)
        }
    }
    
}
