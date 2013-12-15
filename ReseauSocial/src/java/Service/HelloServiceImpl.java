/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.InfoDAO;
import DAO.InfoEntity;
import DAO.UtilisateurDAO;
import DAO.UtilisateurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ctran
 */
@Service("HelloService")
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UtilisateurDAO u_dao; 
    
    public void inscrire(String login, String pwd){
       UtilisateurEntity u = new UtilisateurEntity();
       u.setLogin(login);
       u.setPwd(pwd);
       u_dao.save(u);
    }
    
    /*@Autowired
    private InfoDAO u_dao; 
    
    public void saveHello(String name){
       InfoEntity u = new InfoEntity();
       u.setNom(name);
       u_dao.save(u);
    }
    */
    
}
