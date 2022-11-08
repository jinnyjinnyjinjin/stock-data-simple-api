package com.jinnyjinnyjinjin.chart.service.history;

import com.jinnyjinnyjinjin.chart.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.domain.history.repository.HistoryAppender;
import com.jinnyjinnyjinjin.chart.service.stock.StockReader;
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
