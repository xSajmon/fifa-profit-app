package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.repositories.DealRepository;
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
        return name.isPresent() ? dealRepository.findAllByCardSurname(name.get()) : dealRepository.findAll();
    }

    @Override
    public double calculateTotalProfit(List<Deal> dealList){
        return dealList.stream().mapToDouble(Deal::getProfit).sum();
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