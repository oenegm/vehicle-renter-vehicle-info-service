package com.project.vehiclerentervehicleinfoservice.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.URL
import java.io.Serializable
import java.util.*

/**
 * DTO for {@link com.project.vehiclerentervehicleinfoservice.entity.Brand}
 */
data class BrandDto(
    var id: UUID? = null,
    @field:NotNull @field:Size(max = 45) @field:NotEmpty var name: String? = null,
    @field:NotNull @field:Size(max = 45) @field:NotEmpty var country: String? = null,
    @field:NotNull @field:Size(max = 255) @field:NotEmpty @field:URL var imageLink: String? = null
) : Serializable