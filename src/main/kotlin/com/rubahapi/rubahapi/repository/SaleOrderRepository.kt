package com.rubahapi.rubahapi.repository

import com.rubahapi.rubahapi.model.SaleOrder
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleOrderRepository: CrudRepository<SaleOrder, Long>{}