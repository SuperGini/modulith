@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {"order::events", "generated::api", "generated::model"}
)
package com.gini.store;