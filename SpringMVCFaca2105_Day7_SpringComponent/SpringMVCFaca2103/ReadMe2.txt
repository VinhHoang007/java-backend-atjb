Cach mang data khi di
redirect : /controller/action
    servlet : response.sendReriect 
    Spring : return "redirect:/"

+ Cách 1 : luu session : cho lưu tất cả dữ liệu// Method POST
    ++ b1 : luu session attribute
    ++ b2 : redirect :
    ++ b3 : get session attribute
    ++ b4 : remove session attribute

+ Cách 2 : luu vao URL : Chỉ cho truyền kiểu chuỗi// Method Get
    + /controller/action/abcd
    + /controller/action?abcd=123&zzz=999
    
+ Cách 3: RedirectAttributes - SpringFrameWork
  Luôn Empty khi bắt đầu action/method
  Chỉ có tác dụng khi sử dụng:
    + return "redirect:/controller"
    + return RedirectView (object)
  Có chứa:
    - Attributes : (Giống cách 2 ở trên)
        * tự add vào parameter của request ở URL target
        * set vÃ o Url
    - FlashAttributes  : (Giá»‘ng CÃ¡ch 1 á»Ÿ trÃªn)
        * tự add vào model ở URL target
        * lưu trong session short-time

        http://localhost:8080/SpringMVCFaca2103/demoredirect/receiveRedirect/Hello%20World!%20varPathVariable
        ?varRequestParam=Hello+World%21+varRequestParam&attr1=Attribute1+Value&attr2=Attribute2+Value
        
####################

@SessionAttributes  => SET => Ä‘áº·t á»Ÿ class
    => Set Attibute cá»§a Model => Attribute cÃ¹ng name cá»§a Session
@SessionAttribute => GET => Ä‘áº·t á»Ÿ Parametrer
    => Get tá»« Session ra
@ModelAttribute => SET =>  Ä‘áº·t á»Ÿ method hoáº·c Parametrer
    => Set vÃ o Attribute cá»§a Model

Method cÃ³ gáº¯n @ModelAttribute á»Ÿ Ä‘áº§u method :
    + CÃ³ tÃ¡c dá»¥ng khá»Ÿi táº¡o cÃ¡c giÃ¡ trá»‹ ban Ä‘áº§u cho Model á»Ÿ Controller Ä‘Ã³
    + NÃªn luÃ´n Ä‘Æ°á»£c cháº¡y á»Ÿ Ä‘áº§u(trÆ°á»›c) cÃ¡c method RequestMapping 