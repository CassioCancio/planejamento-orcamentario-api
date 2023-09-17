package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.repository.GroupRepository;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupRepository repository;
	
	@GetMapping
	public List<Group>  getAllGroups() {
		return repository.findAll();
	}

}
