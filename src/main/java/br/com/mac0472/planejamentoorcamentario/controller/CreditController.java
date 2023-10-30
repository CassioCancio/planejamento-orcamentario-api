package br.com.mac0472.planejamentoorcamentario.controller;

import br.com.mac0472.planejamentoorcamentario.dto.CreditCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Credit;
import br.com.mac0472.planejamentoorcamentario.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/credit")
public class CreditController {

	@Autowired
	private CreditService creditService;
	
	@GetMapping("/getAll")
	public List<Credit> getAllCredits(){
		return creditService.getAll();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Credit createCredit(@RequestBody CreditCreateDto credit) {
		return creditService.create(credit);
	}
}
