package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.*;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import br.com.mac0472.planejamentoorcamentario.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
class ExpenseServiceTest {

    @Autowired
    @InjectMocks
    ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private UserService userService;

    @Mock
    private BalanceRepository balanceRepository;

    @BeforeAll
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should save and assert the saved Expense Entity")
    void createCaseSuccess() {

        // We need some mocked entities
        // User
        Profile userProfile = new Profile(ProfileType.DECLARANT);
        UserDto userDto = new UserDto("Username example", "11223344", userProfile);
        User user = new User(userDto);
        // Group
        GroupDto groupDto = new GroupDto("Group's name example", 64L);
        Group group = new Group(groupDto);
        // Category
        CategoryDto categoryDto = new CategoryDto("Category's name example");
        Category category = new Category(categoryDto);
        // Balance
        Instant beginning = LocalDate.of(2023, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant end = LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        BalanceDto balanceDto = new BalanceDto(beginning, end, 2023L);
        Balance balance = new Balance(balanceDto);

        // Mocked methods
        when(groupRepository.findById(group.getId())).thenReturn(Optional.of(group));
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        when(userService.getDeclarantByNusp(user.getNusp())).thenReturn(Optional.of(user));
        when(balanceRepository.findById(balance.getId())).thenReturn(Optional.of(balance));

        // Expense to be saved
        ExpenseCreateDto expenseCreateDto = new ExpenseCreateDto("Expense's name example", "Observation: Lorem ipsum", 2023.14f,
                "2023-01-23", "Requester example", group.getId(), category.getId(), userDto.getNusp(), balance.getId());

        // Assert
        expenseService.create(expenseCreateDto);
        verify(expenseRepository, times(1)).save(any());
    }
}