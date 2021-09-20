package org.mtrepka.task.entity;

public class Orange extends Fruit{
    public Orange(long amount) {
        super(amount);
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public double getValue() {
        return getPrice()*((amount-amount%3)/3*2+amount%3);
    }
}
