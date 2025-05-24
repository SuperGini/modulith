package com.gini.store.external.api;

import com.gini.ModulithAutoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;

@ApplicationModule
class StoreArchTest {

    ApplicationModules modules = ApplicationModules.of(ModulithAutoApplication.class);

    @Test
    void testArchOfModule() {
        System.out.println(modules.toString());
        var x = modules.verify();

    }

}