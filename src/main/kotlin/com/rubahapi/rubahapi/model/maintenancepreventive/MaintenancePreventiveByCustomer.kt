package com.rubahapi.rubahapi.model.maintenancepreventive

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class MaintenancePreventiveByCustomer(
        @Id
        val id:Long,
        val customer_id:Long,
        val customer_name: String,
        val tahun: String,
        val nilai_po: Long
){
    private constructor(): this(0,0,"","",0)
}