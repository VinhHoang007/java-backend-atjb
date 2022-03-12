package demo.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = { "/demorequestparam" })
public class DemoRequestParam {

    @RequestMapping(path = { "/demorequired" })
    public String demoRequired(
            @RequestParam(name = "param1") String valueParam1
            , @RequestParam(name= "param2") String valueParam2) {
        System.err.println("DemoRequestParam - demoRequired");

        System.out.println("Param1 : " + valueParam1);
        System.out.println("Param2 : " + valueParam2);
        
        return "other";
    }

    @RequestMapping(path = { "/demooptionalwithattribute" })
    public String demoOptionalWithAttribute(
            @RequestParam(name = "param1", required = false) String valueParam1
            , @RequestParam(name="param2", required = false) String valueParam2) {
        System.err.println("DemoRequestParam - demoRequired");

        System.out.println("Param1 : " + valueParam1);
        System.out.println("Param2 : " + valueParam2);
        
        return "other";
    }

    @RequestMapping(path = { "/demooptionalwithclassoptional" })
    public String demoOptionalWithClassOptional(
            @RequestParam(name = "param1") java.util.Optional<String> valueParam1
            , @RequestParam(name="param2", required = true) java.util.Optional<String> valueParam2) {
        System.err.println("DemoRequestParam - demoRequired");

        System.out.println("Param1 : " + (valueParam1.isPresent() ? valueParam1.get() : null) );
        System.out.println("Param2 : " + (valueParam2.isPresent() ? valueParam2.get() : null));
        System.out.println("Param2 : " + (valueParam2.orElseGet(() -> null)));
        System.out.println("Param2 : " + (valueParam2.orElse(null)));
        
        return "other";
    }
}
