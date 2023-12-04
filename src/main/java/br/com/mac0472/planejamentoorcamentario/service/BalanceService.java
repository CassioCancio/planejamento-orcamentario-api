package br.com.mac0472.planejamentoorcamentario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.repository.BalanceRepository;

@Service
public class BalanceService {
	@Autowired
	BalanceRepository balanceRepository;
	
	public Balance getBalanceById(Long id) throws RuntimeException {
		Optional<Balance> balanceById = balanceRepository.findById(id);
		return balanceById.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
	}
	
	public Balance getBalanceByYear(Long year) throws RuntimeException {
		Optional<Balance> balanceByYear = balanceRepository.findByYear(year);
		return balanceByYear.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
	}
}
