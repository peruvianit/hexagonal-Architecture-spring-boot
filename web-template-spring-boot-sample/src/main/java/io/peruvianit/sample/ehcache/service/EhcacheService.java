package io.peruvianit.sample.ehcache.service;

import java.math.BigDecimal;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheService {
	@Cacheable(value = "squareCache", key = "#number")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number)
          .multiply(BigDecimal.valueOf(number));
        return square;
    }
}
