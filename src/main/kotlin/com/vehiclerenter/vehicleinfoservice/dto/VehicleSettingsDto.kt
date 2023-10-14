package com.vehiclerenter.vehicleinfoservice.dto

import jakarta.validation.constraints.NotNull
import java.io.Serializable
import java.util.*

/**
 * DTO for {@link com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings}
 */
data class VehicleSettingsDto(
    val id: UUID? = null,
    val vehicleId: UUID? = null,
    @field:NotNull val isVisible: Boolean? = false,
    @field:NotNull val isOutOfOrder: Boolean? = false
) : Serializable