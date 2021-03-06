package org.fca.rsapi.controller

import org.fca.rsapi.dto.AlbumDTO
import org.fca.rsapi.model.Album
import org.fca.rsapi.repository.AlbumRepository
import org.fca.rsapi.service.AlbumService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/album")
class AlbumController (private val albumRepository: AlbumRepository, private val albumService: AlbumService) {

    @GetMapping("/")
    fun getAll(): List<Album> =
            albumRepository.findAll()


    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: AlbumDTO): ResponseEntity<Album> {
        return ResponseEntity.ok(albumService.save(dto))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Album> {
        return albumRepository.findById(id).map { album ->
            ResponseEntity.ok(album)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Album): ResponseEntity<Album> {

        return albumRepository.findById(id).map { existing ->
            val updated: Album = existing
                    .copy(name = new.name, owner = new.owner)
            ResponseEntity.ok().body(albumRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return albumRepository.findById(id).map { album  ->
            albumRepository.delete(album)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/user/{id}")
    fun getByUserId(@PathVariable(value = "id") id: Long): ResponseEntity<List<Album>> {
        val res = albumService.getByUserId(id)
        return if (res.isEmpty()){
            ResponseEntity<List<Album>>(HttpStatus.NOT_FOUND)
        }
        else{
            ResponseEntity.ok(res)
        }
    }


    
}
