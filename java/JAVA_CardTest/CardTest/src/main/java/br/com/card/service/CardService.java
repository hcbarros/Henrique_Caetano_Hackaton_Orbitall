package br.com.card.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import br.com.card.model.Card;
import br.com.card.repository.CardRepository;
import br.com.card.repository.CardRepositoryPage;

@Service
public class CardService {

	@Autowired
	private CardRepository repositorio;
	private CardRepositoryPage repositorioPage;
	
	public Card salvar(Card card) {
		return repositorio.save(card);
	}
	
	public Card alterar(Integer id, Card card) {
		Card cardBanco = getCard(id);
		cardBanco.setCardNumber(card.getCardNumber());
		cardBanco.setEmbossName(card.getEmbossName());
		cardBanco.setCustomerName(card.getCustomerName());
		cardBanco.setDocumentNumber(card.getDocumentNumber());
		cardBanco.setMotherName(card.getMotherName());
		cardBanco.setAddress(card.getAddress());
		cardBanco.setCity(card.getCity());	
		
		return salvar(cardBanco);
	}
		
	public List<Card> getAllCards(Card filtro) {
				
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Card> exemplo = Example.of(filtro, matcher);
		
		return repositorio.findAll(exemplo);
	}
	
	public List<Card> getAllCardsPage(Integer pageNo, Integer pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
        Page<Card> pagedResult = repositorioPage.findAll(paging);
        
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Card>();
        }		
	}	
	
	public Card getCard(Integer id) {
		return repositorio
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}
	
	public void excluir(Integer id) {
		repositorio.deleteById(id);
	}
	
}
