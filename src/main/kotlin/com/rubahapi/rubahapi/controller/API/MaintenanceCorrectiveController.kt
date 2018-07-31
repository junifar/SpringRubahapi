package com.rubahapi.rubahapi.controller.API

import com.rubahapi.rubahapi.repository.MaintenanceCorrectiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MaintenanceCorrectiveController{

    @Autowired
    lateinit var repository: MaintenanceCorrectiveRepository

    @RequestMapping("/api/maintenance_corrective")
    fun getAll() = repository.getAll()
}