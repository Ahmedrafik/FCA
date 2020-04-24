package org.fca.rsapi.controller

import org.fca.rsapi.dto.BillDTO
import org.fca.rsapi.mapper.BillMapper
import org.fca.rsapi.model.Bill
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.BillRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/bill")
class BillController (private val billRepository: BillRepository, private val userRepository: UserRepository) {

    @GetMapping("/")
    fun getAll(): List<Bill> =
            billRepository.findAll()


    @PostMapping("/")
    fun createNew(@Valid @RequestBody dto: BillDTO): ResponseEntity<Bill> {
        val payer: Userfca? = dto.payer?.let { userRepository.getOne(it) }
        val bill = BillMapper.mapper(dto)
        bill.payer = payer
        return ResponseEntity.ok(billRepository.save(bill))
    }



    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Bill> {
        return billRepository.findById(id).map { bill ->
            ResponseEntity.ok(bill)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Bill): ResponseEntity<Bill> {

        return billRepository.findById(id).map { existing ->
            val updated: Bill = existing
                    .copy(amount = new.amount, date = new.date, payer = new.payer)
            ResponseEntity.ok().body(billRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return billRepository.findById(id).map { bill  ->
            billRepository.delete(bill)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }


    
}
