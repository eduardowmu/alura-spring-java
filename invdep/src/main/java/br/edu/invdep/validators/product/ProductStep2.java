package br.edu.invdep.validators.product;

import br.edu.invdep.validators.ProductValidators;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductStep2 implements ProductValidators {
    @Override
    public void list(List<String> validators) {
        validators.add(ProductStep2.class.getName());
    }
}