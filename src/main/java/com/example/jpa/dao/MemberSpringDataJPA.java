package com.example.jpa.dao;

import com.example.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSpringDataJPA extends JpaRepository<Member, Integer> {
}
