package org.example.springbackend.api;

import org.example.springbackend.domain.Order;
import org.example.springbackend.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
