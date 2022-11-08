package com.jinnyjinnyjinjin.chart.service.stock;

import com.jinnyjinnyjinjin.chart.service.history.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockFinder stockFinder;
    private final StockCreator stockCreator;

    public Long create(String name) {
        return stockCreator.create(name);
    }

    public StockDto get(Long id) {
        return stockFinder.find(id);
    }
}
