package com.joyzone.platform.module.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyzone.platform.common.utils.R;

/**
 * Description:TODO
 *
 * @author Mr.Gx
 * date: 2019/3/29
 */
@RestController
@RequestMapping("/frontUser")
public class AppUserController {
	
	@PostMapping("/login")
	public R login() {
		
		
		return null;
	}
}
