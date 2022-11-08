package com.jinnyjinnyjinjin.chart.storage.domain.stock.serivce;

import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.repository.StockAppender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockCreator {

    private final StockAppender stockAppender;

    public Long create(String name) {
        StockEntity entity = new StockEntity(name);
        return stockAppender.append(entity);
    }
}
