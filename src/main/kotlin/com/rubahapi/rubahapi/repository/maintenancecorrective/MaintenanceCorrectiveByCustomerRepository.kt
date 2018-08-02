package com.rubahapi.rubahapi.repository.maintenancecorrective

import com.rubahapi.rubahapi.model.maintenancecorrective.MaintenanceCorrectiveByCustomer
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async

class ConstantMaintenanceCorrectiveByCustomerRepository{
    companion object {
        const val QUERY = """
                        SELECT
                            "public".res_partner."id",
                            "public".res_partner."name" AS customer_name,
                            "public".project_site.tahun,
                            SUM(A.nilai_po) AS nilai_po
                        FROM
                            "public".project_project
                        LEFT JOIN "public".project_site ON "public".project_project.site_id = "public".project_site."id"
                        LEFT JOIN "public".res_partner ON "public".project_site.customer_id = "public".res_partner."id"
                        LEFT JOIN (
                                SELECT
                                "public".sale_order_line.project_id,
                                "public".sale_order_line.price_unit * "public".sale_order_line.product_uom_qty nilai_po
                                FROM
                                "public".sale_order_line
                                LEFT JOIN "public".sale_order ON "public".sale_order_line.order_id = "public".sale_order."id"
                                WHERE
                                "public".sale_order."state" NOT IN ('draft', 'cancel')
                            ) AS A ON A.project_id = "public".project_project."id"
                        WHERE
                            "public".project_project.site_type_id = 7 AND
                            "public".project_site.tahun IS NOT NULL AND
                            "public".project_site.bulan IS NOT NULL AND
                            "public".res_partner."id" IS NOT NULL
                        GROUP BY
                            "public".res_partner."id",
                            "public".res_partner."name",
                            "public".project_site.tahun
                        """
    }
}

interface MaintenanceCorrectiveByCustomerRepository: CrudRepository<MaintenanceCorrectiveByCustomer, Long>{

    @Async
    @Query(ConstantMaintenanceCorrectiveByCustomerRepository.QUERY, nativeQuery = true)
    fun getAll(): Iterable<MaintenanceCorrectiveByCustomer>
}