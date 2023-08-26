package com.project.vehiclerentervehicleinfoservice.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@Entity
@Table(name = "vehicle_settings")
open class VehicleSetting {
    @Id
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    open var vehicle: Vehicle? = null

    @NotNull
    @Column(name = "is_visible", nullable = false)
    open var isVisible: Boolean? = false

    @NotNull
    @Column(name = "is_out_of_order", nullable = false)
    open var isOutOfOrder: Boolean? = false
}