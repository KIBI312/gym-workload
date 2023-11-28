package com.seitov.gymworkload.config;

import com.seitov.gymworkload.dto.ReportRecordDto;
import com.seitov.gymworkload.entity.ReportRecord;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfig {

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Bean
    public MapperFacade orikaMapper() {
        mapperFactory.classMap(ReportRecordDto.class, ReportRecord.class)
                .customize(new CustomMapper<ReportRecordDto, ReportRecord>() {
                    @Override
                    public void mapAtoB(ReportRecordDto dto, ReportRecord reportRecord, MappingContext context) {
                        reportRecord.setActionType(dto.getActionType());
                    }
                })
                .field("trainerUsername", "username")
                .field("firstName", "firstName")
                .field("lastName", "lastName")
                .field("date", "date")
                .field("isActive", "isActive")
                .field("duration", "duration").register();
        return mapperFactory.getMapperFacade();
    }

}
