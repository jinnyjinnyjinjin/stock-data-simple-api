package com.jinnyjinnyjinjin.chart.service.stock;

import com.jinnyjinnyjinjin.chart.service.history.dto.StockDto;
import com.jinnyjinnyjinjin.chart.domain.stock.entity.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockFinder {

    private final StockReader stockReader;

    public StockDto find(Long id) {
        StockEntity entity = stockReader.read(id);
        return StockDto.of(entity);
    }
}
