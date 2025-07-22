package com.modules.hexagonal;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
@EnableJpaRepositories
public class BcncGroupApplication implements CommandLineRunner {

    private final JdbcClient jdbcClient;

    public BcncGroupApplication(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    private final String INSERT_BRAND = """
            
            INSERT INTO BRAND (ID, NAME) VALUES (1, 'ZARA');
            
            """;

    private final String INSERT_PRICE_LIST = """
            
            INSERT INTO PRICE_LIST (ID, DESCRIPTION) VALUES (1, 'SUMMER LIST');
            INSERT INTO PRICE_LIST (ID, DESCRIPTION) VALUES (2, 'WINTER LIST');
            INSERT INTO PRICE_LIST (ID, DESCRIPTION) VALUES (3, 'SPRING LIST');
            INSERT INTO PRICE_LIST (ID, DESCRIPTION) VALUES (4, 'AUTUMN LIST');
            
            """;

    private final String INSERT_PRODUCT = """
            
            INSERT INTO PRODUCT (ID, PRODUCT_NAME) VALUES (35455, 'BASIC WHITE T-SHIRT');
            
            """;

    private final String INSERT_PRICE = """
            
            INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
            (1, 1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR'),
            (2, 1, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR'),
            (3, 1, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR'),
            (4, 1, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');
            
            """;

    @Override
    public void run(String... args) throws Exception {
        jdbcClient.sql(INSERT_BRAND).update();
        jdbcClient.sql(INSERT_PRICE_LIST).update();
        jdbcClient.sql(INSERT_PRODUCT).update();
        jdbcClient.sql(INSERT_PRICE).update();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Price API")
                        .version("1.0")
                        .description("API to search prices according product, brand and date."));
    }

    public static void main(String[] args) {
        SpringApplication.run(BcncGroupApplication.class, args);
    }

}
