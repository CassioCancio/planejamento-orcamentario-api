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
	
	public User getDeclarantByNusp(String nusp) throws RuntimeException {
		Optional<User> userByNusp = userRepository.findByNusp(nusp);
		return userByNusp.orElseThrow(() -> new RuntimeException("User do declarante inexistente"));
	}
}
