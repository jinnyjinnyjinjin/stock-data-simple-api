package com.jinnyjinnyjinjin.chart.service.client.response;

import com.jinnyjinnyjinjin.chart.domain.history.dto.HistoryDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class ExternalResponse {

    private ChartResponse chart;

    public List<HistoryDto> toDto() {

        List<QuoteResponse> quote = chart.getIndicators().getQuote();
        List<Date> timestampList = chart.getTimestamp();

        List<HistoryDto> historyDto = new ArrayList<>();
        IntStream.range(0, timestampList.size()).forEach(i -> {
            HistoryDto dto = new HistoryDto(
                    quote.get(i).getVolume().get(i),
                    quote.get(i).getOpen().get(i),
                    quote.get(i).getLow().get(i),
                    quote.get(i).getHigh().get(i),
                    quote.get(i).getClose().get(i),
                    timestampList.get(i)
            );
            historyDto.add(dto);
        });

        return historyDto;
    }
}
