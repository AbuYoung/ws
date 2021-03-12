package com.abu.ws.controller;

import com.abu.ws.result.Result;
import com.abu.ws.pojo.User;
import com.abu.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@PostMapping(value = "/api/login")
	@ResponseBody
	// 对 html 标签进行转义，防止 XSS 攻击
	public Result login(@RequestBody User requestUser, HttpSession session) {
		String username = requestUser.getUsername();
		username = HtmlUtils.htmlEscape(username);

		User user = userService.get(username, requestUser.getPassword());
		if (null == user) {
			return new Result(400);
		} else {
			session.setAttribute("user", user);
			return new Result(200);
		}
	}
}
