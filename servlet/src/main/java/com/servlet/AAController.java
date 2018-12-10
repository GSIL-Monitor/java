package com.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */

@Controller
public class AAController {

	@RequestMapping("/aa")
	public String  go() {
		return "/Notes.html";
	}
}
