package com.jinnyjinnyjinjin.chart.app.service.history.dto;

import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
