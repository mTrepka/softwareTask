package org.mtrepka.task.entity;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class OrderSummary {
    List<Fruit> fruitList = new LinkedList<>();


    public double getOrderValue() {
        return fruitList.stream().mapToDouble(Fruit::getValue).sum();
    }
}
