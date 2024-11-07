package org.example.springbackend.services;

import org.example.springbackend.domain.Order;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record WebSocketService(SimpMessagingTemplate messagingTemplate) {

    public void sendOrdersToClients(List<Order> orders) {
        messagingTemplate.convertAndSend("/api/orders", orders);
    }

}
