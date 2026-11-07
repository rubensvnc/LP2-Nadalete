package edu.fatec.lp2.exercicio2.compras;

public abstract class ItemCompra implements Calculavel {
    private int quantidade;
    private final Produto produto;
    private double desconto;

    public ItemCompra(Produto produto, double desconto) {
        if (produto == null) {
            throw new IllegalArgumentException("O item de compra precisa de um produto.");
        }
        validarDesconto(produto, desconto);
        this.produto = produto;
        this.desconto = desconto;
    }

    private static void validarDesconto(Produto produto, double desconto) {
        if (desconto < 0 || desconto > produto.getDescontoMaximo()) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e " + produto.getDescontoMaximo() + ".");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        validarDesconto(produto, desconto);
        this.desconto = desconto;
    }

    @Override
    public double calcularPreco() {
        double precoBruto = produto.getPreco() * quantidade;
        return precoBruto * (1 - desconto / 100);
    }
}