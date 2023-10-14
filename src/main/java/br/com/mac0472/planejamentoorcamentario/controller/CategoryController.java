package br.com.mac0472.planejamentoorcamentario.controller;

import br.com.mac0472.planejamentoorcamentario.dto.CategoryCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Category;
import br.com.mac0472.planejamentoorcamentario.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/getAll")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Category createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
		return categoryService.create(categoryCreateDto);
	}
}
