/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.integracao;

import controle.VO.Usuario;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author 80119050
 */
public class UsuarioDAOXML {
    
        
  public String serializaParaXML(ArrayList<Usuario> usuarios) {
        String xmlContent="";
        System.out.println(usuarios);
        try{
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(Usuario.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(usuarios, sw);
            xmlContent = sw.toString();
        }catch(JAXBException e){
            
        }
        System.out.println(xmlContent);
        return xmlContent;
    }
    
}
