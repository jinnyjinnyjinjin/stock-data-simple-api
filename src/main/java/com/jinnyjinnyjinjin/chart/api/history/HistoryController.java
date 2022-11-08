package com.jinnyjinnyjinjin.chart.api.history;

import com.jinnyjinnyjinjin.chart.common.ApiResponse;
import com.jinnyjinnyjinjin.chart.domain.history.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.domain.history.dto.StockHistoryDto;
import com.jinnyjinnyjinjin.chart.service.client.HistoryClientServer;
import com.jinnyjinnyjinjin.chart.service.history.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/history")
public class HistoryController {

    private final HistoryClientServer historyClientServer;
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll() {
        List<HistoryDto> historyDtoList = historyClientServer.getData();
        StockHistoryDto result = historyService.createBatch(historyDtoList);
        return new ResponseEntity<>(new ApiResponse(true, result), HttpStatus.OK);
    }
}
