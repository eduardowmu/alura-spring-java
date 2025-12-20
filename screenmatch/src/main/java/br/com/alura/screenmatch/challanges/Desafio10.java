package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;

//3 - Dada a lista de nomes abaixo, concatene-os separados por vírgula. No código a seguir, há um exemplo prático do resultado esperado.
public class Desafio10 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        // código do agrupamento de dados
        String namesQueue = nomes.stream().reduce("", (a, b) -> a + b + ", ");
        System.out.println(namesQueue);
        // Resultado Esperado: "Alice, Bob, Charlie"
    }
}