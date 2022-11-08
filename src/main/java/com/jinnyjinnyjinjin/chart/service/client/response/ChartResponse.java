package com.jinnyjinnyjinjin.chart.service.client.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChartResponse {
    private List<BodyResponse> result = new ArrayList<>();
}
