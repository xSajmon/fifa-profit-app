package com.example.fifaprofitapp.deal;

import org.springframework.data.domain.Page;
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
    public List<Deal> getCompletedDeals(Optional<String> name) {
        return (name.isPresent() ? dealRepository.findAllByCardSurname(name.get()) : dealRepository.findAll());
    }

    @Override
    public Page<Deal> getCompletedDeals(Optional<String> name, Pageable pageable) {
        return (name.isPresent() ? dealRepository.findAllByCardSurnameAndCompletedTrue(name.get(), pageable) : dealRepository.findAllByCompletedTrue(pageable));
    }

    @Override
    public List<Deal> getUncompletedDeals() {
        return dealRepository.findAllByCompletedFalse();
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