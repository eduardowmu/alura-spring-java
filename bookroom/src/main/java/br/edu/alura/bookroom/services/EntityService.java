package br.edu.alura.bookroom.services;

import br.edu.alura.bookroom.model.ModelEntity;

public interface EntityService {
    ModelEntity save(ModelEntity entity);

    ModelEntity update(ModelEntity entity);

    ModelEntity findByCode(String code);
}
