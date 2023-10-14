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
    )
    abstract fun toEntity(vehicleDto: VehicleDto): Vehicle

    @InheritInverseConfiguration(name = "toEntity")
    @Mappings(
        Mapping(source = "vehicleSettings.visible", target = "vehicleSettingsIsVisible"),
        Mapping(source = "vehicleSettings.outOfOrder", target = "vehicleSettingsIsOutOfOrder")
    )
    abstract fun toDto(vehicle: Vehicle): VehicleDto

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(vehicleDto: VehicleDto, @MappingTarget vehicle: Vehicle): Vehicle
}