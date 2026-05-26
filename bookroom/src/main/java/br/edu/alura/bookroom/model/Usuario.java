package br.edu.alura.bookroom.model;

import br.edu.alura.bookroom.enumtypes.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table
public class Usuario implements ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String email;
    @Enumerated
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}