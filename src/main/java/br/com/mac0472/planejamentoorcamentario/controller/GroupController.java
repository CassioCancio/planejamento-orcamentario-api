package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import br.com.mac0472.planejamentoorcamentario.exceptions.GroupNotFoundException;
import org.springframework.web.bind.annotation.*;

import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.repository.GroupRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/group")
public class GroupController {

	private final GroupRepository repository;

	public GroupController(GroupRepository repository) {
		this.repository = repository;
	}

	@GetMapping()
	public List<Group>  getAllGroups() {
		return repository.findAll();
	}

	@PostMapping()
	public Group newGroup(@RequestBody Group newGroup) {return repository.save(newGroup);}

	@GetMapping("/{id}")
	public Group one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new GroupNotFoundException(id));
	}

	@PutMapping("/{id}")
	public Group replaceGroup(@RequestBody Group newGroup, @PathVariable Long id) {
		return repository.findById(id)
				.map(group -> {
					group.setName(newGroup.getName());
					group.setNumber(newGroup.getNumber());
					return repository.save(group);
				})
				.orElseGet(() -> {
					newGroup.setId(id);
					return repository.save(newGroup);
				});
	}

	@DeleteMapping("/{id}")
	public void deleteGroup(@PathVariable Long id) { repository.deleteById(id); }

}
