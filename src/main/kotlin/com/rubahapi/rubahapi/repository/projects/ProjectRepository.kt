package com.rubahapi.rubahapi.repository.projects

import com.rubahapi.rubahapi.model.projects.Project
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository

class ConstantProject{
    companion object {
        const val QUERY = """
                                    SELECT
                                    "public".project_project."id",
                                    "public".account_analytic_account."name"
                                    FROM
                                    "public".project_project
                                    LEFT JOIN "public".account_analytic_account ON "public".project_project.analytic_account_id = "public".account_analytic_account."id"
                            """
    }
}

@Repository
interface ProjectRepository:CrudRepository<Project, Long>{

    @Async
    @Query(ConstantProject.QUERY, nativeQuery = true)
    fun getAll():Iterable<Project>
}