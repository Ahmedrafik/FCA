package org.fca.rsapi.mapper

import org.fca.rsapi.dto.BillDTO
import org.fca.rsapi.model.Bill
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class BillMapper {
    companion object {
        fun mapper(billDTO: BillDTO): Bill{
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
            val date = Date.from(LocalDate.parse(billDTO.date, formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            return Bill(billDTO.billId, billDTO.amount, date)
        }
    }


}