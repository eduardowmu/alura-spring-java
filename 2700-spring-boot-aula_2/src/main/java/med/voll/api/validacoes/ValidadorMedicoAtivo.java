package med.voll.api.validacoes;

import jakarta.persistence.EntityExistsException;
import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements Validador {
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null) {
            return;
        }

        Boolean medicoEstaAtivo = this.medicoRepository.existsAtivoById(dados.idMedico());

        if(!medicoEstaAtivo) {
            throw new EntityExistsException("Consulta não pode ser agendada com médico exlcuído");
        }
    }
}