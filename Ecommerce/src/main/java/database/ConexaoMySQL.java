package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexão com o MySQL. As credenciais vêm de variáveis de ambiente, para que
 * nenhuma senha fique gravada no código-fonte:
 *
 * <ul>
 *   <li>{@code ECOMMERCE_DB_URL} (padrão: jdbc:mysql://localhost:3306/ecommerce)</li>
 *   <li>{@code ECOMMERCE_DB_USER} (padrão: root)</li>
 *   <li>{@code ECOMMERCE_DB_PASSWORD} (padrão: vazia)</li>
 * </ul>
 */
public class ConexaoMySQL implements ConexaoBD {

    private static final String URL_PADRAO = "jdbc:mysql://localhost:3306/ecommerce";

    private final String url;
    private final String usuario;
    private final String senha;

    public ConexaoMySQL() {
        this(lerVariavel("ECOMMERCE_DB_URL", URL_PADRAO),
             lerVariavel("ECOMMERCE_DB_USER", "root"),
             lerVariavel("ECOMMERCE_DB_PASSWORD", ""));
    }

    public ConexaoMySQL(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    private static String lerVariavel(String nome, String padrao) {
        String valor = System.getenv(nome);
        return (valor == null || valor.isBlank()) ? padrao : valor;
    }

    @Override
    public Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    @Override
    public void fecharConexao(Connection conexao) {
        if (conexao == null) {
            return;
        }
        try {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
