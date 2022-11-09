package com.jinnyjinnyjinjin.chart.storage.domain.history.service;

import com.jinnyjinnyjinjin.chart.exception.stock.StockNotFoundException;
import com.jinnyjinnyjinjin.chart.storage.domain.history.dto.HistoryDto;
import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.history.repository.HistoryAppender;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import com.jinnyjinnyjinjin.chart.storage.domain.stock.repository.StockReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class HistoryCreatorTest {

    @InjectMocks
    HistoryCreator historyCreator;

    @Mock
    HistoryAppender historyAppender;

    @Mock
    StockReader stockReader;

    @Test
    @DisplayName("데이터 생성")
    public void whenCreatedVerified() {
        // given
        StockEntity stock = mock(StockEntity.class);
        List<HistoryDto> historyDtoList = new ArrayList<>();
        List<HistoryEntity> historyEntities = new ArrayList<>();

        given(stockReader.read(anyLong())).willReturn(stock);

        // when
        historyCreator.createBatch(stock.getId(), historyDtoList);

        // then
        verify(stockReader, times(1)).read(anyLong());
        verify(historyAppender, times(1)).appendAll(historyEntities);
    }

    @Test
    @DisplayName("주식 조회 예외 발생")
    public void whenStockNoExistsThrowStockNotFoundException() {
        // given
        StockEntity stock = mock(StockEntity.class);
        List<HistoryDto> historyDtoList = new ArrayList<>();
        List<HistoryEntity> historyEntities = new ArrayList<>();

        given(stockReader.read(anyLong()))
                .willThrow(new StockNotFoundException("해당 주식을 찾을 수 없습니다."));

        // when
        assertThrows(StockNotFoundException.class, () ->
                historyCreator.createBatch(stock.getId(), historyDtoList));

        // then
        verify(stockReader, times(1)).read(anyLong());
        verify(historyAppender, times(0)).appendAll(historyEntities);
    }

}