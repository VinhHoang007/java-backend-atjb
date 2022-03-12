package demo.spring.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.dtos.DemoSpringValidationDTO;

@Controller
@RequestMapping(path = { "/demovalidation" })
public class DemoValidationController {

    @RequestMapping(path = { "/", "/index" }, method = RequestMethod.GET)
    public String show(Model model) {
        System.out.println("DemoValidationController - show");

        model.addAttribute("dto", new DemoSpringValidationDTO());
        return "demovalidation";
    }

    @RequestMapping(path = { "/", "/index" }, method = RequestMethod.POST)
    public String check(@Validated @ModelAttribute("dto") DemoSpringValidationDTO dto, BindingResult rs) {
        System.out.println("DemoValidationController - check");

        FieldError objectError = new FieldError("dto", "name1", "Lỗi add thêm");
        rs.addError(objectError);

        return "demovalidation";
    }
}
