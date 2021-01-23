package br.com.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.card.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}