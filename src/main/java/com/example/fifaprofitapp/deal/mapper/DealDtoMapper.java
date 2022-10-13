package com.example.fifaprofitapp.deal.mapper;

import com.example.fifaprofitapp.card.Card;
import com.example.fifaprofitapp.deal.Deal;
import com.example.fifaprofitapp.deal.DealDto;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service
public class DealDtoMapper {

    private final ModelMapper modelMapper;

    public DealDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public DealDto mapDealToDealDto(Deal deal){
        Converter<Card, String> cardNameConverter = ctx -> ctx.getSource() == null ? null : generateCardName(ctx.getSource().getSurname(), String.valueOf(ctx.getSource().getOverall()));

        modelMapper.typeMap(Deal.class, DealDto.class).addMappings(mapper -> {
            mapper.using(cardNameConverter).map(Deal::getCard, DealDto::setCardName);
        });
        return modelMapper.map(deal, DealDto.class);
    }

    private String generateCardName(String surname, String overall){
        return String.format("%s %s", surname, overall);
    }
}
