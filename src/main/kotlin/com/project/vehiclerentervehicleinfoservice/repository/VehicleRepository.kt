package com.project.vehiclerentervehicleinfoservice.repository

import com.project.vehiclerentervehicleinfoservice.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VehicleRepository : JpaRepository<Vehicle, UUID>