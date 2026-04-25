package com.ing_hexagonal.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ing_hexagonal.domain.api.IProductoServicePort;
import com.ing_hexagonal.domain.spi.IProductoPersistencePort;
import com.ing_hexagonal.domain.usecase.ProductoUseCase;

@Configuration
public class BeanConfiguration {

    @Bean
    public IProductoServicePort productoServicePort(IProductoPersistencePort productoPersistencePort) {
        return new ProductoUseCase(productoPersistencePort);
    }
}