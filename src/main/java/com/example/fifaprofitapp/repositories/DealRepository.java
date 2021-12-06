package com.example.fifaprofitapp.repositories;

import com.example.fifaprofitapp.domain.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {

    @Override
    long count();

    @Override
    Collection<Deal> findAll();
}
