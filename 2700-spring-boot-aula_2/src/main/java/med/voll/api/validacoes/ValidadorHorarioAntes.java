package med.voll.api.validacoes;

import med.voll.api.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntes implements Validador {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinuto = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinuto < 30) {
            throw new IllegalArgumentException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}