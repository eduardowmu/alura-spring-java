package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;

//4 - Dada a lista de números inteiros abaixo, calcule a soma dos quadrados dos números pares.
public class Desafio11 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = numeros.stream().filter(n -> n % 2 == 0).toList().stream()
                .reduce(0, (soma, numero) -> soma + (numero * numero));
        System.out.println(sum);
        // código da filtragem e agrupamento dos dados
    }
}