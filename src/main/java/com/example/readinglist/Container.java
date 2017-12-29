package com.example.readinglist;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Container {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	private String cntrno;
	private String sealno;
	private String type;
	private String size;
	//private HouseBL hbl;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCntrno() {
		return cntrno;
	}
	public void setCntr_no(String cntrno) {
		this.cntrno = cntrno;
	}
	public String getSealno() {
		return sealno;
	}
	public void setSealno(String sealno) {
		this.sealno = sealno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
