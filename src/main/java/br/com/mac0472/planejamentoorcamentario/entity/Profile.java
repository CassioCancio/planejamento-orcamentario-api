package br.com.mac0472.planejamentoorcamentario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;

@Entity
@Table(name="profiles", schema="planejamento_orcamentario")
public class Profile {
    @Id
    @Column(updatable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProfileType type;
}