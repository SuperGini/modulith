package com.gini.order.internal.services;

import com.gini.car_module_openapi.model.GetOrderPartResponse;
import com.gini.car_module_openapi.model.GetOrderResponse;
import com.gini.car_module_openapi.model.OrderPartResponse;
import com.gini.car_module_openapi.model.OrderRequest;
import com.gini.car_module_openapi.model.OrderResponse;
import com.gini.customer.external.interfaces.CustomerService;
import com.gini.customer.external.interfaces.dto.CustomerResponse;
import com.gini.order.internal.domain.entities.CustomerOrder;
import com.gini.order.internal.domain.entities.PartOrder;
import com.gini.order.internal.domain.repositories.OrderRepository;
import com.gini.order.internal.publisher.store.StorePublisher;
import com.gini.store.external.interfaces.PartService;
import com.gini.store.external.listeners.events.OrderPartRequestEvent;
import com.gini.store.external.listeners.events.OrderPartRequestWrapperEvent;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    private final OrderRepository orderRepository;
    private final StorePublisher storePublisher;
    private final CustomerService customerService;
    private final PartService partService;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {

        var customer = customerService.findById(orderRequest.getCustomerId());

        var partsList =
                orderRequest.getParts().stream()
                        .map(
                                part ->
                                        new OrderPartRequestEvent(
                                                part.getPartNumber(), part.getQuantity()))
                        .toList();

        storePublisher.updatePartsInStore(new OrderPartRequestWrapperEvent(partsList));

        var newCustomerOrder = mapToCustomerOrderEntity(orderRequest, customer);
        var customerOrderDb = orderRepository.save(newCustomerOrder);

        var partsListResponse =
                orderRequest.getParts().stream()
                        .map(
                                part ->
                                        new OrderPartResponse(
                                                part.getPartNumber(), part.getQuantity()))
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

        return orderRepository.findByCustomerId(customer.id()).stream()
                .map(
                        customerOrder -> {
                            var partsResponse =
                                    customerOrder.getParts().stream()
                                            .map(
                                                    part ->
                                                            new GetOrderPartResponse()
                                                                    .partNumber(
                                                                            part.getPartNumber())
                                                                    .quantity(part.getQuantity()))
                                            .toList();

                            return new GetOrderResponse()
                                    .parts(partsResponse)
                                    .number(new BigDecimal(customerOrder.getId()))
                                    .customerName(customer.name())
                                    .vin(customerOrder.getVin());
                        })
                .toList();
    }

    private CustomerOrder mapToCustomerOrderEntity(
            OrderRequest orderRequest, CustomerResponse customer) {
        var newCustomerOrder = new CustomerOrder();
        newCustomerOrder.setCustomerId(customer.id());
        newCustomerOrder.setVin(orderRequest.getVin());

        orderRequest
                .getParts()
                .forEach(
                        part -> {
                            var partOrder =
                                    PartOrder.builder()
                                            .partNumber(part.getPartNumber())
                                            .quantity(part.getQuantity())
                                            .build();
                            newCustomerOrder.addPart(partOrder);
                        });
        return newCustomerOrder;
    }
}
