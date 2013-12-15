/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 * @author ctran
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Service.HelloService;
import Service.UtilisateurService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index.htm")
public class HelloController{
   /*
    @Autowired
    HelloService
    UtilisateurService s;
    */
    @Autowired
    HelloService s;
    
        public HelloController() {
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String init()
    {
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
         
        ModelAndView mv = new ModelAndView("wellcome"); // va chercher page wellcome.jsp 
        String pwd = request.getParameter("pwd");
        String log = request.getParameter("log");
        String result = "Vous avez ete inscrit " + log;
        //s.saveHello(nom);
        s.inscrire(log, pwd);
        mv.addObject("wellcomeMessage", result);
        
        return mv;
    }
}