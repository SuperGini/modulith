package com.gini.order.external;

import com.gini.generated.car.api.OrderApi;
import com.gini.generated.car.model.GetOrderResponse;
import com.gini.generated.car.model.OrderRequest;
import com.gini.generated.car.model.OrderResponse;
import com.gini.order.internal.services.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return List.of();
    }
}
