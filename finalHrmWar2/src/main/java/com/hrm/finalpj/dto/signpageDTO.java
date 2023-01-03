package com.hrm.finalpj.dto;

import java.util.List;

public class signpageDTO {

	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int pagingCount;
	private List<signDTO> content;
	
	
	public void signpaging(int total, int currentPage, int size, int pagingCount, List<signDTO> content) {
		
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		this.pagingCount = pagingCount;
		
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total/size;
			
			if(total % size > 0) {
				totalPages++;
			}
			startPage = currentPage / pagingCount * pagingCount+1;
			
			if(currentPage % pagingCount == 0) {
				startPage -= pagingCount;	
			}
			endPage = startPage + pagingCount-1;
			
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
		
	public int getTotal() {
		return this.total;
	}
	
	public boolean hasNoArticles() {
		return this.total == 0;
	}
	public boolean hasArticles() {
		return this.total > 0;
	}
	public int getCurrentPage() {
		return this.currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<signDTO> getContent(){
		return this.content;
	}
	
	public int getStartPage() {
		return this.startPage;
	}
	public int getEndPage() {
		return this.endPage;
	}
	
}
