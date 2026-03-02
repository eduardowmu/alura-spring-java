package br.edu.invdep.validators.client;

import br.edu.invdep.validators.ClientValidators;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClientStep2 implements ClientValidators {
    @Override
    public void list(List<String> validators) {
        validators.add(ClientStep2.class.getName());
    }
}
