package br.com.alura.screenmatch.challanges;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//2 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho. No código a seguir, há um exemplo prático do resultado esperado.
public class Desafio9 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> wordGroup = palavras.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(wordGroup);
        // Resultado Esperado: {4=[java, code], 6=[stream, lambda]}
    }
}