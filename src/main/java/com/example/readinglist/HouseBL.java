package com.example.readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "housebl")
public class HouseBL {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String hblno;
	private String bookingno;
	private String vvd;
	private Date eta;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getHblno() {
		return hblno;
	}
	public void setHblno(String hblno) {
		this.hblno = hblno;
	}
	public String getBookingno() {
		return bookingno;
	}
	public void setBookingno(String bookingno) {
		this.bookingno = bookingno;
	}
	public String getVvd() {
		return vvd;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	
}
