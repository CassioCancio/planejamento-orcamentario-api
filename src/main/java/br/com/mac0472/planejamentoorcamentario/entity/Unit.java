package br.com.mac0472.planejamentoorcamentario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Unit")
@Table(name="units", schema="planejamento_orcamentario")
public class Unit {
	
	@Id
	@Column(updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String code;

	// Constructors
	public Unit(Long id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}
	public Unit() {
		
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
