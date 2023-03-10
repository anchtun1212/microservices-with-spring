package com.anchtun.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.card.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	List<Card> findByCustomerId(Long customerId);
}
