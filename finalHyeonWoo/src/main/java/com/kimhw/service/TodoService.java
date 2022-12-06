package com.kimhw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimhw.dto.CommunicationDTO;
import com.kimhw.dto.Criteria;
import com.kimhw.dto.PageDTO;

@Service
public interface TodoService {
	public List<CommunicationDTO> getList(Criteria criteria);
	public Integer getTotal();
}
