package com.modules.bcncgroup.adapters.inbound.ui.ui.response;

import com.modules.bcncgroup.core.domain.entities.Price;

import java.time.LocalDateTime;

public record PriceResponse(Integer productId, Integer brandId, Double price, LocalDateTime startDate, LocalDateTime endDate) {

    public static PriceResponse parseToResponse(Price price) {
        return new PriceResponse(
                price.getProduct().getId(),
                price.getBrand().getId(),
                price.getPrice(),
                price.getStartDate(),
                price.getEndDate()
        );
    }

}
