package br.com.alura.screenmatch.challanges;

import br.com.alura.screenmatch.challanges.model.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//9 - Dada a lista de produtos acima, calcule o total dos preços dos produtos em cada categoria e armazene o resultado em um Map<String, Double>.
public class Desafio16 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        // código usando streams
        Map<String, Double> productaGroup = produtos.stream().collect(Collectors.groupingBy(
                Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));

        System.out.println(productaGroup);
    }
}