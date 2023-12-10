package br.com.mac0472.planejamentoorcamentario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{
	
	List<Income> findByBalance(Balance balance);
	
	@Query("SELECT i FROM Income i WHERE i.balance = :balance AND (:groupId IS NULL OR i.group.id = :groupId) AND LOWER(i.name) LIKE LOWER(CONCAT('%', :filter, '%')) ORDER BY i.group.number")
    List<Income> findByBalanceAndFilter(
            @Param("balance") Balance balance,
            @Param("groupId") Long group,
            @Param("filter") String filter
    );
	
	void deleteById(Long incomeId);
}
