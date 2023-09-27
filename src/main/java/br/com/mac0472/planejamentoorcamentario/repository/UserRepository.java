package br.com.mac0472.planejamentoorcamentario.repository;

import br.com.mac0472.planejamentoorcamentario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
