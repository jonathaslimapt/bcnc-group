package com.modules.bcncgroup.core.usecase;

import com.modules.bcncgroup.adapters.outbound.RetrievePriceOutboundAdapter;
import com.modules.bcncgroup.core.exception.ItemNotFoundException;
import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.inbound.PriceInboundInterfacePort;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RetrievePriceUseCase implements PriceInboundInterfacePort {


    private final RetrievePriceOutboundAdapter retrievePriceOutboundAdapter;

    public RetrievePriceUseCase(RetrievePriceOutboundAdapter retrievePriceOutboundAdapter) {
        this.retrievePriceOutboundAdapter = retrievePriceOutboundAdapter;
    }

    @Override
    public PriceResponse getPrice(PriceRequest request) throws ItemNotFoundException {
        return retrievePriceOutboundAdapter.retrievePrice(request);
    }


}
