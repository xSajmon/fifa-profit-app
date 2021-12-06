package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;

import java.util.Collection;


public interface DealService {

    void saveDeal(Deal deal);
    void updateDeal(Long id, Deal deal);
    void deleteDeal(Long id);
    Collection<Deal> getDeals();




}
