package br.edu.alura.bookroom.model.dto;

import br.edu.alura.bookroom.model.ModelEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservaReq(
        @NotBlank
        String codigo,
        @NotBlank
        String userCodigo,
        @NotBlank
        String salaCodigo,
        @NotNull
        Integer capacidade) implements ModelEntity {
}