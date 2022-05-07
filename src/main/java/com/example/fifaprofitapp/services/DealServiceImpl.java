package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.repositories.DealRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

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
        dealRepository.deleteById(id);
    }

    @Override
    public Collection<Deal> getDeals() {
        return dealRepository.findAll();
    }

    @Override
    public Collection<Deal> findAllByPlayer(String surname) {
        return dealRepository.findAllByCardSurname(surname);
    }

    @Override
    public double calculateTotalProfit() {
        return dealRepository.findAll().stream().mapToDouble(Deal::getProfit).sum();
    }
    @Override
    public double calculateTotalProfit(String player) {
        return dealRepository.findAllByCardSurname(player).stream().mapToDouble(Deal::getProfit).sum();
    }

    @Override
    public Page<Deal> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return dealRepository.findAll(pageable);
    }

    @Override
    public Page<Deal> findPaginatedByPlayer(String surname, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return  dealRepository.findAllByCardSurname(surname, pageable);

    }
}