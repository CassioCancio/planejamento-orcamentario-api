package br.com.mac0472.planejamentoorcamentario.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "User")
@Table(name = "users", schema = "planejamento_orcamentario")
public class User {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer nusp;

    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    // Constructors

    public User() {
    }

    public User(String name, Integer nusp, Profile profile) {
        this.name = name;
        this.nusp = nusp;
        this.profile = profile;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNusp() {
        return nusp;
    }

    public void setNusp(Integer nusp) {
        this.nusp = nusp;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(nusp, user.nusp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nusp);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nusp=" + nusp +
                ", profile=" + profile +
                '}';
    }
}
