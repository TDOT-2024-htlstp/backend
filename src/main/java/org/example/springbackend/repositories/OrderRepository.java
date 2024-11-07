package org.example.springbackend.repositories;

import org.example.springbackend.domain.Order;
import org.example.springbackend.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.status = ?1")
    List<Order> getAllByStatus(Status status);
}