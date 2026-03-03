package br.edu.invdep.service.impl;

import br.edu.invdep.service.ValidatorService;
import br.edu.invdep.validators.ClientValidators;
import br.edu.invdep.validators.ProductValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Autowired
    private List<ClientValidators> clientValidators;
    @Autowired
    private List<ProductValidators> productValidators;
    @Override
    public List<String> list(String entity) {
        List<String> validators = new ArrayList<>();
        if(entity.equalsIgnoreCase("client")) {
            this.clientValidators.forEach(c -> c.list(validators));
        } else if(entity.equalsIgnoreCase("product")){
            this.productValidators.forEach(p -> p.list(validators));
        } else {
            throw new ProviderNotFoundException("Tipo de entidade não encontrada");
        }
        return validators;
    }
}