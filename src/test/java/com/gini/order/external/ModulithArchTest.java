package com.gini.order.external;

import com.gini.ModulithAutoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class ModulithArchTest {

    ApplicationModules modules = ApplicationModules.of(ModulithAutoApplication.class);

    @Test
    void testArchOfModul() {
        System.out.println(modules.toString());
        var x = modules.verify();
    }
}
