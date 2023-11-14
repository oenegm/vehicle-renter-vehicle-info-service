package com.vehiclerenter.vehicleinfoservice.mapper

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface VehicleMapper {

    @Mappings(
        Mapping(source = "brandId", target = "brand.id"),
        Mapping(source = "brandName", target = "brand.name"),
        Mapping(source = "brandImageLink", target = "brand.imageLink"),
        Mapping(source = "vehicleSettingsId", target = "vehicleSettings.id"),
    )
    fun toEntity(vehicleDto: VehicleDto): Vehicle

    @InheritInverseConfiguration(name = "toEntity")
    @Mappings(
        Mapping(source = "vehicleSettings.visible", target = "vehicleSettingsIsVisible"),
        Mapping(source = "vehicleSettings.outOfOrder", target = "vehicleSettingsIsOutOfOrder")
    )
    fun toDto(vehicle: Vehicle): VehicleDto

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(vehicleDto: VehicleDto, @MappingTarget vehicle: Vehicle): Vehicle
}