package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.entity.Income;
import br.com.mac0472.planejamentoorcamentario.repository.IncomeRepository;

@RestController
@RequestMapping("/Income")
public class IncomeController {
	
	@Autowired
	private IncomeRepository repository;
	
	@GetMapping
	public List<Income> getAllIncomes() {
		return repository.findAll();
	}
}
