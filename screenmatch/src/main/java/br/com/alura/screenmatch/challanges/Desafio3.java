package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;
//3 - Dada a lista de números inteiros abaixo, filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista.
public class Desafio3 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().map(n -> n * 2).forEach(System.out::println);
    }
}