package io.github.jimmynguyen.devicemanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.jimmynguyen.devicemanager.domain.Device;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DeviceResponse {
    private String resourceKey;
    private String errorCode;
    private String message;
    private List<Device> devices = new ArrayList<>();

    public DeviceResponse(String resourceKey, String errorCode, String message) {
        this.resourceKey = resourceKey;
        this.errorCode = errorCode;
        this.message = message;
    }

    public DeviceResponse(DeviceResponseCode error) {
        this(error.getResourceKey(), error.getErrorCode(), error.getMessage());
    }

    public DeviceResponse(List<Device> devices) {
        this.devices = devices;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
