package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.model.Reserva;
import br.edu.alura.bookroom.validations.ReservaValidation;
import br.edu.alura.bookroom.validations.Validation;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Component;

@Component
public class CapacityValidation implements ReservaValidation {

    @Override
    public void process(ModelEntity entity) {
        if(!(entity instanceof Reserva)) {
            throw new EntityTypeException("Tipo de entidade inválido", entity.getClass().getName());
        }

        Reserva reserva = (Reserva)entity;

        if(reserva.getCapacidade() <= 0) {
            throw new IllegalArgumentException(String.format("Numero de usuarios %d da reserva deve ser maior que zero",
                    reserva.getCapacidade()));
        }
    }
}