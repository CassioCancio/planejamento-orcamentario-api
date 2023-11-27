package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.CategoryCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Category;
import br.com.mac0472.planejamentoorcamentario.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Should create and retrieve a Category")
    void createAndRetrieveCategory() {
        // Create a CategoryCreateDto with test data
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto();
        categoryCreateDto.setName("Test Category");

        // Create the Category using the CategoryService
        Category createdCategory = categoryService.create(categoryCreateDto);

        // Retrieve the created Category by its ID
        Long categoryId = createdCategory.getId();
        Category retrievedCategory = categoryRepository.findById(categoryId).orElse(null);

        // Assertions to check if the Category was created and retrieved successfully
        assertNotNull(retrievedCategory, "Category was not retrieved");
        assertEquals(categoryCreateDto.getName(), retrievedCategory.getName(), "Category names do not match");
    }
}
