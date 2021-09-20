package org.mtrepka.task.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FruitDAO {
    @Id
    @GeneratedValue
    private long id;
    private long amount;
    private String name;
}
