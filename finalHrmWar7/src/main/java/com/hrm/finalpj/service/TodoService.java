package com.hrm.finalpj.service;

import java.util.List;

import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


public interface TodoService {
	public List<CommunicationDTO> getList(Criteria criteria);
	public Integer getTotal();
}
