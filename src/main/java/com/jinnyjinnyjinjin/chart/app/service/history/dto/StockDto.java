package com.jinnyjinnyjinjin.chart.app.service.history.dto;

import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StockDto {

    private Long id;
    private String name;

    public static StockDto of(StockEntity entity) {
        return new StockDto(
                entity.getId(),
                entity.getName()
        );
    }
}
