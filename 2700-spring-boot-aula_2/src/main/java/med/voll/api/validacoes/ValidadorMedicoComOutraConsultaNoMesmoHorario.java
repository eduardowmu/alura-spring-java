package med.voll.api.validacoes;

import jakarta.persistence.EntityExistsException;
import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements Validador{
    @Autowired
    private ConsultaRepository consultaRepository;
    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = this.consultaRepository
                .existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if(medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new EntityExistsException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}