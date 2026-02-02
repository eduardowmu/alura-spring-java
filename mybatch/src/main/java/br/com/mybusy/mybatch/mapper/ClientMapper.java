package br.com.mybusy.mybatch.mapper;

import br.com.mybusy.db.db_core.model.Client;
import br.com.mybusy.mybatch.dto.ClientDTO;
import br.com.mybusy.mybatch.model.MyClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client client);

    MyClient toEntity(ClientDTO dto);
}