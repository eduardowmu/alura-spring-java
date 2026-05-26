package br.edu.alura.bookroom.services.impl;

import br.edu.alura.bookroom.repository.SalaRepository;
import br.edu.alura.bookroom.model.ModelEntity;
import br.edu.alura.bookroom.services.EntityService;
import br.edu.alura.bookroom.validations.SalaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaService implements EntityService {
    private final SalaRepository salaRepository;
    private final List<SalaValidation> salaValidations;

    @Autowired
    public SalaService(SalaRepository salaRepository, List<SalaValidation> salaValidations) {
        this.salaRepository = salaRepository;
        this.salaValidations = salaValidations;
    }



    @Override
    public ModelEntity save(ModelEntity entity) {
        return null;
    }

    @Override
    public ModelEntity update(ModelEntity entity) {
        return null;
    }

    @Override
    public ModelEntity findByCode(String code) {
        return null;
    }
}