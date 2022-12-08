/**
 * 
 */
package com.zillionsoftech.org.controller;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zillionsoftech.org.entities.Roles;
import com.zillionsoftech.org.entities.Users;
import com.zillionsoftech.org.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sandeep.rana
 *
 */
@Controller
@Slf4j
public class AuthenticationController {

	@Autowired
	private UsersService usersService;
	
	
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");
		return "authentication/login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "authentication/signup";
	}

	@PostMapping(value = "/signup")
	@ResponseBody
	public Users signUp(@RequestBody Users user, @RequestParam String role) throws NotFoundException {
		final Roles roleModel = usersService.getRole(role);
		Set<Roles> roles = new HashSet<>(); roles.add(roleModel);
		user.setRoles(roles);
		log.info("Going to sign up with username "+ user.getUserId());
		return usersService.signUp(user);		
	}

	@GetMapping("/")
	@ResponseBody
	public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) throws JsonProcessingException {
		return principal;
	}
	
	
	
}
