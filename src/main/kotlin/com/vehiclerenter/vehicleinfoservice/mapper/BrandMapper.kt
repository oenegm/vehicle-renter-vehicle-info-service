package com.vehiclerenter.vehicleinfoservice.mapper

import com.vehiclerenter.vehicleinfoservice.dto.BrandDto
import com.vehiclerenter.vehicleinfoservice.entity.Brand
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface BrandMapper {

    fun toEntity(brandDto: BrandDto): Brand

    fun toDto(brand: Brand): BrandDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(brandDto: BrandDto, @MappingTarget brand: Brand): Brand
}