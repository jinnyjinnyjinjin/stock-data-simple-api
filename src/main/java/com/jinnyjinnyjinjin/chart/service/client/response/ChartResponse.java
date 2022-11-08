package com.jinnyjinnyjinjin.chart.service.client.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ChartResponse {
    private List<Date> timestamp = new ArrayList<>();
    private IndicatorResponse indicators;
}
