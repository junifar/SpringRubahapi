package com.rubahapi.rubahapi.model.maintenancepreventive

import javax.persistence.Id

class MaintenancePreventiveByYear(
        @Id
        var id: Int,
        var year: String,
        var line_data: MutableList<MaintenancePreventiveByCustomer>?
){
    constructor(): this(0, "", null)
}