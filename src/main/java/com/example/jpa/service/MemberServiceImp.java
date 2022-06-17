package com.example.jpa.service;

import com.example.jpa.dao.MemberDAO;
import com.example.jpa.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService{
    private MemberDAO memberDAO;

    @Autowired
    public MemberServiceImp (MemberDAO theMemberDAO) {
        memberDAO = theMemberDAO;
    }

    @Override
    @Transactional
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    @Transactional
    public Member findById(Integer theId) {
        return memberDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Member theMember) {
        memberDAO.save(theMember);
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        memberDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public Member findByEmail(String theEmail) {
        return memberDAO.findByEmail(theEmail);
    }


}
