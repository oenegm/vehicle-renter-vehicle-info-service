package com.vehiclerenter.vehicleinfoservice.mapper

import com.vehiclerenter.vehicleinfoservice.dto.VehicleSettingsDto
import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class VehicleSettingsMapper {

    @Mapping(source = "vehicleId", target = "vehicle.id")
    abstract fun toEntity(vehicleSettingsDto: VehicleSettingsDto): VehicleSettings

    @Mapping(source = "vehicle.id", target = "vehicleId")
    abstract fun toDto(vehicleSettings: VehicleSettings): VehicleSettingsDto

    @Mapping(source = "vehicleId", target = "vehicle.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        vehicleSettingsDto: VehicleSettingsDto,
        @MappingTarget vehicleSettings: VehicleSettings
    ): VehicleSettings
}