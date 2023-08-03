package com.accode.restjava.repository;

import com.accode.restjava.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query(value = "SELECT * FROM device WHERE imei =?1",nativeQuery = true)
    List<Device> getDeviceByImei(long imei);

    @Query(value = "SELECT * FROM device WHERE user_id =?1",nativeQuery = true)
    List<Device> getDevicesByUserId(long userId);
}
