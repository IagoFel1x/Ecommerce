package model;

import database.ConexaoMySQL; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    
    public List<Produto> buscarTodos() {
        List<Produto> listaDeProdutos = new ArrayList<>();
        String sqlQuery = "SELECT id, nome, preco, quantidade_estoque FROM produtos";
        ConexaoMySQL fabricaDeConexoes = new ConexaoMySQL();

        try (Connection conexao = fabricaDeConexoes.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sqlQuery);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int estoque = rs.getInt("quantidade_estoque");
                
                Produto produto = new Produto(id, nome, preco, estoque);
                listaDeProdutos.add(produto);
            }
        } catch (Exception e) {
            System.err.println("Falha ao consultar os produtos no banco de dados.");
            System.err.println("Motivo: " + e.getMessage());
            e.printStackTrace();
        }
        
        return listaDeProdutos;
    }
}