package com.gini.order.internal.domain.repositories;

import com.gini.order.internal.domain.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {


}
