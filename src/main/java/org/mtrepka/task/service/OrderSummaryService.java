package org.mtrepka.task.service;

import org.mtrepka.task.entity.OrderSummary;

import java.util.List;

public interface OrderSummaryService {
    void save(OrderSummary orderSummary);
    OrderSummary getById(long id);

    List<OrderSummary> getAll();
}
