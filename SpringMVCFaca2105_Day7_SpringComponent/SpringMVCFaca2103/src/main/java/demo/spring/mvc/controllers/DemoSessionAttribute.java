package demo.spring.mvc.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("sessionattr1")
@Controller
@RequestMapping(path = { "/demosession" })
public class DemoSessionAttribute {

    @RequestMapping(path = { "/addSession" })
    public String addSession(Model model) {
        System.out.println("DemoSessionAttribute - addSession");

        model.addAttribute("sessionattr1", "Data test save Session");

        return "demosessionattribute";
    }

    @RequestMapping(path = { "/addSession2" })
    public String addSession2() {
        System.out.println("DemoSessionAttribute - addSession2");

        addToModel();

        return "demosessionattribute";
    }

    @ModelAttribute("sessionattr1")
    private String addToModel() {
        System.out.println("addToModel");
        return "Data test save Session with method";
    }

    @RequestMapping(path = { "/readSession" })
    public String readSession(@SessionAttribute(name = "sessionattr1", required = false) String dataatttr1,
            HttpSession session, Model model) {
        System.out.println("DemoSessionAttribute - readSession");

        System.out.println("dataatttr1 : " + dataatttr1);

        return "demosessionattribute";
    }

    @RequestMapping(path = { "/clearSession" })
    public String clearSession(HttpSession session, Model model,
            SessionStatus status/* , SessionAttributeStore store */) {
        System.out.println("DemoSessionAttribute - clearSession");

        // Clear Attributes of Session
        Enumeration<String> attributes = session.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = attributes.nextElement();
            session.removeAttribute(attribute);
        }
        status.setComplete();

        // Clear Session
        // session.invalidate();

        return "demosessionattribute";
    }
}
