package com.example.fifaprofitapp.repositories;

import com.example.fifaprofitapp.domain.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {
}
