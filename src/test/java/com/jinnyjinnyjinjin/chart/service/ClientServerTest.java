package com.jinnyjinnyjinjin.chart.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jinnyjinnyjinjin.chart.api.history.client.ClientServer;
import com.jinnyjinnyjinjin.chart.api.history.client.response.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@Slf4j
@SpringBootTest
class ClientServerTest {

    @Autowired
    ClientServer service;

    @Autowired
    RestTemplate restTemplate;

    @Value("${external.host}")
    private String host;

    @Value("${external.path}")
    private String path;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    @DisplayName("외부 api 호출 후 데이터 반환")
    void givenMockingIsDoneByMockRestServiceServer_whenGetIsCalled_thenReturnsObject() throws IOException {

        String responseTemplate = getResponseSample();

        Gson gson = new Gson();
        JsonObject converted = gson.fromJson(responseTemplate, JsonElement.class).getAsJsonObject();
        ExternalResponse externalResponse = gson.fromJson(converted, ExternalResponse.class);

        URI uri = UriComponentsBuilder.fromHttpUrl(host)
                .path(path)
                .queryParam("interval", "1d")
                .queryParam("range", "5d")
                .encode()
                .build()
                .toUri();

        this.mockServer
                .expect(ExpectedCount.once(),
                        requestTo(uri))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseTemplate, MediaType.APPLICATION_JSON));

        ExternalResponse result = service.callChartHistory();

        assertNotNull(result);
        assertEquals(externalResponse, result);

    }

    private String getResponseSample() throws IOException {
        String file = "src/test/resources/response-template.json";
        return Files.readString(Path.of(file));
    }
}