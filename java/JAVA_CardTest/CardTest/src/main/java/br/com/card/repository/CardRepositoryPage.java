package br.com.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.card.model.Card;

public interface CardRepositoryPage extends PagingAndSortingRepository<Card, Integer> {

}