package com.vehiclerenter.vehicleinfoservice.controller

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import com.vehiclerenter.vehicleinfoservice.dto.VehicleSettingsDto
import com.vehiclerenter.vehicleinfoservice.service.VehicleService
import com.vehiclerenter.vehicleinfoservice.service.VehicleSettingsService
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/vehicles")
class VehicleController(private val service: VehicleService, private val settingsService: VehicleSettingsService) {

    @GetMapping
    fun getVehicles(
    ): ResponseEntity<CollectionModel<VehicleDto>> {

        val vehicles: List<VehicleDto> = service.getAllVehicles()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                CollectionModel
                    .of(vehicles)
                    .add(
                        linkTo<VehicleController> { getVehicles() }.withSelfRel(),
                        linkTo<VehicleController> { getVehicleById(UUID.randomUUID()) }.withSelfRel(),
                        // TODO: make sure this the correct way to put it
                        linkTo<BrandController> { getBrands() }.withSelfRel(),
                    )
            )
    }

    @GetMapping("{vehicleId}")
    fun getVehicleById(
        @PathVariable("vehicleId") vehicleId: UUID,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle: VehicleDto? = service.getVehicleById(vehicleId)

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicleId) }.withSelfRel(),
                        linkTo<BrandController> { getBrands() }.withSelfRel()
                    )
            )
    }

    @PostMapping
    fun createVehicle(
        @RequestBody vehicleDto: VehicleDto,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle = service.createVehicle(vehicleDto)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicle.id!!) }.withSelfRel(),
                        linkTo<BrandController> { getBrands() }.withSelfRel()
                    )
            )
    }

    @PutMapping("{vehicleId}")
    fun updateVehicle(
        @PathVariable("vehicleId") vehicleId: UUID,
        @RequestBody vehicleDto: VehicleDto,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle: VehicleDto = service.updateVehicle(vehicleId, vehicleDto)

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicleId) }.withSelfRel(),
                        linkTo<BrandController> { getBrands() }.withSelfRel()
                    )
            )
    }

    @PutMapping("{vehicleId}/settings")
    fun updateVehicleSettings(
        @PathVariable("vehicleId") vehicleId: UUID,
        @RequestBody settingsDto: VehicleSettingsDto,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicleSettings = settingsService.updateVehicleSettings(vehicleId, settingsDto)

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                RepresentationModel
                    .of(vehicleSettings)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicleId) }.withSelfRel()
                    )
            )
    }

    @DeleteMapping("{vehicleId}")
    fun deleteVehicleSoft(
        @PathVariable("vehicleId") vehicleId: UUID,
    ): ResponseEntity<RepresentationModel<*>> {

        service.deleteVehicleSoft(vehicleId)

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(
                RepresentationModel
                    .of(null)
                    .add(
                        linkTo<VehicleController> { getVehicles() }.withSelfRel(),
                        linkTo<BrandController> { getBrands() }.withSelfRel()
                    )
            )
    }
}
