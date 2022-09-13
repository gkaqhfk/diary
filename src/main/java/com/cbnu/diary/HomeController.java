package com.cbnu.diary;

import com.cbnu.diary.util.AuthenticationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

	@GetMapping
	public String home(Authentication authentication) {
		if (AuthenticationUtils.isAdmin(authentication)) {
			log.info("admin info: {}", authentication);
		}
		return "home";
	}
	
}
