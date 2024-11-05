package org.example.springbackend.services;

import org.example.springbackend.domain.Order;
import org.example.springbackend.domain.Status;
import org.example.springbackend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record OrderService(OrderRepository repository) {

    public List<Order> getOrderWithStatusInProgress() {
        return repository.getAllByStatus(Status.IN_PROGRESS);
    }

    public List<Order> getOrderWithStatusReady() {
        return repository.getAllByStatus(Status.READY);
    }

    public List<Order> getOrderWithStatusFinished() {
        return repository.getAllByStatus(Status.FINISHED);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order updateStatus(Order order) {
        order.setStatus(Status.READY);
        return repository.save(order);
    }
}
