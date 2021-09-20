package org.mtrepka.task.factory;

import org.mtrepka.task.entity.Apple;
import org.mtrepka.task.entity.Fruit;
import org.mtrepka.task.entity.Orange;

public class FruitFactory {
    public static Fruit getFruit(String name, long amount) {
        if(name == null) {
            return null;
        }
        if(name.equalsIgnoreCase("APPLE")) {
            return new Apple(amount);
        } else if(name.equalsIgnoreCase("ORANGE")) {
            return new Orange(amount);
        }
        return null;
    }
}
