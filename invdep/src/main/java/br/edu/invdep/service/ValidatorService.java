package br.edu.invdep.service;

import java.util.List;
@FunctionalInterface
public interface ValidatorService {
    List<String> list(String entity);
}