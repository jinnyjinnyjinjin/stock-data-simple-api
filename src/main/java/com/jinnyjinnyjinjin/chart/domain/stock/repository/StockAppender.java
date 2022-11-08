package com.jinnyjinnyjinjin.chart.domain.stock.repository;

import com.jinnyjinnyjinjin.chart.domain.stock.entity.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class StockAppender {

    private final StockRepository stockRepository;

    public Long append(StockEntity entity) {
        return stockRepository.save(entity).getId();
    }
}
