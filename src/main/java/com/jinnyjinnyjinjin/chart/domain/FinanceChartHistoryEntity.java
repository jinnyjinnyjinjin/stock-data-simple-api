package com.jinnyjinnyjinjin.chart.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "FINANCE_CHART_HISTORY")
public class FinanceChartHistoryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private int low;

    private int open;

    private int close;

    private int volume;

    private int high;

    private LocalDateTime timestamp;

    protected FinanceChartHistoryEntity(int low,
                                        int open,
                                        int close,
                                        int volume,
                                        int high,
                                        LocalDateTime timestamp) {
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.high = high;
        this.timestamp = timestamp;
    }

    public static FinanceChartHistoryEntity create(int low,
                                                   int open,
                                                   int close,
                                                   int volume,
                                                   int high,
                                                   LocalDateTime timestamp) {
        return new FinanceChartHistoryEntity(
                low,
                open,
                close,
                volume,
                high,
                timestamp
        );
    }
}
