package com.modules.bcncgroup.core.usecase;

import com.modules.bcncgroup.adapters.outbound.RetrievePriceOutboundAdapter;
import com.modules.bcncgroup.core.domain.exception.ItemNotFoundException;
import com.modules.bcncgroup.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.bcncgroup.adapters.inbound.ui.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.inbound.PriceInboundInterfacePort;
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
