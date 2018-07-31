package com.rubahapi.rubahapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.ProjectInformation
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URL

@Controller
class ProjectInformationViewController{

    @RequestMapping("/project_information/all")
    fun projectInformationAll(model:Model):String{
        val objectMapper = ObjectMapper()
        val url = URL("http://localhost:8080/project_information")
        val projectInformationDatas: List<ProjectInformation> = objectMapper.readValue(url)
//        projectInformationDatas.forEach {
//            println("${it.site_type} - ${it.total_project}")
//        }
        model.addAttribute("projectInformationDatas", projectInformationDatas)
        return "project_information/index"
    }
}