package model;

import java.math.BigDecimal;

public class Produto {

    private final int id;
    private final String nome;
    private final BigDecimal preco;
    private final int quantidadeEstoque;

    public Produto(int id, String nome, BigDecimal preco, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco == null ? BigDecimal.ZERO : preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "-------------------------\n"
                + "ID: " + id + "\n"
                + "Nome: " + nome + "\n"
                + String.format("Preço: R$ %.2f", preco) + "\n"
                + "Estoque: " + quantidadeEstoque + " unidades";
    }
}
