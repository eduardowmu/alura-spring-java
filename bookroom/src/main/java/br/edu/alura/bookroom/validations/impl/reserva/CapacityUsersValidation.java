package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.repository.SalaRepository;
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
public class CapacityUsersValidation implements ReservaValidation {
    private final SalaRepository salaRepository;

    @Autowired
    public CapacityUsersValidation(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public void process(ModelEntity entity) {
        if(!(entity instanceof Reserva)) {
            throw new EntityTypeException("Tipo de entidade inválido", entity.getClass().getName());
        }

        Reserva reserva = (Reserva)entity;

        Sala salaReservar = this.salaRepository.findByCodigo(reserva.getSala().getCodigo()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Sala %s nao encontrada", reserva.getSala().getCodigo())));

        if(salaReservar.getCapacidade() < reserva.getCapacidade()) {
            throw new IllegalArgumentException(String.format("Numero de usuarios %d da reserva ultrapassa a " +
                    "capacidade da sala %d", reserva.getCapacidade(), salaReservar.getCapacidade()));
        }
    }
}