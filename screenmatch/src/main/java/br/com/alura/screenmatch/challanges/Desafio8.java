package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

//1 - Dada a lista de números inteiros a seguir, encontre o maior número dela.
public class Desafio8 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        DoubleSummaryStatistics statistics = numeros.stream().mapToDouble(n -> n.doubleValue()).summaryStatistics();
        System.out.println(statistics.getMax());
    }
}