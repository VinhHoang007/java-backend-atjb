package demo.spring.mvc.controllers;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path = { "/demoredirect" })
public class DemoRedirect {

    // Return Redirect Object
    @RequestMapping(path = { "/sendRedirect" })
    public RedirectView sendRedirect(Model model, RedirectAttributes redirectAttrs) {
        System.out.println("DemoRedirect - sendRedirect");

        redirectAttrs.addAttribute("varPathVariable", "Hello World! varPathVariable");
        redirectAttrs.addAttribute("varRequestParam", "Hello World! varRequestParam");
        redirectAttrs.addAttribute("attr1", "Attribute1 Value");
        redirectAttrs.addAttribute("attr2", "Attribute2 Value");

        redirectAttrs.addFlashAttribute("flashattr1", "Flash Attribute1 Value");
        redirectAttrs.addFlashAttribute("flashattr2", "Flash Attribute2 Value");

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/demoredirect/receiveRedirect/{varPathVariable}");

        return redirectView;
    }

    // Return Redirect String
    @RequestMapping(path = { "/sendRedirect1" })
    public String sendRedirect1(Model model, RedirectAttributes redirectAttrs) {
        System.out.println("DemoRedirect - sendRedirect1");

        redirectAttrs.addAttribute("varPathVariable", "Hello World! varPathVariable");
        redirectAttrs.addAttribute("varRequestParam", "Hello World! varRequestParam");
        redirectAttrs.addAttribute("attr1", "Attribute1 Value");
        redirectAttrs.addAttribute("attr2", "Attribute2 Value");

        redirectAttrs.addFlashAttribute("flashattr1", "Flash Attribute1 Value");
        redirectAttrs.addFlashAttribute("flashattr2", "Flash Attribute2 Value");

        return "redirect:/demoredirect/receiveRedirect/{varPathVariable}";
    }

    @RequestMapping(path = { "/receiveRedirect/{data}", "/receiveRedirect" })
    public String receiveRedirect(Model model, RedirectAttributes redirectAttrs, HttpServletRequest request
            , @PathVariable(name = "data", required = false) String dataReceive
            , String attr2
            , @RequestParam(name= "attr2", required = false) String requestParamAttr2
            ) {
        System.out.println("DemoRedirect - receiveRedirect");
        
        System.out.println("dataReceive : " + dataReceive);
        System.out.println("attr2 : " + attr2);
        System.out.println("requestParamAttr2 : " + requestParamAttr2);
        System.out.println("request.getParameter(\"attr2\") : " + request.getParameter("attr2"));

        System.out.println("== RedirectAttrs Data - Start ==");
        Map<String, Object> mapRedirectAttrs = redirectAttrs.asMap();
        for (String key : mapRedirectAttrs.keySet()) {
            System.out.println(key + " : " + mapRedirectAttrs.get(key));
        }
        System.out.println("== RedirectAttrs Data - End ==");

        System.out.println("== RedirectAttrs FlashAttributes Data - Start ==");
        Map<String, ?> mapRedirectAttrsFlashAttributes = redirectAttrs.getFlashAttributes();
        for (String key : mapRedirectAttrsFlashAttributes.keySet()) {
            System.out.println(key + " : " + mapRedirectAttrsFlashAttributes.get(key));
        }
        System.out.println("== RedirectAttrs FlashAttributes Data - End ==");

        System.out.println("== Model Data - Start ==");
        // Flash Attribute binding to model
        Map<String, Object> mapModel = model.asMap();
        for (String key : mapModel.keySet()) {
            System.out.println(key + " : " + mapModel.get(key));
        }
        System.out.println("== Model Data - End ==");
        
        System.out.println("=== Request data - Start ===");
        Enumeration<String> reqEnum = request.getParameterNames();
        while (reqEnum.hasMoreElements()) {
            String s = reqEnum.nextElement();
            System.out.println(s + " : " + request.getParameter(s));
        }
        System.out.println("=== Request data - End ===");

        return "demoredirect";
    }
}
