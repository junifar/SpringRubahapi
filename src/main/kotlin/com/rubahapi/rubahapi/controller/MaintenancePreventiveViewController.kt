package com.rubahapi.rubahapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventive
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventiveByCustomer
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventiveByYear
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URL

@Controller
class MaintenancePreventiveViewController{
    @RequestMapping("/maintenance_preventive")
    fun getAll(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_preventive")
        val maintenancePreventiveDataList: List<MaintenancePreventive> = objectMapper.readValue(url)
        model.addAttribute("maintenanceCorrectiveDataList", maintenancePreventiveDataList)
        return "maintenance_preventive/index"
    }

    @RequestMapping("/maintenance_preventive/by_customer")
    fun getAllByCustomer(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_preventive/group")
        val maintenancePreventiveByCustomerDataList: List<MaintenancePreventiveByYear> = objectMapper.readValue(url)
        model.addAttribute("maintenanceCorrectiveByCustomerDataList", maintenancePreventiveByCustomerDataList)
        return "maintenance_preventive/by_customer"
    }
}