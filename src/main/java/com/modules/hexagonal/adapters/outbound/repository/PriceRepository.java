package com.modules.hexagonal.adapters.outbound.repository;

import com.modules.hexagonal.core.domain.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query("""
        SELECT p FROM Price p
        WHERE p.product.id = :productId
          AND p.brand.id = :brandId
          AND :date BETWEEN p.startDate AND p.endDate
        ORDER BY p.priority DESC
        LIMIT 1
    """)
    Optional<Price> findPriceByParams(@Param("productId") Integer productId,
                                      @Param("brandId") Integer brandId,
                                      @Param("date") LocalDateTime date);
}
