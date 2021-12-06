package com.example.fifaprofitapp.repositories;

import com.example.fifaprofitapp.domain.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
