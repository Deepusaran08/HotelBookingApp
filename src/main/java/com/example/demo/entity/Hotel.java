package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Hotel {
	
	@Id
	private String userId;
	private String bookingId;
    private String hotelName;
    private String checkInDate;
    private String checkOutDate;
    
	public Hotel() {
		super();
	}
	
	public Hotel(String userId, String bookingId, String hotelName, String checkInDate, String checkOutDate) {
		super();
		this.userId=userId;
		this.bookingId = bookingId;
		this.hotelName = hotelName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.userId = userId;
	}

	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Hotel [bookingId=" + bookingId + ", hotelName=" + hotelName + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", userId=" + userId +"]";
	}
    
}
