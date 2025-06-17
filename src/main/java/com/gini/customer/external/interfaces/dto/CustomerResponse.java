package com.gini.customer.external.interfaces.dto;

import org.springframework.modulith.NamedInterface;

@NamedInterface("customerResponse")
public record CustomerResponse(Long id, String name) {}
