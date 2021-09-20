package org.mtrepka.task.entity;


import lombok.Data;

@Data
public abstract class Fruit {
    protected long amount;

    Fruit(long amount) {
        this.amount = amount;
    }

    public abstract double getPrice();

    public double getValue() {
        return amount * getPrice();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
