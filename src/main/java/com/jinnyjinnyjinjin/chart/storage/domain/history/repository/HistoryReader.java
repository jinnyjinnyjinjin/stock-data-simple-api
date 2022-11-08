package com.jinnyjinnyjinjin.chart.storage.domain.history.repository;

import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HistoryReader {

    private final HistoryRepository historyRepository;

    public List<HistoryEntity> readTop5ByStock_idOrderByTimestampDesc(Long stockId) {
        return historyRepository.findTop5ByStock_idOrderByTimestampDesc(stockId);
    }
}
