package com.vehiclerenter.vehicleinfoservice.entity

import com.vehiclerenter.vehicleinfoservice.dto.VehicleSettingsDto
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@Entity
@Table(name = "vehicle_settings")
class VehicleSettings(
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    var vehicle: Vehicle? = null,

    @NotNull
    @Column(name = "visible", nullable = false)
    var visible: Boolean = false,

    @NotNull
    @Column(name = "out_of_service", nullable = false)
    var outOfService: Boolean = false,
) {
    fun toDto() = VehicleSettingsDto(
        id = this.id,
        visible = this.visible,
        outOfService = this.outOfService,
    )

    fun partialUpdate(dto: VehicleSettingsDto): VehicleSettings {

        this.visible = dto.visible ?: this.visible
        this.outOfService = dto.outOfService ?: this.outOfService

        return this
    }
}