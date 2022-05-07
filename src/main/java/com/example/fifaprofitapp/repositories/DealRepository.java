package com.example.fifaprofitapp.repositories;

import com.example.fifaprofitapp.domain.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {

    @Override
    long count();

    @Override
    Collection<Deal> findAll();
    Collection<Deal> findAllByCardSurname(String surname);

    void deleteById(Long id);

    Page<Deal> findAll(Pageable pageable);
    Page<Deal> findAllByCardSurname(String surname, Pageable pageable);
}
