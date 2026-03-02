package med.voll.api.validacoes;

import jakarta.persistence.EntityExistsException;
import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements Validador {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        Boolean pacienteAtivo = this.pacienteRepository.existsById(dados.idPaciente());

        if(pacienteAtivo) {
            throw new EntityExistsException("Consulta não pode ser agendada sem paciente cadastrado");
        }
    }
}