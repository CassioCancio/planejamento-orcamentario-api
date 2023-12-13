package br.com.mac0472.planejamentoorcamentario.entity;

import br.com.mac0472.planejamentoorcamentario.dto.CategoryCreateDto;
import br.com.mac0472.planejamentoorcamentario.dto.CategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Category")
@Table(name="categories", schema="planejamento_orcamentario")
@Data
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public Category(CategoryDto data) {
		name = data.getName();
	}

	public Category(CategoryCreateDto data) {
		name = data.getName();
	}

}
