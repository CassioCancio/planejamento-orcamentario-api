package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
