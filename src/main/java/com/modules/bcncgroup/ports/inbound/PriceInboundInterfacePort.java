package com.modules.bcncgroup.ports.inbound;

import com.modules.bcncgroup.core.domain.exception.ItemNotFoundException;
import com.modules.bcncgroup.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.bcncgroup.adapters.inbound.ui.ui.response.PriceResponse;

public interface PriceInboundInterfacePort {

    PriceResponse getPrice(PriceRequest request) throws ItemNotFoundException;
}
