package com.rubahapi.rubahapi.controller

import com.rubahapi.rubahapi.repository.SaleOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SaleOrderController{

    @Autowired
    lateinit var repository: SaleOrderRepository

    @RequestMapping("/sale_order")
    fun findAll() = repository.findAll()
}