package com.gini.order.internal.services;


import com.gini.customer.external.interfaces.CustomerService;
import com.gini.order.external.api.generated.model.GetOrderPartResponse;
import com.gini.order.external.api.generated.model.GetOrderResponse;
import com.gini.order.external.api.generated.model.OrderPartResponse;
import com.gini.order.external.api.generated.model.OrderRequest;
import com.gini.order.external.api.generated.model.OrderResponse;
import com.gini.order.internal.domain.entities.CustomerOrder;
import com.gini.order.internal.domain.entities.PartOrder;
import com.gini.order.internal.domain.repositories.OrderRepository;
import com.gini.store.external.interfaces.PartService;
import com.gini.store.external.listeners.events.OrderPartRequestEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final CustomerService customerService;
    private final PartService partService;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {

        var customer = customerService.findById(orderRequest.getCustomerId());

        var partsList = orderRequest.getParts().stream()
                .map(part -> new OrderPartRequestEvent(part.getPartNumber(), part.getQuantity()))
                .toList();

        eventPublisher.publishEvent(partsList);


        var partsOrder = orderRequest.getParts().stream()
                .map(part -> PartOrder.builder()
                        .partNumber(part.getPartNumber())
                        .quantity(part.getQuantity())
                        .build()

                )
                .toList();


        var newCustomerOrder = CustomerOrder.builder()
                .customerId(customer.id())
                .vin(orderRequest.getVin())
                .parts(partsOrder)
                .build();

        var customerOrderDb = orderRepository.save(newCustomerOrder);


        var partsListResponse = orderRequest.getParts().stream()
                .map(part -> new OrderPartResponse(part.getPartNumber(), part.getQuantity()))
                .toList();


        return new OrderResponse()
                .parts(partsListResponse)
                .vin(orderRequest.getVin())
                .customerName(customer.name())
                .number(new BigDecimal(customerOrderDb.getId()));
    }

    @Transactional
    public List<GetOrderResponse> getOrder(long customerId) {

        var customer = customerService.findById(customerId);

        return orderRepository.findByCustomerId(customer.id())
                .stream()
                .map(customerOrder -> {
                            var partsResponse = customerOrder.getParts().stream()
                                    .map(part -> new GetOrderPartResponse()
                                            .partNumber(part.getPartNumber())
                                            .quantity(part.getQuantity())
                                    ).toList();

                            return new GetOrderResponse()
                                    .parts(partsResponse)
                                    .number(new BigDecimal(customerOrder.getId()))
                                    .customerName(customer.name())
                                    .vin(customerOrder.getVin());
                        }

                ).toList();

    }


}
