package com.rubahapi.rubahapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.maintenancecorrective.MaintenanceCorrective
import com.rubahapi.rubahapi.model.maintenancecorrective.MaintenanceCorrectiveByCustomer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URL

@Controller
class MaintenanceCorrectiveViewController{

    class YearGroup(
            val year:Int,
            var maintenanceCorrectiveList: MutableList<MaintenanceCorrectiveByCustomer>?
    ){
        private constructor(): this(0, null)
    }

    @RequestMapping("/maintenance_corrective")
    fun getAll(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_corrective")
        val maintenanceCorrectiveDataList: List<MaintenanceCorrective> = objectMapper.readValue(url)
        model.addAttribute("maintenanceCorrectiveDataList", maintenanceCorrectiveDataList)
        return "maintenance_corrective/index"
    }

    @RequestMapping("/maintenance_corrective/by_customer")
    fun getAllByCustomer(model: Model): String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/api/maintenance_corrective_by_customer")
        val maintenanceCorrectiveByCustomerDataList: List<MaintenanceCorrectiveByCustomer> = objectMapper.readValue(url)
        var yearGroup: MutableList<YearGroup> = mutableListOf()

        //get Group Of Year
        maintenanceCorrectiveByCustomerDataList.forEach{item ->
            var found:Boolean = false
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
            var maintenanceCorrectiveByCustomers:MutableList<MaintenanceCorrectiveByCustomer> = mutableListOf()
            maintenanceCorrectiveByCustomerDataList.forEach{
                itemDetail ->
                if (item.year == itemDetail.tahun){
                    println(itemDetail.customer_name)
                    maintenanceCorrectiveByCustomers.add(itemDetail)
                }
            }
            item.maintenanceCorrectiveList = maintenanceCorrectiveByCustomers
        }

//        var data1 = YearGroup(2017, null)
//        var data2 = YearGroup(2018, null)
//        yearGroup.add(data1)
//        yearGroup.add(data2)
        yearGroup.forEach{
            item ->
            println(item.year)
            item.maintenanceCorrectiveList?.forEach { dataItem ->
                println(dataItem.customer_name)
            }
        }
        model.addAttribute("maintenanceCorrectiveByCustomerDataList", maintenanceCorrectiveByCustomerDataList)
        return "maintenance_corrective/by_customer"
    }
}