/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Cryptaro
 */
@Controller
@RequestMapping("/editerProfil.htm")
public class editionProfilController {
    public editionProfilController() {
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String init(){
        return "editerProfil";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    protected String handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return "editerProfil";
    }
}