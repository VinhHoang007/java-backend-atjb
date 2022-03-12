package demo.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.dtos.DemoSpringFormDTO;

@Controller
@RequestMapping(path = { "demospringform" })
public class DemoSpringForm {

    @RequestMapping(path = { "/form", "/showform" }, method = { RequestMethod.GET })
    public String showForm(Model model) {
        System.out.println("DemoSpringForm - showForm");

        model.addAttribute("dto", new DemoSpringFormDTO());

        return "demospringform";
    }

    @RequestMapping(path = { "/form", "/receiveform" }, method = { RequestMethod.POST })
    public String receiveForm(Model model, @ModelAttribute(name = "dto") DemoSpringFormDTO formDTO) {
        System.out.println("DemoSpringForm - receiveForm");

        System.out.println(formDTO);
        // model.addAttribute("dto", formDTO); <==> @ModelAttribute(name = "dto")
        
        return "demospringform";
    }
}
