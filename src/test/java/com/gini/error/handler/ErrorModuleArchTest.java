package com.gini.error.handler;

import com.gini.ModulithAutoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ErrorModuleArchTest {

    @Test
    void testErrorModuleArch() {
        ApplicationModules.of(ModulithAutoApplication.class);
    }

    //  https://docs.spring.io/spring-modulith/reference/documentation.html
    @Test
    void writeDocumentation() {
        var module = ApplicationModules.of(ModulithAutoApplication.class);

        new Documenter(module).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
    }
}
