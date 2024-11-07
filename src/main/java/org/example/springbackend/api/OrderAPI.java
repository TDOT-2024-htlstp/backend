package org.example.springbackend.api;

import org.example.springbackend.domain.Order;
import org.example.springbackend.services.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
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

    @PostMapping("/process")
    public Order processOrder(@RequestBody Order order) {
        orderService.processOrder(order);
        return orderService.saveOrder(order);
    }

    @PutMapping("{id}")
    private Order updateStatus(@PathVariable UUID id) {
        orderService.nextStatus(id);
        return orderService.getOrderById(id).orElseThrow();
    }

}
