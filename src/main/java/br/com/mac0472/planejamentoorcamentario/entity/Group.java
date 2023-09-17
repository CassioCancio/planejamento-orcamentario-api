package br.com.mac0472.planejamentoorcamentario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="groups", schema="planejamento_orcamentario")
public class Group {

	@Id
	@Column(updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Long number;

	// Constructors
	
	public Group(Long id, String name, Long number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	public Group() {
		
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
}
