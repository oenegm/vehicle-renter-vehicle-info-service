package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import com.vehiclerenter.vehicleinfoservice.repository.VehicleSettingsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class VehicleSettingsDaoJpaImpl(val repository: VehicleSettingsRepository) : VehicleSettingsDao {

    override fun findById(id: UUID): VehicleSettings? = repository.findByIdOrNull(id)

    override fun findByVehicleId(vehicleId: UUID): VehicleSettings? = repository.findByVehicleId(vehicleId).unwrap()

    private fun <T> Optional<T>.unwrap(): T? = orElse(null)
}