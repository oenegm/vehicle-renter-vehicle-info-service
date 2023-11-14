package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.VehicleSettingsDao
import com.vehiclerenter.vehicleinfoservice.mapper.VehicleSettingsMapper
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class VehicleSettingsServiceImpl(val dao: VehicleSettingsDao, val mapper: VehicleSettingsMapper) :
    VehicleSettingsService