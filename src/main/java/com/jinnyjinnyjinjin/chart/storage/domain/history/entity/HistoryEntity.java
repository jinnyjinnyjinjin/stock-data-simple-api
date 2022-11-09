package com.jinnyjinnyjinjin.chart.storage.domain.history.entity;

import com.jinnyjinnyjinjin.chart.storage.domain.stock.entity.StockEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "HISTORY")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "stock_id")
    private StockEntity stock;

    private int low;

    private int open;

    private int close;

    private int volume;

    private int high;

    private LocalDateTime timestamp;

    protected HistoryEntity(StockEntity stock,
                            int low,
                            int open,
                            int close,
                            int volume,
                            int high,
                            LocalDateTime timestamp) {
        this.stock = stock;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.high = high;
        this.timestamp = timestamp;
    }

    public static HistoryEntity create(StockEntity stock,
                                       int low,
                                       int open,
                                       int close,
                                       int volume,
                                       int high,
                                       LocalDateTime timestamp) {
        return new HistoryEntity(
                stock,
                low,
                open,
                close,
                volume,
                high,
                timestamp
        );
    }
}
