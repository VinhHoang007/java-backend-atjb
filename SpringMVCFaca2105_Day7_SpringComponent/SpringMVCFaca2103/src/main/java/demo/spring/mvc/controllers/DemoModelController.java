package demo.spring.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = { "/demomodel" })
public class DemoModelController {

    @RequestMapping(path = { "/model" })
    public String testModel(Model model, HttpServletRequest request) {
        System.out.println("DemoModelController - testModel");

        model.addAttribute("attr1", "Attribute1 Value");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mapkey1", "MapKey1 Value");
        map.put("mapkey2", 123456);
        map.put("mapkey3", null);

        model.mergeAttributes(map);

        model.addAttribute("attr2", "Attribute2 Value");
        model.addAttribute("attr3", 999);
        model.addAttribute("attr4", null);

        request.setAttribute("requestAttr1", "Request Attribute1 Value");
        request.setAttribute("requestAttr2", "old value");
        request.setAttribute("requestAttr2", null);

        return "demomodel";
    }

    @RequestMapping(path = { "/modelmap" })
    public String testModelMap(ModelMap model, HttpServletRequest request) {
        System.out.println("DemoModelController - testModelMap");

        model.addAttribute("attr1", "Attribute1 Value");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mapkey1", "MapKey1 Value");
        map.put("mapkey2", 123456);
        map.put("mapkey3", null);

        model.mergeAttributes(map);

        model.addAttribute("attr2", "Attribute2 Value");
        model.addAttribute("attr3", 999);
        model.addAttribute("attr4", null);

        request.setAttribute("requestAttr1", "Request Attribute1 Value");
        request.setAttribute("requestAttr2", null);

        return "demomodel";
    }

    @RequestMapping(path = { "/modelandview" })
    public ModelAndView testModelAndView(HttpServletRequest request) {
        System.out.println("DemoModelController - testModelAndView");

        ModelAndView modelAndView = new ModelAndView(/* "demomodel" */);
        modelAndView.setViewName("demomodel");

        modelAndView.addObject("attr1", "Attribute1 Value");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mapkey1", "MapKey1 Value");
        map.put("mapkey2", 123456);
        map.put("mapkey3", null);

        modelAndView.addAllObjects(map);

        modelAndView.addObject("attr2", "Attribute2 Value");
        modelAndView.addObject("attr3", 999);
        modelAndView.addObject("attr4", null);

        request.setAttribute("requestAttr1", "Request Attribute1 Value");
        request.setAttribute("requestAttr2", null);

        return modelAndView;
    }
}
