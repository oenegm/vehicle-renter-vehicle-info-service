package com.vehiclerenter.vehicleinfoservice.mapper

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class VehicleMapper {

    @Mappings(
        Mapping(source = "brandId", target = "brand.id"),
        Mapping(source = "brandName", target = "brand.name"),
        Mapping(source = "brandImageLink", target = "brand.imageLink"),
        Mapping(source = "vehicleSettingsId", target = "vehicleSettings.id"),
        Mapping(source = "vehicleSettingsIsVisible", target = "vehicleSettings.isVisible"),
        Mapping(source = "vehicleSettingsIsOutOfOrder", target = "vehicleSettings.isOutOfOrder")
    )
    abstract fun toEntity(vehicleDto: VehicleDto): Vehicle

    @InheritInverseConfiguration(name = "toEntity")
    abstract fun toDto(vehicle: Vehicle): VehicleDto

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(vehicleDto: VehicleDto, @MappingTarget vehicle: Vehicle): Vehicle
}