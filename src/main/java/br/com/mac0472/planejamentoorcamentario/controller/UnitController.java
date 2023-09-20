package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.entity.Unit;
import br.com.mac0472.planejamentoorcamentario.repository.UnitRepository;

@RestController
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	private UnitRepository repository;
	
	@GetMapping
	public List<Unit>  getAllUnits() {
		return repository.findAll();
	}

}
