package com.xrq.model;

public class OrderBean {
	private String orderItem;
	private String itemNum;
	private String orderId;
	private String ordMethod;
	private String orderPayment;
	private String date;
	
	public String getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	public String getItemNum() {
		return itemNum;
	}
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrdMethod() {
		return ordMethod;
	}
	public void setOrdMethod(String ordMethod) {
		this.ordMethod = ordMethod;
	}
	public String getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
