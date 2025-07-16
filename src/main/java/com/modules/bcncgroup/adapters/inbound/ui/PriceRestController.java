package com.modules.bcncgroup.adapters.inbound.ui;

import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.inbound.PriceInboundInterfacePort;
import org.springframework.format.annotation.DateTimeFormat;
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
    public PriceResponse getPrice(
            @RequestParam("now") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId
    ) {
        var request = new PriceRequest(date, productId, brandId);
        return priceInboundInterfacePort.getPrice(request);
    }
}
