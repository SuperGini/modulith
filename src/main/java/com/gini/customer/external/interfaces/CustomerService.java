package com.gini.customer.external.interfaces;

import com.gini.customer.external.interfaces.dto.CustomerResponse;
import org.springframework.modulith.NamedInterface;

@NamedInterface("customerService")
public interface CustomerService {
    CustomerResponse findById(Long customerId);
}
