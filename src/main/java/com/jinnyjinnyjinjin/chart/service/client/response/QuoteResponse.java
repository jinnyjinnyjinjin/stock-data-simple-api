package com.jinnyjinnyjinjin.chart.service.client.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuoteResponse {
    private List<Integer> volume = new ArrayList<>();
    private List<Integer> open = new ArrayList<>();
    private List<Integer> low = new ArrayList<>();
    private List<Integer> high = new ArrayList<>();
    private List<Integer> close = new ArrayList<>();
}
