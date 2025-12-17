package br.com.alura.screenmatch.challanges;

import br.com.alura.screenmatch.challanges.model.Pessoa;

import java.util.Arrays;
import java.util.List;

//6 - Dado um objeto Pessoa com os campos nome e idade, filtre as pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.
public class Desafio6 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19));

        pessoas.stream().filter(p -> p.getIdade() > 18).map(p -> p.getNome()).forEach(System.out::println);
    }
}