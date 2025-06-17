package com.gini.customer.internal.services;

import com.gini.customer.external.api.generated.model.CustomerRequest;
import com.gini.customer.external.interfaces.CustomerService;
import com.gini.customer.external.interfaces.dto.CustomerResponse;
import com.gini.customer.internal.domain.entities.Customer;
import com.gini.customer.internal.domain.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void createCustomer(CustomerRequest customerRequest) {
        var customer = new Customer();
        customer.setName(customerRequest.getName());
        customerRepository.save(customer);
    }

    @Override
    public CustomerResponse findById(Long customerId) {

        return customerRepository
                .findById(customerId)
                .map(customer -> new CustomerResponse(customer.getId(), customer.getName()))
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
