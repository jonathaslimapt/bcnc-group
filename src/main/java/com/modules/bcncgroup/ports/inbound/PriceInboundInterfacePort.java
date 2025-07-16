package com.modules.bcncgroup.ports.inbound;

import com.modules.bcncgroup.core.exception.ItemNotFoundException;
import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

public interface PriceInboundInterfacePort {

    PriceResponse getPrice(PriceRequest request) throws ItemNotFoundException;
}
