package com.jinnyjinnyjinjin.chart.storage.domain.history.service;

import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.history.repository.HistoryAppender;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.repository.StockReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HistoryCreator {

    private final HistoryAppender historyAppender;
    private final StockReader stockReader;

    public void createBatch(Long stockId, List<HistoryDto> history) {
        StockEntity stock = stockReader.read(stockId);
        List<HistoryEntity> entities = new ArrayList<>();
        history.forEach(data -> {
            HistoryEntity historyEntity = HistoryEntity.create(
                    stock,
                    data.getLow(),
                    data.getOpen(),
                    data.getClose(),
                    data.getVolume(),
                    data.getHigh(),
                    data.getTimestamp()
            );
            entities.add(historyEntity);
        });
        historyAppender.appendAll(entities);

    }
}
