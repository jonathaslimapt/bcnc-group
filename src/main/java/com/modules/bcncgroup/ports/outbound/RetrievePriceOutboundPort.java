package com.modules.bcncgroup.ports.outbound;

import com.modules.bcncgroup.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.bcncgroup.adapters.inbound.ui.ui.response.PriceResponse;

public interface RetrievePriceOutboundPort {

    PriceResponse retrievePrice(PriceRequest price);
}
