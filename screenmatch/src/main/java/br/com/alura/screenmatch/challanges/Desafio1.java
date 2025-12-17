package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;
//1 - Dada a lista de números inteiros abaixo, filtre apenas os números pares e imprima-os.
public class Desafio1 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}