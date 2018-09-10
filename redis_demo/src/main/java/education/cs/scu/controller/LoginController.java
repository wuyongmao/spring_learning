 package education.cs.scu.controller;
import education.cs.scu.entity.User;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author yongmao.wu
 * @since 2018年8月22日
 */
@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public ModelAndView userLogin(HttpServletRequest request, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		User user = new User(userName, password);
		System.out.println(userName);
		// 判断是否登陆成功
		if (loginService.doUserLogin(request, user)) {
			return new ModelAndView("login");
		} else
			return new ModelAndView("loginFailed");
	}

	/**
	 * Redis 缓存 查询
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(HttpServletRequest request, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		User user = new User(userName, password);
		System.out.println(userName);

		return loginService.getUser(user);
	}

	/**
	 * 清除Redis缓存
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	@ResponseBody
	public User updateUser(HttpServletRequest request, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		User user = new User(userName, password);
		System.out.println(userName);

		return loginService.updateUser(user);
	}

	/**
	 * 清除Redis缓存
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	@ResponseBody
	public int deleteUser(HttpServletRequest request, @RequestParam(value = "userName") String userName)
			throws Exception {
		User user = new User(userName);
		System.out.println(userName);

		return loginService.deleteUser(user);
	}

	@RequestMapping(value = "/userRegist", method = RequestMethod.GET)
	public void userRegist(HttpServletRequest request, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "nickName") String nickName)
			throws Exception {
		User user = new User(userName, password, nickName);
		System.out.println(userName);
		loginService.doUserRegist(user);
	}

	@RequestMapping(value = "/clickRegist", method = RequestMethod.GET)
	public ModelAndView clickRegist() throws Exception {
		// regist 为jsp文件名
		return new ModelAndView("regist");
	}
}
