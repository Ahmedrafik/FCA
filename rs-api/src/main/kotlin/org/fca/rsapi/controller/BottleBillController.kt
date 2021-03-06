package org.fca.rsapi.controller

import org.fca.rsapi.dto.BottleBillDTO
import org.fca.rsapi.mapper.BottleBillMapper
import org.fca.rsapi.model.BottleBill
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.BottleBillRepository
import org.fca.rsapi.repository.UserRepository
import org.fca.rsapi.service.BillService
import org.fca.rsapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/bottlebill")
class BottleBillController (private val bottlebillRepository: BottleBillRepository,  private val billService: BillService, private val userService: UserService) {

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<BottleBillDTO>> {
        return ResponseEntity.ok(billService.getBottleBillGroupByUser())
    }



    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: BottleBillDTO): ResponseEntity<BottleBill> {
        val giver: Userfca? = dto.name?.let { userService.getByLogin(it) }
        val bottleBill = BottleBillMapper.mapper(dto)
        bottleBill.giver = giver
        return ResponseEntity.ok(bottlebillRepository.save(bottleBill))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<BottleBillDTO> {
        return bottlebillRepository.findById(id).map { bill ->
            ResponseEntity.ok(BottleBillMapper.mapper(bill))
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: BottleBill): ResponseEntity<BottleBill> {

        return bottlebillRepository.findById(id).map { existing ->
            val updated: BottleBill = existing
                    .copy(quantity = new.quantity, date = new.date, giver = new.giver)
            ResponseEntity.ok().body(bottlebillRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return bottlebillRepository.findById(id).map { bill  ->
            bottlebillRepository.delete(bill)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }


    
}
