package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.*;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import br.com.mac0472.planejamentoorcamentario.repository.ProfileRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ExpenseServiceTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should save and assert the saved Expense Entity")
    void createCaseSucess() {
        // We need to save in db some entities
        // User, Group, Category, Balance
        Optional<Profile> declarant = profileRepository.findByType(ProfileType.DECLARANT);
        if (declarant.isEmpty()) {
            throw new EntityNotFoundException("Profile with type 'DECLARANT' not found");
        }
        UserDto userDto = new UserDto("Pedro Lucas R S Campos", "11223344", declarant.get());
        GroupDto groupDto = new GroupDto("Grupo exemplo", 64L);
        CategoryDto categoryDto = new CategoryDto("Categoria exemplo");
        BalanceDto balanceDto = new BalanceDto();
    }

    private void createExpenseDependencies(UserDto userDto, GroupDto groupDto, CategoryDto categoryDto,
                                           BalanceDto balanceDto) {
        User user = new User(userDto);
        Group group = new Group(groupDto);
        Category category = new Category(categoryDto);
        Balance balance = new Balance(balanceDto);
        entityManager.persist(user);
        entityManager.persist(group);
        entityManager.persist(category);
        entityManager.persist(balance);
    }

    @BeforeAll
    private void createAllProfiles() {
        ProfileType grs = ProfileType.GRS;
        ProfileType declarant = ProfileType.DECLARANT;
        ProfileType other = ProfileType.OTHER;
        entityManager.persist(grs);
        entityManager.persist(declarant);
        entityManager.persist(other);
    }
}