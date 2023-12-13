package br.com.mac0472.planejamentoorcamentario.entity;

import br.com.mac0472.planejamentoorcamentario.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Table(name = "users", schema = "planejamento_orcamentario")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nusp;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public User(UserDto data) {
        name = data.getName();
        nusp = data.getNusp();
        profile = data.getProfile();
    }
}
