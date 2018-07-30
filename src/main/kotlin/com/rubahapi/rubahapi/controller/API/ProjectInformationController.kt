package com.rubahapi.rubahapi.controller.API

import com.rubahapi.rubahapi.repository.ProjectInformationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectInformationController{

    @Autowired
    lateinit var repository: ProjectInformationRepository


    @RequestMapping("/project_information")
    fun getAllProject() = repository.getAllProject()
}