package com.vehiclerenter.vehicleinfoservice.mapper

import com.vehiclerenter.vehicleinfoservice.dto.VehicleSettingsDto
import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface VehicleSettingsMapper {

    @Mapping(source = "vehicleId", target = "vehicle.id")
    fun toEntity(vehicleSettingsDto: VehicleSettingsDto): VehicleSettings

    @InheritInverseConfiguration(name = "toEntity")
    fun toDto(vehicleSettings: VehicleSettings): VehicleSettingsDto

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(
        vehicleSettingsDto: VehicleSettingsDto,
        @MappingTarget vehicleSettings: VehicleSettings
    ): VehicleSettings
}