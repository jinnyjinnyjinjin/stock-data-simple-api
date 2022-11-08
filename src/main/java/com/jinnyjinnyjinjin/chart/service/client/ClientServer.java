package com.jinnyjinnyjinjin.chart.service.client;

import com.jinnyjinnyjinjin.chart.service.client.response.ExternalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;

@Component
@RequiredArgsConstructor
public class ClientServer {

    @Value("${external.host}")
    private String host;

    @Value("${external.path}")
    private String path;

    private final RestTemplate restTemplate;

    @PostConstruct
    public ExternalResponse callChartHistory() {

        URI uri = UriComponentsBuilder.fromHttpUrl(host)
                .path(path)
                .queryParam("interval", "1d")
                .queryParam("range", "5d")
                .encode()
                .build()
                .toUri();

        ResponseEntity<ExternalResponse> response = restTemplate.getForEntity(uri, ExternalResponse.class);

        return response.getBody();
    }
}
