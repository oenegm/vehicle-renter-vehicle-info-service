package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.Brand

fun interface BrandDao {

    fun findAll(): List<Brand>
}