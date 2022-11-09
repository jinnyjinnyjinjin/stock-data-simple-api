package com.jinnyjinnyjinjin.chart.app.service.client;

import com.jinnyjinnyjinjin.chart.app.service.client.response.BodyResponse;
import com.jinnyjinnyjinjin.chart.app.service.client.response.ExternalResponse;
import com.jinnyjinnyjinjin.chart.app.service.client.response.QuoteResponse;
import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.HistoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
@RequiredArgsConstructor
public class HistoryClientServer {

    @Value("${external.host}")
    private String host;

    @Value("${external.path}")
    private String path;

    private final RestTemplate restTemplate;

    public List<HistoryDto> getData() {
        ExternalResponse externalResponse = callChartHistory();
        return parseToDto(externalResponse);
    }

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

    private List<HistoryDto> parseToDto(ExternalResponse response) {
        List<BodyResponse> bodyResponses = response.getChart().getResult();

        List<Long> timestampList = bodyResponses.stream()
                .flatMap(data -> data.getTimestamp().stream())
                .collect(toList());

        List<QuoteResponse> quoteResponses = bodyResponses.stream()
                .flatMap(data -> data.getIndicators().getQuote().stream())
                .map(quote -> new QuoteResponse(
                        quote.getVolume(),
                        quote.getOpen(),
                        quote.getLow(),
                        quote.getHigh(),
                        quote.getClose()))
                .collect(toList());

        List<HistoryDto> historyDtoList = new ArrayList<>();
        quoteResponses.forEach(data -> {
            int bound = timestampList.size();
            IntStream.range(0, bound)
                    .mapToObj(i -> new HistoryDto(
                            data.getVolume().get(i),
                            data.getOpen().get(i),
                            data.getLow().get(i),
                            data.getHigh().get(i),
                            data.getClose().get(i),
                            convertDatetime(timestampList.get(i))
                    )).forEach(historyDtoList::add);
        });

        return historyDtoList;

    }

    private LocalDateTime convertDatetime(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone.getDefault().toZoneId());
    }
}
