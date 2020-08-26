package com.DungDV13.ApiCinemaFpt.controller;

import com.DungDV13.ApiCinemaFpt.security.services.UserPrinciple;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('CUSTOMER')")
	public String userAccess() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return username;
	}

	@GetMapping("/api/test/pm")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	@PreAuthorize("hasAnyRole('CUSTOMER', 'ADMIN')") // cái trên tương đương <==
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}

	@GetMapping("/api/test/user2")
	public String userAccess2() {
		return ">>> User Contents 2!";
	}

}