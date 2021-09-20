package org.mtrepka.task.entity;

public class Apple extends Fruit{
    public Apple(long amount) {
        super(amount);
    }

    @Override
    public double getPrice() {
        return 0.6;
    }
}
