package com.example.fifaprofitapp.services;

import com.example.fifaprofitapp.domain.Deal;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;


public interface DealService {

    void saveDeal(Deal deal);

    void saveAllDeals(List<Deal> dealList);

    void updateDeal(Long id, Deal deal);

    void deleteDeal(Long id);

    Collection<Deal> getDeals();
    Collection<Deal> findAllByPlayer(String player);

    double calculateTotalProfit();
    double calculateTotalProfit(String player);

    Page<Deal> findPaginated(int pageNum, int pageSize);

    Page<Deal> findPaginatedByPlayer(String surname, int pageNo, int pageSize);
}
