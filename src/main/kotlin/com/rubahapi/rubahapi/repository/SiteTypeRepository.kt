package com.rubahapi.rubahapi.repository

import com.rubahapi.rubahapi.model.ProjectSiteType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SiteTypeRepository : CrudRepository<ProjectSiteType, Long>{

//    fun findByLastName(lastName: String): Iterable<SiteType>
}