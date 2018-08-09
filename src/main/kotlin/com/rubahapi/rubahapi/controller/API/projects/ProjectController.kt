package com.rubahapi.rubahapi.controller.API.projects

import com.rubahapi.rubahapi.repository.projects.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectController{

    @Autowired
    lateinit var repository: ProjectRepository

    @RequestMapping("/api/project")
    fun getAll() = repository.getAll()
}