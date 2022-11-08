package com.jinnyjinnyjinjin.chart.storage.domain.stock.repository;

import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
