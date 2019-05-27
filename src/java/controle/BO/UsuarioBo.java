/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.BO;

import controle.DAO.UsuarioDao;
import controle.VO.Item;
import controle.VO.Usuario;

/**
 *
 * @author 80119050
 */
public class UsuarioBo {
    
    UsuarioDao usuarioDao;
    Item item;
    public int cadastrarUsuario(Usuario usuario) {
        usuarioDao = new UsuarioDao(); 
        

        int novoId;

        if (usuarioDao.pesquisarUsuario(usuario.getLogin(), usuario.getSenha()) != null) {

            novoId = 0;
        } else {
            novoId = usuarioDao.cadastrarUsuario(usuario);
        }

        return novoId;
    }
  
    public Usuario validarUsuario(Usuario usuario) {
       
       usuarioDao = new UsuarioDao ();
      
        if(usuarioDao.pesquisarUsuario(usuario.getLogin(), usuario.getSenha()) == null){
            return null;
            } else {return usuario;}
    }

    public Item pesquisarItem(String descricao) {
        item = new Item();
        if(usuarioDao.pesquisarItem(descricao) == null){
            return null;
        }else {return item;}
        
    }
    
}
