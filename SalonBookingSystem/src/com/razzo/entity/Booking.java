package com.razzo.entity;

public class Booking {

	private int bookingId;
	private int userId;
	private int salonId;
	private int serviceId;
	private String bookingTime;

	public Booking() {
	}

	public Booking(int userId, int salonId, int serviceId, String bookingTime) {
		super();
		this.userId = userId;
		this.salonId = salonId;
		this.serviceId = serviceId;
		this.bookingTime = bookingTime;
	}
	public Booking(int bookingId, int userId, int salonId, int serviceId, String bookingTime) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.salonId = salonId;
		this.serviceId = serviceId;
		this.bookingTime = bookingTime;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSalonId() {
		return salonId;
	}

	public void setSalonId(int salonId) {
		this.salonId = salonId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", salonId=" + salonId + ", serviceId="
				+ serviceId + ", bookingTime=" + bookingTime + "]";
	}

}
