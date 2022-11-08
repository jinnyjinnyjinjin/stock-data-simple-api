package com.jinnyjinnyjinjin.chart.api.history.client.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IndicatorResponse {
    private List<QuoteResponse> quote = new ArrayList<>();
}
