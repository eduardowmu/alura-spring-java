package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;
//2 - Dada a lista de strings abaixo, converta todas para letras maiúsculas e imprima-as.
public class Desafio2 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream().map(p -> p.toUpperCase()).forEach(System.out::println);
    }
}