package com.vehiclerenter.vehicleinfoservice.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import lombok.Getter
import lombok.Setter
import java.util.*

@Getter
@Setter
@Entity
@Table(name = "vehicle_settings")
class VehicleSettings {
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    var vehicle: Vehicle? = null

    @NotNull
    @Column(name = "visible", nullable = false)
    var visible: Boolean = false

    @NotNull
    @Column(name = "out_of_service", nullable = false)
    var outOfService: Boolean = false
}