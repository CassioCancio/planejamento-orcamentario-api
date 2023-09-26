package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.repository.BalanceRepository;

@RestController
@RequestMapping("/balance")
public class BalanceController {
	
	@Autowired
	private BalanceRepository repository;
	
	@GetMapping
	public List<Balance> getAllBalances() {
		return repository.findAll();
	}
}
