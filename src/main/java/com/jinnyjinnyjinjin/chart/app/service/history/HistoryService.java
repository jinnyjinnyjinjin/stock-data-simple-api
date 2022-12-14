package com.jinnyjinnyjinjin.chart.app.service.history;

import com.jinnyjinnyjinjin.chart.storage.domain.history.service.HistoryCreator;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.serivce.StockCreator;
import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.StockHistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.service.HistoryFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryCreator historyCreator;
    private final StockCreator stockCreator;
    private final HistoryFinder historyFinder;

    @Transactional
    public StockHistoryDto createBatch(List<HistoryDto> dtoList) {
        Long stockId = stockCreator.create("삼성전자");
        historyCreator.createBatch(stockId, dtoList);
        return historyFinder.findTop5RecentHistory(stockId);
    }
}
