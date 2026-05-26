package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.repository.SalaRepository;
import br.edu.alura.bookroom.enumtypes.Status;
import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.model.Reserva;
import br.edu.alura.bookroom.model.Sala;
import br.edu.alura.bookroom.validations.ReservaValidation;
import br.edu.alura.bookroom.validations.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveRoomValidation implements ReservaValidation {
    private final SalaRepository salaRepository;

    @Autowired
    public ActiveRoomValidation(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public void process(ModelEntity entity) {
        if(!(entity instanceof Reserva)) {
            throw new EntityTypeException(String.format("Tipo de entidade inválido %s", entity.getClass().getName()),
                    entity.getClass().getName());
        }

        Reserva reserva = (Reserva)entity;

        Sala salaReservar = this.salaRepository.findByCodigo(reserva.getSala().getCodigo()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Sala %s nao encontrada",
                        reserva.getSala().getCodigo())));

        if(!salaReservar.getStatus().equals(Status.ACTIVE)) {
            throw new IllegalStateException(String.format("Nao e possível reservar esta sala %s. Status: %s",
                    salaReservar.getCodigo(), salaReservar.getStatus().name()));
        }
    }
}
