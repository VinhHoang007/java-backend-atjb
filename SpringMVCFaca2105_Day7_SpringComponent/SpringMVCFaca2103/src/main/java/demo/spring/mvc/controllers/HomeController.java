package demo.spring.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.dtos.HomeListItemDTO;
import demo.spring.mvc.services.HomeService;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(path = { "/index", "/home/index" }, method = { RequestMethod.GET })
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping(path = { "/hello", "/home/hello" }, method = { RequestMethod.GET })
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping(path = { "/list" }, method = { RequestMethod.GET })
    public String list(HttpServletRequest request) {
        System.out.println("list");

        List<HomeListItemDTO> data = homeService.loadData();

        request.setAttribute("data", data);

        return "list";
    }

    @RequestMapping(path = { "/list2" }, method = { RequestMethod.GET })
    public String list(Model model) {
        System.out.println("list2");

        List<HomeListItemDTO> data = homeService.loadData();

        model.addAttribute("data", data);

        return "list";
    }
}
