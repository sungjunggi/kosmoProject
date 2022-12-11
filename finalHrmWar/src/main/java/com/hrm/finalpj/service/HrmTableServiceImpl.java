//package com.hrm.finalpj.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.hrm.finalpj.dto.HrmEmployeeDTO;
//import com.hrm.finalpj.dto.HrmEmployeePrincipalVO;
//import com.hrm.finalpj.mapper.IHrmMapper;
//
//@Service
//public class HrmTableServiceImpl implements IHrmTableService, UserDetailsService{
//
//	@Autowired
//	IHrmMapper ihrmMapper;
//	
//
//    
//    @Override
//	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//		
//        //DB로부터 회원 정보를 가져온다.
//		ArrayList<HrmEmployeeDTO> userAuthes = ihrmMapper.findByUserId(id);
//		
//		if(userAuthes.size() == 0) {
//			throw new UsernameNotFoundException("User "+id+" Not Found!");
//		}
//		
//		return new HrmEmployeePrincipalVO(userAuthes); //UserDetails 클래스를 상속받은 UserPrincipalVO 리턴한다.
//	}
//	
//	@Override
//	public List<Map<String, Object>> SelectAllList() throws Exception {
//		// TODO Auto-generated method stub
//		return ihrmMapper.SelectAllList();
//	}
//	
//	@Override
//	public ArrayList<HrmEmployeeDTO> findByUserId(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public int findRoleNo(String roleName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	@Override
//	public int findUserNo(String id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	@Override
//	public int userRoleSave(int userNo, int roleNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	@Override
//	public int userSave(HrmEmployeeDTO userVO) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//
//}
