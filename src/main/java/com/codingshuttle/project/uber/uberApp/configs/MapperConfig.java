package com.codingshuttle.project.uber.uberApp.configs;

import com.codingshuttle.project.uber.uberApp.dto.PointDto;
import com.codingshuttle.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Convert PointDto -> Point
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
            PointDto pointDto = context.getSource();
            if (pointDto == null || pointDto.getCoordinates() == null || pointDto.getCoordinates().length < 2) {
                return null;
            }
            return GeometryUtil.createPoint(pointDto);
        });

        // Convert Point -> PointDto
        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            if (point == null) return null;
            double[] coordinates = {
                    point.getX(), // longitude
                    point.getY()  // latitude
            };
            return new PointDto(coordinates);
        });

        return mapper;
    }
}
