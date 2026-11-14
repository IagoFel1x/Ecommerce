package model;

import database.ConexaoBD;
import database.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO {

    private static final String SQL_TODOS = "SELECT id, nome, preco, quantidade_estoque FROM produtos ORDER BY id";
    private static final String SQL_POR_ID = "SELECT id, nome, preco, quantidade_estoque FROM produtos WHERE id = ?";

    private final ConexaoBD conexaoBD;

    public ProdutoDAO() {
        this(new ConexaoMySQL());
    }

    public ProdutoDAO(ConexaoBD conexaoBD) {
        this.conexaoBD = conexaoBD;
    }

    public List<Produto> buscarTodos() {
        List<Produto> produtos = new ArrayList<>();

        try (Connection conexao = conexaoBD.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(SQL_TODOS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                produtos.add(mapear(rs));
            }
        } catch (SQLException e) {
            System.err.println("Falha ao consultar os produtos: " + e.getMessage());
        }

        return produtos;
    }

    public Optional<Produto> buscarPorId(int id) {
        try (Connection conexao = conexaoBD.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(SQL_POR_ID)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapear(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Falha ao buscar o produto " + id + ": " + e.getMessage());
        }
        return Optional.empty();
    }

    private static Produto mapear(ResultSet rs) throws SQLException {
        return new Produto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getBigDecimal("preco"),
                rs.getInt("quantidade_estoque"));
    }
}
