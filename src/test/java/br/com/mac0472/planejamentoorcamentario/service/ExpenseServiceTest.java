package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.*;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ExpenseServiceTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should save and return the saved Expense Entity")
    void createCaseSucess() {
        ProfileDto profileDto = new ProfileDto(ProfileType.GRS);
    }

    private void createExpenseDependencies(UserDto userDto, GroupDto groupDto, CategoryDto categoryDto,
                                           BalanceDto balanceDto, ProfileDto profileDto) {
        Profile profile = new Profile(profileDto);
        User user = new User(userDto);
        Group group = new Group(groupDto);
        Category category = new Category(categoryDto);
        Balance balance = new Balance(balanceDto);
        entityManager.persist(profile);
        entityManager.persist(user);
        entityManager.persist(group);
        entityManager.persist(category);
        entityManager.persist(balance);
    }
}