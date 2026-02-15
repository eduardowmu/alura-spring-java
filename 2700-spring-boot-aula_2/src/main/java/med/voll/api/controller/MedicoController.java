package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        Optional<Medico> medicoOptional = this.medicoRepository.findByCrm(dados.crm());
        Medico medico = this.medicoMapper.toMedico(dados);
        if(medicoOptional.isPresent()) {
            medico.setId(medicoOptional.get().getId());
        }
        this.medicoRepository.save(medico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosCadastroMedico>> listAll(@PageableDefault(size = 4, page = 0, sort = {"nome"})
                                                                 Pageable pageable) {
//        List<DadosCadastroMedico> medicos = new ArrayList<>();
//        this.medicoRepository.findAll().forEach(m -> medicos.add(this.medicoMapper.toDadosMedico(m)));
        Page<DadosCadastroMedico> medicos = medicoRepository.findAll(pageable)
                .map(m -> medicoMapper.toDadosMedico(m));
        return ResponseEntity.ok(medicos);
    }

    @DeleteMapping("/{crm}")
    public void delete(@PathVariable("crm") String crm) {
        Medico medico = this.medicoRepository.findByCrm(crm).orElseThrow(() -> new NoSuchElementException("Medico não encontrado"));
        //this.medicoRepository.delete(medico);
        medico.setAtivo(false);
        this.medicoRepository.save(medico);
    }
}
