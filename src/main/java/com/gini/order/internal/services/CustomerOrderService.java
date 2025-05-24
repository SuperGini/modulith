package com.gini.order.internal.services;

import com.gini.generated.car.model.OrderRequest;
import com.gini.generated.car.model.OrderResponse;
import com.gini.order.internal.domain.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {






        return new OrderResponse();

    }


}
