package com.example.spring.myapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.myapp.model.mapper.TestTableMapper;

@Service
public class TestTableServiceImpl implements TestTableService{

	@Autowired
	TestTableMapper testtableMapper;
	
	@Override
	public List<Map<String, Object>> SelectAllList() throws Exception {
		// TODO Auto-generated method stub
		return testtableMapper.SelectAllList();
	}

}
