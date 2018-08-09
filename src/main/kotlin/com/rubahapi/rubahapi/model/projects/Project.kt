package com.rubahapi.rubahapi.model.projects

import javax.persistence.*

@Entity
class Project(
        @Id
        val id: Long,
        val name: String
){
    constructor(): this(0,"")
}