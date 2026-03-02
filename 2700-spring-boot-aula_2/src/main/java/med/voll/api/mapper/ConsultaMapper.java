package med.voll.api.mapper;

import med.voll.api.consulta.Consulta;
import med.voll.api.consulta.DadosDetalhamentoConsulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "idPaciente", target = "consulta.medico.id")
    @Mapping(source = "dateTime", target = "consulta.data")
    DadosDetalhamentoConsulta toDadosDetalhamentoConsulta(Consulta consulta);
}