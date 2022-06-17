package com.example.jpa.service;

import com.example.jpa.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(Integer theId);

    void save(Member theMember);

    void deleteById(Integer theId);

    Member findByEmail(String theEmail);

}
