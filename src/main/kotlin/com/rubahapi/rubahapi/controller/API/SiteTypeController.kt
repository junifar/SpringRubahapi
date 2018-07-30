package com.rubahapi.rubahapi.controller.API

import com.rubahapi.rubahapi.repository.SiteTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SiteTypeController{

    @Autowired
    lateinit var repository: SiteTypeRepository

    @RequestMapping("/site_type")
    fun findAll() = repository.findAll()
//
//    @RequestMapping("/site_type/{lastName}")
//    fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)
}