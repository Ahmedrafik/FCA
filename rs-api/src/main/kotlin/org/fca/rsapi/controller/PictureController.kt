package org.fca.rsapi.controller

import org.fca.rsapi.dto.PictureDTO
import org.fca.rsapi.model.Picture
import org.fca.rsapi.repository.PictureRepository
import org.fca.rsapi.service.PictureService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/picture")
class PictureController (private val pictureRepository: PictureRepository, private val pictureService: PictureService) {

    @GetMapping("/")
    fun getAll(): List<Picture> =
            pictureRepository.findAll()


    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: PictureDTO): ResponseEntity<Picture> {
        return ResponseEntity.ok(pictureService.save(dto))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Picture> {
        return pictureRepository.findById(id).map { bill ->
            ResponseEntity.ok(bill)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Picture): ResponseEntity<Picture> {

        return pictureRepository.findById(id).map { existing ->
            val updated: Picture = existing
                    .copy(name = new.name, path = new.path, album = new.album)
            ResponseEntity.ok().body(pictureRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return pictureRepository.findById(id).map { bill  ->
            pictureRepository.delete(bill)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/user/{id}")
    fun getByAlbumId(@PathVariable(value = "id") id: Long): ResponseEntity<List<Picture>> {
        val res = pictureService.getByAlbumId(id)
        return if (res.isEmpty()){
            ResponseEntity<List<Picture>>(HttpStatus.NOT_FOUND)
        }
        else{
            ResponseEntity.ok(res)
        }
    }


    
}
