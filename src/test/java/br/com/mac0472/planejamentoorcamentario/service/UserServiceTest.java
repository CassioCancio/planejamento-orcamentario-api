package br.com.mac0472.planejamentoorcamentario.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Should retrieve a Declarant User by NUSP")
    void retrieveDeclarantByNusp() {
        // Define a NUSP for testing
        String testNusp = "11223344";

        // Retrieve the Declarant User using the UserService
        var declarantOptional = userService.getDeclarantByNusp(testNusp);

        // Assertions to check if the Declarant User was retrieved successfully
        assertNotNull(declarantOptional, "Declarant User was not retrieved");
        assertTrue(declarantOptional.isPresent(), "Declarant User not found by NUSP: " + testNusp);

        // Assuming Declarant User has a specific name, you can assert it
        declarantOptional.ifPresent(declarant -> assertEquals("Expected Name", declarant.getName(),
                "Declarant User name does not match expected"));
    }
}
