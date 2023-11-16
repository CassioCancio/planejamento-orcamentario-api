package br.com.mac0472.planejamentoorcamentario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mac0472.planejamentoorcamentario.dto.IncomeCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.entity.Income;
import br.com.mac0472.planejamentoorcamentario.entity.User;
import br.com.mac0472.planejamentoorcamentario.repository.IncomeRepository;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired 
	private BalanceService balanceService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	public List<Income> getAllByBalance(Long year) throws RuntimeException {
		Balance balance = balanceService.getBalanceByYear(year);
		
		return incomeRepository.findByBalance(balance);
	}
	
	public Income getById(Long id) throws RuntimeException {
		Optional<Income> incomeById = incomeRepository.findById(id);
		
		return incomeById.orElseThrow(() -> new RuntimeException("Crédito Inexistente"));
	}
	
	@Transactional
	public Income create(IncomeCreateDto incomeDto) throws RuntimeException {
		Group group = groupService.getGroupById(incomeDto.getGroupId());

		User declarant = userService.getDeclarantByNusp(incomeDto.getDeclarantUser());
		
		Balance balance = balanceService.getBalanceById(incomeDto.getBalanceId());
		
		Income income = new Income(incomeDto, group, declarant, balance);
		
		return incomeRepository.save(income);
	}
	
	@Transactional
	public Income update(Income income) throws RuntimeException {
		return incomeRepository.save(income);
	}
}
