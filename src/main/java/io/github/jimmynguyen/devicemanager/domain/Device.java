package io.github.jimmynguyen.devicemanager.domain;

public class Device {
    private String serialNumber;
    private String machineCode;
    private String deviceName;

    public Device(String serialNumber, String machineCode, String deviceName) {
        this.serialNumber = serialNumber;
        this.machineCode = machineCode;
        this.deviceName = deviceName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
