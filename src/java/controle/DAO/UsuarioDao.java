package controle.DAO;

import controle.VO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDao {

    public UsuarioDao() {
    }

    public int cadastrarUsuario(Usuario usuario) {
        
        int novoId = -1;

        String query = "INSERT INTO usuario (login, senha) VALUES (?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {
            prepStmt.setString(1, usuario.getLogin());
            prepStmt.setString(2, usuario.getSenha());
            

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Produto! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;
    }

    public Usuario pesquisarUsuario(String login, String senha) {
        
        String query = "SELECT * FROM usuario WHERE login = ? and senha = ?";
        Usuario usuario = null;

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, login);
            prepStmt.setString(2, senha);
            ResultSet resultado = prepStmt.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setCodigoUsuario(resultado.getInt("codigoUsuario"));
                usuario.setCodigoSeguranca(resultado.getString("codigoSeguranca"));
                usuario.setDataValidade(resultado.getDate(3));
                usuario.setLogin(resultado.getString("login"));
                usuario.setNumeroCartao(resultado.getInt("numeroCartao"));
                usuario.setSenha(resultado.getString("senha"));
               
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Consulta de funcionarios!Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closeStatement(conn);
            ConexaoComBanco.closeConnection(conn);
        }
        return usuario;
    }  

       
}
