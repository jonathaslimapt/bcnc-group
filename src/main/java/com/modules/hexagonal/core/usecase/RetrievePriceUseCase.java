package com.modules.hexagonal.core.usecase;

import com.modules.hexagonal.adapters.outbound.RetrievePriceOutboundAdapter;
import com.modules.hexagonal.core.domain.exception.ItemNotFoundException;
import com.modules.hexagonal.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.hexagonal.adapters.inbound.ui.ui.response.PriceResponse;
import com.modules.hexagonal.ports.inbound.PriceInboundInterfacePort;
import org.springframework.stereotype.Service;

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
