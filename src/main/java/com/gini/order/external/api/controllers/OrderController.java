package com.gini.order.external.api.controllers;

import com.gini.order.external.api.generated.api.OrderApi;
import com.gini.order.external.api.generated.model.GetOrderResponse;
import com.gini.order.external.api.generated.model.OrderRequest;
import com.gini.order.external.api.generated.model.OrderResponse;
import com.gini.order.internal.services.CustomerOrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final CustomerOrderService customerOrderService;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        return customerOrderService.createOrder(orderRequest);
    }

    @Override
    public List<GetOrderResponse> getAllOrders(Long customerId) {
        return customerOrderService.getOrder(customerId);
    }
}
