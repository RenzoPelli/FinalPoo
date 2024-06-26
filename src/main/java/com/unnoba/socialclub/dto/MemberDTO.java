package com.unnoba.socialclub.dto;

import java.util.Date;

public class MemberDTO {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String location;
	private String telephone;
	private String document_number;
	private Date bthday_date;
	private String accepted;
	private Date admission_date;
	private Boolean eliminado;


	public MemberDTO() {
		super();
	}
	public MemberDTO(String name, String surname, String address, String location, String telephone,
			String document_number, Date bthday_date, String accepted, Date admission_date, Boolean eliminado) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.location = location;
		this.telephone = telephone;
		this.document_number = document_number;
		this.bthday_date = bthday_date;
		this.accepted = accepted;
		this.admission_date = admission_date;
		this.eliminado = eliminado;
	}
	public MemberDTO(int id, String name, String surname, String address, String location, String telephone,
			String document_number, Date bthday_date, String accepted, Date admission_date, Boolean eliminado) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.location = location;
		this.telephone = telephone;
		this.document_number = document_number;
		this.bthday_date = bthday_date;
		this.accepted = accepted;
		this.admission_date = admission_date;
		this.eliminado = eliminado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDocument_number() {
		return document_number;
	}
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}
	public Date getBthday_date() {
		return bthday_date;
	}
	public void setBthday_date(Date bthday_date) {
		this.bthday_date = bthday_date;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public Date getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(Date admission_date) {
		this.admission_date = admission_date;
	}

	public Boolean getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
		
	
	
}
