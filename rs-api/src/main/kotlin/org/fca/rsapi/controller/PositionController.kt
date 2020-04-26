package org.fca.rsapi.controller

import org.fca.rsapi.dto.PositionDTO
import org.fca.rsapi.mapper.PositionMapper
import org.fca.rsapi.model.Position
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.PositionRepository
import org.fca.rsapi.repository.UserRepository
import org.fca.rsapi.service.PositionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/position")
class PositionController (private val positionRepository: PositionRepository, private val positionService: PositionService) {

    @GetMapping("/")
    fun getAll(): List<Position> =
            positionRepository.findAll()


    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: PositionDTO): ResponseEntity<Position> {
        return ResponseEntity.ok(positionService.save(dto))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Position> {
        return positionRepository.findById(id).map { bill ->
            ResponseEntity.ok(bill)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Position): ResponseEntity<Position> {

        return positionRepository.findById(id).map { existing ->
            val updated: Position = existing
                    .copy(latitude = new.latitude, longitude = new.longitude, positionUser = new.positionUser)
            ResponseEntity.ok().body(positionRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return positionRepository.findById(id).map { bill  ->
            positionRepository.delete(bill)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/user/{id}")
    fun getByUserId(@PathVariable(value = "id") id: Long): ResponseEntity<Position> {
        val res = positionService.getByUserId(id)
        return if (res ==null){
            ResponseEntity<Position>(HttpStatus.NOT_FOUND)
        }
        else{
            ResponseEntity.ok(res)
        }
    }


    
}
