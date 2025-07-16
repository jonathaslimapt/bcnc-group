package com.modules.bcncgroup.ports.outbound;

import com.modules.bcncgroup.core.repository.entities.Price;
import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;

import java.util.concurrent.CompletableFuture;

public interface RetrievePriceOutboundPort {

    PriceResponse retrievePrice(PriceRequest price);
}
