package com.hrm.finalpj.service;

import java.util.List;
import java.util.Map;

public interface HrmTableService {
	//select * from Test_Table
	public List<Map<String, Object>> SelectAllList() throws Exception;
}
