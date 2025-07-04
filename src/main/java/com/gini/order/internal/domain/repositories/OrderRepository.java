package com.gini.order.internal.domain.repositories;

import com.gini.order.internal.domain.entities.CustomerOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query(
            """
            SELECT co FROM CustomerOrder co JOIN FETCH co.parts WHERE co.customerId = :customerId
            """)
    List<CustomerOrder> findByCustomerId(Long customerId);
}
