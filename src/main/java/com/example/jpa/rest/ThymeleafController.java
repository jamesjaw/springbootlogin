package com.example.jpa.rest;


import com.example.jpa.entity.Member;
import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ThymeleafController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/homepage")
    public String homepage (Model theModel) {
        theModel.addAttribute("theDate",new Date());
        return "homepage";
    }
    @GetMapping("/")
    public String index (@AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal);
        System.out.println((String) principal.getAttribute("sub"));
        String email = (String)principal.getAttribute("email");
        System.out.println(email);
        Member theMember = memberService.findByEmail(email);

        if(theMember != null){
            System.out.println("find");
            return "yes";
        }
        else{
            System.out.println("not find");
            return "no";
        }

    }
}
