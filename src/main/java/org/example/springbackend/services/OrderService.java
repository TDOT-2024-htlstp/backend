package org.example.springbackend.services;

import org.example.springbackend.domain.Order;
import org.example.springbackend.domain.Status;
import org.example.springbackend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
