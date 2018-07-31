package com.rubahapi.rubahapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.MaintenanceCorrective
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URL

@Controller
class MaintenanceCorrectiveViewController{

    @RequestMapping("/maintenance_corrective")
    fun getAll(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_corrective")
        val maintenanceCorrectiveDataList: List<MaintenanceCorrective> = objectMapper.readValue(url)
        model.addAttribute("maintenanceCorrectiveDataList", maintenanceCorrectiveDataList)
        return "maintenance_corrective/index"
    }
}