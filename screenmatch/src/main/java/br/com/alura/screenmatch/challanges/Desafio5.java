package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;

//5 - Dada a lista de sublistas de números inteiros abaixo, extraia todos os números primos em uma única lista e os ordene em ordem crescente.
public class Desafio5 {
    public static void main(String[] args) {
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12));

        listaDeNumeros.forEach(l -> l.stream().filter(n -> isPrimo(n)).forEach(System.out::println));
    }

    private static boolean isPrimo(Integer numero) {
        for(int i = 2; i < 12; i++) {
            if(i != numero && numero % i == 0) return false;
        }
        return true;
    }
}