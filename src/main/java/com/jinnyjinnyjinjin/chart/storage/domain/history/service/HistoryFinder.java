package com.jinnyjinnyjinjin.chart.storage.domain.history.service;

import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.StockHistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.history.repository.HistoryReader;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.repository.StockReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HistoryFinder {

    private final HistoryReader historyReader;
    private final StockReader stockReader;

    public StockHistoryDto findTop5RecentHistory(Long stockId) {
        StockEntity stock = stockReader.read(stockId);
        List<HistoryEntity> entities = historyReader.readTop5ByStock_idOrderByTimestampDesc(stockId);
        return StockHistoryDto.of(stock, entities);
    }
}
