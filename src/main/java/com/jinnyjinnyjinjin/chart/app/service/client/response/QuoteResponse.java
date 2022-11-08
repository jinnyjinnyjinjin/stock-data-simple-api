package com.jinnyjinnyjinjin.chart.app.service.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {
    private List<Integer> volume;
    private List<Integer> open;
    private List<Integer> low;
    private List<Integer> high;
    private List<Integer> close;
}
