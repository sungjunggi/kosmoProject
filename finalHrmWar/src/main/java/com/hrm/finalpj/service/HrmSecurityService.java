//package com.hrm.finalpj.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import com.hrm.finalpj.dto.HrmEmployeeDTO;
//import com.hrm.finalpj.dto.HrmEmployeePrincipalVO;
//import com.hrm.finalpj.mapper.IHrmMapper;
//
//@Service
//public class HrmSecurityService implements UserDetailsService{
//	
//	@Autowired
//	private IHrmMapper homeMapper;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	//DB에서 유저정보를 불러온다. Custom한 Userdetails 클래스를 리턴 해주면 된다.(실질적인 로그인코드)
//	@Override
//	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//		System.out.println("id : "+id);
//		ArrayList<HrmEmployeeDTO> userAuthes = homeMapper.findByUserId(id);
//		System.out.println("userAuthes size : "+userAuthes.size());
//		
//		if(userAuthes.size() == 0) {
//			throw new UsernameNotFoundException("User "+id+" Not Found!");
//		}
//		
//		return new HrmEmployeePrincipalVO(userAuthes);
//	}
//	
//    //회원가입도중 오류가 날수 있으므로 transactional을 사용합니다 모르면 구글갓에게 물어봅시다
//	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
//	public String InsertUser(HrmEmployeeDTO userVO) throws Exception {
//		userVO.setUserPass(bCryptPasswordEncoder.encode(userVO.getUserPass()));
//		int flag = homeMapper.signup(userVO);	
//		System.out.println("flag num : "+flag);
//		
//		if (flag > 0) {
//			userVO.setRoleName("USER");
//			int roleNo = homeMapper.findRoleNo(userVO.getRoleName());
//			System.out.println("roleNo : "+roleNo);
//			String id = userVO.getUserId();
//			homeMapper.userRoleSave(id, roleNo);
//
//			return "success";
//		}	 	
//		return "fail";
//	}
//
//
//}