package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import br.com.mac0472.planejamentoorcamentario.dto.CreditCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name= "Credit")
@Table(name="credits", schema="planejamento_orcamentario")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String observation;

    private Float value;

    private Instant creationDate;

    private Instant incomeDate;

    private String requester;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="balance_id")
    private Balance balance;

    @ManyToOne
    @JoinColumn(name="declarant_id")
    private User declarant;

    // Constructors

    public Credit() {

    }

    public Credit(CreditCreateDto creditDto, Group group, Category category, User declarant, Balance balance) {
        this.name = creditDto.getName();
        this.observation = creditDto.getObservation();
        this.value = creditDto.getValue();
        this.incomeDate= creditDto.getIncomeDate() == null ? null : LocalDate.parse(creditDto.getIncomeDate()).atStartOfDay(ZoneId.of("GMT-3")).toInstant();;
        this.requester = creditDto.getRequester();
        this.group = group;
        this.category = category;
        this.balance = balance;
        this.declarant = declarant;

        this.creationDate = Instant.now().atZone(ZoneId.of("GMT-3")).toInstant();
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Float getValue() { return value; }

    public void setValue(Float value) {
        this.value = value;
    }

    public Instant getExpectedPaymentDate() {
        return incomeDate;
    }

    public void setExpectedPaymentDate(Instant incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public User getDeclarant() {
        return declarant;
    }

}
