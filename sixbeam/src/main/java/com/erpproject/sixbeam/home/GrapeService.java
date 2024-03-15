package com.erpproject.sixbeam.home;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GrapeService {

    private final RestTemplate restTemplate;

    public GrapeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GrapeForm getGrapePredictions(String url) {

        ResponseEntity<GrapeForm> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<GrapeForm>() {});
        System.out.println(response.getBody());
        return response.getBody();
    }



    // PredictionResult, Prediction 클래스는 API 응답에 맞게 정의
}

