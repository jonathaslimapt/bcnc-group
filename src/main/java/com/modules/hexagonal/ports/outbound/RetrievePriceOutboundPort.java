package com.modules.hexagonal.ports.outbound;

import com.modules.hexagonal.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.hexagonal.adapters.inbound.ui.ui.response.PriceResponse;

public interface RetrievePriceOutboundPort {

    PriceResponse retrievePrice(PriceRequest price);
}
