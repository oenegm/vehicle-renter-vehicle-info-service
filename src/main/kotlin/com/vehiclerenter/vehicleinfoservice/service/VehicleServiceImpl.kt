package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.VehicleDao
import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import com.vehiclerenter.vehicleinfoservice.mapper.VehicleMapper
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import java.util.*

@Service
@Primary
class VehicleServiceImpl(val dao: VehicleDao, val mapper: VehicleMapper) : VehicleService {

    override fun getAllVehicles(): List<VehicleDto> = dao.findAll().map(mapper::toDto)

    override fun getVehicleById(vehicleId: UUID): VehicleDto? {

        return dao.findById(vehicleId)?.let(mapper::toDto)
            ?: throw RuntimeException("Vehicle with id $vehicleId not found")
    }

    override fun createVehicle(vehicleDto: VehicleDto): VehicleDto {

        return mapper.toDto(
            dao.save(
                mapper.toEntity(vehicleDto)
            )
        )
    }

    override fun updateVehicle(vehicleId: UUID, vehicleDto: VehicleDto): VehicleDto {

        var updatedVehicle: Vehicle? = dao.findById(vehicleId)

        updatedVehicle?.let {

            updatedVehicle = mapper.partialUpdate(vehicleDto, it)

            return mapper.toDto(
                dao.save(updatedVehicle!!)
            )
        } ?: throw RuntimeException("Vehicle with id $vehicleId not found")
    }

    override fun deleteVehicleSoft(vehicleId: UUID) {
        val deletedVehicle: Vehicle? = dao.findById(vehicleId)

        deletedVehicle?.let {

            deletedVehicle.isDeleted = true

            dao.save(deletedVehicle)
        } ?: throw RuntimeException("Vehicle with id $vehicleId not found")
    }
}