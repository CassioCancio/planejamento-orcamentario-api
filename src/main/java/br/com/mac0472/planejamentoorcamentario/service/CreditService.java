package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.CreditCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private BalanceRepository balanceRepository;
	
	public List<Credit> getAll() {
		return creditRepository.findAll();
	}
	
	public Credit create(CreditCreateDto creditDto) throws RuntimeException {
		Optional<Group> groupById = groupRepository.findById(creditDto.getGroupId());
		
		Group group = groupById.orElseThrow(() -> new RuntimeException("Grupo inexistente"));
		
		Optional<Category> categoryById = categoryRepository.findById(creditDto.getCategoryId());
		
		Category category = categoryById.orElseThrow(() -> new RuntimeException("Categoria inexistente"));
		
		Optional<User> declarantByName = userService.getDeclarantByNusp(creditDto.getDeclarantUser());
		
		User declarant = declarantByName.orElseThrow(() -> new RuntimeException("User do declarante inexistente"));
		
		Optional<Balance> balanceById = balanceRepository.findById(creditDto.getBalanceId());
		
		Balance balance = balanceById.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
		
		Credit credit = new Credit(creditDto, group, category, declarant, balance);
		
		return creditRepository.save(credit);
	}
}
