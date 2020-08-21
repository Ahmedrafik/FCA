package org.fca.rsapi.service

import org.fca.rsapi.dto.BillDTO
import org.fca.rsapi.dto.BillDateDTO
import org.fca.rsapi.dto.BottleBillDTO
import org.fca.rsapi.dto.UserfcaDTO
import org.fca.rsapi.mapper.BottleBillMapper
import org.fca.rsapi.mapper.UserFcaMapper
import org.fca.rsapi.model.Bill
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.BillRepository
import org.fca.rsapi.repository.BottleBillRepository
import org.fca.rsapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Service
class BillService(private val bottleBillRepository: BottleBillRepository, private val billRepository: BillRepository, private val userRepository: UserRepository)  {

    fun getBottleBillGroupByUser() : List<BottleBillDTO> {
        val bottleBillDTOs = emptyList<BottleBillDTO>().toMutableList()
        bottleBillRepository.findAll().forEach { bottleBill ->
            var userExist = false
            bottleBillDTOs.forEach {
                if(it.name == bottleBill.giver?.login) {
                    it.quantity += bottleBill.quantity
                    userExist = true
                }
            }
            if (!userExist)
                bottleBillDTOs += BottleBillMapper.mapper(bottleBill)
        }
        return bottleBillDTOs
    }

    fun selector(p: Bill): Date? = p.date

    fun getPromBillsbyDates(): BillDateDTO {
        val billDateDto= BillDateDTO()
        val billList = billRepository.findAll()
        billList.sortBy { selector(it) }
        billList.forEach {
            val date = SimpleDateFormat("dd/MM").format(it.date)
            if(billDateDto.labels.isEmpty() || billDateDto.labels.last() != date){
                billDateDto.labels.add(date)
            }
        }
        userRepository.findAll().forEach {
            it.color?.let { it1 -> billDateDto.barColors.add(it1) }
            billDateDto.data.add(emptyList<Double>().toMutableList())
            for (x in 0 until billDateDto.labels.size) {
                billDateDto.data.last().add(0.0)
            }
            it.bills.forEach { bill ->
                var index = 0
                while (index < billDateDto.labels.size) {
                    val date = SimpleDateFormat("dd/MM").format(bill.date)
                    if (billDateDto.labels[index] == date) {
                        billDateDto.data.last()[index] = billDateDto.data.last()[index] + bill.amount
                    }
                    index++

                }
            }
        }
        return billDateDto
    }

}