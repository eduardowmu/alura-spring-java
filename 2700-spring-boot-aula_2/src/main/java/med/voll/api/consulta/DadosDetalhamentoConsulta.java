package med.voll.api.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,
        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime dateTime) {
}