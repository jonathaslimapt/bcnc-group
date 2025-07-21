package com.modules.bcncgroup.adapters.outbound;

import com.modules.bcncgroup.core.domain.exception.ItemNotFoundException;
import com.modules.bcncgroup.adapters.outbound.repository.PriceRepository;
import com.modules.bcncgroup.adapters.outbound.repository.entities.Price;
import com.modules.bcncgroup.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.bcncgroup.adapters.inbound.ui.ui.response.PriceResponse;
import com.modules.bcncgroup.ports.outbound.RetrievePriceOutboundPort;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class RetrievePriceOutboundAdapter implements RetrievePriceOutboundPort {

    private final PriceRepository priceRepository;

    public RetrievePriceOutboundAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse retrievePrice(PriceRequest priceRequest) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(priceRequest.date(), formatter);

            Price price = priceRepository
                    .findPriceByParams(priceRequest.productId(), priceRequest.brandId(), date)
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
