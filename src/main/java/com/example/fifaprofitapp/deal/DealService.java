package com.example.fifaprofitapp.deal;

import com.example.fifaprofitapp.deal.Deal;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface DealService {

    List<Deal> getDeals(Optional<String> name);
    double calculateTotalProfit(List<Deal> dealList);
    Deal findDealById(Long id);

    void saveDeal(Deal deal);

    void saveAllDeals(List<Deal> dealList);

    void updateDeal(Long id, Deal deal);

    void deleteDeal(Long id);









    Page<Deal> findPaginated(int pageNum, int pageSize);

    Page<Deal> findPaginatedByPlayer(String surname, int pageNo, int pageSize);
}
