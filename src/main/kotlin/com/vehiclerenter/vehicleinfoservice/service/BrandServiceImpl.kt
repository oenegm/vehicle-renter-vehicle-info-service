package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.BrandDao
import com.vehiclerenter.vehicleinfoservice.mapper.BrandMapper
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class BrandServiceImpl(val dao: BrandDao, val brandMapper: BrandMapper) : BrandService {

    override fun getBrands() = dao.findAll().map(brandMapper::toDto)
}