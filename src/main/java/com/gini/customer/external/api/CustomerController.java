package com.gini.customer.external.api;

import com.gini.customer.internal.services.CustomerService;
import com.gini.generated.car.api.CustomerApi;
import com.gini.generated.car.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest);
    }
}
