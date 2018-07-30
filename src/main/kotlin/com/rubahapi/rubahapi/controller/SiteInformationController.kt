package com.rubahapi.rubahapi.controller

import com.rubahapi.rubahapi.repository.SiteInformationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SiteInformationController{

    @Autowired
    lateinit var repository: SiteInformationRepository

    @RequestMapping("/site_information")
    fun findSiteName() = repository.findSiteName()

    @RequestMapping("site_information/{id}")
    fun findSiteById(@PathVariable id:Long) = repository.findSiteById(id)
}