package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.validations.ReservaValidation;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaExistsValidation implements ReservaValidation {

    @Override
    public void process(ModelEntity entity) {

    }
}
