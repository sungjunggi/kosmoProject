package com.hrm.finalpj.service;



import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.finalpj.dto.HrmEmployeeDTO;
import com.hrm.finalpj.mapper.IHrmMapper;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberService implements UserDetailsService{
	
	private final IHrmMapper ihrmMapper;
	
	public int saveMember(HrmEmployeeDTO member) {
		validateDuplicateMember(member);
		return ihrmMapper.userSave(member);
	}
	
	private void validateDuplicateMember(HrmEmployeeDTO member) {
		HrmEmployeeDTO findMember = ihrmMapper.findByUserId(member.getEMPLOYEE_ID());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}


	@Override
	public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
		HrmEmployeeDTO member = ihrmMapper.findByUserId(employeeId);
		
		if(member == null) {
			throw new UsernameNotFoundException(employeeId);
		}
		
		return User.builder()
				.username(member.getEMPLOYEE_ID())
				.password(member.getEMPLOYEE_PASSWORD())
				.roles(member.getEMPLOYEE_ROLE())
				.build();
	}
	
//	Member principal = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
//	UserDetails userDetails = (UserDetails)principal; 
//	String name = userDetails.getUsername();
}
