package com.codingshuttle.project.uber.uberApp.utils;

import com.codingshuttle.project.uber.uberApp.dto.PointDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeometryUtil {

    public static Point createPoint(PointDto pointDto) {
        if (pointDto == null || pointDto.getCoordinates() == null || pointDto.getCoordinates().length < 2) {
            throw new IllegalArgumentException("Invalid PointDto: coordinates are missing or incomplete.");
        }

        double longitude = pointDto.getCoordinates()[0];
        double latitude = pointDto.getCoordinates()[1];

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(longitude, latitude));
    }
}
