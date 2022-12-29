package com.hrm.finalpj.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.finalpj.dto.ScheduleDTO;
import com.hrm.finalpj.mapper.IScheduleMapper;

@Service
public class ScheduleServiceImp implements ScheduleService {
	
	@Autowired
	IScheduleMapper SchduleMapper;
	
	
	@Override
	public List<ScheduleDTO> UserList() {
		// TODO Auto-generated method stub
		return SchduleMapper.UserList();
	}
	
	
	public List<Integer> day(int year, int month) {
		 	List<Integer> cali = new ArrayList<>();
		    Calendar cal = Calendar.getInstance();

		    System.out.printf("\t\t%d년 %d월\n",year, month);
		    System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

		    cal.set(year, month - 1, 1);

		    int start = cal.get(Calendar.DAY_OF_WEEK);

		    for (int i = 1; i < start; i++) {
		      System.out.print("\t");
		    }

		    for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
		      System.out.printf("%d\t", i);
		      if(start % 7 == 0) {
		        System.out.println();
		      }
		      start++;
		      cali.add(i);
		    }
		    
		    return cali;
		  }

}