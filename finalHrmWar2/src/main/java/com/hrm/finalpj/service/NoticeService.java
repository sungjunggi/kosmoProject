package com.hrm.finalpj.service;

import java.util.List;

import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


public interface NoticeService {
	public List<CommunicationDTO> ngetList(Criteria criteria);
	public Integer ngetTotal();

}
