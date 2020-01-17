package com.carrental.mapper;

import com.carrental.domain.CarStatus;
import com.carrental.dto.CarStatusDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarStatusMapper {

    public CarStatus mapToCarStatus(final CarStatusDto carStatusDto) {
        return new CarStatus(
                carStatusDto.getCarStatusId(),
                carStatusDto.getCarStatusDescription(),
                new ArrayList<>()
        );
    }

    public CarStatusDto mapToCarStatusDto(final CarStatus carStatus) {
        return new CarStatusDto(
                carStatus.getCarStatusId(),
                carStatus.getCarStatusDescription()
        );
    }

    public List<CarStatusDto> mapToCarStatusDto(final List<CarStatus> carStatusList) {
        return carStatusList.stream()
                .map(this::mapToCarStatusDto)
                .collect(Collectors.toList());
    }
}
