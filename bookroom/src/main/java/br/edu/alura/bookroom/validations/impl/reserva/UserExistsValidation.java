package br.edu.alura.bookroom.validations.impl.reserva;

import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.model.Reserva;
import br.edu.alura.bookroom.model.Usuario;
import br.edu.alura.bookroom.repository.UsuarioRepository;
import br.edu.alura.bookroom.validations.ReservaValidation;
import br.edu.alura.bookroom.validations.UserValidation;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Component
public class UserExistsValidation implements ReservaValidation {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserExistsValidation(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void process(ModelEntity entity) {
        if(!(entity instanceof Reserva)) {
            throw new EntityTypeException(String.format("Tipo de entidade inválido %s", entity.getClass().getName()),
                    entity.getClass().getName());
        }

        Reserva reserva = (Reserva)entity;

        Usuario usuario = this.usuarioRepository.findByCodigo(reserva.getUsuario().getMatricula())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Usuario %s nao encontrado",
                        reserva.getUsuario().getMatricula())));
    }
}