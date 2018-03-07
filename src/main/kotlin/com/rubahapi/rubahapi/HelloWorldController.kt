package com.rubahapi.rubahapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController{
    @GetMapping("/")
    fun index() = "Hallo Apa Kabar"

    @GetMapping("/baik/kok")
    fun test() = "Baik Kok"
}