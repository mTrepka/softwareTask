package org.mtrepka.task.controller;


import org.mtrepka.task.entity.OrderSummary;
import org.mtrepka.task.factory.FruitFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class Rest {


    @PostMapping("/api/order")
    OrderSummary postOrder(@RequestBody Map<String,Integer> order) {
        OrderSummary summary = new OrderSummary();
        order.forEach((key, value) -> summary.getFruitList().add(FruitFactory.getFruit(key, value)));
        return summary;
    }
}
