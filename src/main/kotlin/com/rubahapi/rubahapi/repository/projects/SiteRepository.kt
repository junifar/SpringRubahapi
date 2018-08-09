package com.rubahapi.rubahapi.repository.projects

import com.rubahapi.rubahapi.model.projects.Site
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async

class ConstantSite{
    companion object {
        const val QUERY = """SELECT id, name from project_site"""
    }
}
interface SiteRepository: CrudRepository<Site, Long>{
    @Async
    @Query(ConstantSite.QUERY, nativeQuery = true)
    fun getAll():Iterable<Site>
}