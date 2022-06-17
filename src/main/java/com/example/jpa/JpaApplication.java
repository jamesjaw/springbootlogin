package com.example.jpa;

import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@Controller
public class JpaApplication extends WebSecurityConfigurerAdapter {
	@Autowired
	private MemberService memberService;

	@GetMapping("/user")
	public String user(@AuthenticationPrincipal OAuth2User principal) {
		System.out.println(principal.toString());

		return "yes";
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
//				.authorizeRequests(a -> a
//						.antMatchers("/", "/error", "/webjars/**","/homepage","/no","yes","/user","/api/member/**").permitAll()
//						.anyRequest().authenticated()
//				).logout(l -> l
//						.logoutSuccessUrl("/").permitAll()
//				).csrf(c -> c
//						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				)
//				.exceptionHandling(e -> e
//						.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//				)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.oauth2Login()
				.and()
				.formLogin()
				
		;
		// @formatter:on

	}

}
