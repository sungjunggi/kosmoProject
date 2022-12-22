package com.hrm.finalpj.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
}
