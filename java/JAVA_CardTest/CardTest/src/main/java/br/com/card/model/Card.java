package br.com.card.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Card {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "{card.cardNumber.obrigatorio}")
	private String cardNumber;
		
	@NotBlank(message = "{card.embossName.obrigatorio}")
	private String embossName;
	
	@NotBlank(message = "{card.customerName.obrigatorio}")
	private String customerName;
	
	@NotBlank(message = "{card.documentNumber.obrigatorio}")
	private String documentNumber;
	
	@NotBlank(message = "{card.motherName.obrigatorio}")
	private String motherName;
	
	@NotBlank(message = "{card.address.obrigatorio}")
	private String address;
	
	@NotBlank(message = "{card.city.obrigatorio}")
	private String city;
	
	
	public Card() {
		

	}
	
	public Card(String cardNumber, String embossName, String customerName, String documentNumber, String motherName, String address, String city) {
		super();
		this.cardNumber = cardNumber;
		this.embossName = embossName;
		this.customerName = customerName ;
		this.documentNumber = documentNumber;
		this.motherName = motherName;
		this.address = address;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmbossName() {
		return embossName;
	}

	public void setEmbossName(String embossName) {
		this.embossName = embossName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
}
