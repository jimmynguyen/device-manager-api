package io.github.jimmynguyen.devicemanager.controller;

import io.github.jimmynguyen.devicemanager.domain.Device;
import io.github.jimmynguyen.devicemanager.dto.DeviceResponse;
import io.github.jimmynguyen.devicemanager.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "getAllDevices",
            notes = "get all devices",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<DeviceResponse> getAllDevices() {
        return new ResponseEntity<>(deviceService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/machineCode/{machineCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "findByMachineCode",
            notes = "find device by machine code",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = DeviceResponse.class)
    })
    public ResponseEntity<DeviceResponse> findByMachineCode(
            @PathVariable("machineCode") String machineCode
    ) {
        return new ResponseEntity<>(deviceService.findByMachineCode(machineCode), HttpStatus.OK);
    }

    @GetMapping(value = "/serialNumber/{serialNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "findBySerialNumber",
            notes = "find device by serial number",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = DeviceResponse.class)
    })
    public ResponseEntity<DeviceResponse> findBySerialNumber(
            @PathVariable("serialNumber") String serialNumber
    ) {
        return new ResponseEntity<>(deviceService.findBySerialNumber(serialNumber), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "addDevice",
            notes = "add device",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<DeviceResponse> addDevice(
            @RequestBody Device device
    ) {
        return new ResponseEntity<>(deviceService.add(device), HttpStatus.OK);
    }

    @PutMapping(value = "/machineCode/{machineCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "updateByMachineCode",
            notes = "update device by machine code",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = DeviceResponse.class)
    })
    public ResponseEntity<DeviceResponse> updateByMachineCode(
            @PathVariable("machineCode") String machineCode,
            @RequestBody Device device
    ) {
        return new ResponseEntity<>(deviceService.updateByMachineCode(machineCode, device), HttpStatus.OK);
    }

    @PutMapping(value = "/serialNumber/{serialNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "updateBySerialNumber",
            notes = "update device by serial number",
            response = DeviceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DeviceResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = DeviceResponse.class)
    })
    public ResponseEntity<DeviceResponse> updateBySerialNumber(
            @PathVariable("serialNumber") String serialNumber,
            @RequestBody Device device
    ) {
        return new ResponseEntity<>(deviceService.updateBySerialNumber(serialNumber, device), HttpStatus.OK);
    }
}

