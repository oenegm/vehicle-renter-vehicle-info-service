package com.vehiclerenter.vehicleinfoservice.controller

import com.vehiclerenter.vehicleinfoservice.service.VehicleSettingsService
import org.springframework.web.bind.annotation.RestController

@RestController
class VehicleSettingsController(val service: VehicleSettingsService) {
}