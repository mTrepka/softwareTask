package org.mtrepka.task.repository;

import org.mtrepka.task.dao.OrderSummaryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummaryDAO,Long> {
}
