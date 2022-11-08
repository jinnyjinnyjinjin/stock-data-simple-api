package com.jinnyjinnyjinjin.chart.storage.domain.history.repository;

import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class HistoryAppender {

    private final HistoryRepository historyRepository;

    public void appendAll(List<HistoryEntity> entities) {
        historyRepository.saveAll(entities);
    }
}
