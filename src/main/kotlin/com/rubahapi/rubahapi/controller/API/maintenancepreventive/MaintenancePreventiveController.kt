package com.rubahapi.rubahapi.controller.API.maintenancepreventive

import com.rubahapi.rubahapi.repository.maintenancecorrective.MaintenanceCorrectiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MaintenancePreventiveController{

    @Autowired
    lateinit var repository: MaintenanceCorrectiveRepository

    @RequestMapping("/api/maintenance_preventive")
    fun getAll() = repository.getAll()
}