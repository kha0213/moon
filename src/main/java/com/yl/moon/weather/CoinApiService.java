package com.yl.moon.weather;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class CoinApiService {

    private final WebClient webClient;

    @Value("${coin.api-key}")
    private String apiKey;

    @Value("${coin.base-url}")
    private String baseUrl;

    private final String CURRENCY = "usd";
    private final String BITCOIN = "bitcoin";

    public CoinApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> getCurrent() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(baseUrl)
                        .queryParam("vs_currency", CURRENCY)
                        .queryParam("ids", BITCOIN)
                        .queryParam("x_cg_demo_api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class); // JSON 그대로 반환
    }
}