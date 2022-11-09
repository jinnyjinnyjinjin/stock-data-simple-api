package com.jinnyjinnyjinjin.chart.app.service.history;

import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.StockHistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.service.HistoryCreator;
import com.jinnyjinnyjinjin.chart.storage.domain.history.service.HistoryFinder;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.serivce.StockCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistoryServiceTest {

    @Mock
    StockCreator stockCreator;

    @Mock
    HistoryCreator historyCreator;

    @Mock
    HistoryFinder historyFinder;

    @InjectMocks
    HistoryService historyService;

    @Test
    @DisplayName("stock & history 생성 후 history 조회 해서 반환")
    public void createEntitiesAndReturnObject() {
        // given
        Long stockId = 1L;
        List<HistoryDto> historyDtoList = new ArrayList<>();
        StockHistoryDto stockHistoryDto = mock(StockHistoryDto.class);

        given(stockCreator.create(anyString()))
                .willReturn(stockId);

        doNothing()
                .when(historyCreator)
                .createBatch(stockId, historyDtoList);

        given(historyFinder.findTop5RecentHistory(stockId))
                .willReturn(stockHistoryDto);

        // when
        StockHistoryDto result = historyService.createBatch(historyDtoList);

        // then
        assertNotNull(result);
        assertEquals(stockHistoryDto, result);
        verify(stockCreator, times(1)).create(anyString());
        verify(historyCreator, times(1)).createBatch(stockId, historyDtoList);
        verify(historyFinder, times(1)).findTop5RecentHistory(stockId);
    }
}