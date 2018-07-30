package com.rubahapi.rubahapi.model

import javax.persistence.*

@Entity
//@Table(name= SiteInformation.tableName)
class SiteInformation(
        val name: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1
){
    companion object {
        const val tableName: String = "project_site"
    }
    private constructor(): this("", 0)
}