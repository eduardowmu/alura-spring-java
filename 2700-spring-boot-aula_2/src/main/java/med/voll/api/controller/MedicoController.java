package med.voll.api.controller;

import med.voll.api.mapper.MedicoMapper;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        this.medicoRepository.save(this.medicoMapper.toMedico(dados));
    }
}
