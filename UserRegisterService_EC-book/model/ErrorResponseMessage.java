package com.nareshit.model;

import java.util.List;
import java.util.Map;

public class ErrorResponseMessage {

	private Integer statusCode;
	private String status;
	private String message;
	private List<?>list;
	private Map<?,?>records;

	public Map<?, ?> getRecords() {
		return records;
	}
	public void setRecords(Map<?, ?> records) {
		this.records = records;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}


	@Override
	public String toString() {
		return "ErrorResponseMessage [statusCode=" + statusCode + ", status=" + status + ", message=" + message
				+ ", list=" + list + "]";
	}
	public ErrorResponseMessage(Integer statusCode, String status, String message, List<?> list) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.list = list;
	}

	public ErrorResponseMessage(Integer statusCode, String status, String message, Map<?,?> data) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.records=data;
	}





}
