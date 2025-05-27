package com.gini.customer.external.api.controllers;

import com.gini.customer.external.api.generated.api.CustomerApi;
import com.gini.customer.external.api.generated.model.CustomerRequest;
import com.gini.customer.internal.services.CustomerServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerServiceImpl customerService;

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest);
    }
}
