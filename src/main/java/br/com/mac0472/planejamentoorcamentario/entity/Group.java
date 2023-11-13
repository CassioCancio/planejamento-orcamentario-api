package br.com.mac0472.planejamentoorcamentario.entity;

import br.com.mac0472.planejamentoorcamentario.dto.GroupDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="groups", schema="planejamento_orcamentario")
@Data
@NoArgsConstructor
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long number;

	public Group(GroupDto data) {
		name = data.getName();
		number = data.getNumber();
	}
	
}
