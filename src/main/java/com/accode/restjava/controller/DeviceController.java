package com.accode.restjava.controller;

import com.accode.restjava.model.Device;
import com.accode.restjava.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/device")
    public ResponseEntity<Device> saveDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.saveDevice(device);
        return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
    }

    @GetMapping("/device")
    public ResponseEntity<Device> getDeviceById(@RequestParam(name = "deviceId") long deviceId) {
        Device device = deviceService.getDevice(deviceId);
        return new ResponseEntity<>(device,HttpStatus.OK);
    }

    @GetMapping("/devices")
    public List<Device> getDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/device-by-imei")
    public List<Device> getDeviceByImei(@RequestParam(name = "imei") long imei) {
        return deviceService.getDeviceByImei(imei);
    }

    @PatchMapping("/device")
    public ResponseEntity<Device> updateDevice(@RequestBody Device device){
        Device updateDevice = deviceService.updateDevice(device);
        return new ResponseEntity<>(updateDevice,HttpStatus.OK);
    }
}
