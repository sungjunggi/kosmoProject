package com.hrm.finalpj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.finalpj.dao.ITodoDAO;
import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	ITodoDAO dao;
	
	public void write(HttpServletRequest req) {
		String tit = req.getParameter("title");
		String con = req.getParameter("content");
		String sta = req.getParameter("start");
		String end = req.getParameter("end");
		Map<String,String> map = new HashMap<String,String>();
		map.put("title", tit);
		map.put("content", con);
		map.put("start", sta);
		map.put("end", end);
		int res = dao.writeDAO(map);
	}
	
	public void delete(int communication_num) {
		dao.deleteBoardDAO(communication_num);
	}

	@Override
	public List<CommunicationDTO> getList(Criteria criteria) {
		
		return dao.getList(criteria);
	}

	@Override
	public Integer getTotal() {
		System.out.println();
		return dao.getTotal();
	}

	
	

	

	
	
}
