package br.com.mac0472.planejamentoorcamentario.entity;

import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profiles", schema="planejamento_orcamentario")
public class Profile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProfileType type;

    public Profile(Long id, ProfileType type) {
        this.id = id;
        this.type = type;
    }

    public Profile() {}

    public Profile(ProfileType type) {
        this.type = type;
    }
}