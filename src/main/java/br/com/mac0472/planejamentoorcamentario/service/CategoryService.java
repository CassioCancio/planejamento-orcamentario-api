package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.CategoryCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Category;
import br.com.mac0472.planejamentoorcamentario.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category create(CategoryCreateDto categoryCreateDto) throws RuntimeException{
		Category category = new Category(categoryCreateDto);
		return categoryRepository.save(category);
	}
	
	public Category getCategoryById(Long categoryId) throws RuntimeException{
		Optional<Category> categoryById = categoryRepository.findById(categoryId);
		
		return categoryById.orElseThrow(() -> new RuntimeException("Categoria inexistente"));
	}
}
