package model; 

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e toString() permanecem os mesmos...
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    @Override
    public String toString() {
        return "-------------------------\n" +
               "ID: " + id + "\n" +
               "Nome: " + nome + "\n" +
               String.format("Preço: R$ %.2f", preco) + "\n" +
               "Estoque: " + quantidadeEstoque + " unidades";
    }
}