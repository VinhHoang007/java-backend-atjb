Đây là Project SpringMVC version 5.0
Demo với màn hình Login
=> Nếu thành công sẽ di chuyển tới home của User hoặc home của Admin phụ thuộc account

#####################################
1. Tạo project web-app

2. Chỉnh sửa pom.xml => Update Maven
    2.1. chỉnh java version
    2.2. Add/Remove các thư viện cần thiết
    
3. Chỉnh version dynamicweb (Nếu muốn)
    3.1. Mở folder chứa project
    3.2. vào folder .setting
    3.3. chỉnh sửa trong file org.eclipse.wst.common.project.facet.core.xml

4. Add Runtime (Tomcat, ...)
    Đường dẫn Project => Properties => Project facets => Rumtimes => Chọn loại phù hợp

5. Config DispatcherServlet (Spring) : nằm ở web.xml
    5.1. define servlet
    5.2. mapping path
    5.3. Tạo file [-servlet.xml] tương ứng với các servlet đã định nghĩa
        5.3.1. Khai báo component-scan bằng : context:component-scan
        5.3.2. Kích hoạt @autowired  bằng : context:annotation-config
        5.3.3.
        
6. Tạo các Controllers | Services | Repositories cần thiết
    6.1. Ở Controller : Tạo các method để Handle RequestMapping
    6.2. Ở Services : tạo các method để xử lý business
    6.2. Ở Repositories : tạo các method để tương tác DB

7. Tạo ra các View
    Đường dẫn View phụ thuộc vào bean viewResolver

Bước cuối cùng:
    Run On Server
