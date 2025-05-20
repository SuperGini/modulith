package com.gini.customer.internal.services;

import com.gini.customer.internal.domain.entities.Customer;
import com.gini.customer.internal.domain.repositories.CustomerRepository;
import com.gini.generated.car.model.CustomerRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void createCustomer(CustomerRequest customerRequest) {
        var customer = new Customer();
        customer.setName(customerRequest.getName());
        customerRepository.save(customer);
    }

}
