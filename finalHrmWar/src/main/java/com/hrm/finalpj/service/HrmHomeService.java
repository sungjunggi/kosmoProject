package com.hrm.finalpj.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.finalpj.dto.HrmEmployeeDTO;
import com.hrm.finalpj.dto.HrmEmployeePrincipalVO;
import com.hrm.finalpj.mapper.IHrmMapper;

@Service
public class HrmHomeService implements UserDetailsService{

	@Autowired
	private IHrmMapper homeMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/* DB에서 유저정보를 불러온다.
	 * Custom한 Userdetails 클래스를 리턴 해주면 된다.
	 * */
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		ArrayList<HrmEmployeeDTO> userAuthes = homeMapper.findByUserId(id);
		
		if(userAuthes.size() == 0) {
			throw new UsernameNotFoundException("User "+id+" Not Found!");
		}
		
		return new HrmEmployeePrincipalVO(userAuthes);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public String InsertUser(HrmEmployeeDTO userVO) {
		
		userVO.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
		int flag = homeMapper.userSave(userVO);		
		if (flag > 0) {

			int userNo = homeMapper.findUserNo(userVO.getId());
			int roleNo = homeMapper.findRoleNo(userVO.getRoleName());

			homeMapper.userRoleSave(userNo, roleNo);

			return "success";
		}	 	
		return "fail";
	}

}