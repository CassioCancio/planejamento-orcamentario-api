package br.com.mac0472.planejamentoorcamentario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public Group getGroupById(Long groupId) throws RuntimeException {
		Optional<Group> groupById = groupRepository.findById(groupId);
		
		return groupById.orElseThrow(() -> new RuntimeException("Grupo inexistente"));
	}
}
