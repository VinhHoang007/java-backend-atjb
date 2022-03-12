package demo.spring.mvc.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.entities.UserEntity;
import demo.spring.mvc.services.UserService;

@Controller
@RequestMapping(path = { "/admin/user" })
public class UserController {
	public UserController() {
		System.out.println("UserController");
	}

	@Autowired
	UserService userService;

	@RequestMapping(path = { "/list" }, method = { RequestMethod.GET })
	public String showList(HttpServletRequest req) {
		// Load data
		List<UserEntity> data = userService.FindAll();

		// set data for view
		req.setAttribute("data", data);

		return "admin/user/list"; // /WEB-INF/views/admin/user/list.jsp
	}

	@RequestMapping(path = { "/add" }, method = { RequestMethod.GET })
	public String showAdd() {
		// show form
		return "admin/user/add";
	}

	@RequestMapping(path = { "/add" }, method = { RequestMethod.POST })
	public String execAdd(HttpServletRequest req) {
		// Recive Data from FORM => Add DB
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		// validate du lieu

		if (checkAdd()) {
			// validate da hop le
//			UserService userService = new UserService();
			userService.Add(username, password, email);
			// Di chuyen ve man hinh list
			return "redirect:" + "/admin/user/list";
		} else {
			// Di chuyen lai man hinh add nhap lai
			return "admin/user/add";
		}
	}

	private static boolean checkAdd() {
		return true;
	}

	private static boolean checkEdit() {
		return true;
	}

	@RequestMapping(path = { "/edit" }, method = { RequestMethod.GET })
	public String showEdit(HttpServletRequest req) {

		String id = req.getParameter("id");
		if (id == null || "".equals(id)) {

		} else {
			try {
				int userId = Integer.parseInt(id);

				// show form

				UserEntity data = userService.FindOne(userId);
				System.out.println(data);
				if (data != null) {
					req.setAttribute("data", data);
					return "admin/user/edit";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return "redirect:" + "/admin/user/list";
	}

	@RequestMapping(path = { "/edit" }, method = { RequestMethod.POST })
	public String execEdit(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (id == null || "".equals(id)) {

		} else {
			try {
				int userId = Integer.parseInt(id);

				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String email = req.getParameter("email");

				// Validate data
				if (checkEdit()) {
					// validate da hop le
					userService.Update(userId, username, password, email);
				} else {
					// Di chuyen lai man hinh add nhap lai
					return "admin/user/edit";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return "redirect:" + "/admin/user/list";
	}

	@RequestMapping(path = { "/delete" }, method = { RequestMethod.GET })
	public String execDelete(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (id == null || "".equals(id)) {

		} else {
			try {
				int userId = Integer.parseInt(id);

				boolean result = userService.Delete(userId);
			} catch (Exception e) {
			}
		}
		return "redirect:"+ "/admin/user/list";
	}

	@RequestMapping(path = { "/logout" }, method = { RequestMethod.GET })
	public String logout() {
		return "logout";
	}
}
