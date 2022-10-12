package com.example.fifaprofitapp.deal;

import com.example.fifaprofitapp.deal.mapper.DealDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class DealApiController {

    private final DealService dealService;
    private final DealDtoMapper dealMapper;

    public DealApiController(DealService dealService, DealDtoMapper dealMapper) {
        this.dealService = dealService;
        this.dealMapper = dealMapper;
    }

    @GetMapping("/deals")
    ResponseEntity<List<DealDto>> getDeals() {
        List<DealDto> deals = dealService.getAllDeals().stream()
                .map(dealMapper::mapDealToDealDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(deals);
    }

}
