package com.vehiclerenter.vehicleinfoservice.repository

import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VehicleRepository : JpaRepository<Vehicle, UUID> {

    fun findAllByDeletedFalse(): List<Vehicle>
    fun findByIdAndDeletedFalse(id: UUID): Optional<Vehicle>
}