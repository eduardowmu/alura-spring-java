package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//5 - Dada uma lista de números inteiros, separe os números pares dos ímpares.
public class Desafio12 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        // código do particionamento da lista
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).toList();
        Map<String, List<Integer>> numerosMap = new HashMap<>();
        numerosMap.put("pares", pares);
        numerosMap.put("impares", impares);
        System.out.println(numerosMap);
    }
}