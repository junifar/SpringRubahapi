package com.rubahapi.rubahapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventive
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventiveByCustomer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URL

@Controller
class MaintenancePreventiveViewController{

    class YearGroup(
            val year:String,
            var maintenancePreventiveList: MutableList<MaintenancePreventiveByCustomer>?
    ){
        private constructor(): this("", null)
    }

    @RequestMapping("/maintenance_preventive")
    fun getAll(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_preventive")
        val maintenancePreventiveDataList: List<MaintenancePreventive> = objectMapper.readValue(url)
        model.addAttribute("maintenanceCorrectiveDataList", maintenancePreventiveDataList)
        return "maintenance_corrective/index"
    }

    @RequestMapping("/maintenance_preventive/by_customer")
    fun getAllByCustomer(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_preventive_by_customer")
        val maintenancePreventiveByCustomerDataList: List<MaintenancePreventiveByCustomer> = objectMapper.readValue(url)
        var yearGroup: MutableList<YearGroup> = mutableListOf()

        //get Group Of Year
        maintenancePreventiveByCustomerDataList.forEach{ item ->
            var found = false
            yearGroup.forEach detail@{
                itemDetail ->
                if (itemDetail.year == item.tahun){
                    found = true
                }
            }
            if (!found){
                item.tahun?.let { yearGroup.add(YearGroup(it, null)) }
            }
        }

        yearGroup.forEach{item->
            var maintenancePreventiveByCustomers:MutableList<MaintenancePreventiveByCustomer> = mutableListOf()
            maintenancePreventiveByCustomerDataList.forEach{
                itemDetail ->
                if (item.year == itemDetail.tahun){
                    maintenancePreventiveByCustomers.add(itemDetail)
                }
            }
            item.maintenancePreventiveList = maintenancePreventiveByCustomers
        }

        model.addAttribute("maintenanceCorrectiveByCustomerDataList", maintenancePreventiveByCustomerDataList)
        model.addAttribute("maintenanceCorrectiveByCustomerDataListByYear", yearGroup)
        return "maintenance_corrective/by_customer"
    }
}