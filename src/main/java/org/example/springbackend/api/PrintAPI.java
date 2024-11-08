package org.example.springbackend.api;

import org.example.springbackend.domain.Order;
import org.example.springbackend.services.WebSocketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/print")
@CrossOrigin(origins = "*")
public record PrintAPI(WebSocketService webSocketService) {

    @PostMapping()
    public Order print(@RequestBody Order order) {
        webSocketService.sendOrderToClients(order);

        return order;
    }

}
