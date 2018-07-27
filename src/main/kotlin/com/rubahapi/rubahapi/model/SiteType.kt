package com.rubahapi.rubahapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ProjectSiteType(
        val name: String,
        val kode: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1
){
    private constructor(): this("", "", 0)
}