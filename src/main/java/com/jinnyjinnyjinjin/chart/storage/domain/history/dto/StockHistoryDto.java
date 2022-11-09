package com.jinnyjinnyjinjin.chart.storage.domain.history.dto;

import com.jinnyjinnyjinjin.chart.app.service.history.dto.StockDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
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
