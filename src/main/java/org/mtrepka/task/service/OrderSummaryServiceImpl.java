package org.mtrepka.task.service;

import lombok.AllArgsConstructor;
import org.mtrepka.task.dao.OrderSummaryDAO;
import org.mtrepka.task.entity.OrderSummary;
import org.mtrepka.task.repository.OrderSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderSummaryServiceImpl implements OrderSummaryService{
    private final OrderSummaryRepository repository;

    @Override
    public OrderSummary getById(long id) {
        return OrderSummaryDAO.toOrderSummary(repository.getById(id));
    }

    @Override
    public void save(OrderSummary orderSummary) {
        OrderSummaryDAO dao = OrderSummaryDAO.toOrderSummaryDAO(orderSummary);
        repository.save(dao);
        orderSummary.setId(dao.getId());
    }

    @Override
    public List<OrderSummary> getAll() {
        List<OrderSummaryDAO> list = repository.findAll();
        return list.stream().map(OrderSummaryDAO::toOrderSummary).collect(Collectors.toList());
    }
}
