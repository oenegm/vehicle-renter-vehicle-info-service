package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.BrandDao
import com.vehiclerenter.vehicleinfoservice.mapper.BrandMapper
import org.springframework.stereotype.Service

@Service
class BrandServiceImpl(val dao: BrandDao, private val brandMapper: BrandMapper) : BrandService {

    override fun getBrands() = dao.getBrands().map(brandMapper::toDto)
}