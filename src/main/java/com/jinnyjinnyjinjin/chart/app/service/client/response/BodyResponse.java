package com.jinnyjinnyjinjin.chart.app.service.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyResponse {
    private List<Date> timestamp;
    private IndicatorResponse indicators;
}
