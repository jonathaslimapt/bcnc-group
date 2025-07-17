package com.modules.bcncgroup.adapters.inbound.ui;

import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.inbound.PriceInboundInterfacePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceRestController {

    private final PriceInboundInterfacePort priceInboundInterfacePort;

    public PriceRestController(PriceInboundInterfacePort priceInboundInterfacePort) {
        this.priceInboundInterfacePort = priceInboundInterfacePort;
    }

    @GetMapping
    @Operation(summary = "Get price by params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price found"),
            @ApiResponse(responseCode = "204", description = "Price not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public PriceResponse getPrice(
           @ModelAttribute @Parameter(description = "Query parameters for price search") PriceRequest request
    ) {

        return priceInboundInterfacePort.getPrice(request);
    }
}
