package com.example.fifaprofitapp.deal;

import com.example.fifaprofitapp.deal.Deal;
import com.example.fifaprofitapp.deal.DealRepository;
import com.example.fifaprofitapp.deal.DealService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;

    public DealServiceImpl(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Override
    public List<Deal> getDeals(Optional<String> name) {
        return (name.isPresent() ? dealRepository.findAllByCardSurname(name.get()) : dealRepository.findAll());
    }

    @Override
    public Page<Deal> getDeals(Optional<String> name, Pageable pageable) {
        return (name.isPresent() ? dealRepository.findAllByCardSurname(name.get(), pageable) : dealRepository.findAll(pageable));
    }

    @Override
    public double calculateTotalProfit(List<Deal> dealList){
        return dealList.stream().mapToDouble(Deal::getProfit).sum();
    }

    public Deal findDealById(Long id){
       return dealRepository.findDealById(id);
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

}