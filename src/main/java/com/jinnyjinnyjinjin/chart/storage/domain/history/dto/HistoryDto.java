package com.jinnyjinnyjinjin.chart.storage.domain.history.dto;

import com.jinnyjinnyjinjin.chart.storage.domain.history.entity.HistoryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class HistoryDto {

    private Long id;
    private int volume;
    private int open;
    private int low;
    private int high;
    private int close;
    private LocalDateTime timestamp;

    public HistoryDto(int volume, int open, int low, int high, int close, LocalDateTime timestamp) {
        this.volume = volume;
        this.open = open;
        this.low = low;
        this.high = high;
        this.close = close;
        this.timestamp = timestamp;
    }

    public HistoryDto(Long id, int volume, int open, int low, int high, int close, LocalDateTime timestamp) {
        this.id = id;
        this.volume = volume;
        this.open = open;
        this.low = low;
        this.high = high;
        this.close = close;
        this.timestamp = timestamp;
    }

    public static HistoryDto of(HistoryEntity entity) {
        return new HistoryDto(
                entity.getId(),
                entity.getVolume(),
                entity.getOpen(),
                entity.getLow(),
                entity.getHigh(),
                entity.getClose(),
                entity.getTimestamp()
        );
    }
}
