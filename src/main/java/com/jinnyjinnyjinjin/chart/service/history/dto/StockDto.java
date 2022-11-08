package com.jinnyjinnyjinjin.chart.service.history.dto;

import com.jinnyjinnyjinjin.chart.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.domain.history.dto.HistoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
public class StockDto {

    private Long id;

    private String name;

    private List<HistoryDto> history;

    public static StockDto of(StockEntity entity) {

        List<HistoryDto> history = entity.getHistory().stream()
                .map(HistoryDto::of)
                .collect(toList());

        return new StockDto(
                entity.getId(),
                entity.getName(),
                history
        );
    }
}
