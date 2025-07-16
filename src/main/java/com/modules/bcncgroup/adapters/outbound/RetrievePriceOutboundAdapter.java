package com.modules.bcncgroup.adapters.outbound;

import com.modules.bcncgroup.core.exception.ItemNotFoundException;
import com.modules.bcncgroup.core.repository.PriceRepository;
import com.modules.bcncgroup.core.repository.entities.Price;
import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
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
                    .findPriceByParams(priceRequest.productId(), priceRequest.brandId(), priceRequest.now())
                    .orElseThrow(() -> new ItemNotFoundException("Price not found"));

            return new PriceResponse(
                    price.getProduct().getId(),
                    price.getBrand().getId(),
                    price.getPrice(),
                    price.getStartDate(),
                    price.getEndDate()
            );

    }
}
