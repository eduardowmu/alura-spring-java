package br.edu.alura.bookroom.validations;

import br.edu.alura.bookroom.model.ModelEntity;
import jakarta.transaction.NotSupportedException;

@FunctionalInterface
public interface Validation {
    void process(ModelEntity entity);
}