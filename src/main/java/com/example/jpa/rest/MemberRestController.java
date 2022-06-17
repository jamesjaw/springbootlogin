package com.example.jpa.rest;

import com.example.jpa.dao.MemberDAO;
import com.example.jpa.entity.Member;
import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberRestController {

    private MemberService memberService;

    @Autowired
    public MemberRestController(MemberService theMemberService) {
        memberService = theMemberService;
    }

    @GetMapping("/member")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/member/{memberId}")
    public Member findById(@PathVariable Integer memberId) {

        Member theMember = memberService.findById(memberId);

        if(theMember == null) {
            throw new RuntimeException("memberId: " + memberId + "not find!!!");
        }

        return theMember;
    }

    @PostMapping("/member")
    public Member addMember(@RequestBody Member theMember) {
        // if not hava key then save otherwise update because I use saveOrUpdate()
        theMember.setId(null);
        memberService.save(theMember);

        return theMember;
    }

    @PutMapping("/member")
    public Member updateMember(@RequestBody Member theMember) {
        // if not hava key then save otherwise update because I use saveOrUpdate()
        memberService.save(theMember);

        return theMember;
    }

    @DeleteMapping("/member/{memberId}")
    public String deleteMember(@PathVariable Integer memberId) {

        Member theMember = memberService.findById(memberId);

        if(theMember == null) {
            return "member(" + memberId + ") not find!!!";
        }

        memberService.deleteById(memberId);

        return "member(" + memberId + ") has deleted!!!";
    }




}
