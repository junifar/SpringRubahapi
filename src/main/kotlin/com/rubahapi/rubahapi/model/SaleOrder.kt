package com.rubahapi.rubahapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SaleOrder(
    val name: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
){
    private constructor(): this("", 0)
}