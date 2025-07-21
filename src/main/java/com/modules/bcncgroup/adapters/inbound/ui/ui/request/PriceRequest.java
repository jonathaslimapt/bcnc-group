package com.modules.bcncgroup.adapters.inbound.ui.ui.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record PriceRequest(
        @NotNull(message = "date is required")
        @Pattern(
                regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$",
                message = "Date must be in format yyyy-MM-dd HH:mm:ss"
        )
        @Schema(description = "Date and time in 'yyyy-MM-dd HH:mm:ss' format", example = "2025-07-17 14:00:00")
        String date,

        @NotNull(message = "productId is required")
        @Min(value = 1, message = "productId must be a positive number")
        @Schema(description = "ID of the product", example = "35455")
        Integer productId,

        @NotNull(message = "brandId is required")
        @Min(value = 1, message = "brandId must be a positive number")
        @Schema(description = "ID of the brand", example = "1")
        Integer brandId
) {
}
