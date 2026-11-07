package edu.fatec.lp2.exercicio2;

import edu.fatec.lp2.exercicio2.compras.*;

public class Main {
    public static void main(String[] args) {
        Supermercado astolfo = new Supermercado("Seu Astolfo Supermercado") { };

        Produto arroz = new Produto(astolfo) { };
        arroz.setNome("Arroz");
        arroz.setUnidade("kg");
        arroz.setDescricao("Arroz branco tipo 1");
        arroz.setPreco(5.00);
        arroz.setDescontoMaximo(10);

        Produto leite = new Produto(astolfo) { };
        leite.setNome("Leite");
        leite.setUnidade("L");
        leite.setDescricao("Leite integral");
        leite.setPreco(4.50);
        leite.setDescontoMaximo(5);

        ListaCompra lista = new ListaCompra(2) { };

        ItemCompra item1 = new ItemCompra(arroz, 10) { };
        item1.setQuantidade(2);

        ItemCompra item2 = new ItemCompra(leite, 0) { };
        item2.setQuantidade(3);

        lista.incluir(item1);
        lista.incluir(item2);

        System.out.println("--- Itens da lista ---");
        ItemCompra[] itens = lista.getItensCompra();
        for (int i = 0; i < itens.length; i++) {
            ItemCompra item = itens[i];
            System.out.println(item.getProduto().getNome()
                    + " (" + item.getQuantidade() + " " + item.getProduto().getUnidade() + ")"
                    + " - desconto " + item.getDesconto() + "%"
                    + " - preco: R$ " + item.calcularPreco());
        }
        System.out.println("Total da lista: R$ " + lista.calcularPreco());

        System.out.println("--- Regras de validacao ---");
        try {
            lista.incluir(new ItemCompra(arroz, 5) { });
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            new ItemCompra(leite, 50) { };
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}