package com.rubahapi.rubahapi.controller.API.maintenancepreventive

import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventive
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventiveByCustomer
import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventiveByYear
import com.rubahapi.rubahapi.repository.maintenancecorrective.MaintenanceCorrectiveByCustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MaintenancePreventiveByCustomerController{

    @Autowired
    lateinit var repository: MaintenanceCorrectiveByCustomerRepository

    @RequestMapping("/api/maintenance_preventive_by_customer")
    fun getAll() = repository.getAll()

    @RequestMapping("/api/maintenance_preventive/group")
    fun getAllPreventive(): MutableList<MaintenancePreventiveByYear> {
        var yearGroup: MutableList<MaintenancePreventiveByYear> = mutableListOf()
        val data = repository.getAll()
        var id=1
        data.forEach{
            item->
            var found = false
            yearGroup.forEach{
                itemDetail->
                if (itemDetail.year == item.tahun){
                    found = true
                }
            }
            if (!found){
                item.tahun?.let { yearGroup.add(MaintenancePreventiveByYear(id++,item.tahun, null)) }
            }
        }

        yearGroup.forEach{
            item->
            item.line_data = findPreventiveByYearData(item.year, data)
        }
        return yearGroup
    }

    fun findPreventiveByYearData(year:String, datas:Iterable<MaintenancePreventiveByCustomer>): MutableList<MaintenancePreventiveByCustomer> {
        var maintenancePreventiveByCustomers:MutableList<MaintenancePreventiveByCustomer> = mutableListOf()
        datas.forEach{
            itemDetail ->
            if (year == itemDetail.tahun){
                maintenancePreventiveByCustomers.add(itemDetail)
            }
        }
        return maintenancePreventiveByCustomers
    }
}