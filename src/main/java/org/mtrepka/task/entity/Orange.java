package org.mtrepka.task.entity;

public class Orange extends Fruit{
    public Orange(long amount) {
        super(amount);
    }

    @Override
    public double getPrice() {
        return 0.25;
    }
}
