package edu.fatec.lp2.exercicio2.compras;

public abstract class ListaCompra implements Calculavel {
    private ItemCompra[] itensCompra;
    private int qtdeMax;

    public ListaCompra(int qtdeMax) {
        this.qtdeMax = qtdeMax;
        this.itensCompra = new ItemCompra[qtdeMax];
    }

    public void incluir(ItemCompra item) {
        for (int i = 0; i < itensCompra.length; i++) {
            if (itensCompra[i] == null) {
                itensCompra[i] = item;
                return;
            }
        }
        throw new IllegalStateException("A lista de compras atingiu o limite de " + qtdeMax + " itens.");
    }

    public ItemCompra[] getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItemCompra[] itensCompra) {
        this.itensCompra = itensCompra;
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {
        ItemCompra[] novo = new ItemCompra[qtdeMax];
        int limite = qtdeMax < itensCompra.length ? qtdeMax : itensCompra.length;
        for (int i = 0; i < limite; i++) {
            novo[i] = itensCompra[i];
        }
        this.itensCompra = novo;
        this.qtdeMax = qtdeMax;
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        for (int i = 0; i < itensCompra.length; i++) {
            if (itensCompra[i] != null) {
                total += itensCompra[i].calcularPreco();
            }
        }
        return total;
    }
}