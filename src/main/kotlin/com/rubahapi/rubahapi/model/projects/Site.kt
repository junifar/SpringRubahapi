package com.rubahapi.rubahapi.model.projects

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Site(
        @Id
        val id: Long,
        val name: String,
        @OneToMany
        val projects: List<Project> = emptyList()
){
    constructor(): this(0, "")
}