package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import br.com.mac0472.planejamentoorcamentario.dto.BalanceCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.mac0472.planejamentoorcamentario.dto.GroupReportDto;
import br.com.mac0472.planejamentoorcamentario.dto.ReportDto;
import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.service.BalanceService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/balance")
public class BalanceController {
	
	@Autowired
	private BalanceService balanceService;
	
	@GetMapping
	public List<Balance> getAllBalances() {
		return balanceService.getBalances();
	}
	
	@GetMapping("/{year}")
	public ReportDto getBalanceReport(@PathVariable Long year) {
		return balanceService.getBalanceReport(year, null);
	}
	
	@GetMapping("/{year}/getAllGroups")
	public List<GroupReportDto> getBalanceReportByGroup(@PathVariable Long year) {
		return balanceService.getBalanceReportByGroup(year);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Balance createBalance(@RequestBody BalanceCreateDto balanceCreateDto) {
		return balanceService.create(balanceCreateDto);
	}
}
