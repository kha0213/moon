package com.yl.moon.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class CoinApiController {
    private final CoinApiService coinApiService;

    @GetMapping("/coin")
    public Mono<String> getCoinInfo() {
        return coinApiService.getCurrent();
    }
}
