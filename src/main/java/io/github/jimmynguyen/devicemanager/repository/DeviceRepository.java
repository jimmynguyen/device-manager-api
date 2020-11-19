package io.github.jimmynguyen.devicemanager.repository;

import io.github.jimmynguyen.devicemanager.domain.Device;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeviceRepository {
    private static List<Device> devices = new ArrayList<>();

    public DeviceRepository() {
        // using static application data store as a temporary measure. ideally would connect to database

        // initialize devices
        devices.add(new Device("12-1222","MACHINE_CODE_1","DEVICE_1"));
        devices.add(new Device("3455670-22222","MACHINE_CODE_2","DEVICE_2"));
        devices.add(new Device("1-00022221","MACHINE_CODE_3","DEVICE_3"));
    }

    public List<Device> getAll() {
        return devices;
    }

    public Optional<Device> findBySerialNumber(String serialNumber) {
        return devices.stream().filter(x -> x.getSerialNumber().equals(serialNumber)).findFirst();
    }

    public Optional<Device> findByMachineCode(String machineCode) {
        return devices.stream().filter(x -> x.getMachineCode().equals(machineCode)).findFirst();
    }

    public void add(Device device) {
        devices.add(device);
    }

    public void updateByMachineCode(String machineCode, Device updatedDevice) {
        Optional<Device> existingDevice = findByMachineCode(machineCode);
        if (existingDevice.isPresent()) {
            existingDevice.get().setSerialNumber(updatedDevice.getSerialNumber());
            existingDevice.get().setDeviceName(updatedDevice.getDeviceName());
        }
    }

    public void updateBySerialNumber(String serialNumber, Device updatedDevice) {
        Optional<Device> existingDevice = findBySerialNumber(serialNumber);
        if (existingDevice.isPresent()) {
            existingDevice.get().setMachineCode(updatedDevice.getMachineCode());
            existingDevice.get().setDeviceName(updatedDevice.getDeviceName());
        }
    }
}
