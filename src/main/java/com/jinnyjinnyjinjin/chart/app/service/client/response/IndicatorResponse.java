package com.jinnyjinnyjinjin.chart.app.service.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicatorResponse {
    private List<QuoteResponse> quote;
}
