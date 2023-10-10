package br.com.mac0472.planejamentoorcamentario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mac0472.planejamentoorcamentario.entity.User;
import br.com.mac0472.planejamentoorcamentario.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getDeclarantByNusp(String nusp){
		return userRepository.findByNusp(nusp);
	}
}
