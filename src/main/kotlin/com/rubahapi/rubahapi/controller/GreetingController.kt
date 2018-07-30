package com.rubahapi.rubahapi.controller

import com.rubahapi.rubahapi.model.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController{
    val templates:String = "Hello, %s"
    val counter:AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting(
            counter.incrementAndGet(),
            "Hello, $name")
}