package br.com.mac0472.planejamentoorcamentario.service;

import br.com.mac0472.planejamentoorcamentario.dto.*;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import br.com.mac0472.planejamentoorcamentario.repository.IncomeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IncomeServiceTest {
    @Autowired
    @InjectMocks
    IncomeService incomeService;

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private BalanceService balanceService;

    @Mock
    private UserService userService;

    @Mock
    private GroupService groupService;

    private User user;
    private Group group;
    private Balance balance;

    @BeforeAll
    void setup() {
        MockitoAnnotations.openMocks(this);
        // We need some entities
        // User
        Profile userProfile = new Profile(ProfileType.DECLARANT);
        UserDto userDto = new UserDto("Username example", "11223344", userProfile);
        user = new User(userDto);
        // Group
        GroupDto groupDto = new GroupDto("Group's name example", 64L);
        group = new Group(groupDto);
        // Balance
        Instant beginning = LocalDate.of(2023, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant end = LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        BalanceDto balanceDto = new BalanceDto(beginning, end, 2023L);
        balance = new Balance(balanceDto);
    }

    @Test
    void createSucess() {
        // Mocked methods
        when(groupService.getGroupById(group.getId())).thenReturn(group);
        when(userService.getDeclarantByNusp(user.getNusp())).thenReturn(user);
        when(balanceService.getBalanceByYear(balance.getYear())).thenReturn(balance);

        // Income to be saved
        IncomeCreateDto incomeCreateDto = new IncomeCreateDto("Renda Teste", "Observação teste",
                444F, user.getName(), balance.getYear(), group.getId());
        incomeService.create(incomeCreateDto);

        // Assert
        verify(incomeRepository, times(1)).save(any());
    }
}