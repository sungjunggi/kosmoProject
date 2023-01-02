package com.hrm.finalpj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.report.dto.ReportDTO;


@Mapper
public interface IHrmMapper {

	//select * from employee
    public List<Map<String, Object>> SelectAllList() throws Exception;
    
    //select * from 
    
    public List<signDTO> SelectSignList(signDTO dto); 
    
    public List<signDTO> SelectSignList2(ReportDTO dto);
    
    public List<signDTO> SelectSignList3(signDTO dto);
    
    public signDTO SelectSignPage(int dto);
    
    public signDTO SelectDayoffPage(int dto);
    
    public signDTO SelectReportViewSign(int template_board_num);
    
    public void approveDAO(int sign_num); 
    
    public void denyDAO(int sign_num);
    
    public void approveDAO1(int dayoff_num); 
    
    public void denyDAO1(int dayoff_num);
    
    public void approveDAO2(int template_board_num); 
    
    public void denyDAO2(int template_board_num);
    
    public String numDAO(String name);
    
    public String resDAO(int res);
    
    public String numDAO1(String name1);
    
    public String resDAO1(int res1);

	public signDTO SelectReportViewSign1(String num);
	
	public ReportDTO viewDAO1(int num);  // 게시물 보기
	
	public String TestDAO();
	public String ReportDAO();
	public String DayoffDAO();
	public Object clickTestDAO1(String clickTestDAO);
	public Object clickReportDAO1(String clickReportDAO);
	public Object clickDayoffDAO1(String clickDayoffDAO);
	public List<signDTO> TestDAO(String TestDAO);
	public List<ReportDTO> ReportDAO(String ReportDAO);
	public List<signDTO> DayoffDAO(String DayoffDAO);

   
}
