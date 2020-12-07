package com.exam.vo;

// VO(Value Object) : �����ͺ��̽� ���̺�� ������ �� ��ü  
// DTO(Data Tranfer Object) : �����ͺ��̽� ���̺�� ������ ������ ���ۿ뵵�� �� ��ü

public class PageDto {
	
	private String category; // �˻�����
	private String search; // �˻���
	private int count; // ��ü �� ����
	private int pageCount; // �� �ʿ��� ������(������ ��������ȣ)
	private int pageBlock; // ��������� �� ������ ����
	private int startPage; // ��������� �� ���������� ��ȣ
	private int endPage;   // ��������� �� �������� ��ȣ
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "PageDto [category=" + category + ", search=" + search + ", count=" + count + ", pageCount=" + pageCount
				+ ", pageBlock=" + pageBlock + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
}
