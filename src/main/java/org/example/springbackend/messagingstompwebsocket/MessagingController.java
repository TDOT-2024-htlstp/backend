package org.example.springbackend.messagingstompwebsocket;

import org.example.springbackend.domain.Order;
import org.example.springbackend.domain.messages.Greeting;
import org.example.springbackend.domain.messages.HelloMessage;
import org.example.springbackend.services.OrderService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public record MessagingController(OrderService orderService) {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public List<Order> greeting(HelloMessage message) throws Exception {
////        Thread.sleep(1000); // simulated delay
//        return orderService.getAllOrders();
////        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//    }
}
