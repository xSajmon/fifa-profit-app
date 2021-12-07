package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DealServiceImpl implements DealService{

    private final DealRepository dealRepository;

    public DealServiceImpl(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Override
    public void saveDeal(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void saveAllDeals(List<Deal> dealList) {
        dealRepository.saveAll(dealList);
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