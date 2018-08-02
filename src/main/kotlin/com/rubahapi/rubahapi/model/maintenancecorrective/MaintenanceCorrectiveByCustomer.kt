package com.rubahapi.rubahapi.model.maintenancecorrective

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class MaintenanceCorrectiveByCustomer(
        @Id
        val id:Long,
        val customer_name: String,
        val tahun: Int?,
        val nilai_po: Long?
){
    private constructor(): this(0,"",0,0)
}