package org.fca.rsapi.mapper

import org.fca.rsapi.dto.BillDTO
import org.fca.rsapi.dto.BottleBillDTO
import org.fca.rsapi.enum.BottleType
import org.fca.rsapi.exception.NotFoundException
import org.fca.rsapi.model.Bill
import org.fca.rsapi.model.BottleBill
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class BottleBillMapper {
    companion object {
        fun mapper(bottlebillDTO: BottleBillDTO): BottleBill{
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
            val date = Date.from(LocalDate.parse(bottlebillDTO.date, formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            return BottleBill(bottlebillDTO.bottleBillId, bottlebillDTO.quantity, date)
        }
        fun mapper(bottleBill: BottleBill): BottleBillDTO{
            val date = SimpleDateFormat("dd/MM/yyyy").format(bottleBill.date)
            return BottleBillDTO(bottleBill.bottleBillId, bottleBill.giver?.login, bottleBill.quantity, date, bottleBill.giver?.color)
        }
    }


}