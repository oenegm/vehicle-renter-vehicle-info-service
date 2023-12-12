package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import com.vehiclerenter.vehicleinfoservice.repository.VehicleSettingsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class VehicleSettingsDaoJpaImpl(private val repository: VehicleSettingsRepository) : VehicleSettingsDao {

    override fun findById(id: UUID): VehicleSettings? = repository.findByIdOrNull(id)

    override fun findByVehicleId(vehicleId: UUID): VehicleSettings? = repository.findByVehicleId(vehicleId).unwrap()
    override fun save(vehicleSettings: VehicleSettings): VehicleSettings = repository.save(vehicleSettings)

    private fun <T> Optional<T>.unwrap(): T? = orElse(null)
}