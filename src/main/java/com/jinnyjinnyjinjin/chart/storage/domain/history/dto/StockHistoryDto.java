package com.jinnyjinnyjinjin.chart.storage.domain.history.dto;

import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.app.service.history.dto.StockDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class StockHistoryDto {
    private StockDto stock;
    private List<HistoryDto> history;

    public static StockHistoryDto of(StockEntity stock, List<HistoryEntity> historyEntities) {

        StockDto stockDto = StockDto.of(stock);
        List<HistoryDto> historyDtoList = historyEntities.stream()
                .map(HistoryDto::of)
                .collect(Collectors.toList());

        return new StockHistoryDto(
                stockDto,
                historyDtoList
        );
    }
}
