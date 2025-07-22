package com.modules.hexagonal;

import com.modules.hexagonal.adapters.outbound.RetrievePriceOutboundAdapter;
import com.modules.hexagonal.adapters.outbound.repository.PriceRepository;
import com.modules.hexagonal.adapters.inbound.ui.ui.request.PriceRequest;
import com.modules.hexagonal.core.usecase.RetrievePriceUseCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.web.servlet.MockMvc;

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
    void testGetPrice(String now, Integer productId, Integer brandId) throws Exception {


        PriceRequest priceRequest = new PriceRequest(now, productId, brandId);

        mockMvc.perform(get("/prices")
                        .param("date", priceRequest.date().toString())
                        .param("productId", priceRequest.productId().toString())
                        .param("brandId", priceRequest.brandId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").isNotEmpty());
    }

    static Stream<Arguments> priceRequestProvider() {
        return Stream.of(
                Arguments.of(
                        "2020-06-14 14:00:00",
                        35455, 1
                ),
                Arguments.of(
                        "2020-06-14 16:00:00",
                        35455, 1
                ),
                Arguments.of(
               "2020-06-14 21:00:00",
                        35455, 1
                )
                ,
                Arguments.of(
                        "2020-06-15 15:00:00",
                        35455, 1
                ),
                Arguments.of(
                       "2020-06-16 21:00:00",
                        35455, 1
                )

        );
    }
}
