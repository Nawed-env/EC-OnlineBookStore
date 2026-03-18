package com.nareshit.model;

import java.util.List;

public class OrderModuleDto {

	
	private Long custmerId;
	private List<String> title;
	
	public Long getCustmerId() {
		return custmerId;
	}
	public void setCustmerId(Long custmerId) {
		this.custmerId = custmerId;
	}
	public List<String> getTitle() {
		return title;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	public OrderModuleDto(Long custmerId, List<String> title) {
		super();
		this.custmerId = custmerId;
		this.title = title;
	}
	public OrderModuleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderModuleDto [custmerId=" + custmerId + ", title=" + title + "]";
	}
	
	
	
}
