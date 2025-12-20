package br.com.alura.screenmatch.challanges;

import br.com.alura.screenmatch.challanges.model.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//6 - Dada a lista de produtos acima, agrupe-os por categoria em um Map<String, List<Produto>>.
public class Desafio13 {
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
        Map<String, List<Produto>> productGroup = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
        System.out.println(productGroup);
    }
}