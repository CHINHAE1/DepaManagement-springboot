package org.example.depamanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DepaManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepaManagementApplication.class, args);
    }

}
