package org.example.springbackend.repositories;

import org.example.springbackend.domain.ProductEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntryRepository extends JpaRepository<ProductEntry, Long> {
}
