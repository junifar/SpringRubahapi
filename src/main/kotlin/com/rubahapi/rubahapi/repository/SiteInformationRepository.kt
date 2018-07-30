package com.rubahapi.rubahapi.repository

import com.rubahapi.rubahapi.model.SiteInformation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async

interface SiteInformationRepository : CrudRepository<SiteInformation, Long>{

    @Async
    @Query("SELECT ID, NAME FROM PROJECT_SITE", nativeQuery = true)
    fun findSiteName(): Iterable<SiteInformation>

    @Async
    @Query("SELECT ID, NAME FROM PROJECT_SITE WHERE ID=:id", nativeQuery = true)
    fun findSiteById(@Param("id") id:Long): Iterable<SiteInformation>
}

