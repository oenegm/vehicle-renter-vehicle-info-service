package com.vehiclerenter.vehicleinfoservice.dto

import jakarta.validation.constraints.NotNull
import java.io.Serializable
import java.util.*

/**
 * DTO for {@link com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings}
 */
data class VehicleSettingsDto(
    var id: UUID? = null,
    @field:NotNull var visible: Boolean? = false,
    @field:NotNull var outOfService: Boolean? = false
) : Serializable