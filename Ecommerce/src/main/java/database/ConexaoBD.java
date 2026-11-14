package database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Abstração da fonte de conexões, para permitir trocar o banco ou usar um
 * banco de testes sem alterar os DAOs.
 */
public interface ConexaoBD {

    Connection obterConexao() throws SQLException;

    void fecharConexao(Connection conexao);
}
