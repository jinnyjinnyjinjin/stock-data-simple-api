package com.jinnyjinnyjinjin.chart.domain.stock.entity;

import com.jinnyjinnyjinjin.chart.domain.history.entity.HistoryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "STOCK")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "stock")
    private List<HistoryEntity> history;

    public StockEntity(String name) {
        this.name = name;
    }
}
