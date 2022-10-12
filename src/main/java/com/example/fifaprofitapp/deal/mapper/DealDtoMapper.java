package com.example.fifaprofitapp.deal.mapper;

import com.example.fifaprofitapp.deal.Deal;
import com.example.fifaprofitapp.deal.DealDto;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service
public class DealDtoMapper {

    private final ModelMapper modelMapper;

    public DealDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public DealDto mapDealToDealDto(Deal deal){
        modelMapper.typeMap(Deal.class, DealDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getCard().getOverall(), DealDto::setCardRating);
        });
        return modelMapper.map(deal, DealDto.class);
    }
}
