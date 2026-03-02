package med.voll.api.consulta;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.mapper.ConsultaMapper;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.validacoes.Validador;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Autowired
    private List<Validador> validadores;
    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        Medico medico = null;

        if(dadosAgendamentoConsulta.idMedico() != null) {
            medico = this.medicoRepository.findById(dadosAgendamentoConsulta.idMedico())
                    .orElseThrow(() -> new EntityNotFoundException("Medico não encontrado"));
        } else {
            medico = this.escolherMedico(dadosAgendamentoConsulta);
        }

        validadores.forEach(v -> v.validar(dadosAgendamentoConsulta));

        Paciente paciente = this.pacienteRepository.findById(dadosAgendamentoConsulta.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Consulta consulta = new Consulta(null, medico, paciente, dadosAgendamentoConsulta.data());

        return this.consultaMapper.toDadosDetalhamentoConsulta(this.consultaRepository.save(consulta));
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new EntityTypeException("Especialidade é obrigatória quando médico não for escolhido!", null);
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}