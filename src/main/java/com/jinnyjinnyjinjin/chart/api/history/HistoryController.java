package com.jinnyjinnyjinjin.chart.api.history;

import com.jinnyjinnyjinjin.chart.service.client.response.ExternalResponse;
import com.jinnyjinnyjinjin.chart.service.history.dto.StockDto;
import com.jinnyjinnyjinjin.chart.common.ApiResponse;
import com.jinnyjinnyjinjin.chart.service.client.ClientServer;
import com.jinnyjinnyjinjin.chart.service.history.HistoryService;
import com.jinnyjinnyjinjin.chart.service.stock.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/history")
public class HistoryController {

    private final ClientServer clientServer;
    private final HistoryService historyService;
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll() {
        ExternalResponse externalResponse = clientServer.callChartHistory();
        Long stockId = stockService.create("삼성전자");
        historyService.create(stockId, externalResponse.toDto());
        StockDto stockDto = stockService.get(stockId);
        return new ResponseEntity<>(new ApiResponse(true, stockDto), HttpStatus.OK);
    }
}
