package br.com.mac0472.planejamentoorcamentario.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.entity.Category;
import br.com.mac0472.planejamentoorcamentario.entity.Expense;
import br.com.mac0472.planejamentoorcamentario.entity.Group;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByBalance(Balance balanco);
	
	@Query("SELECT e FROM Expense e WHERE e.balance = :balance AND (:groupId IS NULL OR e.group.id = :groupId) AND (:categoryId IS NULL OR e.category.id = :categoryId) AND LOWER(e.name) LIKE LOWER(CONCAT('%', :filter, '%'))")
    List<Expense> findByBalanceAndFilter(
            @Param("balance") Balance balance,
            @Param("groupId") Long group,
            @Param("categoryId") Long category,
            @Param("filter") String filter
    );
	
}
