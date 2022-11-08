package com.jinnyjinnyjinjin.chart.service.history;

import com.jinnyjinnyjinjin.chart.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.service.history.HistoryCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryCreator historyCreator;

    public void create(Long stockId, List<HistoryDto> dtoList) {
        historyCreator.createBatch(stockId, dtoList);
    }
}
