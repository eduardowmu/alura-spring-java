package br.com.alura.bytebank;

import jakarta.persistence.*;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String functionary;
    private String cpf;
    private String agency;
    private String account;
    private Double value;
    private String refMonth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunctionary() {
        return functionary;
    }

    public void setFunctionary(String functionary) {
        this.functionary = functionary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getRefMonth() {
        return refMonth;
    }

    public void setRefMonth(String refMonth) {
        this.refMonth = refMonth;
    }
}