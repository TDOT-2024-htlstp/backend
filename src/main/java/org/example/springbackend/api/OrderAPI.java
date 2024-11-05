package org.example.springbackend.api;

import org.example.springbackend.domain.Order;
import org.example.springbackend.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public record OrderAPI(OrderService orderService) {

    // get in progress orders
    @GetMapping("in_progress")
    private List<Order> getOrderWithStatusInProgress() {
        return orderService.getOrderWithStatusInProgress();
    }

    // get ready orders
    @GetMapping("ready")
    private List<Order> getOrderWithStatusReady() {
        return orderService.getOrderWithStatusReady();
    }

    // get finished orders
    @GetMapping("finished")
    private List<Order> getOrderWithStatusFinished() {
        return orderService.getOrderWithStatusFinished();
    }

    @GetMapping("")
    private List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("{id}")
    private Order updateStatus(@PathVariable UUID id, @RequestBody Order order) {
        return orderService.updateStatus(id, order);
    }

}
