package br.com.mac0472.planejamentoorcamentario.repository;

import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mac0472.planejamentoorcamentario.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    @Query("SELECT p FROM Profile p WHERE p.type = :type")
    Optional<Profile> findByType(@Param("type") ProfileType type);
}
