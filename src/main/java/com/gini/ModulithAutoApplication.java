package com.gini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

//@Modulithic(
////        sharedModules = {"com.gini.generated.car"},
//        additionalPackages = {"com.gini.generated.car"},
//        useFullyQualifiedModuleNames = true
//
//)


@SpringBootApplication
public class ModulithAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModulithAutoApplication.class, args);
    }

}
