package io.github.jimmynguyen.devicemanager.dto;

public enum DeviceResponseCode {
    MACHINE_CODE_INVALID("machine.code.invalid","ER001","The machine code is incorrect. Check the Machine code you provided and try again."),
    MACHINE_CODE_NOT_FOUND("machine.code.not.found","ER002","The machine code does not match our records."),
    SERIAL_NUMBER_INVALID("serial.number.invalid","ER003","The serial number entered can include a - z, A - Z, 0 - 9 and hyphen. Please correct your entry."),
    SERIAL_NUMBER_NOT_FOUND("serial.number.not.found","ER004","The serial number does not match our records."),
    DEVICE_ALREADY_EXISTS("device.already.exists","ER005","The device being created already exists."),
    DEVICE_CREATION_SUCCESS("device.added.successfully",null,"The device was added."),
    DEVICE_UPDATE_SUCCESS("device.updated.successfully",null,"The device was updated.");

    private String resourceKey;
    private String errorCode;
    private String message;

    private DeviceResponseCode(String resourceKey, String errorCode, String message) {
        this.resourceKey = resourceKey;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
