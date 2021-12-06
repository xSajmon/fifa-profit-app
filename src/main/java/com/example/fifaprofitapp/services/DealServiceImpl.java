package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DealServiceImpl implements DealService{

    @Autowired
    private DealRepository dealRepository;

    @Override
    public void saveDeal(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void updateDeal(Long id, Deal deal) {

    }

    @Override
    public void deleteDeal(Long id) {

    }

    @Override
    public Collection<Deal> getDeals() {
        return dealRepository.findAll();
    }

}
