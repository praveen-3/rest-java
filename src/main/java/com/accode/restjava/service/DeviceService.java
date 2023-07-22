package com.accode.restjava.service;

import com.accode.restjava.model.Device;
import com.accode.restjava.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device getDevice(long deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow(()-> new IllegalArgumentException("Device not found"));
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<Device> getDeviceByImei(long imei) {
        return deviceRepository.getDeviceByImei(imei);
    }
}
