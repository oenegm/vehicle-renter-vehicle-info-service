package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.BrandDao
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class BrandService(private val dao: BrandDao) {

    fun getBrands() = dao.findAll().map { it.toDto() }
}