package controle.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controle.VO.Item;
import controle.VO.Usuario;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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

    public Item pesquisarItem(String descricao) {
        
        String query = "SELECT * FROM item WHERE descricao = ?";
        Item item = null;

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, '%' +descricao +'%');
            
            ResultSet resultado = prepStmt.executeQuery();

            while (resultado.next()) {
                item = new Item();

                item.setCodigoItem(resultado.getInt("codigoItem"));
                item.setDescricao(resultado.getString("descricao"));
                item.setDetalhes(resultado.getString("detalhes"));
                item.setNome(resultado.getString("nome"));
                item.setValor(resultado.getDouble("valor"));
               
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Consulta de funcionarios!Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closeStatement(conn);
            ConexaoComBanco.closeConnection(conn);
        }
        return item;
    }
    
    public ArrayList<Usuario> listarTodosOsUsuarios() {
       
        Usuario usuario;
        String query = "select * from usuario";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            ResultSet resultado = prepStmt.executeQuery(query);

            while (resultado.next()) {

               usuario = new Usuario();
               
               usuario.setCodigoUsuario(resultado.getInt(1));
               usuario.setCodigoSeguranca(resultado.getString("codigoSeguranca"));
               usuario.setDataValidade(resultado.getDate(3));
               usuario.setLogin(resultado.getString("login"));
               usuario.setNumeroCartao(resultado.getInt("numeroCartao"));
               usuario.setSenha(resultado.getString("senha"));
               

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
       
}
