package com.rubahapi.rubahapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rubahapi.rubahapi.model.ProjectInformation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class HelloWorldController{
    @GetMapping("/")
    fun index() = "Hallo Apa Kabar"

    @GetMapping("/baik/kok")
    fun test() = "Baik Kok"

    @GetMapping("/test")
    fun test1(): String {
        val objectMapper = ObjectMapper()
        val map = mapOf(1 to "x", 2 to "Y")
        val sample = objectMapper.writeValueAsString(map)

        val url = URL("http://localhost:8080/project_information")
        val sample1: List<ProjectInformation> = objectMapper.readValue(url)
        sample1.forEach {
            println("${it.site_type} - ${it.id}")
        }
        System.out.println("TEST 9999")
        return "123"
    }
}