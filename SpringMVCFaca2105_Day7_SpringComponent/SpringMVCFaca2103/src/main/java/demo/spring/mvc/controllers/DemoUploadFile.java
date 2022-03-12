package demo.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
// @MultipartConfig // https://www.dev2qa.com/spring-mvc-file-upload-unable-to-process-parts-as-no-multi-part-configuration-has-been-provided/
@RequestMapping(path = { "/demouploadfile" })
public class DemoUploadFile {

    @RequestMapping(path = { "/show" })
    public String show() {
        return "demouploadfile";
    }
    
    @ModelAttribute(name = "addattr1")
    private String methodModelAttribute(Model model) {
        model.addAttribute("addattr2", "Content 2");
        
        return "Content addattr1";
    }

    @RequestMapping(path = { "/receive" }, method = { RequestMethod.POST })
    public String receive(@RequestParam(name = "fileUpload1", required = false) MultipartFile fileUpload1,
            @RequestParam(name = "data1", required = false) String data1) {

        System.out.println("fileUpload1 : " + fileUpload1);
        System.out.println("data1 : " + data1);
        return "demouploadfile";
    }
}
