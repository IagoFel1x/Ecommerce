package database; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL implements ConexaoBD {

    private static final String NOME_BANCO = "ecommerce";
    private static final String USUARIO = "iago";
    private static final String SENHA = "i@go651"; 
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/" + NOME_BANCO;

    @Override
    public Connection obterConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("O driver JDBC do MySQL não foi encontrado.", e);
        }
        return DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
    }

    @Override
    public void fechaConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar fechar a conexão: " + e.getMessage());
        }
    }
}