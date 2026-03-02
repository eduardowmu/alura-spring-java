package br.edu.invdep.validators;

import java.util.List;

@FunctionalInterface
public interface Validators {
    void list(List<String> validators);
}