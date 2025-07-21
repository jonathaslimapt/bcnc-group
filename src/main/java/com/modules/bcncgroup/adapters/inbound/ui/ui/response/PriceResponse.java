package com.modules.bcncgroup.adapters.inbound.ui.ui.response;

import java.time.LocalDateTime;

public record PriceResponse(Integer productId, Integer brandId, Double price, LocalDateTime startDate, LocalDateTime endDate) {
}
