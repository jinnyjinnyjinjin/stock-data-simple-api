package com.jinnyjinnyjinjin.chart.exception.stock;

public class StockNotFoundException extends RuntimeException {

    private Object field;

    public StockNotFoundException(String message, Object filed) {
        super(message);
        this.field = filed;
    }
}
