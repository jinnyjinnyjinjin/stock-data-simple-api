package com.jinnyjinnyjinjin.chart.service.stock;

import com.jinnyjinnyjinjin.chart.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.domain.stock.repository.StockRepository;
import com.jinnyjinnyjinjin.chart.exception.stock.StockNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockReader {

    private final StockRepository stockRepository;

    public StockEntity read(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("해당 주식을 찾을 수 없습니다.", id));
    }
}
