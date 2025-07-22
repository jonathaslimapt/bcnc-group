package com.modules.hexagonal.ports.inbound;

import com.modules.hexagonal.core.domain.exception.ItemNotFoundException;
import com.modules.hexagonal.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.hexagonal.adapters.inbound.ui.ui.response.PriceResponse;

public interface PriceInboundInterfacePort {

    PriceResponse getPrice(PriceRequest request) throws ItemNotFoundException;
}
