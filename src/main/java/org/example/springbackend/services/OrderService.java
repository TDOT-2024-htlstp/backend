package org.example.springbackend.services;

import org.example.springbackend.domain.Order;
import org.example.springbackend.domain.ProductEntry;
import org.example.springbackend.domain.Status;
import org.example.springbackend.repositories.OrderRepository;
import org.example.springbackend.repositories.ProductEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public record OrderService(OrderRepository repository, WebSocketService webSocketService, ProductService productService, ProductEntryRepository productEntryRepository) {

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

    public Optional<Order> getOrderById(Long id) {
        return repository.findById(id);
    }

    public void nextStatus(UUID uuid) {
        repository.findById(uuid).ifPresent(order -> {
            switch (order.getStatus()) {
                case IN_PROGRESS:
                    order.setStatus(Status.READY);
                    break;
                case READY:
                    order.setStatus(Status.FINISHED);
                    break;
                case FINISHED:
            }

            repository.save(order);
        });

        webSocketService.sendOrdersToClients(getAllOrders());
    }

    public Order saveOrder(Order order) {
        order.setEntries(productEntryRepository.saveAll(order.getEntries()));
        return repository.save(order);
    }

    public void processOrder(Order order) {
        for (ProductEntry entry : order.getEntries()) {
            entry.setProduct(productService.decreaseAmount(entry.getProduct(), entry.getAmount()));
        }
    }
}
