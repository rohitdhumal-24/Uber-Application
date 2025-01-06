package com.rohit.project.uber.uberApp.configs;

import com.rohit.project.uber.uberApp.dto.PointDto;
import com.rohit.project.uber.uberApp.utills.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
         ModelMapper mapper=  new ModelMapper();

         mapper.typeMap(PointDto.class, Point.class).setConverter(context->{
             PointDto pointDto =context.getSource();
             return GeometryUtil.createPoint(pointDto); //org.locationtech.jts.geom.
         });

        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });
        return mapper;
    }
}
