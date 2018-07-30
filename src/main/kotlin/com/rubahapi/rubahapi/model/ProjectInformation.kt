package com.rubahapi.rubahapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ProjectInformation(
        val total_project: Int,
        val site_type: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val Id:Long=-1
){
    private constructor(): this(0, "", 0)
}