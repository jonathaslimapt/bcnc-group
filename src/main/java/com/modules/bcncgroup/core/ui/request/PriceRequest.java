package com.modules.bcncgroup.core.ui.request;

import java.time.LocalDateTime;

public record PriceRequest(LocalDateTime now, Integer productId, Integer brandId) {
}
