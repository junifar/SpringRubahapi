package com.rubahapi.rubahapi.controller.API.maintenancepreventive

import com.rubahapi.rubahapi.repository.maintenancecorrective.MaintenanceCorrectiveByCustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MaintenancePreventiveByCustomerController{

    @Autowired
    lateinit var repository: MaintenanceCorrectiveByCustomerRepository

    @RequestMapping("/api/maintenance_preventive_by_customer")
    fun getAll() = repository.getAll1()
}