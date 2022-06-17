package com.example.jpa.dao;

import com.example.jpa.entity.Member;

import java.util.List;

public interface MemberDAO {

    public List<Member> findAll();

    public String test();

    public Member findById(Integer theId);

    public void save(Member theMember);

    public void deleteById(Integer theId);

    public Member findByEmail(String theEmail);

}
