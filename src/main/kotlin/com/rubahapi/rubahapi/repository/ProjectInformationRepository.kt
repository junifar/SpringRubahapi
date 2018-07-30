package com.rubahapi.rubahapi.repository

import com.rubahapi.rubahapi.model.ProjectInformation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async

class Constant{
    companion object {
        const val QUERY = """SELECT
                    "public".project_site_type."id",
                    Count("public".project_project."id") AS total_project,
                    "public".project_site_type."name" AS site_type
                    FROM
                    "public".project_project
                    LEFT JOIN "public".project_site ON "public".project_project.site_id = "public".project_site."id"
                    INNER JOIN "public".project_site_type ON "public".project_project.site_type_id = "public".project_site_type."id"
                    GROUP BY
                    "public".project_site_type."name",
                    "public".project_site_type."id"
                    ORDER BY
                    "public".project_site_type."id" ASC
                    """
    }
}

interface ProjectInformationRepository: CrudRepository<ProjectInformation, Long>{

    @Async
    @Query(Constant.QUERY, nativeQuery = true)
    fun getAllProject(): Iterable<ProjectInformation>

}