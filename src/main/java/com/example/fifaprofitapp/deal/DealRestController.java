package com.example.fifaprofitapp.deal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class DealRestController {

    private final DealService dealService;

    public DealRestController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/deals")
    ResponseEntity<List<Deal>> getDeals(@RequestParam Optional<String> name){

        return ResponseEntity.ok(dealService.getCompletedDeals(name));
    }

}
