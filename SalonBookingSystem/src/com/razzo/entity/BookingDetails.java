package com.razzo.entity;

public class BookingDetails {
	// booking id||salon name||user name||service name||price||time

	private int bookingId;
	private String userName;
	private String salonName;
	private String serviceName;
	private float price;
	private String time;

	public BookingDetails() {

	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", userName=" + userName + ", salonName=" + salonName
				+ ", serviceName=" + serviceName + ", price=" + price + ", time=" + time + "]";
	}

	public BookingDetails(int bookingId, String userName, String salonName, String serviceName, float price,
			String time) {
		this.bookingId = bookingId;
		this.userName = userName;
		this.salonName = salonName;
		this.serviceName = serviceName;
		this.price = price;
		this.time = time;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
