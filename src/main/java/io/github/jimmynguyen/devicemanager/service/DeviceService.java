package io.github.jimmynguyen.devicemanager.service;

import io.github.jimmynguyen.devicemanager.domain.Device;
import io.github.jimmynguyen.devicemanager.dto.DeviceResponseCode;
import io.github.jimmynguyen.devicemanager.repository.DeviceRepository;
import io.github.jimmynguyen.devicemanager.dto.DeviceResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceResponse getAll() {
        return new DeviceResponse(deviceRepository.getAll());
    }

    public DeviceResponse findByMachineCode(String machineCode) {
        if (!isValidMachineCode(machineCode)) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_INVALID);
        }

        Optional<Device> device = deviceRepository.findByMachineCode(machineCode);
        if (!device.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_NOT_FOUND);
        }

        return new DeviceResponse(Arrays.asList(device.get()));
    }

    public DeviceResponse findBySerialNumber(String serialNumber) {
        if (!isValidSerialNumber(serialNumber)) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_INVALID);
        }

        Optional<Device> device = deviceRepository.findBySerialNumber(serialNumber);
        if (!device.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_NOT_FOUND);
        }

        return new DeviceResponse(Arrays.asList(device.get()));
    }

    public DeviceResponse add(Device device) {
        if (!isValidMachineCode(device.getMachineCode())) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_INVALID);
        }

        if (!isValidSerialNumber(device.getSerialNumber())) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_INVALID);
        }

        Optional<Device> existingDevice = deviceRepository.findByMachineCode(device.getMachineCode());
        if (existingDevice.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.DEVICE_ALREADY_EXISTS);
        }

        existingDevice = deviceRepository.findBySerialNumber(device.getSerialNumber());
        if (existingDevice.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.DEVICE_ALREADY_EXISTS);
        }

        deviceRepository.add(device);

        return new DeviceResponse(DeviceResponseCode.DEVICE_CREATION_SUCCESS);
    }

    public DeviceResponse updateByMachineCode(String machineCode, Device device) {
        if (!isValidMachineCode(machineCode)) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_INVALID);
        }

        if (!isValidSerialNumber(device.getSerialNumber())) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_INVALID);
        }

        Optional<Device> existingDevice = deviceRepository.findByMachineCode(machineCode);
        if (!existingDevice.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_NOT_FOUND);
        }

        deviceRepository.updateByMachineCode(machineCode, device);

        return new DeviceResponse(DeviceResponseCode.DEVICE_UPDATE_SUCCESS);
    }

    public DeviceResponse updateBySerialNumber(String serialNumber, Device device) {
        if (!isValidMachineCode(device.getMachineCode())) {
            return new DeviceResponse(DeviceResponseCode.MACHINE_CODE_INVALID);
        }

        if (!isValidSerialNumber(serialNumber)) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_INVALID);
        }

        Optional<Device> existingDevice = deviceRepository.findBySerialNumber(serialNumber);
        if (!existingDevice.isPresent()) {
            return new DeviceResponse(DeviceResponseCode.SERIAL_NUMBER_NOT_FOUND);
        }

        deviceRepository.updateBySerialNumber(serialNumber, device);

        return new DeviceResponse(DeviceResponseCode.DEVICE_UPDATE_SUCCESS);
    }

    private boolean isValidMachineCode(String machineCode) {
        return Strings.isNotBlank(machineCode);
    }

    private boolean isValidSerialNumber(String serialNumber) {
        if (Strings.isBlank(serialNumber)) {
            return false;
        }

        // valid pattern: (one or more alphanumeric chars)-(one or more alphanumeric chars)
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+-[A-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(serialNumber);
        return matcher.find();
    }
}
