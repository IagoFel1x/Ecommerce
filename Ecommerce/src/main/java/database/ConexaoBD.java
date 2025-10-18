package database; 

import java.sql.Connection;


public interface ConexaoBD {
    
    Connection obterConexao() throws Exception;
    
    void fechaConexao(Connection conexao);
}