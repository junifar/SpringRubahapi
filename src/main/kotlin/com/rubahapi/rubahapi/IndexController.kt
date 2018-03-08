package com.rubahapi.rubahapi

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController{

    @RequestMapping("/hello")
    fun index(): String {
        return "index"
    }
}