package com.modules.bcncgroup;

import com.modules.bcncgroup.adapters.outbound.RetrievePriceOutboundAdapter;
import com.modules.bcncgroup.core.repository.PriceRepository;
import com.modules.bcncgroup.core.ui.request.PriceRequest;
import com.modules.bcncgroup.core.ui.response.PriceResponse;
import com.modules.bcncgroup.core.usecase.RetrievePriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private RetrievePriceUseCase retrievePriceUseCase;

    @Mock
    private RetrievePriceOutboundAdapter retrievePriceOutboundAdapter;

    @Mock
    private JdbcClient jdbcClient;

    @Mock
    private PriceRepository priceRepository;

    @ParameterizedTest
    @MethodSource("priceRequestProvider")
    void testGetPrice(LocalDateTime now, Integer productId, Integer brandId) throws Exception {


        PriceRequest priceRequest = new PriceRequest(now, productId, brandId);

        mockMvc.perform(get("/prices")
                        .param("now", priceRequest.now().toString())
                        .param("productId", priceRequest.productId().toString())
                        .param("brandId", priceRequest.brandId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").isNotEmpty());
    }

    static Stream<Arguments> priceRequestProvider() {
        return Stream.of(
                Arguments.of(
                        LocalDateTime.of(2020, 6, 14, 10, 0),
                        1, 1
                ),
                Arguments.of(
                        LocalDateTime.of(2020, 6, 14, 16, 0),
                        1, 1
                ),
                Arguments.of(
                        LocalDateTime.of(2020, 6, 14, 21, 0),
                        1, 1
                )
                ,
                Arguments.of(
                        LocalDateTime.of(2020, 6, 15, 10, 0),
                        1, 1
                ),
                Arguments.of(
                        LocalDateTime.of(2020, 6, 16, 21, 0),
                        1, 1
                )

        );
    }
}
