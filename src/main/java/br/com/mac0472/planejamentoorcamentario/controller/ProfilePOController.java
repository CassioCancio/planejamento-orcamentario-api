package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.entity.Profile;
import br.com.mac0472.planejamentoorcamentario.repository.ProfileRepository;

@RestController
@RequestMapping("/profile")
public class ProfilePOController {

	@Autowired
	private ProfileRepository repository;
	
	@GetMapping
	public List<Profile>  getAllProfiles() {
		return repository.findAll();
	}

}
