package br.com.card.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.card.model.Card;
import br.com.card.service.CardService;

@RestController
@Validated
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardService cardService;
	
	@GetMapping(value = "{id}")
	public Card getOne(@PathVariable Integer id) {
		return cardService.getCard(id);		
	}
	
	@GetMapping
	public List<Card> getAll(Card card) {
		return cardService.getAllCards(card);
	}
	
	@GetMapping(value = "/paginationAndSorting")
    public ResponseEntity<List<Card>> getAllPage(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        List<Card> list = cardService.getAllCardsPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Card>>(list, HttpStatus.OK); 
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Card salvar(@RequestBody @Valid Card card) {
		return cardService.salvar(card);
	}
	
	@PutMapping(value = "{id}")
	public Card alterar(@PathVariable Integer id, @RequestBody Card card) {
		return cardService.alterar(id, card);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		cardService.excluir(id);
	}
	
}


