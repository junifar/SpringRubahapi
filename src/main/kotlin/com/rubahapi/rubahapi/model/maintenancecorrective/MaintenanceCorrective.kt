package com.rubahapi.rubahapi.model.maintenancecorrective

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class MaintenanceCorrective(
    @Id
    val id: Long,
    val project_id: String,
    val site_name: String,
    val site_type: String,
    val bulan: Int?,
    val tahun: Int?
){
    private constructor(): this(0, "", "", "", 0, 0)
}