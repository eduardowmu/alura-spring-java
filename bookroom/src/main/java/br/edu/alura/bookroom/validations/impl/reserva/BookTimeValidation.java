package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.model.Reserva;
import br.edu.alura.bookroom.validations.ReservaValidation;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

@Component
public class BookTimeValidation implements ReservaValidation {
    @Override
    public void process(ModelEntity entity) {
        if(!(entity instanceof Reserva)) {
            throw new EntityTypeException("Tipo de entidade inválido", entity.getClass().getName());
        }

        Reserva reserva = (Reserva)entity;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if(reserva.getFim().isBefore(reserva.getInicio())) {
            throw new DateTimeException(String.format("Data de inicio da reserva %s deve ser antes da data de fim %s",
                    reserva.getInicio().format(formatter), reserva.getFim().format(formatter)));
        }
    }
}