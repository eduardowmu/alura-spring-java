package med.voll.api.mapper;

import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "endereco", target = "endereco")
    Paciente toPaciente(DadosCadastroPaciente dadosCadastroPaciente);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "endereco", target = "endereco")
    DadosCadastroPaciente toDados(Paciente paciente);
}