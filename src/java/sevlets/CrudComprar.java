package sevlets;

import controle.DAO.UsuarioDao;
import controle.VO.Usuario;
import controle.integracao.UsuarioDAOJSON;
import controle.integracao.UsuarioDAOXML;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrudComprar extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        UsuarioDao usuarioDao = new UsuarioDao ();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = usuarioDao.listarTodosOsUsuarios();  
        
        if(usuarios.isEmpty()){
             response.setStatus(500);  
        }else{
            response.setStatus(200);
            UsuarioDAOJSON usuarioDAOJSON;
            UsuarioDAOXML usuarioDAOXML;
            String responseFormat=request.getHeader("accept");
            //System.out.println(" O accept é: " +responseFormat);
                      
           if(responseFormat != null && responseFormat.equals("JSON")){
               response.setContentType("application/json;charset=UTF-8");
               usuarioDAOJSON = new UsuarioDAOJSON();
               usuarioDAOJSON.serializaParaJSON(usuarios);
                        
           }else{
               response.setContentType("text/xml;charset=UTF-8");
               usuarioDAOXML = new UsuarioDAOXML();
               PrintWriter out = response.getWriter();
               out.print(usuarioDAOXML.serializaParaXML(usuarios));
               
           }            
           
        }
        
        
        

        //String usuarioAutenticado = (String) request.getSession().getAttribute("user");
      
//        if (usuarioAutenticado != null) {
//            Usuario user = new Usuario();
//            UsuarioDao userDao = new UsuarioDao();
//            userDao.pesquisarUsuario(user.getLogin(), user.getSenha());
//            
//            System.out.println(userDao.pesquisarUsuario(user.getLogin(), user.getSenha()));
//
//        }else{
//            System.out.println("Usuário não foi autenticado!");
        }
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        RepositorioAlunoList rep= new RepositorioAlunoList();
//        List<Aluno> lista=rep.getLista();
//        
//        String nome=request.getParameter("nome");
//        String matricula=request.getParameter("matricula");
//        String email=request.getParameter("email");
//        
//        Aluno a = new Aluno();
//        a.setNome(nome);
//        a.setMatricula(matricula);
//        a.setEmail(email);
//        
//        lista.add(a);
//        DAOAluno daoAluno;
//        String responseFormat=request.getHeader("accept");
//        if(responseFormat !=null && responseFormat.equals("JSON")){
//            response.setContentType("application/json;charset=UTF-8");
//            daoAluno= new DAOAlunoJSON();
//        }else{
//            response.setContentType("text/xml;charset=UTF-8");
//            daoAluno= new DAOAlunoXML();
//        }
//           response.setStatus(200);  
//           PrintWriter out = response.getWriter();
//           out.print(daoAluno.serializa(rep));
        }    
        
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}

