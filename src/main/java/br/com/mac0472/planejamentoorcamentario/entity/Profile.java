package br.com.mac0472.planejamentoorcamentario.entity;

import br.com.mac0472.planejamentoorcamentario.dto.ProfileDto;
import br.com.mac0472.planejamentoorcamentario.enums.ProfileType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="profiles", schema="planejamento_orcamentario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProfileType type;

    public Profile(ProfileDto data) {
        type = data.getType();
    }
}