package com.jinnyjinnyjinjin.chart.storage.domain.history.repository;

import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    List<HistoryEntity> findTop5ByStock_idOrderByTimestampDesc(Long stockId);
}
