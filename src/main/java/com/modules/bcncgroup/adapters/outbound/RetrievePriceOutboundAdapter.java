package com.modules.bcncgroup.adapters.outbound;

import com.modules.bcncgroup.core.domain.exception.ItemNotFoundException;
import com.modules.bcncgroup.adapters.outbound.repository.PriceRepository;
import com.modules.bcncgroup.core.domain.entities.Price;
import com.modules.bcncgroup.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.bcncgroup.adapters.inbound.ui.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.outbound.RetrievePriceOutboundPort;

import org.springframework.stereotype.Service;


@Service
public class RetrievePriceOutboundAdapter implements RetrievePriceOutboundPort {

    private final PriceRepository priceRepository;

    public RetrievePriceOutboundAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse retrievePrice(PriceRequest priceRequest) {

            Price price = priceRepository
                    .findPriceByParams(priceRequest.productId(), priceRequest.brandId(), PriceRequest.parseDateTime(priceRequest.date()))
                    .orElseThrow(() -> new ItemNotFoundException("Price not found"));

            return PriceResponse.parseToResponse(price);

    }
}
