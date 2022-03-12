package demo.spring.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String index(HttpSession session, Model model) {
        System.out.println("HomeController - index");
        
        String usernamelogin = (String) session.getAttribute("usernamelogin");
        String rolelogin = (String) session.getAttribute("rolelogin");
        if (!"user".equals(rolelogin)) {
            // redirect về trang login
            return "redirect:/login";
        }

        return "index";
    }
}
