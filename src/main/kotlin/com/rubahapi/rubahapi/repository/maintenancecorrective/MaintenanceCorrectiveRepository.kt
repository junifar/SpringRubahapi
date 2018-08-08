package com.rubahapi.rubahapi.repository.maintenancecorrective

import com.rubahapi.rubahapi.model.maintenancepreventive.MaintenancePreventive
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async

class ConstantMaintenanceCorrective{
    companion object {
        const val QUERY = """
                            SELECT
                            "public".project_project."id",
                            "public".project_site_type."name" AS site_type,
                            "public".account_analytic_account."name" AS project_id,
                            "public".project_site."name" AS site_name,
                            "public".project_site.tahun,
                            "public".project_site.bulan
                            FROM
                            "public".project_project
                            LEFT JOIN "public".project_site ON "public".project_project.site_id = "public".project_site."id"
                            LEFT JOIN "public".project_site_type ON "public".project_project.site_type_id = "public".project_site_type."id"
                            LEFT JOIN "public".account_analytic_account ON "public".project_project.analytic_account_id = "public".account_analytic_account."id"
                            WHERE
                            "public".project_project.site_type_id = 7 AND
                            "public".project_site.tahun IS NOT NULL AND
                            "public".project_site.bulan IS NOT NULL
                            """
    }
}

interface MaintenanceCorrectiveRepository: CrudRepository<MaintenancePreventive, Long>{

    @Async
    @Query(ConstantMaintenanceCorrective.QUERY, nativeQuery = true)
    fun getAll(): Iterable<MaintenancePreventive>
}