package com.example.spring.myapp.service;

import java.util.List;
import java.util.Map;

public interface TestTableService {
	
	//select * from Test_Table
	public List<Map<String, Object>> SelectAllList() throws Exception;
}
