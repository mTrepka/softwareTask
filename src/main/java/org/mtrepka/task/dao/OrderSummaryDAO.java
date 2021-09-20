package org.mtrepka.task.dao;

import lombok.Data;
import org.mtrepka.task.entity.Fruit;
import org.mtrepka.task.entity.OrderSummary;
import org.mtrepka.task.factory.FruitFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class OrderSummaryDAO {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FruitDAO> fruitDAOList = new LinkedList<>();


    public static OrderSummary toOrderSummary(OrderSummaryDAO dao) {
        OrderSummary summary = new OrderSummary();
        dao.getFruitDAOList().forEach(e -> summary.getFruitList().add(FruitFactory.getFruit(e.getName(), e.getAmount())));
        summary.setId(dao.getId());
        return summary;
    }
    public static OrderSummaryDAO toOrderSummaryDAO(OrderSummary summary) {
        OrderSummaryDAO dao = new OrderSummaryDAO();
        for (Fruit fruit : summary.getFruitList()) {
            FruitDAO fDao = new FruitDAO();
            fDao.setAmount(fruit.getAmount());
            fDao.setName(fruit.getName());
            dao.fruitDAOList.add(fDao);
        }
        dao.setId(summary.getId());
        return dao;
    }
}
