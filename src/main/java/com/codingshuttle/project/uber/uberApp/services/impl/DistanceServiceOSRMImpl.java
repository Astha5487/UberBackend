package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {
        if (src == null || dest == null) {
            throw new IllegalArgumentException("Source or Destination point is null");
        }

        try {
            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY();
            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            if (responseDto == null || responseDto.getRoutes() == null || responseDto.getRoutes().isEmpty()) {
                throw new RuntimeException("No routes returned by OSRM");
            }

            return responseDto.getRoutes().get(0).getDistance() / 1000.0; // km
        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM: " + e.getMessage(), e);
        }
    }

    // DTO inside the same file
    @Data
    static class OSRMResponseDto {
        private List<OSRMRoute> routes;
    }

    @Data
    static class OSRMRoute {
        private Double distance;
    }
}
