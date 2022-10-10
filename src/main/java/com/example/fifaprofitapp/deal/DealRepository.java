package com.example.fifaprofitapp.deal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {

    @Override
    long count();

    @Override
    List<Deal> findAll();
    List<Deal> findAllByCardSurname(String surname);

    Deal findDealById(Long id);

    void deleteById(Long id);
    Page<Deal> findAllByCompletedTrue(Pageable pageable);
    Page<Deal> findAllByCardSurnameAndCompletedTrue(String surname, Pageable pageable);

    List<Deal> findAllByCompletedFalse();
}
