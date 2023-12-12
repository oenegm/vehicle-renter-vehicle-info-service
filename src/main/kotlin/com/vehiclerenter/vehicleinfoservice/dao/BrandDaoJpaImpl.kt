package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.Brand
import com.vehiclerenter.vehicleinfoservice.repository.BrandRepository
import org.springframework.stereotype.Repository

@Repository
class BrandDaoJpaImpl(private val repository: BrandRepository) : BrandDao {

    override fun findAll(): List<Brand> = repository.findAll()
}