package med.voll.api.consulta;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    public void agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        Medico medico = this.medicoRepository.findById(dadosAgendamentoConsulta.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        Paciente paciente = this.pacienteRepository.findById(dadosAgendamentoConsulta.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Consulta consulta = new Consulta(null, medico, paciente, dadosAgendamentoConsulta.data());

        this.consultaRepository.save(consulta);
    }
}