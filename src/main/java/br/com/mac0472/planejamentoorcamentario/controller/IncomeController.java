package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.dto.IncomeCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Income;
import br.com.mac0472.planejamentoorcamentario.service.IncomeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@GetMapping("/byBalance/{year}")
	public List<Income> getAllIncomesByBalance(
			@PathVariable Long year,
			@RequestParam(required = false) Long group,
	        @RequestParam(required = false) String name) {
		return incomeService.getAllByBalanceAndFilter(year, group, name);
	}
	
	@GetMapping("/{incomeId}")
	public Income getIncomeById(@PathVariable Long incomeId) {
		return incomeService.getById(incomeId);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Income createIncome(@RequestBody IncomeCreateDto income) {
		return incomeService.create(income);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public Income updateIncome(@RequestBody Income income) {
		return incomeService.update(income);
	}
	
}
