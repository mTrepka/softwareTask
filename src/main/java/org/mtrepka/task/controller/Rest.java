package org.mtrepka.task.controller;


import lombok.AllArgsConstructor;
import org.mtrepka.task.entity.OrderSummary;
import org.mtrepka.task.factory.FruitFactory;
import org.mtrepka.task.service.OrderSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class Rest {
    private final OrderSummaryService orderSummaryService;

    @PostMapping("/api/order")
    public OrderSummary postOrder(@RequestBody Map<String,Integer> order) {
        OrderSummary summary = new OrderSummary();
        order.forEach((key, value) -> summary.getFruitList().add(FruitFactory.getFruit(key, value)));
        orderSummaryService.save(summary);
        return summary;
    }

    @GetMapping("/api/order")
    public OrderSummary getOrder(@RequestParam long id) {
        return orderSummaryService.getById(id);
    }

    @GetMapping("/api/order/all")
    public List<OrderSummary> getAllOrders() {
        return orderSummaryService.getAll();
    }
}
