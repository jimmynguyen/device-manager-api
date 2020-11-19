package io.github.jimmynguyen.devicemanager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "io.github.jimmynguyen.devicemanager"
})
public class DeviceManagerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(DeviceManagerApplication.class, args);
            System.out.println("Initialized application");
        } catch (Exception e) {
            System.out.println("Error initializing application");
        }
    }
}
