package com.example.readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private String bookingno;

	public String getBookingno() {
		return bookingno;
	}

	public void setBookingno(String bookingno) {
		this.bookingno = bookingno;
	}

}
