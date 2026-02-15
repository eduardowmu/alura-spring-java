package med.voll.api.mapper;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "crm", target = "crm")
    @Mapping(source = "especialidade", target = "especialidade")
    @Mapping(source = "endereco", target = "endereco")
    @Mapping(source = "ativo", target = "ativo")
    Medico toMedico(DadosCadastroMedico dadosCadastroMedico);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "crm", target = "crm")
    @Mapping(source = "especialidade", target = "especialidade")
    @Mapping(source = "endereco", target = "endereco")
    @Mapping(source = "ativo", target = "ativo")
    DadosCadastroMedico toDadosMedico(Medico medico);
}