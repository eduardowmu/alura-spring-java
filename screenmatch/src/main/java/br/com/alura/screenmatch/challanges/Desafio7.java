package br.com.alura.screenmatch.challanges;

import br.com.alura.screenmatch.challanges.model.Produto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//7 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String), preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.
public class Desafio7 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis"));

        produtos.stream().filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto::getPreco)).forEach(System.out::println);

        //8 - Tomando o mesmo código do exercício anterior como base, modifique o código para que a saída mostre apenas os três produtos mais baratos da categoria "Eletrônicos".
        produtos.stream().filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco))
                .limit(3)
                .forEach(System.out::println);
    }
}