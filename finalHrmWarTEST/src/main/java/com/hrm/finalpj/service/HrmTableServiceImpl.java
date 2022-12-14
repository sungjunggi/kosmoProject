package com.hrm.finalpj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hrm.finalpj.mapper.IHrmMapper;

@Service
public class HrmTableServiceImpl implements HrmTableService{

	@Autowired
	IHrmMapper ihrmMapper;
	
	@Override
	public List<Map<String, Object>> SelectAllList() throws Exception {
		// TODO Auto-generated method stub
		return ihrmMapper.SelectAllList();
	}
}
