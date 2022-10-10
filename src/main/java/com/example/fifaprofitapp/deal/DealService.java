package com.example.fifaprofitapp.deal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface DealService {

    List<Deal> getCompletedDeals(Optional<String> name);
    Page<Deal> getCompletedDeals(Optional<String> name, Pageable pageable);
    List<Deal> getUncompletedDeals();
    double calculateTotalProfit(List<Deal> dealList);
    Deal findDealById(Long id);

    void saveDeal(Deal deal);

    void saveAllDeals(List<Deal> dealList);

    void updateDeal(Long id, Deal deal);

    void deleteDeal(Long id);




}
