package br.com.alura.codetickets;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String client;
    private LocalDate birthDate;
    private String show;
    private LocalDate showDate;
    private String typeEntry;
    private Double value;
    private LocalDateTime importRegistry;

    private Double admTax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getTypeEntry() {
        return typeEntry;
    }

    public void setTypeEntry(String typeEntry) {
        this.typeEntry = typeEntry;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getImportRegistry() {
        return importRegistry;
    }

    public void setImportRegistry(LocalDateTime importRegistry) {
        this.importRegistry = importRegistry;
    }

    public Double getAdmTax() {
        return admTax;
    }

    public void setAdmTax(Double admTax) {
        this.admTax = admTax;
    }
}