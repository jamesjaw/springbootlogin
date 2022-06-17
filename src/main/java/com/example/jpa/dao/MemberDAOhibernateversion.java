package com.example.jpa.dao;

import com.example.jpa.entity.Member;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MemberDAOhibernateversion implements MemberDAO {

    private EntityManager entityManager;

    //EntityManager auto creat by spring boot
    @Autowired
    public MemberDAOhibernateversion(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Member> findAll() {
        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        System.out.println("1");
        //HQL use java class name as table reference, not MySQL table name
        Query<Member> theQuery = currentSession.createQuery("from Member", Member.class);
        System.out.println("2");
        List<Member> members = theQuery.getResultList();

        return members;
    }

    @Override
    public String test() {
        Session currentSession = entityManager.unwrap(Session.class);
        return "test";
    }

    @Override
    public Member findById(Integer theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Member theMember = currentSession.get(Member.class, theId);
        return theMember;
    }

    @Override
    public void save(Member theMember) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theMember);
    }

    @Override
    public void deleteById(Integer theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Member where id =:memberId");
        theQuery.setParameter("memberId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public Member findByEmail(String theEmail) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Member where email =:memberEmail");
        theQuery.setParameter("memberEmail", theEmail);

        Member theMember = (Member) theQuery.uniqueResult();
        return theMember;
    }


}
